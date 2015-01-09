package com.pkw.certification.study.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public abstract class AbstractMainPanel extends JPanel {
	private static final long serialVersionUID = 2476070953363727360L;

	protected JFrame frame;
	protected BorderLayout borderLayout;

	protected AbstractMainPanel(JFrame frame) {
		this.frame = frame;
		this.borderLayout = new BorderLayout();
		setLayout(borderLayout);
	}

	public void update() {
		frame.revalidate();
		frame.repaint();
	}

	protected void swapPanelInConstraintWithPanel(
			String borderLayoutConstraint, JPanel panel) {
		Component component = borderLayout
				.getLayoutComponent(borderLayoutConstraint);
		if (component != null) {
			remove(component);
		}
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(352, 256));
		add(scrollPane, borderLayoutConstraint);
	}
}
