package magnbred.calculator.model;

public class Calculation {

    private double a;
    private double b;
    private String operation;
    private String answer;

    public Calculation(){}

    public Calculation(double a, double b, String operation, String answer) {
        this.a = a;
        this.b = b;
        this.operation = operation;
        this.answer = answer;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "a=" + a +
                ", b=" + b +
                ", operator='" + operation + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
