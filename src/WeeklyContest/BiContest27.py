from functools import lru_cache


class Solution:
    def cherryPickup(self, grid):
        num_row, num_col = len(grid), len(grid[0])

        @lru_cache(None)
        def dp(r, c1, c2):
            if r == num_row:
                return 0
            ans = 0
            for d1 in (-1, 0, 1):
                c1_new = c1 + d1
                if 0 <= c1_new < num_col:
                    for d2 in (-1, 0, 1):
                        c2_new = c2 + d2
                        if 0 <= c2_new < num_col:
                            ans = max(ans, dp(r + 1, c1_new, c2_new))
            base = grid[r][c1]
            if c1 != c2:
                base += grid[r][c2]
            return ans + base

        return dp(0, 0, num_col - 1)
