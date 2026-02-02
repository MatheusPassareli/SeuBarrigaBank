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
        return obterTexto(By.xpath("/html/body/div[1]"));
    }
    public void excluirConta(){
        clicarBotao(By.xpath("//*[@id=\"tabelaContas\"]/tbody/tr/td[2]/a[2]/span"));
    }
    public void editarConta(){
        clicarBotao(By.xpath("//*[@id=\"tabelaContas\"]/tbody/tr/td[2]/a[1]/span"));
    }
}
