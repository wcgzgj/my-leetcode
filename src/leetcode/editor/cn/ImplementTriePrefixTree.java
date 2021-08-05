 //Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
// 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 826 👎 0

  package leetcode.editor.cn;

 import java.util.Arrays;

 public class ImplementTriePrefixTree {

      public static void main(String[] args) {
          Trie trie = new ImplementTriePrefixTree().new Trie();
          trie.insert("apple");
          System.out.println(trie.search("apple"));
          System.out.println(trie.search("app"));
          System.out.println(trie.startsWith("app"));
          System.out.println(trie.startsWith("appled"));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Trie {
          /**
           * Trie 节点的数据结构如下
           * Trie {
           *     private Trie[] children;
           *     private boolean isEnd;
           * }
           */
      private Trie[] children;
      private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children=new Trie[26];
        isEnd=false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        // 将当前对象作为根节点
        Trie node = this;
        if (word==null || word.length()==0) return;
        for (int i = 0; i < word.length(); i++) {
            // 将字符的信息，转换为下标的信息
            int charIndex = word.charAt(i) - 'a';
            if (node.children[charIndex]==null) {
                node.children[charIndex]=new Trie();
            }
            node=node.children[charIndex];
        }
        // 插入到最后位置的字符，要标注 isEnd
        node.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = find(word);
        if (trie==null) return false;
        return trie.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = find(prefix);
        return trie!=null;
    }

  /**
   * 我们需要自己去写一个工具函数
   * 这和函数的作用，是去查找传入的字符串的最后一个字符所在的节点
   * 如果没有该字符串，则返回 null
   * @param word
   * @return
   */
    public Trie find(String word) {
        Trie node = this;
        if (word==null || word.length()==0) return null;
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a';
            if (node.children[charIndex]==null) return null;
            node=node.children[charIndex];
        }
        return node;
    }

          @Override
          public String toString() {
              return "Trie{" +
                      "children=" + Arrays.toString(children) +
                      ", isEnd=" + isEnd +
                      '}';
          }
      }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }
