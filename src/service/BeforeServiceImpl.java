package service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import controller.BeforeController;
import dao.ProductDao;
import dao.UserDao;
import pojo.Product;
import pojo.User;
@Service("beforeService")
public class BeforeServiceImpl implements BeforeService{
	private static final Log logger = LogFactory.getLog(BeforeServiceImpl.class);
	@Autowired
	private UserDao userDao;
	/*×¢²á*/
	@Override
	public void Register(User rf) {
		userDao.addUser(rf);
	}
	@Override
	public boolean Login(User rf) {
		User res = userDao.selectByUserName(rf.getUsername());
		if(res==null) {
			return false;
		}else if(!res.getPassword().equals(rf.getPassword())){
			return false;
		}else {
			return true;
		}
	}
	/*ÕÒ»ØÃÜÂë*/
	@Override
	public boolean FindPassword(User rf) {
		User res = userDao.selectByUserName(rf.getUsername());
		if(res==null) {
			return false;
		}else if(!res.getEmail().equals(rf.getEmail())){
			return false;
		}else {
			return true;
		}
	}
	/*ÐÞ¸ÄÃÜÂë*/
	@Override
	public void ChangePassword(User rf) {
		userDao.ChangePassword(rf);
	}
	@Override
	public User selectUserByUserName(String username) {
		return userDao.selectByUserName(username);
	}
	@Override
	public int getUserIdByUsername(String username) {
		return userDao.selectByUserName(username).getUser_id();
	}
	@Override
	public User selectUserById(Integer userid) {
		return userDao.selectUserById(userid);
	}
	@Override
	public void changeuser(User rf) {
		User olduser = userDao.selectUserById(rf.getUser_id());
		//logger.info("olduser-¡·"+olduser.getUsername()+olduser.getPassword());
		//logger.info("²ÎÊý-¡·"+rf.getUsername()+rf.getPassword());
		if(!"".equals(rf.getUsername())) {
			olduser.setUsername(rf.getUsername());
		}
		if(!"".equals(rf.getPassword())) {
			olduser.setPassword(rf.getPassword());
		}
		if(!"".equals(rf.getEmail())) {
			olduser.setEmail(rf.getEmail());
		}
		if(!"".equals(rf.getQuestion())) {
			olduser.setQuestion(rf.getQuestion());
		}
		if(!"".equals(rf.getAnswer())) {
			olduser.setAnswer(rf.getAnswer());
		}
		userDao.updateUser(olduser);
	}
}
