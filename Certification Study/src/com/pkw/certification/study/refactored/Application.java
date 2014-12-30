package com.pkw.certification.study.refactored;

import javax.swing.JFrame;

import com.pkw.certification.study.refactored.view.MainPanel;

public class Application {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(MainPanel.createIn(frame));
		frame.setVisible(true);
		frame.pack();
	}
}
