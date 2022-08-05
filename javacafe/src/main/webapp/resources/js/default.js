$(function() {
	$('.plus').click(function() {
		var amount = $('.amount').val();
		if (amount < 10) {
		$('.amount').attr('value', parseInt(amount) + 1)	
		}
	});

	$('.minus').click(function() {
		var amount = $('.amount').val();
		if (amount > 1) {
			$('.amount').attr('value', parseInt(amount) - 1)
		}
	});
});