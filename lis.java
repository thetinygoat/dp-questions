class lis {
	public static int solve(int[] arr, int n, int[] dp){
		if(n == 0)
			return dp[n] = 1;
		if(dp[n] != 0) return dp[n];
		dp[n] = 1;
		return dp[n] = Math.max(dp[n], solve(arr, n-1,dp));
	}
	public static void main(String[] argv){
		int[] arr = {3,10,2,1,20};
		int[] dp = new int[arr.length];
		dp[0] = 1;
		int max = 0;
		/*
		for(int i = 1; i < arr.length;i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max,dp[i]);
		}
		*/
		
		System.out.println(solve(arr, arr.length - 1, dp));
		for(int e: dp) System.out.print(e + " ");
	}
}
