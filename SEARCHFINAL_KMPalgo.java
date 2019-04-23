public class IfExample {
    
// Java program to count occurrences of pattern 
// KMP ALGORITHM 

    static int KMPSearch(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
   
        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[M]; 
        int j = 0;  // index for pat[] 
   
        // Preprocess the pattern (calculate lps[] 
        // array) 
        computeLPSArray(pat,M,lps); 
   
        int i = 0;  // index for txt[] 
        int res = 0;  
        int next_i = 0;   
          
        while (i < N) 
        { 
            if (pat.charAt(j) == txt.charAt(i)) 
            { 
                j++; 
                i++; 
            } 
            if (j == M) 
            { 
                // When we find pattern first time, 
                // we iterate again to check if there  
                // exists more pattern 
                j = lps[j-1]; 
                res++; 
  
                // We start i to check for more than once 
                // appearance of pattern, we will reset i  
                // to previous start+1 
                if (lps[j]!=0) 
                    i = ++next_i; 
                j = 0; 
            } 
   
            // mismatch after j matches 
            else if (i < N && pat.charAt(j) != txt.charAt(i)) 
            { 
                // Do not match lps[0..lps[j-1]] characters, 
                // they will match anyway 
                if (j != 0) 
                    j = lps[j-1]; 
                else
                    i = i+1; 
            } 
        } 
        return res; 
    } 
   
    static void computeLPSArray(String pat, int M, int lps[]) 
    { 
        // length of the previous longest prefix suffix 
        int len = 0; 
        int i = 1; 
        lps[0] = 0;  // lps[0] is always 0 
   
        // the loop calculates lps[i] for i = 1 to M-1 
        while (i < M) 
        { 
            if (pat.charAt(i) == pat.charAt(len)) 
            { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else  // (pat[i] != pat[len]) 
            { 
                // This is tricky. Consider the example. 
                // AAACAAAA and i = 7. The idea is similar  
                // to search step. 
                if (len != 0) 
                { 
                    len = lps[len-1]; 
   
                    // Also, note that we do not increment 
                    // i here 
                } 
                else  // if (len == 0) 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
   
    }
    
    public static void main(String args[]) {
        String str1 = "Jelseava else string else contains If else Example";
        int cnt=0;
        int ans=0;
        // In If-else statements you can use the contains() method

        if (str1.contains("Example")) {
            
            System.out.println("The Keyword :example: is found in given string");
            
            if (str1.contains("else"))
           ans=KMPSearch("else",str1); 
        
            
            
            
        } else {
            System.out.println("The Keyword :example: is not found in the string");
        }
       System.out.println(ans); 
        
    }
}
