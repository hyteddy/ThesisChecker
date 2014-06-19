<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<title></title>
	<meta userId="author" content="Łukasz Rak" />
	<meta userId="description" content="" />
	<meta userId="keywords"  content="" />
	<meta userId="Resource-type" content="Document" />
	<meta userId="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" />
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style_index.css" />
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

    
	<div id="content">
	<h2 class="form-signin-heading">ThesisChecker</h2>
		<div id="sign_in">
		<form class="form-horizontal" name="f" action="<c:url value='j_spring_security_check' />"  method='POST'>
			<div class="control-group">
			  <label class="control-label" for="inputIcon">LOGIN</label>
			  <div class="controls">
				<div class="input-prepend">
				  <span class="add-on"><i class="icon-user"></i></span>
				  <input class="span2" name='j_username' id="inputIcon" type="text" placeholder="login" required>
				</div>
			  </div>
			</div>
			
			<div class="control-group">
			  <label class="control-label" for="inputIcon">PASSWORD</label>
			  <div class="controls">
				<div class="input-prepend">
				  <span class="add-on"><i class="icon-star"></i></span>
				  <input class="span2" name='j_password' id="inputIcon" type="password" placeholder="password" required>
				</div>
			  </div>
			</div>
			
			<div class="control-group">
				<div class="controls">
				  <button type="submit" class="btn btn-large btn-primary">Sign in</button>
				</div>
			</div>
		</form>
		</div>
	</div>
	
	<c:if test="${not empty error}">  
	  <div class="errorblock">  
	   Your login attempt was not successful, try again.  
	 Caused :  
	   ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}  
	  </div>  
 </c:if>  
</body>
</html>