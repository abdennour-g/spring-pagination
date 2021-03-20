<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css?sinc=${sinc }" />
</head>
<body>
<h2>${title}</h2>
<div class="btn-group col-xs-offset-2 col-xs-8">
    <input type="text" class="btn t_srch col-xs-8"  placeholder="search"/> 
    <button onClick="search()" class="btn b_srch btn btn-primary"> <span class="glyphicon glyphicon-search"></span> </button>
    </div>
   
<div class="div_table col-xs-12">
<table class="table table-striped">
    <caption >
   </caption>
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">NAME</th>
            <th scope="col">EMAIL</th>
            <th scope="col">CITY</th>
        </tr>
    </thead>
    <tbody>
    
    </tbody>
</table>
</div>
<nav class="nav-pagination col-xs-offset-1 col-xs-10"> </nav>

<ul class="col-xs-offset-1 col-xs-10">
<h5>WEB-SERVICES</h5>
<li> <a href="http://localhost:5500/fullpers?key=oujda"> <strong>full persons</strong></a>
<li> <a href="http://localhost:5500/cities"><strong>citys</strong></a>
<li> <a href="http://localhost:5500/pers?page=1&size=10&key=ahmed"><strong>pagination</strong></a>
</ul>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/includes.js?sinc=${sinc}"></script>
<script type="text/javascript" src="js/main.js?sinc=${sinc}"></script>
</body>
</html>