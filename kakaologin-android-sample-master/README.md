# kakaologin-android-sample

<img width="235" alt="kakao" src="https://user-images.githubusercontent.com/46569798/116001197-39998180-a62e-11eb-9d06-24e1c895fb06.png">

## [Layout]
### 1. 첫번째 버튼 - 로그인
### 2. 두번째 버튼 - 로그아웃

## [Activity]
### 1. GlobalActivity
- KakaoSdk 초기화 : Native app 키 사용

### 2. MainActivity
- 로그인
  - 토큰 생성 -> Error 레벨 : 토큰 출력
  - 사용자 정보(회원번호, 이메일) - Error 레벨 : 정보 출력
  
- 로그아웃
  - 정상 로그아웃 시 -> 토큰 삭제됨

## [Custom]
### 1. MainActivity > getKeyHash()의 키해시 값 : [내 애플리케이션 > 앱 설정 > 플랫폼] 에 등록

### 2. AndroidManifest.xml 
- line 35 : Redirect URI 수정
  </br>ex) https://example.com/oauth -> "oauth" 입력
- line 36 : Kakao app 키 입력

### 3. GlobalActivity 
- line 15 : Native app 키 입력

### 3. values > strings.xml
- line 2 : Native app 키 입력
