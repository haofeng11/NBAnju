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
<title>球员对比</title>
    <!-- Bootstrap -->
    <link href="../NBA/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../NBA/js/jquery-ui/jquery-ui.css">
    <link href="../NBA/css/new.css" rel="stylesheet">
    <!-- Highchart图表JS库 -->
    <script type="text/javascript" src="../NBA/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="../NBA/js/highcharts/highcharts.js"></script>
    <script type="text/javascript" src="../NBA/js/highcharts/highcharts-more.js"></script>
    
    <script type="text/javascript" src="../NBA/js/highcharts/modules/exporting.js"></script>
    
     <script type="text/javascript">
       function compare() {
		   var name1=eval(document.getElementById("1")).value;
		   var name2=eval(document.getElementById("2")).value;
		   //alert(name1);
		   //alert(name2);
		   post('compare',{'firstName':name1,'secondName':name2});
	   }
       
       function post(URL, PARAMS) {      
    	    var temp = document.createElement("form");      
    	    temp.action = URL;      
    	    temp.method = "get";      
    	    temp.style.display = "none";      
    	    for (var x in PARAMS) {      
    	        var opt = document.createElement("textarea");      
    	        opt.name = x;      
    	        opt.value = PARAMS[x];      
    	        // alert(opt.name)      
    	        temp.appendChild(opt);      
    	    }      
    	    document.body.appendChild(temp);      
    	    temp.submit();      
    	    return temp;      
    	}  

     </script>
	

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
       window.open("${path}/player/picture/"+document.getElementByName("cName1").value) ;
    <![endif]-->
    

</head>
<body>
          <!-- 导航栏 -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" href="${path.concat('/NBA/main.jsp')}">NBA数据分析网</a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li><a href="${path.concat('/NBA/main.jsp')}">球员</a></li>
            <li><a href="${path.concat('/NBA/team.jsp')}">球队</a></li>
            <li><a href="${path.concat('/game/game')}">比赛</a></li>
            <li class="active"><a href="${path.concat('/player/comparison')}">球员对比</a></li>
            <li><a href="${path.concat('/comparisonArea')}">分区对比</a></li>
          </ul>
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group form-group-sm">
              <input id="search" type="text" class="form-control" placeholder="搜索球员或者球队">
            </div>
          </form>
          <ul class="nav navbar-nav navbar-right hidden-sm">
            <li><a href="/about/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'about'])">管理员登录</a></li>
          </ul>
        </div>
      </div>
    </div> <!-- 导航栏 -->
	
	<!-- 选择球员 -->
    <div class="bs-docs-header" id="content" style="background-image:url('../NBA/images/compare_player.jpg');">
      <div class="container">
      	    <div class="row">
      	    	<div class="col-md-2"></div>
      	    	<div class="col-md-8">
      	    		<div class="col-md-4 compareinput">
      	    			<form role="form" action="${path.concat('/player/picture1')}" method="get">
						    <div class="input-group search">
						      <input type="text" class="form-control" name="cName" id="1" placeholder="请输入球员姓名" value="${name1 }">
						      <span class="input-group-btn">
						        <input type="submit" class="form-control" value="搜索">						        	
						      </span>
						    </div><!-- /input-group -->
						</form>
						<img class="img-rounded" src="../NBA/${picture1 }" />
      	    		</div>
      	    		<div class="col-md-4 compare">
      	    			<img src="../NBA/images/vs.png" />
      	    			<button type="button" class="btn btn-danger btn-lg" onclick="compare()">开始对比</button>
      	    		</div>
      	    		<div class="col-md-4 compareinput">
      	    			<form  role="form" action="${path.concat('/player/picture2')}" method="get">
						    <div class="input-group search">
						      <input type="text" class="form-control" name="cName" id="2" placeholder="请输入球员姓名" value="${name2 }">
						      <span class="input-group-btn">
						        <input type="submit" class="form-control" value="搜索">		
						      </span>
						    </div><!-- /input-group -->
						</form>
						<img class="img-rounded" src="../NBA/${picture2 }" />
      	    		</div>
      	    	</div>
      	    	<div class="col-md-2"></div>
      	    </div>
      	</div>
  	</div>

  	<!-- 对比数据 -->
	<div class="container bs-docs-container comparedata">
      	<div class="row">
          	<div class="col-md-12" role="main">
          		<div class="bs-docs-section">
					<h2 class="page-header">数据对比</h2>
					<div id="data-container" style="min-width: 260px; height: 400px; margin: 0 auto">
              		</div>
          		</div>
            	<div class="bs-docs-section">
	              	<h2 class="page-header">交手数据</h2>
	              	<table class="table table-bordered table-striped table-hover" style="width: 100%;">
						<thead>
							<tr>
								<th>场均交手数据(共${number }场)</th>
								<th>胜负次数</th>
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
							<tr>
								<td>${firstName }</td>
								<td>${P1Win }胜 ${P2Win }负</td>
								<td>${playerSingleGamesAverageP1.playTime }</td>
								<td>${playerSingleGamesAverageP1.shootPercentage }</td>
								<td>${playerSingleGamesAverageP1.shootHit }</td>
								<td>${playerSingleGamesAverageP1.shootTotal }</td>
								<td>${playerSingleGamesAverageP1.threePercentage }</td>
								<td>${playerSingleGamesAverageP1.threeHit }</td>
								<td>${playerSingleGamesAverageP1.threeTotal }</td>
								<td>${playerSingleGamesAverageP1.freeThrowPercentage }</td>
								<td>${playerSingleGamesAverageP1.freeThrowHit }</td>
								<td>${playerSingleGamesAverageP1.freeThrowTotal }</td>
								<td>${playerSingleGamesAverageP1.rebound }</td>
								<td>${playerSingleGamesAverageP1.offensiveRebound }</td>
								<td>${playerSingleGamesAverageP1.defensiveRebound }</td>
								<td>${playerSingleGamesAverageP1.assistance }</td>
								<td>${playerSingleGamesAverageP1.grab }</td>
								<td>${playerSingleGamesAverageP1.block }</td>
								<td>${playerSingleGamesAverageP1.mistake }</td>
								<td>${playerSingleGamesAverageP1.foul }</td>
								<td>${playerSingleGamesAverageP1.score }</td>

							</tr>
							<tr>
								<td>${secondName }</td>
								<td>${P2Win }胜 ${P1Win }负</td>
								<td>${playerSingleGamesAverageP2.playTime }</td>
								<td>${playerSingleGamesAverageP2.shootPercentage }</td>
								<td>${playerSingleGamesAverageP2.shootHit }</td>
								<td>${playerSingleGamesAverageP2.shootTotal }</td>
								<td>${playerSingleGamesAverageP2.threePercentage }</td>
								<td>${playerSingleGamesAverageP2.threeHit }</td>
								<td>${playerSingleGamesAverageP2.threeTotal }</td>
								<td>${playerSingleGamesAverageP2.freeThrowPercentage }</td>
								<td>${playerSingleGamesAverageP2.freeThrowHit }</td>
								<td>${playerSingleGamesAverageP2.freeThrowTotal }</td>
								<td>${playerSingleGamesAverageP2.rebound }</td>
								<td>${playerSingleGamesAverageP2.offensiveRebound }</td>
								<td>${playerSingleGamesAverageP2.defensiveRebound }</td>
								<td>${playerSingleGamesAverageP2.assistance }</td>
								<td>${playerSingleGamesAverageP2.grab }</td>
								<td>${playerSingleGamesAverageP2.block }</td>
								<td>${playerSingleGamesAverageP2.mistake }</td>
								<td>${playerSingleGamesAverageP2.foul }</td>
								<td>${playerSingleGamesAverageP2.score }</td>

							</tr>
						</tbody>
					</table>

					<!-- 选择场次 -->
					
					<div class="btn-group">
					  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
					    选择场次 <span class="caret"></span>
					  </button>
					  <ul class="dropdown-menu" role="menu">
					  	<c:forEach items="${gameList }" var="g" >
						    <li><a href="./singleGame?gameID=${g.gameID }">${g.seasonID } 常规赛 ${g.homeTeam }${g.homeScore }-${g.guestTeam }${g.guestScore }</a></li>     
						 </c:forEach>
					  <!--
					    <li><a href="#">96-97 常规赛 公牛129-123湖人</a></li>
					    <li><a href="#">96-97 常规赛 公牛90-106湖人</a></li>
					    <li><a href="#">97-98 常规赛 公牛104-83湖人</a></li>
					    <li><a href="#">97-98 常规赛 公牛87-112湖人</a></li>
					    <li><a href="#">01-02 常规赛 奇才94-103湖人</a></li>
						-->
					  </ul>
					</div>
					
					<table class="table table-bordered table-striped table-hover" style="width: 100%;">
						<thead>
							<tr>
								<th>${game.homeTeam }${game.homeScore }-${game.guestTeam }${game.guestScore }</th>
								<th>球队</th>
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
							<tr>
								<td>${P1.player }</a></td>
								<td>${P1.team }</td>
								<td>${P1.playTime }</td>
								<td>${P1.shootPercentage }</td>
								<td>${P1.shootHit }</td>
								<td>${P1.shootTotal }</td>
								<td>${P1.threePercentage }</td>
								<td>${P1.threeHit }</td>
								<td>${P1.threeTotal }</td>
								<td>${P1.freeThrowPercentage }</td>
								<td>${P1.freeThrowHit }</td>
								<td>${P1.freeThrowTotal }</td>
								<td>${P1.rebound }</td>
								<td>${P1.offensiveRebound }</td>
								<td>${P1.defensiveRebound }</td>
								<td>${P1.assistance }</td>
								<td>${P1.grab }</td>
								<td>${P1.block }</td>
								<td>${P1.mistake }</td>
								<td>${P1.foul }</td>
								<td>${P1.score }</td>
							</tr>
							<tr>
								<td>${P2.player }</a></td>
								<td>${P2.team }</td>
								<td>${P2.playTime }</td>
								<td>${P2.shootPercentage }</td>
								<td>${P2.shootHit }</td>
								<td>${P2.shootTotal }</td>
								<td>${P2.threePercentage }</td>
								<td>${P2.threeHit }</td>
								<td>${P2.threeTotal }</td>
								<td>${P2.freeThrowPercentage }</td>
								<td>${P2.freeThrowHit }</td>
								<td>${P2.freeThrowTotal }</td>
								<td>${P2.rebound }</td>
								<td>${P2.offensiveRebound }</td>
								<td>${P2.defensiveRebound }</td>
								<td>${P2.assistance }</td>
								<td>${P2.grab }</td>
								<td>${P2.block }</td>
								<td>${P2.mistake }</td>
								<td>${P2.foul }</td>
								<td>${P2.score }</td>
							</tr>
						</tbody>
					</table>
            	</div>
        	</div>
       	</div>
    </div>

    <!-- Footer
	================================================== -->
	<footer class="bs-docs-footer" role="contentinfo">
	  <div class="container">
	    <p>All content copyright NBA数据分析网 © 2015 • All rights reserved.
	    Proudly published with NBA Data Analysis</p>
	    <p>本项目源码采用 <a href="http://v3.bootcss.com/" target="_blank">Bootstrap</a> 和 <a href="http://jquery.com/">jQuery</a> 开源框架.主要数据来源自<a href="http://creativecommons.org/licenses/by/3.0/">StatNBA数据</a></p>
	    <ul class="bs-docs-footer-links text-muted">
	      <li>当前版本： v1.0.0</li>
	      <li>&middot;</li>
	      <li><a href="nba.hupu.com">虎扑·篮球</a></li>
	      <li>&middot;</li>
	      <li><a href="http://sports.sina.com.cn/nba/">新浪NBA</a></li>
	      <li>&middot;</li>
	      <li><a href="http://china.nba.com/">NBA中国</a></li>
	      <li>&middot;</li>
	      <li><a href="../about/">关于</a></li>
	    </ul>
	  </div>
	</footer>


	<!-- HighchartJS -->
	<script type="text/javascript">
	// 蛛网图
      $(function () {
          $('#data-container').highcharts({
              chart: {
                  polar: true,
                  type: 'line'
              },
              
              title: {
                  text: '',
                  x: 0
              },
              pane: {
                size: '80%'
              },
              // 去掉额外元素
              legend: {
                enabled: true
              },
              exporting: {
                enabled: false
              },
              credits: {
                enabled: false
              },
              xAxis: {
                  categories: ['场均得分', '场均助攻', '场均篮板', '场均抢断', '场均盖帽', '场均失误', 'PER', '命中率'],
                  tickmarkPlacement: 'on',
                  lineWidth: 0
              },
                  
              yAxis: [{
                  gridLineInterpolation: 'polygon',
                  lineWidth: 1,
                  min: 0
              },{
                  gridLineInterpolation: 'polygon',
                  lineWidth: 1,
                  min: 0
              },{
                  gridLineInterpolation: 'polygon',
                  lineWidth: 0,
                  min: 0
              },{
                  gridLineInterpolation: 'polygon',
                  lineWidth: 0,
                  min: 0
              },{
                  gridLineInterpolation: 'polygon',
                  lineWidth: 0,
                  min: 0
              },{
                  gridLineInterpolation: 'polygon',
                  lineWidth: 0,
                  min: 0
              },{
                  gridLineInterpolation: 'polygon',
                  lineWidth: 0,
                  min: 0
              },{
                  gridLineInterpolation: 'polygon',
                  lineWidth: 0,
                  min: 0
              }],
              
              tooltip: {
                shared: true,
                valueDecimals:0,
                pointFormat: '{series.name}<b>{point.y}</b><br/>'
              },
              
              
              series: [{
                  name: '${firstName }',
                  data: [${scoreAverageP1 },${assistanceAverageP1 },${reboundAverageP1 },${grabAverageP1 },${blockAverageP1 },${mistakeAverageP1 },${PERAverageP1 },${shootPercentageAverageP1 }],
                  pointPlacement: 'on'
              },{
                  name: '${secondName }',
                  data: [${scoreAverageP2 },${assistanceAverageP2 },${reboundAverageP2 },${grabAverageP2 },${blockAverageP2 },${mistakeAverageP2 },${PERAverageP2 },${shootPercentageAverageP2 }],
                  pointPlacement: 'on'
              }]             
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