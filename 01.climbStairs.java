// Given an integer n, there is a staircase with n steps, starting from the 0th step.Determine the number of unique ways to reach the nth step, given that each move can be either 1 or 2 steps at a time.

//Methid 1: Using Recursion
class Solution{
  public static int climbStairs(int n){
      if(n<=1)
        return 1;

      return climbStairs(n-1)+climbStairs(n-2);
  }
}

//Methid 2: Using Memoization
class Solution{
  public static int climbStairs(int n){
      if(n<=1)
        return 1;

      int dp[]=new int[n+1];
      Arrays.fill(dp,-1);

      if(dp[n]!=-1)
        return dp[n];

      return dp[n]=climbStairs(n-1)+climbStairs(n-2);
  }
}

//Methid 3: Using Tabulation
class Solution{
  public static int climbStairs(int n){
      if(n<=1)
        return 1;

      int dp[]=new int[n+1];
      Arrays.fill(dp,-1);

      dp[0]=1;
      dp[1]=1;

      for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
      }
    
      return dp[n];
  }
}

//Methid 4: Space optimization
class Solution{
  public static int climbStairs(int n){
      if(n<=1)
        return 1;

      int prev2=1,prev=1;

      for(int i=2;i<=n;i++){
        int cur=prev+prev2;
        prev2=prev;
        prev=cur;
      }

      return prev;
  }
}
