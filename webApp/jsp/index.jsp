<%@ page import="model.UserCashAccount" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.htm" %>

    <div class="row">
        <div class="col">
            <br />
            <h2>Your balance: $${UserCashAccount.cashBalance}</h2>
            <h5>Please make your choice</h5>
            <form action = "SendEventByHttpPost" method = "POST" onSubmit="alert('Send');">
                <br />
                Operation Type:
                <select class="form-control" name="type">
                    <option value="withdraw">Withdraw</option>
                    <option value="deposit">Deposit</option>
                </select>
                Amount:
                <select class="form-control" name="amount">
                    <option value="100">100</option>
                    <option value="200">200</option>
                    <option value="500">500</option>
                    <option value="1000">1000</option>
                </select>
                <br />
                <input class="btn btn-primary" type = "submit" value = "Submit" />
            </form>
        </div>
    </div>

<%@ include file="footer.htm" %>


