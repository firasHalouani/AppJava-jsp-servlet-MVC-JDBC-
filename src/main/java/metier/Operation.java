package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Operation {
//creation d'un tableau pour stocker les produits
	private ArrayList<Produit> produits = new ArrayList<Produit>();

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	//ajouter un produit :
	public void add(Produit p) {
		try {
			//1
			Class.forName("com.mysql.jdbc.Driver");
			//2
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionProduit","root","");
			//3
			PreparedStatement pr = cn.prepareStatement("INSERT INTO produit VALUES(NULL,?,?,?,?)");
			pr.setString(1, p.getNom());
			pr.setString(2, p.getDesc());
			pr.setInt(3, p.getPrix());
			pr.setInt(4, p.getEtat());
			//4
			pr.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//produits.add(p);
	}
	//supprimer un produit par son id :
	public void remove(Long id) {
		try {
			//1
			Class.forName("com.mysql.jdbc.Driver");
			//2
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionProduit","root","");
			//3
			PreparedStatement pr = cn.prepareStatement("DELETE FROM produit WHERE id = ?");
			pr.setLong(1, id);
			//4
			pr.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*for(Produit p:produits) {
			if(p.getId() == id) {
				produits.remove(p);
				break;
			}
		}*/
	}
	//afficher la list des produits:
	public ArrayList getAll() {
		ArrayList listProduit = new ArrayList<Produit>();
		try {
			//1
			Class.forName("com.mysql.jdbc.Driver");
			//2
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionProduit","root","");
			//3
			PreparedStatement pr = cn.prepareStatement("SELECT * FROM produit");
			//4
			ResultSet rs = pr.executeQuery();
			//5
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("id"));
				p.setNom(rs.getString("nom"));
				p.setDesc(rs.getString("descr"));
				p.setPrix(rs.getInt("prix"));
				p.setEtat(rs.getInt("etat"));
				listProduit.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return listProduit;
	}
	
}
