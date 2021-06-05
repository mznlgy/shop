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
 *前台购物系统控制器
 */
public class BeforeController {
	private static final Log logger = LogFactory.getLog(BeforeController.class);//日志
	@Autowired
	private BeforeService beforeService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	/*退出登录*/
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "/before/index";	
	}
	/*首页*/
	@RequestMapping("/first")
	public String first(HttpSession session) {
		return "/before/first";
	}
	@RequestMapping("/chklogin")
	public String chklogin(User rf,Model model,HttpSession session) {
		if(!beforeService.Login(rf)) {
			 model.addAttribute("message", "用户名或密码错误");
			logger.info("用户名或密码错误");
			 return "/before/index";	
		}else {
			 session.setAttribute("username", rf.getUsername());
			 return "/before/first";
		}
	}
	/*注册*/
	@RequestMapping("/register")
	public String register(Model model){
		model.addAttribute("message","注册成功即跳转到登录页面");
		return "/before/register";
	}
	@RequestMapping("/chkregister")
	public String chkregister(User rf,Model model){
		User res = beforeService.selectUserByUserName(rf.getUsername());
		if(res!=null) {
			logger.info("fail"+res.getUsername()+res.getPassword()+res.getEmail());
			model.addAttribute("message","用户名已存在,请重新输入");
			return "/before/register";	
		}else {
			logger.info("success");
			beforeService.Register(rf);
			return "/before/index";
		}
	}
	/*找回密码*/
	@RequestMapping("/findpwd")
	public String findpwd(Model model){
		return "/before/findpwd";
	}
	@RequestMapping("/chkfindpwd")
	public String chkfindpwd(User rf,Model model,HttpSession session){
		if(!beforeService.FindPassword(rf)) {
			 model.addAttribute("message", "用户名或邮箱错误");
			logger.info("用户名或邮箱错误");
			 return "/before/findpwd";	
		}else {
			logger.info("验证成功");
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
		logger.info("修改成功");
		return "/before/index";
	}
	/*商品详情*/
	@RequestMapping("/product")
	public String product(Product pr,Model model){
		Product res = productService.selectProductById(pr.getProduct_id());
		model.addAttribute("product", res);
		return "/before/product";
	}
	/*更新购物车*/
	@RequestMapping("/updatecart")
	public String updatecart(){
		return "forward:/before/shoppingcart";
	}
	/*查询购物车*/
	@RequestMapping("/shoppingcart")
	public String shoppingcart(Model model,HttpSession session){
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		model.addAttribute("productlist", cartService.selectCartByUser(userid));
		return "/before/shoppingcart";
	}
	/*添加商品到购物车*/
	@RequestMapping("/addproduct")
	public String addproduct(Integer product_id,Integer pro_count,HttpSession session){
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("product_id",product_id);
		map.put("count", pro_count);
		if(cartService.isExistedCart(map)) {
			logger.info("可以添加");
			cartService.addCart(map);
		}else {
			cartService.updateCart(map);
			logger.info("不可以添加");
		}
		return "forward:/before/shoppingcart";
	}
	/*移除商品*/
	@RequestMapping("/removeproduct")
	public String removeproduct(Integer product_id,HttpSession session) {
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("product_id",product_id);
		cartService.deleteCart(map);
		return "forward:/before/shoppingcart";
	}
	/*清空购物车*/
	@RequestMapping("/clearcart")
	public String clearcart(HttpSession session) {
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		cartService.clearCart(userid);
		return "forward:/before/shoppingcart";
	}
	/*提交订单*/
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
	/*我的订单*/
	@RequestMapping("/myorders")
	public String myorders(HttpSession session,Model model) {
		Integer userid = beforeService.getUserIdByUsername((String)session.getAttribute("username"));
		//list存放订单号->orderid
		List<Map<String,Object>> list = orderService.selectAllOrderByUserId(userid);
		//list3存放要展示的商品信息
		List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++) {
			//ll存放根据订单号查询到的订单详情
			//lll存放每一个订单中包含的商品信息
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
	/*支付订单*/
	@RequestMapping("/pay")
	public String pay(int subordid) {
		orderService.payOrder(subordid);
		return "/before/paysuccess";
	}
	/*搜索*/
	@RequestMapping("/search")
	public String search(String product_name,Model model,int requestpage) {
		//requestpage表示jsp请求的页码，默认从第一页开始
		int pagecount;//页数
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("product_name", product_name);
		Integer count = productService.selectAllProductByWord(map);//查询符合条件的商品，返回总记录数目
		model.addAttribute("rescount",count);
		if(count%20 == 0) {
			 pagecount = count%20; //刚好能够整除，每一页都能够展示20件商品 
		}else {
			 pagecount = count/20+1; //有余数代表需要多一页来展示
		}
		if(count!=0) {
			model.addAttribute("null", 1);
			//根据搜索词和请求页码进行分页展示
			List<Map<String, Object>> list = productService.splitpage(product_name,requestpage);
			model.addAttribute("searchlist", list);//结果
			model.addAttribute("pagecount",pagecount);
		}else {
			model.addAttribute("null", 0);
		}
		model.addAttribute("keyword", product_name);
		model.addAttribute("thispage", requestpage);
		return "/before/search";
	}
}
