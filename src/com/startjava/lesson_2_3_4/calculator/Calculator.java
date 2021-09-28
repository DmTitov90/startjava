package com.startjava.lesson_2_3_4.calculator;

class Calculator {

    private double firstNumber;
    private String sign;
    private double secondNumber;

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getSign() {
        return sign;
    }

    public boolean setSign(String sign) {
        if ("+".equals(sign) || "-".equals(sign) || "*".equals(sign) ||
                "/".equals(sign) || "^".equals(sign) || "%".equals(sign)) {
            this.sign = sign;
            return true;
        }
        return false;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double calculate() {
        return switch (sign) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            case "^" -> {
                double result = 1;
                for (int i = 1; i <= secondNumber; i++) {
                    result *= firstNumber;
                }
                yield result;
            }
            case "%" -> firstNumber % secondNumber;
            default -> 0.0;
        };
    }
}
