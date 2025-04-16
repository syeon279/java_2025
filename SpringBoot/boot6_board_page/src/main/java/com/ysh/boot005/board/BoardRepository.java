package com.ysh.boot005.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long>{
		
	//4. Page
	Page<Board> findAll(Pageable pagealbe);


	//1. @Query 테이블명은 객체 파라미터를 지원함 = Entity class Board를 의미함 - select 구문에서 사용
	//@Query(value = "select *from board order by id desc", nativeQuery = true)
	@Query("select b from Board b order by id desc")
	List<Board> findAllByOrderByDesc();
	
	// 2. insert, update, delete - @Modifying @Transactional @Query 
	@Modifying // 2-1. 기본작업(=select) 삽입, 수정, 삭제 쿼리는 변경작업
	@Transactional //2-2. rollback을 활성화 시키는 기능 
	@Query("delete from Board b where b.id= :id and b.bpass= :bpass ") // b.id는 db에서  :id는 사용자 값
	int deleteByIdAndBpass(@Param("id") Long id, @Param("bpass") String bpass);
	// 2-3. @Param("id") 쿼리의 변수명과 동일하면 생략가능 
	// 2-4. deleteByIdAndBpass( Board board ); X 안쪽에는 객체 파라미터 지원 안함. 
	
	@Modifying 
	@Transactional 
	@Query("update Board b set b.btitle = :btitle, b.bcontent= :bcontent where b.id = :id and b.bpass = :bpass" )
	int updateByIdAndBpass(@Param("id") Long id, @Param("bpass") String bpass,  @Param("btitle") String btitle,
			@Param("bcontent") String bcontent);
}
//  https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation