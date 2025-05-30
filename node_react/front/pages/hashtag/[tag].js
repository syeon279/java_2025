import axios from "axios";
import { useRouter } from "next/router";
import React, { useEffect, useState } from "react";
import AppLayout from "../../components/AppLayout";
import PostCard from "../../components/PostCard";

const Hashtag = () => {
    // ................. code
    const router = useRouter();
    const { tag } = router.query;
    const [mainPosts, setMainPosts] = useState([]);
    const [hasMorePosts, setHasMorPosts] = useState(true);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchPosts = async () => {
            try {
                setLoading(true);
                const reponse = await axios.get(
                    `http://localhost:3065/hashtag/${tag}`, { withCredentials: true }
                );
                setMainPosts(reponse.data);
                setHasMorPosts(reponse.data.length > 0);
            } catch (error) {
                setError(error);
                console.log('🚨 err: ', error);
            } finally {
                setLoading(false);
            }
        };
        if (tag) { fetchPosts(); }
    }, [tag]);

    // ................. scroll
    useEffect(() => {
        function onScroll() {
            // screenY pageYOffset 차이점 : 현재창에서 마우스커서 y / 페이지를 스트롤 측정 Y
            if (window.pageYOffset + document.documentElement.clientHeight > document.documentElement.scrollHeight - 200) {
                if (hasMorePosts && !loading) {
                    axios.get(`http://localhost:3065/hashtag/${tag}?listId=${mainPosts[mainPosts.length - 1]?.id}`, { withCredentials: true })
                        .then((response) => {
                            setMainPosts((prev) => [...prev, ...response.data]);
                            setHasMorPosts(response.data.length > 0);
                        })
                        .catch((err) => setError(err));
                }
            }
        }
        window.addEventListener('scroll', onScroll);
        return () => {
            window.removeEventListener('scroll', onScroll);  //스크롤했으면 스크롤했던거 remove, 메모리에 쌓임
        }
    }, [mainPosts, hasMorePosts, tag, loading]);

    if (loading) { return <div>해쉬태그 게시글 ing... </div> }
    if (error) { return <div>err...</div> }

    // ................. view
    return (<AppLayout>
        {mainPosts.map((c) => { return (<PostCard post={c} key={c.id} />); })}
    </AppLayout>);
};


export default Hashtag;