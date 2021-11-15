package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;



public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		//클래스패스는 항상 src를 기준으로보기때문에 패키지 안으로 들어갔으면 표시를 해주야함
		HelloSpring helloSpring = context.getBean("helloSpring",HelloSpring.class);
		helloSpring.menu(context);
		System.out.println();
		System.out.println("*****EXIT*****");
		
	}
	
	
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		UserService userService=null;
		int num;

		while (true) {
			System.out.println();
			System.out.println("**************");
			System.out.println("   1. 입력");
			System.out.println("   2. 출력");
			System.out.println("   3. 수정");
			System.out.println("   4. 삭제");
			System.out.println("   5. 종료");
			System.out.println("**************");
			System.out.print("번호 입력 : ");

			num = scan.nextInt();

			if (num == 5)
				break;

			if (num == 1) {
				userService = context.getBean("userInsertService",UserService.class);
			} else if (num == 2) {
				userService = context.getBean("userSelectService",UserService.class);
			} else if (num == 3) {
				userService = context.getBean("userUpdateService",UserService.class);
			} else if (num == 4) {
				userService = context.getBean("userDeleteService",UserService.class);
			}
			
			userService.execute();
	
		}//while
	}//menu
	

	
	
	
	
}
