package ru.vladigeras.visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;

/**
 * @author vladi_geras on 2018-11-29
 */
public class JFreeChartExample extends ApplicationFrame {

	public JFreeChartExample(String title) {
		super(title);

		Dataset dataset = null;
		JFreeChart chart = null;

		if (title.toLowerCase().contains("bar")) {
			dataset = createCategoryDataset();
			chart = createBarChart((CategoryDataset) dataset);

		} else if (title.toLowerCase().contains("pie")) {
			dataset = createPieDataset();
			chart = createPieChart((PieDataset) dataset);
		}

		var chartPanel = new ChartPanel(chart, false);
		chartPanel.setBackground(null);
		chartPanel.setFillZoomRectangle(true);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setPreferredSize(new Dimension(600, 470));
		setContentPane(chartPanel);
	}

	private static CategoryDataset createCategoryDataset() {
		var dataset = new DefaultCategoryDataset();
		dataset.addValue(66.54, "Валюта", "Доллар");
		dataset.addValue(75.59, "Валюта", "Евро");
		dataset.addValue(2.35, "Валюта", "Гривна");
		dataset.addValue(31.25, "Валюта", "Белорус. рубль");
		return dataset;
	}

	private static PieDataset createPieDataset() {
		var dataset = new DefaultPieDataset();
		dataset.setValue("Windows 7", 81);
		dataset.setValue("MacOS", 5);
		dataset.setValue("Linux", 14);
		return dataset;
	}

	private static JFreeChart createBarChart(CategoryDataset dataset) {
		var barChart = ChartFactory.createBarChart(
				"Курс валют к рублю",
				null,
				"Курс",
				dataset);
		barChart.addSubtitle(new TextTitle("Рубль упал :((("));

		var plot = (CategoryPlot) barChart.getPlot();
		plot.setBackgroundPaint(null);

		var rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		var renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		barChart.getLegend().setFrame(BlockBorder.NONE);

		return barChart;
	}

	private static JFreeChart createPieChart(PieDataset dataset) {
		return ChartFactory.createPieChart(
				"Использование операционных систем",
				dataset);
	}
}

