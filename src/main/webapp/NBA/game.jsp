<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html >
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>比赛</title>
<!-- Bootstrap -->
    <link href="../NBA/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../NBA/js/jquery-ui/jquery-ui.css">
    <link href="../NBA/css/new.css" rel="stylesheet">
    <!-- Highchart图表JS库 -->
    <script type="text/javascript" src="../NBA/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="../NBA/js/highcharts/highcharts.js"></script>
    <script type="text/javascript" src="../NBA/js/highcharts/highcharts-more.js"></script>
    <script type="text/javascript" src="../NBA/js/highcharts/themes/custom.js"></script>
    <script type="text/javascript" src="../NBA/js/highcharts/modules/exporting.js"></script>

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
				 <a class="navbar-brand hidden-sm" href="${path.concat('/NBA/main.jsp')}">NBA数据分析网</a>
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
							action="./gameSchedule">
							<div class="form-group">
								<select class="form-control" style="" name="seasonId">
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
									style="text-align: center;" size="45">
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
							<div class="tiltle" conference="W">
								<span class="tiltle_a" style="width: 248px;"><div
										class="btn-group">
										<button type="button"
											class="btn btn-link btn-xs dropdown-toggle"
											data-toggle="dropdown" aria-expanded="false"
											style="margin-top: -8px; font-size: 16px; color: #000000;"
											id="zhanji_season_type">
											常规赛 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" id="zhanji" role="menu">
											<li><a href="javascript:void(0);">常规赛</a></li>
											<li><a href="javascript:void(0);">季后赛</a></li>
										</ul>
									</div></span>
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
											<td width="25" height="35">${regularEast.rank}</td>
											<c:set var="temp" value="${path.concat('/team/')}"></c:set>
											<c:set var="temp2" value="${temp.concat(regularEast.team)}"></c:set>
											<td width="55"><a target="_blank" href="${temp2}">${regularEast.team}</a></td>
											<td width="20">${regularEast.winGame}</td>
											<td width="25">${regularEast.loseGame}</td>
											<td width="25">${regularEast.winGap}</td>
											<td>${regularEast.victory}</td>
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
											<td width="25" height="35">${regularWest.rank}</td>
											<c:set var="temp" value="${path.concat('/team/')}"></c:set>
											<c:set var="temp2" value="${temp.concat(regularWest.team)}"></c:set>
											<td width="55"><a target="_blank" href="${temp2}">${regularWest.team}</a></td>
											<td width="20">${regularWest.winGame}</td>
											<td width="25">${regularWest.loseGame}</td>
											<td width="25">${regularWest.winGap}</td>
											<td>${regularWest.victory}</td>
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
								<td width="150"></td>
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
								<tr class=" bg_color">
									<c:forEach items="${playerScoreRank}" var="ScoreTopten">
										<td width="40" height="35">${ScoreTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${ScoreTopten.team}" href="/nba/teams/hawks">${ScoreTopten.team}</a></td>
										<td width="35">${ScoreTopten.score}分</td>
									</c:forEach>
								</tr>
							</tbody>
							<tbody id="playoff_changjun_defen" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerOffScoreRank}"
										var="PlayoffScoreTopten">
										<td width="40" height="35">${PlayoffScoreTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffScoreTopten.team}" href="/nba/teams/hawks">${PlayoffScoreTopten.team}</a></td>
										<td width="35">${PlayoffScoreTopten.score}分</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="regular_changjun_lanban" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerReboundRank}" var="ReboundTopten">
										<td width="40" height="35">${ReboundTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${ReboundTopten.team}" href="/nba/teams/hawks">${ReboundTopten.team}</a></td>
										<td width="35">${ReboundTopten.rebound}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="playoff_changjun_lanban" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playeroffReboundRank}"
										var="PlayoffReboundTopten">
										<td width="40" height="35">${PlayoffReboundTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffReboundTopten.team}" href="/nba/teams/hawks">${PlayoffReboundTopten.team}</a></td>
										<td width="35">${PlayoffReboundTopten.rebound}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="regular_changjun_zhugong" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerAssistanceRank}"
										var="AssistanceTopten">
										<td width="40" height="35">${AssistanceTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${AssistanceTopten.team}" href="/nba/teams/hawks">${AssistanceTopten.team}</a></td>
										<td width="35">${AssistanceTopten.assistance}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="playoff_changjun_zhugong" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerOffAssistanceRank}"
										var="PlayoffAssistanceTopten">
										<td width="40" height="35">${PlayoffAssistanceTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffAssistanceTopten.team}"
											href="/nba/teams/hawks">${PlayoffAssistanceTopten.team}</a></td>
										<td width="35">${PlayoffAssistanceTopten.assistance}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="regular_changjun_qiangduan" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerGrabRank}" var="GrabTopten">
										<td width="40" height="35">${GrabTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${GrabTopten.team}" href="/nba/teams/hawks">${GrabTopten.team}</a></td>
										<td width="35">${GrabTopten.grab}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="playoff_changjun_qiangduan" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerOffGrabRank}" var="PlayoffGrabTopten">
										<td width="40" height="35">${PlayoffGrabTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffGrabTopten.team}" href="/nba/teams/hawks">${PlayoffGrabTopten.team}</a></td>
										<td width="35">${PlayoffGrabTopten.grab}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="regular_changjun_sanfen" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerThreehitRank}" var="ThreehitTopten">
										<td width="40" height="35">${ThreehitTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${ThreehitTopten.team}" href="/nba/teams/hawks">${ThreehitTopten.team}</a></td>
										<td width="35">${ThreehitTopten.threeHit}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="playoff_changjun_sanfen" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerOffThreehitRank}"
										var="PlayoffThreehitTopten">
										<td width="40" height="35">${PlayoffThreehitTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffThreehitTopten.team}" href="/nba/teams/hawks">${PlayoffThreehitTopten.team}</a></td>
										<td width="35">${PlayoffThreehitTopten.threeHit}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="regular_changjun_gaimao" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerBlockRank}" var="BlockTopten">
										<td width="40" height="35">${BlockTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${BlockTopten.team}" href="/nba/teams/hawks">${BlockTopten.team}</a></td>
										<td width="35">${BlockTopten.block}</td>
									</c:forEach>
								</tr>
							</tbody>

							<tbody id="playoff_changjun_gaimao" style="display: none;">
								<tr class=" bg_color">
									<c:forEach items="${playerOffBlockRank}"
										var="PlayoffBlockTopten">
										<td width="40" height="35">${PlayoffBlockTopten.player}</td>
										<td width="35"><a target="_blank"
											title="${PlayoffBlockTopten.team}" href="/nba/teams/hawks">${BlockTopten.team}</a></td>
										<td width="35">${PlayoffBlockTopten.block}</td>
									</c:forEach>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>

	<script type="text/javascript">
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
												if ($("#zhanji_season_type")[0].childNodes[0].nodeValue
														.replace(/\s+/g, "") == "常规赛") {
													eastdata_regular.style.display = "table";
													westdata_regular.style.display = "none";
												} else {
													eastdata_playoff.style.display = "table";
													westdata_playoff.style.display = "none";
												}
												isEast = true;
											});
							$(west)
									.click(
											function() {
												west.style.background = "#fbfbfb";
												east.style.background = "#e2dede";
												if ($("#zhanji_season_type")[0].childNodes[0].nodeValue
														.replace(/\s+/g, "") == "常规赛") {
													eastdata_regular.style.display = "none";
													westdata_regular.style.display = "table";
												} else {
													eastdata_playoff.style.display = "none";
													westdata_playoff.style.display = "table";
												}
												isEast = false;
											});
							$("#zhanji a")
									.click(
											function() {
												$("#zhanji_season_type")[0].childNodes[0].nodeValue = $(
														this).text()
														+ " ";
												if ($(this).text().replace(
														/\s+/g, "") == "常规赛") {
													if (isEast) {
														eastdata_regular.style.display = "table";
														eastdata_playoff.style.display = "none";
													} else {
														westdata_regular.style.display = "table";
														westdata_playoff.style.display = "none";
													}
												} else {
													if (isEast) {
														eastdata_regular.style.display = "none";
														eastdata_playoff.style.display = "table";
													} else {
														westdata_regular.style.display = "none";
														westdata_playoff.style.display = "table";
													}
												}
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
</body>
</html>