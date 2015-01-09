package com.pkw.certification.study;

import javax.swing.JFrame;

import com.pkw.certification.study.view.MainQuizPanel;

public class QuizApplication {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Quiz App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(MainQuizPanel.createIn(frame));
		frame.setVisible(true);
		frame.pack();
	}
}
