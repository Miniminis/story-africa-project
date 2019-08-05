package experience.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ExperienceService {

	String getViewName(HttpServletRequest request, HttpServletResponse response);

}
