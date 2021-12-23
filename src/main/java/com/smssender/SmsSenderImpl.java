package com.smssender;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.util.ResourceUtils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class SmsSenderImpl implements SmsSender {

	// Find your Account SID and Auth Token at twilio.com/console
	// and set the environment variables. See http://twil.io/secure

	
	private static String ACCOUNT_SID;
	private static  String AUTH_TOKEN;
	private static  String PHONE_NUMBER;

	private void loadCreds() {
		try (FileInputStream fis = new FileInputStream(ResourceUtils.getFile("classpath:application.properties"))) {
			Properties props = new Properties();
			props.load(fis);
			ACCOUNT_SID = (String) props.get("twilio.acc.sid");
			AUTH_TOKEN = (String) props.getProperty("twilio.acc.token");
			PHONE_NUMBER = (String) props.get("twilio.acc.phno");
			
		} catch (Exception e) {
			System.err.println("can't get Twilio Creds...");
		}
	}

	@Override
	public void sendSms(String to, String body) {

		loadCreds();
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(new com.twilio.type.PhoneNumber("+91" + to),
				new com.twilio.type.PhoneNumber(PHONE_NUMBER),
				body).create();
		

		// System.out.println("Account ACCOUNT_SID : " + ACCOUNT_SID + " : " + AUTH_TOKEN + " : " + PHONE_NUMBER);


		System.out.println(message.getSid());

	}

}
