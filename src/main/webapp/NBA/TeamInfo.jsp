<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>球队信息介绍</title>

    
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
				<a class="navbar-brand hidden-sm" href="main.html">NBA数据分析网</a>
			</div>
			<div class="navbar-collapse collapse" role="navigation">
				<ul class="nav navbar-nav">
					<li><a href="../NBA/main.html">球员</a></li>
					<li class="active"><a href="../NBA/team.html">球队</a>
					<li><a href="../game/games">比赛</a></li>
					<li><a href="comparison.html">球员对比</a></li>
					<li><a href="comparison_area.html">分区对比</a></li>
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

	<!-- 球队介绍基本信息 -->
	<!-- 基本信息 -->
	<div class="bs-docs-header" id="content">
		<div class="container">
			<h1>${team.cName }[${team.eName }]</h1>
			<div class="row">
				<div class="col-md-3">
					<div class="rounded" style="text-align: center;">
						<!-- 球队头像大小选择180*120 -->
						<img src="${team.picture }" alt="湖人">
					</div>
					<table class="table table-hover statistics">
						<tr>
							<td>技术统计</td>
							<td>数值</td>
							<td>联盟排名</td>
						</tr>
						<tr>
							<td>场均得分</td>
							<th>${teamSA.score }</th>
							<th>${scoreRanking }</th>
						</tr>
						<tr>
							<td>场均助攻</td>
							<th>${teamSA.assistance }</th>
							<th>${assistanceRanking }</th>
						</tr>
						<tr>
							<td>场均篮板</td>
							<th>${teamSA.rebound }</th>
							<th>${reboundRanking }</th>
						</tr>
						<tr>
							<td>场均抢断</td>
							<th>${teamSA.grab }</th>
							<th>${grabRanking }</th>
						</tr>
						<tr>
							<td>场均盖帽</td>
							<th>${teamSA.block }</th>
							<th>${blockRanking }</th>
						</tr>
						<tr>
							<td>场均失误</td>
							<th>${teamSA.mistake }</th>
							<th>${mistakeRanking }</th>
						</tr>
					</table>
				</div>
				<div class="col-md-5">
					<p>区域: ${team.teamDistrict }</p>
					<p>成立时间: ${team.foundedTime }</p>
					<p>所在地: ${team.teamLocation }</p>
					<p>主场馆: ${team.mainStadium }</p>
					<p>球队老板: ${team.boss }</p>
					<p>现任教练: ${team.coach }</p>
					<p>
						历任球星: <c:forEach items="${teamStars }" var="star" >
						           <a href="">${star }</a>
						        </c:forEach>	
					</p>
					<p>总冠军次数: ${team.champion }</p>
					<p>最高连胜记录: ${team.topWinningStreak }</p>
				</div>
				<!-- 技术统计 -->
				<div class="col-md-4">
					<div style="">
						<!-- Highchart图表 -->
						<div id="Synthesis-container"
							style="min-width: 310px; height: 300px; margin: 0 auto;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 基本信息 -->


	<div class="container bs-docs-container">
      <div class="row">
        <div class="col-md-10" role="main">
          <div class="bs-docs-section">
            <h2 id="lineup" class="page-header solutionForFixBar">球队阵容</h2>
            <!-- echart图表 -->
            <div id="lineup-container" style="min-width: 310px; height: 400px; margin: 0 auto;">
            </div>
          </div>

          <div class="bs-docs-section">
            <h2 id="data" class="page-header solutionForFixBar">球队
              <div class="btn-group">
                <button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="margin-right:10px;margin-top:-6px;font-size:20px;" id="season">
                  14 - 15 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="javascript:void(0);">14 - 15</a></li>
                  <li><a href="javascript:void(0);">13 - 14</a></li>
                  <li><a href="javascript:void(0);">12 - 13</a></li>
                  <li><a href="javascript:void(0);">11 - 12</a></li>
                  <li><a href="javascript:void(0);">10 - 11</a></li>
                  <li><a href="javascript:void(0);">09 - 10</a></li>
                  <li><a href="javascript:void(0);">08 - 09</a></li>
                  <li><a href="javascript:void(0);">07 - 08</a></li>
                  <li><a href="javascript:void(0);">06 - 07</a></li>
                  <li><a href="javascript:void(0);">05 - 06</a></li>
                  <li><a href="javascript:void(0);">04 - 05</a></li>
                  <li><a href="javascript:void(0);">03 - 04</a></li>
                  <li><a href="javascript:void(0);">02 - 03</a></li>
                </ul>
              </div>赛季数据
            </h2>
            <!-- Highchart图表 -->
            <div class="data-select" id="season_data" season="${teamSingleGames.get(0).seasonID }" regular-date="<c:forEach items="${teamSingleGames}" var="t"> ${t.gameDate},</c:forEach>" playoff-date="2015-04-20,2015-04-21,2015-04-23,2015-04-25, 2015-04-26,2015-04-27,2015-04-28,2015-04-29,2015-04-30,2015-05-01,2015-05-05,2015-05-08">
              <a class="on" href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.score},</c:forEach>" tit="赛季得分变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均得分：" playoff="85,111,121,134,106,107,102,102,80,115,114,98" measure = "分" >得分</a>
              <a href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.shootTotal},</c:forEach>" tit="赛季出手数变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均出手数：" playoff="87,84,75,99,87,91,85,89,81,89,99,81" measure = "次" >出手数</a>
              <a href="javascript:void(0);"  name="湖人" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.shootPercentage},</c:forEach>" tit="赛季命中率变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均命中率：" playoff="46.6,39.8,51.2,47.1,41.7,37.3,39.4,54,40.7,51.8,37.1,40.7" measure = "%">命中率</a>
              <a href="javascript:void(0);"  name="湖人" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.threeHit*3},</c:forEach>" tit="赛季3分得分变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均3分得分：" playoff="18,21,21,6,9,18,15,15,9,24,24,30" measure = "分">三分得分</a>
              <a href="javascript:void(0);"  name="湖人" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.threeTotal},</c:forEach>" tit="赛季3分出手变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均3分出手：" playoff="22,21,12,16,17,20,13,24,19,21,24,17" measure = "次">三分出手</a>
              <a href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.threePercentage},</c:forEach>" tit="赛季3分命中率变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均3分命中率：" playoff="31.8,33.3,16.7,18.8,35.3,25,38.5,12.5,42.1,38.1,41.7,58.8" measure = "%">三分命中率</a>
              <a href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.assistance},</c:forEach>" tit="赛季助攻变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均助攻数：" playoff="31.8,33.3,16.7,18.8,35.3,25,38.5,12.5,42.1,38.1,41.7,58.8" measure = "%">助攻</a>
              <a href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.rebound},</c:forEach>" tit="赛季篮板变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均篮板数：" playoff="31.8,33.3,16.7,18.8,35.3,25,38.5,12.5,42.1,38.1,41.7,58.8" measure = "%">篮板</a>
              <a href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.block},</c:forEach>" tit="赛季盖帽变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均盖帽数：" playoff="31.8,33.3,16.7,18.8,35.3,25,38.5,12.5,42.1,38.1,41.7,58.8" measure = "%">盖帽</a>
              <a href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.grab},</c:forEach>" tit="赛季抢断变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均抢断数：" playoff="31.8,33.3,16.7,18.8,35.3,25,38.5,12.5,42.1,38.1,41.7,58.8" measure = "%">抢断</a>
              <a href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.foul},</c:forEach>" tit="赛季犯规变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均犯规数：" playoff="31.8,33.3,16.7,18.8,35.3,25,38.5,12.5,42.1,38.1,41.7,58.8" measure = "%">犯规</a>
              <a href="javascript:void(0);" regular="<c:forEach items="${teamSingleGames}" var="t"> ${t.mistake},</c:forEach>" tit="赛季失误变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均失误数：" playoff="31.8,33.3,16.7,18.8,35.3,25,38.5,12.5,42.1,38.1,41.7,58.8" measure = "%">失误</a>
            </div>
            <div class="row">
              <div id="data-container" class="col-md-11" style="min-width: 310px; height: 400px; margin: 0 auto;">
              </div>
              <div class="col-md-1" style="padding-left:0px;margin-top:10px;">
                <div class="btn-group-vertical" data-toggle="buttons">
                  <label class="btn btn-sm btn-success active" id="regular">
                    <input type="radio" name="options"  autocomplete="off" checked> 常规赛
                  </label>
                  <label class="btn btn-sm btn-danger" id="playoff">
                    <input type="radio" name="options" autocomplete="off"> 季后赛
                  </label>
                </div>
              </div>
            </div>
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
		<p>
			本项目源码采用 <a href="http://v3.bootcss.com/" target="_blank">Bootstrap</a>
			和 <a href="http://jquery.com/">jQuery</a> 开源框架.主要数据来源自<a
				href="http://creativecommons.org/licenses/by/3.0/">StatNBA数据</a>
		</p>
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

	<!-- 基本信息蛛网 -->
	<script type="text/javascript">
		// 综合能力
		$(function() {
			$('#Synthesis-container')
					.highcharts(
							{
								chart : {
									polar : true,
									type : 'line'
								},

								title : {
									text : '',
									x : 0
								},
								pane : {
									size : '80%'
								},
								// 去掉额外元素
								legend : {
									enabled : false
								},
								exporting : {
									enabled : false
								},
								credits : {
									enabled : false
								},
								xAxis : {
									categories : [ '场均得分', '场均助攻', '场均篮板',
											'场均抢断','场均盖帽', '场均失误' ],
									tickmarkPlacement : 'on',
									lineWidth : 0
								},

								yAxis : {
									gridLineInterpolation : 'polygon',
									lineWidth : 0,
									min : 0,
									minorTickInterval : 5,
									reversed : true,
								},

								tooltip : {
									spanhared : true,
									pointFormat : '<span style="color:{series.color}"><b>湖人排名: {point.y}</b><br/>'
								},

								series : [ {
									name : '科比',
									data : [ ${scoreRanking }, ${assistanceRanking }, ${reboundRanking }, ${grabRanking }, ${blockRanking }, ${mistakeRanking } ],
									pointPlacement : 'on'
								} ]
							});
		});
	</script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../NBA/js/bootstrap.min.js"></script>
	<script src="../NBA/js/docs.min.js"></script>
	<!-- 导航栏搜索匹配 -->
	<script src="../NBA/js/jquery-ui/jquery-ui.js"></script>
	<script src="../NBA/js/search-autocomplete.js"></script>


	<!-- 球队阵容.ECharts单文件引入 -->
	<script src="../NBA/js/echarts.js"></script>
	<script type="text/javascript">
		require.config({
			paths : {
				echarts : '../NBA/js/dist'
			}
		});
		// 获取lineup-container对象的高和宽
		var width = document.getElementById('lineup-container').offsetWidth;
		var height = document.getElementById('lineup-container').offsetHeight;
		require([ 'echarts', 'echarts/chart/force', ], function(ec) {
			var myChart = ec.init(document.getElementById('lineup-container'));
			var option = {
				title : {
					text : '',
					subtext : '',
					x : 'right',
					y : 'bottom'
				},
				tooltip : {
					trigger : 'item',
					// formatter: '{a} : {b}'
					formatter : '薪资: {c} 万美元'
				},
				toolbox : {
					show : true,
					feature : {
						restore : {
							show : true
						},
						magicType : {
							show : false,
							type : [ 'force', 'chord' ]
						},
						saveAsImage : {
							show : false
						}
					}
				},
				legend : {
					x : 'center',
					data : [ '中锋', '前锋', '后卫' ]
				},
				series : [ {
					type : 'force',
					ribbonType : false,
					name : "压力动态",
					categories : [ {
						name : '中锋',
						itemStyle : {
							normal : {
								color : '#FF7F00'
							}
						}
					}, {
						name : '前锋',
						itemStyle : {
							normal : {
								color : '#9acd32'
							}
						}
					}, {
						name : '后卫',
						itemStyle : {
							normal : {
								color : '#87cdfa'
							}
						}
					} ],
					itemStyle : {
						normal : {
							label : {
								show : true,
								textStyle : {
									color : '#800080'
								}
							},
							nodeStyle : {
								brushType : 'both',
								strokeColor : 'rgba(255,215,0,0.4)',
								lineWidth : 8
							}
						},
						emphasis : {
							label : {
								show : false
							// textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
							},
							nodeStyle : {
								r : 100
							},
							linkStyle : {}
						}
					},
					minRadius : 25,
					maxRadius : 35,
					density : 0.05,
					attractiveness : 1.8,
					nodes : [ {
						category : 2,
						name : '科比',
						value : 2350,
						initial : [ width / 2, height / 2 ],
						fixX : true,
						fixY : true,
						draggable : false
					}, {
						category : 2,
						name : '纳什',
						value : 970,
						initial : [ width / 2 - 50, height / 2 - 50 ],
						fixX : true,
						fixY : true,
						draggable : true
					}, {
						category : 2,
						name : '林书豪',
						value : 837,
						initial : [ width / 2 + 50, height / 2 - 50 ],
						fixX : true,
						fixY : true,
						draggable : true
					}, {
						category : 2,
						name : '尼克·杨',
						value : 483,
						initial : [ width / 2 - 50, height / 2 + 50 ],
						fixX : true,
						fixY : true,
						draggable : true
					}, {
						category : 1,
						name : '布泽尔',
						value : 325,
						initial : [ width / 2 + 50, height / 2 + 50 ],
						fixX : true,
						fixY : true,
						draggable : true
					}, {
						category : 1,
						name : '兰德尔',
						value : 299
					}, {
						category : 1,
						name : '艾灵顿',
						value : 277,
						initial : [ width / 2 - 200, height / 2 ],
						fixX : true,
						fixY : true,
						draggable : true
					}, {
						category : 1,
						name : '凯利',
						value : 165
					}, {
						category : 2,
						name : '普莱斯',
						value : 114
					}, {
						category : 2,
						name : '戴维斯',
						value : 98,
						initial : [ width / 2 + 200, height / 2 ],
						fixX : true,
						fixY : true,
						draggable : true
					}, {
						category : 0,
						name : '萨克雷',
						value : 91
					}, ],
					links : [ {
						source : 1,
						target : 0,
						weight : 4
					}, {
						source : 2,
						target : 0,
						weight : 4
					}, {
						source : 3,
						target : 0,
						weight : 4
					}, {
						source : 4,
						target : 0,
						weight : 4
					}, {
						source : 1,
						target : 2,
						weight : 2
					}, {
						source : 2,
						target : 3,
						weight : 2
					}, {
						source : 3,
						target : 4,
						weight : 2
					}, {
						source : 4,
						target : 1,
						weight : 2
					}, {
						source : 1,
						target : 5,
						weight : 1
					}, {
						source : 2,
						target : 10,
						weight : 1
					}, {
						source : 3,
						target : 7,
						weight : 1
					}, {
						source : 4,
						target : 8,
						weight : 1
					}, {
						source : 5,
						target : 6,
						weight : 1
					}, {
						source : 6,
						target : 7,
						weight : 1
					}, {
						source : 7,
						target : 8,
						weight : 1
					}, {
						source : 8,
						target : 9,
						weight : 1
					}, {
						source : 9,
						target : 10,
						weight : 1
					}, {
						source : 10,
						target : 5,
						weight : 1
					}, ],

				} ]
			}
			myChart.setOption(option);
		});
	</script>
	<!-- 球队数据 -->
    <script type="text/javascript">
      $(document).ready(function() {
      //首次配置
      var options = {
          chart: {
            type:'spline',
            renderTo:'data-container'
          },
          title: {
            text: '2014-2015常规赛季得分变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均得分：99.3分',
            useHTML:true,
            x: -20 //center
          },
          xAxis: {
            gridLineWidth: 0,
            categories: [<c:forEach items="${teamSingleGames}" var="t">
								'${t.gameDate}',
						 </c:forEach>
				        ],
            labels: {
              style: {
                color: '#000',
                fontWeight: 'bold'
              }
            },
            tickInterval:10,
            startOnTick: false,
          },
          yAxis: {
            title: {
                text: ''
            },
            labels:{
                format:'{value}分'
            }
          },
          // 去掉额外元素
          legend: {
            enabled: false
          },
          exporting: {
            enabled: false
          },
          credits: {
            enabled: false
          },
          tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b><br/>',
            valueSuffix: ' 分',
          },
          series: [{
              name: '湖人',
              color: 'red',
              data: [<c:forEach items="${teamSingleGames}" var="t">
							${t.score},
					 </c:forEach>
			        ]
          }]
        };
      var chart = new Highcharts.Chart(options);

      // var chart = $('#data-container').highcharts();
        $(".data-select a").click(function(){
          //为当前元素添加class:on
          $(this).addClass("on");
          // 遍历所有元素移除on
          $(this).siblings().removeClass("on");
          // 修改y轴单位
          var measure = $(this).attr('measure');
          options.yAxis.labels.format = '{value}'+measure;
          // 修改提示单位
          options.tooltip.valueSuffix = measure;
          // 修改标题
          var active = $("label.active");
          var title = $(".data-select").attr('season');
          if(active.attr('id') == "regular"){
            var average = 0;
            var data_array = $(this).attr('regular').split(',');
            for (var i = 0; i < data_array.length; i++) {
              average += parseInt(data_array[i]);
            };
            average = (average / (data_array.length)).toFixed(1);
            title += "常规" + $(this).attr('tit') + average + measure;
          }
          else if((active.attr('id') == "playoff")){
            var average = 0;
            var data_array = $(this).attr('playoff').split(',');
            for (var i = 0; i < data_array.length; i++) {
              average += parseInt(data_array[i]);
            };
            average = (average / (data_array.length)).toFixed(1);
            title += "季后" + $(this).attr('tit') + average + measure;
          }
          options.title.text = title;
          // 修改数据
          var data;
          if(active.attr('id') == "regular"){
            data = $(this).attr('regular');
          }
          else if((active.attr('id') == "playoff"))
            data = $(this).attr('playoff');
          var array = data.split(",");
          var nums = [ ];
          for (var i=0 ; i< array.length; i++)
          {
              nums.push(parseInt(array[i]));
          }
          // chart.series[0].setData(nums);
          options.series[0].data = nums;
          //修改横坐标
          if(active.attr('id') == "regular"){
            var regular_date = $("#season_data").attr('regular-date');
            var date_array = regular_date.split(",");
            var dates = [ ];
            for (var i=0 ; i< date_array.length; i++)
            {
                dates.push(date_array[i]);
            }
            options.xAxis.categories = date_array;
          }
          else if((active.attr('id') == "playoff")){
            var playoff_date = $("#season_data").attr('playoff-date');
            var date_array = playoff_date.split(",");
            var dates = [ ];
            for (var i=0 ; i< date_array.length; i++)
            {
                dates.push(date_array[i]);
            }
            options.xAxis.categories = date_array;
          }
          // 重画
          chart = new Highcharts.Chart(options);
          // chart.series[0].update(null,true);
        });
        $("label#regular").click(function(){
          // 修改标题
          var title = $(".data-select").attr('season');
          var measure = $("a.on").attr('measure');
          var average = 0;
          var data_array = $("a.on").attr('regular').split(',');
          for (var i = 0; i < data_array.length; i++) {
            average += parseInt(data_array[i]);
          };
          average = (average / data_array.length).toFixed(1);
          title += "常规" +  $("a.on").attr('tit') + average + measure;
          options.title.text = title;
          // 修改数据
          var arr = $("a.on").attr('regular');
          var array = arr.split(",");
          var nums = [ ];
          for (var i=0 ; i< array.length ; i++)
          {
              nums.push(parseInt(array[i]));
          }
          options.series[0].data = nums;
          //修改横坐标
          var regular_date = $("#season_data").attr('regular-date');
          var date_array = regular_date.split(",");
          var dates = [ ];
          for (var i=0 ; i< date_array.length ; i++)
          {
              dates.push(date_array[i]);
          }
          options.xAxis.categories = date_array;
          // 重画
          chart = new Highcharts.Chart(options);
        });
        $("label#playoff").click(function(){
          // 修改标题
          var title = $(".data-select").attr('season');
          var measure = $("a.on").attr('measure');
          var average = 0;
          var data_array = $("a.on").attr('playoff').split(',');
          for (var i = 0; i < data_array.length; i++) {
            average += parseInt(data_array[i]);
          };
          average = (average / data_array.length).toFixed(1);
          title += "季后" +  $("a.on").attr('tit') + average + measure;
          options.title.text = title;
          // 修改数据
          var playoff = $("a.on").attr('playoff');
          var array = playoff.split(",");
          var nums = [ ];
          for (var i=0 ; i< array.length ; i++)
          {
              nums.push(parseInt(array[i]));
          }
          // chart.series[0].setData(nums);
          options.series[0].data = nums;
          //修改横坐标
          var playoff_date = $("#season_data").attr('playoff-date');
          var date_array = playoff_date.split(",");
          var dates = [ ];
          for (var i=0 ; i< date_array.length ; i++)
          {
              dates.push(date_array[i]);
          }
          options.xAxis.categories = date_array;
          // 重画
          chart = new Highcharts.Chart(options);
        });
        $(".dropdown-menu a").click(function(){
          $("#season")[0].childNodes[0].nodeValue = $(this).text()+" ";
          var select_season = $(this).text().replace(/\s+/g,"");
          var url = "http://localhost:8080/NBADataAnalysis/team/${teamSingleGames.get(0).team}/"+select_season;
          $.ajax
            ({  type: "get",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: url,  //这里是网址
                success: function (result) {
                  $(".data-select").attr("season",result.season);
                  $(".data-select").attr("regular-date",result.regular_date);
                  $(".data-select").attr("playoff-date",result.playoff_date);
                  $(".data-select a").each(function(i,item){
                    $(this).attr("regular",result.data[i].regular);
                    $(this).attr("playoff",result.data[i].playoff);
                  });
                  $(".data-select a.on").click();
                },
                timeout: 1000,
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                  alert("该赛季球队未打进季后赛！");
                    // $("#welcome").html(XMLHttpRequest+textStatus+errorThrown.message);
                }
            });
        });
    });
    </script>


</body>
</html>