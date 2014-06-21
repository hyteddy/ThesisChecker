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
					<div class="input-group" id="search">
					  <input type="text" class="form-control" placeholder="SEARCH">
					  <span class="input-group-btn">
						<button type="button" class="btn btn-default btn-lg">
						  <span class="add-on"><i class="icon-search"></i></span>
						</button>
					  </span>
					</div>					
					<div class="btn btn-inverse" id="rightB">DELETE</div>
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
					<div class="btn btn-inverse" id="rightB">DELETE</div>
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
				<!-- <div class="row">
				  <div class="col-lg-6">
					<div class="input-group">
					  <div class="input-group-btn">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
						<ul class="dropdown-menu">
						  <li><a href="#"></a></li>
						  <li><a href="#">Another action</a></li>
						  <li><a href="#">Something else here</a></li>
						</ul>
					  </div>
					  <input type="text" class="form-control">
					</div>
				  </div>
				</div> -->
					<div class="input-group" id="search">
					  <input type="text" class="form-control" placeholder="SEARCH">
					  <span class="input-group-btn">
						<button type="button" class="btn btn-default btn-lg">
						  <span class="add-on"><i class="icon-search"></i></span>
						</button>
					  </span>
					</div>
				<div class="btn btn-inverse" id="rightB">DELETE</div>
				</div>
			</div>
		<!-- Dodawanie -->
			<div class="tab-pane" id="tab5">
			  <form class="form-horizontal">
				  <div class="control-group">
					<label class="control-label" for="inputName">Name</label>
					<div class="controls">
					  <input type="text" id="inputName" placeholder="Name">
					</div>
				  </div>
				  <div class="control-group">
					<label class="control-label" for="inputSurname">Surname</label>
					<div class="controls">
					  <input type="text" id="inputSurname" placeholder="Surname">
					</div>
				  </div>
				  <div class="control-group">
					<label class="control-label" for="inputTitle">Degree</label>
					<div class="controls">
					  <input type="text" id="inputTitle" placeholder="Degree e.g master">
					</div>
				  </div>
				  <div class="control-group">
					<label class="control-label" for="inputInst">Faculty</label>
					<div class="controls">
					  <input type="text" id="inputInst" placeholder="Faculty">
					</div>
				  </div>
				  <div class="control-group">
					<label class="control-label" for="inputEmail">Email</label>
					<div class="controls">
					  <input type="text" id="inputEmail" placeholder="Email">
					</div>
				  </div>
				  
				  <div class="control-group">
					<div class="controls">
					  <button type="submit" class="btn">ADD</button>
					</div>
				  </div>
				</form>
			</div>
			
		  </div>
		</div>
		
	</div>
<%@ include file="../footer.jsp" %>
