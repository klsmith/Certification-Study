package com.pkw.certification.study;

import javax.swing.JFrame;

import com.pkw.certification.study.view.BuilderMainPanel;

public class BuilderApplication {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Quiz Builder Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(BuilderMainPanel.createIn(frame));
		frame.setVisible(true);
		frame.pack();
	}
}
