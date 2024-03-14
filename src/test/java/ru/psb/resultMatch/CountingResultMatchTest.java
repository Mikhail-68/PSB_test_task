package ru.psb.resultMatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountingResultMatchTest {

    @Test
    public void checkCorrectCalculateWithBracketTypeOne() {
        String str = "'1:2', '3:1'";
        Assertions.assertDoesNotThrow(() -> CountingResultMatch.countingResultMatch(str, '\''));
    }

    @Test
    public void checkCorrectCalculateWithBracketTypeTwo() {
        String str = "\"1:2\", \"3:1\"";
        Assertions.assertDoesNotThrow(() -> CountingResultMatch.countingResultMatch(str, '\"'));
    }

    @Test
    public void checkCorrectCalculateFirstWin() {
        String str = "'4:2', '3:1'";
        ResultMatch resultMatch = CountingResultMatch.countingResultMatch(str, '\'');

        Assertions.assertEquals(6, resultMatch.getResultFirst());
        Assertions.assertEquals(0, resultMatch.getResultSecond());
    }

    @Test
    public void checkCorrectCalculateSecondWin() {
        String str = "'0:2', '2:10'";
        ResultMatch resultMatch = CountingResultMatch.countingResultMatch(str, '\'');

        Assertions.assertEquals(0, resultMatch.getResultFirst());
        Assertions.assertEquals(6, resultMatch.getResultSecond());
    }

    @Test
    public void checkCorrectCalculateSecondDraw() {
        String str = "'2:2', '3:3'";
        ResultMatch resultMatch = CountingResultMatch.countingResultMatch(str, '\'');

        Assertions.assertEquals(2, resultMatch.getResultFirst());
        Assertions.assertEquals(2, resultMatch.getResultSecond());
    }

    @Test
    public void checkThrowExceptionNumberFormat() {
        String str = "(\"3:1\", \"2:2\", \"0:1\", \"4:2\", \"3:a\", \"3- 12\").";
        Assertions.assertThrows(NumberFormatException.class,
                () -> CountingResultMatch.countingResultMatch(str, '\"'));
    }

    @Test
    public void checkThrowExceptionInputMismatch() {
        String str = "('2:2, '3 3').";
        Assertions.assertThrows(NumberFormatException.class,
                () -> CountingResultMatch.countingResultMatch(str, '\''));
    }
}
