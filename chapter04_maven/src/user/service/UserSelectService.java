package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserSelectService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public void execute() {
		List<UserDTO>list = userDAO.getUserList();
		
		System.out.println("이름\t\t아이디\t\t비밀번호");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t\t"+userDTO.getId()+"\t\t"+userDTO.getPwd());
		}
		
	}

}
