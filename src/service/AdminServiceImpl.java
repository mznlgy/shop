package service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.AdminDao;
import pojo.Admin;
import pojo.User;
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	private static final  Log logger = LogFactory.getLog(AdminServiceImpl.class);
	@Autowired
	private AdminDao adminDao;
	@Override
	public boolean login(String username,String password) {
		Admin res  = adminDao.selectByUserName(username);
		logger.info("输入->"+username+"/"+password);
		logger.info("数据库->"+username+"/"+res.getPassword());
		if(res==null) {
			return false;
		}else if(!res.getPassword().equals(password)){
			return false;
		}else {
			return true;
		}	
	}
	@Override
	public void Register(Admin ad) {
		adminDao.addAdmin(ad);
	}
	@Override
	public Admin selectUserByUserName(String username) {
		return adminDao.selectByUserName(username);
	}
	/*找回密码*/
	@Override
	public boolean FindPassword(Admin rf) {
		Admin res = adminDao.selectByUserName(rf.getUsername());
		if(res==null) {
			return false;
		}else if(!res.getEmail().equals(rf.getEmail())){
			return false;
		}else {
			return true;
		}
	}
	@Override
	public void ChangePassword(Admin rf) {
		Admin newUser = adminDao.selectByUserName(rf.getUsername());
		newUser.setPassword(rf.getPassword());
		adminDao.ChangePassword(newUser);
	}
	@Override
	public boolean checkAdmin(String name) {
		Admin res = adminDao.selectByUserName(name);
		if(res!=null) {
			return false;
		}else {
			return true;
		}
		
	}
	
}
