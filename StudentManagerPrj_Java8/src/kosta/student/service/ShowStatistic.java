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

public class ShowStatistic implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		String menu = "";
		LinkedList<Student> list = null;
		
		ListStudent ls = new ListStudent();

		EX_1:	while(true){
			System.out.println("**********************************************************************************");
			System.out.println("1.성별 그룹핑 | 2.반별 성적 평균 | 3. 주소별 성적 평균 | 4.학년별 키 평균 | 0.복귀");
			System.out.println("**********************************************************************************");
			
			menu = scan.next();
			list = StudentManager.getList("1");

			switch (menu) {
			case "1":
//				list = StudentManager.getList("1");
				Map<String, List<Student>> map = list.stream()
				.collect(Collectors.groupingBy(t->t.getGender()));		//성별 맵
				
				Iterator<Entry<String, List<Student>>> it = map.entrySet().iterator();
				System.out.println("========================================================");
				System.out.println("번호  이름   주소   성별   반   키   나이   점수   학년 ");
				while(it.hasNext()){
					Map.Entry<String, List<Student>> entry = it.next();
					String key = entry.getKey();
					System.out.println("--------------------------------------------------------");
					System.out.println(key);
					for (Student s : entry.getValue()) {
						ls.printStudent(s);
					}
				}
				System.out.println("========================================================");
				break;
			case "2":					// 반별 평균
				Map<String, Double> map2 = list.stream()
				.collect(Collectors.groupingBy(t->t.getClss(),
						 Collectors.averagingDouble(t->t.getScore())));
				
				Iterator<Entry<String, Double>> it2 = map2.entrySet().iterator();
				System.out.println("=============");
				System.out.println("반  평균 성적");
				System.out.println("-------------");
				while(it2.hasNext()){
					Map.Entry<String, Double> entry = it2.next();
					System.out.printf("%-2s반   %5.1f\n", entry.getKey(), entry.getValue());
				}
				System.out.println("=============");
				break;
				
			case "3":				// 주소별 평균
				Map<String, Double> map3 = list.stream()
				.collect(Collectors.groupingBy(t->t.getAddress(),
						 Collectors.averagingDouble(t->t.getScore())));

				Iterator<Entry<String, Double>> it3 = map3.entrySet().iterator();
				System.out.println("===============");
				System.out.println("주소  평균 성적");
				System.out.println("---------------");
				while(it3.hasNext()){
					Map.Entry<String, Double> entry = it3.next();
					String key = entry.getKey();
					System.out.printf("%-6s   %5.1f\n", entry.getKey(), entry.getValue());
				}
				System.out.println("===============");
				break;
			case "4":					// 학년별 키 평균
				Map<Integer, Double> map4 = list.stream()
				.collect(Collectors.groupingBy(t->t.getYear(),
						 Collectors.averagingDouble(t->t.getHeight())));
				
				Iterator<Entry<Integer, Double>> it4 = map4.entrySet().iterator();
				System.out.println("===============");
				System.out.println("학년    평균 키");
				System.out.println("---------------");
				while(it4.hasNext()){
					Map.Entry<Integer, Double> entry = it4.next();
					System.out.printf("%-1d 학년   %5.1f\n", entry.getKey(), entry.getValue());
				}
				System.out.println("===============");
				break;				
			case "0":
				
				break EX_1;			
			default:
				System.out.println("다시 입력해.[0 ~ 4]");
				break;
			} // end of case
		} // end of while
		
	} // end of execute()

}
