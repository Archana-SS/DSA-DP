//A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.
//To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, provided it exists.
//Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.

//Method-1 : Using recursion
class Solution{
  public int helper(int idx,int heights[]){
    if(idx==0)
      return 0;

    int left=helper(idx-1,heights)+Math.abs(heights[idx]-heights[idx-1]);
    int right=Integer.MAX_VALUE;
    if(idx>1)
      right=helper(idx-2,heights)+Math.abs(heights[idx]-heights[idx-2]);

    return Math.min(left,right);
  }
  
  public int frogJump(int heights[]){
    int n=heights.length;
    return helper(n-1,heights);
  }
}

//Method-2: Using Memoization
class Solution{
  public int helper(int idx,int heights[],int[] dp){
    if(idx==0)
      return 0;

    if(dp[idx]!=-1)
      return dp[idx];
    
    int left=helper(idx-1,heights,dp)+Math.abs(heights[idx]-heights[idx-1]);
    int right=Integer.MAX_VALUE;
    if(idx>1)
      right=helper(idx-2,heights,dp)+Math.abs(heights[idx]-heights[idx-2]);

    return dp[idx]=Math.min(left,right);
  }
  
  public int frogJump(int heights[]){
    int n=heights.length;
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    
    return helper(n-1,heights,dp);
  }
}

//Mehod-3: Using Tabulation
class Solution{
  public int frogJump(int heights[]){
    int n=heights.length;
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    
    if(idx==0)
      return 0;

    dp[0]=0;

    for(int i=1;i<n;i++){
      int left=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
      int right=Integer.MAX_VALUE;
      if(i>1)
        right=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
  
      dp[i]=Math.min(left,right);
    }
    
    return dp[n-1];
  }
}

//Method-4:Space Optimization
class Solution{
  public int frogJump(int heights[]){
    int n=heights.length;
    
    if(idx==0)
      return 0;

    int prev=0,prev2=0;

    for(int i=1;i<n;i++){
      int left=prev+Math.abs(heights[i]-heights[i-1]);
      int right=Integer.MAX_VALUE;
      if(i>1)
        right=prev2+Math.abs(heights[i]-heights[i-2]);
  
      int cur=Math.min(left,right);
      prev2=prev;
      prev=cur;
    }
    
    return prev;
  }
}
