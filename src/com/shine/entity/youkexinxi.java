package com.shine.entity;

import java.io.Serializable;

public class youkexinxi implements Serializable, Comparable<youkexinxi> {
	private static final long serialVersionUID = 1L;
	private int youkebianhao;
	private String youkexingming;
	private String xingbie;
	private String shenfengzhenghao;
	private String lianxifangshi;
	private String huiyuan;
	private String youkemima;
	public String getyoukemima() {
		return youkemima;
	}

	public void setyoukemima(String youkemima) {
		this.youkemima = youkemima;
	}

	public int getyoukebianhao() {
		return youkebianhao;
	}

	public void setyoukebianhao(int youkebianhao) {
		this.youkebianhao = youkebianhao;
	}

	public String getyoukexingming() {
		return youkexingming;
	}

	public void setyoukexingming(String name) {
		this.youkexingming = name;
	}
	public String getxingbie() {
		return xingbie;
	}

	public void setxingbie(String name) {
		this.xingbie = name;
	}
	public String getshenfengzhenghao() {
		return shenfengzhenghao;
	}

	public void setshenfengzhenghao(String name) {
		this.shenfengzhenghao = name;
	}
	public String getlianxifangshi() {
		return lianxifangshi;
	}

	public void setlianxifangshi(String name) {
		this.lianxifangshi = name;
	}
	public String gethuiyuan() {
		return huiyuan;
	}

	public void sethuiyuan(String name) {
		this.lianxifangshi = name;
	}
	

	@Override
	public String toString() {
		return "youkexinxi [youkebianhao=" + youkebianhao + ", youkexingming=" + youkexingming + ", xingbie=" + xingbie
				+ ", shenfengzhenghao=" + shenfengzhenghao + ", lianxifangshi=" + lianxifangshi + ", huiyuan=" + huiyuan
				+ "]";
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		youkexinxi other = (youkexinxi) obj;
		if (xingbie == null) {
			if (other.xingbie != null)
				return false;
		} else if (!xingbie.equals(other.xingbie))
			return false;
		if (youkebianhao != other.youkebianhao)
			return false;
		if (youkexingming == null) {
			if (other.youkexingming != null)
				return false;
		} else if (!youkexingming.equals(other.youkexingming))
			return false;
		
		return true;
	}
	@Override
	public int compareTo(youkexinxi o) {
		// TODO Auto-generated method stub
		return this.youkebianhao - o.youkebianhao;
		
	}

}
