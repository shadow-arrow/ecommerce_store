<!doctype html>
<html lang="en">
<head>
    <title th:text="${message}"></title>
</head>
<body>
<table border="1">
    <tr>
        <td>Error Message</td>
        <td>${message}</td>
    </tr>
    <tr>
        <td>Status Code</td>
        <td>${status}</td>
    </tr>
    <tr>
        <td>Exception</td>
        <td>${exception}</td>
    </tr>
    <tr>
        <td>Stacktrace</td>
        <td>
            <pre>${trace}</pre>
        </td>
    </tr>
    <tr>
        <td>Binding Errors</td>
        <td>${errors}</td>
    </tr>
</table>
</body>
</html>