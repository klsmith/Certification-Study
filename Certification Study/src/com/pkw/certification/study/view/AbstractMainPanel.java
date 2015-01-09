package com.pkw.certification.study.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.pkw.certification.study.model.Problem;
import com.pkw.certification.study.model.Selector;

public abstract class AbstractMainPanel extends JPanel {
	private static final long serialVersionUID = 2476070953363727360L;

	protected JFrame frame;
	protected BorderLayout borderLayout;
	protected Selector<Problem> selector;
	protected ControlPanel controlPanel;
	protected JScrollPane scrollPane;

	protected AbstractMainPanel(JFrame frame) {
		this.frame = frame;
		this.borderLayout = new BorderLayout();
		setLayout(borderLayout);
		controlPanel = ControlPanel.create();
		add(controlPanel, BorderLayout.SOUTH);
		scrollPane = new JScrollPane(//
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,//
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(352, 256));
		add(scrollPane, BorderLayout.NORTH);
	}

	public void updateControlPanelSelector() {
		controlPanel.setSelector(selector);
	}

	public void update() {
		frame.revalidate();
		frame.repaint();
	}

	protected void swapQuestionPanel(JPanel panel) {
		scrollPane.setViewportView(panel);
	}
}
