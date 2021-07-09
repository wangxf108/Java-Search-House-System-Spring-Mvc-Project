<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page import="jp.co.house.model.NewHouseDataModel"%>
<%@ page import="jp.co.house.model.NewOneOption"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>不動産検索</title>
</head>
		<body>
		//post确认
		<f:form modelAttribute="DATA1" action="doFind" method="POST">

			追加したい条件にチェックをいれてください（複数選択できます）<br>



			賃料<f:select path="pricefrom">
					<f:options items="${FROMDATA}" itemValue="optValue" itemLabel="optText"/>
				</f:select>
				~
				<f:select path="priceto">
					<f:options items="${TODATA}" itemValue="optValue" itemLabel="optText"/>
				</f:select> <br>
			駅名<f:input path="station"/> <br>
			駅徒歩距離
			<f:radiobutton path="distance" value="1min"/>1分以内
			<f:radiobutton path="distance" value="5min"/>5分以内
			<f:radiobutton path="distance" value="noset"/>指定しない
			<br>
			間取りタイプ
			<f:checkbox path="type1" value="yes" />ワンルーム
			<f:checkbox path="type2" value="yes" />1DKL
			<f:checkbox path="type3" value="yes" />2DKL
			<f:checkbox path="type3" value="yes" />3DKL
			<br>
			<input type="submit" value="この条件で検索する">
		</f:form>
	</body>
</html>