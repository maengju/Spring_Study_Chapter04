package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

//@Component
@Repository   //DB와 연결되는 것들은 뜻함
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
		
	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	
	
	
	
	@Override
	public void write(UserDTO userDTO) {
		//String sql = "insert into usertable values(?,?,?)";
		//jdbcTemplate.update(sql, userDTO.getName(),userDTO.getId(),userDTO.getPwd());
		
		String sql="insert into usertable values(:name,:id,:pwd)";
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
		
		
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
						
		return getJdbcTemplate().query(sql,new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public List<UserDTO> getUser(UserDTO userDTO) {
		String sql = "select * from usertable where id =?";
		List<UserDTO> results = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
														new Object[] {userDTO.getId()});
		return results;
	}

	@Override
	public void update(UserDTO userDTO) {
		String sql = "update usertable set name=:name ,pwd=:pwd where id=:id";
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void delete(String id) {
		String sql = "delete usertable where id = ?";
		getJdbcTemplate().update(sql, id);
	}

	
	
}
