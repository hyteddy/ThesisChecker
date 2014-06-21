<%@ include file="../header.jsp" %>
<script type="text/javascript">
    $(function() {
        $("#fileupload").fileupload({
            add: function (e, data) {
                data.context = $('<button class="btn btn-primary"/>').text('Upload')
                    .appendTo(".panel-body#uploadPanel")
                    .click(function () {
                        data.context = $('<p/>').text('Uploading...').replaceAll($(this));
                        data.submit();
                    });
                $("#fileName").text(data.files[0].name);
            },
            done: function (e, data) {
                data.context.text('Upload finished.');
            },
            progressall: function (e, data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('#progress .progress-bar').css(
                    'width',
                    progress + '%'
                );
            },
        });
    });
</script>
<h2>Add resource</h2>
    <div class="panel panel-default">
        <div class="panel-heading"><h2 class="panel-title">Upload</h2></div>
        <div class="panel-body" id="uploadPanel">        
            <span class="btn btn-success fileinput-button">
                <span>Add file</span>
                <input id="fileupload" type="file" data-url="upload">
            </span>
            <br>
            <br>
            <div id="progress" class="progress">
                <div class="progress-bar progress-bar-success" style="width: 0%"></div>
            </div>
            <p id="fileName" class="text-muted"></p>
        </div>
    </div>
<%@ include file="../footer.jsp" %>



