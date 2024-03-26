package pages;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrivagoPages extends BasePage {
    protected WebDriverWait wait;
    private By busca = By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section[1]/div[2]/div[4]/div/div/div/form/div");
    private By autoComplete = By.id("input-auto-complete");
    private By destinoManaus = By.xpath("//*[text()='Cidade · Amazonas, Brasil']");
    private By btnPesquisar = By.xpath("//*[text()='Pesquisar']");
    private By ordenar = By.id("sorting-selector");
    private By avaliacaoESugestao = By.xpath("//*[text()='Avaliação e sugestões']");
    private By hotelPrimeiroResultado = By.xpath("//*[text()='ibis budget Manaus']");
    private By avaliacaoPrimeiroResultado = By.xpath("//*[text()='8.4']");
    private By valorPrimeiroResultado = By.xpath("//*[text()='R$175']");
    public TrivagoPages(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public TrivagoPages acessaPagina() {
        driver.get("http://www.trivago.com.br");
        return this;
    }

    public TrivagoPages selecionaDestino(String destino){
        waitElementAndClick(busca);
        waitElementAndSendkeys(autoComplete,destino);
        waitElementAndClick(destinoManaus);
        return this;
    }
    public TrivagoPages efetuaPesquisa(){
        waitElementAndClick(btnPesquisar);
        return this;
    }
    public TrivagoPages ordenarPorAvaliacaoESugestao(){
        waitElementAndClick(ordenar);
        waitElementAndClick(avaliacaoESugestao);
        return this;
    }
    public String retornaHotelPrimeiroElemento(){
        return driver.findElement(hotelPrimeiroResultado).getText();
    }
    public String retornaAvaliacaoPrimeiroElemento(){
        return driver.findElement(avaliacaoPrimeiroResultado).getText();
    }
    public String retornaValorPrimeiroElemento(){
        return driver.findElement(valorPrimeiroResultado).getText();
    }
}
