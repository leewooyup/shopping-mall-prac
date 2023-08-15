package web.dispatcher;

//웹페이지의 내비게이션 경로를 정의하는 클래스(사용자의 위치를 파악, 원하는 페이지로 이동하는 경로)
public class Navi {
	public static String home = "<a href='main.bank'>HOME</a>";
	public static String register =  home + " > register";
	public static String login = home + " > login";
	
	public static String custRegister = home + " > cust > register";
	public static String custGet = home + " > cust > get";
}