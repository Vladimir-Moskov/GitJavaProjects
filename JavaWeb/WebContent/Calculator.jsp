<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>
	<form action="" method="POST">
  		<input type="text" name="firstNum" maxlength="10"  
  			onkeyup="this.value = this.value.replace(/[^0-9.-]/, '')"
  			<c:if test="${response == true}">disabled</c:if>
  			><br>
  			
  		<input type="text" name="secondNum" maxlength="10" 
  			onkeyup="this.value = this.value.replace(/[^0-9.-]/, '')"
  			<c:if test="${response == true}">disabled</c:if>
  			><br>
  		<c:if test="${response == true}"><c:out value="${sum}"/><br></c:if>
  		<input type="submit" value="Submit" <c:if test="${response == true}">disabled</c:if> >
	</form> 

	
</body>
</html>