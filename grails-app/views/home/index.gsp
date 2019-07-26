<!doctype html>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Weather Wolf</title>
</head>

<body>
  <div id="content" role="main">
    <g:include view="subforms/searchbar.gsp"/>
    <sec:ifLoggedIn>

      <div class="backcard">
        <h2><g:message code="msg.hello" default="Hello"/>, <sec:username/></h2>

        <div class="grid-2-bl">
          <div>
            <p>Your favorite location: <strong>${user.favoriteLocation}</strong></p>
          </div>
          <div>
            <sec:ifAnyGranted roles="ROLE_ADMIN">
              <g:link controller="admin" action="index"><button class="btn-white p-1 m all-center">Admin Portal</button></g:link>
            </sec:ifAnyGranted>
            <g:link controller="account" action="index"><button class="btn-white p-1 m all-center">Change Account Settings</button></g:link>
          </div>
        </div>
      </div>
      <g:include view="subforms/searchresults.gsp"/>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
      <g:include view="subforms/loginform.gsp"/>
    </sec:ifNotLoggedIn>
  </div>
</body>
</html>
