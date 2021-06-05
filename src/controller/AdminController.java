package controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import pojo.Admin;
import pojo.Order;
import pojo.Product;
import pojo.User;
import service.AdminService;
import service.BeforeService;
import service.OrderService;
import service.ProductService;
@Controller
@RequestMapping("/admin")
/**
 *��̨����ϵͳ������
 */
public class AdminController {
	private static final Log logger = LogFactory.getLog(AdminController.class);
	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductService productService;
	@Autowired
	private BeforeService beforeService;
	@Autowired
	private OrderService orderService;
	/*��ҳ*/
	@RequestMapping("/first")
	public String first() {
		return "/admin/first";
	}
	/*�˳���¼*/
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "/admin/index";	
	}
	/*��¼*/
	@RequestMapping("/chklogin")
	public String chklogin(String username,String password,Model model,HttpSession session) {
		if(!adminService.login(username, password)) {
			 model.addAttribute("message", "�û������������");
			logger.info("�û������������");
			 return "/admin/index";	
		}else {
			 session.setAttribute("admin", username);
			 return "/admin/first";
		}
	}
	/*ע��*/
	@RequestMapping("/register")
	public String register(Model model){
		model.addAttribute("message","ע��ɹ�����ת����¼ҳ��");
		return "/admin/register";
	}
	@RequestMapping("/chkregister")
	public String chkregister(Admin rf,Model model){
		if(!adminService.checkAdmin(rf.getUsername())) {
			model.addAttribute("message","�û����Ѵ���,����������");
			return "/admin/register";	
		}else {
			adminService.Register(rf);
			return "/admin/index";
		}
	}
	/*�һ�����*/
	@RequestMapping("/findpwd")
	public String findpwd(Model model){
		return "/admin/findpwd";
	}
	@RequestMapping("/chkfindpwd")
	public String chkfindpwd(Admin rf,Model model,HttpSession session){
		if(!adminService.FindPassword(rf)) {
			 model.addAttribute("message", "�û������������");
			logger.info("�û������������");
			 return "/admin/findpwd";	
		}else {
			logger.info("��֤�ɹ�");
			model.addAttribute("username",rf.getUsername());
			 return "/admin/changeinfo";
		}
	}
	@RequestMapping("/changeinfo")
	public String changeinfo(Admin rf,HttpSession session){
		adminService.ChangePassword(rf);
		//logger.info("�޸ĳɹ�");
		return "/admin/index";
	}
	/*��Ʒ����*/
	@RequestMapping("/admproduct")
	public String admproduct(int adminid,Model model) {
		if(adminid==1) {
			model.addAttribute("admin", 1);//��ǣ�չʾ�����Ʒ����
		}else {
			model.addAttribute("admin", 2);//��ǣ�չʾ��ѯ���޸���Ʒ����
		}
		return "/admin/admproduct";
	}
	/*��ѯ��Ʒ*/
	@RequestMapping("/search")
	public String search(int productid,String productname,int requestpage,Model model){
		/**productid ��productname������Ʒ��ѯ�ķ�ʽ
		*productid=0������Ʒ��ѯ�ķ�ʽ�Ǹ�������ģ����ѯ��Ʒ����ʱ�ᴫ��productname��Ϊ��ѯ�ؼ���
		*productname����Ϊ��ʱ��������Ʒ��ѯ�ķ�ʽ�Ǹ�����Ʒid��ѯ��Ʒ����ʱproductid��Ϊ��ѯ����Ʒid
		*productid=0��productname=""����ͬʱ��������Ϊjsp����js���ƣ���Ϊ�����ύ���������
		*requestpage����jsp�����ҳ�룬��1��ʼ
		*/
		//logger.info("id->"+productid+" ����->"+productname);
		int pagecount;
		int count;
		if(productid==0) {
			Map<String, Object> map= new HashMap<String, Object>();
			map.put("product_name", productname);
			count  = productService.selectAllProductByWord(map);//��ѯ������������Ʒ�������ܼ�¼��Ŀ
			model.addAttribute("rescount",count);
			if(count%20 == 0) {
				 pagecount = count%20; //�պ��ܹ�������ÿһҳ���ܹ�չʾ20����Ʒ 
			}else {
				 pagecount = count/20+1; //������������Ҫ��һҳ��չʾ
			}
			if(count!=0) {
				model.addAttribute("isnull",0);//��ǣ���ʾ�ܹ���ѯ��������������Ʒ
				List<Map<String, Object>> list = productService.splitpage2(productname,requestpage);
				model.addAttribute("searchlist", list);//��ѯ����Ʒ�б�
				model.addAttribute("pagecount",pagecount);//ҳ��
			}else {
				model.addAttribute("isnull",1);//��ǣ���ʾ���ܹ���ѯ��������������Ʒ
			}
			model.addAttribute("keyword",productname);
			
		}else {
			Product pr = productService.selectProductById(productid);
			//����id�鲻����Ʒ
			if(pr==null) {
				model.addAttribute("isnull",1);//��ǣ���ʾ���ܹ���ѯ��������������Ʒ
			}else {
				//logger.info("����/id--��"+pr.getProduct_name()+"/"+pr.getProduct_id());
				model.addAttribute("isnull",0);//��ǣ���ʾ�ܹ���ѯ��������������Ʒ
				/**��Ϊ��Ʒid��Ψһ�ģ����Ը���id��ѯ��Ʒ����ѯ��һ����¼������Ϊ�˷���
				 *jsp�б���  ${searchlist}�����԰Ѹ���id��ѯ��Ʒ�Ľ����װ��list��������map
				*/
				Map<String, Object> map = new HashMap<String, Object>();
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				map.put("product_id", pr.getProduct_id());
				map.put("product_name", pr.getProduct_name());
				map.put("imgpath", pr.getImgpath());
				map.put("price", pr.getPrice());
				list.add(map);
				model.addAttribute("searchlist", list);
				model.addAttribute("selectres",1);
			}
			model.addAttribute("keyword",productname);
		}
		
		model.addAttribute("admin", 2);
		return "/admin/admproduct";
	}
	/*��Ʒ����*/
	@RequestMapping("/product")
	public String product(Product pr,Model model){
		Product res = productService.selectProductById(pr.getProduct_id());
		model.addAttribute("product", res);
		return "/admin/product";
	}
	/*ɾ����Ʒ*/
	@RequestMapping("/deleteproduct")
	public String deleteproduct(int product_id,Model model){
		productService.deleteProduct(product_id);
		return "/admin/deletesuccess";
	}
	/*�޸���Ʒ*/
	@RequestMapping("/updateproduct")
	public String updateproduct(String product_name,String price,int product_id,Model model) {
			productService.updateProduct(product_id, product_name, price);
			return "/admin/deletesuccess";
	}
	/*�����Ʒ*/
	@RequestMapping("/addproduct")
	public String addproduct(MultipartFile imgpath,String productname,String price) {
		productService.addproduct(imgpath, productname, price);
		return "/admin/deletesuccess";
	}
	/*�û�����*/
	@RequestMapping("/admuser")
	public String admuser(Model model) {
		return "/admin/admuser";
	}
	/*�����û�id��ѯ�û�*/
	@RequestMapping("/searchbyuserid")
	public String searchbyuserid(Integer userid,Model model) {
		if(beforeService.selectUserById(userid)==null) {
			model.addAttribute("isnull",1);//��ǣ���ʾ���ܹ���ѯ�������������û�
		}else {
			model.addAttribute("isnull",0);//��ǣ���ʾ�ܹ���ѯ�������������û�
			model.addAttribute("user",beforeService.selectUserById(userid));
		}
		return "forward:/admin/admuser";
	}
	/*�����û�����ѯ�û�*/
	@RequestMapping("/searchbyusername")
	public String searchbyuserid(String username,Model model) {
		if(beforeService.selectUserByUserName(username)==null) {
			model.addAttribute("isnull",1);//��ǣ���ʾ���ܹ���ѯ�������������û�
		}else {
			model.addAttribute("isnull",0);//��ǣ���ʾ�ܹ���ѯ�������������û�
			model.addAttribute("user",beforeService.selectUserByUserName(username));
		}
		return "forward:/admin/admuser";
	}
	/*�޸��û�*/
	@RequestMapping("/updateuser")
	public String updateuser(Integer userid,Model model) {
		model.addAttribute("userid",userid);
		return "/admin/changeuser";
	}
	@RequestMapping("/chkupdateuser")
	public String chkupdateuser(User rf) {
		beforeService.changeuser(rf);
		return "/admin/deletesuccess";
	}
	/*��������*/
	@RequestMapping("/admorder")
	public String admorder() {
		return "/admin/admorder";
	}
	/*���ݶ���id��ѯ����*/
	@RequestMapping("/searchorbyid")
	public String searchorbyid(Integer orderid,Model model) {
		//logger.info("����id---��"+orderid);
		Order od = orderService.selectOrdByOrderid(orderid);
		if(od==null) {
			model.addAttribute("isnull",1);//��ǣ���ʾ���ܹ���ѯ�����������Ķ���
		}else {
			model.addAttribute("isnull",0);//��ǣ���ʾ�ܹ���ѯ�����������Ķ���
			model.addAttribute("order",od);
		}
		model.addAttribute("type",1);//��ǣ�jsp��type=1��ʾ���ݶ���id��ѯ����
		return "/admin/admorder";
	}
	/*�����û�id��ѯ����*/
	@RequestMapping("/searchbyserid")
	public String searchbyserid(Integer userid,Model model) {
		//logger.info("�û�id---��"+userid);
		List<Map<String,Object>> list = orderService.selectAllOrderByUserId(userid);
		if(list.size()==0) {
			model.addAttribute("isnull",1);
		}else {
			model.addAttribute("isnull",0);
			model.addAttribute("orderlist",list);
		}
		model.addAttribute("type",2);//��ǣ�jsp��type=1��ʾ�����û�id��ѯ����
		return "/admin/admorder";
	}
	/*�޸Ķ���״̬*/
	@RequestMapping("/updateorder")
	public String updateorder(Integer orderid,Integer status) {
		//logger.info("����id---��"+orderid+"״̬--��"+status);
		orderService.updateOrderStatus(orderid, status);
		return "/admin/deletesuccess";
	}
	/*ɾ������*/
	@RequestMapping("/deleteorder")
	public String deleteorder(Integer orderid) {
		//logger.info("����id---��"+orderid+"״̬--��"+status);
		orderService.deleteorder(orderid);
		return "/admin/deletesuccess";
	}
}
