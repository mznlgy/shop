package dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Product;
@Repository("productDao")
@Mapper
/**
 *商品数据访问层
 */
public interface ProductDao {
	public Product selectProductById(Integer id);//根据id查询商品
	public List<Map<String,Object>> selectProductByWord(Map<String,Object> map);//分页查询
	public Integer selectAllProductByWord(Map<String,Object> map);// 模糊查询所有商品数量
	public List<Map<String,Object>> selectProductByName(Map<String,Object> map);//名称查询商品 
	public int deleteProduct(Integer proid);//根据id删除商品
	public int updateProduct(Product pr);//修改商品
	public int addproduct(Map<String,Object> map);//添加商品
}
