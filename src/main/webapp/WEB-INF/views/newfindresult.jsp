<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page import="jp.co.house.model.NewHouseDataModel"%>
<%@ page import="jp.co.house.model.NewOneOption"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
	<h3>検索結果は以下の通りです:</h3><br>
	<c:forEach items="${DBJieGuo}" var="oneData">
		<c:out value="${oneData.id}"></c:out>
		<c:out value="${oneData.houseName}"></c:out>
		<c:out value="${oneData.price}"></c:out>
		<c:out value="${oneData.station}"></c:out>
		<c:out value="${oneData.distance}"></c:out>
		<c:out value="${oneData.houseType}"></c:out><br>
	</c:forEach>

</body>
</html>