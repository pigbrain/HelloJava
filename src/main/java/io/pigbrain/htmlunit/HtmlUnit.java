package io.pigbrain.htmlunit;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class HtmlUnit {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		// This is a test code for search about "google" through google.com
		
		try (final WebClient webClient = new WebClient()) {
			final HtmlPage htmlPage = webClient.getPage("http://www.google.com");
			Assert.assertEquals("Google", htmlPage.getTitleText());

			Assert.assertTrue(htmlPage.asText().contains("Google+"));
			
			final HtmlForm searchForm = htmlPage.getFormByName("f");
			final HtmlTextInput textField = searchForm.getInputByName("q");
			textField.setValueAttribute("google");

			final HtmlSubmitInput submitButton = searchForm.getInputByName("btnG");
			final HtmlPage searchPage = submitButton.click();
		    
			Assert.assertTrue(searchPage.asText().contains("Search Options"));
		}

	}
}
