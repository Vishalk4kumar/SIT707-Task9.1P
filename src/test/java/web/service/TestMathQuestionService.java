package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1AdditionValidInputs() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.0);
    }

    @Test(expected = RuntimeException.class)
    public void testQ1AdditionNumber1Empty() {
        MathQuestionService.q1Addition("", "2");
    }

    @Test(expected = RuntimeException.class)
    public void testQ1AdditionNumber2Empty() {
        MathQuestionService.q1Addition("1", "");
    }

    @Test(expected = RuntimeException.class)
    public void testQ1AdditionBothNumbersEmpty() {
        MathQuestionService.q1Addition("", "");
    }

    @Test(expected = RuntimeException.class)
    public void testQ1AdditionInvalidNumber1() {
        MathQuestionService.q1Addition("abc", "2");
    }

    @Test(expected = RuntimeException.class)
    public void testQ1AdditionInvalidNumber2() {
        MathQuestionService.q1Addition("1", "xyz");
    }

    @Test
    public void testQ2SubtractionValidInputs() {
        Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("3", "2"), 0.0);
    }

    @Test(expected = RuntimeException.class)
    public void testQ2SubtractionNumber1Empty() {
        MathQuestionService.q2Subtraction("", "2");
    }

    @Test(expected = RuntimeException.class)
    public void testQ2SubtractionNumber2Empty() {
        MathQuestionService.q2Subtraction("3", "");
    }

    @Test(expected = RuntimeException.class)
    public void testQ2SubtractionBothNumbersEmpty() {
        MathQuestionService.q2Subtraction("", "");
    }

    @Test(expected = RuntimeException.class)
    public void testQ2SubtractionInvalidNumber1() {
        MathQuestionService.q2Subtraction("abc", "2");
    }

    @Test(expected = RuntimeException.class)
    public void testQ2SubtractionInvalidNumber2() {
        MathQuestionService.q2Subtraction("3", "xyz");
    }

    @Test
    public void testQ3MultiplicationValidInputs() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("3", "2"), 0.0);
    }

    @Test(expected = RuntimeException.class)
    public void testQ3MultiplicationNumber1Empty() {
        MathQuestionService.q3Multiplication("", "2");
    }

    @Test(expected = RuntimeException.class)
    public void testQ3MultiplicationNumber2Empty() {
        MathQuestionService.q3Multiplication("3", "");
    }

    @Test(expected = RuntimeException.class)
    public void testQ3MultiplicationBothNumbersEmpty() {
        MathQuestionService.q3Multiplication("", "");
    }

    @Test(expected = RuntimeException.class)
    public void testQ3MultiplicationInvalidNumber1() {
        MathQuestionService.q3Multiplication("abc", "2");
    }

    @Test(expected = RuntimeException.class)
    public void testQ3MultiplicationInvalidNumber2() {
        MathQuestionService.q3Multiplication("3", "xyz");
    }
}
