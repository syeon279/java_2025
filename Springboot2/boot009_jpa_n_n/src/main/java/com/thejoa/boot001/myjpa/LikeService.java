package com.thejoa.boot001.myjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {
	private final UserRepository   userRepository;
	private final PostRepository   postRepository;
	
	@Autowired
	public LikeService(UserRepository userRepository, PostRepository postRepository) {
		super();
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	
	//  좋아요추가
	@Transactional
	public void likePost( Long userId, Long postId) {
		User user = userRepository.findById(userId).orElseThrow( ()-> new RuntimeException("사용자 없음"));
		Post post = postRepository.findById(postId).orElseThrow( () -> new RuntimeException("게시글 없음"));
		
		user.getLikedPosts().add(post);
		post.getLikedUsers().add(user);
		
		userRepository.save(user);  //관계저장
	}
	// 좋아요 갯수
	public int getLikeCount(Long postId) {
		Post   post = postRepository.findById(postId).orElseThrow();
		return post.getLikedUsers().size();
	}
	
	// 좋아요 취소
	@Transactional
	public void unlikePost( Long userId, Long postId) {
		User user = userRepository.findById(userId).orElseThrow();
		Post post = postRepository.findById(postId).orElseThrow();
		
		user.getLikedPosts().remove(post);  //##
		post.getLikedUsers().remove(user);  //##
		
		userRepository.save(user);  //관계저장
	}
}


