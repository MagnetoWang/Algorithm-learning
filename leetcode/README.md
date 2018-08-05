## 参考链接

- http://bookshadow.com/weblog/2016/04/19/leetcode-integer-break/
- https://blog.csdn.net/qq508618087/article/details/50394131
- 



## 算法思路归纳

- 要啃就啃硬骨头



## 动态规划

### 思路总结

- 
- 

### 题目

#### 303. Range Sum Query - Immutable 

Given an integer array *nums*, find the sum of the elements between indices *i* and *j* (*i* ≤ *j*), inclusive. 

**Example:**

```
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```

**Note:**

1. You may assume that the array does not change.
2. There are many calls to *sumRange* function.

#### 思路：

- 求出每个区间的总和
- 我们可以提前算出0到i之间的总和
- 然后求i到j的区间，就可以用相减的方法求出



####  53. Maximum Subarray 

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

**Follow up:**

If you have figured out the O(*n*) solution, try coding another solution using the divide and conquer approach, which is more subtle.

#### 思路：

- 求的是连续的子数组最大和
- 因为是连续的，所以这里面有个连贯的特点
- 从数组的内容来看，有正有负。显然我们不想要负数。
- 对于一个数来说，取还是不取呢。临界点就是0。
- 当我们求数组和如果加这个数，数组和大于0就选择，否则就不选择
- 在数组选择的过程中，将会出现数组的最大和，这个时候用一个变量记录这个数组和。最后打印即可



#### 413. Arithmetic Slices 

A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

```
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
```

The following sequence is not arithmetic.

```
1, 1, 2, 5, 7
```

 

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

**Example:**

```
A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
```

#### 思路：

- 这道题是要求找出给定数组中所有的等差子序列，要求是长度大于等于3。  这道题的思想就是，首先找出一个最长的等差子序列（这个肯定是连续出现的），然后根据这个最长的长度用公式算出所有的子序列的多少。 
- 这里等差数列好理解。比较难理解的是怎样从一个长的等差数列算出他的子数列个数。
- 先解决求等差数列有多少个子数列
  - 一个数列的至少需要3个数，假设数列的基本单位是3个数为一组
  - 数列长度为3的时候，子数列是1，相当于有一个单位的数列
  - 长度为4的时候，子数列是3，相当于有2个单位的数列
  - 长度为5的时候，子数列是6，相当于有3个单位的数列
  - 求一个数列有多少个单位数列，用数列长度-2得出
  - 再由单位数列求出子数列个数，1+2+...+单位数列个数
- 初始化为0
- 以i=2作为起点，开始遍历，如果找到一个单位的数列赋值为1，或者赋值为前一个单位个数+1
- 最后全部相加就行



#### 343. Integer Break

Given a positive integer *n*, break it into the sum of **at least** two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given *n* = 2, return 1 (2 = 1 + 1); given *n* = 10, return 36 (10 = 3 + 3 + 4).

**Note**: You may assume that *n* is not less than 2 and not larger than 58.

**Credits:**
Special thanks to [@jianchao.li.fighter](https://leetcode.com/discuss/user/jianchao.li.fighter) for adding this problem and creating all test cases.

#### 思路

- 找规律。因为感觉完全没有什么好的切入口

- ```
  2  ->  1 * 1
  3  ->  2 * 1
  4  ->  2 * 2
  5  ->  3 * 2
  6  ->  3 * 3
  7  ->  3 * 2 * 2
  8  ->  3 * 3 * 2
  9  ->  3 * 3 * 3
  10 ->  3 * 3 * 2 * 2
  11 ->  3 * 3 * 3 * 2
  12 ->  3 * 3 * 3 * 3
  13 ->  3 * 3 * 3 * 2 * 2
  ```


- 显然拆成3是最优方案。拆成4就变成2\*2，拆成5就变成3\*2

- 那么直接算需要多少个3

- n%3

- 余1的话，就将n/3提出一个3然后变成2\*2就行

- 再考虑边界问题1，2，3

#### 279. [Perfect Squares](https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics))

Given a positive integer *n*, find the least number of perfect square numbers (for example, `1, 4, 9, 16, ...`) which sum to *n*.

**Example 1:**

```
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
```

**Example 2:**

```
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
```

 

#### 思路

- 难点，先搞定怎么划分，再来找最小的一组划分数
- 查阅资料：四平方和定理
  - 4^k*(8*m + 7)，满足这个公式即可
- 题目要求是只需要返回个数即可
- 分类：1，2，3，4
- 1的时候说明是数本身可以开平方
- 4说明满足四平方和定理
- 不满足四平方和定理的话就考虑
- Legendre's three-square theorem
  - ![n=x^{2}+y^{2}+z^{2}](https://wikimedia.org/api/rest_v1/media/math/render/svg/d21f8b668e4450e588abd892ed19cae7e2b61835) 
- 循环判断是否为两个数的平方和
  - 如果是，return 2
  - 否则，return 3





#### 91. Decode Ways 

A message containing letters from `A-Z` is being encoded to numbers using the following mapping:

```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

Given a **non-empty** string containing only digits, determine the total number of ways to decode it.

**Example 1:**

```
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
```

**Example 2:**

```
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
```

#### 思路

- 通过前面一些题目子数组之类，还有找数列的多少种子数列。
- 我们可以猜想，这也是个累加的一个过程。
- 可以累加的话，就需要找一个单位，作为累加的基本条件。
- 我个人认为，这个累加的基本的单位就是连续两个数字，是否在1到26以内。
- 注意：对于0要特殊处理
- 那么怎么加呢？
- 应该是要参考前两个位置的和才行
- 先解决临界位置，0和1
  - 第0个位置，种类是1。
  - 第1个位置，也是1。
  - 那么第2个的位置，就是存放前面两个字母的种类数的情况决定。同时也是存放前2个字母的最终答案
  - 如果0和1可以组合，那么第2个位置加上第0个和第1个
  - 如果不可以，那么第2个位置加上第1个即可
  - 同样当数组变长，就考虑第3个，第4个之类，依次类推
- 说实话，我还是不理解，为什么这样的状态公式可以求解出答案。
- 现在回想一下，可不可以这样理解
  - 比如说现在5个数字。
  - 前3个是不用考虑的，之前讲过了
  - 那么在第4个数字上，如果第3个数字符合规定不等于0，那么加上
  - 如果第3个数字和第2个数字可以组合成一个字母，对于这两个字母来说，可以看成一个整体。那么就可以加上作为一个整体的情况，也就是一个字母的情况之前的状态



#### 400. [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation)

Given an unsorted array of integers, find the length of longest increasing subsequence.

**Example:**

```
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
```

**Note:**

- There may be more than one LIS combination, it is only necessary for you to return the length.
- Your algorithm should run in O(*n2*) complexity.

**Follow up:** Could you improve it to O(*n* log *n*) time complexity?

#### 思路

- 题目要求找的是最长增长子序列，是子序列， 也是说不具备连续性了。更多的还是一种状态

- 返回长度就行了

- 常规思路

  - 构造一个dp数组。存放对应数组第i个位置的最长子序列长度
  - 每次在第i个数，遍历之前的数组，如果遇到符合条件（大于或者小于），在第i个位置的长度基础上增加1即可
  - 不停的更新这样每个数
  - 最终n*n的复杂度

- 更快的方法

  - 构造尾巴数组，数组的下标表示长度，第i个位置存放的内容是，数组中长度为i的递增子序列中，子序列的最后一个数。要么是最大，要么是最小取决于看条件
  - 这里对数组循环，每次更新尾巴数组。
  - 更新尾巴数组的代码非常考验代码实现能力！主要是下标极易出错，还有逻辑方面需要非常严谨！



#### 646. Maximum Length of Pair Chain 

You are given `n` pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair `(c, d)` can follow another pair `(a, b)` if and only if `b < c`. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

**Example 1:**

```
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
```

**Note:**

1. The number of given pairs will be in the range [1, 1000].



#### 思路

- 贪心算法
  - 按照每个二元数，对第一位数，进行排序
  - 定义一个变量tail，初始化为最小值
  - 如果二元组第二位小于这个变量，那么更新这个变量值
  - 如果二元组第一位大于这个变量，那么增加长度，并将第一位的数更新到tail
  - 循环反复 
  - 这个贪心法有点绕，并且取巧，总之第一次不能理解到位
- 贪心算法2-更好理解
  - 对第二位进行排序
  - 定义变量tail，为第一数组对的第二位。显然这一定是数组链的第一个数。
  - 然后从第一数组对开始遍历
  - 如果找到第一位比tail大的就更新长度
  - 循环反复
  - 这个算法没有那么绕，不过我总觉得会不会遗漏什么可能性
- dp
  - dp数组维护在第i个下标下，dp的内容是第i个数遍历整个数组对，然后找到符合条件的内容，并选取其中一个最大值，并更新进去
  - 符合的条件就是题目的要求





#### 376. Wiggle Subsequence

A sequence of numbers is called a **wiggle sequence** if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, `[1,7,4,9,2,5]` is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, `[1,4,7,2,5]` and `[1,7,4,5,5]` are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

**Examples:**

```
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
```

**Follow up:**
Can you do it in O(*n*) time?



#### 思路

-  要求最长的子序列，子序列必须符合的条件是他们之间的差必须是正负交替
- 那么一定需要判断正负之间的关系
- 建立两个数组up和down,都是存放着正负交替的长度，但是存放的分别是一个以正数为结尾的长度，另一是负数结尾的长度。
- 也就是当前的数组下标位置，有两个可能的结尾，要么正数，要么负数。选择最长的一个
- 而每一个结尾的状态都取决于另一个数组基础上+1
- up保存之间差为正数的状态，down保存差为负数的状态
- 差为正数时，up显然可以从down当前的长度+1，down保持不变，继续推进。
- 同理负数
- 最终选择最长的一个
- 这种就是状态的累加，以及状态的拆分



#### 416. [Partition Equal Subset Sum](http://www.cnblogs.com/grandyang/p/5951422.html) 

Given a **non-empty** array containing **only positive integers**, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

**Note:**

1. Each of the array element will not exceed 100.
2. The array size will not exceed 200.

**Example 1:**

```
Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
```

**Example 2:**

```
Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
```

#### 思路

- 其实就是从一个集合拆分成两个集合。然后两个集合的和都要相等
- 如何拆分呢。状态是相等与不相等。又如何平衡迭代呢？
  - 找规律
  - 先排序
  - 一个从头开始，一个从尾巴开始。往中间聚合
  - 显然是错误的！！！！！
- 0/1背包算法
  - 一开始没理解，那么就多看几遍
  - 定义dp\[i\]\[j\],行是给的数组的长度，列是算出数组和，然后定义为列的长度
  - 那么可以这样理解前i行是否有等于j的和。
  - 代码实现中，首先遍历数组。
  - 相当于一行一行的往下推进
  - 每一行都从列开始一行行往右推进
  - 那么对于dp\[i\]\[j\]是由上一行，第j个位置或者，第j-num\[i\]来决定的
  - 列的推进比较有讲究
  - 起始位置是数组和的一半，然后一直自减到数组第i个的值。
  - 符合的条件返回true，否则就是false



#### 494. [Target Sum](https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation) 

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols `+` and `-`. For each integer, you should choose one from `+` and `-` as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

**Example 1:**

```
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
```

**Note:**

1. The length of the given array is positive and will not exceed 20.
2. The sum of elements in the given array will not exceed 1000.
3. Your output answer is guaranteed to be fitted in a 32-bit integer.



#### 思路

- 求多少种方式满足这个目标数。累加状态法！

- 对于每个数都是两种状态，+或-

- 我的想法
  - dp\[i\]\[j\]，行是数组长度，列是目标数的大小，内容存放
  - 遍历行
  - 对于列来说，我认为依然是由上一行所决定，而且可能就是j和j-num[i]
  - ok,现在问题是临界的条件是什么？

- 目前比较好的方案

  - 将问题变一下，当然dp还是我前面那个dp

  - 我们求的是集合中的方案数，有正有负，非常难算

  - 网上的方案是

  - ```
           sum(P) - sum(N) = target
         sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                2 * sum(P) = target + sum(nums)
               
       ```
  - 本来我们是要把集合拆分成正数和负数然后想加得到目标
  
  - 现在我们用等价的公式转换成，只需要求子集等于target+sum(nums)的一半有多少方案就可以
  
  - 那么这就是常规的dp算法了
  
  - dp的内容存放的是方案数！
  
  - 方案数应该是累加的。所以列应该是从第num[i]开始
  
  - 符合条件就累加，否则不变






#### 139. Word Break 

Given a **non-empty** string *s* and a dictionary *wordDict* containing a list of **non-empty** words, determine if *s* can be segmented into a space-separated sequence of one or more dictionary words.

**Note:**

- The same word in the dictionary may be reused multiple times in the segmentation.
- You may assume the dictionary does not contain duplicate words.

**Example 1:**

```
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
```

**Example 2:**

```
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
```

**Example 3:**

```
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
```

#### 思路

- 求是否满足条件，返回true或false
- dp数组内容应该存放布尔值，同时这是个累加状态类型
- 显然，dp\[i\]\[j\]，行应该是字典去重的长度，列应该是字符串的长度
  - j=0时，长度为0，显然为true
  - j顺着列递推前进
  - 显然这个思路是错的！！！
- 应该是行与列都字符串的长度
  - 判断条件，j到i之间有无对应词典可以满足。
  - 在加一个条件，保证可以累加状态，就是前j个字符是否有对应的字典对应

#### 474. Ones and Zeroes

In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of **m** `0s` and **n** `1s` respectively. On the other hand, there is an array with strings consisting of only `0s` and `1s`.

Now your task is to find the maximum number of strings that you can form with given **m** `0s` and **n** `1s`. Each `0` and `1` can be used at most **once**.

**Note:**

1. The given numbers of `0s` and `1s` will both not exceed `100`
2. The size of given string array won't exceed `600`.

**Example 1:**

```
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
```

**Example 2:**

```
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
```

#### 思路

- 已知字符串数组，和m,n。如何用m，n给的0和1个数尽可能的组合出字符串数组里面的字符串。越多越好
  - dp数组内容存放应该是可以存放字符串的个数
  - 行对应着0个数，列对应1个数。仍然是个累加状态
  - 确定条件，应该又上一行和上一列并减去对应着0，1个数来决定
- 正确思路
  - 核心基本上没有太大变化，但对于这道题目，应该是3维的dp数组！
  - 第一维对应着字符串数组的长度
  - 每个字符串都会有一张状态表m*n
  - 更新状态表，要参考上一张表。也就是累加状态的过程
  - 符合条件就加1，不符合就不变



#### 322. Coin Change

You are given coins of different denominations and a total amount of money *amount*. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

**Example 1:**

```
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
```

**Example 2:**

```
Input: coins = [2], amount = 3
Output: -1
```

**Note**:
You may assume that you have an infinite number of each kind of coin.



#### 思路

- 给出数组金额和目标金额。求用最少的钱凑成目标金额
- dp数组存放的是，最少金额的纸张数
  - 行表示数组长度，列表示目标金额长度
  - 显然是个累加状态的过程
  - 所以筛选的条件是
  - 那么当前状态取决于上一行状态的同一列或者同一列减去金额后的一列
  - 最好给数组排个序
  - 符合条件，在上一个状态加1，不符合则赋值为0
  - 应该说两个状态取最小的一个状态
- 更好的方案
  - 可以完善，压缩成一维数组，然后不停更新一维数组就行
  - 这里还有初始化问题，应该初始化为integer的最大值

#### 377. Combination Sum IV

Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

**Example:**

```
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
```

**Follow up:**
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?



#### 思路

- 给定一个数组，和目标和
- 和上一题目类似，求方案总数，而不是求最少方案的个数
  - dp存放总数，并且是状态累加的过程
  - 一维数组就行，然后不断更新。
  - 行是数组，列是目标和
  - 列的推进取决减去当前数的那个位置的状态
  - 如果符合，就加上之前的。
  - 初始化第一列为1




#### 123. Best Time to Buy and Sell Stock III

Say you have an array for which the *i*th element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete at most *two* transactions.

**Note:** You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

**Example 1:**

```
Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
```

**Example 2:**

```
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
```

**Example 3:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

#### 思路

- 非常典型的推进过程。累加状态！
  - dp数组，行和列都是数组的长度，内容存放的是当前状态最大收益！
  - 当前状态由哪些决定呢？
  - 上一行的当前列的内容，和减去金额的差值也就是列的数字减去行，前提是下标，行小于列。
  - 选择最大的就行



#### 188. Best Time to Buy and Sell Stock IV
#### 思路

- 





#### 72. Edit Distance 



#### 309. Best Time to Buy and Sell Stock with Cooldown





#### 714. Best Time to Buy and Sell Stock with Transaction Fee 







#### 121. Best Time to Buy and Sell Stock 







#### 583. Delete Operation for Two Strings 

#### 



44.



32.



639.



10.

741.

174.

321.

140.

871.



132.



97.

466 .



629.



446.



818.

87.

85.



879.



472.

552.

600

115.

354.

403.

363.

664.

691.

730.

546.

517.

514.

410.

689.

847.

312.