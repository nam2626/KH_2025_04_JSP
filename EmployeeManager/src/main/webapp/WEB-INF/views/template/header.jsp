<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
  .navbar {
    background-color: #2a4373; /* 더 진한 남색 */
    overflow: hidden;
    display: flex;
    justify-content: center;
    padding: 10px 0;
    font-family: 'Arial', sans-serif;
  }

  .navbar a {
    color: white;
    padding: 14px 20px;
    text-decoration: none;
    text-align: center;
    font-weight: bold;
    transition: background-color 0.3s;
  }

  .navbar a:hover {
    background-color: #1d3055; /* hover 시 더 진하게 */
  }
</style>

<div class="navbar">
  <a href="${pageContext.request.contextPath }/main.do">전체 사원 목록 조회</a>
  <a href="${pageContext.request.contextPath }/insertEmployeeView.do">사원정보 추가</a>
  <a href="${pageContext.request.contextPath }/posList.do">전체 직급 목록 조회</a>
  <a href="#">직급정보 추가</a>
  <a href="${pageContext.request.contextPath }/deptList.do">전체 부서 목록 조회</a>
  <a href="#">부서정보 추가</a>
</div>
