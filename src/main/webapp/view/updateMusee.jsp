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
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src='<s:url value="/assets/js/ie-emulation-modes-warning.js"/>'></script>


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
						<s:url namespace="/" var="linkListMusees" action="list">
						</s:url>
						<a class="btn btn-alert btn-danger" href="${linkListMusees }"
							role="button">Front Office</a> <a
							class="btn btn-alert btn-danger" href="${linkDeconnexion }"
							role="button">Se déconnecter</a>
					</div>
				</s:else>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<div class="container">
		<h2 class="sub-header">Modification du musée : ${musee.nom }</h2>
		<s:form method="post" enctype="multipart/form-data"
			action="saveUpdate" acceptcharset="UTF-8" cssClass="well">
			<fieldset>
				<s:hidden name="musee.idMusee" />
				<div class="form-group">
					<label for="nom">Nom du musée</label>
					<s:textfield type="text" cssClass="form-control" key="Nom du musée"
						name="musee.nom" />
				</div>
				<div class="form-group">
					<label for="adresse">Adresse du musée</label>
					<s:textfield type="text" cssClass="form-control"
						key="Adresse du musée" name="musee.adresse" />
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<s:textarea type="text" cssClass="form-control" key="Description"
						name="musee.description" />
				</div>
				<div class="form-group">
					<label for="url">Url</label>
					<s:textfield type="url" cssClass="form-control" key="URL"
						name="musee.url" />
				</div>
				<div class="form-group">
					<img
						src="<s:url action='ImageAction' > <s:param name="idMusee">${musee.idMusee }</s:param> </s:url>" />
					<s:file type="file" name="museeImage" cssClass="form-control"
						label="Image du musée" size="10" />
				</div>
				<s:submit type="button" cssClass="btn btn-default btn-success "
					key="Enregistrer les modifications"></s:submit>

			</fieldset>
		</s:form>


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