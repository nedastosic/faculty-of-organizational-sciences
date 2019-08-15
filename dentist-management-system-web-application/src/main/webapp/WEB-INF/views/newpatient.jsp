<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Pacienti</title>
                 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
        
    </head>
    <body>
        
    <jsp:include page="menu.jsp"/>
    <div class="container"> 
  <h3>Pacijenti</h3>

<c:url var="addAction" value="/patient/add" ></c:url>
<form:form action="${addAction}" commandName="patient">
 <div class="form-group">
        <form:label path="jmbg">
                <spring:message text="Jmbg"/>
        </form:label>
        <form:input path="jmbg" class="form-control"/>
 </div>
        <form:hidden path="dentist.id" value="${dentist.id}"/>
        <div class="form-group">
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		
			<form:input path="name" class="form-control"/>
                </div>
	<div class="form-group">
			<form:label path="surname">
				<spring:message text="Surname"/>
			</form:label>
	
			<form:input path="surname" class="form-control"/>
        </div>
	<div class="form-group">
            
			<form:label path="dateOfBirth">
				<spring:message text="Date of birth"/>
			</form:label>
            
            <div class='input-group date' id='datetimepicker'>
                    <form:input path="dateOfBirth" type="text" class="form-control"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
		
			
        </div>
	<div class="form-group">
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		
			<form:input path="email" class="form-control"/>
        </div>
        <div class="form-group">
			<form:label path="phone">
				<spring:message text="Phone" />
			</form:label>
	
			<form:input path="phone" class="form-control"/>
        </div>
	<div class="form-group">
                <td><form:label path="city">City</form:label></td>
                <td><form:select path="city.postNumber" items="${cities}" itemValue="postNumber" itemLabel="name" class="form-control"/><form:errors path="city"/> </td>
        </div>
        <div class="form-group">
			<form:label path="address">
				<spring:message text="Address"/>
			</form:label>
		
			<form:input path="address" class="form-control"/>
        </div>
	<div class="form-group">
		
            <button type="submit" class="btn btn-default" >Sacuvaj pacijenta</button>
			
        </div>
	
         
</form:form>
</div>   
<script type="text/javascript">
    $(document).ready(function(){
    $("#datepicker").datetimepicker();
    });
</script>
    </body>
</html>
