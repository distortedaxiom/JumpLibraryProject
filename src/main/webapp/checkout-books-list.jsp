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
                        <td>
						<a href="checkoutbook?id=<c:out value='${ checkoutBook.isbn }' />">
							<button class="btn btn-danger">Return</button>
						</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
</div>

<%@ include file= "footer.jsp" %>