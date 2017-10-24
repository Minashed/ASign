<?php
	require_once "constants.php"
	
	$con = new mysqli(DB_HOST, DB_USER, DB_PASSWORD);
	
	if(!$con){
		echo "Database connection failed";
	}else{
		echo "Database Connected Successfully!!!";
	}
	
	
?>