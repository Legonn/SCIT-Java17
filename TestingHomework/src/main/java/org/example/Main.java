package org.example;

public class Main {
    public static void main(String[] args) {
        
    }

    public static String calculator(String calculus) {
        String[] operands = calculus.split("[-+]");
        int sum = parseMetricDistance(operands[0]);
        for (int i = 1; i < operands.length; i++) {
            int value = parseMetricDistance(operands[i]);
            char operator;
            for (int j=0;j<calculus.length();j++){
                if (calculus.charAt(j)=='+'){
                    sum +=value;
                    calculus=calculus.substring(j+1);
                    break;
                } else if (calculus.charAt(j)=='-') {
                    sum-=value;
                    calculus=calculus.substring(j+1);
                    break;
                }

            }

        }
        return sum +" mm";
    }


    public static int parseMetricDistance(String component) {
        if (component.isBlank()){
            return 0;
        }
        int value = Integer.parseInt(component.replaceAll("\\D", ""));
        String unit = component.replaceAll("\\d", "").toLowerCase();
        unit = unit.trim();
        switch (unit) {
            case "mm":
                return value;
            case "cm":
                return value * 10;
            case "dm":
                return value * 100;
            case "m":
                return value * 1000;
            case "km":
                return value * 1000000;
            default:
                System.out.println("Invalid Scale");
                return 0;
        }
    }
}

