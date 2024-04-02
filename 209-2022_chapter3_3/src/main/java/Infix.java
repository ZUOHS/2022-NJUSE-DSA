import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infix {
    public float infix(String[] tokens) {
        Stack<String> postfix = inTOpo(tokens);
        System.out.println(postfix);
        Stack<String> realPo = new Stack<>();
        while (!postfix.empty()) {
            realPo.push(postfix.pop());
        }
        return calculate(realPo);
    }

    public Stack<String> inTOpo(String [] tokens) {

        Stack<String> stack = new Stack<>();
        Stack<String> res = new Stack<>();

        Pattern p = Pattern.compile("\\d");

        for (String c : tokens) {
            Matcher m = p.matcher(c + "");

            if (m.find()) {
                res.push(c + "");
                continue;
            }

            if (Objects.equals(c, "+") || Objects.equals(c, "-") || Objects.equals(c, "*")
                    || Objects.equals(c, "/") || Objects.equals(c, "(")) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                } else {
                    boolean flag = true;
                    while (flag) {
                        if (stack.isEmpty() || conLevel(c) > conLevel(stack.peek()) || Objects.equals(stack.peek(), "(")) {
                            stack.push(c);
                            flag = false;
                            continue;
                        }

                        if (conLevel(c) <= conLevel(stack.peek())) {
                            res.push("" + stack.pop());
                        }
                    }
                }
            }
            if (Objects.equals(c, ")")) {
                while (!Objects.equals(stack.peek(), "(")) {
                    res.push("" + stack.pop());
                }
                stack.pop();
                continue;
            }
        }

        while (!stack.isEmpty()){

            res.push("" + stack.pop());
        }

        return res;
    }

    public static int conLevel (String  c) {
        if (Objects.equals(c, "+") || Objects.equals(c, "-")) {
            return 1;
        } else if (Objects.equals(c, "*") || Objects.equals(c, "/")) {
            return 2;
        } else if (Objects.equals(c, "(")) {
            return 3;
        } else if (Objects.equals(c, ")")) {
            return 0;
        } else {
            return -1;

        }
    }

    public static float calculate(Stack<String> toCal) {
        Stack<Float> stack = new Stack<>();
        while(!toCal.empty()) {
            if (! isOp(toCal.peek())) {
                stack.push(Float.parseFloat(toCal.pop()));
            } else {
                float num2 = stack.pop();
                float num1 = stack.pop();
                float res = 0;
                if (Objects.equals(toCal.peek(), "+")) {
                    res = num1 + num2;
                } else if (Objects.equals(toCal.peek(), "-")) {
                    res = num1 - num2;
                } else if (Objects.equals(toCal.peek(), "*")) {
                    res = num1 * num2;
                } else if (Objects.equals(toCal.peek(), "/")) {
                    res = (float) (num1 * 1.0 / num2);
                }
                toCal.pop();
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public static boolean isOp(String s) {
        return Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/");
    }

}