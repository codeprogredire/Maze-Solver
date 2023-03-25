import javax.swing.*;
import java.awt.*;
import java.util.*;
public class MAZE_SOLVER_PROJECT extends JFrame {
    private int maze[][]={
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,0,0,1,1,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };


    //stores co-ordinates of the points which will lead to destination
     ArrayList<Integer>path = new ArrayList<>();

     public MAZE_SOLVER_PROJECT(){
         setTitle("Maze Solver");
         setSize(640,720);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         DepthFirst.searchPath(maze,1,1,path);
         System.out.println(path);
     }

     @Override
     public void paint(Graphics g){
         //push the origin of the grphics to co-ordinates specified as parameter
         g.translate(100,100);
         for(int i=0;i<maze.length;i++){
             for(int j=0;j<maze[0].length;j++){
                 Color color;
                 switch(maze[i][j]){
                     case 1: color = Color.BLACK; break;
                     case 9: color=Color.RED; break;
                     default: color=Color.WHITE; break;
                 }
                 g.setColor(color);

                 //rectangles in the grid will be filled with these colors
                 g.fillRect(30*j,30*i,30,30);

                 //to create boundaries around each cell
                 g.setColor(Color.RED);
                 g.drawRect(30*j,30*i,30,30);
             }
         }

         //i+=2 because in path, we are having x as well as y co-ordinates.
         //next co-rdinate lies +2 ahead of the current co-ordinate
         for(int i=0;i<path.size();i+=2){
             g.setColor(Color.GREEN);
             //decrease the width and height of the rectangle so that we can see
             //the rectangles through which it is passing
             g.fillRect(30*path.get(i),30*path.get(i+1),20,20);


         }
     }

     public static void main(String args[]){
         MAZE_SOLVER_PROJECT view = new MAZE_SOLVER_PROJECT();
         view.setVisible(true);
     }

}
