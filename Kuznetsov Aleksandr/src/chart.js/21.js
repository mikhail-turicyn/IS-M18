var ctx = document.getElementById('Line_Chart').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ["January", "February", "March", "April", "May", "June", "July","August"],
        
		datasets: [{
            label: "1973",
            backgroundColor: 'red',
            borderColor: 'rgb(255, 99, 132)',
            data: [-10, 1, 5, 14, 20, 30, 39,27],
			fill: false,
        }, {
            label: "1426",
			fill: false,
            backgroundColor: 'blue',
            borderColor: 'blue',
            data: [1, 10, 3, 18, 24, 36, 27,9],				
		}]
    },

    // Configuration options go here
    options: {
		responsive: true,
				title: {
					display: true,
					text: 'Температура'
				},
	}
});

var ctx = document.getElementById('Bar_Charts').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'bar',

    // The data for our dataset
    data: {
        labels: ["January", "February", "March", "April", "May", "June", "July","August"],
        
		datasets: [{
            label: "1973",
            backgroundColor: 'red',
            borderColor: 'rgb(255, 99, 132)',
            data: [-10, 1, 5, 14, 20, 30, 39,27],
			fill: false,
        }, {
            label: "1426",
			fill: false,
            backgroundColor: 'blue',
            borderColor: 'blue',
            data: [1, 10, 3, 18, 24, 36, 27,9],				
		}]
    },

    // Configuration options go here
    options: {
		responsive: true,
				title: {
					display: true,
					text: 'Температура'
				},
	}
});

var ctx = document.getElementById('HBar_Charts').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'horizontalBar',

    // The data for our dataset
    data: {
        labels: ["Audi S6", "BMW Z4", "Mercedes-Benz CLS 350", "BMW F30", "Range Rover", "Lexus GS 450h", "Skoda Octavia 3 MT","VW Golf 6"],
        
		datasets: [{
            label: "секунд",
            backgroundColor: 'rgba(255, 99, 66, 0.5)',
            borderColor: 'rgb(255, 99, 66)',
            data: [4.8, 5.5, 6.4, 7.3, 5.4, 5.9, 10.3,9.5],
			fill: false,
        }]
    },

    // Configuration options go here
    options: {
		responsive: true,
				title: {
					display: true,
					text: 'разгон до 100км/ч'
				},
	}
});

var ctx = document.getElementById('Radar_Charts').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'radar',

    // The data for our dataset
    data: {
        labels: ["January", "February", "March", "April", "May", "June", "July","August"],
        
		datasets: [{
            label: "1973",
            backgroundColor: 'red',
            borderColor: 'rgb(255, 99, 132)',
            data: [-10, 1, 5, 14, 20, 30, 39,27],
			fill: false,
        }, {
            label: "1426",
			fill: false,
            backgroundColor: 'blue',
            borderColor: 'blue',
            data: [1, 10, 3, 18, 24, 36, 27,9],				
		}]
    },

    // Configuration options go here
    options: {
		responsive: true,
				title: {
					display: true,
					text: 'Температура'
				},
	}
});

var ctx = document.getElementById('Pie_Charts').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'pie',

    // The data for our dataset
    data: {
		labels: ['Red', 'Orange', 'Yellow',	'Green', 'Blue'],
		datasets: [{
            label: "Dataset 1",
            backgroundColor: ['red','orange','yellow','green','blue'],
            data: [5, 14, 20, 30, 27],
        }]
    },

    // Configuration options go here
    options: {
		responsive: true,
				title: {
					display: true,
					text: 'Pie'
				},
	}
});

var ctx = document.getElementById('Mix_Charts').getContext('2d');

var mixedChart = new Chart(ctx, {
  type: 'bar',
  data: {
    datasets: [{
          label: 'Bar Dataset',
          backgroundColor: 'rgba(255, 3, 66, 0.5)',
            borderColor: 'red',
            data: [-5, 5, 14, 20],
        }, {
          label: 'Line Dataset',
		  backgroundColor: 'rgba(47, 59, 235, 0.2)',
		  borderColor: 'blue',
          data: [1, 9, 7, 21],

          // Changes this dataset to become a line
          type: 'line'
        },
		{
          label: 'Bar Dataset2',
		  backgroundColor: 'rgba(2, 130, 0, 0.5)',
		  borderColor: 'green',
          data: [7, -4, 19, 15],

          // Changes this dataset to become a line
          type: 'bar'
        }],
    labels: ['January', 'February', 'March', 'April']
  },
    options: {
		responsive: true,
				title: {
					display: true,
					text: 'mix'
				},
	}
});
