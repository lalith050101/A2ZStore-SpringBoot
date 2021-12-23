package com.smssender;

import org.springframework.stereotype.Component;

public interface SmsSender {

	public void sendSms(String to, String body);
}



