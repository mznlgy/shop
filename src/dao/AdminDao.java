package dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Admin;
import pojo.User;
@Repository("adminDao")
@Mapper
/**
 *管理员用户数据访问层
 */
public interface AdminDao {
	public Admin selectByUserName(String usrename);//根据用户名查询
	public int addAdmin(Admin rf);//添加一个用户
	public int ChangePassword(Admin rf); //修改密码
	public int updateAdmin(Admin rf);//更新用户
}
