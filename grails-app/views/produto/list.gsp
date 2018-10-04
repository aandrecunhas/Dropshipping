
<%@ page import="com.pucminas.security.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'Produto')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-user" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="nome" title="${message(code: 'user.username.label', default: 'nome')}" />

            <g:sortableColumn property="valor" title="${message(code: 'user.accountExpired.label', default: 'Custo')}" />
            <g:sortableColumn property="valor" title="${message(code: 'user.accountExpired.label', default: 'Categoria')}" />
            <g:sortableColumn property="valor" title="${message(code: 'user.accountExpired.label', default: 'Fornecedor')}" />


        </tr>
        </thead>
        <tbody>
        <g:each in="${produtoList}" status="i" var="produtoInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>${produtoInstance?.nome}</td>

                <td>${produtoInstance?.custo}</td>

                <td>${produtoInstance?.categoria}</td>

                <td>${produtoInstance?.fornecedor}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${userInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>
