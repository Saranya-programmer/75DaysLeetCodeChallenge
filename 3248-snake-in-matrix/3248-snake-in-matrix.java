class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row=0;
        int col=0;
        for(String s:commands)
        {
            if(s.equals("RIGHT"))
            {
                col++;
            }
            else if(s.equals("LEFT"))
            {
                col--;
            }
            else if(s.equals("DOWN"))
            {
                row++;
            }
            else
            {
                row--;
            }
        }
        return (row*n)+col;
    }
}

/*

class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int snake=0;
        for(String s:commands)
        {
            if(s.equals("RIGHT"))
            {
                snake=snake+1;
            }
            else if(s.equals("LEFT"))
            {
                snake-=1;
            }
            else if(s.equals("DOWN"))
            {
                snake+=n;
            }
            else
            {
                snake-=n;
            }
        }
        return snake;
    }
}

*/