/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author danielchruscielski
 */
public class TicBoard extends Board{
    public TicBoard()
    {
        grid = new char[3][3];
        for (int r = 0;r<grid.length;r++)
        {
            for (int c = 0;c<grid[0].length;c++)
            {
                grid[r][c]= '-';
            }
        }
    }
    public TicBoard(int row, int col)
    {
        grid = new char[row][col];
        for (int r = 0;r<grid.length;r++)
        {
            for (int c = 0;c<grid[0].length;c++)
            {
                grid[r][c]= '-';
            }
        }
    }
    public boolean setSpot(int r, int c, char mark)
    {
        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length)
        {
            if(grid[r][c]=='-')
            {
                grid[r][c]=mark;
                return true;
            }
        }
        return false;
    }
    public boolean setSpot(int c, char mark)
    {
        return false;
    }
    @Override public boolean isWinner()
    {
        for(int r= 0;r<grid.length;r++)
        {
            for(int c= 0;c<grid[0].length;c++)
            {
                char check = grid[r][c];
                if(check!='-')
                {
                    if(checkDir(r,c,1,check,1) || checkDir(r,c,2,check,1) || 
                        checkDir(r,c,3,check,1) || checkDir(r,c,4,check,1)
                        || checkDir(r,c,5,check,1) || checkDir(r,c,6,check,1) 
                        || checkDir(r,c,7,check,1) || checkDir(r,c,8,check,1))
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkDir(int r, int c, int dir, char mark,int len)
    {
        if (r>=0 && r<grid.length && c>= 0 && c<grid[0].length && grid[r][c]==mark)
        {
            if(len==3)
                return true;
            if(dir==1)
                return checkDir(r-1,c,dir,mark,len+1);
            if(dir==2)
                return checkDir(r-1,c+1,dir,mark,len+1);
            if(dir==3)
                return checkDir(r,c+1,dir,mark,len+1);
            if(dir==4)
                return checkDir(r+1,c+1,dir,mark,len+1);
            if(dir==5)
                return checkDir(r+1,c,dir,mark,len+1);
            if(dir==6)
                return checkDir(r+1,c-1,dir,mark,len+1);
            if(dir==7)
                return checkDir(r,c-1,dir,mark,len+1);
            if(dir==8)
                return checkDir(r-1,c-1,dir,mark,len+1);
        }
        return false;
    }
    @Override public String toString()
    {
        String out = "";
        for(int r = 0;r<grid.length;r++)
        {
            for (int c = 0;c<grid.length;c++)
            {
                out+=grid[r][c];
            }
            out+="\n";
        }
        out+="\n";
        return out;
    }
}
