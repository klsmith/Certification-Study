package com.pkw.certification.study.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pkw.certification.study.ClassMain;

public class QuestionControllerPanel extends JPanel {
	private static final long serialVersionUID = -8992276253798344431L;

	public QuestionControllerPanel() {
		setLayout(new FlowLayout());
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClassMain.selectedQuestion--;
				if (ClassMain.selectedQuestion < 0) {
					ClassMain.selectedQuestion = ClassMain.questionList.size() - 1;
				}
				FullViewPanel.questionUpdate();
			}
		});
		JLabel lblQuestion = new JLabel(ClassMain.questionList.get(
				ClassMain.selectedQuestion).getQuestionNumber());
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClassMain.selectedQuestion++;
				if (ClassMain.selectedQuestion > ClassMain.questionList.size() - 1) {
					ClassMain.selectedQuestion = 0;
				}
				FullViewPanel.questionUpdate();
			}
		});
		add(btnPrevious);
		add(lblQuestion);
		add(btnNext);
	}
}
