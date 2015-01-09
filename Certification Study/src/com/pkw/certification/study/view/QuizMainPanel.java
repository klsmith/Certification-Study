package com.pkw.certification.study.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pkw.certification.study.model.Problem;
import com.pkw.certification.study.model.ProblemImporter;
import com.pkw.certification.study.model.Selector;
import com.pkw.certification.study.model.Selector.OnSelectListener;

public class QuizMainPanel extends AbstractMainPanel {
	private static final long serialVersionUID = 934364967952571204L;

	private Selector<Problem> selector;

	public static QuizMainPanel createIn(JFrame frame) {
		return new QuizMainPanel(frame);
	}

	private QuizMainPanel(JFrame frame) {
		super(frame);
		selector = ProblemImporter//
				.createWithPath("/com/pkw/certification/study/assets/input.txt")//
				.importProblems()//
				.getSelector();
		selector.addOnSelectListener(new OnSelectListener() {
			@Override
			public void onSelect() {
				update();
			}
		});
		update();
		add(ControlPanel.with(selector), BorderLayout.SOUTH);
	}

	@Override
	public void update() {
		swapNorthPanelWith(selector.selected().panel());
		super.update();
	}

	private void swapNorthPanelWith(JPanel panel) {
		swapPanelInConstraintWithPanel(BorderLayout.NORTH, selector.selected()
				.panel());
	}
}
