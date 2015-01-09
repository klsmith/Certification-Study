package com.pkw.certification.study.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.pkw.certification.study.model.Problem;
import com.pkw.certification.study.model.Selector;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = -8714212184565466822L;

	public static ControlPanel createFor(Selector<Problem> selector) {
		return new ControlPanel().setSelector(selector);
	}

	public static ControlPanel create() {
		return new ControlPanel();
	}

	private ControlPanel() {
	}

	public ControlPanel setSelector(final Selector<Problem> selector) {
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
		return this;
	}
}
