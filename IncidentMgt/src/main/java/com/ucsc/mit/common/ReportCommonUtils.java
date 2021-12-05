package com.ucsc.mit.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.ucsc.mit.model.CloseIncidentSummaryReport;
import com.ucsc.mit.model.IncidentSummaryReport;
import com.ucsc.mit.model.IncidentTicketPrint;
import com.ucsc.mit.model.ReopenIncidentSummaryReport;
import com.ucsc.mit.model.ResolveIncidentSummaryReport;
import com.ucsc.mit.model.TMPerformanceReport;
import com.ucsc.mit.model.UnitSummaryReport;
import com.ucsc.mit.model.VendorSummaryReport;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
@ManagedBean(name="reportCommonUtils")
public class ReportCommonUtils {


	static String pdfpath="";
	static boolean pdfok = true; 
	static String errMsg;
	static String[]fileNamesList;

	static String tpErrorMsg = ResourceUtil.getresourceUtilParam("template.jrxml.error");
	static String tpNotFoundMsg = ResourceUtil.getresourceUtilParam("template.not.found.error");
		public static <T> String generateReports(String reportName,  Map parameters,String pox ,boolean finalPdf) throws JRException, FileNotFoundException, IOException {
		
			System.out.println(reportName+"   ===  generateReports ===========");
			
			List<IncidentSummaryReport> list = new ArrayList<IncidentSummaryReport>();
			List<CloseIncidentSummaryReport> clist = new ArrayList<CloseIncidentSummaryReport>();
			List<ResolveIncidentSummaryReport> reslist = new ArrayList<ResolveIncidentSummaryReport>();
			List<ReopenIncidentSummaryReport> reoplist = new ArrayList<ReopenIncidentSummaryReport>();
			List<UnitSummaryReport> unitlist = new ArrayList<UnitSummaryReport>();
			List<TMPerformanceReport> tmlist = new ArrayList<TMPerformanceReport>();
			List<VendorSummaryReport> venlist = new ArrayList<VendorSummaryReport>();
			List<IncidentTicketPrint> ticket = new ArrayList<IncidentTicketPrint>();
			
			list =(ArrayList<IncidentSummaryReport>)parameters.get("allInSummaryList");
			clist =(ArrayList<CloseIncidentSummaryReport>)parameters.get("closeInSummarylist");
			reslist =(ArrayList<ResolveIncidentSummaryReport>)parameters.get("resInSummarylist");
			reoplist =(ArrayList<ReopenIncidentSummaryReport>)parameters.get("reopInSummarylist");
			unitlist =(ArrayList<UnitSummaryReport>)parameters.get("unitSummarylist");
			tmlist =(ArrayList<TMPerformanceReport>)parameters.get("tmPerformancelist");
			venlist =(ArrayList<VendorSummaryReport>)parameters.get("vendorSummarylist");
			ticket =(ArrayList<IncidentTicketPrint>)parameters.get("incidentTicket");
			
			System.out.println(ticket.size()+"  --  incidentTicket");
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);
			JRBeanCollectionDataSource beanColDataSource2 = new JRBeanCollectionDataSource(clist);
			JRBeanCollectionDataSource beanColDataSource3 = new JRBeanCollectionDataSource(reslist);
			JRBeanCollectionDataSource beanColDataSource4 = new JRBeanCollectionDataSource(reoplist);
			JRBeanCollectionDataSource beanColDataSource5 = new JRBeanCollectionDataSource(unitlist);
			JRBeanCollectionDataSource beanColDataSource6 = new JRBeanCollectionDataSource(tmlist);
			JRBeanCollectionDataSource beanColDataSource7 = new JRBeanCollectionDataSource(venlist);
			JRBeanCollectionDataSource beanColDataSource8 = new JRBeanCollectionDataSource(ticket);
			pdfok=true;
			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			ServletOutputStream servletOutPutStream = httpServletResponse.getOutputStream();
			
			
			
			InputStream inputStream = null;
	        Date date = new Date();
	        SimpleDateFormat dsfs = new SimpleDateFormat("yyyyMMddkmsS");
		    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());     
	    //    httpServletResponse.getHeaderNames(); 
	        String severPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
	        
	       
			
			System.out.println(parameters.get("datasetQuery")+"  --  datasetQuery");
	        System.out.println(severPath+"  --  severPath");
	     
	        System.out.println(parameters.get("dateQuery")+"  --  dateQuery");
	         
	        String  poxFile ="";  
	        String filepath = "";
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
			System.out.println(reportName+"  --  reportName");
			
			
			
			String fileName = reportName + dsfs.format(date);
			String reportPath = severPath + "/jasper_templates/" + reportName + ".jrxml";
			System.out.println(reportPath + "  --reportPath  ---");
			
			
			try {

				inputStream = new FileInputStream(reportPath);
				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
				JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
				@SuppressWarnings("unchecked")
				JasperPrint jasperPrint;
				
	            if (reportName.equals("All_Incidents_Summary")) {
	                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
	            } else if (reportName.equals("Closed_Incidents_Summary")) {
	                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource2);
	            } else if (reportName.equals("Resolved_Incidents_Summary")) {
	                    jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource3);
	            }else if (reportName.equals("Reopened_Incidents_Summary")) {
                    jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource4);
	            }else if (reportName.equals("Incidents_Summary-Units")) {
                    jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource5);
	            }else if (reportName.equals("Team_Member_Performance")) {
                    jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource6);
	            }else if (reportName.equals("Vendor_Summary")) {
                    jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource7);
	            }else if (reportName.equals("Incidents_Ticket_detail")) {
                    jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource8);
	            } else {
	            	jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
	            }
				
				
		
				List<JRPrintPage> pages = jasperPrint.getPages();

//				if (pages.size() != 0) {
					if (pox.equalsIgnoreCase("pdf")) {

//						poxFile = "pdf_files/" + fileName + ".pdf";
//						filepath = severPath + "/" + poxFile;
						
						poxFile = "pdf_files/" + fileName + ".pdf";
						filepath = severPath + "/" + poxFile;
						System.out.println(poxFile + "  ===poxFile");
						System.out.println(filepath + "  ===filepath");
						if (finalPdf) {

							OutputStream output = new FileOutputStream(new File(filepath));
							JasperExportManager.exportReportToPdfStream(jasperPrint, output);
							pdfpath = ResourceUtil.getResourcebundlevalu().getString("server.url") + poxFile;

							System.out.println(pdfpath + "  ===finalPdffilepath");
							output.flush();
							output.close();

						} else {

							httpServletResponse.setContentType("application/pdf");
							httpServletResponse.addHeader("content-disposition",
									"attachment; filename=" + fileName + ".pdf");
							JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutPutStream);
						}

					}

					

//				} else {
//					pdfok = false;
//					errMsg = "No records found";
//					System.out.println(reportName);
//					
//
//				}

			} catch (JRException | IOException ex) {
				pdfok = false;
				//errMsg = tpErrorMsg;
				errMsg=ex.toString();
				// logger.error("Error Message!"+ex.getMessage());
				ex.printStackTrace();
				return "";

			} finally {

				if (inputStream != null)
					try {
						inputStream.close();
					} catch (Exception e) {
						e.printStackTrace();
						pdfok = false;
						errMsg = tpNotFoundMsg;
						return "";
					}

			}
		
	
		FacesContext.getCurrentInstance().responseComplete();
		httpServletResponse.flushBuffer();
		
		 if(finalPdf){
			return poxFile;}else {
				return "";
		 }
			
			
			
	}







		public String getPdfpath() {
			return pdfpath;
		}

		public void setPdfpath(String pdfpath) {
			this.pdfpath = pdfpath;
		}

		public  boolean isPdfok() {
			return pdfok;
		}

		public  void setPdfok(boolean pdfok) {
			this.pdfok = pdfok;
		}

		public  String getErrMsg() {
			return errMsg;
		}

		public  void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}
		



}
