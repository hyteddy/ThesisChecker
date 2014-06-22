$(document).ready(function(){
	$('#file').change(function(){
		$this = $(this);
		$('.input-wlasne').attr('value', $this.val());
	})

	$('#chooser').click(function(){
		$('#file').click();
	}).show();
});