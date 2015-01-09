package com.pkw.certification.study.old.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pkw.certification.study.old.ClassMain;

public class QuestionControllerPanel extends JPanel {
	private static final long serialVersionUID = -8992276253798344431L;

	public static QuestionControllerPanel createIn(FullViewPanel mainPanel) {
		return new QuestionControllerPanel(mainPanel);
	}

	private QuestionControllerPanel(final FullViewPanel fullViewPanel) {
		setLayout(new FlowLayout());
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClassMain.selectedQuestion--;
				if (isAtStartOfList()) {
					wrapToEnd();
				}
				fullViewPanel.update();
			}

			private boolean isAtStartOfList() {
				return ClassMain.selectedQuestion < 0;
			}

			private void wrapToEnd() {
				ClassMain.selectedQuestion = ClassMain.questionList.size() - 1;
			}
		});
		JLabel lblQuestion = new JLabel(ClassMain.questionList.get(
				ClassMain.selectedQuestion).getQuestionNumber());
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClassMain.selectedQuestion++;
				if (isAtEndOfList()) {
					wrapToStart();
				}
				fullViewPanel.update();
			}

			private void wrapToStart() {
				ClassMain.selectedQuestion = 0;
			}

			private boolean isAtEndOfList() {
				return ClassMain.selectedQuestion > ClassMain.questionList
						.size() - 1;
			}
		});
		add(btnPrevious);
		add(lblQuestion);
		add(btnNext);
	}
}
