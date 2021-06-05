package service;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.CartDao;
import pojo.ShoppingCart;
@Service("cartService")
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	@Override
	public List<Map<String,Object>> selectCartByUser(Integer userid) {
		return cartDao.selectCartByUser(userid);
	}
	@Override
	public boolean isExistedCart(Map<String, Object> map) {
		List<Map<String, Object>> res = cartDao.isExistedCart(map);
		if(res.size()>0) {
			return false;   
		}else {
			return true;
		}
	}
	@Override
	public void addCart(Map<String, Object> map) {
		cartDao.addCart(map);
	}
	@Override
	public void updateCart(Map<String, Object> map) {
		cartDao.updateCart(map);
	}
	@Override
	public void deleteCart(Map<String, Object> map) {
		cartDao.deleteCart(map);
	}
	@Override
	public void clearCart(Integer id) {
		cartDao.clearCart(id);
	}
}
