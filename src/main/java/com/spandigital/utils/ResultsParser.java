package com.spandigital.utils;

import com.spandigital.domain.MatchScoreResult;

import java.util.ArrayList;
import java.util.List;

public class ResultsParser
{
  private List<String> inputData;
  private List<MatchScoreResult> matchScoreResults = new ArrayList<>();

  public ResultsParser(List<String> inputData)
  {
    this.inputData = inputData;
  }

  public void parseResult()
  {

    for (String line : inputData)
    {
      String[] splitInTeams = line.split(",", 2);

      String homeTeam = splitInTeams[0];
      String oppositionTeam = splitInTeams[1];

      String[] homeTeamNameAndScore = homeTeam.trim().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
      String[] oppositionTeamNameAndScore = oppositionTeam.trim().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");


      matchScoreResults.add(new MatchScoreResult(homeTeamNameAndScore[0].trim(), oppositionTeamNameAndScore[0].trim(),
              Integer.parseInt(homeTeamNameAndScore[1]),
              Integer.parseInt(oppositionTeamNameAndScore[1])));
    }

  }

  public List<MatchScoreResult> getMatchScoreResults()
  {
    return matchScoreResults;
  }


}
