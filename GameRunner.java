/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author danielchruscielski
 */
import java.util.*;
public class GameRunner {
    /**
     * @param args the command line arguments
     */
    private boolean player1;
    private char mark;
    
    public GameRunner()
    {
        player1 = false;
        mark = 'X';
    }
    public void ticTacToe(int rows, int cols)
    {
        Scanner k = new Scanner(System.in);
        TicBoard test = new TicBoard(rows,cols);
        System.out.print("Would you like to play tic-tac-toe? [y/n] ");
        String answer = k.nextLine().trim();
        if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"))
        {
        while(!test.isWinner() && !test.isFull())
        {   
            if(player1)
                player1 = false;
            else
                player1 = true;
            mark = (player1)?'X':'O';
            System.out.print(test);
            int row = -1;
            int col = -1;   
            do
            {
                if(player1)
                    System.out.print("Player 1: Enter row,column ");
                else
                    System.out.print("Player 2: Enter row,column ");
                String[] input = k.nextLine().trim().split("\\D+");
                boolean rowFilled = false;
                for (String each : input)
                {
                    if(each.matches("\\d+"))
                    {
                       if(rowFilled)
                           col = Integer.parseInt(each)-1;
                       else
                       {    
                           row = Integer.parseInt(each)-1;
                           rowFilled = true;
                       }
                    }         
                }
                if(!test.isValid(row,col))
                    System.out.println("\rNot valid selection. Try again!\n");
            }while(!test.isValid(row,col));
            test.setSpot(row,col,mark);
        }
        System.out.print(test);
        if(test.isWinner()&& player1)
            System.out.println("Player 1 wins!");
        else if(test.isWinner())
            System.out.println("Player 2 wins!");
        else
            System.out.println("Draw!");
        }
        else
            System.out.println("The only winning move is not to play.");
    }
    public void ticTacToe()
    {
        ticTacToe(3,3);
    }
    public void connectFour(int rows, int cols)
    {
        Scanner k = new Scanner(System.in);
        ConBoard test = new ConBoard(rows, cols);
        while(!test.isWinner() && !test.isFull())
        {   
            if(player1)
                player1 = false;
            else
                player1 = true;
            mark = (player1)?'X':'O';
            System.out.print(test);
            int row = -1;
            do
            {
                if(player1)
                    System.out.print("Player 1: Enter row ");
                else
                    System.out.print("Player 2: Enter row ");
                row = k.nextInt()-1;
                if(!test.isValid(row))
                {
                    System.out.println("\rNot valid selection. Try again!\n");
                }
            }while(!test.setSpot(row, mark));
        }
        System.out.print(test);
        if(test.isWinner()&& player1)
            System.out.println("Player 1 wins!");
        else if(test.isWinner())
            System.out.println("Player 2 wins!");
        else
            System.out.println("Draw!");
    }
    public void connectFour()
    {
        connectFour(6,7);
    }
    public void popOut(int rows, int cols)
    {
        Scanner k = new Scanner(System.in);
        PopOutBoard test = new PopOutBoard(rows, cols);
        while(!test.isWinner() && !test.isFull())
        {   
            if(player1)
                player1 = false;
            else
                player1 = true;
            mark = (player1)?'X':'O';
            System.out.print(test);
            int row = -1;
            do
            {
                if(player1)
                    System.out.print("Player 1: Enter row ");
                else
                    System.out.print("Player 2: Enter row ");
                String[] line = k.nextLine().trim().split("\\D+");
                for(String each : line)
                {
                    if(each.matches("\\d+"))
                    {
                        row = Integer.parseInt(each)-1;
                        break;
                    }
                }
                if(test.popValid(row, mark))
                {
                    System.out.println("Do you want to Pop Out? [y/n] ");
                    String input = k.nextLine().trim();
                    if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"))
                    {
                        test.popOutOp(row,mark);
                        break;
                    }
                    else if(test.isValid(row))
                    {
                        test.setSpot(row, mark);
                        break;
                    }
                }
                else if(test.isValid(row))
                {
                    test.setSpot(row,mark);
                    break;
                }
                if(!test.isValid(row))
                {
                    System.out.println("\rNot valid selection. Try again!\n");
                }
            }while(!test.isValid(row));
        }
        System.out.print(test);
        if(test.isWinner()&& player1)
            System.out.println("Player 1 wins!");
        else if(test.isWinner())
            System.out.println("Player 2 wins!");
        else
            System.out.println("Draw!");
    }
    public void popOut()
    {
        popOut(6,7);
    }
}

