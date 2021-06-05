package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
/**
 *为了方便测试，用于控制index.jsp的链接跳转
 */
public class IndexController {
	/*前台购物系统默认页面*/
	@RequestMapping("/beforeindex")
	public String beforeindex() {
		return "/before/index";
	}
	/*后台管理系统默认页面*/
	@RequestMapping("/adminindex")
	public String beforeadmin() {
		return "/admin/index";
	}
}
