public class PolynList {

    //多项式相加
    public Node add(Node link1, Node link2) {
        Node pa = link1.next;
        Node pb = link2.next;
        Node p = new Node();
        Node pc = p;
        if (pa == null) {
            return pb;
        } else if (pb == null) {
            return pa;
        }
        int ready = 0;
        while(true) {
            if (pa == null && pb == null) {
                break;
            } else if (pa == null) {
                pc.next = pb;
                break;
            } else if (pb == null) {
                pc.next = pa;
                break;
            } else if (pa.exp == pb.exp) {
                pa.coef += pb.coef;
                pb = pb.next;
                if (pa.coef != 0) {
                    if (ready == 0) {
                        p.next = pa;
                        pc = pa;
                        ready = 1;
                    } else {
                        pc.next = pa;
                        pc = pc.next;
                    }
                }
                pa = pa.next;
            } else if (pa.exp < pb.exp) {
                if (ready == 0) {
                    p.next = pa;
                    pc = pa;
                    ready = 1;
                } else {
                    pc.next = pa;
                    pc = pc.next;
                }
                pa = pa.next;
            } else {
                if (ready == 0) {
                    p.next = pb;
                    pc = pb;
                    ready = 1;
                } else {
                    pc.next = pb;
                    pc = pc.next;
                }
                pb = pb.next;
            }
        }
        return p.next;
   }
}
