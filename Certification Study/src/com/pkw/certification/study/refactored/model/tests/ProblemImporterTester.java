package com.pkw.certification.study.refactored.model.tests;

import static com.pkw.certification.study.refactored.model.Answer.Letter.A;
import static com.pkw.certification.study.refactored.model.Answer.Letter.B;
import static com.pkw.certification.study.refactored.model.Answer.Letter.C;
import static com.pkw.certification.study.refactored.model.Answer.Letter.D;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pkw.certification.study.refactored.model.Answer;
import com.pkw.certification.study.refactored.model.Problem;
import com.pkw.certification.study.refactored.model.ProblemImporter;

public class ProblemImporterTester {

	@Test
	public void testProblemImport() {
		Problem imported = ProblemImporter.createWithPath(
				"assets/test-one-question-input.txt").importQuestion();
		Problem expected = Problem.Builder.create()//
				.question("Which of the following is a public IP addres?")//
				.addAnswer(Answer.createWith(A, "10.0.0.1"))//
				.addAnswer(Answer.createWith(B, "62.10.1.1"))//
				.addAnswer(Answer.createWith(C, "172.16.0.1"))//
				.addAnswer(Answer.createWith(D, "192.168.1.1"))//
				.correctAnswer(B)//
				.explanation("")//
				.build();
		assertTrue(imported.equals(expected));
	}

}
