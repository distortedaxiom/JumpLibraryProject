<%@ include file= "header.jsp" %>


<div class="container">

	<h1 style="text-align: center">Your Library</h1>

    <div class="login-form">
        <form action="LoginServlet" method="post">
            <h2 class="text-center">Log in</h2>
            <div class="form-group">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required="required">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Log in</button>
            </div>
        </form>
        <p class="text-center"><a href="#">Create an Account</a></p>
    </div>
</div>

<%@ include file= "footer.jsp" %>
