package com.anton.sauh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class ReaderFactoryTest {
    @Test
    public void getReader() throws Exception {
        ReaderFactory factory = new ReaderFactory();
        IReader reader = factory.getReader("java.csv");
        assertNotNull(reader);
    }
    @Test
    public void getReaderLongPath() throws Exception {
        ReaderFactory factory = new ReaderFactory();
        IReader reader = factory.getReader("app/files/java.csv");
        assertNotNull(reader);
    }
    @Test
    public void getReaderWrongPath() throws Exception {
        try {
            ReaderFactory factory = new ReaderFactory();
            IReader reader = factory.getReader("app/files/java");
        } catch (Exception e) {
            assertTrue(e instanceof ArrayIndexOutOfBoundsException);
        }
    }
    @Test
    public void getReaderWrongType() throws Exception {
        try {
            ReaderFactory factory = new ReaderFactory();
            IReader reader = factory.getReader("app/files/java.txt");
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
            assertTrue(e.getMessage().equals("Unknown file type: txt"));
        }
    }
}