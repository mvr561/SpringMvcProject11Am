package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomUtil {
	
	public void generatePie(String path,List<Object[]> data) {
		
		//creating dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(Object[] d:data) {
			dataset.setValue(d[0].toString(),new Double(d[1].toString()));
		}
		
		//convert into dataset to jfreechart
		
JFreeChart chart	=	ChartFactory.createPieChart3D("UOMTYPE", dataset, true, true, false);
		

  
  //convert to image	
	 try {
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/utpie.jpg"), chart, 200, 250);
	} catch (IOException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	 
	
}
	///2.CREATING BAR CHART
	
			public void generateBar(String path,List<Object[]> data) {
				
				//1.creating dataset and send the data to dataset from List
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				for(Object[] m:data) {
					
					dataset.setValue(new Double(m[1].toString()), m[0].toString(), "");
					
					
				}
				
				//2.convert dataset to jfreebar chart
				
			JFreeChart chart =	ChartFactory.createBarChart("UOM", " TYPE OF UOM", "COUNT", dataset);
			
			    //3.save image
			  try {
				ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/utbar.jpg"), chart, 300, 400);
			} catch (IOException e) {
				
				e.printStackTrace();
				System.out.println(e);
			}
			}
}
