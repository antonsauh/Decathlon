package com.anton.sauh;

import java.util.ArrayList;

public interface IReader {
    ArrayList<Contestant> readFile(String path) throws Exception;
}
