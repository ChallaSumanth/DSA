class Node
{
    Node [] node = null;
    boolean flag;
    Node()
    {
        node = new Node[26];
    }
    boolean containsKey(char ch)
    {
        return node[ch - 'a'] != null;
    }
    void put(char ch, Node n)
    {
        node[ch - 'a'] = n;
    }
    Node get(char ch)
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
class WordDictionary {
    Node root = null;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
       return searchHelper(word, 0 , root);
    }
    private boolean searchHelper(String word, int string_index, Node root)
    {
        if(string_index == word.length())
            return root.isEnd();
        char ch = word.charAt(string_index);
        if(ch == '.')
        {
            for(int i = 0; i < 26; i++)
            {
                if(root.node[i] != null && searchHelper(word, string_index + 1, root.node[i]))
                    return true;
            }
        }
        else
        {
            int idx = ch - 'a';
            if(root.node[idx] != null && searchHelper(word, string_index + 1, root.node[idx]))
                return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */