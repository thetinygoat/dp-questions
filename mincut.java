public class mincut {
	
	public static int solve(int si, int ei, String s, int[] dp, boolean[][] pali){
		if(si > ei) return -1;
		if(dp[si] != 0) return dp[si];
		int min = Integer.MAX_VALUE;
		for(int cut = si; cut <= ei; cut++){
			if(pali[si][cut]){
				int cuts = solve(cut+1,ei, s, dp, pali)+1;
				min = Math.min(cuts,min);
			}
		}
		
		return dp[si] = min;
	}
	
	public static void main(String[] argv){
		String s = "aab";
		int[] dp = new int[s.length()];
		boolean[][] pali = new boolean[s.length()][s.length()];
		
		for(int gap = 0; gap < s.length();gap++){
			for(int si = 0, ei = gap; ei < s.length();ei++,si++){
				if(gap == 0) pali[si][ei] = true;
				else if(s.charAt(si) == s.charAt(ei) && gap == 1) pali[si][ei] = true;
				else pali[si][ei] = s.charAt(si) == s.charAt(ei) && pali[si+1][ei-1];
			}
		}
		
		System.out.println(solve(0,s.length()-1, s,dp,pali));
	}
	
}
