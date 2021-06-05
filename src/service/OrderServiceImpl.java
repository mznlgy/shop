package service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.OrderDao;
import pojo.Order;
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	private static final Log logger = LogFactory.getLog(OrderServiceImpl.class);
	@Autowired
	private OrderDao orderDao;
	@Override
	public void addOrder(Order od) {
		orderDao.addOrder(od);
	}
	@Override
	public List<Map<String,Object>> selectAllOrderByUserId(Integer userid) {
		return orderDao.selectAllOrderByUserId(userid);
	}
	@Override
	public void addOrderDetail(Map<String, Object> map) {
		orderDao.addOrderDetail(map);
	}
	@Override
	public List<Map<String, Object>> selectOrderDetailByOrderId(Integer orderid) {
		return orderDao.selectOrderDetailByOrderId(orderid);
	}
	@Override
	public List<Map<String, Object>> selectProductCount(Integer orderid) {
		return orderDao.selectProductCount(orderid);
	}
	@Override
	public void payOrder(Integer orderid) {
		orderDao.payOrder(orderid);
	}
	@Override
	public Order selectOrdByOrderid(Integer orderid) {
		return orderDao.selectOrdByOrderid(orderid);
	}
	@Override
	public void updateOrderStatus(Integer orderid, Integer status) {
		Integer newstatus;
		if(status==1) {
			newstatus=0;
		}else {
			newstatus=1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderid", orderid);
		map.put("status", newstatus);
		orderDao.updateOrderStatus(map);	
	}
	@Override
	public void deleteorder(Integer orderid) {
		orderDao.deleteOrderByOrderid(orderid);
	}
	
}
