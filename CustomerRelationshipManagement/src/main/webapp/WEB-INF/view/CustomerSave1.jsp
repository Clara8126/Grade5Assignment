<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Update</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h3> Save Customer</h3>
		<form action="/CustomerRelationshipManagement/customers/save" method="post">
			<input type="hidden" name="id" value="${Customer.id}">
			<div class="form-inline">
			<input type="text"  name="Firstname" value="${Customer.firstname}" placeholder="First Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="LastName" value="${Customer.lastname}" placeholder="Last Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="Email" value="${Customer.email}" placeholder="Email ID" class="form-control mb-4 col-4">
			</div>
			<button type="submit" class="btn btn-info col-2">Submit</button>
		</form>
		
		<a href="/CustomerRelationshipManagement/customers/list">Back to Customer List </a>
	
	</div>
</body>
</html>