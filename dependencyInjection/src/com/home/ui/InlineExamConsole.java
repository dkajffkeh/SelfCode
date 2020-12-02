package com.home.ui;

import com.home.depencency.entity.Exam;

public class InlineExamConsole implements ExamColsole {

	private Exam exam;
	
	
	public InlineExamConsole(Exam exam) {
		super();
		this.exam = exam;
	}

	@Override
	public void print() {
		
			System.out.printf("total is %d , avg is %f \n",exam.total(),exam.avg());

	}

}
