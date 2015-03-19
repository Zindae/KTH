$(document).ready(function() {
	// Show the ranking of the countries and wait for the resulting data
	showMenGraph(function() {
		
		var file = $('.compare-questions').find('option:selected').val() + '.csv';
		showCompareGraph(file, countries);
		
		$('.compare-questions').change(function(e) {
			var file = $('.compare-questions').find('option:selected').val() + '.csv';
			showCompareGraph(file, countries);
		})
	});
});