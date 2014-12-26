package com.pkw.certification.study.refactored.model.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pkw.certification.study.refactored.model.Problem;

public class ProblemTester {

	private Problem problem;
	private Problem duplicate;
	private Problem differentProblem;

	@Before
	public void setup() {
		problem = Problem.Builder.create()//
				.question("Which of the following is a public IP addres?")//
				.answerA("10.0.0.1")//
				.answerB("62.10.1.1")//
				.answerC("172.16.0.1")//
				.answerD("192.168.1.1")//
				.correctAnswer("B")//
				.explanation("")//
				.build();
		duplicate = problem.duplicate();
		differentProblem = Problem.Builder//
				.create()//
				.question(
						"Which of the following ports MUST be open to connect to a PC using RDP?")//
				.answerA("21")//
				.answerB("80")//
				.answerC("443")//
				.answerD("3389")//
				.correctAnswer("D")//
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
	public void testProblemEDoesNotEqualDifferentQuestion() {
		assertFalse(problem.equals(differentProblem));
	}
}
