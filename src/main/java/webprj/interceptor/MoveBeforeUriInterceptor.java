package webprj.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MoveBeforeUriInterceptor extends HandlerInterceptorAdapter{
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("id")!= null) {
//			String uri =(String) session.getAttribute("uri");
//			response.sendRedirect(uri != null ? uri : "/football/main" );		}
//	}
	
}
