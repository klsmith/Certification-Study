package com.pkw.certification.study;

import javax.swing.JFrame;

import com.pkw.certification.study.view.MainPanel;

public class Application {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Quiz App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(MainPanel.createIn(frame));
		frame.setVisible(true);
		frame.pack();
	}
}
