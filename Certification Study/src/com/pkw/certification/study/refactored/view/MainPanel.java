package com.pkw.certification.study.refactored.view;

import javax.swing.JPanel;

import com.pkw.certification.study.refactored.model.ProblemImporter;
import com.pkw.certification.study.refactored.model.ProblemList;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 934364967952571204L;

	private ProblemList problemList;

	public static MainPanel create() {
		return new MainPanel();
	}

	private MainPanel() {
		problemList = ProblemImporter//
				.createWithPath("assets/input.txt")//
				.importProblems();

	}

}
