package service;
import java.util.List;
import java.util.Map;
import pojo.Order;
public interface OrderService {
	public void addOrder(Order od);//��������
	public List<Map<String,Object>> selectAllOrderByUserId(Integer userid);//�û�id��ѯ���� 
	public void addOrderDetail(Map<String,Object> map);//���ɶ������� 
	public List<Map<String,Object>> selectOrderDetailByOrderId(Integer orderid);//��ѯ���û������ж���
	public List<Map<String,Object>> selectProductCount(Integer orderid);//���ݶ���id��ѯÿһ��������������Ʒ������
	public void payOrder(Integer orderid);//֧��
	public Order selectOrdByOrderid(Integer orderid);//����id��ѯ�����ſ� 
	public void updateOrderStatus(Integer orderid,Integer status);//���Ķ���״̬ 
	public void deleteorder(Integer orderid);//ɾ������
}
