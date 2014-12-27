package com.pkw.certification.study.refactored.model.tests;

import static com.pkw.certification.study.refactored.model.Answer.Letter.A;
import static com.pkw.certification.study.refactored.model.Answer.Letter.B;
import static com.pkw.certification.study.refactored.model.Answer.Letter.C;
import static com.pkw.certification.study.refactored.model.Answer.Letter.D;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pkw.certification.study.refactored.model.Answer;
import com.pkw.certification.study.refactored.model.Problem;
import com.pkw.certification.study.refactored.model.ProblemImporter;

public class ProblemImporterTester {

	@Test
	public void testProblemImport() {
		List<Problem> imported = ProblemImporter.createWithPath(
				"assets/test-one-question-input.txt").importProblem();
		List<Problem> expected = new ArrayList<Problem>();
		expected.add(Problem.Builder.create()//
				.question("Which of the following is a public IP addres?")//
				.addAnswer(Answer.createWith(A, "10.0.0.1"))//
				.addAnswer(Answer.createWith(B, "62.10.1.1"))//
				.addAnswer(Answer.createWith(C, "172.16.0.1"))//
				.addAnswer(Answer.createWith(D, "192.168.1.1"))//
				.correctAnswer(B)//
				.explanation("")//
				.build());
		assertTrue(imported.equals(expected));
	}

	@Test
	void testSecondProblemImport() {
		List<Problem> imported = ProblemImporter.createWithPath(
				"assets/test-four-question-input.txt").importProblem();
		List<Problem> expected = new ArrayList<Problem>();
		expected.add(Problem.Builder.create()//
				.question("Which of the following is a public IP addres?")//
				.addAnswer(Answer.createWith(A, "10.0.0.1"))//
				.addAnswer(Answer.createWith(B, "62.10.1.1"))//
				.addAnswer(Answer.createWith(C, "172.16.0.1"))//
				.addAnswer(Answer.createWith(D, "192.168.1.1"))//
				.correctAnswer(B)//
				.explanation("")//
				.build());
		expected.add(Problem.Builder
				.create()
				.question(
						"Which of the following ports MUST be open to connect to a PC using RDP?")//
				.addAnswer(Answer.createWith(A, "21"))//
				.addAnswer(Answer.createWith(B, "80"))//
				.addAnswer(Answer.createWith(C, "443"))//
				.addAnswer(Answer.createWith(D, "3389"))//
				.correctAnswer(D)//
				.explanation("")//
				.build());
		expected.add(Problem.Builder
				.create()
				//
				.question(
						"Which of the following is the MAXIMUM transfer speed of USB 2.0?")//
				.addAnswer(Answer.createWith(A, "100 Mbps"))//
				.addAnswer(Answer.createWith(B, "400 Mbps"))//
				.addAnswer(Answer.createWith(C, "420 Mbps"))//
				.addAnswer(Answer.createWith(D, "480 Mbps"))//
				.correctAnswer(D)//
				.explanation("")//
				.build());
		expected.add(Problem.Builder
				.create()
				//
				.question(
						"Which of the following display connections has 15-pins?")//
				.addAnswer(Answer.createWith(A, "RGB"))//
				.addAnswer(Answer.createWith(B, "VGA"))//
				.addAnswer(Answer.createWith(C, "DVI"))//
				.addAnswer(Answer.createWith(D, "HDMI"))//
				.correctAnswer(B)//
				.explanation("")//
				.build());
		assertTrue(imported.equals(expected));
	}
}
