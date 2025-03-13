<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- Created By CodingNepal - www.codingnepalweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Website Layout | CodingLab</title> 
    
   </head>
<body>
  <nav>
    <div class="menu">
      <div class="logo">
        <a href="#">CodingLab</a>
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
    <h2>Student Registration</h2>
    <form action="saveStudent" method="post" modelAttribute="student">
      <h2>Form Validation</h2>
      <div class="form-group fullname">
        <label for="fullname">Full Name</label>
        <input type="text" id="fullname" name="name" placeholder="Enter your full name">
      </div>
      <div class="form-group email">
        <label for="email">Email Address</label>
        <input type="text" id="email" name="mailId" placeholder="Enter your email address">
      </div>
      <div class="form-group password">
        <label for="password">Branch</label>
        <input type="password" id="password" name="branch"  placeholder="Enter your password">
        <i id="pass-toggle-btn" class="fa-solid fa-eye"></i>
      </div>
      <div class="form-group date">
        <label for="date">Birth Date</label>
        <input type="date" id="date" name="dateOfBirth" placeholder="Select your date">
      </div>
      <div class="form-group gender">
        <label for="gender">Gender</label>
        <select id="gender" name="gender">
          <option value="" selected disabled>Select your gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
      </div>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <div class="form-group submit-btn">
        <input type="submit" value="Submit">
      </div>
    </form>
    <h3>${resp}</h3>
  </div>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</body>
</html>