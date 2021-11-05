<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Homework#8</title>
    <style>
        <%@include file="/WEB-INF/view/css/style.css" %>
    </style>
</head>
<body>
<c:import url="/WEB-INF/view/navigation.jsp"/>
<table cellpadding="5">
    <caption>
        <h2> List of Users </h2>
    </caption>
    <thead>
    <tr>
        <th align="left"> ID</th>
        <th align="left"> Firstname</th>
        <th align="left"> Lastname</th>
        <th align="left"> Email</th>
        <th align="left"> Role</th>
        <th align="left"> Status</th>
        <th align="left"> Password</th>
        <th colspan="2" align="center">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.userRole}</td>
            <td>${user.userStatus}</td>
            <td>${user.password}</td>
            <td align="center">
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="user/findUserById">
                        <button>Details</button>
                    </a>
                </security:authorize>
            </td>
            <td align="center">
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="user/form/update">
                        <button>Update</button>
                    </a>
                </security:authorize>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>