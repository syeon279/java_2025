##  🖥 AI 활용 풀스택 부트캠프(자바, 파이썬, 플러터) 
📅  2025.02.03 ~ 2025.08.12  
📝  Study Record 

---

<br>

### 🎯  JSP
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
   > where 조건&emsp;``` = != <> between or in is null is not null like ```
   
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
