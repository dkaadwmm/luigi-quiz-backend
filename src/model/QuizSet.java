package model;

import java.util.ArrayList;
import java.util.List;

public class QuizSet {
    private List<Qwa> qwaList;

    public QuizSet() {
        qwaList = new ArrayList<Qwa>();
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
