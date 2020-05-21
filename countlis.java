class countlis {
	public static void main (String[] argv){
		int[] arr = {0,8,4,12,2,10,6,14};
		int n = arr.length;
		int[] dp = new int[n];
		int[] count = new int[n];
		
		int maxlen = 0;
		int maxcount = 0;
		
		for(int i = 0; i < n; i++){
			dp[i] = 1;
			count[i] = 1;
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j]){
					if(dp[j]+1 > dp[i]){
						dp[i] = dp[j]+1;
						count[i] = count[j];
					}else if(dp[j] + 1 == dp[i]){
						count[i] += count[j];
					}
				}
			}
			
			if(dp[i] > maxlen){
				maxlen = dp[i];
				maxcount = count[i];
			}else if(dp[i] == maxlen){
				maxcount += count[i];
			}
		}
		
		System.out.println(maxlen);
		System.out.println(maxcount);
		for(int e: count) System.out.print(e + " ");
	}
}
