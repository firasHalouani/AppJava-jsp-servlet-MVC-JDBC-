<%@page import="metier.Operation"%>
<%@page import="metier.Produit"%>
<%@page import="java.util.Iterator"%>
<%@page import="web.ProduitBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des produits</title>
</head>
<body>
<%
	ProduitBeans produits;
	if(request.getAttribute("modele")!=null){
		 produits = (ProduitBeans)request.getAttribute("modele");
	}else{
		Operation o = new Operation();
		produits = new ProduitBeans(); //si le modele(BD) est vide en appel un constructeur sans parametre pour eviter l'erreur
		produits.setListe(o.getAll());
	}
	
%>

<h3>Tutoriel J2EE (jsp , servlet , MVC et JDBC)</h3>
<h5>Ajouter un nouveau produit</h5>
<form action="prodserv" method="post">
	<table border="1" width="30%">
		<tr>
			<td>Nom</td>
			<td><input type="text" name="nom" /></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><input type="text" name="desc" /></td>
		</tr>
		<tr>
			<td>Prix</td>
			<td><input type="text" name="prix" /></td>
		</tr>
		<tr>
			<td>Etat</td>
			<td><input type="text" name="etat" /></td>
		</tr>
			<tr>
			<td colspan="2" ><input type="submit" value="Valider"/> </td>
		</tr>
	</table>
</form>
<br>
<table border="1" width="60%">
	<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Description</th>
		<th>Prix</th>
		<th>Etat</th>
		<th>Option</th>
	</tr>
	<%
		Iterator<Produit> list = produits.getListe().iterator();
		while(list.hasNext()){
			Produit p = list.next();
	%>
		<tr>
			<td><%=p.getId() %></td>
			<td><%=p.getNom() %></td>
			<td><%=p.getDesc() %></td>
			<td><%=p.getPrix() %></td>
			<td><%=p.getEtat() %></td>
			<td>
				<form action="prodserv" method="post">
					<input type="hidden" name="id" value="<%=p.getId() %>" />
					<input type="hidden" name="action" value="supprimer" />
					<input type="submit" value="supprimer" />
				</form>
			</td>
		</tr>
	<%
		} 
	%>	
</table>



</body>
</html>