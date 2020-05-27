class optimalbst {
	public static int solve(int[] freq, int[] values, int[][] dp, int si, int ei){
		if(dp[si][ei] != 0) return dp[si][ei];
		int min = (int)1e8;
		for(int cut = si; cut <= ei; cut++){
			int l = (cut==si)?0:solve(freq,values,dp,si,cut-1);
			int r = (cut == ei)?0:solve(freq,values,dp,cut+1,ei);
			int sum = 0;
			for(int i = si; i<=ei; i++){
				sum+= freq[i];
			}
			int ans = l + sum + r;
			min = Math.min(min,ans);
		}
		
		return dp[si][ei] = min;
	}
	public static void main(String[] argv){
		int[] values = {10,12,20};
		int[] freq = {34,8,50};
		int[] sum = new int[freq.length];

		int[][] dp = new int[values.length][freq.length];
		System.out.println(solve(freq,values,dp,0,values.length-1));
	}
}
