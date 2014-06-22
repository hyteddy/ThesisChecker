<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<meta name="author" content="Łukasz Rak" />
	<meta name="description" content="" />
	<meta name="keywords"  content="" />
	<meta name="Resource-type" content="Document" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/style_index.css" />" rel="stylesheet">

	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div id="content">
	<h2 class="form-signin-heading">ThesisChecker</h2>
		<div id="sign_in">
        <form:form class="form-horizontal" name="f" modelAttribute="login"  method='POST'>
            <div class="form-group" style="margin-left: 15px; margin-right: 15px;">
                <label for="exampleInputEmail1">Email address</label>
                <form:input type="email" class="form-control" placeholder="Enter email" path="login" required="required" />
            </div>
            <div class="form-group" style="margin-left: 15px; margin-right: 15px;">
                <label for="exampleInputPassword1">Password</label>
                <form:password class="form-control" placeholder="Password" path="password" required="required" />
            </div>

            <form:button type="submit" class="btn btn-large btn-primary" style="margin-left: 15px; margin-bottom: 10px;">Sign in</form:button>
        </form:form>
		</div>
        <c:if test="${not empty erstr}">
        	  <div class="errorblock">
                ${erstr}
        	  </div>
         </c:if>
		Test: Loginy
		admin3@pk.pl - admin
		user@pk.pl - user
	</div>
</body>
</html>
