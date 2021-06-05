package service;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import pojo.Product;
public interface ProductService {
	public Product selectProductById(Integer id);//id��ѯ��Ʒ
	public List<Map<String,Object>> selectProductByWord(Map<String,Object> map);//��ҳ��ѯ��Ʒ
	public Integer selectAllProductByWord(Map<String,Object> map);// ģ����ѯ������Ʒ����
	public List<Map<String,Object>> splitpage(String word,int number);//�̳Ƿ�ҳ
	public List<Map<String,Object>> splitpage2(String word,int number);//��̨��ҳ
	public void deleteProduct(Integer proid);//����idɾ����Ʒ
	public void updateProduct(int proid,String name,String price);//�޸���Ʒ
	public void addproduct(MultipartFile imgpath,String productname,String price);//�����Ʒ
}
