package br.com.bank.page;

import br.com.bank.core.BasePage;
import org.openqa.selenium.By;

public class MovimentacoesPage extends BasePage {

    public void escolherTipoMovimentacao(String valor){
        selecionarCombo(By.id("tipo"), valor);
    }
    public void escolherDataMovimentacao(String data){
        escreve(By.id("data_transacao"), data);
    }
    public void escolherDataPagamento(String data){
        escreve(By.id("data_pagamento"), data);
    }
    public void descricao(String descricao){
        escreve(By.id("descricao"), descricao);
    }
    public void interessado(String interessado){
        escreve(By.id("interessado"), interessado);
    }
    public void valor(String valor){
        escreve(By.id("valor"), valor);
    }
    public void escolherConta(String conta){
        selecionarCombo(By.id("conta"), conta);
    }
    public void escolherSituacao(String situacao){
        if (situacao.equals("Pago")){
            clicarRadio(By.id("status_pago"));
        }
        if (situacao.equals("Pendente")){
            clicarRadio(By.id("status_pendente"));
        }
    }
    public void salvar(){
        clicarBotao(By.className("btn-group"));
    }
    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("/html/body/div[1]"));
    }
}