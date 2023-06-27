package stack;

import java.util.*;

public class PostfixCalculator {
    private static final Map<String, Integer> OPERATOR_PRECEDENCE;

    static {
        OPERATOR_PRECEDENCE = new HashMap<>();
        OPERATOR_PRECEDENCE.put("add", 1);
        OPERATOR_PRECEDENCE.put("sub", 1);
        OPERATOR_PRECEDENCE.put("mul", 2);
        OPERATOR_PRECEDENCE.put("div", 2);
        OPERATOR_PRECEDENCE.put("mod", 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix expression: ");
        String infixExpression = sc.nextLine();

        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);

        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperand(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isOperand(String token) {
        return !isOperator(token) && !isParenthesis(token);
    }

    private static boolean isOperator(String token) {
        return OPERATOR_PRECEDENCE.containsKey(token);
    }

    private static boolean isParenthesis(String token) {
        return token.equals("ob") || token.equals("cb");
    }

    private static int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "add":
                return operand1 + operand2;
            case "sub":
                return operand1 - operand2;
            case "mul":
                return operand1 * operand2;
            case "div":
                return operand1 / operand2;
            case "mod":
                return operand1 % operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static String infixToPostfix(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();

        String[] tokens = infixExpression.split(" ");
        for (String token : tokens) {
            if (isOperand(token)) {
                postfixExpression.append(token);
                postfixExpression.append(' ');
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("ob") && hasHigherPrecedence(operatorStack.peek(), token)) {
                    postfixExpression.append(operatorStack.pop());
                    postfixExpression.append(' ');
                }
                operatorStack.push(token);
            } else if (token.equals("ob")) {
                operatorStack.push(token);
            } else if (token.equals("cb")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("ob")) {
                    postfixExpression.append(operatorStack.pop());
                    postfixExpression.append(' ');
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().equals("ob")) {
                    operatorStack.pop();
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop());
            postfixExpression.append(' ');
        }

        return postfixExpression.toString().trim();
    }

    private static boolean hasHigherPrecedence(String operator1, String operator2) {
        return getPrecedence(operator1) >= getPrecedence(operator2);
    }

    private static int getPrecedence(String operator) {
        switch (operator) {
            case "add":
            case "sub":
                return 1;
            case "mul":
            case "div":
            case "mod":
                return 2;
            case "ob":
            case "cb":
                return 0;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}