import java.io.File;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Scoreboard extends Score{
	
	public ArrayList<String> top5(ArrayList<String> score){
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
	
	public static void main(String[] args) throws IOException {
	
		Scoreboard sb = new Scoreboard(); 
		String[] myStringArray = {"a", "b", "c"};

	File path = new File("C:\\Users\\Abdoulahi Said Omar\\Downloads\\Boat_Game_V6\\score\\score.txt");
	FileWriter wr = new FileWriter(path);
	wr.write("Name:\n");

	
	for(String name : n) {
		wr.write("\n" + name);
	}
	
	/*wr.write("Name\n" + null);
	wr.write("Score\n" + "0" + "0" + "0" + "0" + "0");
	wr.close();*/
}
}
