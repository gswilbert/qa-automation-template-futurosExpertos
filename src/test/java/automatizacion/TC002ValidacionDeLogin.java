package automatizacion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002ValidacionDeLogin {
//Script para Validar el Login Page 
   WebDriver driver;

//Acciones que se ejecutaran antes de cada test.
    @BeforeEach 
    public void inicializarNavegador(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//Test 1: Validar el titulo de la pagina antes de realizar el login
    @Test 
    public void validarTitutloDeLaPagina(){
        //Abrir nuestro Navegador.
        driver.get("https://the-internet.herokuapp.com/login");

        //Obtener Titulo de Sitio WEB
        String tituloActual = driver.getTitle();
        String tituloEsperado = "The Internet";

    //Validar el titulo del sitio Web
        Assertions.assertEquals(tituloEsperado, tituloActual, "El titulo Encontrado no coincide con lo esperado");

        System.out.println("Titulo fue validado correctamente");

    }
//Test 2: Validar un Login Exitoso
    @Test 
    public void loginExitoso(){
        //Abrir nuestro Navegador.
        driver.get("https://the-internet.herokuapp.com/login");

    //Ingresar las Credenciales de Autenticación
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //driver.findElement(By.id("submit")).click();
        //Validacion de ULR
    String urlEsperada = "https://the-internet.herokuapp.com/login";

    Assertions.assertEquals(urlEsperada, 
        driver.getCurrentUrl(), "La Url encontrada no coincide con la Esperada");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    /*//Validacion de ULR
    String urlEsperadaLogin = "https://the-internet.herokuapp.com/secure";

    Assertions.assertEquals(urlEsperadaLogin, 
        driver.getCurrentUrl(), "La Url encontrada no coincide con la Esperada");*/

    //Validacion de  Manejo de Login Exitoso
    WebElement mensajeLoginExitoso = driver.findElement(By.id("flash"));
    String textoMensaje = mensajeLoginExitoso.getText();
    
    //Uso de condicional para validar el login exitoso
        if(textoMensaje.contains("You logged into a secure area!")){
            System.out.println("Login Exitoso Validado correctamente");
    }else{
        System.out.println("Error en el mensaje de Login Encontrado");
        Assertions.fail("Se esperaba el mensaje: You logged into a secure area! " 
        + "\n Pero se encontró: " + textoMensaje);
    }

    }
//Accciones a ejecutar despues de cada Test
    @AfterEach 
    public void cerrarSesion(){
            driver.quit();
    }
}
