<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<!-- Created By CodingNepal - www.codingnepalweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> SpringSecurity | RoleBased</title> 
    
   </head>
<body>
  <nav>
    <div class="menu">
      <div class="logo">
        <a href="#">SpringSecurity Role Based</a>
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
    <h2>Student Data</h2>
    <div>
    <table style="margin-left: 13%;width: 77%;     background: white;" >
      <tr style="background-color: #972a27;color: #FFFFFF;"><th >ID</th><th>Name</th><th>MailId</th><th>Department</th><th>DateOfBirth</th><th>Gender</th><th>EditAction</th><th>DeleteAction</th></tr>
      <c:forEach var="student" items="${list}">
          <tr>
              <td>${student.id}</td>
              <td>${student.name}</td>
              <td>${student.mailId}</td>
              <td>${student.branch}</td>
              <td>${student.dateOfBirth}</td>
              <td>${student.gender}</td>
              <td>
                  <a href="/students/edit/${student.id}">Edit</a>
              </td>
              <td>
                <a href="/admin/students/delete/${student.id}">Delete</a>
              </td>
          </tr>
      </c:forEach>
  </table>
  <div>${resp}</div>
</div>
  </div>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</body>
</html>