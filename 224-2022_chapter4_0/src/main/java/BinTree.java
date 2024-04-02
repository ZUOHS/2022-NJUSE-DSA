//此oj需要手动引入工具类，直接用会报“编译或运行失败”，如需要用ArrayList，需要手动引入，
//如：import java.util.ArrayList;

public class BinTree {
    private char element;
    BinTree left, right;

    public BinTree() {
    }

    BinTree(char element, BinTree left, BinTree right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    /**
     * 使用递归方法，根据先序遍历和中序遍历结果，创建一棵二叉树
     * @param pres 先序遍历字符数组
     * @param ins 中序遍历字符数组
     * @Example
     *      BinTree root = BinTree.CreateBT("BDACEGFHI", "DBAEGCHFI");
     */
    public static BinTree CreateBT(char[] pres, char[] ins){
        // please enter your code here...
        int len = pres.length;
        if (len == 0) {
            return null;
        }
        int leftlen = 0;
        int rightlen = 0;
        for (int i = 0; i < len; i++) {
            if (ins[i] == pres[0]) {
                leftlen = i;
                rightlen = len - i - 1;
                break;
            }
        }
        char [] leftpres = new char[leftlen];
        char [] leftins = new char[leftlen];
        char [] rightpres = new char[rightlen];
        char [] rightins = new char[rightlen];
        for (int i = 0; i < leftlen; i++) {
            leftpres[i] = pres[i + 1];
            leftins[i] = ins[i];
        }
        for (int i = 0; i < rightlen; i++) {
            rightpres[i] = pres[i + leftlen + 1];
            rightins[i] = ins[i + leftlen + 1];
        }

        BinTree result = new BinTree(pres[0], null, null);
        result.left = CreateBT(leftpres, leftins);
        result.right = CreateBT(rightpres, rightins);
        return result;
    }



    /**
     * 使用递归方法，先序遍历二叉树
     * @param root  当前树
     * @return  遍历后的序列
     * @Example
     *      BinTree.PreOrderTraversal(root)
     */
    public static StringBuilder PreOrderTraversal(BinTree root) {
        // please enter your code here...

        if (root == null) {
            return new StringBuilder("");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.element);
        sb.append(PreOrderTraversal(root.left));
        sb.append(PreOrderTraversal(root.right));
        return sb;
    }

    /**
     * 使用递归方法，中序遍历二叉树
     * @param root  当前树
     * @return  遍历后的序列
     * @Example
     *      BinTree.InOrderTraversal(root)
     */
    public static StringBuilder InOrderTraversal(BinTree root) {
        // please enter your code here...
        if (root == null) {
            return new StringBuilder("");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(InOrderTraversal(root.left));
        sb.append(root.element);
        sb.append(InOrderTraversal(root.right));
        return sb;
    }

    /**
     * 使用递归方法，后序遍历二叉树
     * @param root  当前树
     * @return  遍历后的序列
     * @Example
     *      BinTree.PostOrderTraversal(root)
     */
    public static StringBuilder PostOrderTraversal(BinTree root) {
        // please enter your code here...
        if (root == null) {
            return new StringBuilder("");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PostOrderTraversal(root.left));
        sb.append(PostOrderTraversal(root.right));
        sb.append(root.element);
        return sb;
    }

}