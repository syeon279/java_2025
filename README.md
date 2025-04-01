##  🖥 AI 활용 풀스택 부트캠프(자바, 파이썬, 플러터) 
📅  2025.02.03 ~ 2025.08.12  
📝  Study Record 

---
<br>


### 🎯  SPRING
##### 📆 03.31.
🚩 Spring?
<table>
	<tr>
		<th rowspan="2" >Spring Framework</th>
		<td>[ 디자인 패턴 + 라이브러리 = 프레임워크]</td>
	</tr>
 	<tr>
		<td>소프트 웨어 개발의 뼈대</td>
	</tr>
 	<tr>
		<th rowspan="3" >Ioc</th>
		<td>Inversion of Control :제어의 역전</td>
	</tr>
 	<tr>
		<td>인스턴스의 생성~소멸까지 생명주기를 개발자가 아니라 컨테이너(스프링)가 하는 것</td>
	</tr>
	<tr>
		<td>POJO: Plain Old Java Object</td>
	</tr>
 	<tr>
		<th rowspan="3" >di</th>
		<td>Dependency Injection : 의존성 주입</td>
	</tr>
	<tr>
		<td> 각 클래스 간의 의존관계를 [설정파일]을 통해 [컨테이너]가 자동으로 연결 </td>
	</tr>
	<tr>
		<td> 장점: 코드 단순화, 결합도 제거 </td>
	</tr>
</table>

🚩 Setting
- dynamic web project
- configure - [Convert Maven Project]
- spring - add Spring project Nature
- java se-11 / project facts, build path
- build path - add Libraries - JUnit 4

🚩 Bean
-  Spring이 관리하는 객체
<table>
 	<tr>
		<th rowspan="6" >XML vs Annotation</th>
		<th rowspan="3"> XML [운영]</th>
	</tr>
 	<tr>
		<td>모든 bean을 명시적으로 xml에 등록</td>
	</tr>
	<tr>
		<td>여러 개발자가 같은 설정 파일을 공유해서 개발하면 수정시 충돌이 일어날 경우가 많음 </td>
	</tr>
 	<tr>
		<th rowspan="3" >Annotation <br/> (Bean Scanning)</th>
		<td>Bean @을 붙여서 자동인식</td>
	</tr>
	<tr>
		<td>개발속도 향상</td>
	</tr>
	<tr>
		<td> bean 간의 의존 관계를 파악하기 힘듦</td>
	</tr>
</table>
🚩 @Componnent 

```
@Componnent // 일반적인 컴포넌트
```

```
@Componnent //구체화된 형식
	@Controller(웹 요청을 받아서 응답)
	@Service(비즈니스 로직)
	@Repository(DB연동)
```


---
### 🎯  JSP
##### 📆 03.30.
🚨 pass가 맞지 않아도 글 삭제가 완료됨

```
<input type="hidden" name="bpass" value="${dto.bpass}" readonly >

<div>
	<label for="temppass" class="form-label">삭제하시려면 비밀번호를 입력해주세요. </label>
	<input type="text" class="form-control" id="temppass" placeholder="비밀번호를 입력하세요." name="temppass">
</div>

public class BDelete implements BoardService {
	String bpass = request.getParameter("bpass");
}
```

😀 오류 난 이유 == jsp의 파라미터를 가져와 늘 올바른 pass를 spl에 넘겨주게 됨

```
<input type="hidden" name="bpass" value="${dto.bpass}" readonly >

<div>
	<label for="temppass" class="form-label">삭제하시려면 비밀번호를 입력해주세요. </label>
	<input type="text" class="form-control" id="temppass" placeholder="비밀번호를 입력하세요." name="temppass">
</div>

public class BDelete implements BoardService {
	String bpass = request.getParameter("temppass");
}

```


##### 📆 03.28.
🚨 Error

```
switch(path) {
		case "/list.do" :
			System.out.println("list.do : C: 전체리스트 BList / V:list.jsp");
			break;
		case "/write_view.do": 
			System.out.println("write_view.do : 글쓰기 폼");
			break;
   			.
      			
   	}
```

😀 오류 == 문자열을 heap에 보관되기 때문에 주소값이 달라질 수 있음

```
 if(path.equals("/list.do")) {  //?
			 	service = new BList(); service.exec(request, response);
				request.getRequestDispatcher("board/list.jsp").forward(request, response);
		 	} else if(path.equals("/write_view.do")) { 
		 		request.getRequestDispatcher("board/write.jsp").forward(request, response);
		 	}
			.
			.
```


🚩 el: Expression Language (표현식)

```
<% 
Servlet001 s = new Servlet001 (1,2);
pageContext.setAttribute("s",s);
request.setAttribute("ss",s);
%>

<p> 객체.변수명 ${ s.a } </p>

```

🚩 jstl: JavaServer pasge Standard Tag Library

- 자바 코드 대신 태그로 웹페이지 작성

```
<c:if  test=></c;if>
<c:forEach items="" var=""></c:forEach>
```

🚩 list 최신글 번호 정렬하기

```
${ list.size() - status.index }
```



##### 📆 03.27.
🚩 Front Controller 패턴 아키텍쳐
<table> 
  <tr>
    <th  rowspan="3" > Front Controller </th>
    <td> 클라이언트가 보낸 요청을 받아서 공통작업(인증, 권한)을 먼저 수행 </td>
  </tr>
  <tr>
	<td> 적절한 세부 Controller에게 작업을 위임 </td>
  </tr>
  <tr>
	<td> 각각의 Controller는 요청작업 처리 + 뷰 선택 → 최종결과를 생성 </td>
  </tr>
</table>

💫  Step 1.

```
@WebServlet("*.do")   // 확장자가 '.do'면 Controller가 처리
```

💫 Step 2.

```
String path = request.getServletPath();   // 어떤 경로로 들어왔는지 확인
```

💫  Step 3.

```
switch(path) {
		case "/list.do" :
			System.out.println("list.do : C: 전체리스트 BList / V:list.jsp");
			break;
		case "/write_view.do": 
			System.out.println("write_view.do : 글쓰기 폼");
			break;
   			.
      			
   	}
```

🚨 Error

```
<form action="#" method = "get" onsubmit = "return form()">
	<div class="mb-3 mt-3">
	   <label for="name" class="form-label">이름: </label>
	   <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name">
	</div>
	<a href="" class="btn btn-outline-success m-1"> 올리기 </a>
```

😀 오류 난 이유 == "submit" 

```
<form action="#" method = "get" onsubmit = "return form()">
	<div class="mb-3 mt-3">
	   <label for="name" class="form-label">이름: </label>
	   <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name">
	</div>
	<button type="submit" title ="작성하기" class="btn btn-success m-1"> 올리기 </button>
```


##### 📆 03.26.
🚩 HTML 파일 분리하기(header, footer)
```
<%@ include file="jsp_header.jsp" %>
```

🚩 MVC2 
<table> 
  <tr>
    <th> MVC 모델 </th>
    <td>아키텍쳐 패턴(Model-View-Controller)</td>
    <td> 서로 영향없이 쉽게 고칠 수 있음 </td>
  </tr>
  <tr>
    <th> MVC2</th>
    <td> controller의 역할을 Servlet이 담당 </td>
    <td> View 와 Controller를 분리 </td>
  </tr>
  <tr>
    <th> 서블릿 맵핑 </th>
    <td> 경로를 맵핑하는 것 </td>
    <td></td>
  </tr>
</table>
🚨   session 

```
HttpSession session = request.getSession();
session.setAttribute("userid", id );
```

😀 오류 난 이유 == 객체 사용 잘못함 <br/>

```
request.setAttribute("userid", id);
```

🚩 DBCP <br/>
<table> 
  <tr>
    <th rowspan="3"> DBCP </th>
    <td>Database Connection Pool</td>
  </tr>
  <tr>
    <td>커넥션을 미리 생성함 </td>
  </tr>
  <tr>
    <td> 데이터 베이스 과부화를 줄임 </td>
  </tr>
</table>

##### 📆 03.25.
🚩 error, cookie, session  <br/>

- application(웹 어플리케이션 실행되고 있는 동안) > session(브라우저 종료) >request(요청) > page(해당 페이지)
- 객체.setAttribute("속성", "값") / 객체.getAttribute("속성")

```
application.setAttribute("name", " D.application - 웹 어플리케이션 실행 ");
```
```
session.setAttribute("name", " C.session - 브라우저 종료/ 로그인 후 아이디 유지 ");
```
```
request.setAttribute("name", " B.request - Ba.jsp -> b.jsp 요청할 때/ 현재 페이지에 요청 ");
```
```
pageContext.setAttribute("name", " A.현재페이지에서만 유지 ");
```
##### 📆 03.24.
🚩   내장객체
<table>
   <tr>
	   <th>내장 객체 </th>
	   <td>jsp 페이지가 웹컨테이너에 의해 서블릿으로 변환될 때 고정된 이름의 객체 컨테이너에 의해 자동으로 구현</td>
   </tr>
   <tr>
	   <th>요청과 응답</th>
	   <td>요청: 요청을 입력받는 페이지 <br/> 폼태그, 검색폼, 로그인 등 </td>
	   <td>응답: 요청을 처리한 후 요청 페이지로 응답을 보냄</td>
   </tr>
   <tr>
	   <th>Request</th>
	   <td>웹 브라우저에서 JSP 페이지로 전달되는 요청정보의 모임</td>
   </tr>
</table>
😀 페이지 이동하기 <br/>

```
location.href='jsp016_child.jsp'
```

```
response.sendRedirect("jsp016_child.jsp?userage=" + userage); //querystring
```

```
request.getRequestDispatcher("jsp016_adult.jsp").forward(request, response);
```


🤔 서블릿(Servlet) <br/>
- java를 사용하여 웹에서 동적으로 요청을 처리하는 서버 측 프로그램
- 클라이언트에서 보낸 요청을 받아서 처리한 후, 결과를 응답으로 보내주는 자바 프로그램

<br/>

🤔   forward() <br/>
- 현재 JSP 또는 서블릿에서 다른 JSP/서블릿으로 요청(Request)와 응답(Response)을 유지한 채 이동하는 방식
- 사용자가 보낸 요청을 유지한 채 서버 내부에서 페이지를 바꿔서 보여줌
-  ! 브라우저의 URL이 바뀌지 않음
-  ! request와 response 객체 유지 → 기존 요청 정보를 전달할 수 있음
-  ex) 로그인 처리 등


##### 📆 03.20.
🚩 우유 주문표 만들기
  <br> 😀 alert 창에 주문번호 띄우기 
  ```
    pstmt = conn.prepareStatement("select * from milk_order order by ono desc;");
			rset = pstmt.executeQuery();
			while(rset.next()){ 
			int no = rset.getInt("ono");
		 	out.println(" <script> alert('주문성공! 주문번호는 " + no + " 입니다.'); location.href='milk.jsp'; </script>");
			}
```
  😀 DB 연동
```
rset = pstmt.executeQuery(sql);  //select 구문에서만 사용
```
```
int result = pstmt.executeUpdate();   //sql- insert, update, delete 실행 줄 수 
```


##### 📆 03.19.
<table> 
  <tr>
    <th> MVC 모델 </th>
    <td>아키텍쳐 패턴(Model-View-Controller)</td>
    <td> 서로 영향없이 쉽게 고칠 수 있음 </td>
  </tr>
  <tr>
    <th> MVC1</th>
    <td> controller의 역할을 JSP가 담당 </td>
    <td></td>
  </tr>
</table>


##### 📆 03.18.
<table>
  <tr>
    <th rowspan="3">FORM</th>
  </tr>
  <tr>
    <td> <code> &lt;label&gt</label></code></td>
    <td> <code>for="kor"</code> → <code>id="kor"</code> 입력 필드와 연결 </td>
  </tr>
  <tr>
    <td><code> &lt;name&gt; </code></td>
    <td> 데이터를 서버로 보낼 때 변수 이름</td>
  </tr>
</table>
<table>
   <tr>
      <th rowspan="3">DB 연동</th>
   </tr>
   <tr>
      <td>드라이버 로드</td>
      <td><code>Class.forName("com.mysql.cj.jdbc.Driver")</code></td>
   </tr>
   <tr>
      <td>DB연동</td>
      <td><code>Connection conn = DriverManger.getConnection("url","id", "pass")</code></td>
   </tr>
</table>


---

### 🎯  MYSQL

#####  📆 03.23.
🚩 서브 쿼리
- select 구문안에 select 구문
- 서브쿼리 결과가 하나 이상이 반환시 in, any, all 사용

😀 '=' 는 값이 하나일 때만 사용 

```
select * from emp
where sal in ( select max(sal) from emp group by deptno );
```

```
select * from emp
group by deptno
having sal = ( select max(sal) from emp group by deptno );
```


#####  📆 03.22.
🚩 join 
```
-- 1. join
select a.no, a.name, a.age, b.ban
from join_userinfo `a`, join_userban `b`
where a.no = b.no;

-- 2. join on 
select  a.no, a.name, a.age, b.ban
from join_userinfo `a` join join_userban `b` on ( a.no = b.no );

-- 3. join using
select  a.no, a.name, a.age, b.ban
from join_userinfo `a` join join_userban `b` using(no);

-- 4. natural join 
select no, name, age, ban
from join_userinfo natural join join_userban;

```


##### 📆 03.21.
🚩 select : Number, String, Date, if/case <br>
🚨   null 사용
```
select sns, if( sns='n', 1, null) `SNS 수신 거부 수 `
from if_userinfo;
```


##### 📆 03.20.
- select : order by + limit
 ```
 select	  필드 1, 필드 2 
 from  	  테이블명
 where	  조건식
 order by  기준필드 [asc(1,2,3 오름차순) | desc(3,2,1 내림차순)]
 limit 	  몇개 
```
- select : 집계 함수   &emsp;&emsp;&emsp;     🚨 순서 기억하기
```
select	  필드 1, 필드 2 
from  	  테이블명
where	  조건식
group by  그룹핑 
having	  조건식 
order by  기준필드 [asc(1,2,3 오름차순) | desc(3,2,1 내림차순)]
limit 	  몇개 
    
avg(컬럼명) 평균, max 최대값, min 최소값, sum 합계, count 갯수 
```


##### 📆 03.19.
- select
   > 전체 데이터&emsp;``` select * from (table)``` <br>
   > 부분 검색  &emsp;``` select (필드명) from (table)```  <br>
   > 중복 제거  &emsp;``` select distinct (필드명) from (table)```  <br>
   > where 조건&emsp;``` =, !=, <>, between, or, in, is null, is not null, like ```

   
##### 📆 03.18.
- CRUD (INSERT, UPDATE, DELETE)

  
##### 📆 03.17.
- mysql DDL
- mysql DML



<br>
<br>

-----

<br>
<br>

### 🎯 JAVA
<table>
   <tr>
      <th rowspan="6">📆</th>
   </tr>
   <tr>
      <th> 03.14. </th>
      <td>Thread</td>
      <td>Network</td>
      <td>Server&Client</td>
      <td></td>
   </tr>
   <tr>
      <th> 03.13. </th>
      <td>Java I/O</td>
      <td>Network</td>
      <td>Bank Project - ArrayList</td>
      <td></td>
   </tr>
   <tr>
      <th> 03.12. </th>
      <td>Lambda</td>
      <td>Stream</td>
      <td> Java I/O</td>
      <td>Bank Project - interface <br>
   결과: https://youtu.be/zPJs-blYw8U</td>
   </tr>
   <tr>
      <th> 03.11.</th>
      <td>Map</td>
      <td>Lambda</td>
      <td> Bank Project </td>
      <td></td>
   </tr>
   <tr>
      <th> 03.10. </th>
      <td> Collection Framework </td>
      <td> List </td>
      <td> Set </td>
      <td>  Self Test </td>
   </tr>
</table>   
<table>
   <tr>
      <th rowspan="5">📆</th>
   </tr>
   <tr>
      <th> 03.07.</th>
      <td>Interface</td>
      <td>익명객체</td>
      <td>Exception</td>
   </tr>
   <tr>
   <th>03.06.</th>
    <td>Abstract</td>
    <td>Interface</td>
    <td>UML</td>
   </tr>
   <tr>
      <th> 03.05. </th>
      <td>상속</td>
      <td>다형성</td>
      <td></td>
   </tr>
   <tr>
      <th>03.04.</th>
      <td>Class Array</td>
      <td>Modifier</td>
      <td>Self Test</td>
   </tr>
</table>
<table>
   <tr>
      <th rowspan="6">📆</th>
   </tr>
    <tr>
      <th>02.28.</th>
      <td>Class</td>
      <td>Static</td>
      <td></td>
      <td></td>
   </tr>
   <tr>
      <th>02.27.</th>
      <td>Method</td>
      <td>OOP</td>
      <td>Class</td>
      <td>Bank MiniProject - version3</td>
   </tr>
     <tr>
      <th>02.26.</th>
      <td>Method</td>
      <td>Method로 성적 계산기만들기</td>
      <td></td>
      <td></td>
   </tr>
    <tr>
      <th>02.25.</th>
      <td>2차원 배열</td>
      <td>이중 for문</td>
      <td>누적 데이터 계산하기</td>
      <td></td>
   </tr>
   <tr>
      <th>02.24.</th>
      <td>while, dowhile</td>
      <td> Bank-miniproject Upgrade -> 잔액이 마이너스 되지 않도록 하기, 중복코드 줄이기<br></bt>결과물: https://youtu.be/HVE4COAvGO0</td>
      <td>Array</td>
      <td></td>
   </tr>
</table>   
<table>
   <tr>
      <th rowspan="6">📆</th>
   </tr>
   <tr>
      <th>02.21.</th>
      <td>For - 무한 반복문 만들기</td>
      <td>if-else -> 삼항 연산자로 처리</td>
      <td>Bank - miniproject -> id 비교는 임시아이디 변수 만들기</td>
   </tr>
   <tr>
      <th>02.20. </th>
      <td>If</td>
      <td>switch</td>
      <td>계산식에서 나누기만 정수로 표현하기 -> String 이용</td>
   </tr>
   <tr>
   <th>02.19. </th>
    <td>Casting</td>
    <td>Operating</td>
    <td>OperatorEx002.java => .charAt() 오류해결</td>
   </tr>
   <tr>
      <th>02.18. </th>
      <td>Datatype</td>
      <td>print</td>
      <td>var</td>
   </tr>
   <tr>
      <th>02.17. </th>
      <td>welcome!</td>
      <td>git (로컬 저장소 - 원격 저장소)</td>
      <td>java(설치, eclips)</td>
   </tr>
</table>
