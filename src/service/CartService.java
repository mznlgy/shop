package service;
import java.util.List;
import java.util.Map;

import pojo.ShoppingCart;
public interface CartService {
	public List<Map<String, Object>> selectCartByUser(Integer userid);  //�����û�id��ѯ���ﳵ
	public boolean isExistedCart(Map<String, Object> map);//�ж���Ʒ�Ƿ��ڹ��ﳵ��
	public void addCart(Map<String, Object> map);//�����Ʒ�����ﳵ
	public void updateCart(Map<String, Object> map);//���¹��ﳵ��Ϣ
	public void deleteCart(Map<String, Object> map);//�Ƴ���Ʒ
	public void clearCart(Integer id);//��չ��ﳵ
}
