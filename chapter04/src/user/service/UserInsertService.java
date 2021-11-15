package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {
	@Setter
	private UserDTO userDTO;
	
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력");
		String name = scan.next();
		System.out.print("아이디 입력");
		String id = scan.next();
		System.out.print("비밀번호 입력");
		String pwd = scan.next();
		
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		userDAO.write(userDTO);
		
		System.out.println(name+"님의 데이터를 DB에 저장 하였습니다.");
		
	}

}
