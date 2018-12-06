package ru.vladigeras.visualization;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.xy.DefaultXYZDataset;

import java.awt.*;
import java.util.Random;

/**
 * @author vladi_geras on 2018-12-06
 */
public class JFreeChartHeatChartExample extends ApplicationFrame {

	public JFreeChartHeatChartExample(String title) {
		super(title);

		var dataset = createXYZDataset();
		var chart = createHeatChart(dataset);

		var chartPanel = new ChartPanel(chart, false);
		chartPanel.setBackground(null);
		chartPanel.setFillZoomRectangle(true);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setPreferredSize(new Dimension(600, 470));
		setContentPane(chartPanel);
	}

	private static DefaultXYZDataset createXYZDataset() {

		var x = new double[1000 * 100]; // date
		var y = new double[1000 * 100]; // numeric (1-100)
		var z = new double[1000 * 100]; // numeric (the actual data)

		final var rand = new Random();
		var l = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {

			l -= 600000;

			for (int j = 0; j < 100; j++) {
				final int idx = i * 100 + j;
				x[idx] = l;
				y[idx] = j;

				double delta = rand.nextInt(15) * (rand.nextInt(4) == 0 ? -1 : 1);
				z[idx] = Math.max(0, Math.min(300, (idx < 1000 ? 0 : z[idx - 1000]) + delta));
			}
		}

		var dataset = new DefaultXYZDataset();
		dataset.addSeries("", new double[][]{x, y, z});
		return dataset;
	}

	private static JFreeChart createHeatChart(DefaultXYZDataset dataset) {
		var xAxis = new DateAxis("Time");
		xAxis.setStandardTickUnits(DateAxis.createStandardDateTickUnits());
		xAxis.setLowerMargin(0);
		xAxis.setUpperMargin(0);

		var labels = new String[500];
		for (int i = 0; i < 500; i++) labels[i] = String.valueOf(i);

		var yAxis = new SymbolAxis(null, labels);
		yAxis.setTickUnit(new NumberTickUnit(50));

		// another invisible y-axis for scaling
		// (this is not necessary if your y-values are suitable)
		var valueAxis1 = new NumberAxis("Data");
		valueAxis1.setLowerMargin(0);
		valueAxis1.setUpperMargin(0);
		valueAxis1.setVisible(false);

		// create a paint-scale and a legend showing it
		var paintScale = new LookupPaintScale(0, 300, Color.black);
		Color c = Color.green;
		paintScale.add(0.0, c);
		paintScale.add(33.0, c = c.darker());
		paintScale.add(66.0, c.darker());
		paintScale.add(100.0, c = Color.blue);
		paintScale.add(133.0, c = c.darker());
		paintScale.add(166.0, c.darker());
		paintScale.add(200.0, c = Color.red.darker().darker());
		paintScale.add(233.0, c = c.brighter());
		paintScale.add(266.0, c.brighter());

		var psl = new PaintScaleLegend(paintScale, new NumberAxis());
		psl.setPosition(RectangleEdge.RIGHT);
		psl.setAxisLocation(AxisLocation.TOP_OR_RIGHT);
		psl.setMargin(50.0, 20.0, 80.0, 0.0);

		var plot = new XYPlot(dataset, xAxis, yAxis, new XYBlockRenderer());
		((XYBlockRenderer) plot.getRenderer()).setPaintScale(paintScale);
		plot.setRangeAxis(1, valueAxis1);
		plot.mapDatasetToRangeAxis(0, 1);

		JFreeChart chart = new JFreeChart(null, null, plot, false);
		chart.addSubtitle(psl);
		return chart;

	}
}
