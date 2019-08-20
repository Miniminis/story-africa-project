package com.storyafrica.sa.mail.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	
	@Autowired
	private JavaMailSender sender;

	public String sendWelcomeMail(String userid) {
		
		MimeMessage msg = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			
			helper.setSubject("[환영] 호갱님~! 저희 회원이 되신 것을 축하드립니다!");
			
			String text = "<h1>회원가입 ㅊㅋㅊㅋ</h1>";
			helper.setText(text, true);
			
			helper.setTo(new InternetAddress(userid, "고객님", "utf-8"));
			
			DataSource dataSource = new FileDataSource("C:\\Users\\minhe\\Pictures\\zootopia01.jpg");
			
			helper.addAttachment(MimeUtility.encodeText("zootopia01.jpg", "utf-8", "B"), dataSource);
			
			sender.send(msg);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		return "mail sent successfully!";
	}
}
