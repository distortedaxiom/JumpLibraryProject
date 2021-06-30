<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Book List</h1>
	<br>
	<br>
	<h2>Previous Books</h2>
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
			<c:forEach var="checkoutBook" items="${previousCheckoutBooks}">
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
	<br />
	<hr />
	<br />
	<h2>Current Books</h2>
		<table class="table table-hover">
    		<thead>
    			<tr>
    				<th>ISBN</th>
    				<th>Title</th>
    				<th>Checkout Date</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach var="checkoutBook" items="${currentCheckoutBooks}">
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
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
</div>

<%@ include file= "footer.jsp" %>