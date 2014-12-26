package com.pkw.certification.study;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.pkw.certification.study.model.Question;
import com.pkw.certification.study.model.QuestionImporter;
import com.pkw.certification.study.view.FullViewPanel;

public class ClassMain {

	public static int selectedQuestion = 0;
	public static List<Question> questionList = new ArrayList<Question>();;

	public static void main(String args[]) {
		final String FILE = "assets/input.txt";
		QuestionImporter.importFile(FILE);
		for (int i = 0; i < questionList.size(); i++) {
			System.out.println("questionList(" + i + ") : ");
			System.out.println(questionList.get(i));
		}
		JFrame frame = new JFrame("Certification Study");
		frame.setContentPane(new FullViewPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.pack();
	}
}
