package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
/**
 *Ϊ�˷�����ԣ����ڿ���index.jsp��������ת
 */
public class IndexController {
	/*ǰ̨����ϵͳĬ��ҳ��*/
	@RequestMapping("/beforeindex")
	public String beforeindex() {
		return "/before/index";
	}
	/*��̨����ϵͳĬ��ҳ��*/
	@RequestMapping("/adminindex")
	public String beforeadmin() {
		return "/admin/index";
	}
}
