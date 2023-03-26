<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>See all countries</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link href="/HibernateApp/css/styles.css" rel="stylesheet">
</head>
<body>

	<%@include file="layouts/header.jsp" %>

	<%@include file="layouts/ModalDelete.jsp" %>


	<c:choose>
		<c:when test="${data == null}">
			<h3 class="not-results">Sense resultats</h3>
		</c:when>
		<c:otherwise>
			<table class="table table-stripped country-table">
	            <thead>
	                <th>Id</th>	            
	                <th>Nombre</th>
	                <th></th>
	            </thead>    
	
	            <tbody>
	
					<tr>
                        <td><c:out value="${data.getCountry_id()}"/>  </td>					
                        <td><c:out value="${data.getCountry()}"/>  </td>
                        <td class="button-actions-3">
	                        <button type="button" class="btn btn-outline-warning country-link" data-link=<c:out value="/HibernateApp/Country/${data.getCountry_id()}/edit"/>>Editar</button>
                            <button type="button" class="btn btn-outline-danger delete-country" data-countryId="<c:out value="${data.getCountry_id()}"/>" data-countryName="<c:out value="${data.getCountry()}"/>">Borrar</button>
                        </td>
                    </tr>
	
	            </tbody>
        	</table>
			
		</c:otherwise>
	</c:choose>
	

	<%@include file="layouts/footer.jsp" %>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script src="/HibernateApp/js/countries.js"></script>

</body>
</html>