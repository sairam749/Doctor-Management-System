<%@ page isELIgnored="false" isErrorPage="true"%>
<h1 Style="color:red;text-align:center">500.jsp(Global Error Page)</h1>
<h3 Style="color:red;text-align:center">Client Side Problem Try Again</h3>
<table align="center" border="1" bgcolor="yellow" >
  <tr>
    <td>Status</td>
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