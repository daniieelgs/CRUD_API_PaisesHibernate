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
		<c:when test="${data.size() == 0}">
			<h3 class="not-results">Sense resultats</h3>
		</c:when>
		<c:otherwise>
			<table class="table table-stripped country-table">
	            <thead>
	                <th>Nombre</th>
	                <th></th>
	            </thead>    
	
	            <tbody>
	
					<c:forEach items="${ data }" var = "country">
						<tr>
	                        <td><c:out value="${country.getCountry()}"/>  </td>
	                        <td class="button-actions-3">
	                            <button type="button" class="btn btn-outline-success country-link" data-link="/HibernateApp/Country/<c:out value="${country.getCountry_id()}"/>">Ver</button>
	                            <button type="button" class="btn btn-outline-warning country-link" data-link=<c:out value="/HibernateApp/Country/${country.getCountry_id()}/edit"/>>Editar</button>
	                            <button type="button" class="btn btn-outline-danger delete-country" data-countryId="<c:out value="${country.getCountry_id()}"/>" data-countryName="<c:out value="${country.getCountry()}"/>">Borrar</button>
	                        </td>
	                    </tr>
					</c:forEach>
	
	            </tbody>
        	</table>
			
		</c:otherwise>
	</c:choose>
	

	<%@include file="layouts/footer.jsp" %>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script src="/HibernateApp/js/countries.js"></script>

</body>
</html>