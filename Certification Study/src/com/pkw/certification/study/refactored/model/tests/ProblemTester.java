package com.pkw.certification.study.refactored.model.tests;

import static com.pkw.certification.study.refactored.model.Answer.Letter.A;
import static com.pkw.certification.study.refactored.model.Answer.Letter.B;
import static com.pkw.certification.study.refactored.model.Answer.Letter.C;
import static com.pkw.certification.study.refactored.model.Answer.Letter.D;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pkw.certification.study.refactored.model.Answer;
import com.pkw.certification.study.refactored.model.Problem;

public class ProblemTester {

	private Problem problem;
	private Problem duplicate;
	private Problem differentProblem;

	@Before
	public void setup() {
		problem = Problem.Builder.create()//
				.number(1)//
				.question("Which of the following is a public IP addres?")//
				.addAnswer(Answer.createWith(A, "10.0.0.1"))//
				.addAnswer(Answer.createWith(B, "62.10.1.1"))//
				.addAnswer(Answer.createWith(C, "172.16.0.1"))//
				.addAnswer(Answer.createWith(D, "192.168.1.1"))//
				.correctAnswer(B)//
				.explanation("")//
				.build();
		duplicate = problem.duplicate();
		differentProblem = Problem.Builder//
				.create()//
				.number(2)//
				.question(
						"Which of the following ports MUST be open to connect to a PC using RDP?")//
				.addAnswer(Answer.createWith(A, "21"))//
				.addAnswer(Answer.createWith(B, "80"))//
				.addAnswer(Answer.createWith(C, "443"))//
				.addAnswer(Answer.createWith(D, "3389"))//
				.correctAnswer(D)//
				.explanation("")//
				.build();
	}

	@Test
	public void testProblemEqualsItself() {
		assertTrue(problem.equals(problem));
	}

	@Test
	public void testProblemEEqualsDuplicate() {
		assertTrue(problem.equals(duplicate));
	}

	@Test
	public void testProblemDoesNotEqualDifferentQuestion() {
		assertFalse(problem.equals(differentProblem));
	}
}
