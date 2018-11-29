package ru.vladigeras.visualization;

/**
 * @author vladi_geras on 2018-11-29
 */
public class Client {
	public static void main(String[] args) {
		var demoJFreeChartBarChart = new JFreeChartExample("Bar Chart");
		demoJFreeChartBarChart.pack();
		demoJFreeChartBarChart.setVisible(true);

		var demoJFreeChartPieChart = new JFreeChartExample("Pie Chart");
		demoJFreeChartPieChart.pack();
		demoJFreeChartPieChart.setVisible(true);

		var demoJFreeChartLineChart = new JFreeChartExample("Line Chart");
		demoJFreeChartLineChart.pack();
		demoJFreeChartLineChart.setVisible(true);
	}
}
