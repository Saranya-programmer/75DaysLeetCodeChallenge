/*
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int cnt=0;
        for(char c:s.toCharArray())
        {
            
            if(c=='(')
            {
                st.push(c);
            }
            else
            {
                if(!st.isEmpty())
                {
                char top=st.peek();
                if(c==')' && top=='(')
                {
                    st.pop();
                }
                }
                else
                {
                    cnt++;
                    
                }
            }   
        }
        return cnt+st.size();
    }
}
*/
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int cnt=0;
        int open=0,add=0;
        for(char c:s.toCharArray())
        {
            
            if(c=='(')
            {
                open++;
               
            }
            else
            {
                if(open>0)
                {
                    open--;
                }
                else
                {
                    add++;
                }
            }   
        }
        return open+add;
    }
}