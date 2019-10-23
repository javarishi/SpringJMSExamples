package com.itech.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerTest {

	public static void main(String[] args) {
		// Load Application Context 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    // Get JmsTemplate Bean from context     
	    JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
	    // Create Message 
	    MessageCreator messageCreator =  new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message msg =  session.createTextMessage("This is My Frist Spring JMS Message");
				return msg;
			}
		};
		// Send the message
		template.send(messageCreator);
		// Close the context
		// ctx.close();
		// You are Done!!
	}

}
