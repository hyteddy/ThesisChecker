<%@ include file="../header.jsp" %>
<script type="text/javascript">
    $(function() {
        removeInfo();
        $("#filesList").hide();
        $("#fileupload").fileupload({
            dataType: 'json',
            add: function (e, data) {
                removeInfo();
                $('#progress .progress-bar').css('width', '0%');
                data.context = $('<button class="btn btn-primary"/>').text('Upload')
                    .appendTo(".panel-body#uploadPanel #buttonArea")
                    .click(function () {
                        data.context = $('<p/>').text('Uploading...').replaceAll($(this));
                        data.submit();
                    });
                $("#fileName").text(data.files[0].name);
            },
            done: function (e, data) {
                data.context.text("");
                $("#fileName").text("");
                if (data.result.status == "SUCCESS") {
                    $("#infoMessage").text(data.result.successMessage);
                    $("#infoMessage").show();
                    var tableContent = "<tr><td>" + data.result.object.name + "</td>";
                    tableContent += "<td>" + data.result.object.type + "<td></tr>";
                    $("#filesList tbody").append(tableContent);
                    $("#filesList").show();
                }
            },
            progressall: function (e, data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('#progress .progress-bar').css('width', progress + '%');
            },
        });
    });
</script>
<h2>Add resource</h2>
    <div class="panel panel-default">
        <div class="panel-heading"><h2 class="panel-title">Upload</h2></div>
        <div class="panel-body" id="uploadPanel">        
            <div id="infoMessage" class="alert alert-success"></div>
            <span class="btn btn-success fileinput-button">
                <span>Add file</span>
                <input id="fileupload" type="file" data-url="upload" accept="application/msword,application/pdf"> 
            </span>
            <br>
            <br>
            <div id="progress" class="progress">
                <div class="progress-bar" style="width: 0%"></div>
            </div>
            <p id="fileName" class="text-muted"></p>
            <div id="buttonArea"></div>
            <table class="table table-striped table-hover" id="filesList">
                <thead>
                    <th>Name</th>
                    <th>File type</th>
                </thead>
                <tbody>
                    
                </tbody>
            </table>
        </div>
    </div>
<%@ include file="../footer.jsp" %>



