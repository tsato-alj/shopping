<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>ProuVege - RecordItem</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css">
		<link rel="stylesheet" type="text/css" href="login.css">
		<link rel="stylesheet" type="text/css" href="footer.css">
		<link rel="stylesheet" type="text/css" href="shopping.css">
		<link rel="stylesheet" type="text/css" href="recordItem.css">

	</head>
	<body>
		<%@include file="producerHeader.jsp"%>
		<div class="container maincontent">
			<div class="row width100margin0">
				<div class="col-md-8">
					<section id="record">
								<div class="record-content">
									<h3 class="h3">Record Item</h3>
									<p>Please enter the information.</p>
								</div>
								<div class="record-section">
								<div class="container formlist">
									<form class="center-block" method="post" action="confirmrecorditem">
										<div class="row">
											<div class="col-md-6 form-line">
												<div class="form-group" >

											    	<label for="itemId">Brand ID</label>
											    	<p><input type="text"  class="form-control" name="itemId" id="itemId" value="" required/></p>
											  	</div>
												<div class="form-group" >

											    	<label for="itemName">Brand Name</label>
											    	<p><input type="text"  class="form-control" name="itemName" id="itemName" value="" required/></p>
											  	</div>
											  	<div class="form-group">
											    	<label for="category">Category</label>
											    	<select class="form-control" id="category" name="category" required>
														<option value="Vegetable">Vegetable</option>
														<option value="Fruit">Fruit</option>
														<option value="Rice">Rice</option>
														<option value="Soy">Soy</option>
											    	</select>
									  			</div>
									  			<div class="form-group">
											    	<label for="price">Price(&yen)</label>
											    	<div id="price">
												    	<input type="number"  class="form-control" name="price" id="price" value=""/></p>
											    	</div>
											  	</div>
									  		</div>
									  		<div class="col-md-6 form-line">
									  			<div>
									  				<button type="submit" class="btn btn-default submit"><i class="fa fa-paper-plane" aria-hidden="true"></i>  Submit</button>
									  			</div>
									  		</div>div
									  	</div>
									</form>
								</div>
							</section>
				</div>
				<div class="col-md-4">
					<jsp:include page="login.jsp" />
				</div>
			</div>
		</div>
		<%@include file="footer.html" %>
		<%@include file="script.html" %>
</html>