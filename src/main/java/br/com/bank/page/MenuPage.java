package br.com.bank.page;

import br.com.bank.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }
    public void acessarTelaEditarConta(){
        clicarLink("Contas");
        clicarLink("Listar");
    }
    public void acessarTelaMovimentacoes(){
        clicarLink("Criar Movimentação");
    }
}
