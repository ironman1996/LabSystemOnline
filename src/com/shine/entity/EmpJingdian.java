package com.shine.entity;

import java.io.Serializable;

public class EmpJingdian implements Serializable, Comparable<EmpJingdian>{
	
	private static final long serialVersionUID = 1L;
	private int jdnum;
	private String jdname;
	private String jdtel;
	private String jdpj;
	private int jdprice;
	private String jdaddress;
	
	
	public int getJdnum() {
		return jdnum;
	}


	public void setJdnum(int jdnum) {
		this.jdnum = jdnum;
	}


	public String getJdname() {
		return jdname;
	}


	public void setJdname(String jdname) {
		this.jdname = jdname;
	}


	public String getJdtel() {
		return jdtel;
	}


	public void setJdtel(String jdtel) {
		this.jdtel = jdtel;
	}


	public String getJdpj() {
		return jdpj;
	}


	public void setJdpj(String jdpj) {
		this.jdpj = jdpj;
	}


	public int getJdprice() {
		return jdprice;
	}


	public void setJdprice(int jdprice) {
		this.jdprice = jdprice;
	}


	public String getJdaddress() {
		return jdaddress;
	}


	public void setJdaddress(String jdaddress) {
		this.jdaddress = jdaddress;
	}

	public String toString(){
		return "EmpJingdian [jdnum=" + jdnum + ",jdname=" + jdname + ",jdprice=" + jdprice + ",jdtel=" + jdtel + ","
				+ "jdaddress=" + jdaddress + ",jdpj=" + jdpj +"]";
	}
	
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jdpj == null) ? 0 : jdpj.hashCode());
		result = prime * result + jdnum;
		result = prime * result + ((jdname == null) ? 0 : jdname.hashCode());
		result = prime * result + ((jdaddress == null) ? 0 : jdaddress.hashCode());
		return result;
		
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpJingdian other = (EmpJingdian) obj;
		if (jdpj == null) {
			if (other.jdpj != null)
				return false;
		} else if (!jdpj.equals(other.jdpj))
			return false;
		if (jdnum != other.jdnum)
			return false;
		if (jdname == null) {
			if (other.jdname != null)
				return false;
		} else if (!jdname.equals(other.jdname))
			return false;
		
		return true;
	}
	@Override
	public int compareTo(EmpJingdian o) {
		// TODO Auto-generated method stub
		return this.jdnum - o.jdnum;
	}
	
}
