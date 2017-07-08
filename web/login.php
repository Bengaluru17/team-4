/*Not being Used*/

<html>
<head>

<script type="text/javascript">

function validate()
{
var usn=document.getElementById("uname").value;
submitOK="true";
if (submitOK=="false")
 {
 return false;
 }
}
</script>

<title>
Login Page
</title>
</head>

<style>
.logo{
	width:150px;
	height:150px;
	
}
div.container {
    width: 100%;
    border: 1px solid gray;
}

header{
    padding: .6em;
    color: white;
    background-color: #fcad1c;
    clear: left;
    text-align: center;
    font-family: arial;
}
body{
	background:#FFFFFF;
}
.heading {
    font-family: "forte";
	font-size:200%;
	}
</style>
<body>	
	<div class="container">
	<header>
	<img src="http://www.kshamata.org/wp-content/uploads/2014/09/logo.jpg" align="left" class="logo" style="position:absolute;left:50;top:50;height:15%;width:8%"/>  
	<h1 style=color:black; align="center" class="heading"> KSHAMATA </h1> 
	<h2 style=color:black; align="center" >Touching Lives . Supporting Liberation </h2>	
	</header>
	
<center>
<br>

<table border=5 valign="center" ><tr><td valign="center" width=10%>
<center><h1><font color=blue>Login Page</font></h1></center></tr></td>
<tr><td>
<form method="post"  action="login.php" onsubmit="return validate()">
<tr><td>
<center><table border=1 ><tr>

<td><font color=blue><b>Username</b></font>  <font color=red><b>*</b></font></td><td><input type="text" name="uname" id="uname" size=30 maxlength=30></td></tr>
<tr>

<td><font color=blue><b>Password</b></font> <font color=red><b>*</b></font></td><td><input type="password" name="pwd" id="pwd" size=30 maxlength=30></td></td></tr>


</table>

<input type="submit" value="login">

</center>
</table></td></tr>
</form>
<b><a href="register.html">Register Here</a></b>

</center>
<hr>
</body>
</html>
