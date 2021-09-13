package com.spandigital;

import com.spandigital.utils.ProcessLeagueResult;
import com.spandigital.utils.ResultsFileReader;
import com.spandigital.utils.ResultsParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App
{
  public static void main(String[] args)
  {
    Scanner user = new Scanner(System.in);
    String inputFileName;

    // prepare the input file
    // inputdata.txt in repo
    System.out.print("Input File Name: ");
    inputFileName = user.nextLine().trim();

    ResultsFileReader fileReader = new ResultsFileReader(inputFileName);

    try
    {
      fileReader.readInFile();
    }
    catch (IOException e)
    {
      System.out.print("File Read Error!");
    }

    ResultsParser parser = new ResultsParser(fileReader.getResultData());


    parser.parseResult();

    ProcessLeagueResult processLeagueResult = new ProcessLeagueResult(parser.getMatchScoreResults());
    processLeagueResult.processData();
    HashMap<String, Integer> results = sortByValue(processLeagueResult.getLeagueResult());

    results.forEach((key1, value1) -> {
      System.out.println(key1 + " : "
                         + value1);
    });
  }

  // Method to sort Hashmap by value in descending order for presentation purposes
  public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
  {
    // Create a list from elements of HashMap
    List<Map.Entry<String, Integer>> list =
            new LinkedList<>(hm.entrySet());

    // Sort the list
    list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

    // put data from sorted list to hashmap
    HashMap<String, Integer> temp = new LinkedHashMap<>();
    for (Map.Entry<String, Integer> aa : list)
    {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }
}
