package intercept;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
/**
 *��ͨ�û���֤��¼������
 */
@Controller
public class LoginInterUser implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) 
	throws Exception{
		//��ȡ�����url
		String url = request.getRequestURI();
		//��¼��������У�������
		if(url.indexOf("/chklogin")>=0) {
			return true;
		}
		//��ȡsession
		HttpSession session = request.getSession();
		Object object = session.getAttribute("username");
		if(object!=null) {
			return true;
		}
		request.setAttribute("msg", "��û��¼�����ȵ�¼��");
		request.getRequestDispatcher("/WEB-INF/jsp/before/index.jsp").forward(request, response);
		return false;
	}
}
