//1.Naive
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        for(String word : words)
        {
            if(check(word,set))
                ans.add(word);
        }
      return ans;
    }
    private boolean check(String word,Set<String> set)
    {
        for(int i=1;i<word.length();i++)
        {
            String left = word.substring(0,i);
            String right = word.substring(i);
            if(set.contains(left))
            {
                if(set.contains(right) || check(right,set))
                    return true;
            }
        }
        return false;
    }
}
//2.using Trie
class TrieNode
{
    TrieNode [] node = null;
    boolean isEnd = false;
    TrieNode(){
        node = new TrieNode[26];
    }
    public boolean containsKey(char ch)
    {
        return (node[ch - 'a']!=null);
    }
    public TrieNode get(char ch)
    {
        return node[ch - 'a'];
    }
    public void put(char ch,TrieNode Node)
    {
        node[ch - 'a'] = Node;
    }
    public void setEnd()
    {
        isEnd = true;
    }
}
class Trie
{
    TrieNode root = null;
    Trie(){
        root = new TrieNode();
    }
    public void insert(String word)
    {
        TrieNode node = root;
        int count = 0;
        for(int i = 0 ; i < word.length() ; i++)
        {
            if(!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i),new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean checkIfConcatinated(String word,int index,int count)
    {
        if(index == word.length())
        {
            return count >= 2;
        }
        TrieNode node = root;
        for(;index<word.length();index++)
        {
            if(!node.containsKey(word.charAt(index)))
                return false;
            node = node.get(word.charAt(index));
            if(node.isEnd && checkIfConcatinated(word,index+1,count+1))
                return true;
        }
        return false;
    }
}
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Trie obj = new Trie();
        for(String word : words)
            obj.insert(word);
        for(String word : words)
        {
             if(obj.checkIfConcatinated(word,0,0))
                ans.add(word);
        }
        return ans;
    }
}