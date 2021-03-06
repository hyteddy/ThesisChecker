<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.fileupload.css" />

    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.blockUI.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.iframe-transport.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
</head>
<script type="text/javascript">
	$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
</script>

<body>
	<nav class="navbar navbar-default" role="navigation">
	  <div class="container">
	  	<div class="navbar-header">
	  		<a href="#" class="navbar-brand">ThesisChecker</a>
	  	</div>
	  	<div class="collapse navbar-collapse">
	  		<ul class="nav navbar-nav">
	  			<li>
	  				<a href="${pageContext.request.contextPath}/test/index">Test</a>
	  			</li>
	  			<li>
	  				<a href="${pageContext.request.contextPath}/resources/index">Resources</a>
	  			</li>
	  			<shiro:hasRole name="ROLE_ADMIN">
	  			<li>
	  				<a href="${pageContext.request.contextPath}/admin/">Admin panel</a>
	  			</li>
	  			</shiro:hasRole>
	  		</ul>
	  		<ul class="nav navbar-nav" style="float: right;">
	  			<li>
	  				<label style="padding-top: 15px;"><shiro:principal/></label>
	  			</li>
	  			<li>
	  				<a href="${pageContext.request.contextPath}/logout"> Logout</a>
	  			</li>
	  		</ul>
	  		
	  	</div>
	  </div>
	</nav>
<div class="container">
