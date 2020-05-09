class goldmine{
	public static int solve(int[][] grid, int r, int c, int[][] dp){
		
		if(c == grid[0].length - 1){
			return dp[r][c] = grid[r][c];
		}
		
		if(dp[r][c] != 0) return dp[r][c];
		int up = 0, down = 0, right = 0;
		if(r - 1 >=0 && c + 1 < grid[0].length)
			up = solve(grid, r-1, c+1, dp);
		if(r + 1 < grid.length && c + 1 < grid[0].length)
			down = solve(grid, r+1, c+1, dp);
		if(c + 1 < grid[0].length)
			right = solve(grid, r, c+1, dp);		
		
		int max = Math.max(up,Math.max(down, right));
		return dp[r][c] = max + grid[r][c];
	}
	public static void main(String[] argv){
		int[][] grid = {{10,33,13,15}, {22,21,04,1}, {5,0,2,3}, {0,6,14,2}};
		int[][] dp = new int[grid.length][grid[0].length];
		int max = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				max = Math.max(solve(grid,i,0,dp), max);
			}
		}
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < dp.length; j++){
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println(max);
	}
}
