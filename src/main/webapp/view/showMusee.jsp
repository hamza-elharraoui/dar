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
<link href='<s:url value="/ressources/css/custom.css"/>'
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar list-group">
					<li class="list-group-item">Liste des musées :</li>
					<c:forEach items="${listeMusees}" var="musee">
						<s:url namespace="/" var="linkShowMusee" action="show">
							<s:param name="idMusee">${musee.idMusee }</s:param>
						</s:url>
						<li class="list-group-item"><a href="${linkShowMusee }">
								${musee.nom } </a></li>
					</c:forEach>
				</ul>

			</div>


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<h1>${musee.nom }</h1>
					<img alt="${musee.nom}" class="img-thumbnail image"
						src="<s:url action='ImageAction' > <s:param name="idMusee">${musee.idMusee }</s:param> </s:url>">
					<!-- Détails du musée -->
					<div class="row">
						<section class="col-sm-8">
							<p>${musee.description }</p>
						</section>
						<section class="col-sm-4">
							<h5>Informations générales :</h5>
							<br>
							<ul>
								<li>Nom : ${musee.nom }</li>
								<li>Adresse : ${musee.adresse }</li>
								<li>Site web : ${musee.url }</li>
							</ul>
						</section>
					</div>
					<hr>

				</div>
				<div class="row">
					<div class="col-sm-6 col-md-6 list-group">
						<h2 class="sub-header">Avis de nos visiteurs !</h2>

						<table class="table table-bordered table-striped table-condensed">
							<thead>
								<tr>
									<th>Nom</th>
									<th>Comentaire</th>
									<s:if test="#session.admin !=null">
										<th>Opération</th>
									</s:if>
								</tr>
							</thead>
							<tbody id="tabAvis">
								<c:forEach items="${musee.avis}" var="avis">
									<tr>
										<td><h4 class="list-group-item-heading">${avis.nom }</h4></td>
										<td><p class="list-group-item-text">${avis.description}</p></td>
										<s:if test="#session.admin !=null">
											<td><a class="btn btn-danger btn-xs"
												onclick="deleteAvis(${musee.idMusee},${avis.idAvis });"><span
													class="glyphicon glyphicon-trash"></span>Supprimer</a></td>
										</s:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
					<s:if test="#session.admin ==null">
						<div class="col-sm-6 col-md-6 main">
							<h2 class="sub-header">Donner votre avis</h2>
							<div class="form-group">
								<s:form id="formAvis" method="post" action="postAvis"
									acceptcharset="UTF-8" cssClass="form-vertical well">
									<fieldset>
										<s:param name="idMusee">${musee.idMusee}</s:param>
										<s:hidden name="idMusee" />
										<div class="form-group">
											<label for="nom">Votre nom complet :</label>
											<s:textfield type="text" key="Votre nom complet"
												cssClass="form-control" name="avis.nom" />
										</div>
										<div>
											<label for="description">Donnez votre avis :</label>
											<s:textarea cssClass="form-control"
												key="Contenu de votre commentaire" name="avis.description" />
										</div>
										<div class="btn-group">

											<s:submit type="button"
												cssClass="btn btn-default btn-success "
												key="Soumettre votre avis" />
										</div>
									</fieldset>
								</s:form>
							</div>

						</div>
					</s:if>
				</div>
				<footer>
					<p>&copy; EL HARRAOUI et T'FEIL 2015</p>
				</footer>
			</div>
		</div>

	</div>
	<!-- /container -->


	<!-- Code Javascript du framework bootstrap -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src='<s:url value="/ressources/js/bootstrap.min.js"/>'></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src='<s:url value="/ressources/js/ie10-viewport-bug-workaround.js"/>'></script>

	<script>
			$('#formAvis').on('submit', function(e) {
				// J'empêche le comportement par défaut du navigateur, c-à-d de soumettre le formulaire
				e.preventDefault(); 
				// L'objet jQuery du formulaire
		        var $this = $(this); 
		 
		        // Je récupère les valeurs
		        var nom = $('#formAvis_avis_nom').val();
		        var description = $('#formAvis_avis_description').val();
		 
		        
		        // verification 
		        if(nom === '' || description === '') {
		            alert('Les champs doivent êtres remplis');
		        } else {
		        	$.get('postAvis?idMusee='+${idMusee}+"&avis.nom="+nom+"&avis.description="+description,function(data) {
						$('#tabAvis').html(data);
		            });
		        	// pour vider le formulaire de soumission d'avis
		        	$(':input','#formAvis').val('');
			}
		    });
		function deleteAvis(idM,idA) {
			$.get('deleteAvis?idMusee='+idM+"&idAvis="+idA, function(data) {
				$('#tabAvis').html(data);
			});
		}
		
	</script>
</body>
</html>