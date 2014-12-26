package com.pkw.certification.study.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FullViewPanel extends JPanel {
	private static final long serialVersionUID = -5403092996763971386L;

	private QuestionViewerPanel questionViewerPanel = new QuestionViewerPanel();

	public static FullViewPanel create() {
		return new FullViewPanel();
	}

	private FullViewPanel() {
		questionViewerPanel = new QuestionViewerPanel();
		setup();
		configurePanels();
	}

	private void setup() {
		final int PADDING = 12;
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
	}

	private void configurePanels() {
		add(questionViewerPanel, BorderLayout.NORTH);
		add(QuestionControllerPanel.createIn(this), BorderLayout.SOUTH);
	}

	public void update() {
		questionViewerPanel.updatePanel();
	}

}
