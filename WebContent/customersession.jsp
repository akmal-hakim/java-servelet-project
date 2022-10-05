<%
	int customer_id = (Integer) session.getAttribute("currentSessionUserid");
	String customer_email = (String) session.getAttribute("currentSessionUser");
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
	
	if(session.getAttribute("currentSessionUserid") == null){
		response.sendRedirect("customerLogin.jsp");
	}
%>