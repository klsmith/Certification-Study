package com.pkw.certification.study.refactored.model;

public class Answer {

	private Letter letter;
	private String text;

	public static Answer createWith(Letter letter, String text) {
		return new Answer(letter, text);
	}

	private Answer(Letter letter, String text) {
		this.letter = letter;
		this.text = text;
	}

	public Letter letter() {
		return letter;
	}

	public String text() {
		return text;
	}

	@Override
	public String toString() {
		return letter + ": " + text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letter == null) ? 0 : letter.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof Answer) {
			Answer other = (Answer) obj;
			return other.text.equals(text) && other.letter == letter;
		}
		return false;
	}

	public static enum Letter {
		A, B, C, D;
	}
}
