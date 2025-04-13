import java.util.ArrayList;

import java.util.Collections;

public class Score {
    private ArrayList<String> score = new ArrayList<String>();
    


    public void setScore(String name) {
        score.add(name);
    }

    public ArrayList<String> getScore() {
        return score;
    }

    public int getLength(){
        return score.size();
    }

    public String element(int i){
        return score.get(i);
    }

    public ArrayList<String> top5(){
        ArrayList<String> temp = new ArrayList<>();
        Collections.sort(score);
        for (int i = 0; i < score.size(); i++){
            String emp = "";
            String num = "";
            String nam = "";
            emp = score.get(i);
            nam = emp.replaceAll("[0-9]", "");
            temp.add(i, nam);
            num = emp.replaceAll("[^0-9]", "");
            temp.add(i+1,num);

        }

        return temp;
    }

}
