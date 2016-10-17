<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage=""%>
<%@page import="service.TitleDAO,domin.book,service.BookService"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Test-newsTitle</title>
  </head>
  
  <body>
  <table border="1">
      <tr>
          <td>ISBN</td>
          <td>Title</td>
          <td>AuthorID</td>
          <td>Publisher</td>
          <td>PublishDate</td>
          <td>Price</td>
          <td>something</td>
      </tr>
     <s:iterator value="list" status="st">
    <tr>
		<td><s:property value="ISBN"/></td>
      <td><s:property value="Title"/></td>
      <td><s:property value="AuthorID"/></td>
      <td><s:property value="Publisher"/></td>
      <td><s:property value="PublishDate"/></td>
      <td><s:property value="Price"/></td>
   	  <td> 
	  	<form action="DELETE">
	  		<input type="hidden" name="publisher.Publisher" value="<s:property value="Title"/>"/>
	  		<input type = "submit" value="删除"/>
	  	</form>
	  </td>
   	 
    </tr>
    </s:iterator>
  </table>
  <form action="back" >
    <input type="submit" value="回"/>
</form>
  </body>
</html>