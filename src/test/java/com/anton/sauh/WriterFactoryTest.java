package com.anton.sauh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class WriterFactoryTest {
    @Test
    public void getWriter() throws Exception {
        WriterFactory factory = new WriterFactory();
        IWriter writer = factory.getWriter("xml");
        assertNotNull(writer);
    }
    @Test
    public void getWriterWrong() throws Exception {
        WriterFactory factory = new WriterFactory();
        IWriter writer = factory.getWriter("xmll");
        assertNull(writer);
    }

}