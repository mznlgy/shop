package pojo;
/**
 *���ﳵ����ģ��
 */
public class ShoppingCart {
	private Integer shopping_id;   //���ﳵid
	private Integer product_id;   //��Ʒid
	private Integer user_id;     //�û�id
	private Integer count ;     //��Ʒ��Ŀ
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
