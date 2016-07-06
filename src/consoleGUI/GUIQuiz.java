package consoleGUI;

/**
 * Created by franziska on 06.07.2016.
 */
public class GUIQuiz {

    public static void printQuestionWithAnswers(model.Qwa qwa){

        System.out.println("\n"+ qwa.getQuestion().getText());

        int maxAnswers = qwa.getAnswers().size();

        for(int i = 0; i < maxAnswers; i++){

        System.out.println(Integer.toString(i + 1) + " - " +  qwa.getAnswers().get(i).getText());

        }

    }

    public static void getAndCheckAnswer(int correctAnswer, String correctAnswerText){

        int userInput = GUIMenu.readIntfromConsole();

        if(userInput == correctAnswer){
            System.out.println("\nGlückwunsch! Das war die richtige Antwort!");
        }
        else{
            System.out.println("\nLeider falsch! Die richtige Antwort wäre gewesen: " + correctAnswerText);
        }
    }
}
