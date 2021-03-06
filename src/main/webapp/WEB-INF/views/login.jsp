<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <% // c:forEach를 쓰기위함 %>  

<% 
	String needLogin = request.getParameter("needLogin");

	String message = "";
	if(needLogin != null && needLogin.equals("true")){
		message = "로그인이 필요합니다";
	}

%>

<%=message%>

<form action="/member/login" name="memberlogin" method="post" >
    <div class= "card">
        <div class="card-body">
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">아이디</span>
              </div>
              <input type="text" class="form-control" name="loginId" aria-describedby="basic-addon3" required>
            </div>  
            
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">패스워드</span>
              </div>
              <input type="password" class="form-control" name="password" aria-describedby="basic-addon3" required>   
            </div>          
        </div>
        <div class="card-footer">
            <input type="hidden" name="boardId" value ="1"/> 
            <input type="hidden" name="writerId" value ="1"/>   
            <input type="submit" id="submit" value="로그인" class="btn btn-default"/>
        </div>
    </div>
    
	<c:forEach items="${LoginFailMessages}" var="msg">
		<div class="text-danger"> ${msg} </div>		
	</c:forEach>    
    
</form>