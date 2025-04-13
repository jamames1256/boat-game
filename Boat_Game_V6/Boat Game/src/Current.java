import java.util.Random;

public class Current{
    private int row;
    private int column;
    String icon;



    public Current(String i){
        this.icon = i;
        Random r = new Random();

    }

    public String getIcon(){
        return icon;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.column = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }

}
