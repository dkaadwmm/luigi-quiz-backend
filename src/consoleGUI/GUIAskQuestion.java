package consoleGUI;

import model.Answer;
import model.Qwa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by franziska on 06.07.2016.
 */
public class GUIAskQuestion {

    private Qwa currentQwa;
    private List<Integer> correctAnswerListIndex;
    private List<String> correctAnswerText;

    GUIAskQuestion(Qwa qwa){
        currentQwa = qwa;


    }

    public Qwa getCurrentQwa() {
        return currentQwa;
    }

    public void setCurrentQwa(Qwa currentQwa) {
        this.currentQwa = currentQwa;

    }

    public void startAskingQuestion(){

        printQuestionWithAnswers();
        getAndCheckAnswer();

    }

    //prints Question and saves the right answers for future usage
    private void printQuestionWithAnswers(){

        System.out.println("\n"+ currentQwa.getQuestion().getText());

        int maxAnswers = currentQwa.getAnswers().size();

        //reset counters for correct answers
        correctAnswerListIndex = new ArrayList<Integer>();
        correctAnswerText = new ArrayList<String>();

        for(int i = 0; i < maxAnswers; i++){

            Answer answer = currentQwa.getAnswers().get(i);
            if(answer.isCorrect()) {
                correctAnswerListIndex.add(i);
                correctAnswerText.add(answer.getText());
            }
            System.out.println(Integer.toString(i + 1) + " - " +  answer.getText());

        }

    }


    private void getAndCheckAnswer(){

        List<Integer> userInput = readAnswerfromConsole();

        List<String> missingAnswers = new ArrayList<String>();

        for(int i = 0; i < userInput.size(); i++){


            if(userInput.contains(correctAnswerListIndex.get(i) + 1)) continue;
            else missingAnswers.add(currentQwa.getAnswers().get(i).getText());
        }

        if(userInput == correctAnswerListIndex){
            System.out.println("\nGlückwunsch! Das war die richtige Antwort!");
        }
        else{
            System.out.println("\nLeider falsch! Die richtige Antwort wäre gewesen: " + correctAnswerText);
        }
    }


    private static List<Integer> readAnswerfromConsole() {

        List <Integer> userInput = new ArrayList<Integer>();

        System.out.print("\nBitte Zahl eingeben: \n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        /*

        try {
            i = Integer.parseInt(input);

            System.out.print("\nEingegebene Zahl: " + input);

        } catch (NumberFormatException nfe) {
            System.err.println("Bitte nur Ganzzahlen eingeben!");
        } finally {
            return null;
        }*/

        return userInput;
    }

    public static List<Integer> splitUserInput(String input)
    {
        String[] strArray = input.split(",");

        List<Integer> integers = new ArrayList<Integer>();

        for(int i = 0; i < strArray.length; i++) {
            integers.add(Integer.parseInt(strArray[i]));
        }

        return integers;
    }
}
