import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expression to evaluate: ");
        String expression = scanner.nextLine();

        double result = evaluateExpression(expression);
        System.out.printf("%s = %.1f\n", expression, result);

        scanner.close();
    }

    public static double evaluateExpression(String expression) {
        ExamStack<Double> operandStack = new ExamStack<>();
        ExamStack<Character> operatorStack = new ExamStack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                /*// Extract the whole number if the operand has more than one digit
                int j = i;
                while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                    j++;
                }
                String numStr = expression.substring(i, j);
                double operand = Double.parseDouble(numStr);
                operandStack.push(operand);
                i = j - 1; // Update i to the end of the number */
                String str = expression.substring(i,i+1);
                double operand = Double.parseDouble(str);
                operandStack.push(operand);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (operatorStack.peep() != '(') {
                    performOperation(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop '(' from the operator stack
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operatorStack.getSize() != 0 && precedence(operatorStack.peep()) >= precedence(ch)) {
                    performOperation(operandStack, operatorStack);
                }
                operatorStack.push(ch);
            }
        }

        while (operatorStack.getSize() != 0) {
            performOperation(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    private static void performOperation(ExamStack<Double> operandStack, ExamStack<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        double result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }

        operandStack.push(result);
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}