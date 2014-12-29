package com.pkw.certification.study.refactored.model;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Problem implements Comparable<Problem> {

	private int number;
	private String question;
	private Map<Answer.Letter, Answer> answerMap;
	private Answer.Letter correctAnswer;
	private String explanation;

	private Problem(int number, String question,
			Map<Answer.Letter, Answer> answerMap, Answer.Letter correctAnswer,
			String explanation) {
		this.number = number;
		this.question = question;
		this.answerMap = answerMap;
		this.correctAnswer = correctAnswer;
		this.explanation = explanation;
	}

	public Problem duplicate() {
		return new Problem(number, question, dusplicateAnswerMap(),
				correctAnswer, explanation);
	}

	private Map<Answer.Letter, Answer> dusplicateAnswerMap() {
		Map<Answer.Letter, Answer> dusplicateAnswerMap = new HashMap<Answer.Letter, Answer>();
		for (Answer.Letter key : answerMap.keySet()) {
			dusplicateAnswerMap.put(key, answerMap.get(key));
		}
		return dusplicateAnswerMap;
	}

	@Override
	public int compareTo(Problem other) {
		if (number == other.number) {
			return 0;
		} else if (number < other.number) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((answerMap == null) ? 0 : answerMap.hashCode());
		result = prime * result
				+ ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result
				+ ((explanation == null) ? 0 : explanation.hashCode());
		result = prime * result + number;
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof Problem) {
			Problem other = (Problem) obj;
			return (number == other.number)
					&& (question.equals(other.question))
					&& (answerMap.equals(other.answerMap))
					&& (correctAnswer.equals(other.correctAnswer))
					&& (explanation.equals(other.explanation));
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String result = "QUESTION NO: " + number + "\n";
		result += question + "\n";
		for (Answer.Letter letter : answerMap.keySet()) {
			result += letter + ". " + answerMap.get(letter).text() + "\n";
		}
		result += "Answer: " + correctAnswer + "\n";
		result += "Explanation: " + explanation + "\n";
		return result;
	}

	public JPanel panel() {
		return new JPanel();
	}

	public static class Builder {

		private int number;
		private String question;
		private Map<Answer.Letter, Answer> answerMap;
		private Answer.Letter correctAnswer;
		private String explanation;

		public static Builder create() {
			return new Builder();
		}

		private Builder() {
			question = "";
			answerMap = new HashMap<Answer.Letter, Answer>();
			correctAnswer = null;
			explanation = "";
		}

		public Builder number(int number) {
			this.number = number;
			return this;
		}

		public Builder question(String question) {
			this.question = question;
			return this;
		}

		public Builder addAnswer(Answer answer) {
			answerMap.put(answer.letter(), answer);
			return this;
		}

		public Builder correctAnswer(Answer.Letter correctAnswer) {
			this.correctAnswer = correctAnswer;
			return this;
		}

		public Builder explanation(String explanation) {
			this.explanation = explanation;
			return this;
		}

		public Problem build() {
			return new Problem(number, question, answerMap, correctAnswer,
					explanation);
		}
	}
}
