// this is also called as evaluate given expression to true or false
// means we are given string expression such as 'True or False and True'
// so we need to find the minimum number of brackets to make the expression true always

public class BooleanParenthesiation {

    // the parameter expected is passed which is used to indicate what we wan tform
    // the expression
    // as if there is 'xor' operator then we need both true and false on left and
    // right side
    // so we pass true on one side and false on the other side
    // just as in case of 'or' we need either of them to be true

    public static int minParenthesis(String[] expression, int i, int j, int[][] dp, Boolean expected) {
        int min = Integer.MAX_VALUE;
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (expected == true) {
                return expression[i].equals("True") ? 0 : 1;
            } else {
                return expression[i].equals("False") ? 0 : 1;
            }
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        for (int k = i + 1; k < j; k += 2) {
            int count = 0;
            int leftTrue = minParenthesis(expression, i, k - 1, dp, true);
            int leftFalse = minParenthesis(expression, i, k - 1, dp, false);
            int rightTrue = minParenthesis(expression, k + 1, j, dp, true);
            int rightFalse = minParenthesis(expression, k + 1, j, dp, false);
            if (expression[k] == "and") {
                if (expected == true) {
                    count += leftTrue * rightTrue;
                } else {
                    count += leftFalse * rightFalse + rightFalse * leftTrue + leftTrue * rightFalse;
                }
            } else if (expression[k] == "or") {
                if (expected == true) {
                    count += leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
                } else {
                    count += leftFalse * rightFalse + rightFalse * leftTrue + rightTrue * leftFalse;
                }
            } else if (expression[k] == "xor") {
                if (expected == true) {
                    count += leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    count += leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
            if (count < min) {
                min = count;
            }
            dp[i][j] = min;
        }

        return dp[i][j];

    }

    public static void main(String[] args) {
        String expr = "True or False and False";
        String[] expression = expr.split(" ");
        int[][] dp = new int[expression.length][expression.length];
        for (int i = 0; i < expression.length; i++) {
            for (int j = 0; j < expression.length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(minParenthesis(expression, 1, expression.length - 1, dp, true));

    }
}
