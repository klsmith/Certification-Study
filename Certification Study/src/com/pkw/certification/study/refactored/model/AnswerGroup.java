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

	public static AnswerGroup create() {
		return new AnswerGroup();
	}

	private AnswerGroup() {
		answerMap = new TreeMap<Answer.Letter, Answer>();
	}

	public AnswerGroup duplicate() {
		return new AnswerGroup(answerMap);
	}

	private AnswerGroup(SortedMap<Answer.Letter, Answer> answerMap) {
		SortedMap<Answer.Letter, Answer> duplicateAnswerMap = new TreeMap<Answer.Letter, Answer>();
		for (Answer.Letter key : answerMap.keySet()) {
			duplicateAnswerMap.put(key, answerMap.get(key));
		}
		this.answerMap = duplicateAnswerMap;
	}

	public void add(Answer answer) {
		answerMap.put(answer.letter(), answer);
	}

	public Answer choose(Letter letter) {
		return answerMap.get(letter);
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

	public class Panel extends JPanel {
		private static final long serialVersionUID = 4816372482400783651L;

		private List<Answer.RadioButton> radioButtonList;

		private Panel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			radioButtonList = new ArrayList<Answer.RadioButton>();
			ButtonGroup group = new ButtonGroup();
			for (Answer.Letter letter : answerMap.keySet()) {
				Answer.RadioButton radioButton = answerMap.get(letter)
						.radioButton();
				radioButtonList.add(radioButton);
				group.add(radioButton);
				add(radioButton);
			}
		}

		public Letter selectedLetter() {
			for (Answer.RadioButton radioButton : radioButtonList) {
				if (radioButton.isSelected()) {
					return radioButton.letter();
				}
			}
			return Answer.Letter.ERR;
		}
	}
}
