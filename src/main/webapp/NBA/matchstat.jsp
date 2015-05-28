<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赛后数据</title>

    <!-- 加载动画 -->
    <link rel="stylesheet" href=${path.concat("/NBA/css/fakeLoader.css")}>
    <!-- 加载动画 -->
    <div class="fakeloader"></div>
<!-- Bootstrap -->
<link
	href="http://localhost:8080/NBADataAnalysis/NBA/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://localhost:8080/NBADataAnalysis/NBA/js/jquery-ui/jquery-ui.css">
<link href="http://localhost:8080/NBADataAnalysis/NBA/css/new.css"
	rel="stylesheet">
<!-- Highchart图表JS库 -->
<script type="text/javascript"
	src="http://localhost:8080/NBADataAnalysis/NBA/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/NBADataAnalysis/NBA/js/highcharts/highcharts.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/NBADataAnalysis/NBA/js/highcharts/highcharts-more.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/NBADataAnalysis/NBA/js/highcharts/themes/custom.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/NBADataAnalysis/NBA/js/highcharts/modules/exporting.js"></script>


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
					<li><a href="../NBA/main.html">球员</a></li>
					<li><a href="../NBA/team.html">球队</a></li>
					<li><a href="${path.concat('/game/game')}">比赛</a></li>
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

	<!-- 直播信息 -->
	<div class="bs-docs-header" id="content">
		<div class="container"
			style="padding-top: 20px; padding-bottom: 60px;">
			<div class="row">
				<!-- <div class="col-md-1"></div> -->
				<div class="col-md-12">
					<div class="col-md-2">
						<!-- 球队头像高100px -->
						<img src="${homeTeamPicture }" style="float: right" alt="${game.homeTeam}">
					</div>
					<div class="col-md-8">
						<div class="col-md-2 homegoal">
							<span id="">${game.homeScore}</span>
							<p>${game.homeTeam}</p>
						</div>
						<div class="col-md-8 goal">
							<table
								class="table table-bordered table-condensed table-hover statistics">
								<tr>
									<td></td>
									<td>第一节</td>
									<td>第二节</td>
									<td>第三节</td>
									<td>第四节</td>
									<td>总分</td>
								</tr>
								<tr>
									<td>${game.homeTeam}</td>
									<th>${game.firstHomeScore}</th>
									<th>${game.secondHomeScore}</th>
									<th>${game.thirdHomeScore}</th>
									<th>${game.fourthHomeScore}</th>
									<th>${game.homeScore}</th>
								</tr>
								<tr>
									<td>${game.guestTeam}</td>
									<th>${game.firstGuestScore}</th>
									<th>${game.firstGuestScore}</th>
									<th>${game.firstGuestScore}</th>
									<th>${game.firstGuestScore}</th>
									<th>${game.guestScore}</th>
								</tr>
							</table>
						</div>
						<div class="col-md-2 visitgoal">
							<span id="">${game.guestScore}</span>
							<p>${game.guestTeam}</p>
						</div>
					</div>
					<div class="col-md-2">
						<!-- 球队头像大小选择100px -->
						<img src="${guestTeamPicture }" style="float: left" alt="${game.guestTeam}">
					</div>
				</div>
				<!-- <div class="col-md-1"></div> -->
			</div>
		</div>
	</div>

	<div class="container bs-docs-container">
		<div class="row">
			<div class="col-md-12">
				<div class="bs-docs-section comparedata">
					<h2 class="page-header">${game.homeTeam}</h2>
					<table class="table table-bordered table-striped table-hover"
						style="width: 100%;">
						<thead>
							<tr>
								<th>球员</th>
								<th>首发</th>
								<th>时间</th>
								<th>投篮</th>
								<th>命中</th>
								<th>出手</th>
								<th>三分</th>
								<th>命中</th>
								<th>出手</th>
								<th>罚球</th>
								<th>命中</th>
								<th>出手</th>
								<th>篮板</th>
								<th>前场</th>
								<th>后场</th>
								<th>助攻</th>
								<th>抢断</th>
								<th>盖帽</th>
								<th>失误</th>
								<th>犯规</th>
								<th>得分</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${homePlayerList}" var="homePlayer">
								<tr>
									<td>${homePlayer.player}</a></td>
									<td>${homePlayer.isFirst}</td>
									<td>${homePlayer.playTime}</td>
									<td>${homePlayer.shootPercentage}</td>
									<td>${homePlayer.shootHit }</td>
									<td>${homePlayer.shootTotal }</td>
									<td>${homePlayer.threePercentage }</td>
									<td>${homePlayer.threeHit }</td>
									<td>${homePlayer.threeTotal }</td>
									<td>${homePlayer.freeThrowPercentage }</td>
									<td>${homePlayer.freeThrowHit }</td>
									<td>${homePlayer.freeThrowTotal }</td>
									<td>${homePlayer.rebound }</td>
									<td>${homePlayer.offensiveRebound }</td>
									<td>${homePlayer.defensiveRebound }</td>
									<td>${homePlayer.assistance }</td>
									<td>${homePlayer.grab }</td>
									<td>${homePlayer.block }</td>
									<td>${homePlayer.mistake }</td>
									<td>${homePlayer.foul }</td>
									<td>${homePlayer.score }</td>
								</tr>
							</c:forEach>

							<tr>
								<td>总计</a></td>
								<td></td>
								<td></td>
								<td>${homeTeamData.shootPercentage}</td>
								<td>${homeTeamData.shootHit }</td>
								<td>${homeTeamData.shootTotal }</td>
								<td>${homeTeamData.threePercentage }</td>
								<td>${homeTeamData.threeHit }</td>
								<td>${homeTeamData.threeTotal }</td>
								<td>${homeTeamData.freeThrowPercentage }</td>
								<td>${homeTeamData.freeThrowHit }</td>
								<td>${homeTeamData.freeThrowTotal }</td>
								<td>${homeTeamData.rebound }</td>
								<td>${homeTeamData.offensiveRebound }</td>
								<td>${homeTeamData.defensiveRebound }</td>
								<td>${homeTeamData.assistance }</td>
								<td>${homeTeamData.grab }</td>
								<td>${homeTeamData.block }</td>
								<td>${homeTeamData.mistake }</td>
								<td>${homeTeamData.foul }</td>
								<td>${homeTeamData.score }</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="bs-docs-section comparedata">
					<h2 class="page-header">${game.guestTeam}</h2>
					<table class="table table-bordered table-striped table-hover"
						style="width: 100%;">
						<thead>
							<tr>
								<th>球员</th>
								<th>首发</th>
								<th>时间</th>
								<th>投篮</th>
								<th>命中</th>
								<th>出手</th>
								<th>三分</th>
								<th>命中</th>
								<th>出手</th>
								<th>罚球</th>
								<th>命中</th>
								<th>出手</th>
								<th>篮板</th>
								<th>前场</th>
								<th>后场</th>
								<th>助攻</th>
								<th>抢断</th>
								<th>盖帽</th>
								<th>失误</th>
								<th>犯规</th>
								<th>得分</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${guestPlayerList}" var="guestPlayer">
								<tr>
									<td>${guestPlayer.player}</a></td>
									<td>${guestPlayer.isFirst}</td>
									<td>${guestPlayer.playTime}</td>
									<td>${guestPlayer.shootPercentage}</td>
									<td>${guestPlayer.shootHit }</td>
									<td>${guestPlayer.shootTotal }</td>
									<td>${guestPlayer.threePercentage }</td>
									<td>${guestPlayer.threeHit }</td>
									<td>${guestPlayer.threeTotal }</td>
									<td>${guestPlayer.freeThrowPercentage }</td>
									<td>${guestPlayer.freeThrowHit }</td>
									<td>${guestPlayer.freeThrowTotal }</td>
									<td>${guestPlayer.rebound }</td>
									<td>${guestPlayer.offensiveRebound }</td>
									<td>${guestPlayer.defensiveRebound }</td>
									<td>${guestPlayer.assistance }</td>
									<td>${guestPlayer.grab }</td>
									<td>${guestPlayer.block }</td>
									<td>${guestPlayer.mistake }</td>
									<td>${guestPlayer.foul }</td>
									<td>${guestPlayer.score }</td>
								</tr>
							</c:forEach>

							<tr>
								<td>总计</a></td>
								<td></td>
								<td></td>
								<td>${guestTeamData.shootPercentage}</td>
								<td>${guestTeamData.shootHit }</td>
								<td>${guestTeamData.shootTotal }</td>
								<td>${guestTeamData.threePercentage }</td>
								<td>${guestTeamData.threeHit }</td>
								<td>${guestTeamData.threeTotal }</td>
								<td>${guestTeamData.freeThrowPercentage }</td>
								<td>${guestTeamData.freeThrowHit }</td>
								<td>${guestTeamData.freeThrowTotal }</td>
								<td>${guestTeamData.rebound }</td>
								<td>${guestTeamData.offensiveRebound }</td>
								<td>${guestTeamData.defensiveRebound }</td>
								<td>${guestTeamData.assistance }</td>
								<td>${guestTeamData.grab }</td>
								<td>${guestTeamData.block }</td>
								<td>${guestTeamData.mistake }</td>
								<td>${guestTeamData.foul }</td>
								<td>${guestTeamData.score }</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="http://localhost:8080/NBADataAnalysis/NBA/js/bootstrap.min.js"></script>
	<script src="http://localhost:8080/NBADataAnalysis/NBA/js/docs.min.js"></script>
	<!-- 导航栏搜索匹配 -->
	<script
		src="http://localhost:8080/NBADataAnalysis/NBA/js/jquery-ui/jquery-ui.js"></script>
	<script
		src="http://localhost:8080/NBADataAnalysis/NBA/js/search-autocomplete.js"></script>
		<!-- 加载动画 -->
    <script src="http://localhost:8080/NBADataAnalysis/NBA/js/fakeLoader.min.js"></script>

</body>
</html>