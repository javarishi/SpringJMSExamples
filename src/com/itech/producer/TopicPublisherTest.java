package com.itech.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TopicPublisherTest {

	public static void main(String[] args) {
		// Load Application Context 
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    // Get JmsTemplate Bean from context     
	    JmsTemplate template = (JmsTemplate) ctx.getBean("topicTemplate");
	    // Create Message 
	    MessageCreator message = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("This is test message");
			}
		};
		// Send the message
		template.send(message);
		// Close the context
		//((ClassPathXmlApplicationContext)ctx).close();
		// You are Done!!

	}

}
