package com.pkw.certification.study.refactored.model;

public class ProblemImporter {

	public static ProblemImporter createWithPath(String path) {
		return new ProblemImporter(path);
	}

	private ProblemImporter(String path) {

	}

	public Problem importQuestion() {
		return Problem.Builder.create()//
				.question("Which of the following is a public IP addres?")//
				.answerA("10.0.0.1")//
				.answerB("62.10.1.1")//
				.answerC("172.16.0.1")//
				.answerD("192.168.1.1")//
				.correctAnswer("B")//
				.explanation("")//
				.build();
	}

}
