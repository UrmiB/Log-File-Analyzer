package com.cummins.project734.servlet;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cummins.project734.dateTime.DateTime;
import com.cummins.project734.entity.AnalysisData;
import com.cummins.project734.entity.ErrorInformation;
import com.cummins.project734.entity.ErrorReport;
import com.cummins.project734.entity.SearchResult;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfTrial extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
	//private String[] str2;


	public PdfTrial() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CreatePdf(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CreatePdf(request, response);
	}

	private void CreatePdf(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String FILE = "D://Log File Analysis.pdf";

		HttpSession session = request.getSession();
		SearchResult sResult = new SearchResult();
		String query = (String) session.getAttribute("searchquery");
		String username = (String) session.getAttribute("UserName");
		String filename = (String) session.getAttribute("filename");

		/*;
		session.setAttribute("freq", freq);
		session.setAttribute("percent", percent);*/


		//Calculate percentage


		DateTime d = new DateTime();
		String [] str = d.dateTime1();
		/*	ArrayList<ErrorInformation> li = new ArrayList<ErrorInformation>();
		li = (ArrayList<ErrorInformation>)analysis.getErrorInfo();*/

		//analysis = (AnalysisData)request.getAttribute("Analysis");

		/*List<DatewiseRecord>  DateList = new ArrayList<DatewiseRecord>();
		DateList = (ArrayList<DatewiseRecord>) analysis.getDatewiseRecords();
		DatewiseRecord dr = new DatewiseRecord();
		Iterator<DatewiseRecord> itd = DateList.iterator();
		int count =0;
		while(itd.hasNext())
		{
			dr = itd.next();
			count++;
		}*/

		//int noOfrecords = analysis.getTotalNoOfRecords();
		
		

		ArrayList<String> RecordList = new ArrayList<String>();
		ArrayList<ErrorReport> ErrorList = new ArrayList<ErrorReport>();
	
		//List<Integer> fieldLenArray = new ArrayList<Integer>();
		//System.out.println("query:"+query);
		if(query != "")
		{

			sResult = (SearchResult) session.getAttribute("SearchResult");
			RecordList = (ArrayList<String>)sResult.getRecords();
		//	fieldLenArray = (List<Integer>) session.getAttribute("FieldArray");

		}else
		{
			ErrorList = (ArrayList<ErrorReport>)session.getAttribute("errorList");
		//	fieldLenArray = (List<Integer>) session.getAttribute("FieldArray");
		}

		try{
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			//addMetaData(document);
			addTitlePage(document, catFont, smallBold, redFont, filename, query, str, 0, 0);
			addContent(document,RecordList,ErrorList,query, username, filename);
			document.close();
		}catch (Exception e) {
			e.printStackTrace();
		}		
		request.getRequestDispatcher("./CreatePDF.jsp").forward(request, response);


	}
	private static void addContent(Document document,ArrayList<String> recordList,ArrayList<ErrorReport> errorList, String query, String filename, String username) throws DocumentException, IOException, ServletException {
		Anchor anchor = new Anchor("Record Details of the User Search", catFont);
		anchor.setName("Record Details");

		// Second parameter is the number of the chapter
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph();
		Section subCatPart = catPart.addSection(subPara);
		//subCatPart.add(new Paragraph(""));

		subPara = new Paragraph();
		subCatPart = catPart.addSection(subPara);

		// Add a list
		//createList(subCatPart);
		Paragraph paragraph = new Paragraph();
		addEmptyLine1(paragraph, 5);
		subCatPart.add(paragraph);

		// Add a table

		createRecordsTable(document, subCatPart,recordList,errorList,query);

		// Now add all this to the document
		document.add(catPart);

		// Next section
		anchor = new Anchor("Pattern Recorded", catFont);
		//anchor.setName("Second Chapter");

		// Second parameter is the number of the chapter
		catPart = new Chapter(new Paragraph(anchor), 1);

		subPara = new Paragraph("", subFont);
		subCatPart = catPart.addSection(subPara);
		//subCatPart.add(new Paragraph("This is a very important message"));
		createPatternTable(document, subCatPart, username, filename);
		otherDetails(document, subCatPart);
		document.add(subCatPart);

		// Now add all this to the document
		//document.add(catPart);

	}


	private void addTitlePage(Document document, Font catfont, Font smallBold, Font redFont, String filename, String query, String[] str, int freq, float percent) {

		// TODO Auto-generated method stub
		Paragraph preface = new Paragraph();
		addEmptyLine1(preface, 1);
		preface.add(new Paragraph("LOG FILE ANALYSIS", catfont));
		addEmptyLine1(preface, 1);
		preface.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + ", " + new Date(), smallBold));		
		preface.add(new Paragraph("File Analyzed: "+ filename, smallBold));
		
		

		if(query != "")
		{	
			preface.add(new Paragraph("Keyword Searched: "+ query, smallBold));
			preface.add(new Paragraph("Earliest Date: "+ str[0], smallBold));
			preface.add(new Paragraph("Latest Date: "+ str[1], smallBold));
			preface.add(new Paragraph("Frequency of keyword: "+ freq, smallBold));
			preface.add(new Paragraph("Percentage Distribution: "+ percent, smallBold));
		
			/*	ErrorInformation displayList = new ErrorInformation();
			List<ErrorInformation> errorInfoList = new ArrayList<ErrorInformation>();
			Iterator lIterator = errorInfoList.iterator();
			while(lIterator.hasNext())
			{
				displayList = (ErrorInformation) lIterator.next();
				preface.add(new Paragraph("Error Type: "+ displayList.getErrorType(), smallBold));
				preface.add(new Paragraph("Error Number: "+ displayList.getNumber(), smallBold));
				//System.out.println("\nType: "+displayList.getErrorType()+" Number: "+displayList.getNumber());
			}*/
			//preface.add(new Paragraph("Number of records: "+ noOfrecords, smallBold));
		}
		else
		{
			preface.add(new Paragraph(""));
		}
		addEmptyLine1(preface, 3);
		addEmptyLine1(preface, 8);

		try {
			document.add(preface);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// Start a new page
		document.newPage();
	}


	private static void addEmptyLine1(Paragraph preface, int i) {
		int number = 0;
		// TODO Auto-generated method stub
		for (int i1 = 0; i1 < number ; i1++) {
			Phrase paragraph = null;
			paragraph.add(new Paragraph(" "));
		}
	}

	private static void createRecordsTable(Document document, Section subCatPart, ArrayList<String> recordList, ArrayList<ErrorReport> errorList, String query)throws BadElementException {
		document.newPage();
		PdfPTable table = new PdfPTable(1);
		PdfPCell c1;

		c1 = new PdfPCell(new Phrase("RECORDS"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		if(query != ""){
			Iterator<String> iterator = recordList.iterator();

			while(iterator.hasNext()){
				String field;
				field= iterator.next();
				c1 = new PdfPCell(new Phrase(field));	        	
				table.addCell(c1);
			}
		}else{
			Iterator<ErrorReport> iterator = errorList.iterator();
			ErrorReport er = new ErrorReport();
			while(iterator.hasNext()){
				String field;
				er = iterator.next();
				field = er.getErrorRecord();
				c1 = new PdfPCell(new Phrase(field));	        	
				table.addCell(c1);
			}
		}

		subCatPart.add(table);
		document.newPage();
	}



	private static void createPatternTable(Document document, Section subCatPart, String username, String filename)throws BadElementException, IOException {
		document.newPage();
		PdfPTable table = new PdfPTable(1);
		PdfPCell c1;

		c1 = new PdfPCell(new Phrase("PATTERN RECORDED"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

	
		FileInputStream fstream = new FileInputStream("C:\\User_Directories\\"+filename+"\\Patterns\\"+username+"\\pattern.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		List<String> list1 = new ArrayList<String>();

		while ((strLine = br.readLine()) != null) 
		{
			list1.add(strLine);
		}
		in.close();
		Iterator<String> it = list1.iterator();
		while(it.hasNext()){
			String pattern;
			pattern = it.next();
			c1 = new PdfPCell(new Phrase(pattern));	        	
			table.addCell(c1);
		}
		subCatPart.add(table);
		document.newPage();
	}

	private static void otherDetails(Document document, Section subCatPart){

		document.newPage();
	
		PdfPTable table = new PdfPTable(2);
				
		PdfPCell c1 = new PdfPCell(new Phrase("ERROR TYPE"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("FREQUENCY"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);
		
		AnalysisData analysis = new AnalysisData();
		ArrayList<ErrorInformation> li = new ArrayList<ErrorInformation>();
		li = (ArrayList<ErrorInformation>)analysis.getErrorInfo();

		Iterator<ErrorInformation> it = li.iterator();
		ErrorInformation ei = new ErrorInformation();
		while(it.hasNext()){
			ei = (ErrorInformation)it.next();
			String error = ei.getErrorType();
			//int frequency = ei.getNumber();
			
			
			/*c1 = new PdfPCell(new Phrase(error));	        	
			table.addCell(c1);
			c1 = new PdfPCell(new Phrase(frequency));	        	
			table.addCell(c1);*/
			table.addCell(error);
			//table.addCell(frequency);
			subCatPart.add(table);
		}
	}
}