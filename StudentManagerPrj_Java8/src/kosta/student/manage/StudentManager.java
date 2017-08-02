package kosta.student.manage;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import kosta.student.vo.Student;

/**
 * Student 데이터 처리하는 클래스
 * 입출력을 여기서 하지 않음
 *
 */
public class StudentManager {

	private static LinkedList<Student> list = new LinkedList<>();
	
	static{
		list.add(new Student(10, "AAA", "addr1", "남", "1", 170.0, 20, 95, 3));
		list.add(new Student(20, "BBB", "addr2", "여", "1", 165.0, 30, 90, 2));
		list.add(new Student(30, "CCC", "addr3", "남", "2", 175.0, 40, 80, 1));
		list.add(new Student(40, "DDD", "addr4", "여", "2", 180.0, 25, 100, 4));
		list.add(new Student(50, "EEE", "addr1", "여", "3", 160.0, 25, 100, 4));
		list.add(new Student(60, "FFF", "addr2", "남", "4", 180.0, 35, 70, 1));
		list.add(new Student(70, "GGG", "addr3", "여", "3", 180.0, 45, 100, 4));
		list.add(new Student(80, "HHH", "addr4", "여", "4", 190.0, 25, 55, 2));

	}
	
	public static boolean add(Student s){
		return list.add(s);
	}

	public static LinkedList<Student> getList(String sortingBase) {
		if(sortingBase.equals("1")){
			Collections.sort(list, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName()) ;
				}
			});
		} else{
			Collections.sort(list, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o2.getScore() - o1.getScore();
				}
			});
		}
		
		return list;
	}

	public static void setList(LinkedList<Student> list) {
		StudentManager.list = list;
	}
	
	
}
