function showStatsJs(canvas, a, label, color, title) {
    const names = a.map(x => x.NAME);
    const values = a.map(x => x.VALUE);
    const chart = new Chart(canvas, {
        type: 'bar',
        data: {
            labels: names,
            datasets: [{
                label: label,
                data: values,
                backgroundColor: color
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            title: {
                display: true,
                text: title
            }
        }
    });
}
