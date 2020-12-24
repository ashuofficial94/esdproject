<%--
  Created by IntelliJ IDEA.
  User: ashutosh
  Date: 23/12/20
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <script type="text/javascript" language="JavaScript">
        if(!sessionStorage.getItem('id')) {
            location.href = "index.jsp";
        }
    </script>
</head>
<body>
    <div class="container">
        <jsp:include page="navigation.jsp"/>
        <div class="text-center">
            <h2>Add Domain</h2>
        </div>
        <form id="domain-form" style="position: absolute; left: 40%">
            <div class="form-group row">
                <label class="col-4 col-form-label-sm">Batch: </label>
                <select class="form-control col-8" id ="batch">
                    <option value="2021">2021</option>
                    <option value="2020">2020</option>
                    <option value="2019">2019</option>
                    <option value="2018">2018</option>
                    <option value="2017">2017</option>
                    <option value="2016">2016</option>
                    <option value="2015">2015</option>
                    <option value="2014">2014</option>
                    <option value="2013">2013</option>
                    <option value="2012">2012</option>
                    <option value="2011">2011</option>
                    <option value="2010">2010</option>
                    <option value="2009">2009</option>
                    <option value="2008">2008</option>
                    <option value="2007">2007</option>
                    <option value="2006">2006</option>
                    <option value="2005">2005</option>
                    <option value="2004">2004</option>
                    <option value="2003">2003</option>
                    <option value="2002">2002</option>
                    <option value="2001">2001</option>
                    <option value="2000">2000</option>
                    <option value="1999">1999</option>
                    <option value="1998">1998</option>
                    <option value="1997">1997</option>
                    <option value="1996">1996</option>
                    <option value="1995">1995</option>
                    <option value="1994">1994</option>
                    <option value="1993">1993</option>
                    <option value="1992">1992</option>
                    <option value="1991">1991</option>
                    <option value="1990">1990</option>
                </select>
            </div>
            <div class="form-group row">
                <label class="col-4 col-form-label-sm">Program: </label>
                <select class="form-control col-8" id="program">
                    <option value = "M.Tech.(CSE)">M.Tech.(CSE)</option>
                    <option value = "M.Tech.(ECE)">M.Tech.(ECE)</option>
                    <option value = "B.Tech.(CSE)">B.Tech.(CSE)</option>
                    <option value = "B.Tech.(ECE)">B.Tech.(ECE)</option>
                    <option value = "iM.Tech.(CSE)">iM.Tech.(CSE)</option>
                    <option value = "iM.Tech.(ECE)">iM.Tech.(ECE)</option>
                    <option value = "DT">DT</option>
                    <option value = "MS">MS</option>
                </select>
            </div>
            <div class="form-group row">
                <label class="col-4 col-form-label-sm">Capacity: </label>
                <input type="number" class="form-control col-8" id="capacity" required>
            </div>
            <div class="form-group row">
                <label class="col-4 col-form-label-sm">Qualification: </label>
                <input type="text" class="form-control col-8" id="qualification">
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success" id="submit-button">Add</button>
            </div>
            <div class="alert" id="notification" role="alert" style="width:350px"></div>
        </form>
    </div>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="assets/js/navigation.js"></script>
<script src="assets/js/add_domain.js"></script>
</html>
