package com.pkw.certification.study.refactored.model;

import java.awt.Dimension;

import javax.swing.JRadioButton;

public class Answer {

	private Letter letter;
	private String text;
	private RadioButton radioButton;

	public static Answer createWith(Letter letter, String text) {
		return new Answer(letter, text);
	}

	private Answer(Letter letter, String text) {
		this.letter = letter;
		this.text = text.trim();
		radioButton = new RadioButton();
	}

	public Letter letter() {
		return letter;
	}

	public String text() {
		return text;
	}

	@Override
	public String toString() {
		return letter + ". " + text;
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

	public Answer.RadioButton radioButton() {
		return radioButton;
	}

	public class RadioButton extends JRadioButton {
		private static final long serialVersionUID = 5965112682889530488L;

		private RadioButton() {
			super();
			setText("<html>" + letter + ". " + text + "</html>");
			setMaximumSize(new Dimension(300, 1000));
		}

		public Letter letter() {
			return letter;
		}
	}

	public static enum Letter {
		ERR, A, B, C, D, E, F, G, H, I, J, K;

		public static Letter valueOf(char c) {
			String s = String.valueOf(c).toUpperCase();
			for (Letter letter : Letter.values()) {
				if (letter.toString().equals(s)) {
					return letter;
				}
			}
			return ERR;
		}
	}

}
