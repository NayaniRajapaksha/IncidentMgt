package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.VendorSummaryView;

public interface VendorSummaryViewDAO {
	public List<VendorSummaryView>  getVendorSummaryReport( String ven_name,String progress,String fromDate,String toDate);
}
