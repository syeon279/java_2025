package com.ysh.board.board;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	// R
	@Query("select b from Board b order by id desc")
	List<Board> findAllBoard();
	
	@Query("select b from Board b where b.id = :id")
	Optional<Board> findById(Long id);
	
	// U
	@Transactional
	@Modifying
	@Query("update Board b set b.btitle= :btitle, b.bcontent= :bcontent where b.id= :id and b.bpass= :bpass")
	int updateByIdAndPass(String btitle, String bcontent, Long id, String bpass);
	
	@Transactional
	@Modifying
	@Query("update Board b set b.bhit = b.bhit + 1 where b.id= :id")
	int updateBhit(long id);
	
	// D
	@Modifying
	@Transactional
	@Query("delete from Board b where b.id= :id and b.bpass= :bpass")
	int deleteByIdAndPass(Long id, String bpass);
}
