<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
        <div class="card-header"><h2 align="center">Article : ${msg}</h2> </br>
            <h2 align="center"> Country Setup </h2>
        </div>
        <form action="/country/success">
            <div class="form-group">
                <label for="code"> Country Code:</label>
                <input type="code" class="form-control" id="code">
            </div>
            <div class="form-group">
                <label for="countryName">Country Name:</label>
                <input type="text" class="form-control" id="countryName">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <div class="card-footer"><h2 align="center"> Footer </h2></div>

</div>
</body>
</html>