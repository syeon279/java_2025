import React, { useMemo } from 'react';
import { List, Button, Card } from 'antd';
import { PlusOutlined, HeartOutlined } from '@ant-design/icons';
import styled from 'styled-components';

const FollowList = ({ header, data, onClckMore, loading }) => {
    ///////////// code
    const style = useMemo(() => ({ margin: '3%', backgroundColor: 'white', padding: '3%' }), []);
    ///////////// view
    return (
        <List style={style}
            grid={{ gutter: 4, xs: 2, md: 3 }}
            size="small"
            header={<div>{header}</div>}
            loadMore={<div style={{ textAlign: 'center' }}><Button loading={loading}>더보기</Button></div>}
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