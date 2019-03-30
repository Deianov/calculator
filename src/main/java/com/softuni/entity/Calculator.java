package com.softuni.entity;

public class Calculator {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public double getLeftOperand() { return leftOperand; }
    public double getRightOperand() { return rightOperand; }
    public String getOperator() { return operator; }

    public Calculator(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public Calculator() {
    }

    public double calculateResult() {
        switch (this.operator) {
            case "+":
                return this.leftOperand + this.rightOperand;
            case "-":
                return this.leftOperand - this.rightOperand;
            case "*":
                return this.leftOperand * this.rightOperand;
            case "/":
                return this.rightOperand == 0 ? 0 : this.leftOperand / this.rightOperand;
            default:
                return 0;
        }
    }
}
