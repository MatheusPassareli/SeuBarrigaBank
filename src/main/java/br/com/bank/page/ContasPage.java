package br.com.bank.page;

import br.com.bank.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome){
        escreve(By.xpath("//*[@id=\"nome\"]"), nome);
    }
    public void salvar(){
        clicarBotao(By.xpath("/html/body/div[2]/form/div[2]/button"));
    }
    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class= 'alert alert-success']"));
    }
    public String obterMensagemDeErro(){
        return obterTexto(By.xpath("//div[@class= 'alert alert-danger']"));
    }

    public void clicarAlterarConta(String contaDoTeste) {
        obterCelula("Conta", contaDoTeste, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']"))
                .click();
    }
    public void clicarExcluirConta(String contaDoTeste) {
        obterCelula("Conta", contaDoTeste, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']"))
                .click();
    }
}