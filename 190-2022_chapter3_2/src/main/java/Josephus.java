//此oj需要手动引入工具类，直接用会报“编译或运行失败”，如需要用ArrayList，需要手动引入，
//如：import java.util.ArrayList;

//只测试了暴力求解和公式法，都是可以通过的，测试用例比较少，不用担心；
//常见的问题都给了注释，还遇到bug找群里的小伙伴交流一下。

public class Josephus {
    public static int lastRemaining(int n, int m) {//不要更改这里的static修饰符
        // 具体代码写这里
		
		// 另外因为语言级别的问题，菱形操作符里的具体类型全部要写上，不然可能也会报错；
		// 如：ArrayList<Integer> list = new ArrayList<Integer>(n);
        Node start = new Node(0);
        Node position = start;
        for (int i = 1; i < n; i++) {
            Node temp = new Node(i);
            position.next = temp;
            temp.last = position;
            position = position.next;
        }
        position.next = start;
        start.last = position;
        position = start;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < m; j++) {
                position = position.next;
            }
            position.last.next = position.next;
            position.next.last = position.last;
            position = position.next;
        }
		
        return position.num;//这里return自己的结果
    }
}

