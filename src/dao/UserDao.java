package dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.User;
@Repository("userDao")
@Mapper
/**
 *普通用户数据访问层
 */
public interface UserDao {
	public int addUser(User rf);//添加一个用户
	public User selectByUserName(String username);//根据用户名查询用户
	public int ChangePassword(User rf); //修改密码
	public User selectUserById(Integer userid);//根据id查询用户
	public int updateUser(User rf);//更新用户
}
