class Solution {

    public int numDistinct(String s,
                           String t) {

        int m = s.length();

        int n = t.length();

        int[][] dp =
            new int[n][m];

        for(int j = 0;
            j < m;
            j++) {

            if(t.charAt(0)
               ==
               s.charAt(j)) {

                dp[0][j] = 1;
            }

            if(j > 0) {

                dp[0][j]
                +=
                dp[0][j - 1];
            }
        }

        for(int i = 1;
            i < n;
            i++) {

            for(int j = 0;
                j < m;
                j++) {

                if(i > j) {

                    dp[i][j] = 0;
                }

                else {

                    if(j > 0) {

                        dp[i][j] =
                            dp[i][j - 1];
                    }

                    if(t.charAt(i)
                       ==
                       s.charAt(j)) {

                        if(j > 0) {

                            dp[i][j]
                            +=
                            dp[i - 1][j - 1];
                        }
                    }
                }

                System.out.print(dp[i][j]);
            }

            System.out.println();
        }

        return dp[n - 1][m - 1];
    }
}