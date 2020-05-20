class lismaxsum {
	public static void main(String[] argv){
		int[] arr =   {1, 101, 2, 3, 100, 4, 5};
		int[] dp = new int[arr.length];
		int max = 0;
		for(int i = 0; i < arr.length; i++){
			dp[i] = arr[i];
			int sum = 0;
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			max = Math.max(max,dp[i]);
		}
		System.out.println(max);
		for(int e: dp) System.out.print(e + " ");
	}
}
