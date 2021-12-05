package com.ucsc.mit.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name="pollView")
@SessionScoped
public class PollView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private int number;

	    public void increment() {
	        number++;
	    }

	    public int getNumber() {
	        return number;
	    }
}
