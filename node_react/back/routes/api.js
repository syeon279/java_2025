const express = require('express');
const axios = require('axios'); // 비동기
const router = express.Router();

const client_id = 'reu63fdeQl8IXmwLVsRM'; // 네이버 id
const client_secret = 'AvEnm8FcX2'; // 네이버 secret

router.get('/search', async (req, res) => {
    // url 주소
    const api_url = `https://openapi.naver.com/v1/search/blog?query=${encodeURIComponent(req.query.query)}`;

    try {
        const response = await axios.get(api_url, {
            headers: {
                'X-Naver-Client-Id': client_id,
                'X-Naver-Client-Secret': client_secret,
            }
        });

        res.status(200).json(response.data); // 응답 데이터를 JSON 형식으로 반환
    } catch (error) {
        console.error('API 요청 오류:', error.response ? error.response.data : error.message);
        res.status(error.response?.status || 500).json({ error: 'API 요청 실패' });
    }
});

module.exports = router;

