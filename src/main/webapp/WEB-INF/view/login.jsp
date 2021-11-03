<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in with your account</title>
    <meta charset="utf-8">
    <link href="${contextPath}/WEB-INF/view/css/common.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css"
    integrity="2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <form method="POST" class="form-signing" action="login>">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <label>
                <input name="Email" type="text" class="form-control" required="required" placeholder="Email"/>
            </label><br/>
            <label>
                <input name="password" type="password" class="form-control" required="required" placeholder="Password"/>
            </label>
            <span>${error}</span>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="user/registration">Create an account</a></h4>
        </div>
    </form>
</div>
</body>
</html>