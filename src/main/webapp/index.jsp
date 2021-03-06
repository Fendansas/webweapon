<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
<body>


<h2>Products List</h2>
<p>
<a class="btn btn-primary" href='<c:url value="/create" />'>Create new</a>
</p>


<table class="table">

<thead class="thead-dark">
<tr>
<th scope="col">Name</th>
<th scope="col">Price</th>
<th scope="col">idcalibre</th>
<th scope="col">Action</th>
<th></th></tr>
</thead>

<c:forEach var="product" items="${products}">
<tr><td>${product.name}</td>
<td>${product.price}</td>
<td>${product.idcalibre}</td>

<td>
<a href='<c:url value="/edit?id=${product.id}" />'>Edit</a> |
<form method="post" action='<c:url value="/delete" />' style="display:inline;">
<input type="hidden" name="id" value="${product.id}">
<input type="submit" value="Delete">
</form>
</td></tr>
</c:forEach>
</table>
</body>
</html>

