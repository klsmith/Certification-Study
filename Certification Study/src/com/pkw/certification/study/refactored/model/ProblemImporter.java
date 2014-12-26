package com.pkw.certification.study.refactored.model;

import static com.pkw.certification.study.refactored.model.Answer.Letter.A;
import static com.pkw.certification.study.refactored.model.Answer.Letter.B;
import static com.pkw.certification.study.refactored.model.Answer.Letter.C;
import static com.pkw.certification.study.refactored.model.Answer.Letter.D;

public class ProblemImporter {

	public static ProblemImporter createWithPath(String path) {
		return new ProblemImporter(path);
	}

	private ProblemImporter(String path) {

	}

	public Problem importQuestion() {
		return Problem.Builder.create()//
				.question("Which of the following is a public IP addres?")//
				.addAnswer(Answer.createWith(A, "10.0.0.1"))//
				.addAnswer(Answer.createWith(B, "62.10.1.1"))//
				.addAnswer(Answer.createWith(C, "172.16.0.1"))//
				.addAnswer(Answer.createWith(D, "192.168.1.1"))//
				.correctAnswer(B)//
				.explanation("")//
				.build();
	}

}
