package dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Admin;
import pojo.User;
@Repository("adminDao")
@Mapper
/**
 *����Ա�û����ݷ��ʲ�
 */
public interface AdminDao {
	public Admin selectByUserName(String usrename);//�����û�����ѯ
	public int addAdmin(Admin rf);//���һ���û�
	public int ChangePassword(Admin rf); //�޸�����
	public int updateAdmin(Admin rf);//�����û�
}
