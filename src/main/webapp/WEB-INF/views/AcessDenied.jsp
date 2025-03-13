<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- Created By CodingNepal - www.codingnepalweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> SpringSecurity | RoleBased</title> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
   </head>
<body>
  <nav>
    <div class="menu">
      <div class="logo">
        <a href="#">SpringSecurity Role Based </a>
      </div>
      <ul>
        <li><a href="/home">Home</a></li>
        <li><a href="/admin/students/reg">Register</a></li>
        <li><a href="/students/getAll">GetAll</a></li>
        <li><a href="#">Contact</a></li>
        <li><a href="/logout">Logout</a></li>
      </ul>
    </div>
  </nav>
  <div class="img"></div>
  <div class="center">
    <div class="title">you dont have the premission to acess the </div>
    <div class="sub_title">Features </div>
   <!-- <div class="btns">
      <button>Learn More</button>
      <button>Subscribe</button>
    </div>-->
  </div>
</body>
</html>