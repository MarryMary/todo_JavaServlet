<%--
  Created by IntelliJ IDEA.
  User: MarryMary
  Date: 2022/07/20
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.html" %>

<a href="Action/Logout.action">ログアウト</a>
<a href="Action/AcDel.action">アカウント削除</a>

<form action="Action/ToDoIns.action" method="POST">
    <input type="text" name="text">
    <button type="submit">追加</button>
</form>

<ul>
    <c:forEach var="todo" items="${list}">
        <li>${list.Text}：<a href="Action/ToDoRem.action?id=${list.Id}">削除</a></li>
    </c:forEach>
</ul>

<%@ include file="footer.html" %>