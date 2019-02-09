<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<%@include file="UserMenu.jsp"%>
		<div class="card">

			<div class="card-header bg-warning text-white">

				<h2>Welcome to Item Register page!!</h2>

			</div>

			<div class="card-body">

				<f:form cssClass="form" action="insert" method="post"
					modelAttribute="item">

					<div class="row">

						<div class="col-2">
							<label for="itemCode">Item Code:</label>
						</div>
						<div class="col-6">
							<f:input path="itemCode" cssClass="form-control" />

						</div>
						<div class="col-2">
							<f:errors path="itemCode" cssClass="text-danger text-center" />
						</div>

					</div>
					<div class="row">

						<div class="col-2">

							<label>Dimensions</label>
						</div>
						
                           <div class="col-1"></div>
							<label for="itemLength">Length</label>
						
						<div class="col-1">
							<f:input path="itemLength" cssClass="form-control" />

						</div>

						
							<label for="itemWidth">Width</label>
						
						<div class="col-1">
							<f:input path="itemWidth" cssClass="form-control" />

						</div>
						
							<label for="itemHeight">Height</label>
						
						<div class="col-1">
							<f:input path="itemHeight" cssClass="form-control" />

						</div>
					</div>
					<div class="row">
					<div class="col-4"></div>
						<div class="col-1">
							<f:errors path="itemLength" cssClass="text-danger text-center" />
						</div>
							
						<div class="col-1">
							<f:errors path="itemWidth" cssClass="text-danger text-center" />
						</div>
							
						<div class="col-1">
							<f:errors path="itemHeight" cssClass="text-danger text-center" />
						</div>
					
					</div>
					<div class="row">

						<div class="col-2">
							<label for="baseCost">BaseCost</label>
						</div>
						<div class="col-6">
							<f:input path="baseCost" cssClass="form-control" />

						</div>
						<div class="col-2">
							<f:errors path="baseCost" cssClass="text-danger text-center" />
						</div>

					</div>



					<div class="row">

						<div class="col-2">
							<label for="baseCurrency">Base Currency</label>
						</div>
						<div class="col-6">
							<f:select path="baseCurrency" cssClass="form-control">
								<f:option value="">---select--</f:option>
								<f:option value="INR">INR</f:option>
								<f:option value="USD">USD</f:option>
								<f:option value="AUS">AUS</f:option>
								<f:option value="ERU">ERU</f:option>
							</f:select>
						</div>
							<div class="col-3">
								<f:errors path="baseCurrency" cssClass="text-danger text-center" />
							</div>


					</div>



					<div class="row">

						<div class="col-2">
							<label for="itemDsc">Description:</label>
						</div>
						<div class="col-6">
							<f:textarea path="itemDsc" cssClass="form-control" />
						</div>
						<div class="col-2">
							<f:errors path="itemDsc" cssClass="text-danger text-center" />
						</div>
					</div>

					<input type="submit" class="btn btn-success" value="Create Item" />

				</f:form>
			</div>
			<!-- body card end -->


			<c:if test="${msg != null}">
				<div class="card-footer bg-primary text-white">${msg}</div>
			</c:if>
		</div>
		<a href="all" class="btn btn-secondary text-center">View All</a>

	</div>
</body>
</html>