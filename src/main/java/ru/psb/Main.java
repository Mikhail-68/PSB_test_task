package ru.psb;

import ru.psb.resultMatch.CountingResultMatch;
import ru.psb.resultMatch.ResultMatch;

public class Main {

    public static void main(String[] args) {
        ResultMatch resultMatch = CountingResultMatch.countingResultMatch("'1:2', '23:5')", '\'');
    }
}