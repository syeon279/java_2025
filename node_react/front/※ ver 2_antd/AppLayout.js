import React from 'react';   // react 불러오기
import PropTypes from 'prop-types';     // props 타입검사하는 역할 
import Link from 'next/Link';
import {Menu} from 'antd';

const AppLayout = ({children}) => {
    /////////////////////////////////// code
    const items = [
        { label: <Link href="/" >LOGO</Link> , key: '/' }, // remember to pass the key prop
        { label: <Link href="/profile" >프로필</Link>, key: '/profile' }, // which is required
        { label: <Link href="/signup" >회원가입</Link>, key:"/signup"}
    ];
    /////////////////////////////////// view
    return (<div>
        <Menu mode="horizontal" items={items} /> 
        {children}               {/* 하위 컴포넌트 동적 삽입 */}
    </div>);
};
AppLayout.propTypes = {
    children : PropTypes.node.isRequired // 태그들 필수 검사
};

export default AppLayout; 