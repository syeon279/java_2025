package com.company.domain;

public class BoardVo {
	private int bno;
	private int bhit;
	private String bname;
	private String btitle;
	private String bcontent;
	private String bdate;
	private String bip;
	private String bpass;
	
	public BoardVo() {
		super();
	}
	
	public BoardVo(int bno, int bhit, String bname, String btitle, String bcontent, String bdate, String bip,
			String bpass) {
		super();
		this.bno = bno;
		this.bhit = bhit;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bip = bip;
		this.bpass = bpass;
	}

	public int getBno() { return bno; }  
	public void setBno(int bno) { this.bno = bno; }
	public int getBhit() { return bhit; }  
	public void setBhit(int bhit) { this.bhit = bhit; }
	public String getBname() { return bname; }  
	public void setBname(String bname) { this.bname = bname; }
	public String getBtitle() { return btitle; }  
	public void setBtitle(String btitle) { this.btitle = btitle; }
	public String getBcontent() { return bcontent; }  
	public void setBcontent(String bcontent) { this.bcontent = bcontent; }
	public String getBdate() { return bdate; }  
	public void setBdate(String bdate) { this.bdate = bdate; }
	public String getBip() { return bip; }  
	public void setBip(String bip) { this.bip = bip; }
	public String getBpass() {return bpass;}
	public void setBpass(String bpass) {this.bpass = bpass;}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", bhit=" + bhit + ", bname=" + bname + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bdate=" + bdate + ", bip=" + bip + ", bpass=" + bpass + "]";
	}

}
