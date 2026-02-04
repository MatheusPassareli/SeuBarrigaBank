package br.com.bank.page;

import br.com.bank.core.BasePage;
import br.com.bank.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/");
    }

    public void setEmail(String email){
        escreve(By.xpath("//*[@id=\"email\"]"), email);
    }

    public void setSenha(String senha){
        escreve(By.xpath("//*[@id=\"senha\"]"), senha);
    }

    public void entrar(){
        clicarBotao(By.xpath("/html/body/div[2]/form/button"));
    }

    public boolean confirmacaoLogin(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'alert-success') and contains(.,'Bem vindo, MatheusP!')]")
        )).isDisplayed();
    }
}
