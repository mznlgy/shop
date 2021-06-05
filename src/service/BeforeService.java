package service;
import pojo.User;
public interface BeforeService {
	public void Register(User rf);//注册
	public void ChangePassword(User rf);//更改密码
	public boolean FindPassword(User  ff);//找回密码
	public boolean Login(User rf);//登录
	public User selectUserByUserName(String username);//查找用户
	public int getUserIdByUsername(String username);//获取用户id
	public User selectUserById(Integer userid);//用户管理
	public void changeuser(User rf);//更新用户
	
}
