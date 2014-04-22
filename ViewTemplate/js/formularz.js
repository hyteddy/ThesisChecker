$(document).ready(function(){
	$('#file').change(function(){
		$this = $(this);
		$('#url').attr('value', $this.val());
	})

	$('#chooser').click(function(){
		$('#file').click();
	}).show();
});