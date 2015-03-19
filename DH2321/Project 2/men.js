/**
 * This is the javascript file for the graph showing the men dominance in the countries.
 */

var countries = [];
var ascending = false;
var q1 = "data/men_business.csv";
var q2 = "data/men_job.csv";
var q3 = "data/men_political.csv";
var q4 = "data/men_university.csv";
var files = [q1,q2,q3,q4];
var dataLoaded = false;

function showMenGraph(callback) {
	loadCSV(files);
	onDataReady(callback);
}

function onDataReady(callback) {
	// Check if data is loaded
	if (!dataLoaded)
		window.setTimeout(function() { onDataReady(callback); }, 100);
	else
		callback();
}

// Loads all the specified files one after another.
function loadCSV(files, index) {
	if (!index) {
		dataLoaded = false;
		index = 0;
	} else if (index >= files.length) {
		createJSON();
		dataLoaded = true;
		return;
	}

	// Skip undefined indices
	if (!files[index]) {
		loadCSV(files, ++index);
		return null;
	}
	
	// Load new csv file and queue next file as well.
	d3.csv(files[index], row, function(error, rows) {
		get(error, rows, files, ++index);
	});
}

// Function used as accessor for the .csv method of d3.
function row(d) {
	var keys = Object.keys(d);
	var row = {}
	row.question = keys[0];
	row.country = d[keys[0]];
	row.answers = keys.slice(1);
	
	// Parse the the percentages
	for (var i = 0; i < row.answers.length; i++) {
		var v = parseFloat(d[row.answers[i]]);
		v = (isNaN(v)) ? 0 : v;
		d[row.answers[i]] = v;
	}
	
	// Filter answers: 3 answers means last answer is neutral, 4 answers means first 2 answers positive, last 2 negative.
	if (row.answers.length == 3) {
		row.answers = row.answers.slice(0,2);
	} else if (row.answers.length == 4) {
		// Calculate new values
		var value1 = d[row.answers[0]] + d[row.answers[1]];
		var value2 = d[row.answers[2]] + d[row.answers[3]];
		
		// Rephrase questions
		row.answers[0] = "'" + row.answers[0] + "' or '" + row.answers[1] + "'";
		row.answers[1] = "'" + row.answers[2] + "' or '" + row.answers[3] + "'";
		row.answers =  row.answers.slice(0,2);
		d[row.answers[0]] = value1;
		d[row.answers[1]] = value2;		
	} else if (row.answers.length != 2) {
		console.error("Error when processing question '" + row.question + "': There are more than 4 or less than 2 answers.");
	}
	
	row.values = [];
	for (var i = 0; i < row.answers.length; i++)
		row.values.push(d[row.answers[i]]);
	return row;
}

// Used as callback function for the .csv method of d3.
function get(error, rows, files, newIndex) {
	if (error) {
		console.error(error);
	} else {
		for (var i = 0; i < rows.length; i++) {
			var country = rows[i].country;
			delete rows[i].country;			
			
			if (!countries[country]) countries[country] = {};
    		if (!countries[country].hasOwnProperty('questions'))
    			countries[country].questions = [];
    		countries[country].questions.push(rows[i]);
		}
		
		loadCSV(files, newIndex);
	}
}

function createJSON() {	
	// Get the max range
	var maxRange = 0;
	for (var k in countries) {
		var sum = 0;
		for (var q in countries[k].questions)
			sum += countries[k].questions[q].values[0];
		
		if (sum > maxRange) maxRange = sum;
	}

	// Create JSON data
	var json = [];
	for (var k in countries) {
		var ranges = [];
		for (var i = 0; i < countries[k].questions.length; i++) {
			// Add last value to the new range value
			var r = 0;
			if (i == 0)
				r = countries[k].questions[i].values[0];
			else
				r = countries[k].questions[i].values[0] + ranges[i-1];
			ranges.push(r)
		}
		// Add the maxRange as the last range element so that all bars are on the same scale
		ranges.push(maxRange);
		
		var country = {};
		country.title = k;
		country.subtitle = '';
		country.measures = [0];
		country.markers = [0];
		country.ranges = ranges;
		country.questions = countries[k].questions;
		json.push(country);
	}
	
	// Sort the countries
	json = json.sort(function (a,b) {
		var valA = a.ranges[a.ranges.length-2];
		var valB = b.ranges[b.ranges.length-2];
		
		if (ascending)
			return valA - valB;
		else
			return valB - valA;
	});
	
	d3.select('.men-chart').selectAll('svg').remove();
	createMenGraph(json);
}

var margin = {top: 5, right: 80, bottom: 5, left: 150},
    width = 960 - margin.left - margin.right,
    height = 25 - margin.top - margin.bottom;

// Creates the graph
function createMenGraph(json) {
	// Create tooltip
	
	var svg = d3.select(".men-chart").style("width", '960px')
	  .selectAll("svg")
	    .data(json)
	  .enter().append("svg")
	    .attr("class", "bullet")
	    .attr("width", width + margin.left + margin.right)
	    .attr("height", height + margin.top + margin.bottom)
	  .append("g")
	    .attr("transform", "translate(" + margin.left + "," + margin.top + ")")
	    .call(chart);
	
	// Set the id for each bar associating it with a question
	svg.each(function(data,i) {
		d3.select(this).selectAll('.range').attr('id', function(range,j) {
			var question = data.questions[data.ranges.indexOf(range)].question;
			return getQuestionIndex(question);
		});
	});
	
	// Tooltips for the questions
	var tooltip = d3.select("body")
		.append("div")   
    	.attr("class", "tooltip")               
    	.style("opacity", 0);    
	tooltip.append('p')
		.attr('class', 'tooltip_question');
	tooltip.append('p')
		.attr('class', 'tooltip_answers');
	svg.on("mouseover", function(data,i) {
		var oldColor;
		d3.select(this).selectAll(".range")
			.on("mouseover", function(range,j) {
				var question = data.questions[data.ranges.indexOf(range)];
				
				// Brush the bar 
				oldColor = d3.select(this).style('fill');
				d3.select(this).style('fill', tooltip.style('background-color'));
				
				// Show actual tooltip element
				var tooltipMargin = 15;
				tooltip.transition()        
	                .duration(200)      
	                .style("opacity", .9);
	            // Question
	            tooltip.select('.tooltip_question').text(question.question);
	            // Answers
	            var answers = '<table>';
	            for (var i in question.answers)
	            	answers += '<tr><td>' + question.answers[i] + ':</td><td>' + question.values[i].toFixed(2) + '%</td></tr>';
	            answers += '</table>';
	            tooltip.select('.tooltip_answers').html(answers);
	            // Position tooltip
	            var height = parseFloat(tooltip.style('height'));
				var top = (d3.event.clientY+height+10 > window.innerHeight) ? d3.event.pageY-height-tooltipMargin : d3.event.pageY+tooltipMargin;				
	            tooltip.style("left", (d3.event.pageX+tooltipMargin) + "px")     
	            	.style("top", top + "px");
			}).on("click", function(range,j) {
				// Show details!?
			}).on("mouseout", function(range,j) {
				// Hide tooltip
				tooltip.transition()        
	                .duration(500)      
	                .style("opacity", 0);   
				
				// Reverse brushing
				d3.select(this).style('fill', oldColor);				
			});
	  });
	
	var title = svg.append("g")
	    .style("text-anchor", "end")
	    .attr("transform", "translate(-6," + ((height+margin.top) / 2) + ")");	
	title.append("text")
	    .attr("class", "title")
	    .text(function(d) { return d.title; });	
	title.append("text")
	    .attr("class", "subtitle")
	    .attr("dy", "1em")
	    .text(function(d) { return parseFloat(d.ranges[d.ranges.length-2].toFixed(2)); });
	
	// Changing order
	d3.select('[value=asc]').on('change', function(d,i) {
		ascending = this.checked;
		createJSON();
	});
	
	// Question selection
	d3.selectAll('input.question').on('change', function(d,i) {
		if (this.value == "q1") {
			if (this.checked)
				files[0] = q1;
			else
				delete files[0];
		} else if (this.value == "q2") {
			if (this.checked)
				files[1] = q2;
			else
				delete files[1];
		} else if (this.value == "q3") {
			if (this.checked)
				files[2] = q3;
			else
				delete files[2];
		} else if (this.value == "q4") {
			if (this.checked)
				files[3] = q4;
			else
				delete files[3];
		}
		
		countries = {};
		loadCSV(files);
		// Update the compareGraph
		onDataReady(function() {
			updateCompareGraph();
		})
	});
	// Question hover
	var oldColor;
	d3.selectAll('span.question')
		.on('mouseover', function(d,i) {
			var checked = d3.select(this).select('input.question').property('checked');
			if (checked) {
				var q = d3.select(this).select('input.question').attr('value');
				oldColor = d3.select('#' + q).style('fill');
				d3.selectAll('#' + q).style('fill', tooltip.style('background-color'));	
				d3.select(this).style('background-color', tooltip.style('background-color'));	
			}
		}).on('mouseout', function(d,i) {
			var checked = d3.select(this).select('input.question').property('checked');
			if (checked) {
				var q = d3.select(this).select('input.question').attr('value');
				d3.selectAll('#' + q).style('fill', oldColor);								
			}
			d3.select(this).style('background-color', null);
		});
}

var chart = d3.bullet()
    .width(width)
    .height(height);

function getQuestionIndex(question) {
	if ('Men make better business executives than women do' == question) {
		return 'q1';
	} else if ('Men should have more right to a job than women' == question) {
		return 'q2';
	} else if ('Men make better political leaders than women do' == question) {
		return 'q3';
	} else if ('University is more important for a boy than for a girl' == question) {
		return 'q4';
	}
}
