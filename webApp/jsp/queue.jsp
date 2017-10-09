<%@ page import="config.URLConfig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.htm" %>
<ul class="list-group">



    <div class="row">
        <div class="col">
            <br />
            <h2>Current Items in Queue:</h2>
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
                <input class="btn btn-info" type = "submit" value = "Notify All" />
            </form>



            <br />
            <h4>Current Client Server List:</h4>
            <div class="list-group">

                <a href="${URLConfig.LOCALHOST}/server" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">${URLConfig.LOCALHOST}/server</h5>
                    </div>
                </a>
                <c:forEach items="${serverURLs}" var="serverURL">
                    <a href="${serverURL}" class="list-group-item list-group-item-action flex-column align-items-start">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">${serverURL}</h5>
                        </div>
                    </a>
                </c:forEach>
            </div>

            <br />
            <h4>Add new Client Server:</h4>

            <form action = "queueAddServerURL" method = "POST" onSubmit="alert('added');">
                <div class="form-group">
                    <label for="serverURL">Server URL</label>
                    <input type="text" class="form-control" id="serverURL" name="serverURL" placeholder="Enter URL">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

    </div>
<%@ include file="footer.htm" %>

