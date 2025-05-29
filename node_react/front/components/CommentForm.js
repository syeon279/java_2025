import React, { useCallback , useEffect } from 'react';  //리액트
import { Button, Form, Input } from 'antd' // 디자인
import PropTypes from 'prop-types';   // 타입설정
import userInput from '../hooks/userInput'  // 사용자입력 - hooks
 
import { ADD_COMMENT_REQUEST } from '../reducers/post';   // request 요청
import { useDispatch , useSelector } from 'react-redux';

//--
const CommentForm = ({ post }) => {   // 어떤게시글에대한 댓글 
  const { addCommentLoading , addCommentDone  } = useSelector(state => state.post);  // 중앙저장소
  const id = useSelector(state => state.user.user?.id);  // 사용자체크
  const dispatch = useDispatch();
  ///////////////////////////////////// code  입력
  const [comment, onChangeComment, setComment] = userInput('');

  useEffect(() => {  if (addCommentDone) { setComment('');  }  }, [addCommentDone]);
  
  const onSubmitForm = useCallback(() => {  // 전송버튼시
    console.log(post.id, comment);
    if (!id) {   return alert('로그인이 필요합니다.');  }   // 로그인시 댓글달기
    dispatch({
      type: ADD_COMMENT_REQUEST,    //타입요청
      data: { content:comment , userId:id, postId:post.id }  
    })
  } , [comment, id]);
  ///////////////////////////////////// view
  return (
    <Form  onFinish={onSubmitForm}  style={{margin:50 , position:'relative'}}  >
      <Input.TextArea rows={5}   value={comment}  onChange={onChangeComment}   />
      <Button htmlType="submit"  style={{position:'absolute' , right:0 , bottom:-50}}   type="primary"  loading={addCommentLoading}  >댓글</Button>
    </Form>
  );
};
CommentForm.propTypes = {  post : PropTypes.object.isRequired  };
export default CommentForm;