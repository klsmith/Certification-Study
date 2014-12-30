package com.pkw.certification.study.refactored.model;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class Answer {

	private Letter letter;
	private String text;

	public static Answer createWith(Letter letter, String text) {
		return new Answer(letter, text);
	}

	private Answer(Letter letter, String text) {
		this.letter = letter;
		this.text = text.trim();
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
		return new RadioButton();
	}

	public Answer.CheckButton checkButton() {
		return new CheckButton();
	}

	public interface Button {
		public Letter letter();

		public JToggleButton button();
	}

	public class RadioButton implements Button {

		private JRadioButton button;

		private RadioButton() {
			button = new JRadioButton("<html>" + letter + ". " + text
					+ "</html>");
			button.setMaximumSize(new Dimension(300, 1000));
		}

		public Letter letter() {
			return letter;
		}

		@Override
		public JToggleButton button() {
			return button;
		}
	}

	public class CheckButton implements Button {
		private JCheckBox button;

		private CheckButton() {
			button = new JCheckBox("<html>" + letter + ". " + text + "</html>");
			button.setMaximumSize(new Dimension(300, 1000));
		}

		@Override
		public Letter letter() {
			return letter;
		}

		@Override
		public JToggleButton button() {
			return button;
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
