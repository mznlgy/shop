package pojo;
/**
 *购物车领域模型
 */
public class ShoppingCart {
	private Integer shopping_id;   //购物车id
	private Integer product_id;   //商品id
	private Integer user_id;     //用户id
	private Integer count ;     //商品数目
	public Integer getShopping_id() {
		return shopping_id;
	}
	public void setShopping_id(Integer shopping_id) {
		this.shopping_id = shopping_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
