<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.your.time.bean.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%
List<User> users = (List<User>) request.getAttribute( "users" );
%>
<%
for (User user : users) {
pageContext.setAttribute("firstname", user.getFirstname() );
%>
<div><%=user.getFirstname() %></div>
<div><%=user.getLastname() %></div>
<div><%=user.getAddressline1() %></div>
<div><%=user.getAddressline2() %></div>
<div><%=user.getPassword() %></div>
<div><%=user.getZip() %></div>
<%
}
%>
</body>
</html>