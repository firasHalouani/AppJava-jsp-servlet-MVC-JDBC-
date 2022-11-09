package metier;

import java.util.Iterator;

public class TestMetier {
	public static void main(String[] args) {
		Operation op = new Operation(); // contollerClass = couche traitement = couche metier
		Produit p = new Produit();
		
		op.add(new Produit(1L,"PC","Pc portable",8000,1)); // on utilise L car l'ID est de type Long
		op.add(new Produit(2L,"Clavier","clavier hp",70,1));
		op.add(new Produit(3L,"Souris","souris dell",100,0));
		op.add(new Produit(4L,"H-P","HP C100",300,1));

		//supprimer un produit
		op.remove(2L);
		//afficher les listes des produits :
		Iterator<Produit> prds = op.getAll().iterator(); //stocker tous les listes dans une collection(iterator) nommée prds
		while(prds.hasNext()) {
			Produit pr = prds.next();
			pr.show();
		}
		
		
	}
}
