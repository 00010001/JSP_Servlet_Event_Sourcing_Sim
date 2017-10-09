<%@ page import="config.ServerConfig" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.htm" %>
<ul class="list-group">

    <div class="row">
        <div class="col">
            <br />
            <h2>Current Items on Server:</h2>
            <div class="list-group">
                <c:forEach items="${eventList}" var="event">
                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">${event.type} : ${event.amount}</h5>
                            <small>${event.date}</small>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
        <div class="col">
            <br />
            <h2>Operations:</h2>
            <form action = "serverGet" method = "POST" onSubmit="alert('Send');">
                <input class="btn btn-info" type = "submit" value = "Get Single Event From Queue" />
            </form>
            <br />
            <form action = "getAllEvents" method = "POST" onSubmit="alert('Send');">
                <input class="btn btn-info" type = "submit" value = "Get All Events From Queue" />
            </form>
            <br />
            <form action = "saveEventsToFile" method = "GET" onSubmit="alert('Send');">
                <input class="btn btn-warning" type = "submit" value = "Save Events To File" />
            </form>
            <br />

            <h2>Configuration</h2>
            <form action = "serverUpdateSettings" method = "POST" onSubmit="alert('Updated');" class="form-inline">
                <div class="form-group">
                    <%--<label for="staticEmail2" class="sr-only">Email</label>--%>
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="When queue notify fetch">
                </div>
                <c:set var = "fetchAll" scope = "session" value = "${ServerConfig.onNotifyFetchAllEvents}"/>
                <div class="form-group mx-sm-3">
                    <select name="onNotify" class="form-control form-control-sm">
                        <option value="single" ${fetchAll eq false ? 'selected="selected"' : ''}>Single Event</option>
                        <option value="all" ${fetchAll eq true ? 'selected="selected"' : ''}>All Events</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary btn-sm">Update</button>
            </form>
        </div>

    </div>
    <%@ include file="footer.htm" %>
