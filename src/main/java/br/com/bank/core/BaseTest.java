package br.com.bank.core;

import br.com.bank.page.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.bank.core.DriverFactory.getDriver;
import static br.com.bank.core.DriverFactory.killDriver;

public class BaseTest {
    private  static LoginPage page = new LoginPage();

    @Rule
    public TestName testeName = new TestName();

//    @Before
//    public void inicializa(){
//        page.acessarTelaInicial();
//        page.setEmail("teste.matheus@email.com.br");
//        page.setSenha("tzKriYS7sqFhJAjl");
//        page.entrar();
//        page.confirmacaoLogin();
//    }

    @After
    public void finalizar() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.<File>getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testeName.getMethodName() + ".jpg"));

        if (Propriedades.FECHAR_BROWSER){
            killDriver();
        }
    }
}
