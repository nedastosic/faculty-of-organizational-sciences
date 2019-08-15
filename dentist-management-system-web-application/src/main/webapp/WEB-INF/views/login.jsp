<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title>Login</title>
	
</head>
<body>
        <jsp:include page="loginmenu.jsp"/>
  
<div class="container">
    
<h3>
	Login
</h3>

<c:url var="addAction" value="/login/validate" ></c:url>

<form:form action="${addAction}" commandName="dentist">
<div class="form-group">
		<form:label path="username">
				<spring:message text="Username"/>
			</form:label>
            <form:input path="username" class="form-control"/>
			
        </div>
        <div class="form-group">	
			<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		
			<form:input path="password" type="password" class="form-control"/>
	</div>
        <div class="form-group">	
        
        <button type="submit" class="btn btn-default" >Login</button>
	
        </div>
</form:form>
</div>
</body>
</html>
