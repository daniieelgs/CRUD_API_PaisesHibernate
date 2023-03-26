    <nav class="navbar navbar-expand navbar-dark bg-dark" aria-label="Second navbar example">
        <div class="container-fluid">
          <a class="navbar-brand" href="/HibernateApp/Country">Inicio</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
    
          <div class="collapse navbar-collapse" id="navbarsExample02">
            <ul class="navbar-nav me-auto">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/HibernateApp/Country">Paises</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/HibernateApp/Country/create">Crear</a>
              </li>
            </ul>
            <form role="search" class="form-search" action=/HibernateApp/Country>
            
            	<div class="orderType">
            		
            		<figure class="order">
            			<img src="/HibernateApp/images/icons/arrow-up.png" alt="ascending/descending" class="arrowImage <c:if test="${orderDesc}">desc</c:if>">
            			<figcaption class="typeText">
							<c:choose>  
							    <c:when test="${orderDesc}">  
							       Desc
							    </c:when>  
							    <c:otherwise>   
							       Asc
							   	</c:otherwise>  
							</c:choose>            				
            			</figcaption>
            		</figure>
            		
            		<input type="checkbox" id="checkDescending" name="orderDesc" <c:if test="${orderDesc}">checked</c:if>>
            		
            	</div>
            
			  <select class="form-control" id="orderBy" name="o" data-valueSelected="<c:out value="${order}" />">
			  	<option value="id">Fecha de creación</option>
			  	<option value="alpha">Alfabético</option>	  	
			  </select>            
              <input class="form-control" type="search" placeholder="Search" id="searchInput" name="s" aria-label="Search" value = "<c:out value="${search}" />">

              <button type="submit" class="btn btn-primary">Buscar</button>
            </form> 
          </div>
        </div>

      </nav>
      
      <script>
	      const selectOrder = document.getElementById('orderBy');
	      Array.from(selectOrder.children).forEach(n => n.selected = n.value == selectOrder.dataset.valueselected);
      
	  	  document.querySelector('form.form-search .orderType figure.order').addEventListener('click', e => {
	  		
	  		  const figure = e.target.parentElement;
	  		  
	  		  console.log(figure);
	  		  console.log(figure.querySelector('img.arrowImage'));
	  			  
	  		  let desc = figure.querySelector('img.arrowImage').classList.toggle('desc');
	  		  
	  		  figure.querySelector('figcaption.typeText').innerText = desc ? 'Desc' : "Asc";
	  		  
	  		  figure.parentElement.querySelector('#checkDescending').checked = desc;
	  		  
	  	  });  
	  </script>