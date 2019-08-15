<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <title>Pregled</title>
     
    </head>
    <body>
          <jsp:include page="menu.jsp"/>
  
<div class="container">
    
        
            <h3>Detalji pregleda</h3>

            <br>
            <table class="table table-bordered">
                <thead>
                    <th width="120">Date and time</th>
                    <th width="120">Note</th>
                    <th width="120">Patient</th>
                    <th width="120">Dentist</th>  
                    <th width="120">Amount</th>
                    <th width="120">Status</th>
                </thead>
                <tbody>
                <tr>
                    <td>${appointment.date}</td>
                    <td>${appointment.note}</td>
                    <td>${appointment.patient.name} ${appointment.patient.surname}</td>
                    <td>${appointment.dentist.name} ${appointment.dentist.surname}</td>     
                    <td>${appointmen.amount}</td>
                    <td>${appointment.status}</td>
            </tr>
            </tbody>
        </table>
            
            
                <h4>
            Usluge
                </h4>

            
        <c:if test="${!empty listAppointmentItems}">
            <table class="table table-bordered">
                <thead>
                    <th width="120">Service name</th>
                    <th width="120">Service price</th>
                    <th width="120">Quantity</th>
                    <th width="120">Total</th>   
                    <th width="60">Action</th>
                </thead>
                <tbody>
                <c:forEach items="${listAppointmentItems}" var="appointmentItem">
                    <tr>
                        <td>${appointmentItem.service.name}</td>
                        <td>${appointmentItem.service.price}</td>
                        <td>${appointmentItem.quantity}</td>
                        <td>${appointmentItem.service.price*appointmentItem.quantity}</td>  
                        <td><a href="<c:url value='/appointmentItem/remove/${appointmentItem.id}' />" >Delete</a></td>
                    </tr>
                </c:forEach>
                    </tbody>
        
        </c:if>
            
            
<c:url var="addAction" value="/appointmentItem/add" ></c:url>

<form:form action="${addAction}" commandName="appointmentItem"  method="POST">

<form:hidden path="id"/>

                <form:hidden path="appointment.id" value="${appointment.id}"/>
    
                
        <tr>
            <td colspan="2">
                    <div class="form-group">
                        <form:select path="service.id" items="${services}" itemValue="id" itemLabel="name" class="form-control" /><form:errors path="service"/> 
                      </div>
                </td>
                <td>
                    <div class="form-group">
                        <form:input path="quantity" class="form-control"/>
                    </div>
                </td>
                <td>
                    
                </td>
                <td>
                 <div class="form-group">
		
            <button type="submit" class="btn btn-default" >Dodaj</button>
			
        </div>
                </td>
        
                 
                      
      

</table>	
</form:form>
</div>
    </body>
</html>
