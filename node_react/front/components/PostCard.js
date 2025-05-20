import React from 'react';
import { Card, Avatar, Button, List, Comment, Popover } from 'antd';
import { EllipsisOutlined, HeartOutlined, MessageOutlined, RetweetOutlined } from '@ant-design/icons';

const PostCard = () => {
    return (
        <div style={{ margin: '3%' }}>
            <Card
                cover={<img alt="expmple" src="https://gw.alipayobjects.com/zos/antfincdn/LlvErxo8H9/photo-1503185912284-5271ff81b9a8.webp"></img>}
                actions={[
                    <HeartOutlined />,
                    <RetweetOutlined />,
                    <MessageOutlined />,
                    <Popover content={(
                        <Button.Group>
                            <Button>수정하기</Button>
                            <Button type='primary'>삭제하기</Button>
                        </Button.Group>
                    )}  >
                        <EllipsisOutlined />
                    </Popover>
                ]}
            >

            </Card>
        </div>
    );
};

export default PostCard;