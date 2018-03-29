<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.almansa.app.core.entity.post.*" %>     
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <!--c:forEach를 쓰기위함 -->

<div class="card">
    <div class="card-header">
    	<h4 class="card-title"><span class="text-info">${post.getId()}. ${post.getName()} by</span>  <a href="#">${post.getWriterInfomation().getMemberLoginId()}</a></h4>
    </div>
    <div>조회수 : ${post.getClickCount()}</div>
	<div class="card-body">
		<p class="card-text">${post.getContents()}</p>
		
	</div> 
	<div class="card-footer">
		<a href="/post/list" class="btn btn-primary">뒤로</a>
		<a href="/post/list" class="btn btn-primary">수정</a>
		<a href="/post/delete/${post.getId()}" class="btn btn-danger">삭제</a>
	</div>
</div>

<script>
</script>