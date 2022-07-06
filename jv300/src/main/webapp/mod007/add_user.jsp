<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param value="mod007 : Java Beans and include 한글 테스트" name="subtitle2" />
				<jsp:param value="<%=URLEncoder.encode(\"mod007 : Java Beans and include 한글 테스트\", \"UTF-8\")%>" name="subtitle" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h3>회원가입</h3>
			<form action="add_user.do" method="post">
				<p>
					회원 아이디 :
					<input type="text" name="userId">
				</p>
				<p>
					비밀번호 :
					<input type="password" name="passwd">
				</p>
				<p>
					이름 :
					<input type="text" name="userName">
				</p>
				<p>
					주민번호 :
					<input type="text" name="ssn" maxlength="6" placeholder="앞 6자리">
				</p>
				<p>
					이메일1 :
					<input type="text" name="email1" placeholder="아이디">
				</p>
				<p>
					이메일2 :
					<input type="text" name="email2" placeholder="메일도메인 ex) naver.com">
				</p>
				<p>
					주소1 :
					<input type="text" name="addr1" placeholder="도로명주소">
				</p>
				<p>
					주소2 :
					<input type="text" name="addr2" placeholder="세부주소">
				</p>

				<p>
					<input type="submit" value="확인">
					<input type="reset" value="리셋">
				</p>
			</form>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</div>
</body>
</html>