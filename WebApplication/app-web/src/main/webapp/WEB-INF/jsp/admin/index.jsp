<%@ include file="../header.jsp" %>
				<div class="tabbable"> <!-- Only required for left/right tabs -->
		  <ul class="nav nav-tabs">
			<li class="active"><a href="#tab1" data-toggle="tab">Promoter</a></li>
			<li><a href="#tab2" data-toggle="tab">Logs</a></li>
			<li><a href="#tab3" data-toggle="tab">Docs</a></li>
			<li><a href="#tab5" data-toggle="tab">Add</a></li>
		  </ul>
		  <div class="tab-content">
		<!-- Prowadzacy -->
			<div class="tab-pane active" id="tab1">
				<div id="table_doc_z">
				<form id="table_doc_w">
				<table class="table table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Surname</th>
						<th>Faculty</th>
						<th>Degree</th>
						<th>E-mail</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Demi</td>
						<td>loo</td>
						<td>WFMIFD</td>
						<td>prof</td>
						<td>demi@gmail.com</td>
						<td><input type="checkbox"></td>
					</tr>
					
				</tbody>
				</table>
				</form>
				</div>
				<div id="bt_2">
					<div class="col-md-5">
						<div class="input-group">
						  <input type="text" class="form-control" placeholder="SEARCH">
						  <span class="input-group-btn">
							<button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
						  </span>
						</div><!-- /input-group -->
					</div><!-- /.col-lg-6 -->
			
					<div class="btn btn-danger" id="rightB">DELETE</div>
					<div class="btn btn-success" id="rightB">ADD</div>
				</div>
				
			</div>
		<!-- Logi -->
			<div class="tab-pane" id="tab2">
				<div id="table_doc_z">
				<form id="table_doc_w">
				<table class="table table-hover">
				<thead>
					<tr>
						<th>Person</th>
						<th>Action</th>
						<th>Time</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Demi loo</td>
						<td>usuniecie</td>
						<td>12:29</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>Demi loo</td>
						<td>usuniecie</td>
						<td>12:29</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>Demi loo</td>
						<td>usuniecie</td>
						<td>12:29</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>Demi loo</td>
						<td>usuniecie</td>
						<td>12:29</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>Demi loo</td>
						<td>usuniecie</td>
						<td>12:29</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>Demi loo</td>
						<td>usuniecie</td>
						<td>12:29</td>
						<td><input type="checkbox"></td>
					</tr>
				</tbody>
				</table>
				</form>
				</div>
				<div id="bt_1">
					<div class="btn btn-danger" id="rightB">DELETE</div>
				</div>
			</div>
		<!-- Prace -->
			<div class="tab-pane" id="tab3">
				<div id="table_doc_z">
				<form id="table_doc_w">
				<table class="table table-hover">
				<thead>
					<tr>
						<th>Title</th>
						<th>Year</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<!-- przyklad -->
					<tr>
						<td>Demi loo</td>
						<td>usuniecie</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>Demi looxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
						<td>usuniecie</td>
						<td><input type="checkbox"></td>
					</tr>
					
				</tbody>
				</table>
				</form>
				</div>
				<div id="bt_1">
					<div class="col-md-5">
						<div class="input-group">
						  <input type="text" class="form-control" placeholder="SEARCH">
						  <span class="input-group-btn">
							<button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
						  </span>
						</div><!-- /input-group -->
					</div><!-- /.col-lg-6 -->
				<div class="btn btn-danger" id="rightB">DELETE</div>
				</div>
			</div>
		<!-- Dodawanie -->
			<div class="tab-pane" id="tab5">
			  <form class="form-horizontal">
				  
				  <div class="form-group">
					<label for="inputName" class="col-sm-3 control-label">Name</label>
					<div class="col-sm-9">
						<div class="input-group">
						  <input type="text" class="form-control" id="inputName" placeholder="Name" required="">
						</div>
					</div>
				  </div>
				  
				  <div class="form-group">
					<label for="inputSurname" class="col-sm-3 control-label">Surname</label>
					<div class="col-sm-9">
						<div class="input-group">
						  <input type="text" class="form-control" id="inputSurname" placeholder="Surname" required="">
						</div>
					</div>
				  </div>
				  
				  <div class="form-group">
					<label for="inputTitle" class="col-sm-3 control-label">Degree</label>
					<div class="col-sm-9">
						<div class="input-group">
						  <input type="text" class="form-control" id="inputTitle" placeholder="Degree e.g master" required="">
						</div>
					</div>
				  </div>
				  
				  <div class="form-group">
					<label for="inputInst" class="col-sm-3 control-label">Faculty</label>
					<div class="col-sm-9">
						<div class="input-group">
						  <input type="text" class="form-control" id="inputInst" placeholder="Faculty">
						</div>
					</div>
				  </div>
				  
				  
				  <div class="form-group">
					<label for="inputEmail" class="col-sm-3 control-label">Email</label>
					<div class="col-sm-9">
						<div class="input-group">
						  <input type="text" class="form-control" id="inputEmail" placeholder="Email">
						</div>
					</div>
				  </div>
				  	<div class="col-sm-offset-3 col-sm-8">
					  <button type="submit" class="btn btn-info">ADD</button>
					</div>
				</form>
			</div>
			
		  </div>
		</div>
		
	</div>
<%@ include file="../footer.jsp" %>
