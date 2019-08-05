package experience.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBoardMainService implements ExperienceService{

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewpage="WEB-INF/experience/main.jsp";
		
		
		return viewpage;
	}

}
