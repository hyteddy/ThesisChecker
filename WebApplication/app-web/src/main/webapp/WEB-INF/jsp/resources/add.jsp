<%@ include file="../header.jsp" %>
<h2>Add resource</h2>
<div id="content">
    <div id="sender">
        <form:form method="POST" class="form-horizontal">
            <div class="control-group">
                <div class="input-append">
                    <label for="title" class="col-md-5 control-label">Title</label>
                    <input type="text" id="title" class="form-control"/>
                    <input type="file" id="file" userId="file" accept="application/msword,application/pdf">
                    <button class="btn" id="chooser" type="button"><i class="icon-folder-open"></i></button>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-large btn-primary">Add resource</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
<%@ include file="../footer.jsp" %>



