import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class ClassMain {

	public static int selectedQuestion = 0;

	public static List<Question> questionList = new ArrayList<Question>();;

	public static void main(String args[]) {

		String file = "C:\\Users\\Tritan\\Desktop\\input.txt";

		QuestionImporter.importFile(file);

		for (int i = 0; i < questionList.size(); i++) {

			System.out.println("questionList(" + i + ") : ");

			System.out.println("Question Number: " + questionList.get(i).getQuestionNumber());
			System.out.println("Question: " + questionList.get(i).getQuestion());

			for (int j = 0; j < questionList.get(i).getPossibleAnswers().size(); j++) {

				System.out.println("Possible Answers: " + questionList.get(i).getPossibleAnswers().get(j));

			}

			System.out.println("Correct Asnwer: " + questionList.get(i).getCorrectAnswer());

			System.out.println("");

		}

		JFrame frame = new JFrame("Flash Card Study");
		frame.setContentPane(new FullViewPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);

	}

}
