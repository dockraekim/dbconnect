<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sensor</title>
</head>
<body>
	<h1>sensor</h1>
	<table>
     <tr>
        <td>Sensor ID</td>
        <td>온도</td>
        <td>습도</td>
        <td>미세먼지</td>
        <td>초미세먼지</td>
        <td>극초미세먼지</td>
        <td>이산화탄소</td>
        <td>TVOC</td>
        <td>Date</td>
    </tr>
	<c:forEach items="${sensorList}" var="sensorList" varStatus="vs">
    <tr>
        <td>${sensorList.sensorId}</td>
        <td>${sensorList.temp}</td>
        <td>${sensorList.humidity}</td>
        <td>${sensorList.tm1}</td>
        <td>${sensorList.tm2_5}</td>
        <td>${sensorList.tm10}</td>
        <td>${sensorList.co2}</td>
        <td>${sensorList.tvoc}</td>
        <td>${sensorList.date}</td>
    </tr>
    </c:forEach>
</table>

		<c:if test="${pageMaker.prev}">
			<li class="paginate_button previous"><a href="${pageMaker.startPage-1}">이전</a>
            </li>
		</c:if>

		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' :''}">
            	<a href="${num}">${num}</a>
            </li>
		</c:forEach>

		<c:if test="${pageMaker.next}">
			<li class="paginate_button next"><a href="${pageMaker.endPage+1}">다음</a>
            </li>
		</c:if>


</body>
</html>