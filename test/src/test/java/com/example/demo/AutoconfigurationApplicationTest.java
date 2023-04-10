package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoconfigurationApplicationTest {
    @Value("${property.test.name}")
    private String propertyTestName;

    @Value("${propertyTest}")
    private String propertyTest;

    @Value("${propertyTestList}")
    private String[] propertyTestArray;

    @Value("#{'${propertyTestList}'.split(',')}")
    private List<String> propertyTestList;

    @Test
    public void testValue() {
        Assert.assertEquals(propertyTestName, "property depth test");
        Assert.assertEquals(propertyTest, "test");
        Assert.assertEquals(propertyTestArray[0], "a");
        Assert.assertEquals(propertyTestArray[1], "b");
        Assert.assertEquals(propertyTestArray[2], "c");
        Assert.assertEquals(propertyTestList.get(0), "a");
        Assert.assertEquals(propertyTestList.get(1), "b");
        Assert.assertEquals(propertyTestList.get(2), "c");
    }
}
