$(document).ready(function() {
	$('.proBtn').click(function() {
		if ($(this).parent().find($('.proName').attr('value') == $('.cartName'))) {
			var val = $('.cartName').attr('value');
			$('.cartName').next().next().attr(val + 1, 'value') + 1;
		}
	});
});