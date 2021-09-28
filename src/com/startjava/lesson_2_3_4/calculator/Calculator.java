package com.startjava.lesson_2_3_4.calculator;

class Calculator {

    private double firstNumber;
    private String sign;
    private double secondNumber;

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void split(String mathString){
        int pos = 0;
        String[] mathSplit = mathString.split(" ");
        for (String mathSplits : mathSplit ) {
            mathSplit [pos++] = mathSplits;
        }
        firstNumber = Integer.parseInt(mathSplit[0]);
        sign = mathSplit[1];
        secondNumber = Integer.parseInt(mathSplit[2]);
    }

    public boolean testSign(){
        if ("+".equals(sign) || "-".equals(sign) || "*".equals(sign) ||
                "/".equals(sign) || "^".equals(sign) || "%".equals(sign)) {
            return true;
        }
        return false;
    }

    public double calculate() {
        return switch (sign) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            case "^" -> Math.pow(firstNumber, secondNumber);
            case "%" -> Math.IEEEremainder(firstNumber, secondNumber);
            default -> 0.0;
        };
    }
}
