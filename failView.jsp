<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failview</title>
</head>
<body>
	<h2>실패 화면</h2>
	<div>${requestScope.dname}는 존재하지 않는 number입니다.</div><br />
	<form action = "dept" method = "get">
		<div>추가를 원하시면  아래 빈칸에 입력을 해주세요</div><br /><br />
		<input type = "text" name = "deptno" placeholder="deptno 입력"><br />
		<input type = "text" name = "dname" placeholder="dname 입력"><br />
		<input type = "text" name = "loc" placeholder="loc 입력"><br />
		<input hidden="true" type = "text" name = "commend" value="insert"><br />
		<input type = "submit" value = "insert"><br /><br />
		<button onclick=" window.location.href='index.html'">메인으로 돌아가기</button>
	</form>
</body>
</html>