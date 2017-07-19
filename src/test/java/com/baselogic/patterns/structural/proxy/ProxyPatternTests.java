package com.baselogic.patterns.structural.proxy;

import org.junit.Before;
import org.junit.Test;

// Added 2 new imports:
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class ProxyPatternTests {

    private Subject subject;

    @Before
    public void beforeEachTestCase(){

        // Init Client
        // JavaEE CDI / Spring
        subject = new Proxy();
    }

    /**
     * acting as our Client
     */
    @Test
    public void test_Simple_Client_Subject__IntResult_Implemented_with_Proxy(){

        int result = subject.operationReturningNumericValue(7);
        assertThat("((Input * 100) * 42) * 1_000", result, is(742_000));

    }

    @Test
    public void test_Simple_Client_Subject__StringResult_Implemented_with_Proxy(){
        String result = subject.operationReturningStringValue("input");

        assertThat("Input should contain prefix", result, is("POST OPERATION: prefix: audit: input"));
    }

    //-------------------------------------------------------------------

    @Test
    public void test_Simple_Client_Subject__IntResult_Implemented_without_Proxy(){

        subject = new Target();

        int result = subject.operationReturningNumericValue(7);
        assertThat("Input + 42", result, is(49));

    }

    @Test
    public void test_Simple_Client_Subject__StringResult_Implemented_without_Proxy(){

        subject = new Target();

        String result = subject.operationReturningStringValue("input");

        assertThat("Input should contain prefix", result, is("prefix: input"));
    }

}
