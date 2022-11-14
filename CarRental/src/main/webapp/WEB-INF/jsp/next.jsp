<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>

<style>
h1 {
  text-align: center;
}
a.two:link {color:#ff0000;}
a.two:visited {color:#0000ff;}
a.two:hover {font-size:150%;}

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
    <h1>AVAILABLE CARS</h1>

    <br/><br/>
    <div>
      <table id="customers" border="1">
        <tr>
          <th>CAR ID</th>
          <th>COMPANY</th>
          <th>MODEL</th>
          <th>TYPE</th>
          <th>FUEL TYPE</th>
          <th>PRICE</th>

        </tr>
        <c:forEach  items="${modeld}" var ="person">
        <tr>
          <form action="bill" method="post">

          <td><input type="text" name="id1" id="carId" value=${person.carId} ></td>
          <td><input type="text" id="company" value=${person.company} ></td>
          <td><input type="text" id="company" value=${person.model} ></td>
          <td><input type="text" id="model" value=${person.type} ></td>
          <td><input type="text" id="model" value=${person.fuel} ></td>
          <td><input type="text" id="model" value=${person.prize} ></td>

          <td> <input type="submit" value="book"> </td>
         </form>
        </tr>
        </c:forEach>
      </table>
      <br>
      <br>

      <p><b><a class="two" href="http://localhost:8080/sort" >SORT BY PRICES</a></b></p>
    </div>
  </body>

</html>