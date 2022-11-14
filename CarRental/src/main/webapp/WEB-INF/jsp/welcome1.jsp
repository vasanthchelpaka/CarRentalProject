    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
    <style>
        @import "compass/css3";
      html, body {
      display: flex;
      justify-content: center;
      height: 100%;
      }


a.five:link {color:#ff0000;text-decoration:none;}
a.five:visited {color:#0099ff;text-decoration:none;}
a.five:hover {text-decoration:underline;}
      body, div, h1, form, input, p {
      padding: 0;
      margin: 0;
      outline: none;
      font-family: Roboto, Arial, sans-serif;
      font-size: 16px;
      color: #666;
      }
      th, td {
        border-bottom: 1px solid #ddd;
      }
      h1 {
      padding: 10px 0;
      font-size: 32px;
      font-weight: 300;
      text-align: center;
      }
      p {
      font-size: 12px;
      }
      hr {
      color: #a9a9a9;
      opacity: 0.3;
      }
      .main-block {
      max-width: 340px;
      min-height: 460px;
      padding: 10px 0;
      margin: auto;
      border-radius: 5px;
      border: solid 1px #ccc;
      box-shadow: 1px 2px 5px rgba(0,0,0,.31);
      background: #ebebeb;
      }
      form {
      margin: 0 30px;
      }
      .account-type, .gender {
      margin: 15px 0;
      }
      input[type=radio] {
      display: none;
      }
      label#icon {
      margin: 0;
      border-radius: 5px 0 0 5px;
      }
      label.radio {
      position: relative;
      display: inline-block;
      padding-top: 4px;
      margin-right: 20px;
      text-indent: 30px;
      overflow: visible;
      cursor: pointer;
      }
      label.radio:before {
      content: "";
      position: absolute;
      top: 2px;
      left: 0;
      width: 20px;
      height: 20px;
      border-radius: 50%;
      background: #1c87c9;
      }
      label.radio:after {
      content: "";
      position: absolute;
      width: 9px;
      height: 4px;
      top: 8px;
      left: 4px;
      border: 3px solid #fff;
      border-top: none;
      border-right: none;
      transform: rotate(-45deg);
      opacity: 0;
      }
      input[type=radio]:checked + label:after {
      opacity: 1;
      }
      input[type=text], input[type=password] {
      width: calc(100% - 57px);
      height: 36px;
      margin: 13px 0 0 -5px;
      padding-left: 10px;
      border-radius: 0 5px 5px 0;
      border: solid 1px #cbc9c9;
      box-shadow: 1px 2px 5px rgba(0,0,0,.09);
      background: #fff;
      }
      input[type=password] {
      margin-bottom: 15px;
      }
      #icon {
      display: inline-block;
      padding: 9.3px 15px;
      box-shadow: 1px 2px 5px rgba(0,0,0,.09);
      background: #1c87c9;
      color: #fff;
      text-align: center;
      }
      .btn-block {
      margin-top: 10px;
      text-align: center;
      }
      button {
      width: 100%;
      padding: 10px 0;
      margin: 10px auto;
      border-radius: 5px;
      border: none;
      background: #1c87c9;
      font-size: 14px;
      font-weight: 600;
      color: #fff;
      }
      button:hover {
      background: #26a9e0;
      }
    </style>
  </head>
  <body>
    <div class="main-block">
      <h1>welcome</h1>
      <form method="post">
        <hr>

        <hr>

        <label id="icon" for="name"><i class='far fa-calendar-alt'></i></label>
		<input type="text" name="bookfrom" placeholder="time from" /> <br>
        <label id="icon" for="name"><i class='far fa-calendar-alt'></i></label>
		<input type="text" name="bookto" placeholder="time to" required/> <br>
        <h3>Enter Car Type<h3>



		 <label for="cars">Choose a car model:</label>

        <select name="type" id="cars">
         <option value="any">ALL</option>
          <option value="sedan">SEDAN</option>


          <option value="hatchback">HATCHBACK</option>
          <option value="sport">SPORT</option>
        </select>
        <div class="btn-block">
          <button type="submit" href="/">Submit</button>
        </div>
      </form>
      <br>
      <hr>
        <div style="text-align: center">
      <p><b><a class="five" href="http://localhost:8080/batman" >BOOKING HISTORY</a></b></p>
      </div>
      <hr>
    </div>
  </body>
</html>