<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/post/write" name="postwrite" method="post">
		제목 <input type="text" name="name"/>
		내용 <input type="text" name="contents"/>
		<input type="hidden" name="boardId" value ="1"/>
		<input type="hidden" name="writerId" value ="1"/>
		
		<input type="submit" id="submit" value="등록"/>
	</form>	
</body>
</html>