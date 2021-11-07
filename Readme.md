# Spring-Boot 사용한 게시판 구현!

### #목표
스프링 및 스프링 Boot의 개략적인 이해와 적용
##### 필수 구현 조건
- User Authentication 구현
- 초 간단 게시판 CRUD 구현
- Spring MVC + Validation 익숙해지기
- 스프링 특유의 디자인 패턴 사용

##### 단계별 구현 목표
- 부분적 SPA 구현 (React.js, Vue.js)
- MSA(Micro Service Architecher) 구현
- JUnit 단위 테스트 구현
- CI/CD Pipeline 구축 (젠킨스 사용?)


## 학습 Process
- #### **토비의 스프링**
    - 멋도 모르고 잘 팔리는 책이라 구매함
    - 내용은 너무 좋으나 **빠르게 시작해보는 목적에 부합하지 않음**

- #### **Udemy**
     **Spring & Hibernate for Beginners (includes Spring Boot) by Chad Darby** https://www.udemy.com/course/spring-hibernate-tutorial/
    - 세일중에 구매하면 14,000원대. 
    - 핵심적인 개념들을 매우 상세히 잘 정리해줌
    - 초보자 대상이라 템포가 좀 느리다. Overview 부분들만 보고 나머진 참고만 하고 넘기면서 진행함.

##구현 상태
###### *@지속적 업데이트 예정*

#### 구현상태
	1. 로그인 및 회원가입 레디스 세션 방식으로 구현
	2. MySQL 사용, MyBatis 어노테이션 방식 Mapper 활용해 게시판 CRUD 구현
	3. 인터셉터 사용해 라우트별 인증유저 확인 로직 구현
	4. JQuery 적용 해봄 (...할곳이 별로 없었음...)
		- 자동완성이 없어 너무 불편... (package.json에 JQuery를 추가하니 Vs code에서 되긴 함)
	5. JSTL 사용해봄
		- 라이브러리도 자동완성이 너무 불편... (InteliJ 구입할까..?)

#### TO DO

	-  MyBatis 어노테이션 방식은 한계가 많음(이제 깨달음) => XML 방식으로 교체 후 DAO 생성;
	-  현재 이 프로젝트는 REDIS DATA 라이브러리 적용됨 => 실전에선 REDIS DATA REACTIVE 를 사용하는 것으로 보임 (시간나면 변경);
	-  Search 기능 적용 (일단은 SQL => 이후 Elastic Search 나 Algolia로);
	-  Board 불러올때 User 조인 아직 안해놓음 => 적용하고 board/index.jsp에 유저 이름 display 하기;
	-  Project 카피해서 특정 jsp 페이지에 React 나 Vue.js 적용해보기 (MPA는 유지);
	-  SCSS 혹은 SASS 적용시켜보기 (빌드과정에서 SASS => CSS 트랜스파일 하는 로직(혹은 라이브러리) 적용);
	-  Spring Security 적용;
	-  브라우저 location.history 사용하던지 ATTEMPED URL 세션에 저장해 로그인 이전 위치 기억;
	-  AOP로 로거 적용
	-  비번찾기 및 변경, Spring E-mail 기능이 있다던데... 찾아보고 적용;
	-  MSA 적용 ## Kafka || Nats streaming || RabbitMQ 적용해보기 (Redis Pubsub이 간단하긴 할듯..);
	-  Elastic Search 학습 후 검색에 적용해보기;
	... 이후 생각날때마다 추가
