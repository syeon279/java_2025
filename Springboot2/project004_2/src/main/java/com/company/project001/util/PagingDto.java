package com.company.project001.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PagingDto {
   private int listtotal;    // 전체 글 123 
   private int onepagelist;  // 한페이지에 보여줄 게시물의 수 10
   private int pagetotal;    // 총 페이지 수는 123/10 = 13
   private int bottomlist;   // 하단의 페이지 나누기 이전 11 12 13 
   
   private int pstartno; 	// 페이지의 스타트 번호 1page : 최신글 0번째부터 9개      
   private int current;     // 현재 페이지 번호
   private int start;     	// 시작 페이지 번호
   private int end;        	// 끝 페이지 번호 
   
   public PagingDto(int listtotal, int pstartno) {   
      super();
      this.listtotal   = listtotal;  // 전체 페이지 계산한 ㄱ값
      this.pstartno = pstartno*10;   // limit 0,10 10,10  20,10 
      this.onepagelist = 10;   
      if(this.listtotal <=0) {this.listtotal=1;} // 글이 없으면 1로
      this.pagetotal = (int) Math.ceil(listtotal/(double)onepagelist) ; // 123/10 = 13 
      
      this.bottomlist=10;  // 1(0)  2(10)  3(20)
      this.current = (this.pstartno/this.onepagelist) +1;     
      //현재 페이지가 pstartno가 10 라면 2
      //현재 페이지가 pstartno가 20 라면 3
      this.start = ((this.current-1)/this.bottomlist) * this.bottomlist+1;  
      // 11  15(현재)   20
      // 11을 11로, 15를 11로, 20을 11로 계산해야함 -> 앞자리는 1로 , 10으로 나누면 
      this.end = this.start + this.bottomlist -1;  
      // 11을 20으로 만들기 
      if( this.pagetotal < this.end ) { this.end=  this.pagetotal; } 
   } 
   
}





