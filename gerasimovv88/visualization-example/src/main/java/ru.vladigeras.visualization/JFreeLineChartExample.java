package ru.vladigeras.visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * @author vladi_geras on 2018-11-29
 */
public class JFreeLineChartExample extends ApplicationFrame {

	public JFreeLineChartExample(String title) {
		super(title);

		var dataset = createCategoryDatasetTwo();
		var chart = createLineChart(dataset);

		var chartPanel = new ChartPanel(chart, false);
		chartPanel.setBackground(null);
		chartPanel.setFillZoomRectangle(true);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setPreferredSize(new Dimension(600, 470));
		setContentPane(chartPanel);
	}

	private static CategoryDataset createCategoryDatasetTwo() {
		var dataset = new DefaultCategoryDataset();
		dataset.addValue(300, "Ubuntu", "2004");
		dataset.addValue(2546, "Ubuntu", "2005");
		dataset.addValue(2640, "Ubuntu", "2006");
		dataset.addValue(2519, "Ubuntu", "2007");
		dataset.addValue(2325, "Ubuntu", "2008");
		dataset.addValue(2249, "Ubuntu", "2009");
		dataset.addValue(2185, "Ubuntu", "2010");
		dataset.addValue(2192, "Ubuntu", "2011");
		dataset.addValue(2045, "Ubuntu", "2012");
		dataset.addValue(1933, "Ubuntu", "2013");
		dataset.addValue(2022, "Ubuntu", "2014");
		dataset.addValue(1617, "Ubuntu", "2015");
		dataset.addValue(1576, "Ubuntu", "2016");
		dataset.addValue(1498, "Ubuntu", "2017");
		return dataset;
	}

	private static JFreeChart createLineChart(CategoryDataset dataset) {
		return ChartFactory.createLineChart(
				"Популярность Ubuntu Linux (по версии Distrowatch)",
				"Год",
				"Запросов в день",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
	}
}

