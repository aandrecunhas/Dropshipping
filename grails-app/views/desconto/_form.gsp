<%@ page import="com.pucminas.desconto.AbrangenciaDesconto; com.pucminas.desconto.Desconto" %>


<div class="fieldcontain ${hasErrors(bean: descontoInstance, field: 'categoria', 'error')} ">
	<label for="categoria">
		<g:message code="desconto.categoria.label" default="Nome" />

	</label>
	<g:textField name="nome" value="${descontoInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: descontoInstance, field: 'categoria', 'error')} ">
	<label for="categoria">
		<g:message code="desconto.categoria.label" default="Categoria" />
		
	</label>
	<g:textField name="categoria" value="${descontoInstance?.categoria}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: descontoInstance, field: 'fornecedor', 'error')} ">
	<label for="fornecedor">
		<g:message code="desconto.fornecedor.label" default="Fornecedor" />
		
	</label>
	<g:textField name="fornecedor" value="${descontoInstance?.fornecedor}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: descontoInstance, field: 'valor', 'error')} ">
	<label for="fornecedor">
		<g:message code="desconto.fornecedor.label" default="Valor" />

	</label>
	<g:textField name="valor" value="${descontoInstance?.valor}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: descontoInstance, field: 'abrangenciaDesconto', 'error')} required">
	<label for="abrangenciaDesconto">
		<g:message code="desconto.abrangenciaDesconto.label" default="Abrangencia Desconto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select from="${com.pucminas.desconto.AbrangenciaDesconto.list()}" optionValue="nome" name="abrangenciaDesconto"></g:select>
</div>

<div class="fieldcontain ${hasErrors(bean: descontoInstance, field: 'tipoDesconto', 'error')} required">
	<label for="tipoDesconto">
		<g:message code="desconto.tipoDesconto.label" default="Tipo Desconto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select from="${com.pucminas.desconto.TipoDesconto.list()}" optionValue="nome" name="tipoDesconto"></g:select>
</div>