package webprj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String id= (String)session.getAttribute("id");
		if(id == null) {
			saveBeforeUri(request);
			response.sendRedirect("/football/login");
			return false;
		}else {
			return true;
		}
	}
	
	public void saveBeforeUri(HttpServletRequest request) {
		String uri=request.getRequestURI();
		String query=request.getQueryString();
		if(query == null || query.trim().equals("null")) {
			query = "";
		}else {
			query="?"+query;
		}
		
		if(request.getMethod().equals("GET")) {
			request.getSession().setAttribute("uri", uri+query);
		}
	}
	
}
