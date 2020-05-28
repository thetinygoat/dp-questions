class climbStairs{
	public static int solve(int n, int s, int[] dp){
		if(s == n){
			return dp[s] = 1;
		}
		if(dp[s] != 0) return dp[s];
		int count = 0;
		for(int i = 1; i <=2; i++){
			if(s + i <= n){
				count += solve(n, s + i, dp);
			}
		}
		return dp[s] = count;
	}
  public static void main(){

  }
	public static void main(String[] argv){
		int n = 100;
		int[] dp = new int[n + 1];
		System.out.println(solve(n,0,dp));
	}
}
