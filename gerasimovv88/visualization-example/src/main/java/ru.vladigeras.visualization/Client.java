package ru.vladigeras.visualization;

/**
 * @author vladi_geras on 2018-11-29
 */
public class Client {
	public static void main(String[] args) {
		var demoJFreeChartBarChart = new JFreeBarChartExample("Bar Chart");
		demoJFreeChartBarChart.pack();
		demoJFreeChartBarChart.setVisible(true);

		var demoJFreeChartPieChart = new JFreePieChartExample("Pie Chart");
		demoJFreeChartPieChart.pack();
		demoJFreeChartPieChart.setVisible(true);

		var demoJFreeChartLineChart = new JFreeLineChartExample("Line Chart");
		demoJFreeChartLineChart.pack();
		demoJFreeChartLineChart.setVisible(true);

		var demoJFreeChartMultiplePieChart = new JFreeMultiplePieChartExample("Multiple Pie Chart");
		demoJFreeChartMultiplePieChart.pack();
		demoJFreeChartMultiplePieChart.setVisible(true);

		var demoJFreeChart3dPieChart = new JFree3dPieChartExample("3D Pie Chart");
		demoJFreeChart3dPieChart.pack();
		demoJFreeChart3dPieChart.setVisible(true);

		var demoJFreeChartHeatChart = new JFreeChartHeatChartExample("Heat Chart");
		demoJFreeChartHeatChart.pack();
		demoJFreeChartHeatChart.setVisible(true);
	}
}
