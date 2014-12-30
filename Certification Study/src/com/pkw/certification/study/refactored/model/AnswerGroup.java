package com.pkw.certification.study.refactored.model;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.pkw.certification.study.refactored.model.Answer.Letter;

public class AnswerGroup {

	private SortedMap<Answer.Letter, Answer> answerMap;
	private List<Letter> correctAnswers;

	public static AnswerGroup create() {
		return new AnswerGroup();
	}

	private AnswerGroup() {
		answerMap = new TreeMap<Answer.Letter, Answer>();
		correctAnswers = new ArrayList<Letter>();
	}

	public AnswerGroup duplicate() {
		return new AnswerGroup(answerMap, correctAnswers);
	}

	private AnswerGroup(SortedMap<Answer.Letter, Answer> answerMap,
			List<Letter> correctAnswers) {
		this();
		this.answerMap.putAll(answerMap);
		this.correctAnswers.addAll(correctAnswers);
	}

	public void addAnswerChoice(Answer answer) {
		answerMap.put(answer.letter(), answer);
	}

	public void addCorrectAnswer(Letter correctAnswer) {
		correctAnswers.add(correctAnswer);
	}

	public List<Letter> correctAnswers() {
		return correctAnswers;
	}

	public boolean isCorrectAnswer(Letter letter) {
		return correctAnswers.contains(letter);
	}

	public Answer choose(Letter letter) {
		return answerMap.get(letter);
	}

	public boolean hasMultipleAnswers() {
		return correctAnswers.size() > 1;
	}

	public Panel panel() {
		return new Panel();
	}

	@Override
	public String toString() {
		String result = "";
		for (Answer.Letter letter : answerMap.keySet()) {
			result += answerMap.get(letter) + "\n";
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((answerMap == null) ? 0 : answerMap.hashCode());
		result = prime * result
				+ ((correctAnswers == null) ? 0 : correctAnswers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof AnswerGroup) {
			AnswerGroup other = (AnswerGroup) obj;
			return answerMap.equals(other.answerMap)
					&& correctAnswers.equals(other.correctAnswers);
		} else {
			return false;
		}
	}

	public class Panel extends JPanel {
		private static final long serialVersionUID = 4816372482400783651L;

		private List<Answer.Button> buttonList;

		private Panel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			buttonList = new ArrayList<Answer.Button>();
			ButtonGroup group = new ButtonGroup();
			for (Answer.Letter letter : answerMap.keySet()) {
				if (correctAnswers.size() == 1) {
					Answer.RadioButton radioButton = answerMap.get(letter)
							.radioButton();
					buttonList.add(radioButton);
					group.add(radioButton.button());
					add(radioButton.button());
				} else {
					Answer.CheckButton checkButton = answerMap.get(letter)
							.checkButton();
					buttonList.add(checkButton);
					add(checkButton.button());
				}
			}
		}

		private List<Letter> selectedLetters() {
			List<Letter> selectedLetters = new ArrayList<Letter>();
			for (Answer.Button radioButton : buttonList) {
				if (radioButton.button().isSelected()) {
					selectedLetters.add(radioButton.letter());
				}
			}
			return selectedLetters;
		}

		public boolean correctAnswersAreSelected() {
			boolean result = false;
			List<Letter> selectedLetters = selectedLetters();
			if (selectedLetters.size() > 0) {
				result = true;
			}
			if (selectedLetters.size() != correctAnswers.size()) {
				return false;
			}
			for (Letter letter : selectedLetters()) {
				if (!correctAnswers.contains(letter)) {
					return false;
				}
			}
			return result;
		}
	}
}
