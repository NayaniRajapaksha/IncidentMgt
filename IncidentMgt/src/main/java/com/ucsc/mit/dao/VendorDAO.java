package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.Vendor;

public interface VendorDAO {
	public String addVendor(Vendor v);
	
	public List<Vendor> listVendors();
	
	public String updateVendor(Vendor v);
	
	public Vendor getVendorByCode(int code);
}
