/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author danielchruscielski
 */
public class ConBoard extends Board{
    
    public ConBoard()
    {
        grid = new char[6][7];
        for (int r = 0;r<grid.length;r++)
        {
            for(int c = 0;c<grid[0].length;c++)
            {
                grid[r][c]= '-';
            }
        }
    }
    public ConBoard(int row, int col)
    {
        grid = new char[row][col];
        for (int r = 0;r<grid.length;r++)
        {
            for(int c = 0;c<grid[0].length;c++)
            {
                grid[r][c]= '-';
            }
        }
    }
    @Override public boolean setSpot(int c, char mark)
    {
        for (int r = grid.length-1;r>=0;r--)
        {
            if(grid[r][c]=='-')
            {
                grid[r][c]=mark;
                return true;
            }
        }
        return false;
    }
    @Override public boolean setSpot(int row,int c, char mark)
    {
        for (int r = grid.length-1;r>=0;r--)
        {
            if(grid[r][c]=='-')
            {
                grid[r][c]=mark;
                return true;
            }
        }
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
            if(len==4)
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
        for(int c = 0;c<grid[0].length;c++)
        {
            out+=(c+1)%10+" ";
        }
        out+="\n";
        for(int r = 0;r<grid.length;r++)
        {
            for (int c = 0;c<grid[0].length;c++)
            {
                out+=grid[r][c]+ " ";
            }
            out+="\n";
        }
        out+="\n";
        return out;
    }
    
}
