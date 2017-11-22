<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>小马论坛登录</title>
    </head>
    <body>
        <c:if test="${!empty error}">
            <font color="red"><c:out value="${error}" /></font>
        </c:if>
        <%--c：url在url前自动加上应用部署根目录--%>
        <form action="<c:url value='/a/loginCheck.html' />" method="post">
            用户名：<input type="text" name="userName">
            <br>
            密码：<input type="password" name="password">
            <br>
            <input type="submit" value="登录">
            <input type="reset" value="重置">
        </form>
    </body>
</html>
