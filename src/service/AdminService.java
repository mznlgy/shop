package service;
import pojo.Admin;
import pojo.User;
public interface AdminService {
	public boolean login(String username,String password);//登录
	public void Register(Admin ad);//注册       
	public Admin selectUserByUserName(String username);//查找用户
	public boolean FindPassword(Admin  ff);//找回密码
	public void ChangePassword(Admin rf);//更改密码
	public boolean checkAdmin(String name);//查询用户是否存在
}
