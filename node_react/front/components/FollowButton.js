import React, { useCallback } from 'react'; // 부품객체
import { Button } from 'antd'; //디자인
import { followLoading, unfollowLoading } from '../reducers/post';
import PropTypes from 'prop-types'; // 넘겨받은 데이터 포스트
import { useSelector, useDispatch } from 'react-redux'; // 중앙 저장소
import { FOLLOW_REQUEST, UNFOLLOW_REQUEST } from '../reducers/user'; // 액션타입

const FollowButton = ({ post }) => {
    /////////////// code
    const dispatch = useDispatch();
    const { user, followLoading, unfollowLoading } = useSelector(state => state.user);
    const isFollowing = user?.Followings.find((v) => v.id === post.User.id);
    const onClikcFollow = useCallback(() => {
        console.log('🧪 현재 user 상태:', user);

        if (isFollowing) { // 팔로잉 - 내친구
            console.log('🟡 클릭한 포스트:', post);
            console.log('🟡 post.User.id:', post?.User?.id);
            console.log('🟡 로그인 유저 ID:', user?.id);
            dispatch({
                type: UNFOLLOW_REQUEST,
                data: post.User.id,
            })
        } else { // 팔로잉 - 내친구x
            console.log('🟡 클릭한 포스트:', post);
            console.log('🟡 post.User.id:', post?.User?.id);
            console.log('🟡 로그인 유저 ID:', user?.id);
            dispatch({
                type: FOLLOW_REQUEST,
                data: post.User.id,
            })
        }
    }, [isFollowing]);

    ////////////// view
    return (
        <Button
            loading={followLoading || unfollowLoading}
            onClick={onClikcFollow}>
            {isFollowing ? '언팔로우' : '팔로우'}
        </Button>
    );
}

FollowButton.propTypes = {
    post: PropTypes.object.isRequired,
}
export default FollowButton;