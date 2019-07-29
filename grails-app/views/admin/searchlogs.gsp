<%--
  Created by IntelliJ IDEA.
  User: kvancott
  Date: 7/26/2019
  Time: 10:49 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title></title>
</head>

<body>
  <g:include view="subforms/navadmin.gsp"/>
  <div class="backcard">
    <g:include view="subforms/msg.gsp"/>
    <table id="user-table" class="display">
      <thead>
        <tr>
          <th>ID</th>
          <th>Date Time</th>
          <th>Search</th>
          <th>User</th>
        </tr>
      </thead>
      <tbody>
        <g:each in="${searchLogDataSet}" var="searchLog">
          <tr>
            <td>${searchLog.id}</td>
            <td>${searchLog.date}</td>
            <td>${searchLog.searchString}</td>
            <td>${searchLog.user.username}</td>
          </tr>
        </g:each>
      </tbody>
    </table>

  </div>
  <script>
      $(document).ready(function () {
          $('#user-table').DataTable({
              select: true,
              ordering: true
          });
      });
  </script>
</body>
</html>