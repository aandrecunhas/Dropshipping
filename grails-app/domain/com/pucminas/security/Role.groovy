package com.pucminas.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	private static final long serialVersionUID = 1

	String authority
	String label

	Role(String authority) {
		this()
		this.authority = authority
	}

	static getPermissoes() {
		[
				findOrSaveWhere(authority: 'ROLE_ADMIN', label: 'Administrador'),
				findOrSaveWhere(authority: 'ROLE_CONTROLE_VENDAS', label: 'Gerenciar Vendas'),
				findOrSaveWhere(authority: 'ROLE_RELATORIOS', label: 'Relatórios'),
				findOrSaveWhere(authority: 'ROLE_SAC', label: 'Gerenciar SAC'),
				findOrSaveWhere(authority: 'ROLE_PROPAGANDA', label: 'Gerenciar Propaganda'),

		]
	}

	static init() {
		withTransaction {
				getPermissoes()
		}
	}


	static constraints = {
		authority blank: false, unique: true
	}

	static mapping = {
		cache true
	}


	String toString() {
		label ?: authority
	}
}
