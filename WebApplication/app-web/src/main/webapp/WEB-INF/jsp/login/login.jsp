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
	<meta userId="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
	
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
   
    <link href="<c:url value="/resources/css/style_index.css" />" rel="stylesheet">
    
	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

</head>
<body>
	

    
	<div id="content">
	<h2 class="form-signin-heading">ThesisChecker</h2>
		<div id="sign_in">
			<form class="form-horizontal" name="f" action="<c:url value='j_spring_security_check' />"  method='POST'>
				<div class="form-group" style="margin-left: 15px; margin-right: 15px;">
					<label for="exampleInputEmail1">Email address</label>
					<input type="email" name='j_username' class="form-control" placeholder="Enter email" required>
				</div>
				<div class="form-group" style="margin-left: 15px; margin-right: 15px;">
					<label for="exampleInputPassword1">Password</label>
					<input type="password" class="form-control" name='j_password' placeholder="Password" required>
				</div>
		
				<button type="submit" class="btn btn-large btn-primary" style="margin-left: 15px; margin-bottom: 10px;">Sign in</button>
			</form>
		</div>
		<c:if test="${not empty error}">  
	  <div class="errorblock">  
	  	Your login attempt was not successful, try again.  
	 	Caused :  
	   	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}  
	  </div>  
 </c:if>  
	</div>
</body>
</html>