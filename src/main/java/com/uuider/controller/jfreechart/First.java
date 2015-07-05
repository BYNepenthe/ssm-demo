package com.uuider.controller.jfreechart;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author <a href="mailto:xingsan.zhang@gmail.com">zhangpl</a>
 * @version 2015年7月5日
 */
public class First {
	public static void main(String[] args) {
		// create a dataset...
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Category 1", 10.0D);
		dataset.setValue("Category 2", 27.9D);
		dataset.setValue("Category 3", 79.5D);
		
		/*dataset.setValue("Category 1-10", 10.0D);
		dataset.setValue("Category 2-27.9", 27.9D);
		dataset.setValue("Category 3-79.5", 79.5D);*/

		// create a chart...
		JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart",
				dataset, true, true, false);
/*		JFreeChart chart = ChartFactory.createPieChart3D("Sample Pie Chart",
				dataset, true, true, false);
*/
		//自定义颜色
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSectionPaint("Category 1", new Color(200, 255, 255));
		plot.setSectionPaint("Category 2", new Color(255, 0, 255));
		plot.setSectionPaint("Category 3", new Color(255, 255, 255));

		//Outlines
		plot.setSectionOutlinesVisible(true);

		//Null, Zero and Negative Values
		//There does not seem to be a sensible way to represent negative values in a pie chart, 
		//and JFreeChart will always ignore them.
		plot.setIgnoreZeroValues(false);
		plot.setIgnoreNullValues(true);

		//Exploded Sections
		plot.setExplodePercent("Category 1", 0.3D);

		// create and display a frame...
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		frame.setVisible(true);
	}
}