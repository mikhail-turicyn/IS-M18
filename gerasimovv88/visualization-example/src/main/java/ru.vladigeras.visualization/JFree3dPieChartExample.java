package ru.vladigeras.visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;

/**
 * @author vladi_geras on 2018-11-29
 */
public class JFree3dPieChartExample extends ApplicationFrame {

	public JFree3dPieChartExample(String title) {
		super(title);

		var dataset = createPieDataset();
		var chart = createPieChart(dataset);

		var chartPanel = new ChartPanel(chart, false);
		chartPanel.setBackground(null);
		chartPanel.setFillZoomRectangle(true);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setPreferredSize(new Dimension(600, 470));
		setContentPane(chartPanel);
	}

	private static PieDataset createPieDataset() {
		var dataset = new DefaultPieDataset();
		dataset.setValue("Windows 7", 81);
		dataset.setValue("MacOS", 5);
		dataset.setValue("Linux", 14);
		return dataset;
	}

	private static JFreeChart createPieChart(PieDataset dataset) {
		var chart = ChartFactory.createPieChart3D(
				"Использование операционных систем",
				dataset);

		var plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(270);
		plot.setForegroundAlpha(0.60f);
		plot.setInteriorGap(0.02);

		return chart;
	}
}

