package com.spandigital.utils;

import com.spandigital.domain.MatchScoreResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultsParserTest
{
  @Test
  public void shouldParseSingleLineWithDraw()
  {
    List<String> data = new ArrayList<>();

    data.add("Lions 3, Snakes 3");

    ResultsParser parser = new ResultsParser(data);
    parser.parseResult();
    List<MatchScoreResult> result = parser.getMatchScoreResults();

    assertEquals(result.size(), 1);
    assertEquals(result.get(0).getHomeTeam(), "Lions");
    assertEquals(result.get(0).getHomeScore(), 3);
    assertEquals(result.get(0).getOppositionTeam(), "Snakes");
    assertEquals(result.get(0).getOppositionScore(), 3);
  }

  @Test
  public void shouldParseMultipleLinesWithWinsDrawsAndLosses()
  {

    List<String> data = new ArrayList<>();

    data.add("Lions 3, Snakes 3");
    data.add("Tarantulas 1, FC Awesome 0");
    data.add("Lions 1, FC Awesome 1");
    data.add("Tarantulas 3, Snakes 1");
    data.add("Lions 4, Grouches 0");

    ResultsParser parser = new ResultsParser(data);
    parser.parseResult();
    List<MatchScoreResult> result = parser.getMatchScoreResults();

    assertEquals(result.size(), 5);

  }
}
