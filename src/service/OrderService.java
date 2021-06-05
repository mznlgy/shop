package service;
import java.util.List;
import java.util.Map;
import pojo.Order;
public interface OrderService {
	public void addOrder(Order od);//新增订单
	public List<Map<String,Object>> selectAllOrderByUserId(Integer userid);//用户id查询订单 
	public void addOrderDetail(Map<String,Object> map);//生成订单详情 
	public List<Map<String,Object>> selectOrderDetailByOrderId(Integer orderid);//查询该用户的所有订单
	public List<Map<String,Object>> selectProductCount(Integer orderid);//根据订单id查询每一个订单的所有商品的数量
	public void payOrder(Integer orderid);//支付
	public Order selectOrdByOrderid(Integer orderid);//根据id查询订单概况 
	public void updateOrderStatus(Integer orderid,Integer status);//更改订单状态 
	public void deleteorder(Integer orderid);//删除订单
}
