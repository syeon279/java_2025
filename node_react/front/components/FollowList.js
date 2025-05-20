import React from 'react';
import { List, Button, Card } from 'antd';
import { PlusOutlined, HeartOutlined } from '@ant-design/icons';

const FollowList = ({ header, data }) => {
    ///////////// code

    ///////////// view
    return (
        <List style={{ margin: '3%', backgroundColor: 'white', padding: '3%' }}
            grid={{ gutter: 4, xs: 2, md: 3 }}
            size="small"
            header={<div>{header}</div>}
            loadMore={<div style={{ textAlign: 'center' }}><Button>더보기</Button></div>}
            dataSource={data}
            renderItem={(item) => (
                <List.Item style={{ marginTop: '10%' }}>
                    <Card actions={[<HeartOutlined key="user" />]}>
                        <Card.Meta title={item.nickname} />
                    </Card>
                </List.Item>
            )}
        >
            {/* () => () 맵 */}
        </List>
    );
}

export default FollowList;