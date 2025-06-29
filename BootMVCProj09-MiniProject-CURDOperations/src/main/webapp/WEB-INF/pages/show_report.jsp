<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 Style="color:green;text-align:center">ShoW Report Page</h1>

<c:choose>
  <c:when test="${!empty doctorlist}">
     <table bgcolor="cyan" align="center" border="1">
        <tr>
            <th>Id</th> <th>Name</th> <th>Specialization</th> <th>fee</th> <th>qualification</th> <th>Operations</th>
        </tr>
        
          <c:forEach var="res" items="${doctorlist}">
              <tr>
                  <td>${res.did}</td>
                  <td>${res.dname}</td>
                  <td>${res.specialz}</td>
                  <td>${res.fee}</td>
                  <td>${res.qlfy}</td>
                  <td>
                      <a href="edit?no=${res.did}"><img src="images/edit2.jpg" width="60px" height="60px"></a>&nbsp;&nbsp;
                      <a href="delete?no=${res.did}" onclick="return confirm('Do yo Really want delete?')"><img src="images/delete1.jpg" width="60px" height="60px"></a>
                  </td>
                  
              </tr>
          </c:forEach>
        
     </table>
  </c:when>
  
 <c:otherwise>
   <h1 Style="color:red;text-align:center">No Doctors Are Found</h1>
  </c:otherwise>
 </c:choose>
<h1 Style="color:green;text-align:center">${resultmsg}</h1>

<h1 Style="color:blue;text-align:center"><a href="register">Add Doctor <img src="images/add.jpg"></a></h1>
 
<br><br>
<h1 Style="color:blue;text-align:center"><a href="./">Home<img src="images/home.jpg"></a></h1>