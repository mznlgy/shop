package intercept;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
/**
 *普通用户验证登录拦截器
 */
@Controller
public class LoginInterUser implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) 
	throws Exception{
		//获取请求的url
		String url = request.getRequestURI();
		//登录则请求放行，不拦截
		if(url.indexOf("/chklogin")>=0) {
			return true;
		}
		//获取session
		HttpSession session = request.getSession();
		Object object = session.getAttribute("username");
		if(object!=null) {
			return true;
		}
		request.setAttribute("msg", "还没登录，请先登录！");
		request.getRequestDispatcher("/WEB-INF/jsp/before/index.jsp").forward(request, response);
		return false;
	}
}
