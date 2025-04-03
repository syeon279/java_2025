package com.company.dto;

public class BoardDto {
	private int bno;
	private String bname;
	private String bpass;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bhit;
	private String bip;
	
	public int getBno() { return bno; } 
	public void setBno(int bno) { this.bno = bno; }
	public String getBname() { return bname; } 
	public void setBname(String bname) { this.bname = bname; }
	public String getBpass() { return bpass; } 
	public void setBpass(String bpass) { this.bpass = bpass; } 
	public String getBtitle() { return btitle; } 
	public void setBtitle(String btitle) { this.btitle = btitle; }
	public String getBcontent() { return bcontent; } 
	public void setBcontent(String bcontent) { this.bcontent = bcontent; } 
	public String getBdate() { return bdate; }
	public void setBdate(String bdate) { this.bdate = bdate; } 
	public int getBhit() { return bhit; } 
	public void setBhit(int bhit) { this.bhit = bhit; }
	public String getBip() { return bip; } 
	public void setBip(String bip) { this.bip = bip; }
	
	public BoardDto() {
		super();
	}
	public BoardDto(int bno, String bname, String bpass, String btitle, String bcontent, String bdate, int bhit,
			String bip) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.bpass = bpass;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
		this.bip = bip;
	}
	
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", bname=" + bname + ", bpass=" + bpass + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bdate=" + bdate + ", bhit=" + bhit + ", bip=" + bip + "]";
	}
	
	
}
