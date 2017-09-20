<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>대학교 홈페이지에 오신것을 환영합니다.</title>
<link rel="icon" href="/images/etc/icon.ico" type="image/x-icon">
<!-- <link rel="stylesheet" type="text/css" href="/css/default.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="/css/main.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="/css/board.css"> -->
<!-- <script src="/js/jquery.min.js"></script> -->

</head>
<body>
	<p>몸통</p>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="content" />
	<tiles:insertAttribute name="footer" />
</body>
</html>