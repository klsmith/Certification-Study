package com.pkw.certification.study.view;

import javax.swing.JFrame;

public class BuilderMainPanel extends AbstractMainPanel {
	private static final long serialVersionUID = -2976171637210318816L;

	public static BuilderMainPanel createIn(JFrame frame) {
		return new BuilderMainPanel(frame);
	}

	private BuilderMainPanel(JFrame frame) {
		super(frame);
	}
}
