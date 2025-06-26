package com.company.project001.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Board {
	private long id;
	private String btitle;
	private String bcontent;
	private String bfile;
	private String bip;
	private String bpass;
	private long bhit;
	private Date createDate;
	private Member member;
}

/*


*/