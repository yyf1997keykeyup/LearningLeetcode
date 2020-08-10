class Solution:

    # https://leetcode.com/contest/biweekly-contest-32/problems/kth-missing-positive-number/
    def findKthPositive(self, arr: List[int], k: int) -> int:
        count = 1
        i = 0
        while i < len(arr):
            if k == 0:
                return count - 1
            if count == arr[i]:
                i += 1
                count += 1
            else:
                k -= 1
                count += 1

        return count + k - 1

    # https://leetcode.com/contest/biweekly-contest-32/problems/can-convert-string-in-k-moves/
    def canConvertString(self, s: str, t: str, k: int) -> bool:
        if len(s) != len(t):
            return False
        i = 0
        idx_diff_list = []
        while i < len(s):
            diff = ord(t[i]) - ord(s[i])
            if diff != 0:
                if diff < 0:
                    idx_diff_list.append(diff + 26)
                else:
                    idx_diff_list.append(diff)
            i += 1
        if len(idx_diff_list) == 0:
            return 0 <= k
        idx_diff_list.sort()
        prev = idx_diff_list[0]
        _max = prev
        curr_plus = 0
        i = 1
        while i < len(idx_diff_list):
            if idx_diff_list[i] == prev:
                curr_plus += 1
            else:
                _max = max(_max, curr_plus * 26 + prev)
                curr_plus = 0
            _max = max(_max, idx_diff_list[i])
            prev = idx_diff_list[i]
            i += 1
        _max = max(_max, curr_plus * 26 + prev)
        return _max <= k

    # https://leetcode.com/contest/biweekly-contest-32/problems/minimum-insertions-to-balance-a-parentheses-string/
    def minInsertions(self, s: str) -> int:
        output = 0
        right_counter = 0
        left_counter = 0
        for i in range(len(s)):
            if s[i] == '(':
                left_counter += 1
            if s[i] == ')':
                right_counter += 1
                if i != len(s) - 1 and s[i+1] == '(':
                    # 中途结算
                    if right_counter % 2 == 1:
                        right_counter += 1
                        output += 1
                    if left_counter > right_counter / 2:
                        left_counter -= right_counter / 2
                        right_counter = 0
                    else:
                        output += (right_counter / 2 - left_counter)
                        right_counter = 0
                        left_counter = 0

        if right_counter % 2 == 1:
            right_counter += 1
            output += 1
        if left_counter > right_counter / 2:
            output += (left_counter - right_counter / 2) * 2
        else:
            output += (right_counter / 2 - left_counter)

        return int(output)
