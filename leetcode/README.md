## 参考链接

- http://bookshadow.com/weblog/2016/04/19/leetcode-integer-break/
- https://blog.csdn.net/qq508618087/article/details/50394131
- 



## TODOLIST

- [ ] 57
- [ ] 768
- [ ] 152 
- [ ] 689 
- [ ] 591

## 算法思路归纳

- 与其拼命无脑的刷题，不如把题目的规律总结一下。也方便快速复习
- 要啃就啃硬骨头

## Tree

### 思路总结

- 我发觉树这类题目，看题解不如直接看代码。绕来绕去文字很难解释清楚

### 题目

#### 124. [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)

Given a **non-empty** binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain **at least one node** and does not need to go through the root.

**Example 1:**

```
Input: [1,2,3]

       1
      / \
     2   3

Output: 6
```

**Example 2:**

```
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
```

#### 思路

- 题目意思还真是不知道想表达神马啊

- 提供一个二叉树，找出一条路径和最大的路线。边的权值是两个节点之和

- 参考思路

- https://blog.csdn.net/jmspan/article/details/51478810

- ```java
  public class Solution {
      private int max = Integer.MIN_VALUE;
      private int maxSideSum(TreeNode node) {
          if (node == null) return 0;
          int left = maxSideSum(node.left);
          int right = maxSideSum(node.right);
          max = Math.max(max, left + node.val + right);
          return Math.max(0, node.val + Math.max(left, right));
      }
      public int maxPathSum(TreeNode root) {
          maxSideSum(root);
          return max;
      }
  }
  ```




#### 685. [Redundant Connection II](https://leetcode.com/problems/redundant-connection-ii/description/)

In this problem, a rooted tree is a **directed** graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of `edges`. Each element of `edges` is a pair `[u, v]` that represents a **directed** edge connecting nodes `u` and `v`, where `u` is a parent of child `v`.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

**Example 1:**

```
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
```

**Example 2:**

```
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
```

**Note:**

The size of the input 2D-array will be between 3 and 1000.

Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

#### 思路

- http://www.cnblogs.com/grandyang/p/8445733.html

- ```java
  public int[] findRedundantDirectedConnection(int[][] edges) {
          int[] roots = new int[edges.length];
          for (int i = 0; i < edges.length; i++) roots[i] = i;
  
          int[] candidate1 = null, candidate2 = null;
          for (int[] e : edges){
              int rootx = find(roots, e[0]-1), rooty = find(roots, e[1]-1);
              if (rootx != rooty) {
                  if (rooty != e[1]-1) candidate1 = e; // record the last edge which results in "multiple parents" issue
                  else roots[rooty] = rootx;
              }
              else candidate2 = e; // record last edge which results in "cycle" issue, if any.
          }
  
          // if there is only one issue, return this one.
          if (candidate1 == null) return candidate2; 
          if (candidate2 == null) return candidate1;
          
          // If both issues present, then the answer should be the first edge which results in "multiple parents" issue
          // Could use map to skip this pass, but will use more memory.
          for (int[] e : edges) if (e[1] == candidate1[1]) return e;
  
          return new int[2];
      }
  
      private int find(int[] roots, int i){
          while (i != roots[i]){
              roots[i] = roots[roots[i]];
              i = roots[i];
          }
          return i;
      }
  ```


#### 99. [Recover Binary Search Tree](https://leetcode.com/problems/recover-binary-search-tree/description/) 

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

**Example 1:**

```
Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
```

**Example 2:**

```
Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
```

**Follow up:**

- A solution using O(*n*) space is pretty straight forward.
- Could you devise a constant space solution?

#### 思路

- 二叉搜索是否被交换，就要看能否搜索到，左子树要小于根，右子树要大于根

- 比如第一个例子搜索2时，就无法搜索到

- 在一棵二叉搜索树中, 只有两个节点是被交换的. 找到这些节点并交换, 如果没有节点被交换就返回原来的树的根节点

- ```java
  public class Solution {
      private TreeNode firstElement = null;
      private TreeNode secondElement = null;
      private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE); 
      
      private void traverse(TreeNode root) {
          if (root == null) {
              return;
          }
          traverse(root.left);
          if (firstElement == null && root.val < lastElement.val) {
              firstElement = lastElement;
          }
          if (firstElement != null && root.val < lastElement.val) {
              secondElement = root;
          }
          lastElement = root;
          traverse(root.right);
      }
      
      public void recoverTree(TreeNode root) {
          // traverse and get two elements
          traverse(root);
          // swap
          int temp = firstElement.val;
          firstElement.val = secondElement.val;
          secondElement.val = temp;
      }
  }
  ```


#### 834. [Sum of Distances in Tree](https://leetcode.com/problems/sum-of-distances-in-tree/description/)

An undirected, connected tree with `N` nodes labelled `0...N-1` and `N-1` `edges` are given.

The `i`th edge connects nodes `edges[i][0] `and` edges[i][1]` together.

Return a list `ans`, where `ans[i]` is the sum of the distances between node `i` and all other nodes.

**Example 1:**

```
Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: 
Here is a diagram of the given tree:
  0
 / \
1   2
   /|\
  3 4 5
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
```

Note: `1 <= N <= 10000`

#### 思路

- 给出一个树，求每个节点到所有节点的距离和。边长为1

- 题解：https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C++JavaPython-Pre-order-and-Post-order-DFS-O(N)

- ```
      int[] res, count; ArrayList<HashSet<Integer>> tree; int n;
      public int[] sumOfDistancesInTree(int N, int[][] edges) {
          tree = new ArrayList<HashSet<Integer>>();
          res = new int[N];
          count = new int[N];
          n = N;
          for (int i = 0; i < N ; ++i ) tree.add(new HashSet<Integer>());
          for (int[] e : edges) {tree.get(e[0]).add(e[1]); tree.get(e[1]).add(e[0]);}
          dfs(0, new HashSet<Integer>());
          dfs2(0, new HashSet<Integer>());
          return res;
      }
  
      public void dfs(int root, HashSet<Integer> seen) {
          seen.add(root);
          for (int i : tree.get(root))
              if (!seen.contains(i)) {
                  dfs(i, seen);
                  count[root] += count[i];
                  res[root] += res[i] + count[i];
              }
          count[root]++;
      }
  
  
      public void dfs2(int root, HashSet<Integer> seen) {
          seen.add(root);
          for (int i : tree.get(root))
              if (!seen.contains(i)) {
                  res[i] = res[root] - count[i] + n - count[i];
                  dfs2(i, seen);
              };
      }
  ```







#### 297. [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/) 

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

**Example:** 

```
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
```

**Clarification:** The above format is the same as [how LeetCode serializes a binary tree](https://leetcode.com/faq/#binary-tree). You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

**Note:** Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

#### 思路

- http://www.cnblogs.com/grandyang/p/4913869.html



#### 145. [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/description/) 

Given a binary tree, return the *postorder* traversal of its nodes' values.

**Example:**

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
```

**Follow up:** Recursive solution is trivial, could you do it iteratively?

#### 思路

- https://blog.csdn.net/yanglingwell/article/details/80994422
- 



#### 98. [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/description/) 

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys **less than** the node's key.
- The right subtree of a node contains only nodes with keys **greater than** the node's key.
- Both the left and right subtrees must also be binary search trees.

**Example 1:**

```
Input:
    2
   / \
  1   3
Output: true
```

**Example 2:**

```
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
```

#### 思路

- https://www.cnblogs.com/yrbbest/p/4437172.htmlhttps://www.cnblogs.com/yrbbest/p/4437172.html

- ```Java
  public class Solution {
      TreeNode lastNode; 
      public boolean isValidBST(TreeNode root) {
          if(root == null)
              return true;
          if(!isValidBST(root.left))
              return false;
          if(lastNode != null && lastNode.val >= root.val)
              return false;
          lastNode = root;
          if(!isValidBST(root.right))
              return false;
          return true;
      }
  }
  ```





#### 222. [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/description/) 

Given a **complete** binary tree, count the number of nodes.

**Note:**

**Definition of a complete binary tree from Wikipedia:**
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

**Example:**

```
Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
```

#### 思路

- http://www.cnblogs.com/grandyang/p/4567827.html

- ```
  class Solution {
  public:
      int countNodes(TreeNode* root) {
          int hLeft = 0, hRight = 0;
          TreeNode *pLeft = root, *pRight = root;
          while (pLeft) {
              ++hLeft;
              pLeft = pLeft->left;
          }
          while (pRight) {
              ++hRight;
              pRight = pRight->right;
          }
          if (hLeft == hRight) return pow(2, hLeft) - 1;
          return countNodes(root->left) + countNodes(root->right) + 1;
      }
  };
  ```



#### 236. [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/) 

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow **a node to be a descendant of itself**).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

```
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
```

**Example 1:**

```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of of nodes 5 and 1 is 3.
```

**Example 2:**

```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
             according to the LCA definition.
```

**Note:**

- All of the nodes' values will be unique.
- p and q are different and both values will exist in the binary tree.

#### 思路

- https://blog.csdn.net/Jeanphorn/article/details/46894663

- ```c++
  class Solution {
  public:
      TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
          if(root == NULL || root == p || root == q) return root;
  
          TreeNode *ltree = lowestCommonAncestor(root->left,p,q);
          TreeNode *rtree = lowestCommonAncestor(root->right,p,q);
  
          if(ltree && rtree) return root;
  
          return ltree?ltree:rtree;
      }
  };
  ```




#### 95. [Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/description/) 

Given an integer *n*, generate all structurally unique **BST's** (binary search trees) that store values 1 ... *n*.

**Example:**

```
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

#### 思路

- http://www.cnblogs.com/grandyang/p/4301096.html

- ```c++
  class Solution {
  public:
      vector<TreeNode *> generateTrees(int n) {
          if (n == 0) return {};
          return *generateTreesDFS(1, n);
      }
      vector<TreeNode*> *generateTreesDFS(int start, int end) {
          vector<TreeNode*> *subTree = new vector<TreeNode*>();
          if (start > end) subTree->push_back(NULL);
          else {
              for (int i = start; i <= end; ++i) {
                  vector<TreeNode*> *leftSubTree = generateTreesDFS(start, i - 1);
                  vector<TreeNode*> *rightSubTree = generateTreesDFS(i + 1, end);
                  for (int j = 0; j < leftSubTree->size(); ++j) {
                      for (int k = 0; k < rightSubTree->size(); ++k) {
                          TreeNode *node = new TreeNode(i);
                          node->left = (*leftSubTree)[j];
                          node->right = (*rightSubTree)[k];
                          subTree->push_back(node);
                      }
                  }
              }
          }
          return subTree;
      }
  };
  ```



#### 117. [Populating Next Right Pointers in Each Node II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/)

Given a binary tree

```
struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.

Initially, all next pointers are set to `NULL`.

**Note:**

- You may only use constant extra space.
- Recursive approach is fine, implicit stack space does not count as extra space for this problem.

**Example:**

Given the following binary tree,

```
     1
   /  \
  2    3
 / \    \
4   5    7
```

After calling your function, the tree should look like:

```
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
```

#### 思路

- https://blog.csdn.net/qq508618087/article/details/50508030

- ```java
  class Solution {
  public:
      void connect(TreeLinkNode *root) {
          TreeLinkNode *pHead = new TreeLinkNode(0), *pre = pHead;
          while(root)
          {
              if(root->left)
              {
                  pre->next = root->left;
                  pre = pre->next;
              }
              if(root->right)
              {
                  pre->next = root->right;
                  pre = pre->next;
              }
              root = root->next;
              if(!root)//如果到了一层的最后一个结点，就连接下一层的第一个结点
              {
                  pre = pHead;
                  root = pHead->next;
                  pHead->next = NULL;
              }
          }
      }
  };
  ```


#### 106. [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

Given inorder and postorder traversal of a tree, construct the binary tree.

**Note:**
You may assume that duplicates do not exist in the tree.

For example, given

```
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
```

Return the following binary tree:

```
    3
   / \
  9  20
    /  \
   15   7
```

#### 思路

- 借助map空间存储树的节点。只需左右节点位置赋值到位就行了
- 规律：后序遍历，最后一个一定是根
- 前序遍历，第一个一定是根
- 中序遍历就是用来辅助的
- 中序的数字作为左右边界的互换条件
- 如果中序的数字一直没有找到，那么安装后序遍历不停往右赋值
- 如果中序的数字已经存在，那么让当前节点转移到后序的左节点

```
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if (inorder.empty()) return NULL;
        reverse(postorder.begin(), postorder.end());
        reverse(inorder.begin(), inorder.end());
        TreeNode* root = new TreeNode(postorder[0]);
        TreeNode** curr = &(root->right);
        unordered_map<int, TreeNode*> seen;
        seen[postorder[0]] = root;
        int i = 0, j = 0;
        while (j < inorder.size()) {
            if (seen.count(inorder[j]) == 0) {
                TreeNode* node = new TreeNode(postorder[++i]);
                seen[node->val] = node;
                *curr = node;
                curr = &(node->right);
            }
            else {
                curr = &(seen[inorder[j]]->left);
                j++;
            }
        }
        return root;
    }
};
```



#### 116. [Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

Given a binary tree

```
struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.

Initially, all next pointers are set to `NULL`.

**Note:**

- You may only use constant extra space.
- Recursive approach is fine, implicit stack space does not count as extra space for this problem.
- You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

**Example:**

Given the following perfect binary tree,

```
     1
   /  \
  2    3
 / \  / \
4  5  6  7
```

After calling your function, the tree should look like:

```
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
```

#### 思路







#### 思路





#### 思路

思路

## Math

### 思路总结

### 题目



## 格式有问题题目

#### 132. [Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/description/)

Given a string *s*, partition *s* such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of *s*.

**Example:**


Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.




#### 思路

- 一个字符串切割多少次，可以切磋成所有的子字符串为回文字符串

- https://www.cnblogs.com/zuoyuan/p/3758783.html

- 看不懂解法可以看youtube视频手动推导





```c++
- class Solution {
  public:
      int minCut(string s) {
          int n = s.size();
          vector<int> cut(n+1, 0);  // number of cuts for the first k characters
          for (int i = 0; i <= n; i++) cut[i] = i-1;
          for (int i = 0; i < n; i++) {
              for (int j = 0; i-j >= 0 && i+j < n && s[i-j]==s[i+j] ; j++) // odd length palindrome
                  
                  cut[i+j+1] = min(cut[i+j+1],1+cut[i-j]);
                            
              for (int j = 1; i-j+1 >= 0 && i+j < n && s[i-j+1] == s[i+j]; j++) // even length palindrome
              cut[i+j+1] = min(cut[i+j+1],1+cut[i-j+1]);
      }
      return cut[n];
  }



  };

```



```python
 class Solution:

      # @param s, a string

      # @return an integer

      # @dfs time out

      # @dp is how many palindromes in the word

      def minCut(self, s):

          dp = [0 for i in range(len(s)+1)]

          p = [[False for i in range(len(s))] for j in range(len(s))]

          for i in range(len(s)+1):

              dp[i] = len(s) - i

          for i in range(len(s)-1, -1, -1):

              for j in range(i, len(s)):

                  if s[i] == s[j] and (((j - i) < 2) or pi+1):

                      pi = True

                      dp[i] = min(1+dp[j+1], dp[i])

          return dp[0]-1

```


