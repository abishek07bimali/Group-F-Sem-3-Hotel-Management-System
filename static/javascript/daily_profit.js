const chart = document.querySelector('#chart').getContext('2d');

// Create a new chart instance


new Chart(chart, {
    type: 'line',
    data: {
        labels: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],

        datasets: [
            {
            label: 'Daily Profit',
            data: [1030, 2400, 5300, 2400, 5040, 6500, 7600],
            borderColor: 'red',
            borderWidth: 2
            },
    
            {
            label: 'Daily Visit',
            data: [3030, 2609, 6300, 4400, 6040, 6500, 8200],
            borderColor: 'blue',
            borderWidth: 2
                }
    ]
    },
    options: {
        responsive: true
    }
});



const config = {
    type: 'bar',
    data,
    options: {
      indexAxis: 'y',
    }
  };


const day = Utils.days({count: 7});
const data = {
  labels: day,
  datasets: [{
    axis: 'y',
    label: 'Daily profit',
    data: [1030, 2400, 5300, 2400, 5040, 6500, 7600],
    fill: false,
    backgroundColor: [
      'rgba(255, 99, 132, 0.2)',
      'rgba(255, 159, 64, 0.2)',
      'rgba(255, 205, 86, 0.2)',
      'rgba(75, 192, 192, 0.2)',
      'rgba(54, 162, 235, 0.2)',
      'rgba(153, 102, 255, 0.2)',
      'rgba(201, 203, 207, 0.2)'
    ],
    borderColor: [
      'rgb(255, 99, 132)',
      'rgb(255, 159, 64)',
      'rgb(255, 205, 86)',
      'rgb(75, 192, 192)',
      'rgb(54, 162, 235)',
      'rgb(153, 102, 255)',
      'rgb(201, 203, 207)'
    ],
    borderWidth: 1
  }]
};
