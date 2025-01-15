public class Divide implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Divide(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        int rightValue = rightExpression.interpret();
        if (rightValue == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return leftExpression.interpret() / rightValue;
    }
}
