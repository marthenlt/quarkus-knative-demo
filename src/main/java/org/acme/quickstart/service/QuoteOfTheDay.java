package org.acme.quickstart.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuoteOfTheDay {
	
	private String[] quotes = {"Cheerful heart is a good medicine!", "Rejoice!"};
	
	public String getQuote(int index) {
		return quotes[index];
	}

}
