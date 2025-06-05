import React, { useState, useCallback, useEffect } from "react";
import PropTypes from "prop-types"; // 넘겨받은 데이터 확인
import { Button, Input } from 'antd'; // 화면 디자인
import { useSelector } from "react-redux"; // 중앙저장소
import TextArea from "antd/lib/input/TextArea";
import Link from 'next/Link';

const PostCardContent = ({ editMode, postData, onChangePost, onCancelUpdate }) => {
    const { updatePostLoading, updatePostDone } = useSelector(state => state.post); // 중앙저장소 상태
    const [editText, setEditText] = useState(postData); // 글 받아서 수정 - 변수: 글수정, react 알려: 글 수정반영
    const onChangeText = useCallback((e) => {
        setEditText(e.target.value); console.log('🦾 editText : ', editText);
    }, [editText]); // 글 수정 event반영


    useEffect(() => { if (updatePostDone) { onCancelUpdate(); } }, [updatePostDone]);

    const onClickCancel = useCallback(() => { setEditText(postData); onCancelUpdate(); }, []); // 수정취소
    // .......................code

    // .......................view
    return (
        <div>
            {editMode ? (
                <>
                    <TextArea value={editText} onChange={onChangeText} />
                    <Button.Group  >
                        <Button style={{ margin: '3%' }} loading={updatePostLoading} onClick={() => onChangePost(editText)()}>수정</Button>
                        <Button style={{ margin: '3%' }} type='primary' onClick={onClickCancel}>취소</Button>
                    </Button.Group>
                </>
            ) : (postData
                .split(/(#[^\s#]+)/g)
                .map((v, i) => {
                    if (v.match(/(#[^\s#]+)/)) {
                        return <Link href={`/hashtag/${v.slice(1)}`} prefetch={false} key={`${v}-${i}`}>{v}</Link>
                    }
                    return <span key={`text-${i}`}>{v}</span> // 텍스트에도 key 추가 
                }))
            }
        </div>
    );
}

PostCardContent.propTypes = {
    postData: PropTypes.string.isRequired,
    editMode: PropTypes.bool,
    onChangePost: PropTypes.func.isRequired,
    onCancelUpdate: PropTypes.func.isRequired,
};
PostCardContent.defaultProps = {
    editMode: false,
};

export default PostCardContent;