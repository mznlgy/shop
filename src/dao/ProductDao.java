package dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Product;
@Repository("productDao")
@Mapper
/**
 *��Ʒ���ݷ��ʲ�
 */
public interface ProductDao {
	public Product selectProductById(Integer id);//����id��ѯ��Ʒ
	public List<Map<String,Object>> selectProductByWord(Map<String,Object> map);//��ҳ��ѯ
	public Integer selectAllProductByWord(Map<String,Object> map);// ģ����ѯ������Ʒ����
	public List<Map<String,Object>> selectProductByName(Map<String,Object> map);//���Ʋ�ѯ��Ʒ 
	public int deleteProduct(Integer proid);//����idɾ����Ʒ
	public int updateProduct(Product pr);//�޸���Ʒ
	public int addproduct(Map<String,Object> map);//�����Ʒ
}
