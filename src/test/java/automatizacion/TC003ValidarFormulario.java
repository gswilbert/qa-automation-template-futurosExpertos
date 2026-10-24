package automatizacion;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC003ValidarFormulario {
      //Script para Validar el Login Page 
   private WebDriver driver;
   private WebDriverWait wait;


    @BeforeEach 
     public void inicializarNavegador(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Inicializar Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void pausa() throws InterruptedException {
        Thread.sleep(3000);
    }
    @Test 
    public void completarFormularioContacto() throws InterruptedException {
        //Abrir nuestro Navegador.
        driver.get("https://www.automationtesting.co.uk/contactForm.html");

        pausa();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");

    //Completar el Nombre en Formulario
        WebElement nombre = wait.until(ExpectedConditions.elementToBeClickable(By.name("first_name")));
        nombre.sendKeys("Wilbert");

        wait.until(ExpectedConditions.attributeToBe(By.name("first_name"), "value", "Wilbert"));

    //Completar el Apellido en Formulario
        WebElement apellido = wait.until(ExpectedConditions.elementToBeClickable(By.name("last_name")));
        apellido.sendKeys("Gomez");

        wait.until(ExpectedConditions.attributeToBe(By.name("last_name"), "value", "Gomez"));

         js.executeScript("document.body.style.zoom='70%'");

    //Completar el Email en Formulario
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
        email.sendKeys("test@qa.com.sv");

        wait.until(ExpectedConditions.attributeToBe(By.name("email"), "value", "test@qa.com.sv"));
         js.executeScript("document.body.style.zoom='60%'");
        
    //Completar el Comentario en Formulario
        String msj = "Este es un mensaje de prueba para llenar/Validar el formulario.";
        WebElement comentario = wait.until(ExpectedConditions.elementToBeClickable(By.name("message")));
        comentario.sendKeys(msj);

        wait.until(ExpectedConditions.attributeToBe(By.name("message"), "value", msj));
         js.executeScript("document.body.style.zoom='50%'");
        pausa();

     //Enviar informacion ingresada en el formulario 
     WebElement btnSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='SUBMIT']")));
        btnSubmit.click();

     js.executeScript("document.body.style.zoom='80%'");
        pausa();

    //Validar mensaje de formulario llenado con exito.
        WebElement formularioCompletado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='col-8 col-12-small'] h3")));
        String mensajeExitoso = formularioCompletado.getText();

        Assertions.assertEquals("Thank you for your mail!", mensajeExitoso);
    
    //Uso de condicional para validar el login exitoso
        if(mensajeExitoso.equals("Thank you for your mail!")){
            System.out.println("Formulario llenado Exitosamente");
            pausa();
    }else{
        System.out.println("Formulario no fue llenado Exitosamente");
        Assertions.fail("Se esperaba el titulo de Formulario: Thank you for your mail! " 
        + "\n Pero se encontró: " + mensajeExitoso);
        pausa();
    }

    }

    //Test 2: Reset Formulario
    @Test 
     public void resetFormulario() throws InterruptedException {
    //Abrir nuestro Navegador.
        driver.get("https://www.automationtesting.co.uk/contactForm.html");
        
        //Completar Formulario
        driver.findElement(By.name("first_name")).sendKeys("Wilbert");
        driver.findElement(By.name("last_name")).sendKeys("Gomez");
        driver.findElement(By.name("email")).sendKeys("test@qa.com.sv");
        driver.findElement(By.name("message")).sendKeys("Este es un mensaje de prueba para llenar/Validar el formulario.");

        pausa();
    //Resetear Formulario
        driver.findElement(By.cssSelector("input[value='RESET']")).click();

        pausa();
     }

    @AfterEach 
    public void cerrarSesion(){
            driver.quit();
    }
       
}
