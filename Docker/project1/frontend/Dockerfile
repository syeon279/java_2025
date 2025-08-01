FROM node:18

WORKDIR /app

# 의존성 설치
COPY package.json package-lock.json ./
RUN npm install

# 전체 소스 복사
COPY . .

# Next.js 빌드
RUN npm run build

# 포트 노출
EXPOSE 3000

# 프로덕션 서버 실행
CMD ["npm", "start"]
