package com.self.gs.logical.thinking;
import java.util.*;

class Student{
	private String name;
	private int totalMarks;
	private int totalSubjects;
	public Student(String name) {
		this.name = name;
		this.totalMarks = 0;
		this.totalSubjects = 0;
	}
	public void addMark(int mark) {
		this.totalMarks += mark;
		this.totalSubjects++;
	}
	public float averageMark() {
		return (float)totalMarks / (float) totalSubjects;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", totalMarks=" + totalMarks + ", totalSubjects=" + totalSubjects + "]";
	}
	
}


class StudentMarkComparator implements Comparator<Student>{
	public int compare(Student a, Student b) {
		int diff = (int)( Math.ceil( a.averageMark() - b.averageMark())); 
		if(diff == 0) return b.getName().compareTo(a.getName()); // in case if we want name in alphabetical order
		return diff;
	}
}

public class HighestAvgStudent {

	final Comparator<Student> STUDENT_MARK_ASC  = new StudentMarkComparator();
	
	private  String highest(String[][] students) {
		
		Map<String, Student> studentMap = new HashMap<String, Student>();
		populateStudentMap(students, studentMap);

		PriorityQueue<Student> minHeap = new PriorityQueue<Student>(STUDENT_MARK_ASC);
		
		for(Map.Entry<String, Student> entry : studentMap.entrySet()) {
			minHeap.offer(entry.getValue());
			if(minHeap.size() > 1)  minHeap.poll();  // maintain only top one student in heap
		}
		
		return minHeap.poll().getName();
	}
	
 

	private void populateStudentMap(String[][] students, Map<String, Student> studentMap) {
		for(String[] student : students) {
			String name = student[0];
			int mark = Integer.parseInt(student[1]);
			studentMap.putIfAbsent(name, new Student(name));
			studentMap.get(name).addMark(mark);
		}
		
	}



	public static void main(String[] args) {
		String[][] students = 
			   { 
				{"Dave","10"},
				{"Ben","12"},
				{"Charles","11"},
				{"Ben","8"},
				{"Adam","8"},
				{"Evan","8"},
		      };
	
		
		System.err.println("Highest Avg Student - " + new HighestAvgStudent().highest(students));

	}

	

}
