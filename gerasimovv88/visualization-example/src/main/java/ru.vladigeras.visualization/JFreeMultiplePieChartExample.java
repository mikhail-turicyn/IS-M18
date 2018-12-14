package ru.vladigeras.visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * @author vladi_geras on 2018-11-29
 */
public class JFreeMultiplePieChartExample extends ApplicationFrame {

	public JFreeMultiplePieChartExample(String title) {
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

	private static CategoryDataset createPieDataset() {
		var dataset = new DefaultCategoryDataset();
		dataset.addValue(12, "Windows XP", "Январь 2018");
		dataset.addValue(43, "Windows 7", "Январь 2018");
		dataset.addValue(12, "Windows 8/8.1", "Январь 2018");
		dataset.addValue(33, "Windows 10", "Январь 2018");

		dataset.addValue(10, "Windows XP", "Июнь 2018");
		dataset.addValue(43, "Windows 7", "Июнь 2018");
		dataset.addValue(12, "Windows 8/8.1", "Июнь 2018");
		dataset.addValue(35, "Windows 10", "Июнь 2018");

		dataset.addValue(5, "Windows XP", "Июль 2018");
		dataset.addValue(36, "Windows 7", "Июль 2018");
		dataset.addValue(5, "Windows 8/8.1", "Июль 2018");
		dataset.addValue(54, "Windows 10", "Июль 2018");

		return dataset;
	}

	private static JFreeChart createPieChart(CategoryDataset dataset) {
		var chart = ChartFactory.createMultiplePieChart3D(
				"Статистика использования Windows",
				dataset,
				TableOrder.BY_COLUMN,
				true,
				true,
				false
		);

		chart.setBackgroundPaint(new Color(200, 255, 200));
		return chart;
	}
}
