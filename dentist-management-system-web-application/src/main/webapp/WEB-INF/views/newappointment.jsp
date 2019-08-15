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

  
  <h3>
	Dodaj Pregledi
</h3>

<c:url var="addAction" value="/appointment/add" ></c:url>

<form:form action="${addAction}" commandName="appointment"  method="POST">

                <form:hidden path="id"/>
     
			<form:hidden path="dentist.id" value="${dentist.id}"/>
        <div class="form-group">
                        <form:label path="date">
                                <spring:message text="Date"/>
                        </form:label>
              
                        <form:input path="date" type="text" id="datepicker" class="form-control"/>
        </div>
        <div class="form-group">
                        <form:label path="note">
                                <spring:message text="Note"/>
                        </form:label>
           
                        <form:input path="note" class="form-control"/>
               </div>
        <div class="form-group">
                        <form:label path="amount">
                                <spring:message text="Amount"/>
                        </form:label>
             
                        <form:input path="amount" class="form-control"/>
           </div>
        <div class="form-group">
                        <form:label path="status">
                                <spring:message text="Status"/>
                        </form:label>
               
                        <form:input path="status" class="form-control"/>
             </div>
        <div class="form-group">
       
               <form:label path="patient">Patient</form:label>
                <form:select path="patient.jmbg" items="${patients}" itemValue="jmbg" itemLabel="name" class="form-control"/><form:errors path="patient"/>
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
