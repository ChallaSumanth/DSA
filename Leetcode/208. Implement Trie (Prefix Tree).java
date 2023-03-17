class TrieNode{
    TrieNode [] node = null;
    boolean flag = false;
    TrieNode(){
        node = new TrieNode[26];
    }
    boolean containsKey(char ch)
    {
        return (node[ch - 'a'] != null);
    }
    void put(char ch, TrieNode n)
    {
        node[ch - 'a'] = n;
    }
    TrieNode get(char ch)
    {
        return node[ch - 'a'];
    }
    void setEnd()
    {
        flag = true;
    }
    boolean isEnd()
    {
        return flag;
    }
}
class Trie {

    TrieNode root = null;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(!node.containsKey(word.charAt(i)))
                node.put(word.charAt(i), new TrieNode());
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        if(node.isEnd()) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
         boolean flag = true;
         TrieNode node = root;
         for(int i = 0; i < prefix.length(); i++)
         {
             if(!node.containsKey(prefix.charAt(i)))
                    return false;
             node = node.get(prefix.charAt(i));
         }
         return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */