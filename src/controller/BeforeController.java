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
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Order;
import pojo.Product;
import pojo.User;
import service.BeforeService;
import service.CartService;
import service.OrderService;
import service.ProductService;
@Controller
@RequestMapping("/before")
/**
 *ǰ̨����ϵͳ������
 */
public class BeforeController {
	private static final Log logger = LogFactory.getLog(BeforeController.class);//��־
	@Autowired
	private BeforeService beforeService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	/*�˳���¼*/
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "/before/index";	
	}
	/*��ҳ*/
	@RequestMapping("/first")
	public String first(HttpSession session) {
		return "/before/first";
	}
	@RequestMapping("/chklogin")
	public String chklogin(User rf,Model model,HttpSession session) {
		if(!beforeService.Login(rf)) {
			 model.addAttribute("message", "�û������������");
			logger.info("�û������������");
			 return "/before/index";	
		}else {
			 session.setAttribute("username", rf.getUsername());
			 return "/before/first";
		}
	}
	/*ע��*/
	@RequestMapping("/register")
	public String register(Model model){
		model.addAttribute("message","ע��ɹ�����ת����¼ҳ��");
		return "/before/register";
	}
	@RequestMapping("/chkregister")
	public String chkregister(User rf,Model model){
		User res = beforeService.selectUserByUserName(rf.getUsername());
		if(res!=null) {
			logger.info("fail"+res.getUsername()+res.getPassword()+res.getEmail());
			model.addAttribute("message","�û����Ѵ���,����������");
			return "/before/register";	
		}else {
			logger.info("success");
			beforeService.Register(rf);
			return "/before/index";
		}
	}
	/*�һ�����*/
	@RequestMapping("/findpwd")
	public String findpwd(Model model){
		return "/before/findpwd";
	}
	@RequestMapping("/chkfindpwd")
	public String chkfindpwd(User rf,Model model,HttpSession session){
		if(!beforeService.FindPassword(rf)) {
			 model.addAttribute("message", "�û������������");
			logger.info("�û������������");
			 return "/before/findpwd";	
		}else {
			logger.info("��֤�ɹ�");
			model.addAttribute("username",rf.getUsername());
			 return "/before/changeinfo";
		}
	}
	@RequestMapping("/changeinfo")
	public String changeinfo(User rf,HttpSession session){
		String name = rf.getUsername();
		User newUser = beforeService.selectUserByUserName(name);
		newUser.setPassword(rf.getPassword());
		beforeService.ChangePassword(newUser);
		logger.info("�޸ĳɹ�");
		return "/before/index";
	}
	/*��Ʒ����*/
	@RequestMapping("/product")
	public String product(Product pr,Model model){
		Product res = productService.selectProductById(pr.getProduct_id());
		model.addAttribute("product", res);
		return "/before/product";
	}
	/*���¹��ﳵ*/
	@RequestMapping("/updatecart")
	public String updatecart(){
		return "forward:/before/shoppingcart";
	}
	/*��ѯ���ﳵ*/
	@RequestMapping("/shoppingcart")
	public String shoppingcart(Model model,HttpSession session){
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		model.addAttribute("productlist", cartService.selectCartByUser(userid));
		return "/before/shoppingcart";
	}
	/*�����Ʒ�����ﳵ*/
	@RequestMapping("/addproduct")
	public String addproduct(Integer product_id,Integer pro_count,HttpSession session){
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("product_id",product_id);
		map.put("count", pro_count);
		if(cartService.isExistedCart(map)) {
			logger.info("�������");
			cartService.addCart(map);
		}else {
			cartService.updateCart(map);
			logger.info("���������");
		}
		return "forward:/before/shoppingcart";
	}
	/*�Ƴ���Ʒ*/
	@RequestMapping("/removeproduct")
	public String removeproduct(Integer product_id,HttpSession session) {
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("product_id",product_id);
		cartService.deleteCart(map);
		return "forward:/before/shoppingcart";
	}
	/*��չ��ﳵ*/
	@RequestMapping("/clearcart")
	public String clearcart(HttpSession session) {
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		cartService.clearCart(userid);
		return "forward:/before/shoppingcart";
	}
	/*�ύ����*/
	@RequestMapping("/suborder")
	public String orders(Double subprice,HttpSession session){
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		Order neworder =new Order();
		neworder.setAmount(subprice);
		neworder.setUser_id(userid);
		orderService.addOrder(neworder);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderid",neworder.getOrderid());
		map.put("user_id", userid);
		orderService.addOrderDetail(map);
		cartService.clearCart(userid);
		return "forward:/before/shoppingcart";
	}
	/*�ҵĶ���*/
	@RequestMapping("/myorders")
	public String myorders(HttpSession session,Model model) {
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		//list��Ŷ�����->orderid
		List<Map<String,Object>> list = orderService.selectAllOrderByUserId(userid);
		//list3���Ҫչʾ����Ʒ��Ϣ
		List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++) {
			//ll��Ÿ��ݶ����Ų�ѯ���Ķ�������
			//lll���ÿһ�������а�������Ʒ��Ϣ
			List<Map<String,Object>> ll = orderService.selectOrderDetailByOrderId((Integer) list.get(i).get("orderid"));
			List<Map<String,Object>> lll = orderService.selectProductCount((Integer) list.get(i).get("orderid"));
			for(int j=0;j<ll.size();j++) {
				Map<String,Object> mm =new HashMap();
				mm.put("product_id", ll.get(j).get("product_id"));
				mm.put("price", ll.get(j).get("price"));
				mm.put("product_name", ll.get(j).get("product_name"));
				mm.put("imgpath", ll.get(j).get("imgpath"));
				mm.put("count", lll.get(j).get("count"));
				mm.put("orderid", list.get(i).get("orderid"));
				mm.put("status", lll.get(j).get("status"));
				list3.add(mm);
			}
		}
		model.addAttribute("orderidlist",list);
		model.addAttribute("productlist",list3);
		for(int i=0;i<list3.size();i++) {
			logger.info(list3.get(i).get("orderid")+"/");
		}
		return "/before/orders";
	}
	/*֧������*/
	@RequestMapping("/pay")
	public String pay(int subordid) {
		orderService.payOrder(subordid);
		return "/before/paysuccess";
	}
	/*����*/
	@RequestMapping("/search")
	public String search(String product_name,Model model,int requestpage) {
		//requestpage��ʾjsp�����ҳ�룬Ĭ�ϴӵ�һҳ��ʼ
		int pagecount;//ҳ��
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("product_name", product_name);
		Integer count = productService.selectAllProductByWord(map);//��ѯ������������Ʒ�������ܼ�¼��Ŀ
		model.addAttribute("rescount",count);
		if(count%20 == 0) {
			 pagecount = count%20; //�պ��ܹ�������ÿһҳ���ܹ�չʾ20����Ʒ 
		}else {
			 pagecount = count/20+1; //������������Ҫ��һҳ��չʾ
		}
		if(count!=0) {
			model.addAttribute("null", 1);
			//���������ʺ�����ҳ����з�ҳչʾ
			List<Map<String, Object>> list = productService.splitpage(product_name,requestpage);
			model.addAttribute("searchlist", list);//���
			model.addAttribute("pagecount",pagecount);
		}else {
			model.addAttribute("null", 0);
		}
		model.addAttribute("keyword", product_name);
		model.addAttribute("thispage", requestpage);
		return "/before/search";
	}
}
