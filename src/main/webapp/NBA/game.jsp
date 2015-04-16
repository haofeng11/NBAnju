<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比赛</title>
<!-- Bootstrap -->
    <link href="http://localhost:8080/NBADataAnalysis/NBA/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://localhost:8080/NBADataAnalysis/NBA/js/jquery-ui/jquery-ui.css">
    <link href="http://localhost:8080/NBADataAnalysis/NBA/css/new.css" rel="stylesheet">
    <!-- Highchart图表JS库 -->
    <script type="text/javascript" src="http://localhost:8080/NBADataAnalysis/NBA/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="http://localhost:8080/NBADataAnalysis/NBA/js/highcharts/highcharts.js"></script>
    <script type="text/javascript" src="http://localhost:8080/NBADataAnalysis/NBA/js/highcharts/highcharts-more.js"></script>
    <script type="text/javascript" src="http://localhost:8080/NBADataAnalysis/NBA/js/highcharts/themes/custom.js"></script>
    <script type="text/javascript" src="http://localhost:8080/NBADataAnalysis/NBA/js/highcharts/modules/exporting.js"></script>
<script>
  $(function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
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
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" href="main.html">NBA数据分析网</a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li><a href="../NBA/main.html">球员</a></li>
            <li><a href="../NBA/team.html">球队</a></li>
            <li class="active"><a href="../game/games">比赛</a></li>
            <li><a href="comparison.html">球员对比</a></li>
            <li><a href="comparison_area.html">分区对比</a></li>
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
     <div class="game">
    	<div class="container">
    		<div class="row">
    			<div class = "col-md-12">
    				<div class="col-md-3">
    				</div>
    				<!-- 选择场次 -->
    				<div class="col-md-6">
						<form class="form-inline" style="margin-top:10px;" action="./NBADataAnalysis/">
						  <div class="form-group">
						    <select class="form-control" style="">
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
							</select>
							<input type="text" class="form-control" id="datepicker" placeholder="点击选择日期" style="text-align: center;" size="45">
						  </div>
						  <button type="submit" class="btn btn-default" style="float:right;">查看数据</button>
						</form>
					</div>
					<div class="col-md-3">
					</div>
    			</div>
    			<div class="col-md-3">
    				<div class="gamecenter_content_r">
						<div class="region_box">
							<h4>球队战绩</h4>
							<div class="tiltle" conference="W">
								<span class="tiltle_a" id="east">东部</span><span class="tiltle_b" id="west">西部</span>
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
                    	<table class="itinerary_table itinerary_table_show" id="westdata">
                        <tbody>
                                <tr class=" bg_color">
	                                <td width="25" height="35">1</td>
	                                <td width="55"><a target="_blank" title="老鹰" href="/nba/teams/hawks">老鹰</a></td>
	                                <td width="20">38</td>
	                                <td width="25">8</td>
	                                <td width="25">0</td>
	                                <td>82.6%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">2</td>
	                                <td width="55"><a target="_blank" title="猛龙" href="/nba/teams/raptors">猛龙</a></td>
	                                <td width="20">31</td>
	                                <td width="25">15</td>
	                                <td width="25">7</td>
	                                <td>67.4%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">3</td>
	                                <td width="55"><a target="_blank" title="奇才" href="/nba/teams/wizards">奇才</a></td>
	                                <td width="20">31</td>
	                                <td width="25">16</td>
	                                <td width="25">7.5</td>
	                                <td>66.0%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">4</td>
	                                <td width="55"><a target="_blank" title="公牛" href="/nba/teams/bulls">公牛</a></td>
	                                <td width="20">30</td>
	                                <td width="25">17</td>
	                                <td width="25">8.5</td>
	                                <td>63.8%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">5</td>
	                                <td width="55"><a target="_blank" title="骑士" href="/nba/teams/cavaliers">骑士</a></td>
	                                <td width="20">27</td>
	                                <td width="25">20</td>
	                                <td width="25">11.5</td>
	                                <td>57.4%</td>
	                            </tr>
	                                                        <tr class="">
	                                <td width="25" height="35">6</td>
	                                <td width="55"><a target="_blank" title="雄鹿" href="/nba/teams/bucks">雄鹿</a></td>
	                                <td width="20">23</td>
	                                <td width="25">22</td>
	                                <td width="25">14.5</td>
	                                <td>51.1%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">7</td>
	                                <td width="55"><a target="_blank" title="热火" href="/nba/teams/heat">热火</a></td>
	                                <td width="20">20</td>
	                                <td width="25">25</td>
	                                <td width="25">17.5</td>
	                                <td>44.4%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">8</td>
	                                <td width="55"><a target="_blank" title="黄蜂" href="/nba/teams/hornets">黄蜂</a></td>
	                                <td width="20">19</td>
	                                <td width="25">27</td>
	                                <td width="25">19</td>
	                                <td>41.3%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">9</td>
	                                <td width="55"><a target="_blank" title="篮网" href="/nba/teams/nets">篮网</a></td>
	                                <td width="20">18</td>
	                                <td width="25">27</td>
	                                <td width="25">19.5</td>
	                                <td>40.0%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">10</td>
	                                <td width="55"><a target="_blank" title="凯尔特人" href="/nba/teams/celtics">凯尔特人</a></td>
	                                <td width="20">16</td>
	                                <td width="25">28</td>
	                                <td width="25">21</td>
	                                <td>36.4%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">11</td>
	                                <td width="55"><a target="_blank" title="活塞" href="/nba/teams/pistons">活塞</a></td>
	                                <td width="20">17</td>
	                                <td width="25">30</td>
	                                <td width="25">21.5</td>
	                                <td>36.2%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">12</td>
	                                <td width="55"><a target="_blank" title="步行者" href="/nba/teams/pacers">步行者</a></td>
	                                <td width="20">16</td>
	                                <td width="25">31</td>
	                                <td width="25">22.5</td>
	                                <td>34.0%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">13</td>
	                                <td width="55"><a target="_blank" title="魔术" href="/nba/teams/magic">魔术</a></td>
	                                <td width="20">15</td>
	                                <td width="25">33</td>
	                                <td width="25">24</td>
	                                <td>31.3%</td>
	                            </tr>
                                <tr class="">
	                                <td width="25" height="35">14</td>
	                                <td width="55"><a target="_blank" title="尼克斯" href="/nba/teams/knicks">尼克斯</a></td>
	                                <td width="20">9</td>
	                                <td width="25">37</td>
	                                <td width="25">29</td>
	                                <td>19.6%</td>
	                            </tr>
                                <tr class=" bg_color">
	                                <td width="25" height="35">15</td>
	                                <td width="55"><a target="_blank" title="76人" href="/nba/teams/76ers">76人</a></td>
	                                <td width="20">9</td>
	                                <td width="25">37</td>
	                                <td width="25">29</td>
	                                <td>19.6%</td>
	                            </tr>
                                </tbody>
                   		 	</table>


							<table class="itinerary_table itinerary_table_show" id="eastdata" style="display:none">
                        		<tbody>
                                <tr class=" bg_color">
	                                <td width="25" height="35">1</td>
	                                <td width="55"><a target="_blank" title="勇士" href="/nba/teams/warriors">勇士</a></td>
	                                <td width="20">36</td>
	                                <td width="25">7</td>
	                                <td width="25">0</td>
	                                <td>83.7%</td>
	                            </tr>
                                <tr class="">
	                                <td width="25" height="35">2</span></td>
	                                <td width="55"><a target="_blank" title="灰熊" href="/nba/teams/grizzlies">灰熊</a></td>
	                                <td width="20">33</td>
	                                <td width="25">12</td>
	                                <td width="25">4</td>
	                                <td>73.3%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">3</td>
	                                <td width="55"><a target="_blank" title="开拓者" href="/nba/teams/blazers">开拓者</a></td>
	                                <td width="20">32</td>
	                                <td width="25">14</td>
	                                <td width="25">5.5</td>
	                                <td>69.6%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">4</td>
	                                <td width="55"><a target="_blank" title="快船" href="/nba/teams/clippers">快船</a></td>
	                                <td width="20">32</td>
	                                <td width="25">14</td>
	                                <td width="25">5.5</td>
	                                <td>69.6%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">5</td>
	                                <td width="55"><a target="_blank" title="火箭" href="/nba/teams/rockets">火箭</a></td>
	                                <td width="20">32</td>
	                                <td width="25">14</td>
	                                <td width="25">5.5</td>
	                                <td>69.6%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">6</td>
	                                <td width="55"><a target="_blank" title="马刺" href="/nba/teams/spurs">马刺</a></td>
	                                <td width="20">30</td>
	                                <td width="25">17</td>
	                                <td width="25">8</td>
	                                <td>63.8%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">7</td>
	                                <td width="55"><a target="_blank" title="小牛" href="/nba/teams/mavericks">小牛</a></td>
	                                <td width="20">30</td>
	                                <td width="25">17</td>
	                                <td width="25">8</td>
	                                <td>63.8%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">8</td>
	                                <td width="55"><a target="_blank" title="太阳" href="/nba/teams/suns">太阳</a></td>
	                                <td width="20">27</td>
	                                <td width="25">20</td>
	                                <td width="25">11</td>
	                                <td>57.4%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">9</td>
	                                <td width="55"><a target="_blank" title="鹈鹕" href="/nba/teams/pelicans">鹈鹕</a></td>
	                                <td width="20">24</td>
	                                <td width="25">22</td>
	                                <td width="25">13.5</td>
	                                <td>52.2%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">10</td>
	                                <td width="55"><a target="_blank" title="雷霆" href="/nba/teams/thunder">雷霆</a></td>
	                                <td width="20">23</td>
	                                <td width="25">23</td>
	                                <td width="25">14.5</td>
	                                <td>50.0%</td>
	                            </tr>
	                                                        <tr class=" bg_color">
	                                <td width="25" height="35">11</td>
	                                <td width="55"><a target="_blank" title="掘金" href="/nba/teams/nuggets">掘金</a></td>
	                                <td width="20">19</td>
	                                <td width="25">27</td>
	                                <td width="25">18.5</td>
	                                <td>41.3%</td>
	                            </tr>
	                                                        <tr class="">
	                                <td width="25" height="35">12</td>
	                                <td width="55"><a target="_blank" title="国王" href="/nba/teams/kings">国王</a></td>
	                                <td width="20">16</td>
	                                <td width="25">28</td>
	                                <td width="25">20.5</td>
	                                <td>36.4%</td>
	                            </tr>
	                                                        <tr class=" bg_color">
	                                <td width="25" height="35">13</td>
	                                <td width="55"><a target="_blank" title="爵士" href="/nba/teams/jazz">爵士</a></td>
	                                <td width="20">16</td>
	                                <td width="25">30</td>
	                                <td width="25">21.5</td>
	                                <td>34.8%</td>
	                            </tr>
	                            <tr class="">
	                                <td width="25" height="35">14</td>
	                                <td width="55"><a target="_blank" title="湖人" href="/nba/teams/lakers">湖人</a></td>
	                                <td width="20">12</td>
	                                <td width="25">34</td>
	                                <td width="25">25.5</td>
	                                <td>26.1%</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="25" height="35">15</td>
	                                <td width="55"><a target="_blank" title="森林狼" href="/nba/teams/timberwolves">森林狼</a></td>
	                                <td width="20">8</td>
	                                <td width="25">37</td>
	                                <td width="25">29</td>
	                                <td>17.8%</td>
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
					            <td width="165">北京时间</td>
					            <td width="280">主队 VS 客队</td>
					            <td width="150"></td>
				        	</tr>
				        	<tr>
			                    <td width="135">11:00</td>
			                    <td width="360">
			                        <a href="teaminfo.html">洛杉矶湖人</a> 88 : 91 <a href="teaminfo.html">休斯顿火箭</a>
			                    </td>
			                    <td>
			                        <a target="_blank" href="./14-15/2014-10-29/夏洛特黄蜂/密尔沃基雄鹿">比赛统计</a>            
			                    </td>
			                </tr>
			                <tr>
			                    <td width="135">11:00</td>
			                    <td width="360">
			                        <a href="teaminfo.html">洛杉矶湖人</a> 88 : 91 <a href="teaminfo.html">休斯顿火箭</a>
			                    </td>
			                    <td>
			                        <a target="_blank" href="matchstat.html">比赛统计</a>            
			                    </td>
			                </tr>
			                <tr>
			                    <td width="135">10:00</td>
			                    <td width="360">
			                        <a href="teaminfo.html">洛杉矶湖人</a> 88 : 91 <a href="teaminfo.html">休斯顿火箭</a>
			                    </td>
			                    <td>
			                        <a target="_blank" href="matchstat.html">比赛统计</a>            
			                    </td>
			                </tr>
			                <tr>
			                    <td width="135">09:00</td>
			                    <td width="360">
			                        <a href="teaminfo.html">洛杉矶湖人</a> 88 : 91 <a href="teaminfo.html">休斯顿火箭</a>
			                    </td>
			                    <td>
			                        <a target="_blank" href="matchstat.html">比赛统计</a>            
			                    </td>
			                </tr>
			                <tr>
			                    <td width="135">08:00</td>
			                    <td width="360">
			                        <a href="teaminfo.html">洛杉矶湖人</a> 100 : 92 <a href="teaminfo.html">休斯顿火箭</a>
			                    </td>
			                    <td>
			                        <a target="_blank" href="matchstat.html">比赛统计</a>            
			                    </td>
			                </tr>
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

					<div class="gamecenter_content_r">
						<div class="region_box">
							<h4>球员场均</h4>
							<div class="tiltle" conference="W">
								<span class="tiltle_c" id="east">得分</span><span class="tiltle_c" id="west">篮板</span><span class="tiltle_c" id="west">助攻</span><span class="tiltle_c" id="west">抢断</span><span class="tiltle_c" id="west">三分</span><span class="tiltle_d" >盖帽</span>
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
	                    	<table class="itinerary_table itinerary_table_show" id="westdata">
	                        <tbody>
                                <tr class=" bg_color">
	                                <td width="40" height="35">詹姆斯·哈登</td>
	                                <td width="35"><a target="_blank" title="老鹰" href="/nba/teams/hawks">火箭</a></td>
	                                <td width="35">27.3分</td>
	                            </tr>
	                            <tr class="">
	                                <td width="40" height="35">勒布朗·詹姆斯</td>
	                                <td width="35"><a target="_blank" title="老鹰" href="/nba/teams/hawks">骑士</a></td>
	                                <td width="35">26.4分</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="40" height="35">安东尼·戴维斯</td>
	                                <td width="35"><a target="_blank" title="老鹰" href="/nba/teams/hawks">鹈鹕</a></td>
	                                <td width="35">24.5分</td>
	                            </tr>
	                        </tbody>
	                    	</table>
		                </div>
		            </div>

					<div class="gamecenter_content_r">
						<div class="region_box">
							<h4>球员赛季单场</h4>
							<div class="tiltle" conference="W">
								<span class="tiltle_c" id="east">得分</span><span class="tiltle_c" id="west">篮板</span><span class="tiltle_c" id="west">助攻</span><span class="tiltle_c" id="west">抢断</span><span class="tiltle_c" id="west">三分</span><span class="tiltle_d" >盖帽</span>
							</div>
							<table class="itinerary_table">
		                        <tbody>
		                            <tr>
		                                <td width="40" height="35">姓名</td>
		                                <td width="35">球队</td>
		                                <td width="35">单场数据</td>
		                            </tr>
		                        </tbody>
		                    </table>
		                    <div class="border_red"></div>
	                    	<table class="itinerary_table itinerary_table_show" id="westdata">
	                        <tbody>
                                <tr class=" bg_color">
	                                <td width="40" height="35">凯里·欧文</td>
	                                <td width="35"><a target="_blank" title="骑士" href="/nba/teams/hawks">骑士</a></td>
	                                <td width="35">55分</td>
	                            </tr>
	                            <tr class="">
	                                <td width="40" height="35">克莱·汤普森</td>
	                                <td width="35"><a target="_blank" title="勇士" href="/nba/teams/hawks">勇士</a></td>
	                                <td width="35">52分</td>
	                            </tr>
	                            <tr class=" bg_color">
	                                <td width="40" height="35">莫·威廉姆斯</td>
	                                <td width="35"><a target="_blank" title="老鹰" href="/nba/teams/hawks">森林狼</a></td>
	                                <td width="35">52分</td>
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
		$(document).ready(function() {
			var west = document.getElementById("west");
			var east = document.getElementById("east");
			var westdata = document.getElementById("westdata");
			var eastdata = document.getElementById("eastdata");
			$(west).click(function(){
				west.style.background = "#fbfbfb";
				east.style.background = "#f2f2f2";
				westdata.style.display = "none";
				eastdata.style.display = "table";
			});
			$(east).click(function(){
				east.style.background = "#fbfbfb";
				west.style.background = "#f2f2f2";
				westdata.style.display = "table";
				eastdata.style.display = "none";
			});
		});
	</script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://localhost:8080/NBADataAnalysis/NBA/js/bootstrap.min.js"></script>
    <script src="http://localhost:8080/NBADataAnalysis/NBA/js/docs.min.js"></script>
    <!-- 导航栏搜索匹配 -->
    <script src="http://localhost:8080/NBADataAnalysis/NBA/js/jquery-ui/jquery-ui.js"></script>
    <script src="http://localhost:8080/NBADataAnalysis/NBA/js/search-autocomplete.js"></script>

</body>
</html>