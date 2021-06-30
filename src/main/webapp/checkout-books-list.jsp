<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Book List</h1>
	<br>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Checkout Date</th>
				<th>Return Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="checkoutBook" items="${allCheckoutBooks}">
				<tr>
					<td>
						<c:out value="${ checkoutBook.isbn }" />
					</td>
					<td>
						<c:out value="${ checkoutBook.title }" />
					</td>
                    <td>
                        <c:out value="${ checkoutBook.checkoutDate }" />
                    </td>
                    <td>
                        <c:out value="${ checkoutBook.returnDate }" />
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file= "footer.jsp" %>