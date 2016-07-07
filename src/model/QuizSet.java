package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the model for a QuizSet. Contains a List of Qwa objects.
 */

public class QuizSet {
    private List<Qwa> qwaList;


    public QuizSet(List<Qwa> qwaList) {

        this.qwaList = new ArrayList<>();
        this.qwaList = qwaList;
    }

    public QuizSet() {
        qwaList = new ArrayList<>();
    }

    public List<Qwa> getQwaList() {
        return qwaList;
    }


   public void setQwaList(List<Qwa> qwaList) {
      this.qwaList = qwaList;
    }


    public void addQwa(Qwa qwa) {
        qwaList.add(qwa);
    }
}
