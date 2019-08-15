<%-- 
    Document   : menu
    Created on : Jul 3, 2019, 8:39:01 PM
    Author     : milos
--%>

<%@page import="com.journaldev.spring.model.Dentist"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Kotlar Dental</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pacijenti<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/SpringMVCHibernate/patients">Lista Pacijenata </a></li>
          <li><a href="/SpringMVCHibernate/patient/new">Dodaj Pacijenta</a></li>
        </ul>
      </li>
       <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pregledi<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/SpringMVCHibernate/appointments">Lista Pregleda</a></li>
          <li><a href="/SpringMVCHibernate/appointment/new">Dodaj Pregled</a></li>
        </ul>
          
      </li>
      
    </ul>
      
      <ul class="nav navbar-nav navbar-right">
           <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%= ((Dentist)session.getAttribute("dentist")).getName() %> <%= ((Dentist)session.getAttribute("dentist")).getSurname()%></a></li>
          <li><a href="/SpringMVCHibernate/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
  </div>
</nav>
        <div class="container">
            
        </div>

    </body>
</html>
