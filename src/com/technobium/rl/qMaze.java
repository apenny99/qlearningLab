/**
 * QMaze
 * Generates a maze with an end square and some blocked squares
 * Author: August Penny
 * Collaborator(s): The names of anyone you collaborated with here
 * Collaboration: Describe the collaboration that took place
 * Date: 4/20/22
 **/

package com.technobium.rl;
import java.io.IOException;
import java.util.Random;
import java.io.FileWriter;

public class qMaze {
    //random betweem 0 and 2. if its 0 or 1 then space is clear and if it is 2 then it is blocked
    private Random r;
    private int width;
    private int height;
    private double chanceBlocked=.25;

    public qMaze(){
        width=5;
        height=5;
        r=new Random();
    }
    public void makeMaze() throws IOException {
        int endSquare=r.nextInt(5);//random goal square

        String maze="";
        int indexesAssessed=0;

        for(int i=0;i<25;i++){//goes through and sets each block to blocked or open and sets the goal block
            if (indexesAssessed%5==0 && indexesAssessed !=0){
                maze=maze+"\n";
            }

            double fOrB=r.nextDouble();
            if(i==endSquare) {
                maze += 'F';
                indexesAssessed++;
            }else if(fOrB<=chanceBlocked){
                maze+='X';
                indexesAssessed++;
            } else if(fOrB>chanceBlocked){
                maze+='0';
                indexesAssessed++;
            }

            try{ //puts the maze in its own file
                FileWriter f = new FileWriter("src/maze.txt");
                f.write(maze);
                f.close();
            } catch (IOException e) {
                System.out.println("Could not be written to file");
                e.printStackTrace();

            }

        }

    }


}
