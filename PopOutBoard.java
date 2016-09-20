/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author danielchruscielski
 */
public class PopOutBoard extends ConBoard{
    public PopOutBoard()
    {
        super();
    }
    public PopOutBoard(int r, int c)
    {
        super(r,c);
    }
    public boolean popValid(int c, char mark)
    {
        if(c>=0 && c<grid[0].length && grid[grid.length-1][c]==mark)
            return true;
        return false;
    }
    public boolean popOutOp(int c,char mark)
    {
        if(c>=0 && c<grid[0].length && grid[grid.length-1][c]==mark)
        {
            for (int x = grid.length-1;x>0;x--)
            {
                grid[x][c]= grid[x-1][c];
            }
            grid[0][c]='-';
            return true;
        }
        return false;
    }
}
