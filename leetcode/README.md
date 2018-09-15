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



#### 188. [Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/)

Say you have an array for which the *i*th element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete at most **k** transactions.

**Note:**
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

**Example 1:**

```
Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
```

**Example 2:**

```
Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
```



#### 思路

- 找出K次交易的最大利润，每次交易只能有一个股票

```c++
    class Solution {
      public:
          int maxProfit(int k, vector<int>& prices) {
              int m = prices.size();
              if(m==0 || m==1 || k == 0) return 0;
              if (k>m/2){ // simple case
                  int ans = 0;
                  for (int i=1; i<m; ++i){
                      ans += max(prices[i] - prices[i-1],0);
                  }
                  return ans;
              }
              vector<vector<int>> buy(k+1,vector<int>(m+1,0));
              vector<vector<int>> sell(k+1,vector<int>(m+1,0));
              vector<int> end(m+1,0);
              for(int i=1;i<=k;i++)
                  buy[i][0] = INT_MIN;
              for(int i=1;i<=m;i++){
                  for(int j=1;j<=k;j++){
                      //for the first buy state, need to compare the current price with the previous price. sell[0][0] are all initialized with 0, then sell[0][0] - prices[i-1] is the price of current first buy state
                      buy[j][i] = max(buy[j][i-1], sell[j-1][i-1] - prices[i-1]);
                      sell[j][i] = max(buy[j][i-1]+prices[i-1],sell[j][i-1]);
                  }
              }
              return sell[k][m];
          }
      };
```









#### 871. [Minimum Number of Refueling Stops](https://leetcode.com/problems/minimum-number-of-refueling-stops/description/)

A car travels from a starting position to a destination which is `target` miles east of the starting position.

Along the way, there are gas stations.  Each `station[i]` represents a gas station that is `station[i][0]` miles east of the starting position, and has `station[i][1]` liters of gas.

The car starts with an infinite tank of gas, which initially has `startFuel` liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.

When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return `-1`.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

 

**Example 1:**

```
Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.
```

**Example 2:**

```
Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can't reach the target (or even the first gas station).
```

**Example 3:**

```
Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: 
We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.
```

 

**Note:**

1. `1 <= target, startFuel, stations[i][1] <= 10^9`
2. `0 <= stations.length <= 500`
3. `0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target`



#### 思路

- https://blog.csdn.net/u011026968/article/details/81052040

- https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/149839/DP-O(N2)-and-Priority-Queue-O(NlogN)

- ```c++
  class Solution {
  public:
      int minRefuelStops(int target, int startFuel, vector<vector<int>>& ss) {
          // int dp[ss.size() + 1];
          if (startFuel >= target) return 0;
          if (ss.size() == 0) return startFuel >= target ? 0 : -1;
          long long dp[ ss.size() + 1 ];
          memset(dp, 0 , sizeof(dp));
          dp[0] = startFuel;
          int ret = INT_MAX;
          
          for (int i = 0; i < ss.size(); i++) {
              int t = i+1;
              for (t = i + 1; t >= 1; t--) {
                  if (dp[t - 1] < ss[i][0]) continue;
                  dp[t] = max(dp[t-1] + ss[i][1], dp[t]);
                  if (dp[t] >= target) ret = min(t , ret);
              }
              
          }
          return ret == INT_MAX ? -1 : ret;
      }
  };
  
  ```

  

#### 466. [Count The Repetitions](https://leetcode.com/problems/count-the-repetitions/description/)

Define `S = [s,n]` as the string S which consists of n connected strings s. For example, `["abc", 3]` ="abcabcabc".

On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.

You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where `S1=[s1,n1]` and `S2=[s2,n2]`. Find the maximum integer M such that `[S2,M]` can be obtained from `S1`.

**Example:**

```
Input:
s1="acb", n1=4
s2="ab", n2=2

Return:
2
```

#### 思路

- 给两个字符串和重复次数，经过重复次数之后计算新的两个字符串S1,S2。

- 找出[S2,m]被s1包含。M要尽可能的大

- http://www.cnblogs.com/grandyang/p/6149294.html

- 思路

  - 如果用常规dp也可以做出来，无非一个个暴力增长长度
  - 不过这里面的字符串是有规律
  - 大字符串都是由小字符串重复添加而构成的
  - 所以其实我们可以直接比较小字符串
  - 然后算出一个小字符串的情况，才直接通过公式计算出大字符串的情况
  - 具体看代码的注释

- ```java
  public class Solution {
      public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
          //初始变量
          int[] reps = new int[102];
          int[] rests = new int[102];
          int posRest=0, repTime=0;
          int i=0, k=0;
          if(n1 <= 0) return 0;
          //小字符串的比较主要三种情况
          //s2在s1正好可以找到对应字符
          //s2在s1不可以找到对应字符
          //s2在s1只找到一部分对应字符，下一部分还需要一个s1的字符串
          //从鸽巢原理知道，两个s1合在一起的字符串一定能完美确定下来是否能包含s2
          while(k==i) {
              i++;
              for(int j=0; j<s1.length(); j++) {
                  //posRest专门跟踪s2的字符串内容
                  //j跟踪s1的字符串
                  if(s2.charAt(posRest) == s1.charAt(j)) {
                      posRest++;
                      //如果完整包含，那么就用repTime包含一次
                      //同时postRest归0，重新计算，是否还有包含的内容
                      if(posRest == s2.length()) {
                          repTime++;
                          posRest=0;
                      }
                  }
              }
              //i如果大于s1的重复次数
              if(i >= n1)
                  return repTime / n2;
              //
              for(k=0; k<i; k++){
                  //说明位置没有变化
                  if(posRest == rests[k])
                      break;
              }
              //repTime给当前I的包含个数
              //posRest给当前I的s2跟踪的位置，好为下一次循环做准备
              reps[i] = repTime;
              rests[i] = posRest;
          }
          //算出区间，多少个s1会迭代一次，显然根据鸽巢原理，interval最大等于2
          int interval = i-k;
          //计算一个单位字符串的重复次数
          int repeatCount = (n1-k) / interval;
          //计算整个前面部分的重复次数
          int repeatTimes = repeatCount * (reps[i]-reps[k]);
          //计算剩余字符串长度的重复次数
          int remainTimes = reps[(n1-k) % interval + k];
          //因为只是计算s2的出现重复次数，所以针对S2的情况，只需要除以一下n2就Ok
          return (repeatTimes + remainTimes) / n2;
      }
  }
  ```

- 


#### 629. [K Inverse Pairs Array](https://leetcode.com/problems/k-inverse-pairs-array/description/)

Given two integers `n` and `k`, find how many different arrays consist of numbers from `1` to `n` such that there are exactly `k` inverse pairs.

We define an inverse pair as following: For `ith` and `jth` element in the array, if `i` < `j` and `a[i]` > `a[j]` then it's an inverse pair; Otherwise, it's not.

Since the answer may be very large, the answer should be modulo 109 + 7.

**Example 1:**

```
Input: n = 3, k = 0
Output: 1
Explanation: 
Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.
```

**Example 2:**

```
Input: n = 3, k = 1
Output: 2
Explanation: 
The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
```

**Note:**

1. The integer `n` is in the range [1, 1000] and `k` is in the range [0, 1000].

#### 思路

- 从1到n之间找出有多少个数组拥有k个逆序对

- https://leetcode.com/problems/k-inverse-pairs-array/discuss/104815/Java-DP-O(nk)-solution

- 逆序对的概念很容易理解，但是总是抓不到那个可以控制这个概念的规律

- 从题解中

- 假设正常的顺序的数组

- 现在把第N个数放在第N个数，那么逆序对为0

- 现在把第N个数放在第N-1个数，那么逆序对为1

- 现在把第N个数放在第N-2个数，那么逆序对为2

- 现在把第N个数放在第N-3个数，那么逆序对为3

- 现在把第N个数放在第1个数，那么逆序对为n

- 现在要找出拥有k个逆序对的数组就行

- 根据上面的规律，已经可以用暴力法了

- 既然可以用暴力法，就可以考虑用转换成dp

- http://www.cnblogs.com/grandyang/p/7111385.html

- ```
  dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]
  
  dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]
  
  dp[n][k+1] = dp[n-1][k+1]+dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]
  公式转换
  dp[n][k+1] - dp[n][k]=dp[n-1][k+1] -dp[n-1][k+1-n]
  最终的递推公式
  dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]
  ```

  

- ```java
  public static int kInversePairs(int n, int k) {
          int mod = 1000000007;
          if (k > n*(n-1)/2 || k < 0) return 0;
          if (k == 0 || k == n*(n-1)/2) return 1;
          long[][] dp = new long[n+1][k+1];
          dp[2][0] = 1;
          dp[2][1] = 1;
          for (int i = 3; i <= n; i++) {
              dp[i][0] = 1;
              for (int j = 1; j <= Math.min(k, i*(i-1)/2); j++) {
                  //完美体现递推公式，尤其是在减法的那一步做了额外的处理
                  dp[i][j] = dp[i][j-1] + dp[i-1][j];
                  if (j >= i) dp[i][j] -= dp[i-1][j-i];
                  dp[i][j] = (dp[i][j]+mod) % mod;
              }
          }
          return (int) dp[n][k];
      }
  ```





#### 446. [Arithmetic Slices II - Subsequence](https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/)

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

```
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
```

The following sequence is not arithmetic.

```
1, 1, 2, 5, 7
```

 

A zero-indexed array A consisting of N numbers is given. A **subsequence** slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A **subsequence** slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.

The function should return the number of arithmetic subsequence slices in the array A.

The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.

 

**Example:**

```
Input: [2, 4, 6, 8, 10]

Output: 7

Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
```

------

#### 思路

- 找出一个数组的所有等差数列或者等比数列。数列在数组中是序列形式

- dp，行和列都分别对应数组的内容

- 因为要打印出有规律的等差序列

- 所以dp的内容该放什么呢

- http://www.cnblogs.com/grandyang/p/6057934.html

- 提示,放a[j]-a[i]，也就是差值。差值如何应用，看代码注释

- ```java
      public int numberOfArithmeticSlices(int[] A) {
          int re = 0;
          //maps数组，分别代表A的位置
          //每个位置都是kv结构，k表示某个差值，v表示拥有该差值的个数
          HashMap<Integer, Integer>[] maps = new HashMap[A.length];
          for(int i=0; i<A.length; i++) {
              maps[i] = new HashMap<>();
              int num = A[i];
              for(int j=0; j<i; j++) {
                  //分别计算A[i]-A[j]，无论负数还是正数
                  if((long)num-A[j]>Integer.MAX_VALUE) continue;
                  if((long)num-A[j]<Integer.MIN_VALUE) continue;
                  int diff = num - A[j];
                  //找出拥有该差值的个数
                  int count = maps[j].getOrDefault(diff, 0);
                  //i在原来的j的基础上要加上1，在加自己本身
                  maps[i].put(diff, maps[i].getOrDefault(diff,0)+count+1);
                  //总个数都是从j中提取
                  re += count;
              }
          }
          return re;
      }
  ```





#### 818. Race Car 

Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)

Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).

When you get an instruction "A", your car does the following: `position += speed, speed *= 2`.

When you get an instruction "R", your car does the following: if your speed is positive then `speed = -1` , otherwise `speed = 1`.  (Your position stays the same.)

For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.

Now for some target position, say the **length** of the shortest sequence of instructions to get there.

```
Example 1:
Input: 
target = 3
Output: 2
Explanation: 
The shortest instruction sequence is "AA".
Your position goes from 0->1->3.
```

```
Example 2:
Input: 
target = 6
Output: 5
Explanation: 
The shortest instruction sequence is "AAARA".
Your position goes from 0->1->3->7->7->6.
```

**Note:**

- `1 <= target <= 10000`.

#### 思路

- 

## 数组

### 思路总结

### 题目

#### 126. [Word Ladder II](https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS) 

Given two words (*beginWord* and *endWord*), and a dictionary's word list, find all shortest transformation sequence(s) from *beginWord* to *endWord*, such that:

1. Only one letter can be changed at a time
2. Each transformed word must exist in the word list. Note that *beginWord* is *not* a transformed word.

**Note:**

- Return an empty list if there is no such transformation sequence.
- All words have the same length.
- All words contain only lowercase alphabetic characters.
- You may assume no duplicates in the word list.
- You may assume *beginWord* and *endWord* are non-empty and are not the same.

**Example 1:**

```
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
```

**Example 2:**

```
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
```

#### 思路

- 给出两个单词，一个beginWord，一个endWord。再给出一个词典。判断begin变换到end最短过程。每次只能变一个字母。变的单词必须符合在词典中
- 方法：dfs或者bfs,hashmap
- 每次用26个字母对单词的每个位置都进行遍历
- 每次遍历判断条件是否在单词列表中
- 同时在定义一个路径对象，hashmap保存路径单词和长度



#### 4. [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/) 

There are two sorted arrays **nums1** and **nums2** of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume **nums1** and **nums2** cannot be both empty.

 

**Example 1:**

```
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```

**Example 2:**

```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```

#### [思路](https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/very-concise-ologminmn-iterative-solution-with-detailed-explanation)

- 二分法



#### 45. Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

**Example:**

```
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Note:**

You can assume that you can always reach the last index.

#### 思路

- 循环状态保存最大值法
- 分结构来思考问题
- 一个大循环，每次选出max最大的数。由i+a[i]决定
- 这个时候用一个条件来更新，我们的最短路径
- 因为一定会遍历到某个i位置。遍历到i位置的时候，说明已经可以更改我们的路径。我们的路径由之前走的路最大的路程决定。也就是max
- 非常简短的代码

​```java
public int jump(int[] A) {
    int sc = 0;
    int e = 0;
    int max = 0;
    for(int i=0; i<A.length-1; i++) {
        max = Math.max(max, i+A[i]);
        if( i == e ) {
            sc++;
            e = max;
        } 
    }
    return sc;
}
```

#### [41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/description/)

Given an unsorted integer array, find the smallest missing positive integer.

**Example 1:**

```
Input: [1,2,0]
Output: 3
```

**Example 2:**

```
Input: [3,4,-1,1]
Output: 2
```

**Example 3:**

```
Input: [7,8,9,11,12]
Output: 1
```

**Note:**

Your algorithm should run in *O*(*n*) time and uses constant extra space.

#### 思路

- 排除法和调换法
- 先把大于数组长度本身数字删除，以及小于0的删除
- 在数组长度内的数字，调换到和下标和他一样的数字
- 最后在遍历一次不存在的就返回







#### 719. Find K-th Smallest Pair Distance 

Given an integer array, return the k-th smallest **distance** among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

**Example 1:**

```
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
```

**Note:**

1. `2 <= len(nums) <= 10000`.
2. `0 <= nums[i] < 1000000`.
3. `1 <= k <= len(nums) * (len(nums) - 1) / 2`.

#### 思路

- 二分法
- 这里通过二分的判断条件，不是单纯的比较大小，而是一个子函数形式。但是整体思路是二分法
- 关键找出判定函数
- 此题求的是第k个最小的差值
  - 先排序
  - 显然最大的差值是最后一个减去第一个
  - 最小的差值说不准。都有可能相邻的为1
  - 所以要从最大差值入手
  - 三层循环
  - 第一层是从0到最大差值直接的循环
  - 第二层是数组的遍历
  - 第三层是遍历第二层之前的数组，并求出它们之间的差值
  - 如果是大于mid,那么统计下来，最终如果超过K，那么就要调整mid的位置了
  - 调整完再来后面两层循环，直到有合适的mid出现
- 代码短小精悍

​```c++
class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int n = nums.size(), left = 0, right = nums.back() - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0, start = 0;
            for (int i = 0; i < n; ++i) {
                while (start < n && nums[i] - nums[start] > mid) ++start;
                cnt += i - start;
            }
            if (cnt < k) left = mid + 1;
            else right = mid;
        }
        return right;
    }
};
```





#### 84. Largest Rectangle in Histogram 

Given *n* non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

![img](https://leetcode.com/static/images/problemset/histogram.png)
Above is a histogam where width of each bar is 1, given height = `[2,1,5,6,2,3]`.

 

![img](https://leetcode.com/static/images/problemset/histogram_area.png)
The largest rectangle is shown in the shaded area, which has area = `10` unit.

 

**Example:**

```
Input: [2,1,5,6,2,3]
Output: 10
```

#### 思路

- 二层循环遍历



```

public class MaxInnerRec {
    public int countArea(int[] A, int n) {
        int maxArea=0;
        int min;
        for(int i=0;i<n;i++){
            min=Integer.MAX_VALUE;
            for(int j=i;j>=0;j--){
                min=Math.min(min, A[j]);
                maxArea=Math.max(maxArea,(i-j+1)*min);
            }
        }
        return maxArea;
    }
}
```



- 方法二;递增的栈 
- 每次只压比栈顶大的元素。否则就提出来，然后做计算





#### 57. Insert Interval

Given a set of *non-overlapping* intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

**Example 1:**

```
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```

**Example 2:**

```
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```

#### 思路

- 这个题目感觉很没意思









#### [381. Insert Delete GetRandom O(1) - Duplicates allowed](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/)

Design a data structure that supports all following operations in *average* **O(1)** time.

Note: Duplicate elements are allowed.

1. `insert(val)`: Inserts an item val to the collection.
2. `remove(val)`: Removes an item val from the collection if present.
3. `getRandom`: Returns a random element from current collection of elements. The probability of each element being returned is **linearly related** to the number of same value the collection contains.

**Example:**

```
// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
```

#### 思路

- Java HaspMap, LinkedHashSet, ArrayList 





#### 85. Maximal Rectangle 

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

**Example:**

```
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
```

#### 思路

- https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution







#### 715. Range Module 

A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.

`addRange(int left, int right)` Adds the half-open interval `[left, right)`, tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval `[left, right)` that are not already tracked.

`queryRange(int left, int right)` Returns true if and only if every real number in the interval `[left, right)` is currently being tracked.

`removeRange(int left, int right)` Stops tracking every real number currently being tracked in the interval `[left, right)`.

**Example 1:**

```
addRange(10, 20): null
removeRange(14, 16): null
queryRange(10, 14): true (Every number in [10, 14) is being tracked)
queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
```

**Note:**

A half open interval `[left, right)` denotes all real numbers `left <= x < right`.

`0 < left < right < 10^9` in all calls to `addRange, queryRange, removeRange`.

The total number of calls to `addRange` in a single test case is at most `1000`.

The total number of calls to `queryRange` in a single test case is at most `5000`.

The total number of calls to `removeRange` in a single test case is at most `1000`.

#### 思路

- https://leetcode.com/problems/range-module/discuss/108910/Java-TreeMap



####  123. Best Time to Buy and Sell Stock III

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

- https://www.jiuzhang.com/solution/best-time-to-buy-and-sell-stock-iii/

- https://blog.csdn.net/liuchonge/article/details/73274871

- 买卖股票系列题目：http://www.cnblogs.com/grandyang/p/4280131.html

- 看了3份题解才大概明白思路

- 题目要求是，交易两次，每次交易只能持有一股，求最大利润
  - 可以一般化思路，交易K次

  - 这是一道状态累加的题目，不过是时间序列累加

  - dp\[\]\[\],行对应交易次数，列对应输入的一维数组，也就总共价格天数

  - 难点：

  - 这里还要额外定义一个local\[\]\[\]，用来保存局部变量，并协助dp数组更新为最大值

  - 所以状态的公式

  - ```
           l[i][j] = max(g[i - 1][j - 1] + max(diff, 0), l[i - 1][j] + diff);
           g[i][j] = max(l[i][j], g[i - 1][j]);
       ```
    ```
  
    ```

- 全部代码，短小精悍

  - ```c++
    //version1
    class Solution {
    public:
        int maxProfit(vector<int> &prices) {
            if (prices.empty()) return 0;
            int n = prices.size(), g[n][3] = {0}, l[n][3] = {0};
            for (int i = 1; i < prices.size(); ++i) {
                int diff = prices[i] - prices[i - 1];
                for (int j = 1; j <= 2; ++j) {
                    l[i][j] = max(g[i - 1][j - 1] + max(diff, 0), l[i - 1][j] + diff);
                    g[i][j] = max(l[i][j], g[i - 1][j]);
                }
            }
            return g[n - 1][2];
        }
    };
    //二维压缩成一维。只是一行一行的更新
    //version2
    class Solution {
    public:
        int maxProfit(vector<int> &prices) {
            if (prices.empty()) return 0;
            int g[3] = {0};
            int l[3] = {0};
            for (int i = 0; i < prices.size() - 1; ++i) {
                int diff = prices[i + 1] - prices[i];
                for (int j = 2; j >= 1; --j) {
                    l[j] = max(g[j - 1] + max(diff, 0), l[j] + diff);
                    g[j] = max(l[j], g[j]);
                }
            }
            return g[2];
        }
    };
    ```

    

#### 782. [Transform to Chessboard](https://leetcode.com/problems/transform-to-chessboard/discuss/114847/Easy-and-Concise-Solution-with-Explanation-C++JavaPython) 

An N x N `board` contains only `0`s and `1`s. In each move, you can swap any 2 rows with each other, or any 2 columns with each other.

What is the minimum number of moves to transform the board into a "chessboard" - a board where no `0`s and no `1`s are 4-directionally adjacent? If the task is impossible, return -1.

```
Examples:
Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
Output: 2
Explanation:
One potential sequence of moves is shown below, from left to right:

0110     1010     1010
0110 --> 1010 --> 0101
1001     0101     1010
1001     0101     0101

The first move swaps the first and second column.
The second move swaps the second and third row.


Input: board = [[0, 1], [1, 0]]
Output: 0
Explanation:
Also note that the board with 0 in the top left corner,
01
10

is also a valid chessboard.

Input: board = [[1, 0], [1, 0]]
Output: -1
Explanation:
No matter what sequence of moves you make, you cannot end with a valid chessboard.
```

**Note:**

- `board` will have the same number of rows and columns, a number in the range `[2, 30]`.
- `board[i][j]` will be only `0`s or `1`s.

#### 思路

- 给一个01矩阵，要求变换成黑白棋盘的矩阵。0代表黑色，1代表白色。给出最少的交换步骤，否则返回-1
- 这个题目目前网络上的题解，也讲不出一个所以然
- 目前只是要求，只要符合黑白棋盘的两个条件就行
  - 每一行只有偶数个0和1
  - 每个矩阵的形式，应该是4个0，或者4个1，或者2个0和2个1
- 验证完成两个条件，再直接计算列和行求和，相加除以2即可
- 这个题目启发性不大





  #### 154. Find Minimum in Rotated Sorted Array II 

  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  `[0,1,2,4,5,6,7]` might become  `[4,5,6,7,0,1,2]`).

Find the minimum element.

The array may contain duplicates.

**Example 1:**

```
Input: [1,3,5]
Output: 1
```

**Example 2:**

```
Input: [2,2,2,0,1]
Output: 0
```

**Note:**

- This is a follow up problem to [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/).
- Would allow duplicates affect the run-time complexity? How and why?

  #### 思路

- 这道题是要你在旋转数组中最小的那个元素。
- 因为是排好序的旋转数组，所以要考虑二分法
- 正常的二分是右边大于左边，那么就反过来思考，如果不要右边大于左边，那么就有可能是最小的元素
- 难点：
  - 里面有重复的元素
  - 面对重复的元素，只需要跳过这个元素，用下一位的元素作为边界，在新的数组继续二分就行了



#### 42. [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/description/) 

Given *n* non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

![img](http://www.leetcode.com/static/images/problemset/rainwatertrap.png)
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. **Thanks Marcos**for contributing this image!

**Example:**

```
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

#### 思路

- 从左和右两头靠近中间

- 但是原理我搞不清楚，为什么能这样做

- ```c++
  class Solution {
  public:
      int trap(int A[], int n) {
          int left=0; int right=n-1;
          int res=0;
          int maxleft=0, maxright=0;
          while(left<=right){
              if(A[left]<=A[right]){
                  if(A[left]>=maxleft) maxleft=A[left];
                  else res+=maxleft-A[left];
                  left++;
              }
              else{
                  if(A[right]>=maxright) maxright= A[right];
                  else res+=maxright-A[right];
                  right--;
              }
          }
          return res;
      }
  };
  ```





#### 128. [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/discuss/) 

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(*n*) complexity.

**Example:**

```
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```



#### 思路

- https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
- 有点像并查集的思路，用hashmap
- 遍历数组
  - 如果map没有的话，查该数的-1，+1两个数，并返回value
  - value全部相加然后再加1,也就是当前的数
  - put 当前的数，和相加之后的和
  - 同时更新全局的Max数
  - 再更新左右两个数



#### 689. Maximum Sum of 3 Non-Overlapping Subarrays 

In a given array `nums` of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size `k`, and we want to maximize the sum of all `3*k` entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

**Example:**

```
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
```

**Note:**

`nums.length` will be between 1 and 20000.

`nums[i]` will be between 1 and 65535.

`k` will be between 1 and floor(nums.length / 3).

#### 思路



















#### 54. [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/description/) 

Given a matrix of *m* x *n* elements (*m* rows, *n* columns), return all elements of the matrix in spiral order.

**Example 1:**

```
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
```

**Example 2:**

```
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

#### 思路

- 题目不难，我只是想看看更高超的解法

- 定义方向数组，定义好边界

- 然后把调节设置好，让循环自动转弯

- ```
  class Solution {
      public List<Integer> spiralOrder(int[][] matrix) {
          if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new LinkedList<Integer>();
          ArrayList<Integer> res = new ArrayList<Integer>(matrix.length*matrix[0].length);
          int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
          int w = matrix[0].length;
          int h = matrix.length;
          int i = 0; int j = -1; int d = 0; int consec = 0;
          
          for (int m = 0; m < matrix[0].length*matrix.length; m++) {
              if ((d == 0 && consec == w)     ||
                  (d == 1 && consec == h - 1) ||
                  (d == 2 && consec == w - 1)) { d++; consec = 0; }
              else if (d == 3 && consec == h - 2) {
                  w -= 2; h -= 2; d = 0; consec = 0;
              }
              i += dir[d][0]; j += dir[d][1]; res.add(matrix[i][j]); consec++;
          }
          return res;
      }
  }
  ```





#### 15. 3Sum 

Given an array `nums` of *n* integers, are there elements *a*, *b*, *c* in `nums` such that *a* + *b* + *c* = 0? Find all unique triplets in the array which gives the sum of zero.

**Note:**

The solution set must not contain duplicate triplets.

**Example:**

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

#### 思路

- https://kingsfish.github.io/2017/07/13/Leetcode-15-3Sum/
- 遍历数组，每次遍历的时候把右边的数组当作2Sum来做



#### 18. [4Sum](https://kingsfish.github.io/2017/07/13/Leetcode-18-4Sum/) 

Given an array `nums` of *n* integers and an integer `target`, are there elements *a*, *b*, *c*, and *d* in `nums` such that *a* + *b* + *c* + *d* = `target`? Find all unique quadruplets in the array which gives the sum of `target`.

**Note:**

The solution set must not contain duplicate quadruplets.

**Example:**

```

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]




```

#### 思路

- 类似3Sum



#### 152. [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/) 

Given an integer array `nums`, find the contiguous subarray within an array (containing at least one number) which has the largest product.

**Example 1:**

```
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
```

**Example 2:**

```
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
```

#### 思路

- http://www.cnblogs.com/grandyang/p/4028713.html
- 





## String

### 思路总结

- 字符串处理相关题目要从结构方面考虑
- 是否对称，是否有某种规律
- 多用java本身字符串的工具！

### 题目

#### 65. Valid Number 

Validate if a given string is numeric.

Some examples:
`"0"` => `true`
`" 0.1 "` => `true`
`"abc"` => `false`
`"1 a"` => `false`
`"2e10"` => `true`

**Note:** It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

**Update (2015-02-10):**
The signature of the `C++` function had been updated. If you still see your function signature accepts a `const char *` argument, please click the reload button to reset your code definition.

#### 思路

- 直接用java内置的解析函数





#### 564. [Find the Closest Palindrome](https://leetcode.com/problems/find-the-closest-palindrome/description/) 

Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

**Example 1:**

```
Input: "123"
Output: "121"
```

**Note:**

1. The input **n** is a positive integer represented by string, whose length will not exceed 18.
2. If there is a tie, return the smaller one as answer.

#### 思路

- http://www.cnblogs.com/grandyang/p/6915355.html
- 这题不参考题解，真是想不到怎么找最接近的回文数字
  - 本身是回文字符串
    - 只需要对中间的数字进行加一或者减一，并加入后续数字的集合
  - 本身不是回文字符串
    - 要想产生最小的回文串，只有两种可能
    - 一个是左半边对折到右边
    - 另一个是右半边对折到左边
    - 加入到候选列
  - 循环找出最小的回文数字
- 其实这个算法还有很多问题
  - 比如99最小的应该是101，而不是88
- 未完成待续



#### 68. Text Justification 

Given an array of words and a width *maxWidth*, format the text such that each line has exactly *maxWidth* characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly *maxWidth* characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no **extra** space is inserted between words.

**Note:**

- A word is defined as a character sequence consisting of non-space characters only.
- Each word's length is guaranteed to be greater than 0 and not exceed *maxWidth*.
- The input array `words` contains at least one word.

**Example 1:**

```
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

**Example 2:**

```
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
```

**Example 3:**

```
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
```

#### 思路

- https://www.tianmaying.com/tutorial/LC68
- https://www.cnblogs.com/yrbbest/p/4436432.html
- 感觉这道题目好没意思啊



#### 44. Wildcard Matching 

Given an input string (`s`) and a pattern (`p`), implement wildcard pattern matching with support for `'?'` and `'*'`.

```
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
```

The matching should cover the **entire** input string (not partial).

**Note:**

- `s` could be empty and contains only lowercase letters `a-z`.
- `p` could be empty and contains only lowercase letters `a-z`, and characters like `?` or `*`.

**Example 1:**

```
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

**Example 2:**

```
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
```

**Example 3:**

```
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
```

**Example 4:**

```
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
```

**Example 5:**

```
Input:
s = "acdcb"
p = "a*c?b"
Output: false
```

#### 思路

- https://blog.csdn.net/qq508618087/article/details/51044029
- https://blog.csdn.net/MebiuW/article/details/51165505

#### 30. Substring with Concatenation of All Words 

You are given a string, **s**, and a list of words, **words**, that are all of the same length. Find all starting indices of substring(s) in **s** that is a concatenation of each word in **words** exactly once and without any intervening characters.

**Example 1:**

```
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
```

**Example 2:**

```
Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []
```

#### 思路

- http://www.cnblogs.com/grandyang/p/4521224.html
- http://www.cnblogs.com/yrbbest/p/4435166.html







#### 273. Integer to English Words 
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

**Example 1:**

```
Input: 123
Output: "One Hundred Twenty Three"
```

**Example 2:**

```
Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
```

**Example 3:**

```
Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
```

**Example 4:**

```
Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
```

#### 思路

- http://www.cnblogs.com/grandyang/p/4772780.html
- https://www.cnblogs.com/yrbbest/p/5031682.html





#### 32. [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/discuss/) 

Given a string containing just the characters `'('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.

**Example 1:**

```
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
```

**Example 2:**

```
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
```

#### 思路

- http://www.cnblogs.com/grandyang/p/4424731.html



#### 10. Regular Expression Matching 

Given an input string (`s`) and a pattern (`p`), implement regular expression matching with support for `'.'` and `'*'`.

```
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
```

The matching should cover the **entire** input string (not partial).

**Note:**

- `s` could be empty and contains only lowercase letters `a-z`.
- `p` could be empty and contains only lowercase letters `a-z`, and characters like `.` or `*`.

**Example 1:**

```
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

**Example 2:**

```
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
```

**Example 3:**

```
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```

**Example 4:**

```
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
```

**Example 5:**

```
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
```

#### 思路

- http://www.cnblogs.com/grandyang/p/4461713.html



#### 214. Shortest Palindrome 

Given a string **\*s***, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

**Example 1:**

```
Input: "aacecaaa"
Output: "aaacecaaa"
```

**Example 2:**

```
Input: "abcd"
Output: "dcbabcd"
```

#### 思路

- 参考思路：https://www.cnblogs.com/yrbbest/p/4982859.html
- 给一个字符串，返回最短的回文字符串。如果不是回文字符串，自己添加字符到原字符串即可
- 解法一

  - kmp思路
- 解法二

  - Suffix Array思路
  - 分别计算字符串的正向和反向的前缀数组
  - 然后遍历比较即可，记录相等前缀的最长长度
  - 其余的字符串反向即可
- 解法三
  - 双向指针
  - 直接一个头一个尾往中间移动比较字符串
  - 相比解法二，用两个指针替代了。节省空间



#### 97. [Interleaving String](https://leetcode.com/problems/interleaving-string/description/) 

Given *s1*, *s2*, *s3*, find whether *s3* is formed by the interleaving of *s1* and *s2*.

**Example 1:**

```
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
```

**Example 2:**

```
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
```

#### 思路

- 参考思路
  - http://www.cnblogs.com/grandyang/p/4298664.html
- 如何判断s3是由s2和s1相互交错而成的
- 解法一
  - dp

  - 行存放s1，列存放s2，内容存放true或false

  - s3当前的位置，由同一列的上一行或者同一行的上一列决定

  - 如果前置条件是true同时当前也可以匹配才能是true

  - ```java
    public boolean isInterleave(String s1, String s2, String s3) {
    
        if ((s1.length()+s2.length())!=s3.length()) return false;
    
        boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];
    
        matrix[0][0] = true;
    
        for (int i = 1; i < matrix[0].length; i++){
            matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }
    
        for (int i = 1; i < matrix.length; i++){
            matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }
    
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                        || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }
    
        return matrix[s2.length()][s1.length()];
    
    }
    ```
- 解法二
  - dfs
  - 感觉很烦的解法



#### 336. [Palindrome Pairs](https://leetcode.com/problems/palindrome-pairs/description/) 

Given a list of **unique** words, find all pairs of **distinct** indices `(i, j)` in the given list, so that the concatenation of the two words, i.e. `words[i] + words[j]` is a palindrome.

**Example 1:**

```
Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
```

**Example 2:**

```
Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
```

#### 思路

- 任意拼接两个字符串，如果是回文字符串，那么就作为回文字符串对
- 暴力法行不通
- 参考链接
  - http://www.cnblogs.com/grandyang/p/5272039.html
  - https://leetcode.com/problems/palindrome-pairs/discuss/79210/The-Easy-to-unserstand-JAVA-Solution
- 解法一
  - 列出可能出现的四种情况
  - 空字符串
  - 本身就回文
  - 长度为奇数的回文，但是回文的中心位置在末尾
  - 长度为奇数的回文，但是回文的中心位置在起始
  - 四次遍历

#### 76. [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/description/)

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

**Example:**

```
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
```

**Note:**

- If there is no such window in S that covers all characters in T, return the empty string `""`.
- If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

#### 思路

- 找出S的最短子字符串，其中包含T字符串的字母就行
- 个人解法
  - 用两个指针，一头一尾，先移动尾巴，一直到包围T后
  - 再移动头部，记录最短的长度就行
  - 终止条件尾巴到最后一个元素，而头部到极限位置就行了

#### 87. Scramble String 

Given a string *s1*, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of *s1* = `"great"`:

```
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
```

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node `"gr"` and swap its two children, it produces a scrambled string `"rgeat"`.

```
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
```

We say that `"rgeat"` is a scrambled string of `"great"`.

Similarly, if we continue to swap the children of nodes `"eat"` and `"at"`, it produces a scrambled string `"rgtae"`.

```
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
```

We say that `"rgtae"` is a scrambled string of `"great"`.

Given two strings *s1* and *s2* of the same length, determine if *s2* is a scrambled string of *s1*.

**Example 1:**

```
Input: s1 = "great", s2 = "rgeat"
Output: true
```

**Example 2:**

```
Input: s1 = "abcde", s2 = "caebd"
Output: false
```

#### 思路

- 题目不太懂

- 参考链接

  - https://leetcode.com/problems/scramble-string/discuss/29387/Accepted-Java-solution

- 参考代码

  - ```
        public boolean isScramble(String s1, String s2) {
            if(s1 == null || s2 == null) return false;
            if(s1.equals(s2)) return true;
            if(s1.length()!=s2.length()) return false;
            
            int[] letters = new int[26];
            int len = s1.length();
            for(int i = 0; i < len; i++){
                letters[s1.charAt(i)-'a']++;
                letters[s2.charAt(i)-'a']--;
            }
            for(int i = 0; i < 26; i++){
                if(letters[i]!= 0) return false;
            }
            
            for(int i = 1; i < len; i++){
                if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
                if(isScramble(s1.substring(0,i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0,len-i))) return true;
            }
            return false;
        }
    }
    ```



#### 591. Tag Validator 

Given a string representing a code snippet, you need to implement a tag validator to parse the code and return whether it is valid. A code snippet is valid if all the following rules hold:

1. The code must be wrapped in a **valid closed tag**. Otherwise, the code is invalid.
2. A **closed tag** (not necessarily valid) has exactly the following format : `<TAG_NAME>TAG_CONTENT</TAG_NAME>`. Among them, `<TAG_NAME>` is the start tag, and `</TAG_NAME>` is the end tag. The TAG_NAME in start and end tags should be the same. A closed tag is **valid** if and only if the TAG_NAME and TAG_CONTENT are valid.
3. A **valid** `TAG_NAME` only contain **upper-case letters**, and has length in range [1,9]. Otherwise, the `TAG_NAME` is **invalid**.
4. A **valid** `TAG_CONTENT` may contain other **valid closed tags**, **cdata** and any characters (see note1) **EXCEPT** unmatched `<`, unmatched start and end tag, and unmatched or closed tags with invalid TAG_NAME. Otherwise, the `TAG_CONTENT` is **invalid**.
5. A start tag is unmatched if no end tag exists with the same TAG_NAME, and vice versa. However, you also need to consider the issue of unbalanced when tags are nested.
6. A `<` is unmatched if you cannot find a subsequent `>`. And when you find a `<` or `</`, all the subsequent characters until the next `>` should be parsed as TAG_NAME (not necessarily valid).
7. The cdata has the following format : `<![CDATA[CDATA_CONTENT]]>`. The range of `CDATA_CONTENT` is defined as the characters between `<![CDATA[` and the **first subsequent** `]]>`.
8. `CDATA_CONTENT` may contain **any characters**. The function of cdata is to forbid the validator to parse `CDATA_CONTENT`, so even it has some characters that can be parsed as tag (no matter valid or invalid), you should treat it as **regular characters**.

**Valid Code Examples:**

```
Input: "<DIV>This is the first line <![CDATA[<div>]]></DIV>"

Output: True

Explanation: 

The code is wrapped in a closed tag : <DIV> and </DIV>. 

The TAG_NAME is valid, the TAG_CONTENT consists of some characters and cdata. 

Although CDATA_CONTENT has unmatched start tag with invalid TAG_NAME, it should be considered as plain text, not parsed as tag.

So TAG_CONTENT is valid, and then the code is valid. Thus return true.


Input: "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"

Output: True

Explanation:

We first separate the code into : start_tag|tag_content|end_tag.

start_tag -> "<DIV>"

end_tag -> "</DIV>"

tag_content could also be separated into : text1|cdata|text2.

text1 -> ">>  ![cdata[]] "

cdata -> "<![CDATA[<div>]>]]>", where the CDATA_CONTENT is "<div>]>"

text2 -> "]]>>]"


The reason why start_tag is NOT "<DIV>>>" is because of the rule 6.
The reason why cdata is NOT "<![CDATA[<div>]>]]>]]>" is because of the rule 7.
```

**Invalid Code Examples:**

```
Input: "<A>  <B> </A>   </B>"
Output: False
Explanation: Unbalanced. If "<A>" is closed, then "<B>" must be unmatched, and vice versa.

Input: "<DIV>  div tag is not closed  <DIV>"
Output: False

Input: "<DIV>  unmatched <  </DIV>"
Output: False

Input: "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"
Output: False

Input: "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"
Output: False

Input: "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"
Output: False
```

**Note:**

1. For simplicity, you could assume the input code (including the **any characters** mentioned above) only contain `letters`, `digits`, `'<'`,`'>'`,`'/'`,`'!'`,`'['`,`']'` and `' '`.

#### 思路



#### 115. [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/description/) 

Given a string **S** and a string **T**, count the number of distinct subsequences of **S** which equals **T**.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, `"ACE"` is a subsequence of `"ABCDE"` while `"AEC"` is not).

**Example 1:**

```
Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
```

**Example 2:**

```
Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
```

 

#### 思路

- 个人解法：dp

  - 行代表S，列代表T，内容代表能匹配的个数
  - 每一个内容的位置如果匹配要加上前一列的内容并加1，否则直接加上前一列。然后还要加上上一行的内容。否则不加。

- 正确解法

  - 其实上述解法已经接近正确答案了。

  - 递推方面，想要对第一行和第一列做初始化

  - 然后从左向右推进的时候，要考虑是否匹配，如果不匹配可以直接赋值上一列，如果匹配就还要加上上一列上一行位置的次数即可。

  - ```
    class Solution {
    public:
        int numDistinct(string s, string t) {
            int m = t.length(), n = s.length();
            vector<vector<int>> dp(m + 1, vector<int> (n + 1, 0));
            for (int j = 0; j <= n; j++) dp[0][j] = 1;
            for (int j = 1; j <= n; j++)
                for (int i = 1; i <= m; i++)
                    dp[i][j] = dp[i][j - 1] + (t[i - 1] == s[j - 1] ? dp[i - 1][j - 1] : 0);
            return dp[m][n];
        }
    };  
    ```



#### 72. [Edit Distance](https://leetcode.com/problems/edit-distance/description/) 

Given two words *word1* and *word2*, find the minimum number of operations required to convert *word1* to *word2*.

You have the following 3 operations permitted on a word:

1. Insert a character
2. Delete a character
3. Replace a character

**Example 1:**

```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

**Example 2:**

```
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

#### 思路

- dp
  - https://www.cnblogs.com/higerzhang/p/4098614.html
  - 三种情况
  - 行代表WORD1，列代表WORD2,内容代表距离
  - 只有2比1短的时候需要添加字符串，只有2比1长的时候需要减少字符串
  - 所以第一行和第一列可以直接初始化
  - 剩下的根据三种情况直接找最短的距离，三个位置，左上角，上方和左方
  - 相等的情况直接等于左上角



#### 730. Count Different Palindromic Subsequences 

Given a string S, find the number of different non-empty palindromic subsequences in S, and **return that number modulo 10^9 + 7.**

A subsequence of a string S is obtained by deleting 0 or more characters from S.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences `A_1, A_2, ...` and `B_1, B_2, ...` are different if there is some `i` for which `A_i != B_i`.

**Example 1:**

```
Input: 
S = 'bccb'
Output: 6
Explanation: 
The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.
```

**Example 2:**

```
Input: 
S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
Output: 104860361
Explanation: 
There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
```

**Note:**

The length of `S` will be in the range `[1, 1000]`.

Each character `S[i]` will be in the set `{'a', 'b', 'c', 'd'}`.

#### 思路

- 找出字符串有多少种回文字符串
- 参考链接：http://www.cnblogs.com/grandyang/p/7942040.html



#### 899. Orderly Queue 

#### 思路



#### 632. [Smallest Range](https://leetcode.com/problems/smallest-range/description/) 

You have `k` lists of sorted integers in ascending order. Find the **smallest** range that includes at least one number from each of the `k`lists.

We define the range [a,b] is smaller than range [c,d] if `b-a < d-c` or `a < c` if `b-a == d-c`.

**Example 1:**

```
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
```

**Note:**

1. The given list may contain duplicates, so ascending order means >= here.
2. 1 <= `k` <= 3500
3. -105 <= `value of elements` <= 105.
4. **For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.**

#### 思路



#### 761. [Special Binary String](https://leetcode.com/problems/special-binary-string/description/) 

*Special* binary strings are binary strings with the following two properties:

The number of 0's is equal to the number of 1's.

Every prefix of the binary string has at least as many 1's as 0's.

Given a special string `S`, a *move* consists of choosing two consecutive, non-empty, special substrings of `S`, and swapping them. *(Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.)*

At the end of any number of moves, what is the lexicographically largest resulting string possible?

**Example 1:**

```
Input: S = "11011000"
Output: "11100100"
Explanation:
The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.
```

**Note:**

1. `S` has length at most `50`.
2. `S` is guaranteed to be a *special* binary string as defined above.

#### 思路



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

  





思路







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


