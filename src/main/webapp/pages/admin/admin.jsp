<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creation of Tour</title>
</head>
<body>
<table>
    <tbody>
    <form action="tour/create" method="post">
        <tr>
            <td><input type="text" name="name_ofTour" placeholder="Enter Name"></td>
            <td><input type="text" name="cost_ofTour" placeholder="Enter Cost"></td>
            <td><input type="text" name="state_ofTour" placeholder="Enter State"></td>
            <td><input type="text" name="hotel" placeholder="Enter Hotel"></td>
            <td><input type="text" name="attraction" placeholder="Enter Attrarction"></td>
            <td><input type="submit" value="Create Tour"></td>
        </tr>
    </form>
    </tbody>
</table>
<table>
    <tbody>
    <form action="user/create" method="post">
        <tr>
            <td><input type="text" name="name" placeholder="Enter name"></td>
            <td><input type="text" name="surname" placeholder="Enter surname"></td>
            <td><input type="text" name="age" placeholder="Enter age"></td>
            <td><input type="submit" value="Creation Person"></td>
        </tr>
    </form>
    </tbody>
</table>
<table>
    <tbody>
    <form action="tour/read" method="post">
        <tr>
            <td><input type="submit" value="Choose Tour"></td>
        </tr>
    </form>
    </tbody>
</table>
<table>
    <tbody>
    <form action="user/read" method="post">
        <tr>
            <td><input type="submit" value="Read Users"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
