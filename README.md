# NeetCode 150 Java Solutions

Welcome to my **NeetCode 150 Solutions** repository! 🎯 This repository contains my solutions to the popular [NeetCode 150](https://neetcode.io/) problem list, covering essential topics for technical interviews such as arrays, strings, linked lists, trees, dynamic programming, and more.

---

## 📌 What is NeetCode 150?

The NeetCode 150 is a carefully curated list of 150 LeetCode problems designed to help you master data structures and algorithms for technical interviews. It’s structured by topic and difficulty, making it an excellent resource for systematic learning.

---
## 📂 Topics Overview

### 1. 🧮 Arrays & Hashing
- **Key Skills:** HashMap, HashSet, frequency counter, sliding window
- **Must Know:**
  - Time complexity of common operations
  - When to use `Set` vs `Map`
  - Sliding window pattern for subarrays

---

### 2. 🚶‍♂️ Two Pointers
- **Use Case:** Solving problems with sorted arrays or finding pairs
- **Essential Tips:**
  - One pointer starts from beginning, other from end
  - Avoid extra space — great for in-place solutions
  - Used in:
    - Merging sorted arrays
    - Removing duplicates
    - Finding palindromes

---

### 3. 🔁 Sliding Window
- **Use Case:** Finding subarrays that satisfy a condition (sum, max, min)
- **Key Ideas:**
  - Fixed size vs variable size window
  - Avoid recomputation — update window as you slide
  - Important for optimizing time to `O(n)`

---

### 4. 📐 Binary Search
- **Use Case:** Search problems on sorted data
- **Core Ideas:**
  - Always think of `low`, `mid`, `high`
  - Binary search can be applied on the answer (search space)
  - Watch out for overflow: `mid = low + (high - low) // 2`

---

### 5. 🧷 Linked List
- **Use Case:** Dynamic memory allocation, pointer manipulation
- **Must Know:**
  - Use dummy node to simplify code
  - Be cautious of null pointers
  - Learn reversing a linked list (both iterative and recursive)

---

### 6. 🧠 Dynamic Programming (DP)
- **Use Case:** Optimal substructure problems like Fibonacci, knapsack
- **Strategy:**
  - Identify overlapping subproblems
  - Use recursion + memoization or bottom-up tabulation
  - Think about state: `dp[i]` means what?

---

### 7. 📏 Intervals
- **Use Case:** Calendar scheduling, merging ranges
- **Tips:**
  - Always sort intervals by start time
  - Merge by comparing `current.end` vs `next.start`
  - Greedy is often useful

---

### 8. 🌲 Binary Trees
- **Use Case:** Tree traversal, manipulation, recursion
- **Core Patterns:**
  - Preorder, Inorder, Postorder (DFS)
  - Level Order (BFS)
  - Use stack for DFS, queue for BFS

---

### 9. 🌐 Graphs
- **Use Case:** Networks, pathfinding
- **Key Concepts:**
  - BFS for shortest path (unweighted)
  - DFS for connectivity
  - Use adjacency list for efficiency
  - Detect cycles, topological sort

---

### 10. 📊 Heap / Priority Queue
- **Use Case:** Kth largest, sorting on-the-fly
- **Things to Know:**
  - Min-heap and max-heap
  - `PriorityQueue` in Java or `heapq` in Python
  - Keep size small with `heapq.heappushpop`

---

### 11. 🔁 Backtracking
- **Use Case:** Permutations, combinations, constraint problems
- **Tips:**
  - Try → Recurse → Undo
  - Prune paths early for optimization
  - Use visited/used arrays

---

### 12. 🧮 Bit Manipulation
- **Use Case:** Efficient toggling, checking states
- **Important Techniques:**
  - `x ^ x = 0` (XOR)
  - Shift operators `<<`, `>>`
  - Check bit: `(n & (1 << i))`

---

### 13. 🏗️ Stack / Monotonic Stack
- **Use Case:** Next greater element, valid parentheses
- **Key Notes:**
  - Store indices for range-related problems
  - Useful in histogram, stock span
  - Be careful with decreasing vs increasing stack

---

### 14. 🌀 Tries
- **Use Case:** Prefix searching, autocomplete
- **Concepts:**
  - Tree-like structure of characters
  - Each node is a character; edge is prefix
  - Useful for `startsWith`, `search`

---

### 15. 📐 Greedy
- **Use Case:** Making the best local choice for optimal global result
- **Core Idea:**
  - Works when the problem has a "greedy-choice property"
  - Examples: Jump Game, Activity Selection, Gas Station

---

## 🚀 Getting Started

1. Fork this repo 🍴
2. Solve problems one by one ✍️
3. Track your progress 📈
4. Learn patterns, not just solutions 💡

---

## 🤝 Contributions

Feel free to open issues or pull requests for:
- Improvements
- Adding solutions in other languages
- Better explanations

---

## 📌 Credits

- Inspired by [NeetCode.io](https://neetcode.io/)
- Built to improve problem-solving skills & prepare for coding interviews

---
