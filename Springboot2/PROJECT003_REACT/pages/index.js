import React, { useState } from 'react';
import axios from 'axios';
const Index = () => {
    const [form, setForm] = useState({ username: '', password: '' });
    const [info, setInfo] = useState(null);
    const [message, setMessage] = useState('');

    const handleChange = (e) => { setForm({ ...form, [e.target.name]: e.target.value }); };
    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            //1. 로그인
            const res = await axios.post('http://localhost:8080/api/member/login', form);
            console.log('** 로그인 응답 : ', res.data);
            const token = res.data?.token;
            if (!token) { setMessage('토큰이 응답에 없습니다. '); return; }

            localStorage.setItem('jwtToken', token);
            setMessage('로그인성공!');

            //2. 마이페이지
            const me = await axios.get('http://localhost:8080/api/member/me'
                , { headers: { Authorization: `Bearer ${token}` } });
            setInfo(me.data);

        } catch (err) {
            const msg = err.response?.data?.error || '로그인 실패';
            setMessage(`${msg}`);
            setInfo(null);
        }
    };

    ////////////////////////////////
    return (<div style={{ padding: '2em' }} >
        <h3> JWT 로그인 테스트</h3>
        {!info && (
            <form onSubmit={handleLogin}>
                <input
                    name="username" value={form.username} onChange={handleChange} placeholder="아이디"
                />
                <br />
                <input
                    name="password" type="password" value={form.password}
                    onChange={handleChange} placeholder="비밀번호"
                />
                <br />
                <button type="submit">로그인</button>
            </form>
        )}
        <div style={{ marginTop: '1em' }}> {message}  </div>

        {info && (
            <table>
                <caption>마이페이지</caption>
                <tbody>
                    <tr><th>아이디</th> <td> {info.username}</td></tr>
                    <tr><th>이메일</th> <td> {info.email}</td></tr>
                    <tr><th>닉네임</th> <td> {info.nickname}</td></tr>
                    <tr><th>권한 </th>  <td> {info.role}</td></tr>
                </tbody>
            </table>
        )}
    </div>);
};
export default Index;