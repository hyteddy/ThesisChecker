<%@ include file="../header.jsp" %>

<script type="text/javascript">
	$(function() {
		$("#resultPanel").hide();
	});

	function searchResources() {
		$.ajax({
			url: "search",
			type: "POST", 
			data: $("form"),
			mimeType: "text/html; charset=UTF-8",
			dataType: "json",
			success: function(data, jqXHR) {
				var tableContent = "";
				for (var i = 0; i < data.length; i++) {
					tableContent += "<tr><td>" + data[i].name + "</td>";
					tableContent += "<td>" + data[i].fileType + "</td>";
					tableContent += "<td>" + data[i].user + "</td>";
					tableContent += "<td>" + data[i].uploadDate + "<td></tr>";
				}
				$("#resultPanel").find("table.table-striped tbody").html(tableContent);
				$("#resultPanel").show();
			}
		});
	}
</script>

<h2>Resources</h2>
<div class="panel panel-default">
	<div class="panel-heading"><h2 class="panel-title">Filter</h2></div>
	<div class="panel-body">		
		<form:form method="POST" class="form-horizontal" modelAttribute="resourcesModel">
			<div class="row">
				<div class="col-md-5">
					<div class="form-group">
						<label for="name" class="col-md-5 control-label">Name</label>
						<div class="col-md-7">
							<form:input path="name" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="user" class="col-md-5 control-label">User</label>
						<div class="col-md-7">
							<form:select path="user" class="form-control">
								<option value="-1">---</option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="col-md-5">
					<div class="form-group">
						<label for="fileType" class="col-md-5 control-label">File type</label>
						<div class="col-md-7">
							<form:select path="fileType" class="form-control">
								<option value="-1">---</option>
								<option value="pdf">PDF</option>
								<option value="docx">docx</option>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-md-5 control-label">Creation date</label>
						<div class="col-md-7">
							<form:input path="creationDate" class="form-control"/>
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
