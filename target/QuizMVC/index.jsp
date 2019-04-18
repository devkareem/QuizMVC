<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quiz</title>
</head>
<body>
<h1>The Number Quiz</h1>
Your Current Score is ${quiz.score} .
<br/>
Guess the next number in the sequence.
<br/>
${quiz.question}
<br/>
<form action="Quiz" method="post">
    <label>Your Answer : <input type="number" name="num"></label>
    <br/>
    <input type="submit" value="Submit">
</form>
</body>
</html>
