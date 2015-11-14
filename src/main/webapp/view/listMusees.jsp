<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href='<s:url value="/ressources/assets/icon.png"/>'>

<title>Monaliza App</title>

<!-- Bootstrap core CSS -->
<link href='<s:url value="/ressources/css/bootstrap.min.css"/>'
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href='<s:url value="/ressources/css/jumbotron.css"/>'
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../ressources/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src='<s:url value="/ressources/js/ie-emulation-modes-warning.js"/>'></script>


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<s:url namespace="/" var="linkHome" action="list">
				</s:url>
				<a class="navbar-brand" href="${linkHome }">Monaliza App</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<s:if test="#session.admin ==null">
					<s:form cssClass="navbar-form navbar-right" action="login">
						<div class="form-group">
							<s:textfield type="text" name="login" placeholder="Login"
								cssClass="form-control" />
						</div>
						<div class="form-group">
							<s:textfield type="password" name="password"
								placeholder="Mot de passe" cssClass="form-control" />
						</div>
						<s:actionerror />
						<s:submit cssClass="btn btn-success" value="S'authentifier"></s:submit>
					</s:form>
				</s:if>
				<s:else>
					<div class="btn-group pull-right">
						<s:url namespace="/" var="linkDeconnexion" action="deconnexion">
						</s:url>
						<s:url namespace="/" var="linkEditMusees" action="editMusees">
						</s:url>
						<a class="btn btn-alert btn-danger" href="${linkEditMusees }"
							role="button"><span class="glyphicon glyphicon-wrench"></span>Administration</a>
						<a class="btn btn-alert btn-danger" href="${linkDeconnexion }"
							role="button"><span class="glyphicon glyphicon-log-out"></span>Se
							déconnecter</a>
					</div>
				</s:else>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Bienvenue!</h1>
			<p>
				Cette application vous permets de découvrir l'ensemble des musées
				existants dans la caiptale de la lumière Paris.<br>Vous pouvez
				découvrir les informations concernant chaque muséé. Vous pouvez même
				calculer l'iténiraire pour arriver à un musée de votre choix en
				fonction de votre positon. Amusez vous !!
			</p>
			<!--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>-->
		</div>
	</div>

	<div class="container">
		<!-- Liste des musées existants -->
		<div class="row">
			<c:forEach items="${listeMusees}" var="musee">
				<div class="col-md-4">
					<h2>${musee.nom}</h2>
					<p>${musee.description}</p>
					<p>
						<s:url namespace="/" var="linkShowMusee" action="show">
							<s:param name="idMusee">${musee.idMusee }</s:param>
						</s:url>
						<a class="btn btn-default" href="${linkShowMusee }" role="button">Plus
							de détails &raquo;</a>
					</p>
				</div>
			</c:forEach>
		</div>

		<hr>

		<footer>
			<p>&copy; EL HARRAOUI et T'FEIL 2015</p>
		</footer>
	</div>
	<!-- /container -->


	<!-- Code Javascript du framework bootstrap -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src='<s:url value="/ressources/js/bootstrap.min.js"/>'></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src='<s:url value="/ressources/js/ie10-viewport-bug-workaround.js"/>'></script>
	

</body>
</html>