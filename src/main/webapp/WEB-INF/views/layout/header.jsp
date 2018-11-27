<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="org.almansa.app.core.service.dto.*"  %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<% 
    String user = "";
	boolean isLoginUser = false;
	
    LoginMemberSessionModel model = (LoginMemberSessionModel)session.getAttribute("loginuser");
    if(model != null){
        user = model.getLoginId();
        isLoginUser = true;
    }else{
    	isLoginUser = false;
    }

%>   
<%=user %> 
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/post/list">리스트 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/post/write">글쓰기</a>
      </li>
      <li class="nav-item">
      	<c:if test="${isLoginUser == true}">
        	<a class="nav-link" href="/member/login">로그인</a>
        </c:if>
        <c:if test="${isLoginUser == false}">
        	<a class="nav-link" href="/member/logout">로그아웃</a>
        </c:if>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/member/join">회원가입</a>
      </li>           
    </ul>
  </div>
</nav>