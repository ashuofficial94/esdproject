
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'>
    <link rel="stylesheet" href="assets/css/dashboard.css">
    <link rel="stylesheet" href="assets/css/domains.css">
    <script type="text/javascript" language="JavaScript">
        if(!sessionStorage.getItem('id')) {
            location.href = "index.jsp";
        }
    </script>
</head>
<body>
    <div class="container">
        <jsp:include page="navigation.jsp" />
        <div class="row" style = "margin: 5px;">
            <div class="col-sm-4">
                <jsp:include page="domains.jsp" />
            </div>
            <div class="col-sm-8">
                <jsp:include page="search.jsp" />
            </div>
        </div>
        <div class="row" style = "margin: 5px;">
            <div class="col-lg-4"></div>
            <div class="col-lg-8">
                <jsp:include page="student-list.jsp" />
            </div>
        </div>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="assets/js/dashboard.js"></script>
<script src="assets/js/navigation.js"></script>
<script src="assets/js/student-list.js"></script>
</html>