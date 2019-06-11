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

    <article>
      <p>Alla dagar framåt:</p>
    </article>
    <ul style="list-style-type:none;">
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/fishing">Fishing</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/outdoorseating">Outdoorseating</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/sunbathing">Sunbathing</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/volleyball">Volleyball</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/windsurfing">Windsurfing</a></li>
    </ul>
    <article>
      <p>Specifik dag: </p>
    </article>
    <ul style="list-style-type:none;">
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/fishing/1">Fishing </a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/outdoorseating/1">Outdoorseating</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/sunbathing/1">Sunbathing</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/volleyball/1">Volleyball</a></li>
      <li><a href="http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/windsurfing/1">Windsurfing</a></li>
    </ul>
  </article>

  <article>
    <button onclick="location.href='http://localhost:8080/JavaEEuppgift2_war_exploded/weatherActivityApi/v1.0/listusers'" type="button">List Users</button>
  </article>
  </body>
</html>
