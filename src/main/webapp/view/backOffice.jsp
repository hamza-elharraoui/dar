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
							role="button"><span class="glyphicon glyphicon-new-window"></span>Front
							Office</a> <a class="btn btn-alert btn-danger"
							href="${linkDeconnexion }" role="button"><span
							class="glyphicon glyphicon-log-out"></span>Se déconnecter</a>
					</div>
				</s:else>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-7">
				<h2 class="sub-header">Liste des musées</h2>
				<div class="table-responsive">
					<table class="table table-bordered table-striped table-condensed">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Url</th>
								<th>Adresse</th>
								<th>Description</th>
								<th>Nombre d'avis</th>
								<th>Modifier</th>
								<th>Supprimer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listeMusees}" var="musee">
								<tr>
									<td><s:url namespace="/" var="linkShowMusee" action="show">
											<s:param name="idMusee">${musee.idMusee }</s:param>
										</s:url><a href="${linkShowMusee }">${musee.nom}</a></td>
									<td>${musee.url}</td>
									<td>${musee.adresse}</td>
									<td>${musee.description}</td>
									<td>${musee.avis.size()}</td>
									<td><s:url namespace="/" var="linkUpdate" action="update">
											<s:param name="idMusee">${musee.idMusee }</s:param>
										</s:url> <a class="btn btn-success pull-left" href="${linkUpdate}"><span
											class="glyphicon glyphicon-pencil"></span>Modifier</a></td>
									<td><s:url namespace="/" var="linkDelete" action="delete">
											<s:param name="idMusee">${musee.idMusee }</s:param>
										</s:url><a class="btn btn-danger pull-right" href="${linkDelete}"><span
											class="glyphicon glyphicon-trash"></span>Supprimer</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<s:url namespace="/" var="linkAdd" action="add">
				</s:url>
				<a class="btn btn-success" href="${linkAdd}">Ajouter un nouveau
					musée</a>
			</div>
			<div class="col-xs-8 col-sm-8 col-md-5">

				<h2 class="sub-header">Liste des admins</h2>
				<div class="table-responsive">
					<table class="table table-bordered table-striped table-condensed">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Login</th>
								<th>Email</th>
								<th>Supprimer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listeAdmins}" var="admin">
								<tr>
									<td><s:url namespace="/" var="linkShowAdmin"
											action="showAdmin">
											<s:param name="idAdmin">${admin.idAdmin }</s:param>
										</s:url><a href="${linkShowAdmin }">${admin.nom}</a></td>
									<td>${admin.login}</td>
									<td>${admin.email}</td>
									<td><s:url namespace="/" var="linkDelete"
											action="deleteAdmin">
											<s:param name="idAdmin">${admin.idAdmin}</s:param>
										</s:url><a class="btn btn-danger pull-right" href="${linkDelete}"><span
											class="glyphicon glyphicon-trash"></span>Supprimer</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<s:url namespace="/" var="linkAdd" action="addAdmin">
				</s:url>
				<a class="btn btn-success" href="${linkAdd}">Créer un nouveau
					admin</a>

			</div>
		</div>
	</div>

	<hr>

	<footer>
		<p>&copy; EL HARRAOUI et T'FEIL 2015</p>
	</footer>
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