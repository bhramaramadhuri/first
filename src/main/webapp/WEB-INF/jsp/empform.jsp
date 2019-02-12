<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
.error {
color: red;
font-style: italic;
}
</style>
       <form:form method="post" action="save" modelAttribute="person"> 
        <h1 class="jumbotron" HEIGHT=100>Add New Person</h1> 
               <table  >    
         <tr>    
         <form:hidden path="id"></form:hidden> 
          <td>Code : </td>   
          <td><form:input path="code" id="code"  /></td> 
          </tr>    
         <tr>    
          <td>Name :</td>    
          <td><form:input path="name"  id="name"/></td>
          </tr>   
          <tr>    
          <td><br/> </td>    
          <td><input type="submit" class="btn btn-success" value="Save" /></td>    
         </tr>    
        </table>   
       
       </form:form>  