package com.boroda.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {

    @Test
    public void test1() {
        Stack stack = new Stack<String>();
        stack.push("5");
        stack.push("8");
        CalculatorApplication.rpnCalc(stack, "+");
        Assert.assertEquals(stack.peek(), "13.0");
    }

    @Test
    public void test2() {
        Stack stack = new Stack<String>();
        CalculatorApplication.rpnCalc(stack, "5 8 +");
        Assert.assertEquals(stack.peek(), "13.0");
        stack = CalculatorApplication.rpnCalc(stack, "13 -");
        Assert.assertEquals(stack.peek(), "0.0");
    }

    @Test
    public void test3() {
        Stack stack = new Stack<String>();
        stack = CalculatorApplication.rpnCalc(stack, "-3");
        Assert.assertEquals(stack.peek(), "-3");
        stack = CalculatorApplication.rpnCalc(stack, "-2");
        Assert.assertEquals(stack.peek(), "-2");
        stack = CalculatorApplication.rpnCalc(stack, "*");
        Assert.assertEquals(stack.peek(), "6.0");
        stack = CalculatorApplication.rpnCalc(stack, "5");
        Assert.assertEquals(stack.peek(), "5");
        stack = CalculatorApplication.rpnCalc(stack, "+");
        Assert.assertEquals(stack.peek(), "11.0");
    }

    @Test
    public void test4() {
        Stack stack = new Stack<String>();
        stack = CalculatorApplication.rpnCalc(stack, "5");
        Assert.assertEquals(stack.peek(), "5");
        stack = CalculatorApplication.rpnCalc(stack, "9");
        Assert.assertEquals(stack.peek(), "9");
        stack = CalculatorApplication.rpnCalc(stack, "1");
        Assert.assertEquals(stack.peek(), "1");
        stack = CalculatorApplication.rpnCalc(stack, "-");
        Assert.assertEquals(stack.peek(), "8.0");
        stack = CalculatorApplication.rpnCalc(stack, "/");
        Assert.assertEquals(stack.peek(), "0.625");
    }

}
