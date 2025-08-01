### 01. Docker 설치
1. wsl
```bash
wsl  --install       # wsl2 활성화
wsl  --update      # 리눅스커널 업데이트
```
2. docker
```bash
wmic os get osarchitecture
``` 
- 64-bit ,  x64 (AMD64)
- ARM64(ARM64)
- https://www.docker.com/products/docker-desktop

3. docker 실행
```bash
docker version
```

### 02. Docker 기본명령어
```bash
docker  ps  -a    #모든 컨테이너확인
docker  images    #로컬 이미지목록
docker  --help    #명령어 확인
```
### 03. 컨테이너 생성/실행/삭제
```bash
docker run  -d  --name  web-server httpd 
# httpd 컨테이너를 백그라운드(-d)로 생성 및 실행(run) 
docker ps   -a   # 모든컨테이너 목록확인
docker stop  web-server  # 컨테이너중지
docker start web-server  # 컨테이너시작
docker rm    web-server  # 컨테이너삭제
```

### 04. 포트설정 실습
```bash
docker run  -d  -p 8080:80 --name apache  httpd
```
➡️ 브라우저 접속   http://localhost:8080

`-d` : 컨테이너를 백그라운(Detached) 모드로 실행
`-p 8080:80`  : 호스트의  8080포트를 컨테이너의 80 포트로 연결
`--name apache` : 컨테이너이름설정
`httpd`  :사용할이미지이름


### 05. nginx / mysql 컨테이너 실행
```bash
docker  run  -d -p 8888:80   --name nginx-test  nginx
# 8888포트를  80포트로 연결  nginx 컨테이너 실행
docker  run  -d --name mysql-test -e MYSQL_ROOT_PASSWORD=1234   mysql
# MYSQL_ROOT_PASSWORD 환경변수로 MYSQL 컨테이너 실행
```
➡️ 브라우저 접속   http://localhost:8888

```bash
docker ps -a   # mysql-test 컨테이너가 'Up' 상태인지 확인
docker exec   -it  mysql-test  mysql -uroot -p
비밀번호 1234
select  version()
```
`-it`   i(표준입력) , t(가상터미널)




### 06.  Volume 마운트
- 

```bash
pwd   # 내위치 확인
mkdir  html  # html 폴더만들기
docker  run  -d  -v $(pwd)\html:/usr/local/apache2/htdocs/ -p 8080:80 httpd
# Bind Mount 방식 : 호스트의 html 폴더를 컨테이너의 웹서버폴더에 연결
```
```
docker run -d -v D:\sohyeon_java_2025\html:/usr/local/apache2/htdocs/ -p 8888:80  httpd

docker exec -it  1ea993082ef8  /bin/bash
cd  /usr/local/apache2/htdocs/
ls -l
exit
```


➡️ 브라우저 접속   http://localhost:8080



### 07.  Docker 이미지생성
docker  run  -d   -v  D:\sohyeon_java_2025\html:/usr/local/apache2/htdocs/   -p 8080:80  --name apache  httpd

```bash
docker commit  apache  custom-apache
```
- 지금 이 컨테이너 상태를 이미지로 저장


### 08. Docker Hub 연동
1.  https://hub.docker.com  - 회원가입
2.  이미지 올리기
```
docker  tag custom-apache   도커허브아이디/custom-apache
docker  login
docker  push     도커허브아이디/custom-apache
```  

docker  tag custom-apache   syeonblue/custom-apache
docker  login
docker  push     syeonblue/custom-apache

### 09. 컨테이너끼리의 연결
```bash
docker network create wp-net

docker run -d --name mysql-wp --network wp-net `
  -e MYSQL_ROOT_PASSWORD=1234 `
  -e MYSQL_DATABASE=wordpress `
  mysql

docker run -d --name wordpress --network wp-net `
  -e WORDPRESS_DB_HOST=mysql-wp `
  -e WORDPRESS_DB_USER=root `
  -e WORDPRESS_DB_PASSWORD=1234 `
  -e WORDPRESS_DB_NAME=wordpress `
  -p 8081:80 wordpress
```
➡️ http://localhost:8081

### 10. docker ( spring + tomcat + mysql + react ) docker로 구성
1. 구조

2. docker-compose.yml
```
```

3. build
```
docker-compose up -d --build
``` 

4. 컨테이너 확인
```bash
docker ps
```