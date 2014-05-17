<%@ include file="../header.jsp" %>

<script type="text/javascript">
	function searchResources() {
		alert("TODO");
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

<%@ include file="../footer.jsp" %>
