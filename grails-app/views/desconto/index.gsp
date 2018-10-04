
<%@ page import="com.pucminas.desconto.Desconto" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'desconto.label', default: 'Desconto')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-desconto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-desconto" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="categoria" title="${message(code: 'desconto.categoria.label', default: 'Categoria')}" />
					
						<g:sortableColumn property="fornecedor" title="${message(code: 'desconto.fornecedor.label', default: 'Fornecedor')}" />
					
						<g:sortableColumn property="abrangenciaDesconto" title="${message(code: 'desconto.abrangenciaDesconto.label', default: 'Abrangencia Desconto')}" />

						<g:sortableColumn property="tipo" title="${message(code: 'desconto.tipo.label', default: 'Tipo')}" />

						<g:sortableColumn property="valor" title="${message(code: 'desconto.tipo.label', default: 'Valor')}" />


					</tr>
				</thead>
				<tbody>
				<g:each in="${descontoInstanceList}" status="i" var="descontoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td>${descontoInstance.categoria?:"Todas"}</td>
					
						<td>${descontoInstance.fornecedor?:"Todas"}</td>
					
						<td>${fieldValue(bean: descontoInstance, field: "abrangenciaDesconto")}</td>

						<td>${fieldValue(bean: descontoInstance, field: "tipo")}</td>

						<td>${descontoInstance.valor}</td>


					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${descontoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
