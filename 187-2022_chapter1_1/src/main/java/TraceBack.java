import java.util.HashSet;

public class TraceBack {

    public HashSet<HashSet<Integer>> traceBack(int n, int k){
//      please enter your code here...
        HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>>();
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        cal(result, a, n, k, 0);

        return result;
    }

    public void cal(HashSet<HashSet<Integer>> result, int [] a, int n, int k, int start) {
        if (n == k) {
            HashSet<Integer> temp = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                temp.add(a[i + start]);
            }
            result.add(temp);
        } else {
            for (int i = 0; i < n; i++) {
                int temp = a[start];
                a[start] = a[start + i];
                a[start + i] = temp;
                cal(result, a, n - 1, k, start + 1);
                a[start + i] = a[start];
                a[start] = temp;
            }
        }
    }

}
