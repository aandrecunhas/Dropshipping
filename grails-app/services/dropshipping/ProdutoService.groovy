package dropshipping

import com.pucminas.Produto
import grails.transaction.Transactional
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

@Transactional
class ProdutoService {
    def grailsApplication
    private HTTPBuilder builder

    def capturarProdutos() {
        def url = "/home/andre/products.xml"
        def usuario = grailsApplication.config.fornecedores.webservice.usuario
        def senha = grailsApplication.config.fornecedores.webservice.senha

        if(usuario && senha) {
            httpGet(url) { xml, resp ->
                log.debug xml
                def sxml = xml.toString()
                if (sxml ==~ /.*Internal Server Error.*/ || sxml ==~ /.*The operation has timed out.*/) {
                    throw new RuntimeException("Erro ao consultar WS SAP: $sxml")
                } else {
                    def produtos = []
                    xml.'Body'.'Produtos'.each { n ->
                        def obr = parseProdutos(n)
                        produtos.add(obr)
                    }
                    log.debug "No Produtos: ${produtos.size()}"
                    produtos.each {
                        log.debug " - ${it}"
                    }
                    return produtos
                }
            }
        } else {
            def produtos = []
            def n = ""
            def obr = parseProdutos(n)
            produtos.add(obr)
            produtos.add(new Produto(nome: "Pen Driver", custo: 80, categoria:"TECNOLOGIA", fornecedor:"Kabum"))
            produtos.add(new Produto(nome: "Tenis", custo: 250, categoria:"CALCADO", fornecedor:"Netshoes"))

            return produtos
        }

    }

    def parseProdutos(n){
        new Produto(nome: "Relogio", custo: 100, categoria:"ACESSORIO", fornecedor:"Relogio MIX")
    }

    def httpGet(url,closure) {
        def http = new HTTPBuilder( url )
        log.debug "GET ${url}"
        http.request( Method.GET, ContentType.XML ) {
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            // response handler for a success response code:
            response.success = { resp, xml ->
                log.debug "RESP STATUS: ${resp.statusLine.statusCode}"
                return closure(xml,resp)
            }

            // handler for any failure status code:
            response.failure = { resp ->
                log.debug "RESP Unexpected error: ${resp.statusLine.statusCode} : ${resp.data}"
                throw new RuntimeException("Erro ao consultar WS SAP: ${resp.statusLine.statusCode} : ${resp.data}")
            }
        }
    }
}
