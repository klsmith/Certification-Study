package com.pkw.certification.study.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pkw.certification.study.model.Problem;
import com.pkw.certification.study.model.Selector;

public class BuilderMainPanel extends AbstractMainPanel {
	private static final long serialVersionUID = -2976171637210318816L;

	public static BuilderMainPanel createIn(JFrame frame) {
		return new BuilderMainPanel(frame);
	}

	private BuilderMainPanel(JFrame frame) {
		super(frame);
		swapQuestionPanel(new JPanel());
		add(ControlPanel.createFor(new Selector<Problem>(
				new ArrayList<Problem>())), BorderLayout.SOUTH);
	}
}
