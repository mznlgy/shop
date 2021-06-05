package dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository("cartDao")
@Mapper
/**
 *购物车数据访问层
 */
public interface CartDao {
	public List<Map<String, Object>> selectCartByUser(Integer userid);//查询用户的购物车商品
	public  List<Map<String, Object>> isExistedCart(Map<String, Object> map);//判断商品是否在购物车里
	public int addCart(Map<String, Object> map);//添加商品到购物车
	public int updateCart(Map<String, Object> map);//更新购物车信息
	public int deleteCart(Map<String, Object> map);//移除商品
	public int clearCart(Integer userid);//清空购物车
}
