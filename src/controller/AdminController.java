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
 *后台管理系统控制器
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
	/*首页*/
	@RequestMapping("/first")
	public String first() {
		return "/admin/first";
	}
	/*退出登录*/
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "/admin/index";	
	}
	/*登录*/
	@RequestMapping("/chklogin")
	public String chklogin(String username,String password,Model model,HttpSession session) {
		if(!adminService.login(username, password)) {
			 model.addAttribute("message", "用户名或密码错误");
			logger.info("用户名或密码错误");
			 return "/admin/index";	
		}else {
			 session.setAttribute("admin", username);
			 return "/admin/first";
		}
	}
	/*注册*/
	@RequestMapping("/register")
	public String register(Model model){
		model.addAttribute("message","注册成功即跳转到登录页面");
		return "/admin/register";
	}
	@RequestMapping("/chkregister")
	public String chkregister(Admin rf,Model model){
		if(!adminService.checkAdmin(rf.getUsername())) {
			model.addAttribute("message","用户名已存在,请重新输入");
			return "/admin/register";	
		}else {
			adminService.Register(rf);
			return "/admin/index";
		}
	}
	/*找回密码*/
	@RequestMapping("/findpwd")
	public String findpwd(Model model){
		return "/admin/findpwd";
	}
	@RequestMapping("/chkfindpwd")
	public String chkfindpwd(Admin rf,Model model,HttpSession session){
		if(!adminService.FindPassword(rf)) {
			 model.addAttribute("message", "用户名或邮箱错误");
			logger.info("用户名或邮箱错误");
			 return "/admin/findpwd";	
		}else {
			logger.info("验证成功");
			model.addAttribute("username",rf.getUsername());
			 return "/admin/changeinfo";
		}
	}
	@RequestMapping("/changeinfo")
	public String changeinfo(Admin rf,HttpSession session){
		adminService.ChangePassword(rf);
		//logger.info("修改成功");
		return "/admin/index";
	}
	/*商品管理*/
	@RequestMapping("/admproduct")
	public String admproduct(int adminid,Model model) {
		if(adminid==1) {
			model.addAttribute("admin", 1);//标记，展示添加商品功能
		}else {
			model.addAttribute("admin", 2);//标记，展示查询及修改商品功能
		}
		return "/admin/admproduct";
	}
	/*查询商品*/
	@RequestMapping("/search")
	public String search(int productid,String productname,int requestpage,Model model){
		/**productid 和productname代表商品查询的方式
		*productid=0代表商品查询的方式是根据名称模糊查询商品，此时会传入productname作为查询关键词
		*productname传入为空时，代表商品查询的方式是根据商品id查询商品，此时productid作为查询的商品id
		*productid=0与productname=""不能同时成立，因为jsp加了js控制，都为空是提交不了请求的
		*requestpage代表jsp请求的页码，从1开始
		*/
		//logger.info("id->"+productid+" 名称->"+productname);
		int pagecount;
		int count;
		if(productid==0) {
			Map<String, Object> map= new HashMap<String, Object>();
			map.put("product_name", productname);
			count  = productService.selectAllProductByWord(map);//查询符合条件的商品，返回总记录数目
			model.addAttribute("rescount",count);
			if(count%20 == 0) {
				 pagecount = count%20; //刚好能够整除，每一页都能够展示20件商品 
			}else {
				 pagecount = count/20+1; //有余数代表需要多一页来展示
			}
			if(count!=0) {
				model.addAttribute("isnull",0);//标记，表示能够查询到符合条件的商品
				List<Map<String, Object>> list = productService.splitpage2(productname,requestpage);
				model.addAttribute("searchlist", list);//查询的商品列表
				model.addAttribute("pagecount",pagecount);//页数
			}else {
				model.addAttribute("isnull",1);//标记，表示不能够查询到符合条件的商品
			}
			model.addAttribute("keyword",productname);
			
		}else {
			Product pr = productService.selectProductById(productid);
			//根据id查不到商品
			if(pr==null) {
				model.addAttribute("isnull",1);//标记，表示不能够查询到符合条件的商品
			}else {
				//logger.info("名字/id--》"+pr.getProduct_name()+"/"+pr.getProduct_id());
				model.addAttribute("isnull",0);//标记，表示能够查询到符合条件的商品
				/**因为商品id是唯一的，所以根据id查询商品最多查询到一条记录，所以为了方便
				 *jsp中遍历  ${searchlist}，所以把根据id查询商品的结果封装成list，而不是map
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
	/*商品详情*/
	@RequestMapping("/product")
	public String product(Product pr,Model model){
		Product res = productService.selectProductById(pr.getProduct_id());
		model.addAttribute("product", res);
		return "/admin/product";
	}
	/*删除商品*/
	@RequestMapping("/deleteproduct")
	public String deleteproduct(int product_id,Model model){
		productService.deleteProduct(product_id);
		return "/admin/deletesuccess";
	}
	/*修改商品*/
	@RequestMapping("/updateproduct")
	public String updateproduct(String product_name,String price,int product_id,Model model) {
			productService.updateProduct(product_id, product_name, price);
			return "/admin/deletesuccess";
	}
	/*添加商品*/
	@RequestMapping("/addproduct")
	public String addproduct(MultipartFile imgpath,String productname,String price) {
		productService.addproduct(imgpath, productname, price);
		return "/admin/deletesuccess";
	}
	/*用户管理*/
	@RequestMapping("/admuser")
	public String admuser(Model model) {
		return "/admin/admuser";
	}
	/*根据用户id查询用户*/
	@RequestMapping("/searchbyuserid")
	public String searchbyuserid(Integer userid,Model model) {
		if(beforeService.selectUserById(userid)==null) {
			model.addAttribute("isnull",1);//标记，表示不能够查询到符合条件的用户
		}else {
			model.addAttribute("isnull",0);//标记，表示能够查询到符合条件的用户
			model.addAttribute("user",beforeService.selectUserById(userid));
		}
		return "forward:/admin/admuser";
	}
	/*根据用户名查询用户*/
	@RequestMapping("/searchbyusername")
	public String searchbyuserid(String username,Model model) {
		if(beforeService.selectUserByUserName(username)==null) {
			model.addAttribute("isnull",1);//标记，表示不能够查询到符合条件的用户
		}else {
			model.addAttribute("isnull",0);//标记，表示能够查询到符合条件的用户
			model.addAttribute("user",beforeService.selectUserByUserName(username));
		}
		return "forward:/admin/admuser";
	}
	/*修改用户*/
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
	/*订单管理*/
	@RequestMapping("/admorder")
	public String admorder() {
		return "/admin/admorder";
	}
	/*根据订单id查询订单*/
	@RequestMapping("/searchorbyid")
	public String searchorbyid(Integer orderid,Model model) {
		//logger.info("订单id---》"+orderid);
		Order od = orderService.selectOrdByOrderid(orderid);
		if(od==null) {
			model.addAttribute("isnull",1);//标记，表示不能够查询到符合条件的订单
		}else {
			model.addAttribute("isnull",0);//标记，表示能够查询到符合条件的订单
			model.addAttribute("order",od);
		}
		model.addAttribute("type",1);//标记，jsp中type=1表示根据订单id查询订单
		return "/admin/admorder";
	}
	/*根据用户id查询订单*/
	@RequestMapping("/searchbyserid")
	public String searchbyserid(Integer userid,Model model) {
		//logger.info("用户id---》"+userid);
		List<Map<String,Object>> list = orderService.selectAllOrderByUserId(userid);
		if(list.size()==0) {
			model.addAttribute("isnull",1);
		}else {
			model.addAttribute("isnull",0);
			model.addAttribute("orderlist",list);
		}
		model.addAttribute("type",2);//标记，jsp中type=1表示根据用户id查询订单
		return "/admin/admorder";
	}
	/*修改订单状态*/
	@RequestMapping("/updateorder")
	public String updateorder(Integer orderid,Integer status) {
		//logger.info("订单id---》"+orderid+"状态--》"+status);
		orderService.updateOrderStatus(orderid, status);
		return "/admin/deletesuccess";
	}
	/*删除订单*/
	@RequestMapping("/deleteorder")
	public String deleteorder(Integer orderid) {
		//logger.info("订单id---》"+orderid+"状态--》"+status);
		orderService.deleteorder(orderid);
		return "/admin/deletesuccess";
	}
}
