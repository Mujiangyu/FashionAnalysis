<?php
$q = intval($_GET['q']);

$con = mysqli_connect('localhost','root','niit1234');
if (!$con) {
    die('Could not connect: ' . mysqli_error($con));
}

mysql_select_db("fashion_analysis");

$sql="SELECT valid_question FROM tbl_userinfo WHERE user_name = '".$q."' ";
$result = mysqli_query($con,$sql);

if($row = mysql_fetch_array($result))
{
  echo "<input type="text" value='$row[valid_question]' />";//循环，拼凑下拉框选项
}

mysqli_close($con);
?>