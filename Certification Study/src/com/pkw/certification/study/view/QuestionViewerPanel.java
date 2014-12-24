package com.pkw.certification.study.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.pkw.certification.study.ClassMain;

public class QuestionViewerPanel extends JPanel {

	private static final long serialVersionUID = 4403470480656476440L;
	
	public static List<JRadioButton> jrbList = new ArrayList<JRadioButton>();

	public QuestionViewerPanel() {

		updatePanel();
		
	}
	
	public void updatePanel(){
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel lblQuestion = new JLabel(ClassMain.questionList.get(ClassMain.selectedQuestion).getQuestion());

		add(lblQuestion);

		ButtonGroup group = new ButtonGroup();

		for (int i = 0; i < ClassMain.questionList.get(ClassMain.selectedQuestion).getPossibleAnswers().size(); i++) {

			jrbList.add(new JRadioButton(ClassMain.questionList.get(ClassMain.selectedQuestion).getPossibleAnswers().get(i)));

			group.add(jrbList.get(i));

			add(jrbList.get(i));

		}
		
		JButton btnCheckAnswer = new JButton("Check Answer");
		
		btnCheckAnswer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( somethingSelected() ){
					
					if ( isCorrect() ){
						
						jrbList.get( getSelectedIndex() ).setText(jrbList.get( getSelectedIndex() ).getText() + " Correct!");
						
					}
					else
					{
						
						jrbList.get( getSelectedIndex() ).setText(jrbList.get( getSelectedIndex() ).getText() + " ): Incorrect ):");
						
					}
					
				}
				
			}
		});
		
		add(btnCheckAnswer);
		
	}
	
	public boolean somethingSelected(){
		
		boolean returnValue = false;
		
		int selectedAnswer = -1;
		
		for (int i = 0; i < jrbList.size(); i++){
			
			if ( jrbList.get(i).isSelected() )
			{
				
				selectedAnswer = i;
				
			}
			
		}
		
		if (selectedAnswer > -1){
			
			returnValue = true;
			
		}
		
		return returnValue;
		
	}
	
	public boolean isCorrect(){
		
		boolean returnValue = false;
		
		int selectedAnswer = -1;
		
		for (int i = 0; i < jrbList.size(); i++){
			
			if ( jrbList.get(i).isSelected() )
			{
				
				selectedAnswer = i;
				
			}
			
		}
		
		if (jrbList.get(selectedAnswer).getText().charAt(0) == ClassMain.questionList.get(ClassMain.selectedQuestion).getCorrectAnswer().charAt(8)){
			
			returnValue = true;
			
		}
		
		return returnValue;
		
	}
	
	public int getSelectedIndex(){
		
		int returnValue = -1;
		
		for (int i = 0; i < jrbList.size(); i++){
			
			if ( jrbList.get(i).isSelected() )
			{
				
				returnValue = i;
				
			}
			
		}
		
		return returnValue;
		
	}
	
}
