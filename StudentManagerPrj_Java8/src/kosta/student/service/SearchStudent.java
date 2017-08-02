package kosta.student.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class SearchStudent implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub

		String menu = "";
EX_1:	while(true){
			LinkedList<Student> list = StudentManager.getList("1");
			Iterator<Student> it = list.iterator();
	
			System.out.println("***********************************");
			System.out.println("1.주소 검색 | 2.이름 검색 | 0.복귀");
			System.out.println("***********************************");
			
			menu = scan.next();
			
			switch (menu) {
			case "1":
				System.out.print("주소 : ");
				String address = scan.next();
				while(it.hasNext()){
					Student s = it.next();
					if(address.equals(s.getAddress())) {
						printStudentWithHeader(s);
					}
				} // end of while
				break;
				
			case "2":
				System.out.print("이름 : ");
				String name = scan.next();
				while(it.hasNext()){
					Student s = it.next();
					if(name.equals(s.getName())) {
						printStudentWithHeader(s);
					}
				} // end of while
				break;

			case "0":
				break EX_1;			
				
			default:
				System.out.println("다시 입력해.[0 ~ 2]");
				break;
			} // end of case
		} // end of while
	} // end of execute()
	
	void printStudentWithHeader(Student s){
		System.out.println("========================================================");
		System.out.println("번호  이름   주소   성별   반   키   나이   점수   학년 ");
		System.out.println("--------------------------------------------------------");
		ListStudent ls = new ListStudent();
		ls.printStudent(s);
		System.out.println("========================================================");

	}

} // end of class
