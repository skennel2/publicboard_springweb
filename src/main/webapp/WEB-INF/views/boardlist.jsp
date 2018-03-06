<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*" %> 
<%@page import="org.almansa.app.core.board.Board" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <% // c:forEach를 쓰기위함 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${boards}" var="board">
    <tr>      
        <td>${board.getId()}</td>
        <td>${board.getName()}</td>
    </tr>
</c:forEach>

${count}

</body>
</html>