package Controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Country;
import Model.CountryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.PathURL;


/**
 * Servlet implementation class Api
 */
@WebServlet("/Api/Country/*")
public class Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private CountryDAO dao;
	
    public Api() {
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
		
		if(id == null) {
			
			List<Country> countries = dao.getCountries();
			
			if(countries.size() == 0) {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		        response.getWriter().append("{}");

			}else {
				JSONArray responseJSON = new JSONArray(countries);	
		        response.getWriter().append(responseJSON.toString());
			}

		}else {
						
			Country country = dao.getCountry(id);
			
			if(country != null) {
				JSONObject responseJSON = new JSONObject(country);
		        response.getWriter().append(responseJSON.toString());
			}else {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		        response.getWriter().append("{}");
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String data = request.getReader().lines().collect(Collectors.joining());
        JSONObject countryJSON = new JSONObject(data);
		
        String countryName = countryJSON.getString("country");
        
		Country c = new Country();
		
		c.setCountry(countryName);
		
		dao.savePais(c);
		
		JSONObject responseJSON = new JSONObject(c);
		response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().append(responseJSON.toString());
		
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getReader().lines().collect(Collectors.joining());
        JSONObject countryJSON = new JSONObject(data);
        
        String countryName = countryJSON.getString("country");
        Integer id = countryJSON.getInt("country_id");

		Country c = dao.getCountry(id);
		
		if(c == null) {
	        response.getWriter().append("{}");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	        return;
		}
        
		
		c.setCountry(countryName);
		
		dao.savePais(c);
		
		JSONObject responseJSON = new JSONObject(c);
        response.getWriter().append(responseJSON.toString());
	
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] paramsResource = PathURL.RequestParamsResource(request);
		
		Integer id = paramsResource == null ? null : PathURL.TryParseInt(paramsResource[0]);
 
		if(id == null) {
	        response.getWriter().append("{}");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        return;
		}
		
		Country c = dao.getCountry(id);
		
		if(c == null) {
	        response.getWriter().append("{}");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	        return;
		}
	
		dao.deletePais(c);
		
		JSONObject responseJSON = new JSONObject(c);
        response.getWriter().append(responseJSON.toString());
	}
	
	

}
