<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*" %> 
<%@page import="org.almansa.app.core.post.*" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <% // c:forEach를 쓰기위함 %>    

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
			<td width="50%"> <a href="/post/detail/${post.getId()}">${post.getName()}</a> </td>
			<td>${post.getWriterInfomation().getWriterLoginId()}</td>
			<td> ${post.getCreationDate()} </td>
		
		<tr>
	</c:forEach>
	</tbody>
</table>

