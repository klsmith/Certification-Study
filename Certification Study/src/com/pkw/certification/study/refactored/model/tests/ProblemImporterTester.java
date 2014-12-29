package com.pkw.certification.study.refactored.model.tests;

import static com.pkw.certification.study.refactored.model.tests.TestProblem.FIRST;
import static com.pkw.certification.study.refactored.model.tests.TestProblem.FOURTH;
import static com.pkw.certification.study.refactored.model.tests.TestProblem.SECOND;
import static com.pkw.certification.study.refactored.model.tests.TestProblem.THIRD;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pkw.certification.study.refactored.model.ProblemImporter;
import com.pkw.certification.study.refactored.model.ProblemList;

public class ProblemImporterTester {

	@Test
	public void testProblemImport() {
		ProblemList imported = ProblemImporter.createWithPath(
				"assets/test-one-question-input.txt").importProblems();
		ProblemList expected = ProblemList.create();
		expected.add(FIRST.problem());

		assertTrue(imported.equals(expected));
	}

	@Test
	public void testSecondProblemImport() {
		ProblemList imported = ProblemImporter.createWithPath(
				"assets/test-four-question-input.txt").importProblems();
		ProblemList expected = ProblemList.create();
		expected.add(FIRST.problem());
		expected.add(SECOND.problem());
		expected.add(THIRD.problem());
		expected.add(FOURTH.problem());
		System.out.println(imported);
		System.out.println(expected);
		assertTrue(imported.equals(expected));
	}
}
