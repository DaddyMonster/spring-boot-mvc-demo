<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="../common/base.jspf"%>
    <title>Edit Post</title>
</head>

<body>
    <h1>Data : ${boardDto.toString()}</h1>
</body>
<script>
    $(document).ready(function () {
        console.log("${boardDto.toString()}")
    })
</script>

</html>