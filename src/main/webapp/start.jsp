<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.*" %>
<html>
<head>
  <title>Task1</title>
  <link rel="stylesheet" href="resources/css/stylesheet.css" type="text/css"/>
  <link rel="stylesheet" href="resources/bootstrap-3.3.6/css/bootstrap.css" type="text/css"/>
</head>
<body>
<br><br>
<div class="container">
  <!-- Menu -->
  <ul class="nav nav-tabs">
    <li class="active"><a href=""><h4 class="str">Device management</h4></a></li>
  </ul><br>
  <!-- Form -->
  <form name="control-device" onsubmit="">
    <h3 class="str"><span class="label label-info">Turn <b>on/off</b> the device</span></h3><br>
    <div class="row">
      <div class="col-md-4 brd">
        <h4 class="str"><span class="label label-danger" id="error1"></span></h4>
        <input type="text" class="form-control" id="input-key" placeholder="Keyword"><br>
        <h4 class="str"><span class="label label-danger" id="error2"></span></h4>
        <label class="checkbox-inline"><input type="checkbox" name="checkBoxView" value="On" id="var1"> On</label>
        <label class="checkbox-inline"><input type="checkbox" name="checkBoxView" value="Off" id="var2"> Off</label>
        <br><br>
        <button type="button" onclick="validate()" class="btn btn-default">Send</button>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <h4 class="str"><span class="label label-danger" id="error-label"></span></h4><br>
        <h4 class="str">Result: </h4>
        <input type="text" class="form-control" id="input-res" placeholder="Result">
      </div>
    </div>
  </form>
</div>
<script type="text/javascript" src="resources/js/functions.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
