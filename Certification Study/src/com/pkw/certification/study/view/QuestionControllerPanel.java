package com.pkw.certification.study.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pkw.certification.study.Application;

public class QuestionControllerPanel extends JPanel {
	private static final long serialVersionUID = -8992276253798344431L;

	public static QuestionControllerPanel createIn(FullViewPanel mainPanel) {
		return new QuestionControllerPanel(mainPanel);
	}

	private QuestionControllerPanel(final FullViewPanel mainPanel) {
		setLayout(new FlowLayout());
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Application.selectedQuestion--;
				if (Application.selectedQuestion < 0) {
					Application.selectedQuestion = Application.questionList
							.size() - 1;
				}
				mainPanel.update();
			}
		});
		JLabel lblQuestion = new JLabel(Application.questionList.get(
				Application.selectedQuestion).getQuestionNumber());
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Application.selectedQuestion++;
				if (Application.selectedQuestion > Application.questionList
						.size() - 1) {
					Application.selectedQuestion = 0;
				}
				mainPanel.update();
			}
		});
		add(btnPrevious);
		add(lblQuestion);
		add(btnNext);
	}
}
