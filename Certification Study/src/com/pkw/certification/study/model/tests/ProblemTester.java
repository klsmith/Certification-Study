package com.pkw.certification.study.model.tests;

import static com.pkw.certification.study.model.tests.TestProblem.FIRST;
import static com.pkw.certification.study.model.tests.TestProblem.SECOND;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProblemTester {

	@Test
	public void testProblemEqualsItself() {
		assertTrue(FIRST.problem().equals(FIRST.problem()));
	}

	@Test
	public void testProblemEqualsDuplicate() {
		assertTrue(FIRST.problem().equals(FIRST.problem().duplicate()));
	}

	@Test
	public void testProblemDoesNotEqualDifferentQuestion() {
		assertFalse(FIRST.problem().equals(SECOND.problem()));
	}
}
