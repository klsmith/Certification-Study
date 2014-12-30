package com.pkw.certification.study.refactored.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.pkw.certification.study.refactored.model.Problem;
import com.pkw.certification.study.refactored.model.Selector;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = -8714212184565466822L;

	public static ControlPanel with(Selector<Problem> selector) {
		return new ControlPanel(selector);
	}

	private ControlPanel(final Selector<Problem> selector) {
		JButton previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selector.moveToPrevious();
			}
		});
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selector.moveToNext();
			}
		});
		add(previous);
		add(next);
	}
}
