class minCostPath {
	public static int solve(int[][] grid, int r, int c, int m, int n, int[][] dp){
		if(r == m && c == n){
			return dp[r][c] = grid[r][c];
		}
		if(dp[r][c] != 0) return dp[r][c];
		int down = (int)1e8, right = (int)1e8, diag = (int)1e8;
		if(c + 1 < grid[0].length)
			right = solve(grid, r, c+1, m, n, dp);
		if(r + 1 < grid[0].length)
			down = solve(grid, r + 1, c, m, n, dp);
		if(c + 1 < grid[0].length && r + 1 < grid.length)
			diag = solve(grid, r+1, c+1, m, n, dp);
		
		int min = Math.min(down, Math.min(right, diag));
		
		return dp[r][c] = min + grid[r][c];
	}
	public static void main(String[] argv){
		int[][] grid = {{1,2,3}, {4,8,2}, {1,5,3}};
		int m = grid.length -1;
		int n = grid[0].length - 1;
		int[][] dp = new int[grid.length][grid[0].length];
		System.out.println(solve(grid,0,0,m,n,dp));
		for(int[] arr: dp){
			for(int e: arr) System.out.print(e + " ");
			System.out.println();
		}
	}
}
