import React from 'react';   // react 불러오기
import PropTypes from 'prop-types';     // props 타입검사하는 역할 

const AppLayout = ({children}) => {
    return (<div>
        <div>공통 메뉴</div>     {/* 공통 메뉴 */}
        {children}               {/* 하위 컴포넌트 동적 삽입 */}
    </div>);
};
AppLayout.propTypes = {
    children : PropTypes.node.isRequired // 태그들 필수 검사
};

export default AppLayout; 