package com.ucsc.mit.common;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
@ManagedBean
@ApplicationScoped
public class ResourceUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ResourceBundle resourceBundleValu;
//	private static final ResourceBundle resourceBundleMsg;
//	private static final ResourceBundle resourceBundleLog;
	/*private static final List<String> reportNameList;
	public static  Map<String, String> reportNameMap = new HashMap<String, String>();*/
	
	static {
		resourceBundleValu =ResourceBundle.getBundle("propValues");
		//resourceBundleMsg =ResourceBundle.getBundle("messages");
	//	resourceBundleLog =ResourceBundle.getBundle("log4j");
	/*	reportNameList =Arrays.asList(resourceBundleValu.getString("all.reportName.values").split(","));*/
	/*	int i =0;*/
		
	
/*		for (String rpnape : reportNameList) {
			reportNameMap.put("jxmlFile"+i, rpnape);
			System.out.println(rpnape);
		}
	*/
		
	}


	
	 public static ResourceBundle getResourcebundlevalu() {
		return resourceBundleValu;
	}



	public static String getresourceUtilParam(String resKey) {
			return resourceBundleValu.getString(resKey);
		}



	/*public static ResourceBundle getResourcebundlemsg() {
		return resourceBundleMsg;
	}
	public static String getresourceUtilMsg(String resKey) {
		return resourceBundleMsg.getString(resKey);
	}*/



	/*public static ResourceBundle getResourcebundlelog() {
		return resourceBundleLog;
	}*/




/*	public static List<String> getReportnamelist() {
		return reportNameList;
	}



	public static Map<String, String> getReportNameMap() {
		return reportNameMap;
	}
*/


}
