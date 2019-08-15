<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Pacijenti</title>
	
</head>
<body>
    <jsp:include page="menu.jsp"/>
  
<div class="container">
    
  
<h3>Lista Pacijenata</h3>

<c:url var="addAction" value="" ></c:url>

<form action="/SpringMVCHibernate/patient/search" method="GET">
<div class="form-group">
    <input type="text" name="search" class="form-control" style="float:left;width:80%;" placeholder="Search"/>
            <button type="Submit" class="btn btn-primary" style="float:right;width:19%;">Search</button>
        </div>
<form>
    <br/>
    <br/>
    <br/>
<c:if test="${!empty listPatients}">
	<table class="table table-bordered">
            <thead>
		<th width="120">JMBG</th>
		<th width="120">Name</th>
		<th width="120">Lastname</th>
                <th width="120">Date of birth</th>
                <th width="120">Phone</th>
                <th width="120">City</th>
                <th width="200">Address</th>
                <th width="200">Dentist</th>
		<th width="60">Action</th>
	</thead>
            <tbody>
	<c:forEach items="${listPatients}" var="patient">
		<tr>
			<td>${patient.jmbg}</td>
			<td>${patient.name}</td>
                        <td>${patient.surname}</td>
                        <td><fmt:formatDate value="${patient.dateOfBirth}" pattern="dd-MM-yyyy" /></td>
                        <td>${patient.phone}</td>
                        <td>${patient.city.name}</td>
                        <td>${patient.address}</td>
			<td>${patient.dentist.name} ${patient.dentist.surname}</td>
			<td><a href="<c:url value='/edit/${patient.jmbg}' />" >Edit</a> | <a href="<c:url value='/remove/${patient.jmbg}' />" >Delete</a></td>
		</tr>
	</c:forEach>
            </tbody>
	</table>
</c:if>
</div>

</body>
</html>
