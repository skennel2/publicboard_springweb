<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*" %> 
<%@page import="org.almansa.app.core.post.*" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <% // c:forEach를 쓰기위함 %>    

<table class="table border">
    <thead class="text-info">
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
			<td>${post.getCreationDate()} </td>
		
		<tr>
	</c:forEach>
	</tbody>
	<tfoot class="text-info">
		<tr>
        	<th></th>
        	<th></th>
        	<th></th>
        	<th></th>
      	</tr>
    </tfoot>
</table>

<script>
    var msg = '${msg}';
    
    if(msg == 'SUCCESS'){
    	alert("처리가 완료되었습니다");
    }
</script>

