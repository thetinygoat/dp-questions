class minPathSum{
	public static int solve(int[][] grid, int r, int c, int m, int n, int[][] dp){
		
		if(r == m-1 && c == n-1)
			return dp[r][c] = grid[r][c];
			
		if(dp[r][c] != 0) return dp[r][c];
		
		int right = (int) 1e8, bottom = (int)1e8;
		if(r + 1 < m)
			bottom = solve(grid,r+1,c,m,n,dp);
		
		if(c + 1 < n)
			right = solve(grid,r,c+1,m,n,dp);
		
		int min = Math.min(right,bottom);
		
		return dp[r][c] = min + grid[r][c];
		
	}
	public static void main(String[] argv){
		int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		System.out.println(solve(grid,0,0,m,n,dp));
				for(int[] arr: dp){
			for(int e: arr){
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
}
