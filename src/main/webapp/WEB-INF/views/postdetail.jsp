<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.almansa.app.core.entity.post.*" %>   
<%@page import="org.almansa.app.core.entity.comment.*" %>
<%@page import="org.almansa.web.dto.*" %>     
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <!--c:forEach를 쓰기위함 -->

<div class="card">
    <div class="card-header">
    	<h4 class="card-title">
    	<span class="text-info">${post.getId()}. ${post.getName()} by</span>  
    	<a href="#">${post.getWriterId()}</a></h4>
    </div>
    
    <div>조회수 : ${post.getClickCount()}</div>
    
	<div class="card-body">
		<p class="card-text">${post.getContents()}</p>
	</div> 
	
	<br>
	
	<div id="comments_list"></div>
		
	<div id="comment_write">
	   <div>
	       <input type="hidden" id="postId" name="postId" value="${post.getId()}">
	       <textarea 
	           id= "input-comment"
	           rows="2" 
	           class="form-control span6" 
	           name="contents" 
	           aria-describedby="basic-addon3" 
	           required>
	       </textarea>
	       <div class="text-center">
	           <button id="btn-comment" class="btn btn-primary">댓글달기</button>
	       </div>
	   </div>
	</div>	
	
	<div class="card-footer">
		<a href="/post/list" class="btn btn-primary">뒤로</a>
		<a href="/post/list" class="btn btn-primary">수정</a>
		<a href="/post/delete/${post.getId()}" class="btn btn-danger">삭제</a>
	</div>
	
</div>

<script>

	
	function loadComment(){
		$.getJSON("/rest/comment/bypost/" + $('#postId').val(), function(data){
			console.log(data);
			
			var commentListHtml = '';
			$(data).each(function(item){
				commentListHtml += "<div class='list-group-item list-group-item-action'>"
				                +  "<div class='text-info' style='width:30%''>" + this.writerMemberName + "</div>"
				                +  "<div>" + this.contents +"</div>"
				                +  "</div>"
			});
			
			$("#comments_list").html(commentListHtml);
		});
	}
	
	$('#btn-comment').click(function(){
		
		var commentValue = $('#input-comment').val();
		
		$.ajax({
			method : 'POST',
			contentType: 'application/json',
			url : '/rest/comment/write',
			data : JSON.stringify({
				postId : $('#postId').val(),
				writerMemberId : 1,
				contents : commentValue,
				writeDate : new Date()
			}),
			success : function(result){
				$('#input-comment').val('')
				loadComment();
			}
		});
	})
	
	loadComment();
	
	
</script>