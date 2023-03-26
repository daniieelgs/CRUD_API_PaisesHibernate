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

    <div class="card text-center formCardCenter">
        <div class="card-header">
            Crear País
        </div>
        <div class="card-body">

            
            <form class="row g-3 needs-own-validation" novalidate id="form" action="/HibernateApp/Country/create" method="POST">
                

                <div class="col-12 form-floating">
                    <input type="text" class="form-control <c:if test="${errors.containsKey('name')}"> is-invalid </c:if>" id="name" name="name" placeholder=" " value="<c:out value="${ values.get('name') }"/>" required>
                    <label for="nom">Nom</label>
                    <div class="invalid-feedback">
                            <c:out value="${ errors.get('name') }"/>
                    </div>
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary" id="btnSubmit">Crear</button>
                </div>
            </form>      
            
        </div>
    </div>
	

	<%@include file="layouts/footer.jsp" %>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script src="/HibernateApp/js/countries.js"></script>
	<script src="/HibernateApp/js/validateForm.js"></script>

</body>
</html>