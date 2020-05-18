public class longestPalinSubstr{
	public static void main(String[] argv){
		String s = "abcda";
		int max = 0;
		int msi = 0, mei = 0;
		int[][] dp = new int[s.length()][s.length()];
		for(int gap = 0; gap < s.length(); gap++){
			for(int si = 0, ei = gap; ei < s.length(); si++, ei++){
				if(gap == 0) dp[si][ei] = 1;
				else if(s.charAt(si) == s.charAt(ei) && gap == 1) dp[si][ei] = 2;
				else if(s.charAt(si) == s.charAt(ei) && dp[si+1][ei-1] != 0)
					dp[si][ei] = dp[si+1][ei-1] + 2;
				if(dp[si][ei] > max){
					max = dp[si][ei];
					msi = si;
					mei = ei;
				}
			}
		}
		System.out.println(max + " "+ msi + " "+ mei);
	}
}
