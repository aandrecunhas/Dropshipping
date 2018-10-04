package dropshipping

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class ProdutoController {
    def produtoService
    def list() {
        [produtoList: produtoService.capturarProdutos()]
    }
}
