import React from 'react';   // react 불러오기
import PropTypes from 'prop-types';     // props 타입검사하는 역할 
import Link from 'next/Link';
import { Menu } from 'antd';
import { Input, Space, Row, Col } from 'antd';
const { Search } = Input;

const AppLayout = ({ children }) => {
    /////////////////////////////////// code
    const items = [
        { label: <Link href="/" >LOGO</Link>, key: '/' }, // remember to pass the key prop
        { label: <Link href="/profile" >프로필</Link>, key: '/profile' }, // which is required
        { label: <Link href="/signup" >회원 가입</Link>, key: "/signup" },
        {
            label: <Input.Search
                placeholder="input search text"
                enterButton
                style={{ verticalAlign: 'middle' }} />, key: '/search'
        },
    ];
    /////////////////////////////////// view
    return (<div>
        <Menu mode="horizontal" items={items} />
        <Row gutter={8}>
            <Col xs={24} md={6}> 왼쪽 메뉴- 로그인폼 </Col>
            <Col xs={24} md={12} style={{ backgroundColor: '#efefef' }}> {children} </Col>
            <Col xs={24} md={6}> <div><a href="https://thejoa.com" target="_black" rel="noreferrer noopener"> TheJoa </a>
                copyrights. all reserved. </div> </Col>
        </Row>
    </div>);
};
AppLayout.propTypes = {
    children: PropTypes.node.isRequired // 태그들 필수 검사
};

export default AppLayout; 