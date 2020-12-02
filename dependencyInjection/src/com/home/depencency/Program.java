package com.home.depencency;

import com.home.depencency.entity.Exam;
import com.home.ui.ExamColsole;
import com.home.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		Exam exam = new NewlecExam();
		
		// ExamColsole console = new InlineExamConsole(exam);
		ExamColsole console = new GridExamConsole(exam);
		console.print();
		
	}

}
