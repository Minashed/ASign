<?php
    require_once "constants.php";
	
	$con = new mysqli(DB_HOST, DB_USER, DB_PASSWORD);
	
    $uname = $_POST["uname"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM User WHERE uname = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $uname, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $fname, $lname, $uname, $password, $email, $pnumber);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["fname"] = $fname;
		$response["lname"] = $lname;
		$response["uname"] = $uname;
        $response["password"] = $password;
		$response["email"] = $email;
		$response["pnumber"] = $pnumber;
    }
    
    echo json_encode($response);
?>