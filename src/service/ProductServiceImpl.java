package service;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import controller.BeforeController;
import dao.ProductDao;
import pojo.Product;
@Service("productService")
public class ProductServiceImpl implements ProductService{
	private static final Log logger = LogFactory.getLog(ProductServiceImpl.class);
	@Autowired
	ProductDao productDao;
	@Override
	public Product selectProductById(Integer id) {
		return productDao.selectProductById(id);
	}
	@Override
	public List<Map<String, Object>> selectProductByWord(Map<String, Object> map) {
		return productDao.selectProductByWord(map);
	}
	/*查询商品（user用户）*/
	@Override
	public List<Map<String, Object>> splitpage(String word,int requestpage) {
		logger.info("搜索词->"+word+"请求页码->"+requestpage);
		int number;//总页数
		Map<String,Object> map =new HashMap<String,Object>();
		Map<String,Object> map2 =new HashMap<String,Object>();
		map.put("product_name", word);
		number = productDao.selectAllProductByWord(map);
		if(number == 0) {
			return null;
		}
		//数据库like查询得到
		int pagesize = 20;//每一页展示20件商品
		int pagecount;//页数
		int startpage;
		if(number%pagesize == 0) {
			pagecount = number%pagesize;
		}else {
			pagecount = number/pagesize+1; //有余数代表需要多一页来展示
		}
		logger.info("页数"+pagecount);
		
		if(pagecount==1) {
			startpage = 0; //limit 0,20
			map2.put("startpage", startpage);
		}
		if(pagecount>1) {
			startpage = (requestpage-1)*pagesize;//limit start,20
			map2.put("startpage", startpage);
			logger.info("要查询的开始索引"+startpage);
		}
		map2.put("product_name", word);
		List<Map<String, Object>> list= productDao.selectProductByWord(map2);
		logger.info("查询结果:"+list.size());
		return list;
	}
	@Override
	public Integer selectAllProductByWord(Map<String, Object> map) {
		return productDao.selectAllProductByWord(map);
	}
	/*查询商品（admin用户）*/
	@Override
	public List<Map<String, Object>> splitpage2(String word,int requestpage) {
		logger.info("搜索词->"+word+"请求页码->"+requestpage);
		int number;//总页数
		Map<String,Object> map =new HashMap<String,Object>();
		Map<String,Object> map2 =new HashMap<String,Object>();
		map.put("product_name", word);
		number = productDao.selectAllProductByWord(map);
		if(number == 0) {
			return null;
		}
		//数据库like查询得到
		int pagesize = 10;//每一页展示20件商品
		int pagecount;//页数
		int startpage;
		if(number%pagesize == 0) {
			pagecount = number%pagesize;
		}else {
			pagecount = number/pagesize+1; //有余数代表需要多一页来展示
		}
		logger.info("页数"+pagecount);
		
		if(pagecount==1) {
			startpage = 0; //limit 0,20
			map2.put("startpage", startpage);
		}
		if(pagecount>1) {
			startpage = (requestpage-1)*pagesize;//limit start,20
			map2.put("startpage", startpage);
			logger.info("要查询的开始索引"+startpage);
		}
		map2.put("product_name", word);
		List<Map<String, Object>> list= productDao.selectProductByName(map2);
		logger.info("查询结果:"+list.size());
		return list;
	}
	@Override
	public void deleteProduct(Integer proid) {
		productDao.deleteProduct(proid);
	}
	/*修改商品*/
	@Override
	public void updateProduct(int proid,String name,String price) {
		Product pr = productDao.selectProductById(proid);
		//logger.info("改的名--》"+name+" 改的价格--》"+price);
		double newprice = Double.valueOf(price);
		if(name.equals("null") && !price.equals("null")) {
			pr.setPrice(newprice);
			productDao.updateProduct(pr);
			logger.info("1"+pr.getProduct_name());
		}
		if(!name.equals("null") && price.equals("null")) {
			pr.setProduct_name(name);
			productDao.updateProduct(pr);
			logger.info("2");
		}
		if(!name.equals("null") && !price.equals("null")) {
			pr.setPrice(newprice);
			pr.setProduct_name(name);
			productDao.updateProduct(pr);
			logger.info("3");
		}
		
	}
	/*添加商品*/
	@Override
	public void addproduct(MultipartFile imgpath, String productname, String price) {
		String realpath = "E:\\java\\Eclipse\\workplace\\shop\\WebContent\\images";
		String filename = imgpath.getOriginalFilename();
		File targetFile = new File(realpath,filename);
		String newimgpath = "images/"+targetFile.getName();
		double newprice = Double.valueOf(price);
		logger.info("文件路径"+newimgpath);
		if(!targetFile.exists()) {
			targetFile.mkdirs();
		}
		//上传图片
		try {
			imgpath.transferTo(targetFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("product_name",productname);
		map.put("imgpath",newimgpath);
		map.put("price",newprice);
		productDao.addproduct(map);
		logger.info("添加成功");
	}
}
