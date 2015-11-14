<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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