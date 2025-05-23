import Reach from 'react';
import AppLayout from '../components/AppLayout';
//import 'antd/dist/antd.css'
import PostCard from '../components/PostCard';
import PostForm from '../components/PostForm';

import { useSelector } from 'react-redux';

const Home = () => {
    const { user } = useSelector(state => state.user);
    const { mainPosts } = useSelector(state => state.post);
    return (
        <AppLayout>
            {user && <PostForm />}
            {mainPosts.map((post) => {
                return (
                    <PostCard post={post} key={post.id} />
                );
            })}
        </AppLayout>);
};
export default Home; 