import copy
class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        # https://leetcode.com/contest/weekly-contest-190/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
        words = sentence.split(" ")
        for i in range(len(words)):
            if words[i].startswith(searchWord):
                return i+1
        return -1

    def maxVowels(self, s: str, k: int) -> int:
        # https://leetcode.com/contest/weekly-contest-190/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
        vowel_set = {"a", "e", "i", "o", "u"}
        left = 0
        right = 0
        max_count = 0
        cur_count = 0
        while right < len(s):
            if right - left >= k:
                if s[left] in vowel_set:
                    cur_count -= 1
                left += 1
            if s[right] in vowel_set:
                cur_count += 1
            right += 1
            max_count = max(cur_count, max_count)
            if max_count == k:
                return k
        return max_count

    def pseudoPalindromicPaths (self, root: TreeNode) -> int:
        # https://leetcode.com/contest/weekly-contest-190/problems/pseudo-palindromic-paths-in-a-binary-tree/
        if root is None:
            return 0
        return self.helper(root, {})

    def helper(self, root: TreeNode, node_map: {}):
        node_map[root.val] = node_map.get(root.val, 0) + 1
        # leave node
        if root.left is None and root.right is None:
            if self.checkPseudoPalindromic(node_map) is False:
                return 0
            else:
                return 1
        # mid node
        count = 0
        if root.left is not None:
            count += self.helper(root.left, copy.deepcopy(node_map))
        if root.right is not None:
            count += self.helper(root.right, copy.deepcopy(node_map))
        return count

    def checkPseudoPalindromic(self, node_map):
        odd_shown = False
        for _, count in node_map.items():
            if count % 2 == 1:
                if odd_shown is True:
                    return False
                else:
                    odd_shown = True
        return True

    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        # https://leetcode.com/contest/weekly-contest-190/problems/max-dot-product-of-two-subsequences/
        if (len(nums1) > len(nums2)):
            return self.maxDotProduct(nums2, nums1)

        mat = [[num1 * num2 for num1 in nums2] for num2 in nums1]

        for i in range(len(nums1)):
            for j in range(len(nums2)):
                if j > 0:
                    mat[i][j] = max(mat[i][j], mat[i][j-1])
                if i > 0:
                    mat[i][j] = max(mat[i][j], mat[i-1][j])
                if i > 0 and j > 0:
                    mat[i][j] = max(mat[i][j], nums1[i]*nums2[j] + mat[i-1][j-1])

        return mat[len(nums1)-1][len(nums2)-1]