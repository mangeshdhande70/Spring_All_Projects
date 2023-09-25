<%@ page import="in.pwskilss.service.WishMessageService"%>
<h1 style="color: red; text-align: center;">
<%= new WishMessageService().wishMsg("Nitin")%>
</h1>