<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title>Pregledi</title>
</head>
<body>
        <jsp:include page="menu.jsp"/>


        <div class="container">
<h3>Appointments List</h3>



<c:if test="${!empty listAppointments}">
	<table  class="table table-bordered">
            <thead>
		<th width="120">Date and time</th>
		<th width="120">Patient</th>
		<th width="120">Dentist</th>
		<th width="120">Amount</th>
                <th width="120">Status</th>
		<th width="60" colspan="2">Action</th>
	</thead>
        <tbody>
	<c:forEach items="${listAppointments}" var="appointment">
		<tr>
			<td>${appointment.date}</td>
			<td>${appointment.patient.name} ${appointment.patient.surname}</td>
                        <td>${appointment.dentist.name} ${appointment.dentist.surname}</td>
                        <td>${appointment.amount}</td>
                        <td>${appointment.status}</td>
                        
			<td><a href="<c:url value='/appointment/edit/${appointment.id}' />" >Edit</a> | <a href="<c:url value='/appointment/remove/${appointment.id}' />" >Delete</a> </td>
                        
                        <td><a href="<c:url value='/appointmentDetails/${appointment.id}' />" >Details</a></td>
		</tr>
	</c:forEach>
        </tbody>
	</table>
</c:if>
</div>
</body>
</html>
