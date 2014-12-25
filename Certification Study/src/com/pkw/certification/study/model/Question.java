package com.pkw.certification.study.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String questionNumber;
	private String question, correctAnswer;
	private List<String> possibleAnswers;

	public Question(String questionNumber, String question,
			String correctAnswer, List<String> possibleAnswers) {
		this.questionNumber = questionNumber;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.possibleAnswers = new ArrayList<String>(possibleAnswers);
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
