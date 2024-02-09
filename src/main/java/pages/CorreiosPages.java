package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CorreiosPages {
    private WebDriver driver;
    private By endereco = By.id("endereco");
    private By pesquisar = By.id("btn_pesquisar");
    public CorreiosPages(WebDriver driver){
        this.driver = driver;
    }
    public CorreiosPages acessaPagina(){
        driver.get("http://www.buscacep.correios.com.br");
        return this;
    }
    public CorreiosPages pesquisa(){
        driver.findElement(endereco).sendKeys("69005-040");
        driver.findElement(pesquisar).click();
        return this;
    }
}
