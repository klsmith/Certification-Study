package com.pkw.certification.study.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pkw.certification.study.ClassMain;

public abstract class QuestionImporter {

	static String tmpQuestionNumber;
	static String tmpQuestion;
	static String tmpCorrectAnswer;
	static List<String> tmpPossibleAnswers = new ArrayList<String>();

	public static void importFile(String file) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				if (isQuestionNumber(line) == true) {
					tmpQuestionNumber = line;
				} else if (isPossibleAnswer(line) == true) {
					tmpPossibleAnswers.add(line);
				} else if (isExplanation(line) == true) {
					ClassMain.questionList.add(new Question(tmpQuestionNumber,
							tmpQuestion, tmpCorrectAnswer, tmpPossibleAnswers));
					tmpPossibleAnswers.clear();
				} else if (isCorrectAnswer(line) == true) {
					tmpCorrectAnswer = line;
				} else {
					tmpQuestion = line;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static boolean isPossibleAnswer(String line) {
		boolean returnValue = false;
		if (line.charAt(1) == '.') {
			returnValue = true;
		}
		return returnValue;
	}

	static boolean isCorrectAnswer(String line) {
		boolean returnValue = true;
		for (int i = 0; i < "Answer".length(); i++) {
			if (line.charAt(i) != "Answer".charAt(i)) {
				return false;
			}
		}
		return returnValue;
	}

	static boolean isExplanation(String line) {
		boolean returnValue = true;
		for (int i = 0; i < "Explanation".length(); i++) {
			if (line.charAt(i) != "Explanation".charAt(i)) {
				return false;
			}
		}
		return returnValue;
	}

	static boolean isQuestionNumber(String line) {
		boolean returnValue = true;
		for (int i = 0; i < "QUESTION".length(); i++) {
			if (line.charAt(i) != "QUESTION".charAt(i)) {
				return false;
			}
		}
		return returnValue;
	}
}
