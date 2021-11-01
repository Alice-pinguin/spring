<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            <%@include file="/WEB-INF/view/css/style.css" %>
        </style>
    </head>

    <body>
        <div class="navbar">
          <a href="${pageContext.request.contextPath}/">Home</a>

          <div class="dropdown">
            <button class="dropbtn">Admin tools
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <a href="${pageContext.request.contextPath}view/manufacturers/form/add">Create Manufacturer</a>
                <a href="${pageContext.request.contextPath}view/products/form/add">Create Product</a>
                <a href="${pageContext.request.contextPath}view/user/findAllUsers">Find All User</a>
            </security:authorize>
            </div>
          </div>

          <div class="dropdown">
            <button class="dropbtn">Common tools
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}view/manufacturers/findAllManufacturers">Find All Manufacturers</a>
                <a href="${pageContext.request.contextPath}view/products/findAllProducts">Find All Products</a>
            </div>
          </div>

          <div style="display: flex; justify-content: flex-end">
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
          </div>
        </div>
    </body>
</html>
