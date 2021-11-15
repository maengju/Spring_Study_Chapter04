package user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {
	@Setter
	private UserDTO userDTO;
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute(){
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("수정할 아이디 입력 : ");
			String id = scan.next();
			userDTO.setId(id);
			
			List<UserDTO> list = userDAO.getUser(userDTO);
			
			
			if(list.size()==0) {
				System.out.println("찾고자하는 아이디가 없습니다.");
				
			}else {
				System.out.println("이름\t\t아이디\t\t비밀번호");
				for(UserDTO userDTO : list) {
					System.out.println(userDTO.getName()+"\t\t"+userDTO.getId()+"\t\t"+userDTO.getPwd());
				}//for
				
				
				System.out.print("수정할 이름 입력 : ");
				String name = scan.next();
				System.out.print("수정할 비밀번호 입력 : ");
				String pwd = scan.next();
				
				userDTO.setName(name);
				userDTO.setPwd(pwd);
				
				userDAO.update(userDTO);
				
				System.out.println(id+"님의 데이터를 수정하였습니다.");
				return;
			}
			
		}
		

	}

}
