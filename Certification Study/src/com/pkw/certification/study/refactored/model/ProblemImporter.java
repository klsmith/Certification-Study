package com.pkw.certification.study.refactored.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.pkw.certification.study.refactored.model.Answer.Letter;

public class ProblemImporter {

	private static final String QUESTION_NO_PREFIX = "QUESTION NO:";
	private static final int POSSIBLE_ANSWER_PREFIX_SIZE = 3;
	private static final String EXPLANATION_PREFIX = "Explanation:";
	private static final String CORRECT_ANSWER_PREFIX = "Answer:";
	private static final int FIRST_CHAR = 0;
	private InputStream stream;
	private BufferedReader reader;
	private String currentLine;

	public static ProblemImporter createWithPath(String path) {
		return new ProblemImporter(path);
	}

	private ProblemImporter(String path) {
		stream = this.getClass().getResourceAsStream(path);
		currentLine = "";
	}

	private void setupReader() {
		reader = new BufferedReader(new InputStreamReader(stream));
	}

	public ProblemList importProblems() {
		ProblemList problemList = ProblemList.create();
		setupReader();
		Problem.Builder builder = Problem.Builder.create();
		while (readLine()) {
			if (isProblemNumber()) {
				builder.setNumber(getNumber());
			} else if (isPossibleAnswer()) {
				builder.addAnswerChoice(getPossibleAnswer());
			} else if (isExplanation()) {
				builder.setExplanation(getExplanation());
				problemList.add(builder.build());
				builder = Problem.Builder.create();
			} else if (isCorrectAnswer()) {
				builder.addAllCorrectAnswers(getCorrectAnswers());
			} else {
				builder.setQuestion(currentLine);
			}
		}
		return problemList;
	}

	private boolean readLine() {
		try {
			return (currentLine = reader.readLine()) != null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isProblemNumber() {
		return currentLine.startsWith(QUESTION_NO_PREFIX);
	}

	private int getNumber() {
		int place = QUESTION_NO_PREFIX.length() + 1;
		return Integer.parseInt(currentLine.substring(place));
	}

	private boolean isPossibleAnswer() {
		boolean returnValue = false;
		if (currentLine.charAt(1) == '.') {
			returnValue = true;
		}
		return returnValue;
	}

	private Answer getPossibleAnswer() {
		Answer.Letter letter = Answer.Letter.valueOf(getFirstChar());
		String text = currentLine.substring(POSSIBLE_ANSWER_PREFIX_SIZE);
		return Answer.createWith(letter, text);
	}

	private char getFirstChar() {
		return currentLine.charAt(FIRST_CHAR);
	}

	private boolean isCorrectAnswer() {
		return currentLine.startsWith(CORRECT_ANSWER_PREFIX);
	}

	private List<Letter> getCorrectAnswers() {
		int place = CORRECT_ANSWER_PREFIX.length() + 1;
		List<Letter> correctAnswers = new ArrayList<Letter>();
		while (place < currentLine.length()) {
			Letter letter = Letter.valueOf(currentLine.charAt(place));
			if (letter != Letter.ERR) {
				correctAnswers.add(letter);
			}
			place += 1;
		}
		return correctAnswers;
	}

	private boolean isExplanation() {
		return currentLine.startsWith(EXPLANATION_PREFIX);
	}

	private String getExplanation() {
		int place = EXPLANATION_PREFIX.length() + 1;
		try {
			return currentLine.substring(place);
		} catch (StringIndexOutOfBoundsException e) {
			return "";
		}
	}

}
