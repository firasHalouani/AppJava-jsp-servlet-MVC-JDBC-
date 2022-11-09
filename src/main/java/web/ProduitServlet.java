package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Operation;
import metier.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	/*
	private Operation op ;
	@Override
	public void init() throws ServletException {
			op = new Operation();
	}
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Operation op = new Operation();
		if(req.getParameter("action")!=null) {
			op.remove(Long.parseLong(req.getParameter("id")));
			System.out.println("action = supprimer");
		}else {		
			//récuperation des informations(données)
			String nom  = req.getParameter("nom") ;
			String desc = req.getParameter("desc") ;
			String prix = req.getParameter("prix") ;
			String etat = req.getParameter("etat") ;
			//creation des objects
			Produit p = new Produit(1L,nom,desc,Integer.parseInt(prix),Integer.parseInt(etat));
			//traitement
			op.add(p);//ajouter les données dans la list
					
		}
		ProduitBeans pb = new ProduitBeans(); //c'est le modele où on va stocker les informations(données) récuperer 
		pb.setListe(op.getAll());//recuperer les données qui se trouvent dans la list
		req.setAttribute("modele", pb);//stocker les données dans le modele
		//envoyer les données vers la page jsp
		req.getRequestDispatcher("Produit.jsp").forward(req, resp);
		
		
		
		
		
		
		//afficher les informations(données)
		/*
		PrintWriter pr = resp.getWriter();
		pr.println("<html><head><title>ProduitServlet</title></head><body>");
		pr.println(nom +" - "+desc+" - "+prix+" - "+etat+" . ");
		pr.println("</body></html>");
	    */

		
		
	}

}
