package com.thejoa.boot001;
 
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa.boot001.myjpa.LikeService;
import com.thejoa.boot001.myjpa.Post;
import com.thejoa.boot001.myjpa.PostRepository;
import com.thejoa.boot001.myjpa.User;
import com.thejoa.boot001.myjpa.UserRepository; 

@SpringBootTest
public class LikedServiceTest {
  @Autowired UserRepository   userRepository;
  @Autowired PostRepository   postRepository;
  @Autowired LikeService      likedService;
  

  @Disabled 
  @Transactional
  @Commit
  public void  testLikedPost() {
	  // 사용자생성
	  User user  = new User();  user.setUsername("first");   
	  userRepository.save(user);
	  
	  // 게시글생성
	  Post post  = new Post();  post.setContent("first board");
	  postRepository.save(post);
	  
	  // 좋아요 추가
	  likedService.likePost(user.getId(), post.getId());
	  
	  // 사용자의 likedPosts에서 게시글추가확인
      User updatedUser = userRepository.findById(user.getId()).orElseThrow();
      assertTrue(updatedUser.getLikedPosts().contains(post));

	  // 게시글의 likedUsers에서 사용자추가확인
      Post updatedPost = postRepository.findById(post.getId()).orElseThrow();
      assertTrue(updatedPost.getLikedUsers().contains(user));
      //import static org.junit.jupiter.api.Assertions.assertTrue;
  }
  
  
  @Disabled @Test
  @Transactional
  @Commit
  public void  testLikedPostCount() { // 좋아요갯수
	  System.out.println( likedService.getLikeCount(2L));   //있는번호 확인  1
  }
  
  @Test
  @Transactional
  @Commit
  public void  testUnLikedPost() {
	  // 사용자생성
	  User user  = new User();  user.setId(1L); 
	  // 게시글생성
	  Post post  = new Post();   post.setId(2L); 
	  
	  // 좋아요 추가
	  likedService.unlikePost(user.getId(), post.getId());
	  
	  // 사용자의 likedPosts에서 게시글추가확인
      User updatedUser = userRepository.findById(user.getId()).orElseThrow();
      assertTrue(updatedUser.getLikedPosts().contains(post));   //false  좋아요 관계삭제해서요....

	  // 게시글의 likedUsers에서 사용자추가확인
      Post updatedPost = postRepository.findById(post.getId()).orElseThrow();
      assertTrue(updatedPost.getLikedUsers().contains(user));  //false   좋아요 관계삭제해서요....
      //import static org.junit.jupiter.api.Assertions.assertTrue;
  }
  
}
