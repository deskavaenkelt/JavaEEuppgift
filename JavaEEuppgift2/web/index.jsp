<%--
  Created by IntelliJ IDEA.
  User: 87sofrid byt why
  Date: 2019-05-07
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Aktivitets väder api</title>
    <link rel = "stylesheet" type = "text/css" href = "styles.css" />
  </head>
  <body>

  <article>
    <h1>Aktivitetsväderapi v1.0</h1>
    <p>Startsida som visar att servern är igång med länkar till vårt API(initialt iaf)</p>
  </article>

  <article>
    <h2>API frågor:</h2>
    <ul style="list-style-type:none;">
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/place">Place</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/test">Test</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/open">Open</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/secured">Secured</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/secured/listusers">List Users</a></li>
    </ul>
  </article>

  <article>
    <button onclick="location.href='http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/listusers'" type="button">List Users</button>
  </article>
  </body>
</html>
