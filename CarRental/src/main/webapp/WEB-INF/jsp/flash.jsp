<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>

  <style>
  a.two:link {color:#ff0000;}
  a.two:visited {color:#0000ff;}
  a.two:hover {font-size:120%;}
  h1 {
    text-align: center;
  }
  #customers {
    font-family: Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
  }

  #customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
  }

  #customers tr:nth-child(even){background-color: #f2f2f2;}

  #customers tr:hover {background-color: #ddd;}

  #customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #04AA6D;
    color: white;
  }
  </style>
  </head>
  <body>
    <h1>THE BOOKING DETAILS</h1>

    <br/><br/>
    <div>
      <table id="customers" border="1">
        <tr>
          <th>CAR ID</th>
          <th>BOOKED FROM</th>
          <th>BOOKED TO</th>
          <th>HASHCODE/th>

        </tr>
        <c:forEach  items="${model3}" var ="person">
        <tr>
          <form  method="post">
          <td>${person.userid}</td>
          <td>${person.bookedfrom} </td>
          <td>${person.bookedto} </td>
          <td>${person.hashcode} </td>
          </form>
        </tr>
        </c:forEach>
      </table>


          <br><br>
          <p><b><a class="two" href="http://localhost:8080/returnCar" >RETURN THE CAR</a></b></p>
    </div>
    <a>
  </body>

</html>