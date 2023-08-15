package web.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet({ "/DispatcherServlet", "/dispatcher", "*.bit"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger work_log = Logger.getLogger("work"); 

	public DispatcherServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		String path = uri.substring(uri.lastIndexOf("/"));
		work_log.debug(path);
		path = path.substring(1, path.lastIndexOf("."));
		work_log.debug(path);
		
		//주어진 path가 없으면 메인으로 이동
		String next = "main.jsp";
		if(path != null) {
			next = path; //주어진 path가 있으면 그 path로 이동		
		}
		//기존의 request, response를 유지하면서 페이지를 이용하는 방법(정보유지)
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
		
	}

}





