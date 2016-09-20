/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author danielchruscielski
 */
public abstract class Board {
    protected char[][] grid;
    
    public abstract boolean isWinner();
    public abstract boolean setSpot(int r, int c, char mark);
    public abstract boolean setSpot(int c, char mark);
    
    public char getSpot(int r,int c)
    {
        return grid[r][c];
    }
    public int getLength()
    {
        return grid.length;
    }
    public boolean isFull()
    {
        for (int r = 0;r<grid.length;r++)
        {
            for(int c = 0;c<grid[0].length;c++)
            {
                if(grid[r][c]=='-')
                    return false;
            }
        }
        return true;
    }
    public boolean isValid(int r, int c)
    {
        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='-')
            return true;
        return false;
    }
    public boolean isValid(int c)
    {
        if(c>=0 && c<grid[0].length && grid[0][c]=='-')
            return true;
        return false;
    }
    @Override public String toString()
    {
        String out = "";
        for(int r = 0;r<grid.length;r++)
        {
            for (int c = 0;c<grid[0].length;c++)
            {
                out+=grid[r][c];
            }
            out+="\n";
        }
        out+="\n";
        return out;
    }
    
    
    
    
    
}
