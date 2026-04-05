class Solution {
    public String reverseWords(String s) {
    int i=s.length()-1;
    StringBuilder sb=new StringBuilder();
    while(i>=0){
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        if(i<0)
          break;
        int end=i;
        while(i>=0 && s.charAt(i)!=' '){
            i--;
        }
        if(sb.length()>0)
        {
            sb.append(" ");
        }
        String word=s.substring(i+1,end+1);
        sb.append(word);
    }
    return sb.toString();
    }
}



