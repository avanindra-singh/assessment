package com.spandigital.domain;

public class MatchScoreResult
{
  private final String homeTeam;
  private final String oppositionTeam;
  private final int homeScore;
  private final int oppositionScore;

  public MatchScoreResult(String homeTeam, String oppositionTeam, int homeScore, int oppositionScore)
  {
    this.homeTeam = homeTeam;
    this.oppositionTeam = oppositionTeam;
    this.homeScore = homeScore;
    this.oppositionScore = oppositionScore;
  }

  public String getHomeTeam()
  {
    return homeTeam;
  }

  public String getOppositionTeam()
  {
    return oppositionTeam;
  }

  public int getHomeScore()
  {
    return homeScore;
  }

  public int getOppositionScore()
  {
    return oppositionScore;
  }
}
