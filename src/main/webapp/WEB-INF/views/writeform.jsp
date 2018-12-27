<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <% // c:forEach를 쓰기위함 %>  

<form action="/post/write" name="postwrite" method="post" >
	<div class=card>
		<div class="card-body">
			<div class="input-group">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="basic-addon3">제목</span>
			  </div>
			  <input type="text" 
			         class="form-control" 
			         id="subject" 
			         name="name" 
			         aria-describedby="basic-addon3" 
			         required>
			</div>	
			
			<div class="input-group">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="basic-addon3">내용</span>
			  </div>
			  <textarea rows="6" 
			            class="form-control span6" 
			            id="contents" 
			            name="contents" 
			            aria-describedby="basic-addon3" 
			            required></textarea>
			</div>			
		</div>
		<div class="card-footer">
			<input type="hidden" name="boardId" value ="1"/>
			<input type="submit" id="submit" value="등록" class="btn btn-default"/>
		</div>
	</div>
</form>

<script>
	$( document ).ready(function() {
		
		var constValues = {
			subjectMinimumLength : 10,
			subjectMaxLength : 100,
			contentsMinimumLength : 10
		};
		
		$('#submit').click(onSubmit);
		
		function onSubmit(e){
			var subject = $('#subject').val();
			
			if(subject.trim().length <= constValues.subjectMinimumLength){
				alert('제목은 최소 '+ constValues.subjectMinimumLength +'글자 이상으로 작성해주세요');
				e.preventDefault();
				$('#subject').focus();
				return;
			}
			
			if(subject.trim().length >= constValues.subjectMaxLength){
				alert('제목은 최소 '+ constValues.subjectMaxLength +'글자 이하로 작성해주세요');
				e.preventDefault();
				$('#subject').focus();
				return;
			}
			
			var contents = $('#contents').val();
			
			if(contents.trim().length <= constValues.contentsMinimumLength){
				alert('내용은 최소 ' + constValues.contentsMinimumLength + '글자 이상으로 작성해주세요');
				e.preventDefault();
				$('#contents').focus();
				return;
			}
		}
	});
</script>