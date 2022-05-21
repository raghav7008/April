/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String n = "X";
    String s = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }
    public void build(TreeNode root, StringBuilder sb){
        if(root == null)    sb.append(n).append(s);
        else{
            sb.append(root.val).append(s);
            build(root.left,sb);
            build(root.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(data.split(s)));
        return build(dq);
    }
    public TreeNode build(Deque<String> dq){
        String temp = dq.remove();
        if(temp.equals(n))  return null;
        else{
            TreeNode t = new TreeNode(Integer.valueOf(temp));
            t.left = build(dq);
            t.right = build(dq);
            return t;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));