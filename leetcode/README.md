## 参考链接

- http://bookshadow.com/weblog/2016/04/19/leetcode-integer-break/
- https://blog.csdn.net/qq508618087/article/details/50394131
- 



## 算法思路归纳

- 要啃就啃硬骨头



## 动态规划

### 思路总结



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

- 难点，先搞定怎么划分，再来找最大的一组划分数
- 查阅资料：四平方和定理
  - 4^k*(8*m + 7)，满足这个公式即可
- 题目要求是只需要返回个数即可
- 分类：1，2，3，4
- 1的时候说明是数本身可以开平方
- 4说明满足四平方和定理
- 不满足四平方和定理的话就考虑
- Legendre's three-square theorem
  - ![n=x^{2}+y^{2}+z^{2}](https://wikimedia.org/api/rest_v1/media/math/render/svg/d21f8b668e4450e588abd892ed19cae7e2b61835) 
- 

