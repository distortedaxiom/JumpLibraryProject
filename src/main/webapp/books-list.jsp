<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${(patron.first_name).length() > 0}">
		<%@ include file= "loggedin-header.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file= "header.jsp" %>
	</c:otherwise>
</c:choose>


<div class="container">
	
	<c:if test="${(patron.first_name).length() > 0}"> 
		<br>
		<div>
			<h1>Hello ${patron.first_name}!</h1>
		</div>
		<hr>
	</c:if>
	
	<h1>Book List</h1>
	<br>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Description</th>
				<th>Rented</th>
				<th>Date Added</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${allBooks}">
				<tr>
					<td>
						<c:out value="${ book.isbn }" />
					</td>
					<td>
						<c:out value="${ book.title }" />
					</td>
					<td>
						<c:out value="${ book.description }" />
					</td>
					<td>
						<c:out value="${ book.rented }" />
					</td>
					<td>
						<c:out value="${ book.addedToLibrary }" />
					</td>
					<td>
						<c:if test="${(book.rented) == false}"> 
						<a href="edit?id=<c:out value='${ book.isbn }' />">
							<button class="btn btn-primary">Checkout</button>
						</a>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file= "footer.jsp" %>