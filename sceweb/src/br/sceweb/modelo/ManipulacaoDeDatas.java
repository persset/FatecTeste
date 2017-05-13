package br.sceweb.modelo;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class ManipulacaoDeDatas {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ManipulacaoDeDatas.class);
		DateTime dateTime = new DateTime(); 
		logger.info("dateTime.toString() = " + dateTime.toString("YYYY-MM-dd"));
		// Imprimindo a data no formato YYYY-MM-dd HH:mm:ss
		logger.info("dateTime.toString() = " + dateTime.toString("YYYY-MM-dd HH:mm:ss"));
		// Imprimindo o mês 
		logger.info("dateTime.toString() = " + dateTime.monthOfYear().getAsText());
		// Imprimindo o mês
		logger.info("dateTime.toString() = " + dateTime.monthOfYear().getAsShortText());
		// Imprimindo o mês em Inglês
		logger.info("dateTime.toString() = " + dateTime.monthOfYear().getAsText(Locale.ENGLISH));
	}
}
	