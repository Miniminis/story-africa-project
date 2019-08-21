package com.storyafrica.sa.mail.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.member.dao.MemberSessionDao;

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
	
	//인증코드 받는 매서드 추가 
	public String sendWelcomeMail(String userid, String vericode) {
		
		System.out.println("rest4-2 : "+userid+"////"+vericode);
		
		MimeMessage msg = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			
			helper.setSubject("[공지] 호갱님~! 저희 회원이 되신 것을 축하드립니다!");
			
			String text = "<h1>회원가입 ㅊㅋㅊㅋ</h1>";
			text += "<h3><a href='http://localhost:8080/sa/member/verify?vericode="+vericode+"&userid="+userid+"'>인증하기</a></h3>";
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
	
	//재 인증코드 
	public int resendWelcomeMail(String userid, String vericode) {
		
		MimeMessage msg = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			
			helper.setSubject("[재인증안내] 호갱님, 인증을 해야 회원가입이 완벽하게 처리됩니다!");
			
			String text = "<h1>재인증 링크전송</h1>";
			text += "<h3><a href='http://localhost:8080/sa/member/verify?vericode="+vericode+"&userid="+userid+"'>인증하기</a></h3>";
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
		
		return 1;
	}

	//비밀번호 찾기 메일 전송 
	public int sendFindPwMail(String userid, String tempoPw) {
		
		MimeMessage msg = sender.createMimeMessage();
		
		try {
			msg.setSubject("[비번찾기안내] 비번찾기!");
			
			String html = "<h1>임시 비밀번호로 로그인 해주세요! </h1>";
			html += "<a href ='http://localhost:8080/sa'>임시 비밀번호로 로그인하기</a><br>";
			html += "임시비번 : "+tempoPw;
			
			msg.setText(html, "utf-8", "html");

			msg.addRecipient(RecipientType.TO, new InternetAddress(userid, "고객님", "utf-8"));
			
			sender.send(msg);

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return 1;
	}
	
}
