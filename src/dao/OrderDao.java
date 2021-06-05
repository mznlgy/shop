package dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Order;
@Repository("orderDao")
@Mapper
/**
 *�������ݷ��ʲ�
 */
public interface OrderDao {
	public int addOrder(Order od);//��������
	public List<Map<String,Object>> selectAllOrderByUserId(Integer userid);//�û�id��ѯ���� 
	public int addOrderDetail(Map<String,Object> map);// ���ɶ�������
	public List<Map<String,Object>> selectOrderDetailByOrderId(Integer orderid);//���ݶ���id��ѯ��������
	public List<Map<String,Object>> selectProductCount(Integer orderid);//���ݶ���id��ѯÿһ��������������Ʒ������
	public int payOrder(Integer orderid);//֧������
	public Order selectOrdByOrderid(Integer orderid);//����id��ѯ�����ſ� 
	public int updateOrderStatus(Map<String,Object> map);//���Ķ���״̬ 
	public int deleteOrderByOrderid(Integer orderid);// ɾ������
}
