<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<link rel="stylesheet" href="/project/css/member/mypage/mypage_main.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	 <header>
		<%@ include file="../../include/header.jsp" %>
    </header> 
    <div class="mypage-div">
        <nav class="mypage-nav">
            <ul>
                <li><a href="/football/mypage">회원정보</a></li>
                <li><a href="mypage/board">게시글 </a></li>
                <li><a href="mypage/reply">댓글</a></li>
                <li><a href="mypage/goods">상품</a></li>
            </ul>
        </nav>

        <section>
            <header class="section-title">
                <p>회원정보</p>
            </header>

            <table>
                <tr id="id-area">
                    <td>
                        아이디
                    </td>
                    <td>
                    	<input type="hidden" class="hidden_id" value="${member.id }">
                        ${member.id }
                    </td>
                    <td>
                        <button class="changeId-btn" type="button">아이디 변경</button>
                    </td>
                </tr>

                 <!-- 아이디 변경 -->
                 <tr id="change-id-area">
                    <td>
                        아이디
                    </td>

                    <td colspan="2">
                       <div class="my-info-modify-div">
                           
                           <div class="input-div">
                               <label for="new-id">변경 아이디</label>
                               <input type="text" name="" id="new-id">
                           </div>
                           
                           <div class="btn-gropu-div">
                                <button id="cancelId-btn" class="btn" type="button">취소</button>
                                <button id="finishId-btn" class="btn" type="button">완료</button>
                           </div>
                       </div>
                    </td>
                </tr>

                <tr id="pwd-area">
                    <td>
                        비밀번호
                    </td>
                    <td>
                        ********
                    </td>
                    <td>
                        <button class="changePwd-btn" type="button">비밀번호 변경</button>
                    </td>
                </tr>

                <!-- 비밀번호 변경 -->
                <tr id="change-pwd-area">
                    <td>
                        비밀번호
                    </td>

                    <td colspan="2">
                       <div class="my-info-modify-div">
                           <div class="input-div">
                               <label for="current-pwd">현재 비밀번호</label>
                               <input type="password" name="" id="current-pwd">
                           </div>
                           <div class="input-div">
                               <label for="new-pwd">신규 비밀번호</label>
                               <input type="password" name="" id="new-pwd">
                           </div>
                           <div class="input-div">
                               <label for="confirm-pwd">신규 비밀번호 재입력</label>
                               <input type="password" name="" id="confirm-pwd">
                           </div>
                           <div class="btn-gropu-div">
                                <button id="cancelPwd-btn" class="btn" type="button">취소</button>
                                <button id="finishPwd-btn" disabled class="btn" type="button">완료</button>
                           </div>
                       </div>
                    </td>
                </tr>


                <tr id="name-area">
                    <td>
                        이름(실명)
                    </td>
                    <td colspan="2">
                        ${member.name }
                    </td>
                </tr>
                <tr>
                    <td>
                        이메일
                    </td>
                    <td colspan="2">
                        ${member.email }
                    </td>
                </tr>
                <tr id="regdate-area">
                    <td>
                        가입일자
                    </td>
                    <td colspan="2">
                        ${member.regdate }
                    </td>
                </tr>
            </table>
            <div style="margin-top: 10px;">
            	<button type="button">회원 탈퇴</button>
            </div>
        </section>

        <footer style="clear:both;width: 100%; height: 100px; background-color: brown;">
            
        </footer>
    </div>
</body>
<script src="/project/js/member/mypage/mypage_main.js"></script>
<script src="/project/js/member/mypage/changeNamePwd.js"></script>
</html>