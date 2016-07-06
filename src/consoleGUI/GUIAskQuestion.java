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


    GUIAskQuestion(Qwa qwa){
        currentQwa = qwa;

    }

    public Qwa getCurrentQwa() {
        return currentQwa;
    }

    public void setCurrentQwa(Qwa currentQwa) {
        this.currentQwa = currentQwa;

    }

    public void startAskingQuestion() throws  UserWantsToQuitException{

        System.out.println("\nHinweis: Mit der Eingabe 0 können Sie das Quiz jederzeit abbrechen!\n");
        printQuestionWithAnswers();
        getAndCheckAnswer();

    }

    //prints Question and saves the right answers for future usage
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

    private void getAndCheckAnswer() throws UserWantsToQuitException {

        List<Integer> userInput = readAnswerfromConsole();

        String missingAnswers = "";
        String wrongAnswers = "";

        for(int i = 0; i < correctAnswerListIndex.size(); i++){

            if(userInput.contains(correctAnswerListIndex.get(i) + 1)) continue;
            else missingAnswers += currentQwa.getAnswers().get(correctAnswerListIndex.get(i)).getText() + "\n";
        }


        for(int i : userInput)
        {

            if(correctAnswerListIndex.contains(i)) continue;
            else {

                String errorString = "";
                if (i > currentQwa.getAnswers().size()) errorString = Integer.toString(i);
                else {errorString = currentQwa.getAnswers().get(i - 1).getText();}

                wrongAnswers += errorString + "\n";
            }
        }


        if(missingAnswers == "" && wrongAnswers == ""){
            System.out.println("\nGlückwunsch! Das war richtig!");
        }
        else{

            System.out.println("\nLeider falsch!");

            /*System.out.println(testString);
            System.out.println(correctAnswerListIndex);
            System.out.println(missingAnswers);*/


            if(missingAnswers != "") {
                System.out.println("Fehlende richtige Antwort(en): " + "\n" + missingAnswers);
            }

            if(missingAnswers != "") {
                System.out.println("Falsche Antwort(en): " + "\n" + wrongAnswers);
            }
        }
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
