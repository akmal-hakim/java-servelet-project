<%
	int admin_id = (Integer) session.getAttribute("admin_id");
	String admin_name = (String) session.getAttribute("admin_name");
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
	
	if(session.getAttribute("admin_id") == null){
		response.sendRedirect("adminLogin.jsp");
	}
%>