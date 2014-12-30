package com.pkw.certification.study.refactored.model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pkw.certification.study.refactored.model.Answer.Letter;

public class Problem implements Comparable<Problem> {

	private int number;
	private String question;
	private AnswerGroup answerGroup;
	private Answer.Letter correctAnswer;
	private String explanation;

	private Problem(int number, String question, AnswerGroup answerGroup,
			Answer.Letter correctAnswer, String explanation) {
		this.number = number;
		this.question = question;
		this.answerGroup = answerGroup;
		this.correctAnswer = correctAnswer;
		this.explanation = explanation;
	}

	public Problem duplicate() {
		return new Problem(number, question, answerGroup.duplicate(),
				correctAnswer, explanation);
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
				+ ((answerGroup == null) ? 0 : answerGroup.hashCode());
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
					&& (answerGroup.equals(other.answerGroup))
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
		result += answerGroup.toString();
		result += "Answer: " + correctAnswer + "\n";
		result += "Explanation: " + explanation + "\n";
		return result;
	}

	public JPanel panel() {
		JPanel panel = new JPanel();
		GroupLayout layout = getGroupLayoutFor(panel);
		JLabel questionLabel = getQuestionLabel();
		AnswerGroup.Panel answerGroupPanel = answerGroup.panel();
		JButton checkButton = getCheckButton(panel, answerGroupPanel);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(questionLabel).addComponent(answerGroupPanel)//
				.addComponent(checkButton));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(questionLabel)//
				.addComponent(answerGroupPanel).addComponent(checkButton));
		panel.setLayout(layout);
		return panel;
	}

	private GroupLayout getGroupLayoutFor(JPanel panel) {
		GroupLayout layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		return layout;
	}

	private JLabel getQuestionLabel() {
		String text = "<html>" + number + ". " + question + "</html>";
		JLabel questionLabel = new JLabel(text);
		questionLabel.setMaximumSize(new Dimension(300, 1000));
		return questionLabel;
	}

	private JButton getCheckButton(final JPanel panel,
			final AnswerGroup.Panel answerGroupPanel) {
		JButton checkButton = new JButton("Check Answer");
		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Letter selected = answerGroupPanel.selectedLetter();
				if (selected == correctAnswer) {
					JOptionPane.showMessageDialog(panel, "Correct! :D");
				} else {
					JOptionPane.showMessageDialog(panel, "Incorrect! :(");
				}
			}
		});
		return checkButton;
	}

	public static class Builder {

		private int number;
		private String question;
		private AnswerGroup answerGroup;
		private Answer.Letter correctAnswer;
		private String explanation;

		public static Builder create() {
			return new Builder();
		}

		private Builder() {
			question = "";
			answerGroup = AnswerGroup.create();
			correctAnswer = Answer.Letter.ERR;
			explanation = "";
		}

		public Builder setNumber(int number) {
			this.number = number;
			return this;
		}

		public Builder setQuestion(String question) {
			this.question = question.trim();
			return this;
		}

		public Builder addAnswer(Answer answer) {
			answerGroup.add(answer);
			return this;
		}

		public Builder setCorrectAnswer(Answer.Letter correctAnswer) {
			this.correctAnswer = correctAnswer;
			return this;
		}

		public Builder setExplanation(String explanation) {
			this.explanation = explanation.trim();
			return this;
		}

		public Problem build() {
			return new Problem(number, question, answerGroup, correctAnswer,
					explanation);
		}
	}
}
