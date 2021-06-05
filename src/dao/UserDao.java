package dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.User;
@Repository("userDao")
@Mapper
/**
 *��ͨ�û����ݷ��ʲ�
 */
public interface UserDao {
	public int addUser(User rf);//���һ���û�
	public User selectByUserName(String username);//�����û�����ѯ�û�
	public int ChangePassword(User rf); //�޸�����
	public User selectUserById(Integer userid);//����id��ѯ�û�
	public int updateUser(User rf);//�����û�
}
