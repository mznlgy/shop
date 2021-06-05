package dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository("cartDao")
@Mapper
/**
 *���ﳵ���ݷ��ʲ�
 */
public interface CartDao {
	public List<Map<String, Object>> selectCartByUser(Integer userid);//��ѯ�û��Ĺ��ﳵ��Ʒ
	public  List<Map<String, Object>> isExistedCart(Map<String, Object> map);//�ж���Ʒ�Ƿ��ڹ��ﳵ��
	public int addCart(Map<String, Object> map);//�����Ʒ�����ﳵ
	public int updateCart(Map<String, Object> map);//���¹��ﳵ��Ϣ
	public int deleteCart(Map<String, Object> map);//�Ƴ���Ʒ
	public int clearCart(Integer userid);//��չ��ﳵ
}
