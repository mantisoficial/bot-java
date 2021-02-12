package java_atos_bot_package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscaPorNome {
	public Integer antigoTdMaxI;

	public void buscarNome(String nome) {
		int localAntigo;
		SendEmailSSL sendEmail = new SendEmailSSL();

		if (this.antigoTdMaxI == null) {
			localAntigo = 0;
		} else {
			localAntigo = this.antigoTdMaxI.intValue();
		}

		System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		ChromeDriver chromeDriver = new ChromeDriver(options);

		chromeDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		try {
			chromeDriver.get("https://www.aneel.gov.br/atos-do-dia");
		} catch (org.openqa.selenium.WebDriverException ex) {
			chromeDriver.get("https://www.aneel.gov.br/atos-do-dia");
		}

		WebDriverWait wait = new WebDriverWait((WebDriver) chromeDriver, 30);
		wait.until((Function) ExpectedConditions.elementToBeClickable(By.id("url-atos-do-dia")));
		chromeDriver.findElement(By.id("url-atos-do-dia")).click();

		try {
			wait.until((Function) ExpectedConditions.numberOfWindowsToBe(2));

		} catch (org.openqa.selenium.TimeoutException ex) {
			chromeDriver.navigate().refresh();
			wait.until((Function) ExpectedConditions.elementToBeClickable(By.id("url-atos-do-dia")));
			chromeDriver.findElement(By.id("url-atos-do-dia")).click();
		}

		ArrayList<String> tabs = new ArrayList<String>(chromeDriver.getWindowHandles());
		chromeDriver.switchTo().window(tabs.get(0));
		chromeDriver.close();
		chromeDriver.switchTo().window(tabs.get(1));

		chromeDriver.switchTo().frame("mainFrame");
		wait.until((Function) ExpectedConditions.visibilityOfElementLocated(By.name("leg_campo1")));
		chromeDriver.findElement(By.name("leg_campo1")).sendKeys(new CharSequence[] { nome });

		wait.until((Function) ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"div_leg\"]/table/tbody/tr[2]/td[2]/input[1]")));
		chromeDriver.findElement(By.xpath("//*[@id=\"div_leg\"]/table/tbody/tr[2]/td[2]/input[1]")).click();

		int tdRef = 2;
		try {
			wait.until((Function) ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[1]/tbody/tr/td/b[1]")));
		} catch (TimeoutException ex) {
			wait.until((Function) ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[1]/tbody/tr/td/b[1]")));
		}

		if (chromeDriver.findElements(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[1]/tbody/tr/td/b[1]"))
				.size() == 0) {
			System.out.println("Nenhum registro encontrado para " + nome + ".");
		} else {
			wait.until((Function) ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[1]/tbody/tr/td/b[1]")));
			String tdMaxS = chromeDriver
					.findElement(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[1]/tbody/tr/td/b[1]")).getText();

			int tdMaxI = Integer.parseInt(tdMaxS);
			int dif = tdMaxI - localAntigo;
			if (tdMaxI > localAntigo || localAntigo <= 20) {
				for (tdRef = 2; tdRef <= dif + 1 && tdRef < 21; tdRef++) {
					String ementa, str1;

					wait.until((Function) ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr["
									+ tdRef + "]/td[3]/table/tbody/tr[2]/td[2]/b/a")));
					String norma = chromeDriver
							.findElement(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr[" + tdRef
									+ "]/td[3]/table/tbody/tr[2]/td[2]/b/a"))
							.getText();
					String dataPublicacao = chromeDriver
							.findElement(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr[" + tdRef
									+ "]/td[3]/table/tbody/tr[4]/td[2]"))
							.getText();

					if (chromeDriver.findElements(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr["
							+ tdRef + "]/td[3]/table/tbody/tr[10]/td[2]/a")).size() != 0) {
						str1 = chromeDriver.findElement(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr["
								+ tdRef + "]/td[3]/table/tbody/tr[10]/td[2]/a")).getText();
					} else {
						str1 = "Não foi possível recuperar esse link. Acesse https://biblioteca.aneel.gov.br/index.html para ler o texto integral.";
					}

					if (chromeDriver.findElement(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr[" + tdRef
							+ "]/td[3]/table/tbody/tr[5]/td[1]")).getText().equals("Ementa")) {
						if (chromeDriver.findElements(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr["
								+ tdRef + "]/td[3]/table/tbody/tr[5]/td[2]/p")).size() != 0) {
							ementa = chromeDriver
									.findElement(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr[" + tdRef
											+ "]/td[3]/table/tbody/tr[5]/td[2]/p"))
									.getText();
						} else {
							ementa = chromeDriver
									.findElement(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr[" + tdRef
											+ "]/td[3]/table/tbody/tr[5]/td[2]"))
									.getText();
						}
					} else {
						ementa = "Sem ementa disponível";

						if (chromeDriver.findElements(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr["
								+ tdRef + "]/td[3]/table/tbody/tr[8]/td[2]/a")).size() != 0) {
							str1 = chromeDriver
									.findElement(By.xpath("//*[@id=\"p_div_aba1_resultado\"]/table[2]/tbody/tr[" + tdRef
											+ "]/td[3]/table/tbody/tr[8]/td[2]/a"))
									.getText();
						} else {
							str1 = "Não foi possível recuperar esse link. Acesse https://biblioteca.aneel.gov.br/index.html para ler o texto integral.";
						}
					}
					String msg = "\nNorma: " + norma + "\nData de Publicação: " + dataPublicacao + "\nEmenta: " + ementa
							+ "\nTexto Integral: " + str1;
					sendEmail.sendEmail(msg, norma, nome);
					System.out.println("Registro(s) encontrado(s) para " + nome + ".");
				}
			} else {
				System.out.println("Sem novas atualizações disponíveis.");
			}
			this.antigoTdMaxI = Integer.valueOf(tdMaxI);
		}
		chromeDriver.close();
		chromeDriver.quit();
	}
}