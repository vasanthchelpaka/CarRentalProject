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
    <h1>THE BOOKING HAS BEEN CONFIRMED</h1>
    <BR>
    <H3>BOOKING SUMMARY:</H3>

    <br/><br/>
    <div>
     <table id="customers">
        <tr>
          <th>ID</th>
          <th>Company</th>
           <th>model</th>
            <th>car_type</th>
             <th>prize</th>
             <th>hashcode</th>
        </tr>
        <c:forEach  items="${model2}" var ="person">
        <tr>
          <form action="bill" method="post">
          <td>${person.carId}</td>
          <td>${person.company} </td>
          <td>${person.model} </td>
          <td>${person.type} </td>
          <td>${person.prize} </td>
          <td>${person.hashcode}</td>
         </form>
        </tr>
        </c:forEach>
      </table>


    </div>
  </body>

</html>