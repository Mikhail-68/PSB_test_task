package ru.psb.resultMatch;

import lombok.Getter;

@Getter
public class ResultMatch {
    private int resultFirst;
    private int resultSecond;

    public void changeResultFirst(int val) {
        resultFirst += val;
    }

    public void changeResultSecond(int val) {
        resultSecond += val;
    }
}