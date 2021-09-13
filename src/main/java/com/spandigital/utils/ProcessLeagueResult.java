package com.spandigital.utils;

import com.spandigital.domain.MatchScoreResult;

import java.util.HashMap;
import java.util.List;

public class ProcessLeagueResult
{
  private final List<MatchScoreResult> inputData;

  private final HashMap<String, Integer> leagueResult = new HashMap<>();

  public ProcessLeagueResult(List<MatchScoreResult> inputData)
  {
    this.inputData = inputData;
  }

  public HashMap<String, Integer> getLeagueResult()
  {
    return leagueResult;
  }


  public void processData()
  {
    for (MatchScoreResult match : inputData)
    {
      if (match.getHomeScore() > match.getOppositionScore())
      {
        Integer oppositionDrawPoints = leagueResult.getOrDefault(match.getOppositionTeam(), 0);
        leagueResult.put(match.getOppositionTeam(), oppositionDrawPoints);

        Integer homeDrawPoints = leagueResult.getOrDefault(match.getHomeTeam(), 0) + 3;
        leagueResult.put(match.getHomeTeam(), homeDrawPoints);
      }
      else if (match.getHomeScore() < match.getOppositionScore())
      {
        Integer oppositionDrawPoints = leagueResult.getOrDefault(match.getOppositionTeam(), 0) + 3;
        leagueResult.put(match.getOppositionTeam(), oppositionDrawPoints);

        Integer homeDrawPoints = leagueResult.getOrDefault(match.getHomeTeam(), 0);
        leagueResult.put(match.getHomeTeam(), homeDrawPoints);
      }
      else if (match.getHomeScore() == match.getOppositionScore())
      {
        Integer oppositionDrawPoints = leagueResult.getOrDefault(match.getOppositionTeam(), 0) + 1;
        leagueResult.put(match.getOppositionTeam(), oppositionDrawPoints);

        Integer homeDrawPoints = leagueResult.getOrDefault(match.getHomeTeam(), 0) + 1;
        leagueResult.put(match.getHomeTeam(), homeDrawPoints);
      }
    }
  }


}
