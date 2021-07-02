<%@ include file= "loggedin-header.jsp" %>

<div class="container">
<form action="AccountServlet" method="post">
  <div class="form-group">
    <label for="changeFirstName">First Name</label>
    <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Update First Name" required="required">
  </div>
    <div class="form-group">
      <label for="changeLastName">Last Name</label>
      <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Update Last Name" required="required">
    </div>
  <div class="form-group">
    <label for="changeUsername">Username</label>
    <input type="text" class="form-control" id="username" name="username" placeholder="Update Username" required="required">
  </div>
  <div class="form-group">
    <label for="changePassword">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Update Password" required="required">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<%@ include file= "footer.jsp" %>