//A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step, and an integer k.
//To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from the ith step to any step in the range [i + 1, i + k], provided it exists.
//Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.

//Method-1: Using recursion
class Solution{
  public int helper(int idx,int heights[],int k){
    if(idx==0)
      return 0;

    int mini=Integer.MAX_VALUE;

    for(int j=1;j<=k;j++){
      if(idx-j>=0){
        int jump=helper(idx-j,heights,k)+Math.abs(heights[idx]-heights[idx-j]);
        mini=Math.min(mini,jump);
      }
    }

    return mini;
  }

  public int frogJumpKJumps(int heights[],int k){
    int n=heights.length;

    return helper(n-1,heights,k);
  }
}

//Method-2: Using Memoization
class Solution{
  public int helper(int idx,int heights[],int k,int dp[]){
    if(idx==0)
      return 0;

    if(dp[idx]!=-1)
      return dp[idx];
    
    int mini=Integer.MAX_VALUE;

    for(int j=1;j<=k;j++){
      if(idx-j>=0){
        int jump=helper(idx-j,heights,k,dp)+Math.abs(heights[idx]-heights[idx-j]);
        mini=Math.min(mini,jump);
      }
    }

    return dp[idx]=mini;
  }

  public int frogJumpKJumps(int heights[],int k){
    int n=heights.length;
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    
    return helper(n-1,heights,k,dp);
  }
}

//Method-3 : Using Tabulation
class Solution{
  public int frogJumpKJumps(int heights[],int k){
    int n=heights.length;
    int dp[]=new int[n];
    Arrays.fill(dp,-1);

    if(n==0)
      return 0;

    dp[0]=0;

    for(int i=1;i<n;i++){
      int mini=Integer.MAX_VALUE;
      for(int j=1;j<=k;j++){
        if(i-j>=0){
          int jump=dp[i-j]+Math.abs(heights[i]-heights[i-j]);
          mini=Math.min(mini,jump);
        }
        dp[i]=mini;
      }
  
    return dp[n-1];
  }
}

//No need to do space optimization because in order to do that we need to create a list of size k and during each iteration we need to remove the first element and insert cur to the end of list. But if k==n then space complexity will again be O(k)=O(n).
