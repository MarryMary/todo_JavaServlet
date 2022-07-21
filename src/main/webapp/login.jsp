<%--
  Created by IntelliJ IDEA.
  User: MarryMary
  Date: 2022/07/20
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.html" %>

<div class="container">

    <div style="margin: 10px; padding: 10px; box-shadow: 0 0 8px gray;">
        <div class="text-center">
            <h1>Login</h1>
            <p>続行するにはログインしてください</p>
        </div>
        <hr>

        <form action="Action/Login.action" method="POST">
            <input type="text" name="login" class="form-control" placeholder="ログインID" style="margin-bottom: 10px;">
            <input type="password" name="password" class="form-control" placeholder="パスワード">
            <div class="text-center">
                <button type="submit" name="submit" class="btn btn-success" style="width: 90%; margin: 10px;">ログイン</button>
            </div>
        </form>

        <p>新規登録は<a href="Register.jsp">こちら</a></p>
    </div>

</div>

<%@ include file="footer.html" %>