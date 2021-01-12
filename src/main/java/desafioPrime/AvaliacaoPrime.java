package desafioPrime;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;

public class AvaliacaoPrime {
	
	

	@Test
	//Sucesso
	public void loginSucesso() {
	System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	 driver.manage().window().maximize();
	 driver.get("http://automationpractice.com/index.php");
	 driver.findElement(By.linkText("Sign in")).click();
	 driver.findElement(By.id("email")).sendKeys("vitor.vieira10@hotmail.com");
	 driver.findElement(By.id("passwd")).sendKeys("testesenha");
	 driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
	 
	 	Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
	 	Assert.assertEquals("My account", (driver.findElement(By.className("navigation_page")).getText()));
	 	
	 		 	
	 driver.quit();
	   
	}
	
	
	@Test
	//Erro
	public void loginFalha() {
	System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	 driver.manage().window().maximize();
	 driver.get("http://automationpractice.com/index.php");
	 driver.findElement(By.linkText("Sign in")).click();
	 driver.findElement(By.id("email")).sendKeys("vitor.vieira10@hotmail.com");
	 driver.findElement(By.id("passwd")).sendKeys("123");
	 driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
	 
	 
	 	Assert.assertEquals("Invalid password.", driver.findElement(By.cssSelector("ol > li")).getText());
	 
	 	 		 	
	 driver.quit();
	   
	}
	
	@Test
	//Falha - mau funcionamento de filtro categoria
	  public void falhaDeSistemaFiltro() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
			
	    driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("(//a[contains(text(),\'Dresses\')])[5]")).click();
	    driver.findElement(By.id("layered_category_9")).click();
	    
	    Thread.sleep(600);
	    	      
	    	Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).isDisplayed());
	    	Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")).isDisplayed());
	    	Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")).isDisplayed());
	    	Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[1]/div/a[1]/img")).isDisplayed());
	    	Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[1]/div/a[1]/img")).isDisplayed());
	    driver.quit();
	      
	     
	
	}
}