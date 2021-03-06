package edu.nju.nba.service;



import java.util.List;



import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.PlayerCareerHigh;
import edu.nju.nba.bean.PlayerDataAnalysis;
import edu.nju.nba.bean.PlayerDataStatistics;
import edu.nju.nba.bean.PlayerSingleGame;



public interface IPlayerService {
	
	
	//根据球员姓名查找球员，返回球员基本信息
	public Player show(String playerName);
	
	//模糊查找球员
	public List<Player> searchPlayer(String name);
	
	//根据球队名称，赛季ID查找属于一个球队的所有球员姓名
	public List<PlayerDataStatistics> findTeam(String teamName,String seasonID,String tag);
	
	
	//查找所有球员基本信息
	public List<Player> list();
	
	//得到某一名球员所有赛季场均基本数据
	public List<PlayerDataStatistics> getDataStatisticsByName(String playerName,String tag);
	//得到某一名球员所有赛季场均分析数据
	public List<PlayerDataAnalysis> getDataAnalysisByName(String playerName,String tag);
	
	//得到某一名球员某个赛季的常规赛场均基本数据
	//得到某一名球员某个赛季的季后赛场均基本数据
	public PlayerDataStatistics getDataStatistics(String seasonID,String playerName,String tag);
	
	//得到某一名球员某个赛季的常规赛场均分析数据
	//得到某一名球员某个赛季的季后赛场均分析数据
	public PlayerDataAnalysis getDataAnalysis(String seasonID,String playerName,String tag);
	
	//得到某个赛季所有球员的赛季场均基本数据
	public List<PlayerDataStatistics> getAllDataStatistics(String seasonID,String tag);
	
	//得到某个赛季所有球员的场均分析数据
	public List<PlayerDataAnalysis> getAllDataAnalysis(String seasonID,String tag);
	
	//根据赛季ID，比赛日期，球员名字得到球员某一场比赛的数据
    public PlayerSingleGame getPlayerSingleGame(String playerName,String seasonID,String gameDate);
    
    //根据赛季ID，比赛日期，所在球队得到某一场比赛该球队所有球员的数据
    public List<PlayerSingleGame> getPlayerSingleGames(String teamName,String seasonID,String gameDate);
    
    //根据gameID查找PlayerSingleGame
    public List<PlayerSingleGame> getPlayerSingleGameByID(String gameID);

	//根据球员cName得到某一球员所有的单场比赛数据
    public List<PlayerSingleGame> getPlayerSingleGameByName(String cName);
    
    //根据球员名字playerName得到一个球员生涯之最的所有数据
    public List<PlayerCareerHigh> getPlayerCareerHighList(String playerName);
    
    /**计算球员单项数据榜单
     * 
     * @param seasonId
     * @return List<PlayerDataStatistics>
     */
    //以下是常规赛球员榜单
    //球员得分榜
    public List<PlayerDataStatistics> getPlayerScoreRankingList(String seasonId);
    //球员篮板榜
    public List<PlayerDataStatistics> getPlayerReboundRankingList(String seasonId);
    //助攻榜
    public List<PlayerDataStatistics> getPlayerAssistanceRankingList(String seasonId);
    //抢断榜 
    public List<PlayerDataStatistics> getPlayerGrabRankingList(String seasonId);
    //三分榜
    public List<PlayerDataStatistics> getPlayerThreehitRankingList(String seasonId);
    //盖帽榜
    public List<PlayerDataStatistics> getPlayerBlockRankingList(String seasonId);
    //真实命中率
    public List<PlayerDataAnalysis> getPlayerTruePercentRanking(String seasonId);
    //投篮效率
    public List<PlayerDataAnalysis> getPlayerShootEfficiencyRanking(String seasonId);
    //篮板率
    public List<PlayerDataAnalysis> getPlayerReboundPercentRanking(String seasonId);
    //助攻率
    public List<PlayerDataAnalysis> getPlayerAssistancePercentRanking(String seasonId);
    //抢断率
    public List<PlayerDataAnalysis> getPlayerGrabPercentRanking(String seasonId);
    //盖帽率
    public List<PlayerDataAnalysis> getPlayerBlockPercentRanking(String seasonId);
    
    //以下是季后赛球员榜单
    //球员得分榜
    public List<PlayerDataStatistics> getPlayerScoreRankingOffList(String seasonId);
    //球员篮板榜
    public List<PlayerDataStatistics> getPlayerReboundRankingOffList(String seasonId);
    //助攻榜
    public List<PlayerDataStatistics> getPlayerAssistanceRankingOffList(String seasonId);
    //抢断榜 
    public List<PlayerDataStatistics> getPlayerGrabRankingOffList(String seasonId);
    //三分榜
    public List<PlayerDataStatistics> getPlayerThreehitRankingOffList(String seasonId);
    //盖帽榜
    public List<PlayerDataStatistics> getPlayerBlockRankingOffList(String seasonId);
    //真实命中率
    public List<PlayerDataAnalysis> getPlayerTruePercentOffRanking(String seasonId);
    //投篮效率
    public List<PlayerDataAnalysis> getPlayerShootEfficiencyOffRanking(String seasonId);
    //篮板率
    public List<PlayerDataAnalysis> getPlayerReboundPercentOffRanking(String seasonId);
    //助攻率
    public List<PlayerDataAnalysis> getPlayerAssistancePercentOffRanking(String seasonId);
    //抢断率
    public List<PlayerDataAnalysis> getPlayerGrabPercentOffRanking(String seasonId);
    //盖帽率
    public List<PlayerDataAnalysis> getPlayerBlockPercentOffRanking(String seasonId);

}
