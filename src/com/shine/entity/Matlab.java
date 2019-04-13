package com.shine.entity;



import java.io.Serializable;

public class Matlab implements Serializable, Comparable<Matlab>{
	
	private static final long serialVersionUID = 1L;
	private int matNum;
	private String matPackageName;
	private String matDesc;
	private String matClass;
	public int getMatNum() {
		return matNum;
	}


	public void setMatNum(int matNum) {
		this.matNum = matNum;
	}


	public String getMatPackageName() {
		return matPackageName;
	}


	public void setMatPackageName(String matPackageName) {
		this.matPackageName = matPackageName;
	}


	public String getMatDesc() {
		return matDesc;
	}


	public void setMatDesc(String matDesc) {
		this.matDesc = matDesc;
	}


	public String getMatClass() {
		return matClass;
	}


	public void setMatClass(String matClass) {
		this.matClass = matClass;
	}


	public String getMatMethod() {
		return matMethod;
	}


	public void setMatMethod(String matMethod) {
		this.matMethod = matMethod;
	}
	private String matMethod;
	
	
	
	
	@Override
	public String toString() {
		return "Matlab [matNum=" + matNum + ", matPackageName=" + matPackageName + ", matDesc=" + matDesc
				+ ", matClass=" + matClass + ", matMethod=" + matMethod + "]";
	}
	
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matlab other = (Matlab) obj;
		
		if (matNum != other.matNum)
			return false;
		if (matPackageName == null) {
			if (other.matPackageName != null)
				return false;
		} else if (!matPackageName.equals(other.matPackageName))
			return false;
		if (matDesc == null) {
			if (other.matDesc != null)
				return false;
		} else if (!matDesc.equals(other.matDesc))
			return false;
		if (matClass == null) {
			if (other.matClass != null)
				return false;
		} else if (!matClass.equals(other.matClass))
			return false;
		
		return true;
	}
	public int compareTo(Matlab o) {
		// TODO Auto-generated method stub
		return this.matNum - o.matNum;
	}


	
	
}
