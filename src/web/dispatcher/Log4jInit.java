package web.dispatcher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@WebServlet("/Log4jInit")
public class Log4jInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//work 작업 영역의 로그를 관리하는 Logger객체 생성
	private Logger work_log = Logger.getLogger("work"); 
	
	public void init(ServletConfig config) throws ServletException {
	 //루트 경로에 해당하는 실제 파일 시스템 경로 가져오기
	 String prefix =  config.getServletContext().getRealPath("/");
	 //지정된 이름의(log4j-init-file) 설정된 초기화 매개변수 값 가져오기
     String file = config.getInitParameter("log4j-init-file");
  
     if(file != null){
    	 //지정된 .properties 파일을 로드하여, 설정정보 가져오기
    	 PropertyConfigurator.configure(prefix+file);
    	 //로깅 레벨 (DEBUG, INFO, WARN, ERROR, FATAL)에 따른 로그 메시지 작성
    	 work_log.debug("Log4J Logging started: " + prefix+file);
     }
     else{
    	 // if the log4j-init-file context parameter is not set, then no point in trying
    	 work_log.debug("Log4J Is not configured for your Application: " + prefix + file);
     }     
	}

}