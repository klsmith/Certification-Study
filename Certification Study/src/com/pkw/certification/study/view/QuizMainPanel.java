package com.pkw.certification.study.view;

import javax.swing.JFrame;

import com.pkw.certification.study.model.ProblemImporter;
import com.pkw.certification.study.model.Selector.OnSelectListener;

public class QuizMainPanel extends AbstractMainPanel {
	private static final long serialVersionUID = 934364967952571204L;

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
		updateControlPanelSelector();
		update();

	}

	@Override
	public void update() {
		swapQuestionPanel(selector.selected().panel());
		super.update();
	}
}
