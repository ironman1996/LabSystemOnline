package com.shine.entity;

import java.io.Serializable;

public class EmpDaoyou implements Serializable,Comparable<EmpDaoyou>{
	
	private static final long serialVersionUID = 1L;
	private int dynum;
	private String dyname;
	private String dytel;
	private String dygender;
	
	
	public int getDynum() {
		return dynum;
	}


	public void setDynum(int dynum) {
		this.dynum = dynum;
	}


	public String getDyname() {
		return dyname;
	}


	public void setDyname(String dyname) {
		this.dyname = dyname;
	}


	public String getDytel() {
		return dytel;
	}


	public void setDytel(String dytel) {
		this.dytel = dytel;
	}


	public String getDygender() {
		return dygender;
	}


	public void setDygender(String dygender) {
		this.dygender = dygender;
	}

	public String toString(){
		return "EmpDaoyou [dynum=" + ",dyname=" + ",dytel=" + ",dygender=" + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dygender == null) ? 0 : dygender.hashCode());
		result = prime * result + dynum;
		result = prime * result + ((dyname == null) ? 0 : dyname.hashCode());
		
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpDaoyou other = (EmpDaoyou) obj;
		if (dygender == null) {
			if (other.dygender != null)
				return false;
		} else if (!dygender.equals(other.dygender))
			return false;
		if (dynum != other.dynum)
			return false;
		if (dyname == null) {
			if (other.dyname != null)
				return false;
		} else if (!dyname.equals(other.dyname))
			return false;
		
		return true;
	}
	@Override
	public int compareTo(EmpDaoyou o) {
		// TODO Auto-generated method stub
		return this.dynum - o.dynum;
	}


	


	

}
