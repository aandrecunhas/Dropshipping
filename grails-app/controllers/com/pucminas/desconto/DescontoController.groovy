package com.pucminas.desconto

import com.pucminas.security.User
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND

@Secured("ROLE_ADMIN")
class DescontoController {

    def index() {
        [descontoInstanceList: Desconto.list()]
    }

    def create() {
        respond new Desconto(params)
    }

    def edit() {

    }

    @Transactional
    def save(Desconto descontoInstance) {

        if (descontoInstance == null) {
            notFound()
            return
        }

        descontoInstance.tipo = TipoDesconto.PORCENTAGEM
        descontoInstance.abrangenciaDesconto = AbrangenciaDesconto.GERAL

        if (descontoInstance.hasErrors()) {
            respond descontoInstance.errors, view:'create'
            return
        }

        descontoInstance.save flush:true
        redirect action: 'index'

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
