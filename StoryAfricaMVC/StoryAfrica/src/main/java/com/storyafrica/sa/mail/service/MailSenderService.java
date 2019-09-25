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
			
			helper.setSubject("[공지] 스토리 아프리카의 에디터가 되신 것을 환영합니다!");
			
			String text = "<h1>회원가입을 축하드립니다. 앞으로 활발한 활동을 기대하겠습니다!</h1>";
			helper.setText(text, true);
			
			helper.setTo(new InternetAddress(userid, "에디터님", "utf-8"));
			
			//DataSource dataSource = new FileDataSource("C:\\Users\\minhe\\Pictures\\zootopia01.jpg");
			
			//helper.addAttachment(MimeUtility.encodeText("zootopia01.jpg", "utf-8", "B"), dataSource);
			
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
			
			helper.setSubject("[인증] 스토리 아프리카의 에디터가 되신 것을 환영합니다!");
			
			String text = "<h1>회원가입을 축하드립니다. 아래의 링크를 클릭하여 회원가입을 완료해주세요!</h1>";
			text += "<h3><a href='http://15.164.99.110:8080/storyafrica/member/verify?vericode="+vericode+"&userid="+userid+"'>인증하기</a></h3>";
			helper.setText(text, true);
			
			helper.setTo(new InternetAddress(userid, "에디터님", "utf-8"));
			
			//DataSource dataSource = new FileDataSource("C:\\Users\\minhe\\Pictures\\zootopia01.jpg");
			
			//helper.addAttachment(MimeUtility.encodeText("zootopia01.jpg", "utf-8", "B"), dataSource);
			
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
			
			helper.setSubject("[재인증] 이메일 인증을 통해 스토리 아프리카의 회원가입을 완료하여주세요!");
			
			String text = "<h1>회원 계정 재인증 안내 메일입니다. 메일 인증이 완료되어야 정식으로 스토리 아프리카의 회원으로 활동하실 수 있습니다. 아래의 링크를 클릭하여 회원가입을 완료해주세요!</h1>";
			text += "<h3><a href='http://15.164.99.110:8080/storyafrica/member/verify?vericode="+vericode+"&userid="+userid+"'>인증하기</a></h3>";
			helper.setText(text, true);
			
			helper.setTo(new InternetAddress(userid, "에디터님", "utf-8"));
			
			//DataSource dataSource = new FileDataSource("C:\\Users\\minhe\\Pictures\\zootopia01.jpg");
			
			//helper.addAttachment(MimeUtility.encodeText("zootopia01.jpg", "utf-8", "B"), dataSource);
			
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
			msg.setSubject("[비밀번호 찾기] 비밀번호찾기 안내메일입니다.");
			
			String html = "<h1>에디터님의 임시 비밀번호는 아래와 같습니다. 해당 비밀번호로 로그인 한 뒤, 비밀번호를 변경해주세요!</h1>";
			html += "<a href ='http://15.164.99.110:8080/storyafrica/'>임시 비밀번호로 로그인</a><br>";
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
