<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      xmlns:th="http://www.thymeleaf.org"
      layout:decorate="~{fragments/layout}">
<head>
    <title>Index</title>
</head>
<body>
<%--<jsp:include page="common/header.jsp"/>--%>

<%--<div layout:fragment="content" th:remove="tag">--%>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1>Hello Spring Security</h1>
            <h2>This is an secured page, but you can access the secured pages after authenticating.</h2>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h3> To access this page please login first </h3>
            </c:if>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <ul>
                <li>Go to the <a href="/success" th:href="@{/success}">Success pages</a></li>
            </ul>
            <ul>
                <li>Go to the <a href="/welcome" th:href="@{/welcome}">Welcome page</a></li>
            </ul>

            <ul>
                <li>Go to the <a href="/signup" th:href="@{/signup}"> Create New User</a></li>
            </ul>

            <ul>
                <li>Go to the <a href="/userList" th:href="@{/userList}"> User List</a></li>
            </ul>
            <ul>
                <li>Go to the <a href="/user/getAllUser" th:href="@{/user/getAllUser}">User List Redis Test</a></li>
            </ul>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <ul>
                    <li>Go to the <a href="/login" th:href="@{/login}">Log-in page</a></li>
                </ul>

                <ul>
                    <li>Go to the <a href="/signup" th:href="@{/signup}">Sign-up Here</a></li>
                </ul>

            </c:if>

            <ul>
                <li>Click here <a href="/swagger-ui.html" th:href="@{/swagger-ui.html}"> Swagger </a> to show Swagger
                    Implementation
                </li>
            </ul>
            <ul>
                <li>Click here <a href="/browser/index.html#/actuator" th:href="@{//browser/index.html#/actuator}">
                    Actuator </a> to show Actuator
                    Implementation
                </li>
            </ul>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <h2>Welcome ${pageContext.request.userPrincipal.name} | <a
                        onclick="document.forms['logoutForm'].submit()">Logout</a>
                </h2>
            </c:if>

        </div>
    </div>
</div>
</body>
</html>