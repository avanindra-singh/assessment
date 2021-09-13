package com.spandigital.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ResultsFileReader
{
  private final List<String> inputData = new ArrayList<>();
  private final String fileNameAndPath;

  public ResultsFileReader(String fileNameAndPath)
  {

    this.fileNameAndPath = fileNameAndPath;
  }

  public void readInFile() throws IOException
  {
    try (Stream<String> lines = Files.lines(Paths.get(fileNameAndPath), Charset.defaultCharset()))
    {
      lines.forEach(inputData::add);
    }
  }

  public List<String> getResultData()
  {
    return inputData;
  }
}
