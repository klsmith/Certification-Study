package com.pkw.certification.study.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String questionNumber;

	private String question, correctAnswer;
	private List<String> possibleAnswers;

	public Question(String qNumber, String q, String correctAns,
			List<String> possibleAns) {

		questionNumber = qNumber;
		question = q;
		correctAnswer = correctAns;
		possibleAnswers = new ArrayList<String>(possibleAns);

	}

	public String getQuestionNumber() {

		return questionNumber;

	}

	public String getQuestion() {

		return question;

	}

	public String getCorrectAnswer() {

		return correctAnswer;

	}

	public List<String> getPossibleAnswers() {

		return possibleAnswers;

	}

}
