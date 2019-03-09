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


