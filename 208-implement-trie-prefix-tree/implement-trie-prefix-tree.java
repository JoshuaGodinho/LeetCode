/*
create array[26]
insert()
iterate through each letter
if letter already exists, then add 

*/
class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode(){
        children=new TrieNode[26];
        isEndOfWord=false;
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node=root;
        for(char c: word.toCharArray())
        {
            int idx=c-'a';
            if(node.children[idx]==null)
            {
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];
        }
        node.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        TrieNode node=searchNode(word);
        return node!=null && node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        return searchNode(prefix)!=null;
    }

    private TrieNode searchNode(String word)
    {
        TrieNode node=root;
        for(char c:word.toCharArray())
        {
            int idx=c-'a';
            if(node.children[idx]==null)    return null;
            node=node.children[idx];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */