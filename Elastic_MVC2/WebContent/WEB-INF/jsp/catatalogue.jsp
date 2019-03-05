
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<!-- initialisation de la jstl via la taglib -->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!-- on peut maintenant utiliser les tags de la jstl -->

<!-- gestion des imports -->
<%@page import="bean.Client" %>
<%@page import="bean.BlocFiltre" %>
<%@page import="java.util.List" %>
<%@page import="bean.LigneFiltre" %>
<%@page import="service.MakingFiltre" %>
<%@page import="bean.Filtre" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>le catatalogue</title>
	<link rel="stylesheet" type="text/css" href="../../style/style.css">
</head>
<body>
	<h1>Bienvenue à toi oh ${sessionScope.user.user}</h1>
	
	<p>veuillez cliquer sur les petites cases à cocher pour pouvoir afficher 
	les elastiques que vous voulez ( en fait ce sont des filtres)
	</p>
	
	<p>je recupere les filtres de ma base de donnée dans une arrayList</p><br/>
	<p>j'affiche</p><br/>
	<%for (Filtre f : MakingFiltre.init(2)){%>
	<p><%=f.getLabel() %><br/>
	<%}  %>

	
	<!-- todo : mettre dans form et recuperer choix checked -->
	<form method="post" action="frontControleur?cmd=Search">
	<table>
    	<thead>
            <tr >colonne1</tr>
            <tr >colonne2</tr>
            <tr >colonne3</tr>
     
    	</thead>
    	<tbody>
        	<tr>
            	<td>The table body</td>
            	<td>with two columns</td>
            	<td>with two columns</td>
        	</tr>
    	</tbody>
	</table>
	<input value ="rechercher" type='submit' name='buttonSub'>
	</form>	

</body>
</html>