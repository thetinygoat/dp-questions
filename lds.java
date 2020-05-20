class lds {
	public static void main(String[] argv){
		int[] arr = {15, 27, 14, 38, 63, 55, 46, 65, 85};
		int max = 0;
		int[] dp = new int[arr.length];
		dp[arr.length - 1] = 1;
		for(int i = arr.length - 2; i >=0; i--){
			dp[i] = 1;
			for(int j = arr.length - 1; j > i; j--){
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		for(int e: dp) System.out.print(e + " ");
	}
}
