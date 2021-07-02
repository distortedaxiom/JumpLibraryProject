<%@ include file= "header.jsp" %>


<div class="container">

	<h1 style="text-align: center">Your Library</h1>

    <div class="login-form">
        <form action="SignupServlet" method="post">
            <h2 class="text-center">Sign Up</h2>
            <div class="form-group">
                <input type="text" class="form-control" id="first_name" name="first_name" placeholder="First Name" required="required">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Last Name" required="required">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required="required">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Create your account</button>
            </div>
        </form>
        <p class="text-center"><a href="<%= request.getContextPath() %>/">Already have an account? Login!</a></p>
    </div>
</div>

<%@ include file= "footer.jsp" %>
