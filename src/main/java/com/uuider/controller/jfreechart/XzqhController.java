package com.uuider.controller.jfreechart;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uuider.mappers.jfreechart.XzqhMapper;
import com.uuider.model.jfreechart.Xzqh;

/**
 * @author  <a href="mailto:xingsan.zhang@gmail.com">zhangpl</a>
 * @version 2015年7月5日
 */
@Controller
@RequestMapping("xzqh")
public class XzqhController {
	
	@Autowired
	public XzqhMapper xzqhMapper;
	
	@RequestMapping
	public void getProvince(HttpServletResponse resp){
		List<Xzqh> province = xzqhMapper.getProvince();
		getJfreechart(province,resp);
	}
	
	public void getJfreechart(List<Xzqh> xzqh,HttpServletResponse resp){
		DefaultPieDataset dataset = new DefaultPieDataset();
		/*dataset.setValue("Category 1", 10.0);
		dataset.setValue("Category 2", 27.9);
		dataset.setValue("Category 3", 79.5);*/
		
		for (int i = 0; i < xzqh.size(); i++) {
			dataset.setValue(xzqh.get(i).getProvince(), 1);
		}
		
		// create a chart...
		JFreeChart chart = ChartFactory.createPieChart(
		"行政区划分布",
		dataset,
		true, // legend?
		true, // tooltips?
		false // URLs?
		);

		// 乱码解决开始
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.PLAIN, 20)); //标题文字乱码
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("宋体", Font.BOLD, 12));//饼上的文字乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12)); //图例文字乱码
		
		//自定义颜色
		/*PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSectionPaint("Category 1", new Color(200, 255, 255));
		plot.setSectionPaint("Category 2", new Color(255, 0, 255));
		plot.setSectionPaint("Category 3", new Color(255, 255, 255));
		
		//Outlines
		plot.setSectionOutlinesVisible(true);
		
		//Null, Zero and Negative Values
		//There does not seem to be a sensible way to represent negative values in a pie chart, 
		//and JFreeChart will always ignore them.
		plot.setIgnoreZeroValues(false);
		plot.setIgnoreNullValues(true);*/
		
		//Exploded Sections
//		plot.setExplodePercent("Category 1", 0.3);
		
		// create and display a frame...
		/*ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		frame.setVisible(true);*/
		
		/*try {
			// 将图表保存到"D:\\chart.png"文件,图片的大小宽为500px,长为270px
			ChartUtilities.saveChartAsPNG(new File("D:\\chart.png"),
					chart, 500, 270);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		resp.setContentType("image/png");
		try {
			OutputStream out = resp.getOutputStream();
			ChartUtilities.writeChartAsPNG(out, chart, 700, 500);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
