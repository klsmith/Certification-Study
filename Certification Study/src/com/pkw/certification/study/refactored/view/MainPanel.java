package com.pkw.certification.study.refactored.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.pkw.certification.study.refactored.model.Problem;
import com.pkw.certification.study.refactored.model.ProblemImporter;
import com.pkw.certification.study.refactored.model.Selector;
import com.pkw.certification.study.refactored.model.Selector.MoveListener;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 934364967952571204L;

	private JFrame frame;
	private BorderLayout layout;
	private Selector<Problem> selector;

	public static MainPanel createIn(JFrame frame) {
		return new MainPanel(frame);
	}

	private MainPanel(JFrame frame) {
		this.frame = frame;
		layout = new BorderLayout();
		setLayout(layout);
		selector = ProblemImporter//
				.createWithPath("/com/pkw/certification/study/assets/input.txt")//
				.importProblems().selector();
		selector.addMoveListener(new MoveListener() {
			@Override
			public void onMove() {
				update();
			}
		});
		update();
		add(ControlPanel.with(selector), BorderLayout.SOUTH);
	}

	public void update() {
		swapNorthPanel(selector.selected().panel());
		frame.revalidate();
		frame.repaint();
	}

	private void swapNorthPanel(JPanel panel) {
		Component component = layout.getLayoutComponent(BorderLayout.NORTH);
		if (component != null) {
			remove(layout.getLayoutComponent(BorderLayout.NORTH));
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(panel);
		scrollPane.setPreferredSize(new Dimension(352, 256));
		add(scrollPane, BorderLayout.NORTH);
	}

}
