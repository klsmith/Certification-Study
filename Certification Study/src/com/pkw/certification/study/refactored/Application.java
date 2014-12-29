package com.pkw.certification.study.refactored;

import javax.swing.JFrame;

import com.pkw.certification.study.refactored.view.MainPanel;

public class Application {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(MainPanel.create());
		frame.setVisible(true);
		frame.pack();
	}
}
