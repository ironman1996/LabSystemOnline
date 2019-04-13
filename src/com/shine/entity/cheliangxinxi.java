package com.shine.entity;

import java.io.Serializable;

public class cheliangxinxi implements Serializable, Comparable<cheliangxinxi> {
	private int cheliangbianhao;
	private String chepaihao;
	private String jinrushijian;
	private String likaishijian;
	public int getCheliangbianhao() {
		return cheliangbianhao;
	}
	public void setCheliangbianhao(int cheliangbianhao) {
		this.cheliangbianhao = cheliangbianhao;
	}
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getJinrushijian() {
		return jinrushijian;
	}
	public void setJinrushijian(String jinrushijian) {
		this.jinrushijian = jinrushijian;
	}
	public String getLikaishijian() {
		return likaishijian;
	}
	public void setLikaishijian(String likaishijian) {
		this.likaishijian = likaishijian;
	}
	public String toString() {
		return "cheliangxinxi [cheliangbianhao=" + cheliangbianhao + ", chepaihao=" + chepaihao + ", jinrushijian=" + jinrushijian
				+ ", likaishijian=" + likaishijian + "]";
	}
	
	@Override
	public int compareTo(cheliangxinxi o) {
		return this.cheliangbianhao - o.cheliangbianhao;
		// TODO Auto-generated method stub
		
	}

}
