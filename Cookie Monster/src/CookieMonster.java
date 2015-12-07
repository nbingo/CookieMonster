import java.util.ArrayDeque;

public class CookieMonster {

	private int [][] cookieGrid, memoGrid;
	private int numRows;
	private int numCols;
	private int optimalPath = -1;
	private int maxCallStackDepth = 0; // Used only in recursiveOptimalPath
	private int numPaths = 0;

	public CookieMonster(int [][] cookieGrid) {
		this.cookieGrid = cookieGrid;
		this.numRows    = cookieGrid.length;
		this.numCols    = cookieGrid[0].length;
		this.memoGrid   = new int[numRows][numCols];
		for (int r = 0; r < numRows; r++)      // Initializing memoGrid to all -1's for recursiveOptimalPathMemoized
			for (int c = 0; c < numCols; c++)
				memoGrid[r][c] = -1;
	}

	/* Return the calculated optimal path */
	public int getOptimalPath() {
		return optimalPath;
	}

	private boolean goodPoint(int row, int col) {
		return (row >= 0 && row < numRows && col >= 0 && col < numCols && cookieGrid[row][col] >= 0);
	}


	/* RECURSIVELY calculates the route which grants the most cookies, and 
	 * returns the maximum depth the call stack reached during the operation. */
	public int maxCallStackDepth() {
		this.optimalPath = recursiveOptimalPathMemoized(0, 0, 1);
		return maxCallStackDepth;
	}	

	/* Helper function for the above, which returns the maximum number of cookies edible starting at coordinate (row, col). */
	/* From any given position, always check right before checking down */
	/* Also, updates the maxCallStackDepth variable, to find out how deep the recursion call stack got during the operation. 
	 * I've implemented this part already (you should add 1 to the depth when it calls itself). */ 
/**
 * @param row the row of the current point
 * @param col the column of the current point
 * @param depth the current depth of the call stack for the function.
 * @return the maximum number of cookies possible to collect in the maze.
 */
	@SuppressWarnings("unused")
	private int recursiveOptimalPath(int row, int col, int depth) {
		if (depth > this.maxCallStackDepth)
			this.maxCallStackDepth = depth;
        if (!goodPoint(row, col))
        	return 0;
        return cookieGrid[row][col] + Math.max(recursiveOptimalPath(row, col+1, depth+1), recursiveOptimalPath(row+1, col, depth+1));
	}
	
	private int recursiveOptimalPathMemoized(int row, int col, int depth)
	{
		this.maxCallStackDepth = Math.max(this.maxCallStackDepth, depth);
		return !goodPoint(row, col) ? 0 : getPointTotal(row, col, depth);
	}
	
	private int getPointTotal(int row, int col, int depth)
	{
		if (memoGrid[row][col]!=-1)
			return memoGrid[row][col];
		return memoGrid[row][col] = cookieGrid[row][col] + Math.max(recursiveOptimalPathMemoized(row, col+1, depth+1), recursiveOptimalPathMemoized(row+1, col, depth+1));
	}
	
	/* Calculate the route which grants the most cookies, and return the maximum queue size during the operation. */
	/* From any given position, always check right before checking down */
	/* Set this.optimalPath before returning */
	public int maxQueueSize() {
		ArrayDeque<PathMarker> queue = new ArrayDeque<PathMarker>();
		int maxQueueSize = 0;
		int bestPath = -1;
		PathMarker current = new PathMarker(0, 0, cookieGrid[0][0]);
		queue.addFirst(current);
		numPaths = 0;
		while(!queue.isEmpty())
		{
			boolean right = goodPoint(current.row,   current.col+1);
			boolean down  = goodPoint(current.row+1, current.col);
			
			if (right ^ down) //can only go up either right or down
				current = right ? new PathMarker(current.row, current.col+1, current.total+cookieGrid[current.row][current.col+1]) : new PathMarker(current.row+1, current.col, current.total+cookieGrid[current.row+1][current.col]);
			else if (right && down) //can go both right and down
			{
				current = new PathMarker(current.row, current.col+1, current.total+cookieGrid[current.row][current.col+1]);
				queue.addFirst(new PathMarker(current.row+1, current.col, current.total+cookieGrid[current.row+1][current.col]));
			}
			else //have reached the bottom right
			{
				bestPath = Math.max(current.total, bestPath);
				current = queue.pollLast();
				numPaths++;
			}
			maxQueueSize = Math.max(maxQueueSize, queue.size());
	}
		return maxQueueSize;
	}

	/* Calculate the route which grants the most cookies, and return the maximum stack size during the operation. */
	/* From any given position, always check right before checking down */
	/* Set this.optimalPath before returning */
	/**
	 * @return the maximum size the stack reaches during the process.
	 */
	public int maxStackSize() {
		ArrayDeque<PathMarker> stack = new ArrayDeque<PathMarker>();
		int maxStackSize = 0;
		int bestPath = -1;
		PathMarker current = new PathMarker(0, 0, cookieGrid[0][0]);
		stack.addFirst(current);
		numPaths=0;
		while(!stack.isEmpty())
		{
			boolean right = goodPoint(current.row,   current.col+1);
			boolean down  = goodPoint(current.row+1, current.col);
			
			if (right ^ down) //can only go up either right or down
				current = right ? new PathMarker(current.row, current.col+1, current.total+cookieGrid[current.row][current.col+1]) : new PathMarker(current.row+1, current.col, current.total+cookieGrid[current.row+1][current.col]);
			else if (right && down) //can go both right and down
			{
				current =  new PathMarker(current.row,   current.col+1, current.total+cookieGrid[current.row  ][current.col+1]);
				stack.push(new PathMarker(current.row+1, current.col,   current.total+cookieGrid[current.row+1][current.col  ]));
			}
			else //have reached the bottom right
			{
				bestPath = Math.max(current.total, bestPath);
				current = stack.pop();
				numPaths++;
			}
			maxStackSize = Math.max(maxStackSize, stack.size());
		}
		return maxStackSize;
	}
	
	public int getNumPaths()
	{
		return numPaths;
	}
}