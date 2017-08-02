package kosta.student.test;

import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.service.AddScore;
import kosta.student.service.AddStudent;
import kosta.student.service.ListStudent;
import kosta.student.service.SearchStudent;
import kosta.student.service.ShowStatistic;
import kosta.student.service.StudentService;

public class StudentManageTest {
	public static void main(String[] args) {
		 /*
		    1. 학생정보 추가(번호/이름/주소/성별/반/키/나이/학년)
		    2. 성적정보 추가(학번입력 -> 성적 입력
		    3. 학생 리스트 출력
				3.1 이름순 오름차순 정렬
				3.2 성적순 내림차순 정렬
				3.3 반별 리스트 출력
			4. 학생정보 검색
				4.1 주소 검색
				4.2 이름 검색
			5. 통계
				5.1 성별 그룹핑
				5.2 반별 성적 평균
				5.3 주소별 성적 평균
				5.4 학년별 키 평균
			0. 종료
			
			에러처리 반드시 할것
		 	throw new NullException("학번을 입력하세요.");
		 	성공/실패여부 확인 메시지 반드시 출력
		 	깃허브에 commit & push
		 	주석처리(javadoc)
		  */
		Logger logger = Logger.getLogger("Student Project ---- ");
		logger.info(" ");
		
		Scanner scan = new Scanner(System.in);
		String menu;
		StudentService ss = null;
		
		while(true){
			System.out.println("***********************************************************************************");
			System.out.println("1.학생 추가 | 2.성적 추가 | 3.학생 리스트 출력 | 4.학생 검색 | 5.통계 조회 | 0.종료");
			System.out.println("***********************************************************************************");
			
			menu = scan.next();
			
			switch (menu) {
			case "1":
				ss = new AddStudent();
				ss.execute(scan);
				break;
			case "2":
				ss = new AddScore();
				ss.execute(scan);
				break;
			case "3":
				ss = new ListStudent();
				ss.execute(scan);
				break;
			case "4":
				ss = new SearchStudent();
				ss.execute(scan);
				break;
			case "5":
				ss = new ShowStatistic();
				ss.execute(scan);
				break;
			case "0":
				System.exit(0);
				break;

			default:
				System.out.println("다시 입력해.[0 ~ 5]");
				break;
			}
			
		}
		
		
	} // end of main
} // end of class
