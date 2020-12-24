<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/login.css">
</head>
<body data-new-gr-c-s-check-loaded="14.988.0" data-gr-ext-installed="">

    <div class="container-fluid">
        <div class="centered">
            <div class="panel panel-primary">
                <div class="panel-heading">Login</div>
                <div class="panel-body">
                    <form id="login_form">

                        <div class="form-group">
                            <label>Email Address:</label>
                            <input type="email" placeholder="E-mail" class="form-control active" id="email" required="">
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-sm btn-success" id="submit-button">Login</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="alert alert-danger" id="login-alert" role="alert" style="display: none; margin-top: 20px">
                Invalid Email Address!!
            </div>
        </div>
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="assets/js/login.js"></script>
</body>
</html>

