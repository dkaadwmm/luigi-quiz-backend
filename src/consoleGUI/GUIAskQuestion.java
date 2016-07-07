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

    private List<Integer> userInput;
    private Qwa currentQwa;

    private List<Integer> correctAnswerListIndex;


    GUIAskQuestion(Qwa qwa){
        currentQwa = qwa;
        userInput = new ArrayList<Integer>();
    }

    public Qwa getCurrentQwa() {
        return currentQwa;
    }

    public void setCurrentQwa(Qwa currentQwa) {
        this.currentQwa = currentQwa;
    }

    public void askAQuestion() throws UserWantsToQuitException {

        printQuestionWithAnswers();
        getUserInput();
        if(!checkIfAnswerIsRight()) {printCorrectAnswer();}
        else {
            System.out.println("Glückwunsch! Das war richtig!");}

    }

    private void printQuestionWithAnswers(){
        
        System.out.println("\n"+ currentQwa.getQuestion().getText());

        int maxAnswers = currentQwa.getAnswers().size();

        //reset counters for correct answers
        correctAnswerListIndex = new ArrayList<Integer>();

        for(int i = 0; i < maxAnswers; i++){

            Answer answer = currentQwa.getAnswers().get(i);
            if(answer.isCorrect()) {
                correctAnswerListIndex.add(i);
            }
            System.out.println(Integer.toString(i + 1) + " - " +  answer.getText());

        }

    }

    private void getUserInput() throws UserWantsToQuitException {

        userInput = readAnswerfromConsole();
    }

    private boolean checkIfAnswerIsRight(){

        boolean answerIsCorrect = true;

        List<Answer> answers = currentQwa.getAnswers();
        int maxSize = answers.size();


        for (int i : userInput)
        {
            if(i > maxSize)
            {
                answerIsCorrect = false;
                break;
            }

            if(!answers.get(i - 1).isCorrect())
            {
                answerIsCorrect = false;
                break;
            }
        }
        
        return answerIsCorrect;
    }

    private void printCorrectAnswer() {

        System.out.println("\nLeider falsch!");
        int maxSize = currentQwa.getAnswers().size();

        String entryText = "\nDie richtige Antwort ist:";
        String correctAnswers = "";
        int counter = 0;

        for(int i = 0; i < maxSize; i++)
        {
            if (currentQwa.getAnswers().get(i).isCorrect()){
                correctAnswers += "\n" + currentQwa.getAnswers().get(i).getText() ;
                counter++;
            }
        }

        if(counter > 1) entryText = "\nDie richtigen Antworten sind:";

        System.out.println(entryText + correctAnswers);

    }

    private static List<Integer> readAnswerfromConsole() throws UserWantsToQuitException {

        List <Integer> userInput = new ArrayList<Integer>();

        System.out.print("\nBitte Zahl eingeben: \n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        userInput = splitUserInput(input);

        return userInput;
    }

    private static List<Integer> splitUserInput(String input) throws UserWantsToQuitException {
        String[] strArray = input.split("[ ,;]+");

        List<Integer> integers = new ArrayList<Integer>();

        for(int i = 0; i < strArray.length; i++) {
            integers.add(Integer.parseInt(strArray[i]));
        }

        if(integers.contains(0)) {
            throw new UserWantsToQuitException();
        }

        return integers;
    }


}
