package service;
import pojo.User;
public interface BeforeService {
	public void Register(User rf);//ע��
	public void ChangePassword(User rf);//��������
	public boolean FindPassword(User  ff);//�һ�����
	public boolean Login(User rf);//��¼
	public User selectUserByUserName(String username);//�����û�
	public int getUserIdByUsername(String username);//��ȡ�û�id
	public User selectUserById(Integer userid);//�û�����
	public void changeuser(User rf);//�����û�
	
}
