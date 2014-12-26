package com.pkw.certification.study.refactored.model;

import java.util.HashMap;
import java.util.Map;

public class Problem {

	private String question;
	private Map<String, String> answerMap;
	private String correctAnswer;
	private String explanation;

	private Problem(String question, Map<String, String> answerMap,
			String correctAnswer, String explanation) {
		this.question = question;
		this.answerMap = answerMap;
		this.correctAnswer = correctAnswer;
		this.explanation = explanation;
	}

	public Problem duplicate() {
		return new Problem(question, dusplicateAnswerMap(), correctAnswer,
				explanation);
	}

	private Map<String, String> dusplicateAnswerMap() {
		Map<String, String> dusplicateAnswerMap = new HashMap<String, String>();
		for (String key : answerMap.keySet()) {
			dusplicateAnswerMap.put(key, answerMap.get(key));
		}
		return dusplicateAnswerMap;
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
			return (question.equals(other.question))
					&& (answerMap.equals(other.answerMap))
					&& (correctAnswer.equals(other.correctAnswer))
					&& (explanation.equals(other.explanation));
		} else {
			return false;
		}
	}

	public static class Builder {

		private String question;
		private Map<String, String> answerMap;
		private String correctAnswer;
		private String explanation;

		public static Builder create() {
			return new Builder();
		}

		private Builder() {
			question = "";
			answerMap = new HashMap<String, String>();
			correctAnswer = "";
			explanation = "";
		}

		public Builder question(String question) {
			this.question = question;
			return this;
		}

		public Builder answerA(String answer) {
			answerMap.put("A", answer);
			return this;
		}

		public Builder answerB(String answer) {
			answerMap.put("B", answer);
			return this;
		}

		public Builder answerC(String answer) {
			answerMap.put("C", answer);
			return this;
		}

		public Builder answerD(String answer) {
			answerMap.put("D", answer);
			return this;
		}

		public Builder correctAnswer(String answer) {
			this.correctAnswer = answer;
			return this;
		}

		public Builder explanation(String explanation) {
			this.explanation = explanation;
			return this;
		}

		public Problem build() {
			return new Problem(question, answerMap, correctAnswer, explanation);
		}
	}
}
