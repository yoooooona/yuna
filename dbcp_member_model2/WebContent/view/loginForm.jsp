<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layout/header.jsp" %>
<link href="../css/floating-labels.css" rel="stylesheet">
<c:choose>
<c:when test="${vo eq null}">
<form class="form-signin" name="loginform" action="../login.do" method="post">	
      <div class="form-label-group">
        <input type="text" id="userid" name="userid" class="form-control" placeholder="id" required autofocus>
        <label for="userid">아이디</label>
      </div>
      <div class="form-label-group">
        <input type="password" id="current_password" name="current_password" class="form-control" placeholder="Password" required>
        <label for="pass">비밀번호</label>
      </div>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2018</p>
    </form>	
    </c:when>
    <c:when test="${vo ne null}">	  	
		<script>		
			var name='${vo.name}';
			//3번 메뉴(login) 없애기
			var $zero=$('#3').detach();
			var $tag="<span class='navbar-text'>"+name+" 님 반갑습니다.</span>&nbsp;&nbsp;"+
			"<button type='button' id='logout' class='btn btn-primary'>로그아웃</button>";
			//메뉴 추가
			$('#navbarCollapse').append($tag);		
			</script>
	</c:when>
 </c:choose>
	 <script>
	 	$(function(){
	 		$("#logout").click(function(){
				location.href='../logout.do';
			});
	 	});
	 </script>
<%@ include file="../layout/footer.jsp" %>























