import java.util.Random;

public class River {
    private int row = 4;
    private int col = 101;
    private String[][]riverArr = new String[row][col];


//Creates the River
    public River()
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                riverArr[i][col-1] = "-";
                riverArr[i][0]  = "-";
                riverArr[row - 1][j]  = "-";
                riverArr[0][j]  = "-";
            }
        }
        riverArr[1][100] = "E";
        riverArr[2][100] = "E";
    }

    public void clearPreviousPosition(int row, int col)
    {
        riverArr[row][col] = " ";
    }

    //Takes the player's position and places their Icon on the river
    public void addPlayersToRiver(Player player)
    {
        riverArr[player.getRow()][player.getCol()] = player.getIcon();
    }

    //Takes the Trap's position and places their Icon on the river
    public void addTrapsToRiver(Trap traps){
        riverArr[traps.getRow()][traps.getCol()] = traps.getIcon();
    }

    //Creates random number of traps and adds them to river
    public Trap trap1(){
        Random r = new Random();
        int ran = 1 + r.nextInt(5);

        Trap t = new Trap("T");

        for(int i = 0; i < ran; i++){
            int colran = 2 + r.nextInt(98);
            if (riverArr[1][colran] == null){
                t.setPosition(1, colran);
                addTrapsToRiver(t);
            }
            else {
                continue;
            }
        }
        return t;
    }
    public Trap trap2(){
        Random r = new Random();
        int ran = 1 + r.nextInt(5);

        Trap t = new Trap("T");

        for(int i = 0; i < ran; i++){
            int colran = 2 + r.nextInt(98);
            if (riverArr[2][colran] == null){
                t.setPosition(2, colran);
                addTrapsToRiver(t);
            }
            else {
                continue;
            }

        }
        return t;
    }

    //Creates random number of currents and adds them to river
    public Current current1(){
        Random r = new Random();
        int ran = 1 + r.nextInt(5);

        Current c = new Current("C");

        for(int i = 0; i < ran; i++){
            int colran = 2 + r.nextInt(98);
            if (riverArr[1][colran] == null){
                c.setPosition(1, colran);
                addCurrentsToRiver(c);
            }
            else {
                continue;
            }
        }
        return c;
    }
    public Current current2(){
        Random r = new Random();
        int ran = 1 + r.nextInt(5);

        Current c = new Current("C");

        for(int i = 0; i < ran; i++){
            int colran = 2 + r.nextInt(98);
            if (riverArr[2][colran] == null){
                c.setPosition(2, colran);
                addCurrentsToRiver(c);
            }
            else {
                continue;
            }
        }
        return c;
    }

    //Creates a rocket object and adds it to river
    public Rocket rock1(){
        Random r = new Random();

        Rocket rocket = new Rocket("R");
        int colran = 20 + r.nextInt(30);
        rocket.setPosition(1, colran);
        addRocketToRiver(rocket);
        return rocket;
    }
    public Rocket rock2(){
        Random r = new Random();

        Rocket rocket = new Rocket("R");
        int colran = 20 + r.nextInt(30);
        rocket.setPosition(2, colran);
        addRocketToRiver(rocket);
        return rocket;
    }


    //Takes the Current's position and places their Icon on the river
    public void addCurrentsToRiver(Current currents){
        riverArr[currents.getRow()][currents.getCol()] = currents.getIcon();
    }

    //Takes the Rocket's position and places their Icon on the river
    public void addRocketToRiver(Rocket rocket){
        riverArr[rocket.getRow()][rocket.getCol()] = rocket.getIcon();
    }

    //Checks for clash between player and river objects
    public int clash(int row, int col, int move, int col2){
        Random r = new Random();
        int movement = 0;
        if(col + move >= 100)
        {
            System.out.println("You reached the end!");
            return col + move;
        }
        else
        {
            if (riverArr[row][col + move] != null){
                if (riverArr[row][col + move] == "T"){
                    movement = -1 + r.nextInt(10);
                    col += move;
                    col += movement;
                    System.out.println("You hit a Trap!");
                    System.out.println("You move back: -" + movement);
                    return col;
                }
                if (riverArr[row][col + move] == "C"){
                    movement = 1 + r.nextInt(10);
                    col += move;
                    col += movement;
                    System.out.println("You hit a Current!");
                    System.out.println("You move forward: " + movement);
                    return col;
                }
                if (riverArr[row][col + move] == "R"){
                    movement = -1 + r.nextInt(10);
                    col2 -= movement;
                    System.out.println("You hit a Rocket!");
                    System.out.println("You move your opponenet back: -" + movement);
                    return col & col2;
                }
                if (riverArr[row][col + move] == "E"){
                    col += move;
                    System.out.println("You reached the end!");
                    return col;
                }
            }
            else
            col += move;
            return col;
        }
        
    }


    @Override
    public String toString()
    {
        StringBuilder riverPrint = new StringBuilder();
        for (int i = 0; i < riverArr.length; i++) {
            for (int j = 0; j < riverArr[i].length; j++) {
                if (riverArr[i][j] == null) {
                    riverPrint.append(" ");
                }
                else {
                    riverPrint.append(riverArr[i][j]);
                }
            }
            riverPrint.append('\n');
        }
        return riverPrint.toString();
    }

}
