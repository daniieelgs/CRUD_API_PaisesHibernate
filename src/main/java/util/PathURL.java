package util;

import jakarta.servlet.http.HttpServletRequest;

public class PathURL {

	public static String[] RequestParamsResource(HttpServletRequest request) {		
		
		return request.getPathInfo() == null ? null : request.getPathInfo().substring(1).split("/");
	}
	
	public static String[] RequestParams(HttpServletRequest request) {		
		
		System.out.println(request.getPathInfo());
		
		return request.getPathInfo() != null && request.getPathInfo().contains("?") ? request.getPathInfo().split("?")[1].split("&") : null;
	}
	
	public static Integer TryParseInt(String str) {
		
		return str.matches("[0-9.]+") && str != null ? Integer.parseInt(str) : null;
		
	}
	
}
