public class TowerOfHanoi {
    public void Hanoi(int n) {
        // please enter your code here...
        Move("A", "B", "C", 1, n);
    }

    public void Move(String from, String to, String temp, int left, int right) {
        if (left == right) {
            System.out.print("Move disk " + left + " from " + from + " to " + to + "\n");
        } else {
            Move(from, temp, to, left, right - 1);
            Move(from, to, temp, right, right);
            Move(temp, to, from, left, right - 1);
        }
    }

//    public static void main(String[] args) {
//        Hanoi(10);
//    }

}
