package ru.psb.resultMatch;

import java.util.InputMismatchException;

public class CountingResultMatch {
    public static ResultMatch countingResultMatch(String str, char separationBrackets) {
        ResultMatch resultMatch = new ResultMatch();
        int crntFirstResult = 0;
        int crntSecondResult = 0;
        int countBrackets = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != separationBrackets) {
                continue;
            } else {
                countBrackets++;
                int lastDigit = str.indexOf(':', i);
                if (lastDigit == -1) throw new InputMismatchException();
                crntFirstResult = Integer.parseInt(str.substring(i + 1, lastDigit));

                i = lastDigit; // смотрит на :
                lastDigit = str.indexOf(separationBrackets, i);
                if (lastDigit == -1) throw new InputMismatchException();
                crntSecondResult = Integer.parseInt(str.substring(i + 1, lastDigit));
                i = lastDigit;

                if (crntFirstResult > crntSecondResult) {
                    resultMatch.changeResultFirst(3);
                } else if (crntFirstResult < crntSecondResult) {
                    resultMatch.changeResultSecond(3);
                } else {
                    resultMatch.changeResultFirst(1);
                    resultMatch.changeResultSecond(1);
                }
            }
        }
        if(countBrackets == 0) throw new InputMismatchException();
        return resultMatch;
    }
}
