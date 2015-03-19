var compareData, compareAnswers;
var countryMenData, menValues;
var maxMenValue;
var lastFile;

function showCompareGraph(file, menData) {
	compareData = [];
	compareAnswers = [];
	countryMenData = menData;
	
	maxMenValue = 0;
	lastFile = file;
	
	loadCompareData(file);
}

function loadCompareData(file) {
	d3.csv('data/' + file)
		.get(function(error, rows) {
			if (error) {
				console.error(error);
				return;
			}

			menValues = getCountryMenValues();
			
			for (var i in rows) {
				var o = {};
				o.country = rows[i].Country;
				delete rows[i].Country;
				
				// Save the possible answers, but only once (the first iteration of the outer for loop)
				if (i == 0) {
					for (var answer in rows[i])					
						compareAnswers.push(answer);
				}
				
				// Calculate mean value and save answer values as well
				o.value = [];
				var value = 0;
				for (var answer in rows[i]) {							
					// Parse the percentages number
					var v = parseFloat(rows[i][answer]);
					v = (isNaN(v)) ? 0 : v;
					
					// Save all values
					o.value[answer] = v;
					
					// Calculate the mean value for this country
					value += (v/100) * ((compareAnswers.indexOf(answer)+1) / compareAnswers.length);
				}
				o.calculatedValue = value;
				
				
				// Check if the country is in the ranking aka the suvery selected for ranking was conducted in that country
				if (menValues[o.country])
					compareData.push(o);
			}
			
			createCompareGraph();
		});
}

function getCountryMenValues() {
	var menValues = [];
	for (var country in countryMenData) {
		var sum = 0;
		for (var i in countryMenData[country].questions)
			sum += countryMenData[country].questions[i].values[0];
		
		menValues[country] = sum;
		if (maxMenValue < sum) maxMenValue = sum;
	}
	
	return menValues;
}

function createCompareGraph() {
	// Clear previous chart
	d3.select('.compare-chart').selectAll('svg').remove();
	
	var margin = {top: 20, right: 20, bottom: 30, left: 100},
		width = 960 - margin.left - margin.right,
		height = 500 - margin.top - margin.bottom;
	
	var x = d3.scale.linear()
		.range([0, width])
		.domain([0, maxMenValue+10]);
	
	var y = d3.scale.ordinal()
		.rangeRoundBands([height, 0])
		.domain(compareAnswers.map(function(d) {
			if (d == '1') return 'Never justifiable';
			else if (d == "10") return 'Always justifiable';
			else return d;
		}));
	
	var yValue = d3.scale.linear()
		.range([height, 0])
		.domain([0,1]);
	
	var color = d3.scale.category10();

	var xAxis = d3.svg.axis()
	    .scale(x)
	    .orient("bottom");

	var yAxis = d3.svg.axis()
	    .scale(y)
	    .orient("left");

	// Create svg element
	var svg = d3.select(".compare-chart").append("svg")
		.attr("width", width + margin.left + margin.right)
		.attr("height", height + margin.top + margin.bottom)
		.append("g")
			.attr("transform", "translate(" + margin.left + "," + margin.top + ")");

	// Draw x axis
	svg.append("g")
		.attr("class", "x axis")
		.attr("transform", "translate(0," + height + ")")
		.call(xAxis)
	.append("text")
		.attr("class", "label")
		.attr("x", width)
		.attr("y", -6)
		.style("text-anchor", "end")
		.text("Countries 'man dominance' value");

	// Draw y axis
	svg.append("g")
		.attr("class", "y axis")
		.call(yAxis)
		
	var tooltip = d3.select("body").append("div")
		.attr("class", "compare-tooltip")
		.style("opacity", 0);

	// Draw dots
	svg.selectAll(".dot")
		.data(compareData)
	.enter().append("circle")
		.attr("class", "dot")
		.attr("r", 5.5)
		.attr("cx", function(d) { return x(menValues[d.country]); })
		.attr("cy", function(d) { return yValue(d.calculatedValue); })
		.style("fill", "#414141")
		.on("mouseover", function(d) {
			// Color the dot
			d3.select(this).style('fill', '#b6b6b6');
			
			// Show tooltip
			tooltip.transition()
				.duration(200)
				.style("opacity", .9);
			tooltip.html('<span style="font-weight: bold;">' + d.country + '</span>')
				.style("left", (d3.event.pageX + 15) + "px")
				.style("top", (d3.event.pageY - 40) + "px");
	     })
	     .on("mouseout", function(d) {
	    	 // Color the dot
	    	 d3.select(this).style('fill', '#414141');
				
	    	 // Hide the tooltip
	    	 tooltip.transition()
	    	 	.duration(500)
	    	 	.style("opacity", 0);
	     });

	// Draw legend
	var legend = svg.selectAll(".legend")
		.data(color.domain())
	.enter().append("g")
		.attr("class", "legend")
		.attr("transform", function(d, i) { return "translate(0," + i * 20 + ")"; });

	legend.append("rect")
		.attr("x", width - 18)
		.attr("width", 18)
		.attr("height", 18)
		.style("fill", color);

	legend.append("text")
		.attr("x", width - 24)
		.attr("y", 9)
		.attr("dy", ".35em")
		.style("text-anchor", "end")
		.text(function(d) { return d; });
}

function updateCompareGraph() {
	 showCompareGraph(lastFile, countries) 
}