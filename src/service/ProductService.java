package service;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import pojo.Product;
public interface ProductService {
	public Product selectProductById(Integer id);//id查询商品
	public List<Map<String,Object>> selectProductByWord(Map<String,Object> map);//分页查询商品
	public Integer selectAllProductByWord(Map<String,Object> map);// 模糊查询所有商品数量
	public List<Map<String,Object>> splitpage(String word,int number);//商城分页
	public List<Map<String,Object>> splitpage2(String word,int number);//后台分页
	public void deleteProduct(Integer proid);//根据id删除商品
	public void updateProduct(int proid,String name,String price);//修改商品
	public void addproduct(MultipartFile imgpath,String productname,String price);//添加商品
}
