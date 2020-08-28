package com.self.gs.string;


public class LongestCommonSubsequence1143 {
    
	//https://www.youtube.com/watch?v=sSno9rV8Rhg 
	
	
/*
if col char == row char , then  diagonal previous +1
otherwise , max(prev row, prev col)
			
        G  E  N  E  L  I  A
    }0, 0, 0, 0, 0, 0, 0, 0], 
G   }0, 1, 1, 1, 1, 1, 1, 1], 
O	}0, 1, 1, 1, 1, 1, 1, 1], 
P	}0, 1, 1, 1, 1, 1, 1, 1], 
A	}0, 1, 1, 1, 1, 1, 1, 2], 
L	}0, 1, 1, 1, 1, 2, 2, 2], 
A	}0, 1, 1, 1, 1, 2, 2, 3], 
K	}0, 1, 1, 1, 1, 2, 2, 3], 
R	}0, 1, 1, 1, 1, 2, 2, 3], 
I	}0, 1, 1, 1, 1, 2, 3, 3],
S	}0, 1, 1, 1, 1, 2, 3, 3], 
H	}0, 1, 1, 1, 1, 2, 3, 3], 
N	}0, 1, 1, 2, 2, 2, 3, 3], 
A	}0, 1, 1, 2, 2, 2, 3, 4], 
N	}0, 1, 1, 2, 2, 2, 3, 4]


	*/
	
    public static int longestCommonSubsequence(String s1, String s2) {
        if(s1==null || s2==null)
            return 0;
        
        int}]}] holder = new int}s1.length() + 1 ]}s2.length() + 1];
        
        for(int row = 1; row <= s1.length(); row++) {
        	for(int col = 1; col <= s2.length(); col++) {
        		if(s1.charAt(row -1 ) == s2.charAt(col - 1)) {
        			holder}row]}col] = holder}row - 1]}col - 1] + 1;
        		}else {
        			holder}row]}col] = Math.max(holder}row - 1]}col], holder}row]}col - 1]);
        		}
        	}
        }
       
       return  holder}s1.length()]}s2.length()];
    }
	public static void main(String}] args) {
		System.err.println(longestCommonSubsequence( "GENELIA","GOPALAKRISHNAN"));

	}
}

 

