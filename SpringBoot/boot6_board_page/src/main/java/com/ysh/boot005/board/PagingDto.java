package com.ysh.boot005.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PagingDto {
	private int listTotal; // #1) 전체글 247
	private int onepagelist; // #2) 한페이지에 보여줄 게시물의 수 10
	private int pageTotal; // #3) 총페이지 수 247/10 = 25 24 + 마지막 7글=25
	private int bottomlist; // #4) 하단의 페이지 나누기 이전 11 12 13 ... 몇 개

	private int pstartno; // #5) 페이지의 스타트 번호 [1]: 최신글 0~10개

	private int current; // #6 현재 페이지 번호
	private int start; // #7 시작 페이지 번호
	private int end; // #6 마지막 페이지 번호

	public PagingDto(int listTotal, int pstartno) { // limit 0 10
		super();
		this.listTotal = listTotal;
		this.onepagelist = 10;

		// 247/10 = 25 => 24 + 마지막 7글=25
		if (this.listTotal <= 0) {
			this.listTotal = 1;
		}
		this.pageTotal = (int) Math.ceil(listTotal / (double) onepagelist);
		this.bottomlist = 10;
		this.pstartno = pstartno * 10;

		// 1(0) 2(10) 3(20) 4 [5] 6 7 8 9 10 다음
		// 이전 11 12 13 14 [15] 16 17 18 19 20 다음
		// partno=10 이라고 하면 현재페이지 번호2
		// partno=40 이라고 하면 현재페이지 번호5

		this.current = (this.pstartno / onepagelist) + 1;
		// 시작) 11 15 20 (20을 11로, 15를 11, 11을 11-> 앞자리는 1 -> 1*10 +1
		this.start = ((this.current - 1) / this.bottomlist) * this.bottomlist + 1;
		// 끝)
		this.end = this.start + bottomlist - 1;
		if (pageTotal < end) {
			this.end = pageTotal;
		}

	}

}
