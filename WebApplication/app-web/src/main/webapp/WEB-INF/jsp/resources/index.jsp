<%@ include file="../header.jsp" %>

<script type="text/javascript">
	$(function() {
		$("#resultPanel").hide();
		$("#errorMessage").hide();
		$("#infoMessage").hide();
		$("#dateFrom").datepicker({format: "yyyy-mm-dd"});
		$("#dateTo").datepicker({format: "yyyy-mm-dd"});
	});

	function searchResources() {
		var formData = $("form").serializeObject();
		$.ajax({
			url: "search",
			type: "POST", 
			headers: { 
        		'Accept': 'application/json',
        		'Content-Type': 'application/json' 
    		},
			data: JSON.stringify(formData),
			dataType: "json",
			success: function(data, jqXHR) {
				removeErrors();
				removeInfo();
				$("#resultPanel").hide();
				if (data.status != "ERROR") {
					var tableContent = "";
					var list = data.list;
					if (data.list != null && data.list.length > 0) {
						for (var i = 0; i < list.length; i++) {
							tableContent += "<tr><td>" + list[i].name + "</td>";
							tableContent += "<td>" + list[i].fileType + "</td>";
							tableContent += "<td>" + list[i].user + "</td>";
							tableContent += "<td>" + formatDate(list[i].uploadDate) + "<td></tr>";
						}
						$("#resultPanel").find("table.table-striped tbody").html(tableContent);
						$("#resultPanel").show();
					} else {
						$("#infoMessage").text(data.successMessage);
						$("#infoMessage").show();
					}

				} else {
    				showErrors(data);
				}
			}
		});
	}
</script>

<h2>
	Resources
	<a href="${pageContext.request.contextPath}/resources/add" class="btn btn-success pull-right">Add resource</a>
</h2>
<div class="panel panel-default">
	<div class="panel-heading"><h2 class="panel-title">Filter</h2></div>
	<div class="panel-body">		
	<div id="errorMessage" class="alert alert-danger"></div>
	<div id="infoMessage" class="alert alert-info"></div>
		<form:form method="POST" class="form-horizontal" modelAttribute="resourcesModel">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="userId" class="col-md-5 control-label">User</label>
						<div class="col-md-7">
							<form:select path="userId" class="form-control">
								<option value="-1">---</option>
								<c:forEach var="user" items="${resourcesModel.usersList}">
									<option value="${user.id}">${user.getFullName()}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group" id="dateFromGroup">
						<label for="dateFrom" class="col-md-5 control-label">Date from</label>
						<div class="col-md-7">
							<form:input path="dateFrom" class="form-control" id="dateFrom"/>
							<span class="text-danger validMessage"></span>
						</div>
					</div>
					<span id="dateFromMessage" class="text-danger"></span>
				</div>
				<div class="col-md-4">
					<div class="form-group" id="dateToGroup">
						<label for="dateTo" class="col-md-5 control-label">Date to</label>
						<div class="col-md-7">
							<form:input path="dateTo" class="form-control" id="dateTo"/>
							<span class="text-danger validMessage"></span>
						</div>
					</div>
				</div>
			</div>
			<button type="button" onclick="searchResources()" class="btn btn-primary pull-right">Search</button>
		</form:form>

	</div>
</div>
<div id="resultPanel" class="panel panel-default">
	<div class="panel-heading">
		<h2 class="panel-title">Results</h2>
	</div>
	<div class="panel-body">
		<table class="table table-striped table-hover">
			<thead>
				<th>Name</th>
				<th>File type</th>
				<th>User</th>
				<th>Upload date</th>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>
</div>


<%@ include file="../footer.jsp" %>
