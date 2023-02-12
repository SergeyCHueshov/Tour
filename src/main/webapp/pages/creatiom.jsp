<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<table>
    <tbody>
    <form action="user/create" method="post">
        <tr>
            <td><input type="text" name="name" placeholder="Enter Login"></td>
            <td><input type="text" name="surname" placeholder="Enter Password"></td>
            <td><input type="text" name="age" placeholder="Enter userType"></td>
            <td><input type="submit" value="Creation"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
