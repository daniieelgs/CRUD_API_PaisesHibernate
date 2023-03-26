package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Country;
import Model.CountryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.PathURL;

/**
 * Servlet implementation class CountryController
 */

@WebServlet("/Country/*")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CountryDAO dao;
	
	private final String paramName = "name", 
						emptyErrorMessage = "Campo obligatorio.";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryController() {
        super();
        dao = new CountryDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String[] paramsResource = PathURL.RequestParamsResource(request);
		
		Integer id = paramsResource == null ? null : PathURL.TryParseInt(paramsResource[0]);
		
		if(paramsResource != null && paramsResource[0].equalsIgnoreCase("create")) {
			
			request.getRequestDispatcher("/CreateCountry.jsp").forward(request, response);	
			
		}else if(id == null) {
						
			List<Country> countries = dao.getCountries();
									
	        if(request.getParameter("s") != null) {
	        	request.setAttribute("search", request.getParameter("s").trim());
	        	countries = countries.stream().filter(n -> n.getCountry().toLowerCase().contains(request.getParameter("s").toLowerCase().trim())).toList();
	        }
	        
	        if(request.getParameter("o") != null) {
	        	request.setAttribute("order", request.getParameter("o"));
	        	countries = (request.getParameter("o").equalsIgnoreCase("id") ? countries.stream().sorted((n, m) -> n.getCountry_id() - m.getCountry_id()) : countries.stream().sorted((n, m) -> n.getCountry().compareTo(m.getCountry()))).toList();
	        }

	        if(request.getParameter("orderDesc") != null) {
	        	request.setAttribute("orderDesc", true);
	        	List<Country> reversed = new ArrayList<>(countries);
	        	Collections.reverse(reversed);
	        	countries = reversed;
	        }else {
	        	request.setAttribute("orderDesc", false);
	        }
			
			request.setAttribute("data", countries);
			request.getRequestDispatcher("/SeeAllContries.jsp").forward(request, response);
			
		}else {
					
			request.setAttribute("data", dao.getCountry(id));
						
			if(paramsResource.length >= 2 && paramsResource[1].equalsIgnoreCase("edit")) {
				Map<String, String> errors = new HashMap<>();
				Map<String, String> values = new HashMap<>();
				
				request.setAttribute("errors", errors);
				request.setAttribute("values", values);
				
				request.getRequestDispatcher("/EditCountry.jsp").forward(request, response);	
			}
			else request.getRequestDispatcher("/SeeCountry.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] paramsResource = PathURL.RequestParamsResource(request);
		
		Integer id = paramsResource == null ? null : PathURL.TryParseInt(paramsResource[0]);
		
		if(id == null) {
			
			Country country = new Country();
			
			updateOrCreate(country, "/CreateCountry.jsp", request, response);
			
		}else {
					
			Country country = dao.getCountry(id);
			
			switch (paramsResource[1]) {
			case "edit":
				
				updateOrCreate(country, "/EditCountry.jsp", request, response);
				
				break;

			case "delete":
//				
//				String search = request.getParameter("s");
//				String order = request.getParameter("order");
//				boolean orderDesc = request.getParameter("orderDesc") != null;
				
				dao.deletePais(country);
				
				response.sendRedirect("/HibernateApp/Country");
//				response.sendRedirect(String.format("/HibernateApp/Country?s=%s&o=%s%s", search != null ? search : "", order != null ? order : "", orderDesc ? "&orderDesc=on" : ""));
								
				break;
			}
			
		}
		
	}
	
	private void updateOrCreate(Country country, String form, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> errors = new HashMap<>();
		Map<String, String> values = new HashMap<>();
		
		values.put(paramName, request.getParameter(paramName));
		
		if(values.get(paramName).trim().length() == 0) {
			
			request.setAttribute("data", country);
			
			errors.put(paramName, emptyErrorMessage);
			
			request.setAttribute("errors", errors);
			request.setAttribute("values", values);
			request.getRequestDispatcher(form).forward(request, response);
		}else {
			
			country.setCountry(values.get(paramName));
			
			dao.savePais(country);
			
			response.sendRedirect("/HibernateApp/Country/" + country.getCountry_id());
			
		}
		
	}

}
