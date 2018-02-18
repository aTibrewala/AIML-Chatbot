package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KnowledgeBase {
	static String path = "F:\\AIML Bot\\Input Data\\bots\\super\\aiml\\client_profile.aiml";
	static ArrayList<String> questions = new ArrayList<String>();
	static ArrayList<String> answers = new ArrayList<String>();

	BufferedReader br = null;
	FileReader fr = null;
	{
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String currentLine;
			String initialString = "<category><pattern>";
			String initialAnswer = "<template>";

			while ((currentLine = br.readLine()) != null) {
				if (currentLine.startsWith(initialString)) {
					String questionsSubstring = null;
					int index = currentLine.indexOf("<", initialString.length());
					questionsSubstring = currentLine.substring(initialString.length(), index);
					String answerSubstring = null;
					questions.add(questionsSubstring);
				} else if (currentLine.startsWith(initialAnswer)) {
					String answerSubstring = null;
					int index = currentLine.indexOf("<", initialAnswer.length());
					answerSubstring = currentLine.substring(initialAnswer.length());
					if (answerSubstring == null) {
						answers.add(null);
					} else {
						answers.add(answerSubstring);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void reply(String question) {
		String answer = "Please check your question.";
		for (int counter = 0; counter < questions.size(); counter++) {
			if (question.equalsIgnoreCase(questions.get(counter))) {
				answer = answers.get(counter);
				break;
			} 
		}
		System.out.println("Bot: "+answer);
	}

}
