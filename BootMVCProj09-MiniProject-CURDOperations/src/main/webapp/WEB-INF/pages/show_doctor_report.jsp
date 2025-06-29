<%@ page language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<frm:form action="register" method="post" modelAttribute="docVo">
    <table bgcolor="cyan" align="center" border="1">
       
        <tr>
          <td>DName</td>
          <td><frm:input path="dname"/></td>
        </tr>
         <tr>
          <td>DSpecialz</td>
          <td><frm:input path="specialz"/></td>
        </tr>
         <tr>
          <td>Dfee</td>
          <td><frm:input path="fee"/></td>
        </tr>
         <tr>
          <td>DQlfy</td>
          <td><frm:input path="qlfy"/></td>
        </tr>
        
        <tr>
          
          <td><input type="submit" value="register"/></td>
          <td><input type="reset" value="Cancel"/>
        </tr>
        
    </table>

</frm:form>