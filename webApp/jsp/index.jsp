
<%@ include file="header.htm" %>

    <div class="row">
        <div class="col">
            <br />
            <h2>Please make your choice:</h2>
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


