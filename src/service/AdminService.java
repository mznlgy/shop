package service;
import pojo.Admin;
import pojo.User;
public interface AdminService {
	public boolean login(String username,String password);//��¼
	public void Register(Admin ad);//ע��       
	public Admin selectUserByUserName(String username);//�����û�
	public boolean FindPassword(Admin  ff);//�һ�����
	public void ChangePassword(Admin rf);//��������
	public boolean checkAdmin(String name);//��ѯ�û��Ƿ����
}
