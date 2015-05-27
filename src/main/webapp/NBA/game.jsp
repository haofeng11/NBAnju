<%@page import="edu.nju.nba.bean.TeamGameRecord"%>
<%@page import="edu.nju.nba.service.impl.TeamService"%>
<%@page import="edu.nju.nba.service.ITeamService"%>
<%@page import="edu.nju.nba.bean.Team"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html >
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>比赛</title>

    <!-- 加载动画 -->
    <link rel="stylesheet" href=${path.concat("/NBA/css/fakeLoader.css")}>
    <!-- 加载动画 -->
    <div class="fakeloader"></div>
<!-- Bootstrap -->
<link href="../NBA/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../NBA/js/jquery-ui/jquery-ui.css">
<link href="../NBA/css/new.css" rel="stylesheet">
<!-- Highchart图表JS库 -->
<script type="text/javascript" src="../NBA/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../NBA/js/highcharts/highcharts.js"></script>
<script type="text/javascript"
	src="../NBA/js/highcharts/highcharts-more.js"></script>
<script type="text/javascript"
	src="../NBA/js/highcharts/themes/custom.js"></script>
<script type="text/javascript"
	src="../NBA/js/highcharts/modules/exporting.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- 导航栏 -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle collapsed" type="button"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand hidden-sm"
					href="${path.concat('/NBA/main.jsp')}">NBA数据分析网</a>
			</div>
			<div class="navbar-collapse collapse" role="navigation">
				<ul class="nav navbar-nav">
					<li><a href="${path.concat('/NBA/main.jsp')}">球员</a></li>
					<li><a href="${path.concat('/NBA/team.jsp')}">球队</a></li>
					<li class="active"><a href="${path.concat('/game/game')}">比赛</a></li>
					<li><a href="${path.concat('/player/comparison')}">球员对比</a></li>
					<li><a href="${path.concat('/comparisonArea')}">分区对比</a></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group form-group-sm">
						<input id="search" type="text" class="form-control"
							placeholder="搜索球员或者球队">
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right hidden-sm">
					<li><a href="/about/"
						onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'about'])">管理员登录</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 导航栏 -->
	<div class="game">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-3"></div>
					<!-- 选择场次 -->
					<div class="col-md-6">
						<form class="form-inline" style="margin-top: 10px;"
							action="./gameSchedule" onsubmit="return validate_form()">
							<div class="form-group">
								<select class="form-control" style="" name="seasonId" id="seasonpicker">
									<option>请选择赛季</option>
									<option>02-03 赛季</option>
									<option>03-04 赛季</option>
									<option>04-05 赛季</option>
									<option>05-06 赛季</option>
									<option>06-07 赛季</option>
									<option>07-08 赛季</option>
									<option>08-09 赛季</option>
									<option>09-10 赛季</option>
									<option>10-11 赛季</option>
									<option>11-12 赛季</option>
									<option>12-13 赛季</option>
									<option>13-14 赛季</option>
									<option>14-15 赛季</option>
								</select> <input type="text" class="form-control" name="date"
									id="datepicker" placeholder="点击选择日期"
									style="text-align: center;" size="38">
							</div>
							<button type="submit" class="btn btn-default"
								style="float: right;">查看数据</button>
						</form>
					</div>
					<div class="col-md-3"></div>
				</div>
				<div class="col-md-3">
					<div class="gamecenter_content_r">
						<div class="region_box">
							<h4>球队${season}战绩</h4>
							<div class="tiltle" conference="W">
								<span class="tiltle_a" id="east">东部</span><span class="tiltle_b"
									id="west">西部</span>
							</div>

						
							
							<table class="itinerary_table">
								<tbody>
									<tr>
										<td width="35" height="40">排名</td>
										<td width="40">球队</td>
										<td width="25">胜</td>
										<td width="25">负</td>	
										<td width="35">胜差</td>
										<td>胜率</td>
									</tr>
								</tbody>
							</table>
							<div class="border_red"></div>
							<table class="itinerary_table itinerary_table_show"
								id="eastdata_regular">
								<tbody>
									<c:forEach items="${regularEastRankGameRecords}"
										var="regularEast">
										<tr class=" bg_color">
											<td width="25" height="35">${regularEast.record.rank}</td>
											<c:set var="temp" value="${path.concat('/team/')}"></c:set>
											<c:set var="temp2" value="${temp.concat(regularEast.record.team)}"></c:set>
											<td width="55"><a target="_blank" href="${temp2}">${regularEast.bName}</a></td>
											<td width="20">${regularEast.record.winGame}</td>
											<td width="25">${regularEast.record.loseGame}</td>
											<td width="25">${regularEast.record.winGap}</td>
											<td>${regularEast.record.victory}</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>


							<table class="itinerary_table itinerary_table_show"
								id="eastdata_playoff" style="display: none">
								<tbody>
									<c:forEach items="${playoffEastRankGameRecords}"
										var="playoffEast">
										<tr class=" bg_color">
											<td width="25" height="35">${playoffEast.rank}</td>
											<c:set var="temp" value="${path.concat('/team/')}"></c:set>
											<c:set var="temp2" value="${temp.concat(playoffEast.team)}"></c:set>
											<td width="55"><a target="_blank" href="${temp2}">${playoffEast.team}</a></td>
											<td width="20">${playoffEast.winGame}</td>
											<td width="25">${playoffEast.loseGame}</td>
											<td width="25">${playoffEast.winGap}</td>
											<td>${playoffEast.victory}</td>
										</tr>
									</c:forEach>
									</tr>

								</tbody>
							</table>

							<table class="itinerary_table itinerary_table_show"
								id="westdata_regular" style="display: none">
								<tbody>
									<c:forEach items="${regularWestRankGameRecords}"
										var="regularWest">
										<tr class=" bg_color">
											<td width="25" height="35">${regularWest.record.rank}</td>
											<c:set var="temp" value="${path.concat('/team/')}"></c:set>
											<c:set var="temp2" value="${temp.concat(regularWest.record.team)}"></c:set>
											<td width="55"><a target="_blank" href="${temp2}">${regularWest.bName}</a></td>
											<td width="20">${regularWest.record.winGame}</td>
											<td width="25">${regularWest.record.loseGame}</td>
											<td width="25">${regularWest.record.winGap}</td>
											<td>${regularWest.record.victory}</td>
										</tr>
									</c:forEach>
									</tr>

								</tbody>
							</table>

							<table class="itinerary_table itinerary_table_show"
								id="westdata_playoff" style="display: none">
								<tbody>
									<tr class=" bg_color">
										<c:forEach items="${playoffWestRankGameRecords}"
											var="playoffWest">
											<tr class=" bg_color">
												<td width="25" height="35">${playoffWest.rank}</td>
												<c:set var="temp" value="${path.concat('/team/')}"></c:set>
												<c:set var="temp2" value="${temp.concat(playoffWest.team)}"></c:set>
												<td width="55"><a target="_blank" href="${temp2}">${playoffWest.team}</a></td>
												<td width="20">${playoffWest.winGame}</td>
												<td width="25">${playoffWest.loseGame}</td>
												<td width="25">${playoffWest.winGap}</td>
												<td>${playoffWest.victory}</td>
											</tr>
										</c:forEach>
									</tr>

								</tbody>
							</table>

						</div>
					</div>
				</div>
				<div class="col-md-6">
					<!-- 选择日期 -->
					<!-- <div class="choosedate">
    			
    					<div class="date">
    						<a href="">前一天</a>
    						<a class="on" href="">今天</a>
    						<a href="">后一天</a>
    					</div>
    				</div> -->
					<!-- 表格数据 -->
					<div class="data">
						<table class="table table-bordered teams_table">
							<tr>
								<td width="165">比赛时间</td>
								<td width="280">主队 VS 客队</td>
								<td width="150"><a id="start" href="#" data-toggle="modal"
									data-target="#myModal">季后赛对阵图</a></td>
							</tr>

							<c:forEach items="${gameSchedule}" var="game">
								<tr class=" bg_color">
									<td width="135">${game.gameDate}</td>
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat(game.homeTeam)}"></c:set>
									<c:set var="temp3" value="${temp.concat(game.guestTeam)}"></c:set>
									<td width="360"><a href="${temp2}">${game.homeTeam}</a>
										${game.homeScore} : ${game.guestScore} <a href="${temp3}">${game.guestTeam}</a>
									</td>
									<%-- 			                    	 <c:set var="gamelinktemp" value="${path.concat('/'game.seasonID'/')}"></c:set> --%>
									<%-- 			                    	 <c:set var="gamelinktemp2" value="${gamelinktemp.concat(game.gameDate/)}"></c:set> --%>
									<%-- 			                    	 <c:set var="gamelinktemp3" value="${gamelinktemp2.concat(game.homeTeam/)}"></c:set> --%>
									<%-- 			                    	 <c:set var="gamelinktemp4" value="${gamelinktemp3.concat(game.guestTeam)}"></c:set> --%>
									<td>
										<form action="${path.concat('/game/match')}" method="POST">
											<input type="hidden" name="seasonID" value="${game.seasonID}">
											<input type="hidden" name="gameDate" value="${game.gameDate}">
											<input type="hidden" name="homeTeam" value="${game.homeTeam}">
											<input type="hidden" name="guestTeam"
												value="${game.guestTeam}"> <input type="submit"
												class="btn btn-default" value="比赛统计" />
										</form> <%-- 			                        <a target="_blank" href="${gamelinktemp4}">比赛统计</a>             --%>
									</td>
								</tr>
							</c:forEach>

						</table>

					</div>
				</div>
				<!-- <div class="col-md-3">
    				<div class="gamecenter_content_r">
						<div class="region_box">
							<h4>球员今日</h4>
							<div class="tiltle" conference="W">
								<span class="tiltle_c" id="east">得分</span><span class="tiltle_c" id="west">篮板</span><span class="tiltle_c" id="west">助攻</span><span class="tiltle_c" id="west">抢断</span><span class="tiltle_c" id="west">三分</span><span class="tiltle_d" >盖帽</span>
							</div>
							<table class="itinerary_table">
		                        <tbody>
		                            <tr>
		                                <td width="50" height="40">姓名</td>
		                                <td width="45">球队</td>
		                                <td width="35">今日数据</td>
		                            </tr>
		                        </tbody>
		                    </table>
		                    <div class="border_red"></div>
	                    	<table class="itinerary_table itinerary_table_show" id="westdata">
	                        <tbody>
                                <tr class=" bg_color">
	                                <td width="60" height="35">凯里·欧文</td>
	                                <td width="45"><a target="_blank" title="骑士" href="/nba/teams/hawks">骑士</a></td>
	                                <td width="45">55分</td>
	                            </tr>
	                            <tr class="">
	                                <td width="35" height="35">斯蒂芬·库里</td>
	                                <td width="60"><a target="_blank" title="勇士" href="/nba/teams/hawks">勇士</a></td>
	                                <td width="35">39分</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="35" height="35">詹姆斯·哈登</td>
	                                <td width="60"><a target="_blank" title="火箭" href="/nba/teams/hawks">火箭</a></td>
	                                <td width="45">34分</td>
	                            </tr>
	                        </tbody>
	                    	</table>
		                </div>
		            </div> -->


				<div class="gamecenter_content_r" id="changjun">
					<div class="region_box">
						<h4>球员场均</h4>
						<div class="tiltle" conference="W">
							<span class="tiltle_c on" id="changjun_defen"
								style="background: #fbfbfb;">得分</span><span class="tiltle_c"
								id="changjun_lanban">篮板</span><span class="tiltle_c"
								id="changjun_zhugong">助攻</span><span class="tiltle_c"
								id="changjun_qiangduan">抢断</span><span class="tiltle_c"
								id="changjun_sanfen">三分</span><span class="tiltle_d"
								id="changjun_gaimao">盖帽</span>
						</div>
						<div class="tiltle" conference="W">
							<span class="tiltle_a" style="width: 240px;"><div
									class="btn-group">
									<button type="button"
										class="btn btn-link btn-xs dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false"
										style="margin-top: -8px; font-size: 14px; color: #000000;"
										id="changjun_season_type">
										常规赛 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="javascript:void(0);">常规赛</a></li>
										<li><a href="javascript:void(0);">季后赛</a></li>
									</ul>
								</div></span>
						</div>
						<table class="itinerary_table">
							<tbody>
								<tr>
									<td width="40" height="35">姓名</td>
									<td width="35">球队</td>
									<td width="35">场均数据</td>
								</tr>
							</tbody>
						</table>
						<div class="border_red"></div>
						<table class="itinerary_table itinerary_table_show">
							<tbody id="regular_changjun_defen">
								<c:forEach items="${playerScoreRank}" var="ScoreTopten">
									<tr class=" bg_color">
										<td width="40" height="35">${ScoreTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${ScoreTopten.team}" href="/nba/teams/hawks">${ScoreTopten.team}</a></td>
										<td width="35">${ScoreTopten.score}分</td>
									</tr>
								</c:forEach>
							</tbody>
							<tbody id="playoff_changjun_defen" style="display: none;">
								<c:forEach items="${playerOffScoreRank}"
									var="PlayoffScoreTopten">
									<tr class=" bg_color">
										<td width="40" height="35">${PlayoffScoreTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffScoreTopten.team}" href="/nba/teams/hawks">${PlayoffScoreTopten.team}</a></td>
										<td width="35">${PlayoffScoreTopten.score}分</td>
									</tr>
								</c:forEach>

							</tbody>

							<tbody id="regular_changjun_lanban" style="display: none;">
								<c:forEach items="${playerReboundRank}" var="ReboundTopten">

									<tr class=" bg_color">
										<td width="40" height="35">${ReboundTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${ReboundTopten.team}" href="/nba/teams/hawks">${ReboundTopten.team}</a></td>
										<td width="35">${ReboundTopten.rebound}</td>
									</tr>
								</c:forEach>
							</tbody>

							<tbody id="playoff_changjun_lanban" style="display: none;">
								<c:forEach items="${playerOffReboundRank}"
									var="PlayoffReboundTopten">
									<tr class=" bg_color">
										<td width="40" height="35">${PlayoffReboundTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffReboundTopten.team}" href="/nba/teams/hawks">${PlayoffReboundTopten.team}</a></td>
										<td width="35">${PlayoffReboundTopten.rebound}</td>
									</tr>
								</c:forEach>
							</tbody>

							<tbody id="regular_changjun_zhugong" style="display: none;">
								<c:forEach items="${playerAssistanceRank}"
									var="AssistanceTopten">
									<tr class=" bg_color">
										<td width="40" height="35">${AssistanceTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${AssistanceTopten.team}" href="/nba/teams/hawks">${AssistanceTopten.team}</a></td>
										<td width="35">${AssistanceTopten.assistance}</td>

									</tr>
								</c:forEach>
							</tbody>

							<tbody id="playoff_changjun_zhugong" style="display: none;">
								<c:forEach items="${playerOffAssistanceRank}"
									var="PlayoffAssistanceTopten">
									<tr class=" bg_color">

										<td width="40" height="35">${PlayoffAssistanceTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffAssistanceTopten.team}"
											href="/nba/teams/hawks">${PlayoffAssistanceTopten.team}</a></td>
										<td width="35">${PlayoffAssistanceTopten.assistance}</td>

									</tr>
								</c:forEach>
							</tbody>

							<tbody id="regular_changjun_qiangduan" style="display: none;">
								<c:forEach items="${playerGrabRank}" var="GrabTopten">
									<tr class=" bg_color">
										<td width="40" height="35">${GrabTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${GrabTopten.team}" href="/nba/teams/hawks">${GrabTopten.team}</a></td>
										<td width="35">${GrabTopten.grab}</td>

									</tr>
								</c:forEach>
							</tbody>

							<tbody id="playoff_changjun_qiangduan" style="display: none;">
								<c:forEach items="${playerOffGrabRank}" var="PlayoffGrabTopten">
									<tr class=" bg_color">
										<td width="40" height="35">${PlayoffGrabTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffGrabTopten.team}" href="/nba/teams/hawks">${PlayoffGrabTopten.team}</a></td>
										<td width="35">${PlayoffGrabTopten.grab}</td>
									</tr>
								</c:forEach>
							</tbody>

							<tbody id="regular_changjun_sanfen" style="display: none;">
								<c:forEach items="${playerThreehitRank}" var="ThreehitTopten">
									<tr class=" bg_color">
										<td width="40" height="35">${ThreehitTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${ThreehitTopten.team}" href="/nba/teams/hawks">${ThreehitTopten.team}</a></td>
										<td width="35">${ThreehitTopten.threeHit}</td>

									</tr>
								</c:forEach>
							</tbody>

							<tbody id="playoff_changjun_sanfen" style="display: none;">
								<c:forEach items="${playerOffThreehitRank}"
									var="PlayoffThreehitTopten">
									<tr class=" bg_color">

										<td width="40" height="35">${PlayoffThreehitTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffThreehitTopten.team}" href="/nba/teams/hawks">${PlayoffThreehitTopten.team}</a></td>
										<td width="35">${PlayoffThreehitTopten.threeHit}</td>

									</tr>
								</c:forEach>
							</tbody>

							<tbody id="regular_changjun_gaimao" style="display: none;">
								<c:forEach items="${playerBlockRank}" var="BlockTopten">
									<tr class=" bg_color">

										<td width="40" height="35">${BlockTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${BlockTopten.team}" href="/nba/teams/hawks">${BlockTopten.team}</a></td>
										<td width="35">${BlockTopten.block}</td>

									</tr>
								</c:forEach>
							</tbody>

							<tbody id="playoff_changjun_gaimao" style="display: none;">
								<c:forEach items="${playerOffBlockRank}"
									var="PlayoffBlockTopten">
									<tr class=" bg_color">

										<td width="40" height="35">${PlayoffBlockTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffBlockTopten.team}" href="/nba/teams/hawks">${PlayoffBlockTopten.team}</a></td>
										<td width="35">${PlayoffBlockTopten.block}</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="gamecenter_content_r" id="danchang">
					<div class="region_box">
						<h4>球员赛季效率值</h4>
						<div class="tiltle" conference="W">
							<span class="tiltle_c on" id="danchang_defen"
								style="background: #fbfbfb; width: 68px">真实命中率</span><span
								class="tiltle_c" id="danchang_zhugong" style="width: 43px">篮板率</span><span
								class="tiltle_c" id="danchang_qiangduan" style="width: 43px">助攻率</span><span
								class="tiltle_c" id="danchang_sanfen" style="width: 43px">抢断率</span><span
								class="tiltle_d" id="danchang_gaimao" style="width: 43px">盖帽率</span>
						</div>
						<div class="tiltle" conference="W">
							<span class="tiltle_a" style="width: 240px;"><div
									class="btn-group">
									<button type="button"
										class="btn btn-link btn-xs dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false"
										style="margin-top: -8px; font-size: 14px; color: #000000;"
										id="danchang_season_type">
										常规赛 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="javascript:void(0);">常规赛</a></li>
										<li><a href="javascript:void(0);">季后赛</a></li>
									</ul>
								</div></span>
						</div>
						<table class="itinerary_table">
							<tbody>
								<tr>
									<td width="40" height="35">姓名</td>
									<td width="35">球队</td>
									<td width="35">场均数据</td>
								</tr>
							</tbody>
						</table>
						<div class="border_red"></div>
						<table class="itinerary_table itinerary_table_show">
							<tbody id="regular_danchang_defen">
								<c:forEach items="${playerTruePercentRank}"
									var="playerTruePercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerTruePercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerTruePercent.team}" href="/nba/teams/hawks">${playerTruePercent.team}</a></td>
										<td width="35">${playerTruePercent.truePercentage}</td>

									</tr>
								</c:forEach>

							</tbody>

							<tbody id="playoff_danchang_defen" style="display: none;">
								<c:forEach items="${playerOffTruePercentRank}"
									var="playerOffTruePercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerOffTruePercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerOffTruePercent.team}" href="/nba/teams/hawks">${playerOffTruePercent.team}</a></td>
										<td width="35">${playerOffTruePercent.truePercentage}</td>

									</tr>
								</c:forEach>

							</tbody>



							<tbody id="regular_danchang_zhugong" style="display: none;">
								<c:forEach items="${playerReboundPercentRank}"
									var="playerReboundPercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerReboundPercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerReboundPercent.team}" href="/nba/teams/hawks">${playerReboundPercent.team}</a></td>
										<td width="35">${playerReboundPercent.reboundPercent}</td>

									</tr>
								</c:forEach>

							</tbody>

							<tbody id="playoff_danchang_zhugong" style="display: none;">
								<c:forEach items="${playerOffReboundPercentRank}"
									var="playerOffReboundPercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerOffReboundPercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerOffReboundPercent.team}"
											href="/nba/teams/hawks">${playerReboundPercent.team}</a></td>
										<td width="35">${playerOffReboundPercent.reboundPercent}</td>

									</tr>
								</c:forEach>

							</tbody>

							<tbody id="regular_danchang_qiangduan" style="display: none;">
								<c:forEach items="${playerAssistancePercentRank}"
									var="playerAssistancePercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerAssistancePercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerAssistancePercent.team}"
											href="/nba/teams/hawks">${playerAssistancePercent.team}</a></td>
										<td width="35">${playerAssistancePercent.assistancePercent}</td>

									</tr>
								</c:forEach>

							</tbody>

							<tbody id="playoff_danchang_qiangduan" style="display: none;">
								<c:forEach items="${playerOffAssistancePercent}"
									var="playerOffAssistancePercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerOffAssistancePercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerOffAssistancePercent.team}"
											href="/nba/teams/hawks">${playerAssistancePercent.team}</a></td>
										<td width="35">${playerOffAssistancePercent.assistancePercent}</td>

									</tr>
								</c:forEach>

							</tbody>

							<tbody id="regular_danchang_sanfen" style="display: none;">
								<c:forEach items="${playerGrabPercentRank}"
									var="playerGrabPercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerGrabPercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerGrabPercent.team}" href="/nba/teams/hawks">${playerGrabPercent.team}</a></td>
										<td width="35">${playerGrabPercent.grabPercent}</td>

									</tr>
								</c:forEach>
							</tbody>

							<tbody id="playoff_danchang_sanfen" style="display: none;">
								<c:forEach items="${playerOffGrabPercentRank}"
									var="playerOffGrabPercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerOffGrabPercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerOffGrabPercent.team}" href="/nba/teams/hawks">${playerOffGrabPercent.team}</a></td>
										<td width="35">${playerOffGrabPercent.grabPercent}</td>

									</tr>
								</c:forEach>

							</tbody>

							<tbody id="regular_danchang_gaimao" style="display: none;">
								<c:forEach items="${playerBlockPercentRank}"
									var="playerBlockPercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerBlockPercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerBlockPercent.team}" href="/nba/teams/hawks">${playerBlockPercent.team}</a></td>
										<td width="35">${playerBlockPercent.blockPercent}</td>

									</tr>
								</c:forEach>

							</tbody>

							<tbody id="playoff_danchang_gaimao" style="display: none;">
								<c:forEach items="${playerOffBlockPercentRank}"
									var="playerOffBlockPercent">
									<tr class=" bg_color">

										<td width="40" height="35">${playerOffBlockPercent.player}</td>
										<td width="35"><a target="_blank"
											title="${playerOffBlockPercent.team}" href="/nba/teams/hawks">${playerOffBlockPercent.team}</a></td>
										<td width="35">${playerOffBlockPercent.blockPercent}</td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>


			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width: 80%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">季后赛对阵图</h4>
				</div>
				<canvas id="myCanvas" style="position: absolute;" width="1100px;"
					height="400px">你的浏览器不支持canvas</canvas>
				<div class="modal-body">
					<div style="height: 100%; width: 12.5%; float: left;">
						<div>
							<div class="btn-group">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('金州勇士队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">勇 士</a>
								</button>
								<button type="button" class="btn btn-success" id="team1">4</button>
							</div>
							<div class="btn-group" style="margin-top: 10px;">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('新奥尔良鹈鹕队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">鹈 鹕</a>
								</button>
								<button type="button" class="btn btn-success" id="team2">0</button>
							</div>
						</div>
						<div style="margin-top: 20px;">
							<div class="btn-group">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('波特兰开拓者队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">开拓者</a>
								</button>
								<button type="button" class="btn btn-success" id="team3">1</button>
							</div>
							<div class="btn-group" style="margin-top: 10px;">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('孟菲斯灰熊队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">灰 熊</a>
								</button>
								<button type="button" class="btn btn-success" id="team4">4</button>
							</div>
						</div>
						<div style="margin-top: 20px;">
							<div class="btn-group">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('洛杉矶快船队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">快 船</a>
								</button>
								<button type="button" class="btn btn-success" id="team5">4</button>
							</div>
							<div class="btn-group" style="margin-top: 10px;">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('圣安东尼奥马刺队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">马 刺</a>
								</button>
								<button type="button" class="btn btn-success" id="team6">3</button>
							</div>
						</div>
						<div style="margin-top: 20px;">
							<div class="btn-group">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('休斯顿火箭队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">火 箭</a>
								</button>
								<button type="button" class="btn btn-success" id="team7">4</button>
							</div>
							<div class="btn-group" style="margin-top: 10px;">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('达拉斯小牛队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">小 牛</a>
								</button>
								<button type="button" class="btn btn-success" id="team8">1</button>
							</div>
						</div>
					</div>
					<div style="float: left; width: 12.5%;">
						<div style="margin-top: 22px;">
							<div class="btn-group">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('金州勇士队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">勇士</a>
								</button>
								<button type="button" class="btn btn-success" id="team9">1</button>
							</div>
							<div class="btn-group" style="margin-top: 64px;">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('孟菲斯灰熊队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">灰熊</a>
								</button>
								<button type="button" class="btn btn-success" id="team10">0</button>
							</div>
						</div>
						<div style="margin-top: 64px;">
							<div class="btn-group">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('洛杉矶快船队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">快船</a>
								</button>
								<button type="button" class="btn btn-success" id="team11">1</button>
							</div>
							<div class="btn-group" style="margin-top: 64px;">
								<c:set var="temp" value="${path.concat('/team/')}"></c:set>
								<c:set var="temp2" value="${temp.concat('休斯顿火箭队')}"></c:set>
								<button type="button" class="btn btn-success">
									<a target="_blank" href="${temp2}">火箭</a></button>
								<button type="button" class="btn btn-success" id="team12">0</button>
							</div>
						</div>
					</div>
					<div style="float: left; width: 12.5%;">
						<div style="margin-top: 72px;">
							<div class="btn-group">
								<button type="button" class="btn btn-success">待定</button>
								<button type="button" class="btn btn-success" id="team13">0</button>
							</div>
							<div class="btn-group" style="margin-top: 162px;">
								<button type="button" class="btn btn-success">待定</button>
								<button type="button" class="btn btn-success" id="team14">0</button>
							</div>
						</div>
					</div>
					<div style="float: left; width: 12.5%;">
						<div style="margin-top: 162px;">
							<div class="btn-group">
								<button type="button" class="btn btn-success btn-lg">待定</button>
								<button type="button" class="btn btn-success btn-lg" id="team15">0</button>
							</div>
						</div>
					</div>

					<div id="playoffs_right">
						<div style="height: 100%; width: 12.5%; float: right;">
							<div style="left: 20px;">
								<div class="btn-group">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('亚特兰大老鹰队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">老鹰</a>
									</button>
									<button type="button" class="btn btn-success" id="team16">4</button>
								</div>
								<div class="btn-group" style="margin-top: 10px;">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('布鲁克林篮网队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">篮网</a>
									</button>
									<button type="button" class="btn btn-success" id="team17">2</button>
								</div>
							</div>
							<div style="margin-top: 20px;">
								<div class="btn-group">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('多伦多猛龙队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">猛龙</a>
									</button>
									<button type="button" class="btn btn-success" id="team18">0</button>
								</div>
								<div class="btn-group" style="margin-top: 10px;">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('华盛顿奇才队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">奇才</a>
									</button>
									<button type="button" class="btn btn-success" id="team19">4</button>
								</div>
							</div>
							<div style="margin-top: 20px;">
								<div class="btn-group">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('芝加哥公牛队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">公牛</a>
									</button>
									<button type="button" class="btn btn-success" id="team20">4</button>
								</div>
								<div class="btn-group" style="margin-top: 10px;">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('密尔沃基雄鹿队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">雄鹿</a>
									</button>
									<button type="button" class="btn btn-success" id="team21">2</button>
								</div>
							</div>
							<div style="margin-top: 20px;">
								<div class="btn-group">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('克里夫兰骑士队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">骑士</a></button>
									<button type="button" class="btn btn-success" id="team22">4</button>
								</div>
								<div class="btn-group" style="margin-top: 10px;">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('波士顿凯尔特人队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">凯尔特人</a></button>
									<button type="button" class="btn btn-success" id="team23">0</button>
								</div>
							</div>
						</div>
						<div style="float: right; width: 12.5%;">
							<div style="margin-top: 22px;">
								<div class="btn-group">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('亚特兰大老鹰队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">老鹰</a></button>
									<button type="button" class="btn btn-success" id="team24">0</button>
								</div>
								<div class="btn-group" style="margin-top: 64px;">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('华盛顿奇才队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">奇才</a></button>
									<button type="button" class="btn btn-success" id="team25">1</button>
								</div>
							</div>
							<div style="margin-top: 64px;">
								<div class="btn-group">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('芝加哥公牛队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">公牛</a></button>
									<button type="button" class="btn btn-success" id="team26">1</button>
								</div>
								<div class="btn-group" style="margin-top: 64px;">
									<c:set var="temp" value="${path.concat('/team/')}"></c:set>
									<c:set var="temp2" value="${temp.concat('克里夫兰骑士队')}"></c:set>
									<button type="button" class="btn btn-success">
										<a target="_blank" href="${temp2}">骑士</a></button>
									<button type="button" class="btn btn-success" id="team27">0</button>
								</div>
							</div>
						</div>
						<div style="float: right; width: 12.5%;">
							<div style="margin-top: 72px;">
								<div class="btn-group">
									<button type="button" class="btn btn-success">待定</button>
									<button type="button" class="btn btn-success" id="team28">0</button>
								</div>
								<div class="btn-group" style="margin-top: 162px;">
									<button type="button" class="btn btn-success">待定</button>
									<button type="button" class="btn btn-success" id="team29">0</button>
								</div>
							</div>
						</div>
						<div style="float: right; width: 12.5%;">
							<div style="margin-top: 162px;">
								<div class="btn-group" style="left: 20px;">
									<button type="button" class="btn btn-success btn-lg">待定</button>
									<button type="button" class="btn btn-success btn-lg"
										id="team30">0</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer" style="border-top: 0px solid #e5e5e5;">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	//验证表单
	function validate_form()
	{
		if($('#datepicker').val() == '' || $('#seasonpicker').val() == '请选择赛季'){
			alert("请选择赛季和日期！");
			return false;
		}
		return true;
	}

		$(document)
				.ready(
						function() {
							var west = document.getElementById("west");
							var east = document.getElementById("east");
							var westdata_regular = document
									.getElementById("westdata_regular");
							var eastdata_regular = document
									.getElementById("eastdata_regular");
							var westdata_playoff = document
									.getElementById("westdata_playoff");
							var eastdata_playoff = document
									.getElementById("eastdata_playoff");
							var isEast = true;
							$(east)
									.click(
											function() {
												east.style.background = "#fbfbfb";
												west.style.background = "#e2dede";
												
													eastdata_regular.style.display = "table";
													westdata_regular.style.display = "none";											
											
											});
							$(west)
									.click(
											function() {
												west.style.background = "#fbfbfb";
												east.style.background = "#e2dede";
											
													eastdata_regular.style.display = "none";
													westdata_regular.style.display = "table";											
											});
							
							$(
									'#changjun_defen,#changjun_lanban,#changjun_zhugong,#changjun_qiangduan,#changjun_sanfen,#changjun_gaimao,#danchang_defen,#danchang_lanban,#danchang_zhugong,#danchang_qiangduan,#danchang_sanfen,#danchang_gaimao')
									.click(
											function() {
												$(this).css("background",
														"#fbfbfb");
												$(this).addClass("on");
												$(this).siblings()
														.css("background",
																"#e2dede");
												$(this).siblings().removeClass(
														"on");
												switch ($(this).attr('id')) {
												case 'changjun_defen':
													if ($("#changjun_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_changjun_defen')
																.css("display",
																		"");
														$(
																'#regular_changjun_defen')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_changjun_defen')
																.css("display",
																		"");
														$(
																'#playoff_changjun_defen')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'changjun_lanban':
													if ($("#changjun_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_changjun_lanban')
																.css("display",
																		"");
														$(
																'#regular_changjun_lanban')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_changjun_lanban')
																.css("display",
																		"");
														$(
																'#playoff_changjun_lanban')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'changjun_zhugong':
													if ($("#changjun_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_changjun_zhugong')
																.css("display",
																		"");
														$(
																'#regular_changjun_zhugong')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_changjun_zhugong')
																.css("display",
																		"");
														$(
																'#playoff_changjun_zhugong')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'changjun_qiangduan':
													if ($("#changjun_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_changjun_qiangduan')
																.css("display",
																		"");
														$(
																'#regular_changjun_qiangduan')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_changjun_qiangduan')
																.css("display",
																		"");
														$(
																'#playoff_changjun_qiangduan')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'changjun_sanfen':
													if ($("#changjun_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_changjun_sanfen')
																.css("display",
																		"");
														$(
																'#regular_changjun_sanfen')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_changjun_sanfen')
																.css("display",
																		"");
														$(
																'#playoff_changjun_sanfen')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'changjun_gaimao':
													if ($("#changjun_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_changjun_gaimao')
																.css("display",
																		"");
														$(
																'#regular_changjun_gaimao')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_changjun_gaimao')
																.css("display",
																		"");
														$(
																'#playoff_changjun_gaimao')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												//单场数据
												case 'danchang_defen':
													if ($("#danchang_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_danchang_defen')
																.css("display",
																		"");
														$(
																'#regular_danchang_defen')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_danchang_defen')
																.css("display",
																		"");
														$(
																'#playoff_danchang_defen')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'danchang_lanban':
													if ($("#danchang_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_danchang_lanban')
																.css("display",
																		"");
														$(
																'#regular_danchang_lanban')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_danchang_lanban')
																.css("display",
																		"");
														$(
																'#playoff_danchang_lanban')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'danchang_zhugong':
													if ($("#danchang_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_danchang_zhugong')
																.css("display",
																		"");
														$(
																'#regular_danchang_zhugong')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_danchang_zhugong')
																.css("display",
																		"");
														$(
																'#playoff_danchang_zhugong')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'danchang_qiangduan':
													if ($("#danchang_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_danchang_qiangduan')
																.css("display",
																		"");
														$(
																'#regular_danchang_qiangduan')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_danchang_qiangduan')
																.css("display",
																		"");
														$(
																'#playoff_danchang_qiangduan')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'danchang_sanfen':
													if ($("#danchang_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_danchang_sanfen')
																.css("display",
																		"");
														$(
																'#regular_danchang_sanfen')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_danchang_sanfen')
																.css("display",
																		"");
														$(
																'#playoff_danchang_sanfen')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												case 'danchang_gaimao':
													if ($("#danchang_season_type")[0].childNodes[0].nodeValue
															.replace(/\s+/g, "") == "常规赛") {
														$(
																'#regular_danchang_gaimao')
																.css("display",
																		"");
														$(
																'#regular_danchang_gaimao')
																.siblings()
																.css("display",
																		"none");
													} else {
														$(
																'#playoff_danchang_gaimao')
																.css("display",
																		"");
														$(
																'#playoff_danchang_gaimao')
																.siblings()
																.css("display",
																		"none");
													}
													break;
												}
											});
							$("#changjun a,#danchang a")
									.click(
											function() {
												if ($(this)
														.parents("#changjun").length > 0)
													$("#changjun_season_type")[0].childNodes[0].nodeValue = $(
															this).text()
															+ " ";
												else
													$("#danchang_season_type")[0].childNodes[0].nodeValue = $(
															this).text()
															+ " ";
												if ($(this).text().replace(
														/\s+/g, "") == "常规赛") {
													switch ($(this)
															.parents(
																	".gamecenter_content_r")
															.find(".on").attr(
																	'id')) {
													case 'changjun_defen':
														$(
																'#regular_changjun_defen')
																.css("display",
																		"");
														$(
																'#regular_changjun_defen')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_lanban':
														$(
																'#regular_changjun_lanban')
																.css("display",
																		"");
														$(
																'#regular_changjun_lanban')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_zhugong':
														$(
																'#regular_changjun_zhugong')
																.css("display",
																		"");
														$(
																'#regular_changjun_zhugong')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_qiangduan':
														$(
																'#regular_changjun_qiangduan')
																.css("display",
																		"");
														$(
																'#regular_changjun_qiangduan')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_sanfen':
														$(
																'#regular_changjun_sanfen')
																.css("display",
																		"");
														$(
																'#regular_changjun_sanfen')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_gaimao':
														$(
																'#regular_changjun_gaimao')
																.css("display",
																		"");
														$(
																'#regular_changjun_gaimao')
																.siblings()
																.css("display",
																		"none");
														break;

													case 'danchang_defen':
														$(
																'#regular_danchang_defen')
																.css("display",
																		"");
														$(
																'#regular_danchang_defen')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_lanban':
														$(
																'#regular_danchang_lanban')
																.css("display",
																		"");
														$(
																'#regular_danchang_lanban')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_zhugong':
														$(
																'#regular_danchang_zhugong')
																.css("display",
																		"");
														$(
																'#regular_danchang_zhugong')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_qiangduan':
														$(
																'#regular_danchang_qiangduan')
																.css("display",
																		"");
														$(
																'#regular_danchang_qiangduan')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_sanfen':
														$(
																'#regular_danchang_sanfen')
																.css("display",
																		"");
														$(
																'#regular_danchang_sanfen')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_gaimao':
														$(
																'#regular_danchang_gaimao')
																.css("display",
																		"");
														$(
																'#regular_danchang_gaimao')
																.siblings()
																.css("display",
																		"none");
														break;
													}
												} else {
													switch ($(this)
															.parents(
																	".gamecenter_content_r")
															.find(".on").attr(
																	'id')) {
													case 'changjun_defen':
														$(
																'#playoff_changjun_defen')
																.css("display",
																		"");
														$(
																'#playoff_changjun_defen')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_lanban':
														$(
																'#playoff_changjun_lanban')
																.css("display",
																		"");
														$(
																'#playoff_changjun_lanban')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_zhugong':
														$(
																'#playoff_changjun_zhugong')
																.css("display",
																		"");
														$(
																'#playoff_changjun_zhugong')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_qiangduan':
														$(
																'#playoff_changjun_qiangduan')
																.css("display",
																		"");
														$(
																'#playoff_changjun_qiangduan')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_sanfen':
														$(
																'#playoff_changjun_sanfen')
																.css("display",
																		"");
														$(
																'#playoff_changjun_sanfen')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'changjun_gaimao':
														$(
																'#playoff_changjun_gaimao')
																.css("display",
																		"");
														$(
																'#playoff_changjun_gaimao')
																.siblings()
																.css("display",
																		"none");
														break;

													case 'danchang_defen':
														$(
																'#playoff_danchang_defen')
																.css("display",
																		"");
														$(
																'#playoff_danchang_defen')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_lanban':
														$(
																'#playoff_danchang_lanban')
																.css("display",
																		"");
														$(
																'#playoff_danchang_lanban')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_zhugong':
														$(
																'#playoff_danchang_zhugong')
																.css("display",
																		"");
														$(
																'#playoff_danchang_zhugong')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_qiangduan':
														$(
																'#playoff_danchang_qiangduan')
																.css("display",
																		"");
														$(
																'#playoff_danchang_qiangduan')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_sanfen':
														$(
																'#playoff_danchang_sanfen')
																.css("display",
																		"");
														$(
																'#playoff_danchang_sanfen')
																.siblings()
																.css("display",
																		"none");
														break;
													case 'danchang_gaimao':
														$(
																'#playoff_danchang_gaimao')
																.css("display",
																		"");
														$(
																'#playoff_danchang_gaimao')
																.siblings()
																.css("display",
																		"none");
														break;
													}
												}
											});

						});
	</script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../NBA/js/bootstrap.min.js"></script>
	<script src="../NBA/js/docs.min.js"></script>
	<!-- 导航栏搜索匹配 -->
	<script src="../NBA/js/jquery-ui/jquery-ui.js"></script>
	<script src="../NBA/js/search-autocomplete.js"></script>
	<!-- 加载动画 -->
    <script src="../NBA/js/fakeLoader.min.js"></script>
	<script>
		$('#start').click(
				function() {
					$('#myModal').on(
							'shown.bs.modal',
							function(e) {
								// alert($("#team1").offset().left);
								console.log($("#team1").offset().left + " "
										+ $("#team1").offset().top);
								var myCanvas = document
										.getElementById("myCanvas");
								var context = myCanvas.getContext("2d");
								context.lineWidth = 2;
								context.beginPath();
								context.strokeStyle = "grey";
								var x = 110, y = 70, x_x = 89;
								var interval = 25;
								context.moveTo($("#team1").offset().left - x,
										$("#team1").offset().top - y);
								context.lineTo($("#team1").offset().left - x
										+ interval, $("#team1").offset().top
										- y);
								context.lineTo($("#team1").offset().left - x
										+ interval, $("#team9").offset().top
										- y);
								context.lineTo($("#team9").offset().left - x
										- x_x, $("#team9").offset().top - y);
								context.moveTo($("#team2").offset().left - x,
										$("#team2").offset().top - y);
								context.lineTo($("#team2").offset().left - x
										+ interval, $("#team2").offset().top
										- y);
								context.lineTo($("#team2").offset().left - x
										+ interval, $("#team9").offset().top
										- y);
								context.lineTo($("#team9").offset().left - x
										- x_x, $("#team9").offset().top - y);

								context.moveTo($("#team3").offset().left - x,
										$("#team3").offset().top - y);
								context.lineTo($("#team3").offset().left - x
										+ interval, $("#team3").offset().top
										- y);
								context.lineTo($("#team3").offset().left - x
										+ interval, $("#team10").offset().top
										- y);
								context.lineTo($("#team10").offset().left - x
										- x_x, $("#team10").offset().top - y);
								context.moveTo($("#team4").offset().left - x,
										$("#team4").offset().top - y);
								context.lineTo($("#team4").offset().left - x
										+ interval, $("#team4").offset().top
										- y);
								context.lineTo($("#team4").offset().left - x
										+ interval, $("#team10").offset().top
										- y);
								context.lineTo($("#team10").offset().left - x
										- x_x, $("#team10").offset().top - y);

								context.moveTo($("#team5").offset().left - x,
										$("#team5").offset().top - y);
								context.lineTo($("#team5").offset().left - x
										+ interval, $("#team5").offset().top
										- y);
								context.lineTo($("#team5").offset().left - x
										+ interval, $("#team11").offset().top
										- y);
								context.lineTo($("#team11").offset().left - x
										- x_x, $("#team11").offset().top - y);
								context.moveTo($("#team6").offset().left - x,
										$("#team6").offset().top - y);
								context.lineTo($("#team6").offset().left - x
										+ interval, $("#team6").offset().top
										- y);
								context.lineTo($("#team6").offset().left - x
										+ interval, $("#team11").offset().top
										- y);
								context.lineTo($("#team11").offset().left - x
										- x_x, $("#team11").offset().top - y);

								context.moveTo($("#team7").offset().left - x,
										$("#team7").offset().top - y);
								context.lineTo($("#team7").offset().left - x
										+ interval, $("#team7").offset().top
										- y);
								context.lineTo($("#team7").offset().left - x
										+ interval, $("#team12").offset().top
										- y);
								context.lineTo($("#team12").offset().left - x
										- x_x, $("#team12").offset().top - y);
								context.moveTo($("#team8").offset().left - x,
										$("#team8").offset().top - y);
								context.lineTo($("#team8").offset().left - x
										+ interval, $("#team8").offset().top
										- y);
								context.lineTo($("#team8").offset().left - x
										+ interval, $("#team12").offset().top
										- y);
								context.lineTo($("#team12").offset().left - x
										- x_x, $("#team12").offset().top - y);

								context.moveTo($("#team9").offset().left - x,
										$("#team9").offset().top - y);
								context.lineTo($("#team9").offset().left - x
										+ interval, $("#team9").offset().top
										- y);
								context.lineTo($("#team9").offset().left - x
										+ interval, $("#team13").offset().top
										- y);
								context.lineTo($("#team13").offset().left - x
										- x_x, $("#team13").offset().top - y);
								context.moveTo($("#team10").offset().left - x,
										$("#team10").offset().top - y);
								context.lineTo($("#team10").offset().left - x
										+ interval, $("#team10").offset().top
										- y);
								context.lineTo($("#team10").offset().left - x
										+ interval, $("#team13").offset().top
										- y);
								context.lineTo($("#team13").offset().left - x
										- x_x, $("#team13").offset().top - y);

								context.moveTo($("#team11").offset().left - x,
										$("#team11").offset().top - y);
								context.lineTo($("#team11").offset().left - x
										+ interval, $("#team11").offset().top
										- y);
								context.lineTo($("#team11").offset().left - x
										+ interval, $("#team14").offset().top
										- y);
								context.lineTo($("#team14").offset().left - x
										- x_x, $("#team14").offset().top - y);
								context.moveTo($("#team12").offset().left - x,
										$("#team12").offset().top - y);
								context.lineTo($("#team12").offset().left - x
										+ interval, $("#team12").offset().top
										- y);
								context.lineTo($("#team12").offset().left - x
										+ interval, $("#team14").offset().top
										- y);
								context.lineTo($("#team14").offset().left - x
										- x_x, $("#team14").offset().top - y);

								context.moveTo($("#team13").offset().left - x,
										$("#team13").offset().top - y);
								context.lineTo($("#team13").offset().left - x
										+ interval, $("#team13").offset().top
										- y);
								context.lineTo($("#team13").offset().left - x
										+ interval, $("#team15").offset().top
										- y + 8);
								context.lineTo($("#team15").offset().left - x
										- x_x, $("#team15").offset().top - y
										+ 8);
								context.moveTo($("#team14").offset().left - x,
										$("#team14").offset().top - y);
								context.lineTo($("#team14").offset().left - x
										+ interval, $("#team14").offset().top
										- y);
								context.lineTo($("#team14").offset().left - x
										+ interval, $("#team15").offset().top
										- y + 8);
								context.lineTo($("#team15").offset().left - x
										- x_x, $("#team15").offset().top - y
										+ 8);

								//西部
								context.moveTo($("#team16").offset().left - x
										- x_x, $("#team16").offset().top - y);
								context.lineTo($("#team16").offset().left - x
										- x_x - interval,
										$("#team16").offset().top - y);
								context.lineTo($("#team16").offset().left - x
										- x_x - interval,
										$("#team24").offset().top - y);
								context.lineTo($("#team24").offset().left - x,
										$("#team24").offset().top - y);
								context.moveTo($("#team17").offset().left - x
										- x_x, $("#team17").offset().top - y);
								context.lineTo($("#team17").offset().left - x
										- x_x - interval,
										$("#team17").offset().top - y);
								context.lineTo($("#team17").offset().left - x
										- x_x - interval,
										$("#team24").offset().top - y);
								context.lineTo($("#team24").offset().left - x,
										$("#team24").offset().top - y);

								context.moveTo($("#team18").offset().left - x
										- x_x, $("#team18").offset().top - y);
								context.lineTo($("#team18").offset().left - x
										- x_x - interval,
										$("#team18").offset().top - y);
								context.lineTo($("#team18").offset().left - x
										- x_x - interval,
										$("#team25").offset().top - y);
								context.lineTo($("#team25").offset().left - x,
										$("#team25").offset().top - y);
								context.moveTo($("#team19").offset().left - x
										- x_x, $("#team19").offset().top - y);
								context.lineTo($("#team19").offset().left - x
										- x_x - interval,
										$("#team19").offset().top - y);
								context.lineTo($("#team19").offset().left - x
										- x_x - interval,
										$("#team25").offset().top - y);
								context.lineTo($("#team25").offset().left - x,
										$("#team25").offset().top - y);

								context.moveTo($("#team20").offset().left - x
										- x_x, $("#team20").offset().top - y);
								context.lineTo($("#team20").offset().left - x
										- x_x - interval,
										$("#team20").offset().top - y);
								context.lineTo($("#team20").offset().left - x
										- x_x - interval,
										$("#team26").offset().top - y);
								context.lineTo($("#team26").offset().left - x,
										$("#team26").offset().top - y);
								context.moveTo($("#team21").offset().left - x
										- x_x, $("#team21").offset().top - y);
								context.lineTo($("#team21").offset().left - x
										- x_x - interval,
										$("#team21").offset().top - y);
								context.lineTo($("#team21").offset().left - x
										- x_x - interval,
										$("#team26").offset().top - y);
								context.lineTo($("#team26").offset().left - x,
										$("#team26").offset().top - y);

								context.moveTo($("#team22").offset().left - x
										- x_x, $("#team22").offset().top - y);
								context.lineTo($("#team22").offset().left - x
										- x_x - interval,
										$("#team22").offset().top - y);
								context.lineTo($("#team22").offset().left - x
										- x_x - interval,
										$("#team27").offset().top - y);
								context.lineTo($("#team27").offset().left - x,
										$("#team27").offset().top - y);
								context.moveTo($("#team23").offset().left - x
										- x_x, $("#team23").offset().top - y);
								context.lineTo($("#team23").offset().left - x
										- x_x - interval,
										$("#team23").offset().top - y);
								context.lineTo($("#team23").offset().left - x
										- x_x - interval,
										$("#team27").offset().top - y);
								context.lineTo($("#team27").offset().left - x,
										$("#team27").offset().top - y);

								context.moveTo($("#team24").offset().left - x
										- x_x, $("#team24").offset().top - y);
								context.lineTo($("#team24").offset().left - x
										- x_x - interval,
										$("#team24").offset().top - y);
								context.lineTo($("#team24").offset().left - x
										- x_x - interval,
										$("#team28").offset().top - y);
								context.lineTo($("#team28").offset().left - x,
										$("#team28").offset().top - y);
								context.moveTo($("#team25").offset().left - x
										- x_x, $("#team25").offset().top - y);
								context.lineTo($("#team25").offset().left - x
										- x_x - interval,
										$("#team25").offset().top - y);
								context.lineTo($("#team25").offset().left - x
										- x_x - interval,
										$("#team28").offset().top - y);
								context.lineTo($("#team28").offset().left - x,
										$("#team28").offset().top - y);

								context.moveTo($("#team26").offset().left - x
										- x_x, $("#team26").offset().top - y);
								context.lineTo($("#team26").offset().left - x
										- x_x - interval,
										$("#team26").offset().top - y);
								context.lineTo($("#team26").offset().left - x
										- x_x - interval,
										$("#team29").offset().top - y);
								context.lineTo($("#team29").offset().left - x,
										$("#team29").offset().top - y);
								context.moveTo($("#team27").offset().left - x
										- x_x, $("#team27").offset().top - y);
								context.lineTo($("#team27").offset().left - x
										- x_x - interval,
										$("#team27").offset().top - y);
								context.lineTo($("#team27").offset().left - x
										- x_x - interval,
										$("#team29").offset().top - y);
								context.lineTo($("#team29").offset().left - x,
										$("#team29").offset().top - y);

								context.moveTo($("#team28").offset().left - x
										- x_x, $("#team28").offset().top - y);
								context.lineTo($("#team28").offset().left - x
										- x_x - interval,
										$("#team28").offset().top - y);
								context.lineTo($("#team28").offset().left - x
										- x_x - interval,
										$("#team30").offset().top - y + 8);
								context.lineTo($("#team30").offset().left - x,
										$("#team30").offset().top - y + 8);
								context.moveTo($("#team29").offset().left - x
										- x_x, $("#team29").offset().top - y);
								context.lineTo($("#team29").offset().left - x
										- x_x - interval,
										$("#team29").offset().top - y);
								context.lineTo($("#team29").offset().left - x
										- x_x - interval,
										$("#team30").offset().top - y + 8);
								context.lineTo($("#team30").offset().left - x,
										$("#team30").offset().top - y + 8);

								context.moveTo($("#team15").offset().left - x
										- x_x, $("#team15").offset().top - y
										+ 8);
								context.lineTo($("#team30").offset().left - x
										- x_x, $("#team30").offset().top - y
										+ 8);
								context.stroke();
							});
				});
	</script>
	
</body>
</html>