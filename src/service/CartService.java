package service;
import java.util.List;
import java.util.Map;

import pojo.ShoppingCart;
public interface CartService {
	public List<Map<String, Object>> selectCartByUser(Integer userid);  //根据用户id查询购物车
	public boolean isExistedCart(Map<String, Object> map);//判断商品是否在购物车里
	public void addCart(Map<String, Object> map);//添加商品到购物车
	public void updateCart(Map<String, Object> map);//更新购物车信息
	public void deleteCart(Map<String, Object> map);//移除商品
	public void clearCart(Integer id);//清空购物车
}
