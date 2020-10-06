<%--
  Created by IntelliJ IDEA.
  User: mdtofazzal.hossain
  Date: 12/26/2018
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" charset="utf-8">
    <title>Home Form</title>
    <%--<meta charset="utf-8">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="card-header">
            <h2 align="center"> Country Setup </h2>
        </div>
        <form action="/country/saveCountry" th:action="@{/saveCountry}" th:object="${country}" method="post">
        <%--<form name="countryForm" method="post">--%>
        <%--<form name="countryForm" method="post" action="/country/saveCountry">--%>
            <div class="form-group">
                <label for="code"> Country Code:</label>
                <input type="code" class="form-control" id="code">
            </div>
            <div class="form-group">
                <label for="name">Country Name:</label>
                <input type="text" class="form-control" id="name">
            </div>
            <button type="submit" onclick="saveCountry();" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <div class="card-footer"><h2 align="center"> Footer </h2></div>

</div>
</body>


<script type="javascript">

    function saveCountry() {
        alert("saveCountry")
        var data =  $("#countryForm").serialize();
        jQuery.ajax({
            type:'post',
            data: da,
            url: "${request.contextPath}/${params.controller}/saveCountry",
            success:function(data, textStatus) {
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {
            },
            complete:function(){
            },
            dataType:'json'
        });
    }

</script>
</html>
