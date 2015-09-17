package com.cummins.project734.servlet;

import java.awt.BasicStroke;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ChartController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException{

		HttpSession session = request.getSession();
		String searchQuery = (String) session.getAttribute("searchquery");
		if(searchQuery == ""){
			int []numb = (int[]) session.getAttribute("numb");
			String []str = (String[]) session.getAttribute("str");
			
			int total=0;
			for(int j=0;j<3;j++)
			{
				total = numb[j]+total;
			}
			
			float []per;
			per = new float[3];
			for(int i=0;i<3;i++)
			{
				double div;
				div = ((double)numb[i])/total;
				per[i] = (float)div*100;
				//System.out.println("Percentage: "+per[i]);
			}
			
			JFreeChart chart = getChart(str,per); // create your chart
		    ByteArrayOutputStream bos = new ByteArrayOutputStream();
		    ChartUtilities.writeChartAsPNG(bos, chart, 600, 400);

		            response.setContentType("image/png");
		            OutputStream out = new BufferedOutputStream(response.getOutputStream());
		            out.write(bos.toByteArray());
		            out.flush();
		            out.close();
			
		}else{
		int freq = (Integer) session.getAttribute("freq");
		float percent = (Float) session.getAttribute("percent");
		float value;
		value = 100 - percent;
		
		System.out.println("Final Percent: "+value);
		
		JFreeChart chart = getChart(freq,percent,value,searchQuery); // create your chart		
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    ChartUtilities.writeChartAsPNG(bos, chart, 600, 400);

	            response.setContentType("image/png");
	            OutputStream out = new BufferedOutputStream(response.getOutputStream());
	            out.write(bos.toByteArray());
	            out.flush();
	            out.close();
		}
	}
	
	private JFreeChart getChart(int freq, float percent, float value, String searchQuery) {

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Other", value);
		dataset.setValue(searchQuery, percent);

		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart3D(" ", dataset, legend, tooltips, urls);

		//chart.setBorderPaint(Color.BLACK);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);
		//chart.getTitle().setPaint(Color.BLACK);
		return chart;
	}
	
	private JFreeChart getChart(String str[],float per[]){
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		int i=0;
		for(i=0;i<str.length;i++)
		{
			dataset.setValue("Error "+str[i], per[i]);
		}

		boolean legend = false; //true - bottom bar appears
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart3D(" ", dataset, legend, tooltips, urls);

		//chart.setBorderPaint(Color.BLACK);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);
		return chart;
	}

}
