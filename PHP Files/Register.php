<?php
    require_once "constants.php";
	
	$con = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);
    
    $fname = $_POST["fname"];
    $lname = $_POST["lname"];
	
    $uname = $_POST["uname"];
    $password = $_POST["password"];
	
	$email = $_POST["email"];
	$pnumber = $_POST["pnumber"];
    
    $statement = mysqli_prepare($con, "INSERT INTO User (fname, lname, uname, password, email, pnumber) VALUES (?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssssss", $fname, $lname, $uname, $password, $email, $pnumber);
    mysqli_stmt_execute($statement);
    
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>