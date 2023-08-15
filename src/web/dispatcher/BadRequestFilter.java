package web.dispatcher;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebFilter(urlPatterns = "/*")
public class BadRequestFilter implements Filter{
	private Logger work_log = Logger.getLogger("work"); 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter init call");
	}


	@Override
	public void destroy() {
		System.out.println("Filter destroy call");
	}

	// 인코딩 처리 및 경로 지정
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//클라이언트가 전송한 데이터를 UTF-8로 인코딩하도록 서버에게 지시
		request.setCharacterEncoding("UTF-8");
		//HttpServletRequst의 내장메서드 getRequestURI()를 통한 URI 정보 가져오기
		String uri = ((HttpServletRequest)request).getRequestURI();
		work_log.debug("doFilter----"+uri);

		// URI 맨 뒤의 '/'부터 끝까지 자르기
		String path = uri.substring(uri.lastIndexOf("/"));
		work_log.debug("doFilter----"+path);
		if(path.equals("/")) {
			//새로운 request, response를 생성하여 이동(정보손실)
			((HttpServletResponse)response).sendRedirect("main.bit");
			return;
		}

		chain.doFilter(request, response);
		 	
	}
}