<%@ page isELIgnored="false" isErrorPage="true"%>
<h1 Style="color:red;text-align:center">error.jsp(Global Error Page)</h1>
<h1 Style="color:red;text-align:center">Internal Problem Try Again</h1>
<table align="center" bgcolor="yellow" border="1">
  <tr>
    <td>status</td>
    <td>${status}</td>
  </tr>
   <tr>
    <td>Message</td>
    <td>${message}</td>
  </tr>
   <tr>
    <td>Path</td>
    <td>${path}</td>
  </tr>
  <tr>
    <td>timestamp</td>
    <td>${timestamp}</td>
  </tr>
</table>