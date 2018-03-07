<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*" %> 
<%@page import="org.almansa.app.core.post.*" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <% // c:forEach를 쓰기위함 %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="container">
	<table class="table">
	    <thead>
	      <tr>
	        <th>No</th>
	        <th>Subject</th>
	        <th>Writer</th>
	        <th>Date</th>
	      </tr>
	    </thead>	
		<tbody>
		<c:forEach items="${list}" var="post">
			<tr>
				<td> ${post.getId()} </td>
				<td width="50%"> <a href="/post/write">${post.getName()}</a> </td>
				<td>${post.getWriterInfomation().getWriterLoginId()}</td>
				<td> ${post.getCreationDate()} </td>
			
			<tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>