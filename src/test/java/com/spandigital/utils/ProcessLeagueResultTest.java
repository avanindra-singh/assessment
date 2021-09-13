package com.spandigital.utils;

import com.spandigital.domain.MatchScoreResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProcessLeagueResultTest
{
  @Test
  public void shouldProcessResultWithThreeMatchesOfThreeTeams()
  {
    List<MatchScoreResult> inputData = new ArrayList<>();

    inputData.add(new MatchScoreResult("Tarantulas", "FC Awesome", 1, 0));
    inputData.add(new MatchScoreResult("Lions", "Snakes", 3, 3));
    inputData.add(new MatchScoreResult("Lions", "FC Awesome", 1, 1));

    ProcessLeagueResult parser = new ProcessLeagueResult(inputData);
    parser.processData();
    HashMap<String, Integer> results = parser.getLeagueResult();

    assertEquals(Integer.valueOf(2), results.get("Lions"));
    assertEquals(Integer.valueOf(3), results.get("Tarantulas"));
    assertEquals(Integer.valueOf(1), results.get("FC Awesome"));
  }

}
