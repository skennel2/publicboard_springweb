<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <% // c:forEach를 쓰기위함 %>  

<form action="/member/join" name="memberJoin" method="post" >
    <div class=card>
        <div class="card-body">
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">아이디</span>
              </div>
              <input type="text" class="form-control" id="loginId" name="loginId" aria-describedby="basic-addon3" required>
            </div>  
            
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">패스워드</span>
              </div>
              <input type="password" class="form-control" id="password" name="password" aria-describedby="basic-addon3" required>   
            </div>   
            
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">패스워드</span>
              </div>
              <input type="password" class="form-control" id="passwordCheck" name="passwordCheck" aria-describedby="basic-addon3" required>   
            </div>                             
        </div>
        <div class="card-footer">
            <input type="submit" id="submit" value="가입" class="btn btn-default"/>
        </div>
    </div>
    
	<c:forEach items="${JoinFailMessages}" var="msg">
		<div class="text-danger"> ${msg} </div>		
	</c:forEach>    
    
</form>

<script>
$( document ).ready(function() {
	var page = this;
	
	var constValues = {
		idMinimumLength : 10,
		idMaximumLength : 20,
		isIdOK : function(id){
			return (id.length > this.idMinimumLength && id.length < this.idMaximumLength);
		}
	};
	
	$('#submit').click(onClickSubmit);
	
	function onClickSubmit(e){
		var loginId = $('#loginId');
		var password = $('#password');
		var passwordCheck = $('#passwordCheck');
		
		//if(loginId.val().length < 10){
		if(constValues.isIdOK(loginId.val())){
			alert('아이디는 최소 10자이상으로 등록해주세요');
			e.preventDefault();	
			loginId.focus();
			return;
		}
		
		if(password.val().length < 8){
			alert('패스워드는 최소 8자이상으로 등록해주세요');
			e.preventDefault();
			password.focus();
			return;
		}
		
		if(passwordCheck.val().length < 10){
			alert('패스워드는 최소 8자이상으로 등록해주세요');
			e.preventDefault();
			passwordCheck.focus();
			return;
		}
		
		if(passwordCheck.val().length < 10){
			alert('패스워드는 최소 8자이상으로 등록해주세요');
			e.preventDefault();
			passwordCheck.focus();
			return;
		}
		
		if(password.val() !== passwordCheck.val()){
			alert('패스워드를 확인해 주세요');
			e.preventDefault();
			passwordCheck.focus();
			return;
		}
	}
});
</script>