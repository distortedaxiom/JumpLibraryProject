<%@ include file= "header.jsp" %>
<div class="container">
	
	<c:if test="${patron.username != null} }"> 
		<div>
			<h1>HELLO</h1>
		</div>
	</c:if>
	
	<h1>Book List</h1>
	<br>
	<br>
	<table class="table table-hover">
		<thead>
			<h1>${patron.first_name}</h1>
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file= "footer.jsp" %>