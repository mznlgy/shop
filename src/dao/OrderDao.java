package dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Order;
@Repository("orderDao")
@Mapper
/**
 *订单数据访问层
 */
public interface OrderDao {
	public int addOrder(Order od);//新增订单
	public List<Map<String,Object>> selectAllOrderByUserId(Integer userid);//用户id查询订单 
	public int addOrderDetail(Map<String,Object> map);// 生成订单详情
	public List<Map<String,Object>> selectOrderDetailByOrderId(Integer orderid);//根据订单id查询订单详情
	public List<Map<String,Object>> selectProductCount(Integer orderid);//根据订单id查询每一个订单的所有商品的数量
	public int payOrder(Integer orderid);//支付订单
	public Order selectOrdByOrderid(Integer orderid);//根据id查询订单概况 
	public int updateOrderStatus(Map<String,Object> map);//更改订单状态 
	public int deleteOrderByOrderid(Integer orderid);// 删除订单
}
