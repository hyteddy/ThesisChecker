<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<meta name="author" content="Łukasz Rak" />
	<meta name="description" content="" />
	<meta name="keywords"  content="" />
	<meta name="Resource-type" content="Document" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style_index.css" />
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="content">
	<h2 class="form-signin-heading">ThesisChecker</h2>
		<div id="sign_in">
		<form:form class="form-horizontal" method="post" modelAttribute="login">
			<div class="control-group">
			  <label class="control-label" for="inputIcon" path="login">LOGIN</label>
			  <div class="controls">
				<div class="input-prepend">
				  <span class="add-on"><i class="icon-user"></i></span>
				  <form:input class="span2" id="inputIcon" type="text" placeholder="login" path="login" required="required" />
				</div>
			  </div>
			</div>

			<div class="control-group">
			  <label class="control-label" for="inputIcon" path="password">PASSWORD</label>
			  <div class="controls">
				<div class="input-prepend">
				  <span class="add-on"><i class="icon-star"></i></span>
				  <form:password class="span2" id="inputIcon" placeholder="password" path="password" required="required" />
				</div>
			  </div>
			</div>

			<div class="control-group">
				<div class="controls">
				  <form:button type="submit" class="btn btn-large btn-primary">Sign in</form:button>
				</div>
			</div>
		</form:form>
		${erstr}
		</div>
		Test: Loginy
		admin3@pk.pl - admin
		user@pk.pl - user
	</div>
</body>
</html>
