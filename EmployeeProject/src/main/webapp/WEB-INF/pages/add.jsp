<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>save page</title>
</head>
<body>

  <h1>Add New Employee</h1>  
       <form:form method="post" id= "addForm" modelAttribute="employee" action="${pageContext.request.contextPath}/addemployee">  
       <form:hidden path="id"/>  
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input type="text" path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Salary :</td>    
          <td><form:input type="text" path="salary" /></td>  
         </tr>   
        <tr>    
          <td> </td>    
          <td><input type="button" onclick="submitForm()" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
<script>
function submitForm() 
{
	document.getElementById("addForm").submit();	
	return false;
	}
</script>
</body>
</html>

