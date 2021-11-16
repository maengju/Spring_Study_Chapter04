package user.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserDeleteService implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDTO userDTO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("삭제할 아이디 입력 : ");
			String id = scan.next();
			userDTO.setId(id);
			
			List<UserDTO> list = userDAO.getUser(userDTO);
			
			
			if(list.size()==0) {
				System.out.println("찾고자하는 아이디가 없습니다.");
				
			}else {
				userDAO.delete(id);
				System.out.println(id+"님의 데이터를 삭제하였습니다.");
				return;
			}
			
		}

	}

}
