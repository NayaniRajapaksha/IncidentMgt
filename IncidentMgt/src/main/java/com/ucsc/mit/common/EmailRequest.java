package com.ucsc.mit.common;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailRequest {
	
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("iresha.nayani@gmail.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("iresha.nayani@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
//	public void sendEmail(){
//		
//		// Recipient's email ID needs to be mentioned.
//	      String to = "iresha.nayani@gmail.com";
//
//	      // Sender's email ID needs to be mentioned
//	      String from = "iresha.nayani@gmail.com";
//
//	      // Assuming you are sending email from localhost
//	      String host = "localhost";
//
//	      // Get system properties
//	      Properties properties = System.getProperties();
//
//	      // Setup mail server
//	      properties.setProperty("mail.smtp.host", host);
//
//	      // Get the default Session object.
//	      Session session = Session.getDefaultInstance(properties);
//
//	      try {
//	         // Create a default MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//	         // Set Subject: header field
//	         message.setSubject("This is the Subject Line!");
//
//	         // Now set the actual message
//	         message.setText("This is actual message");
//
//	         // Send message
//	         Transport.send(message);
//	         System.out.println("Sent message successfully....");
//	      } catch (MessagingException mex) {
//	         mex.printStackTrace();
//	      }
//	   }
		
	
}
