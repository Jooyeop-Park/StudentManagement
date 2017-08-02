package kosta.student.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class ListStudent implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		LinkedList<Student> list = null;

		String menu = "";
EX_1:	while(true){
			System.out.println("*******************************************************");
			System.out.println("1.이름 순서로 | 2.성적 순서로 | 3. 반별 리스트 | 0.복귀");
			System.out.println("*******************************************************");
			
			menu = scan.next();
			switch (menu) {
			case "1":
			case "2":
				list = StudentManager.getList(menu);
				System.out.println("========================================================");
				System.out.println("번호  이름   주소   성별   반   키   나이   점수   학년 ");
				System.out.println("--------------------------------------------------------");
				for(Student s : list){
					printStudent(s);
				}
				System.out.println("========================================================");
				break;
			case "3":
				list = StudentManager.getList("1");
				Map<String, List<Student>> map = list.stream()
				.collect(Collectors.groupingBy(t->t.getClss()));
				
				Iterator<Entry<String, List<Student>>> it = map.entrySet().iterator();
				System.out.println("========================================================");
				System.out.println("번호  이름   주소   성별   반   키   나이   점수   학년 ");
				while(it.hasNext()){
					Map.Entry<String, List<Student>> entry = it.next();
					String key = entry.getKey();
					System.out.println("--------------------------------------------------------");
					System.out.println(key + "반");
					for (Student s : entry.getValue()) {
						printStudent(s);
					}
				}
				System.out.println("========================================================");
				break;
				
			case "0":
				
				break EX_1;			
			default:
				System.out.println("다시 입력해.[0 ~ 2]");
				break;
			} // end of case
		} // end of while
	} // end of execute()

	void printStudent(Student s){
		System.out.printf("%2d  %-6s  %-8s  %-2s  %2s  %5.1f  %3d  %4d     %2d \n",
				 s.getNum(), s.getName(), s.getAddress(), s.getGender(), s.getClss(), s.getHeight(), s.getAge(), s.getScore(), s.getYear() );

	} // end of printStudent()
}
