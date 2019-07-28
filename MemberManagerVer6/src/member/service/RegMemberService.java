package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class RegMemberService implements MemberService{

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		//실행결과 반환을 위한 페이지, 실행결과, Member 객체 정의 
		String viewpage="/WEB-INF/member/memberReg.jsp";
		int resultCnt =0;
		Member member = null;
		
		//회원폼으로부터 파라미터 전달받기
		String userid = "";
		String userpw = "";
		String username = "";
		String userphoto="";
		
		String saveFileName = "";
		String uploadPath = "/image";
		String dir = request.getSession().getServletContext().getRealPath(uploadPath);
		String fileDBPath = "";
		
		try {
			//1. enctype 확인 
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart) {
				// 2. 업로드 파일 보관하는 fileitem의 factory 설정 
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//3. 업로드 요청을 처리하는 servletfileupload 생성 
				ServletFileUpload upload = new ServletFileUpload(factory);
				//4. 업로드 요청을 파싱해서 fileitem 목록 구함 
				List<FileItem> files = upload.parseRequest(request);
				
				Iterator<FileItem> itr = files.iterator();
				
				//5. fileitem이 file 형식인지 아닌지에 따라 분기처리 
				while(itr.hasNext()) {
					FileItem file = itr.next();
					
					if(file.isFormField()) {
						//(1) 파일형식이 아닌 경우 : 아이디, 패스워드, 이름 
						if(file.getFieldName().equals("userid")) {
							userid = file.getString("utf-8");
						} else if(file.getFieldName().equals("userpw")) {
							userpw = file.getString("utf-8");					
						} else if(file.getFieldName().equals("username")) {
							username = file.getString("utf-8");
						}
					} else {
						//(2) 파일형식인 경우 --> 파일 경로 분기처리 : 1. 파일이 있는 경우 2. 파일이 없는 경우
						if(file.getFieldName().equals("userphoto")) {
							userphoto = file.getName();
							
							saveFileName = System.nanoTime() + "_" + userphoto;
							file.write(new File(dir, saveFileName));
	
							fileDBPath = "/image/"+saveFileName;
							
							if(userphoto.equals(null) || userphoto.equals("")) {
								fileDBPath = "/image/noImg.png";
							}
						} 
					}
				}
				
			}
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("11"+userid+"::"+userpw+":"+username+":"+fileDBPath);
		
		member = new Member(userid, userpw, username, fileDBPath);
		System.out.println("22 "+member.getUserid());
		
		//DB저장을 위해 Connection 객체 생성, DAO 호출, insert() 호출 
		Connection conn;
		
		try {
			conn = ConnectionProvider.getConnection();		
			
			System.out.println("33 "+member.getUserid());
			
			MemberDao dao = MemberDao.getInstance();
			resultCnt = dao.insert(conn, member);			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("resultCnt", resultCnt);
		request.setAttribute("member", member);
		
		return viewpage;
	}

}
