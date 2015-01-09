package com.pkw.certification.study.model.tests;

import static com.pkw.certification.study.model.Answer.Letter.A;
import static com.pkw.certification.study.model.Answer.Letter.B;
import static com.pkw.certification.study.model.Answer.Letter.C;
import static com.pkw.certification.study.model.Answer.Letter.D;

import com.pkw.certification.study.model.Answer;
import com.pkw.certification.study.model.Problem;

public enum TestProblem {

	FIRST(Problem.Builder.create()//
			.setNumber(1)//
			.setQuestion("Which of the following is a public IP address?")//
			.addAnswerChoice(Answer.createWith(A, "10.0.0.1"))//
			.addAnswerChoice(Answer.createWith(B, "62.10.1.1"))//
			.addAnswerChoice(Answer.createWith(C, "172.16.0.1"))//
			.addAnswerChoice(Answer.createWith(D, "192.168.1.1"))//
			.addCorrectAnswer(B)//
			.setExplanation("")//
			.build()), //
	SECOND(
			Problem.Builder
					.create()
					.setNumber(2)
					.setQuestion(
							"Which of the following ports MUST be open to connect to a PC using RDP?")//
					.addAnswerChoice(Answer.createWith(A, "21"))//
					.addAnswerChoice(Answer.createWith(B, "80"))//
					.addAnswerChoice(Answer.createWith(C, "443"))//
					.addAnswerChoice(Answer.createWith(D, "3389"))//
					.addCorrectAnswer(D)//
					.setExplanation("")//
					.build()), //
	THIRD(
			Problem.Builder
					.create()
					.setNumber(3)
					.setQuestion(
							"Which of the following is the MAXIMUM transfer speed of USB 2.0?")//
					.addAnswerChoice(Answer.createWith(A, "100 Mbps"))//
					.addAnswerChoice(Answer.createWith(B, "400 Mbps"))//
					.addAnswerChoice(Answer.createWith(C, "420 Mbps"))//
					.addAnswerChoice(Answer.createWith(D, "480 Mbps"))//
					.addCorrectAnswer(D)//
					.setExplanation("")//
					.build()), //
	FOURTH(Problem.Builder
			.create()
			.setNumber(4)
			.setQuestion(
					"Which of the following display connections has 15-pins?")//
			.addAnswerChoice(Answer.createWith(A, "RGB"))//
			.addAnswerChoice(Answer.createWith(B, "VGA"))//
			.addAnswerChoice(Answer.createWith(C, "DVI"))//
			.addAnswerChoice(Answer.createWith(D, "HDMI"))//
			.addCorrectAnswer(B)//
			.setExplanation("")//
			.build());

	private Problem problem;

	private TestProblem(Problem problem) {
		this.problem = problem;
	}

	public Problem problem() {
		return problem;
	}
}
