﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
					<li><a href="main.html">球员</a></li>
					<li class="active"><a href="team.html">球队</a>
					<li><a href="game.html">比赛</a></li>
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
			<h1>洛杉矶·湖人队 [ L.A. Lakers ]</h1>
			<div class="row">
				<div class="col-md-3">
					<div class="rounded" style="text-align: center;">
						<!-- 球队头像大小选择180*120 -->
						<img src="../NBA/TeamsBigAvatar/Lakers.png" alt="湖人">
					</div>
					<table class="table table-hover statistics">
						<tr>
							<td>技术统计</td>
							<td>数值</td>
							<td>联盟排名</td>
						</tr>
						<tr>
							<td>场均得分</td>
							<th>99.6</th>
							<th>19</th>
						</tr>
						<tr>
							<td>场均助攻</td>
							<th>20.5</th>
							<th>24</th>
						</tr>
						<tr>
							<td>场均篮板</td>
							<th>42.9</th>
							<th>15</th>
						</tr>
						<tr>
							<td>失分</td>
							<th>106.3</th>
							<th>29</th>
						</tr>
						<tr>
							<td>失误</td>
							<th>13</th>
							<th>6</th>
						</tr>
					</table>
				</div>
				<div class="col-md-5">
					<p>区域: 西部</p>
					<p>成立时间: 1948年</p>
					<p>所在地: 加利福尼亚州洛杉矶市</p>
					<p>主场馆: 斯台普斯球馆(STAPLES Center)</p>
					<p>球队老板: 吉姆·巴斯(Jim Buss)</p>
					<p>现任教练: 拜伦·斯科特</p>
					<p>
						历任球星: <a href="">麦肯</a> <a href="">韦斯特</a> <a href="">张伯伦</a> <a
							href="">约翰逊</a> <a href="">奥尼尔</a> <a href="">科比</a>
					</p>
					<p>季后赛次数: 56次</p>
					<p>西部冠军次数: 31次</p>
					<p>总冠军次数: 16次</p>
					<p>最高连胜记录: 33场</p>
					<p>最好战绩: 69胜13负(71-72赛季)</p>
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
					<div id="lineup-container"
						style="min-width: 310px; height: 400px; margin: 0 auto;"></div>
				</div>

				<div class="bs-docs-section">
					<h2 id="data" class="page-header solutionForFixBar" style="">球队本赛季数据</h2>
					<!-- Highchart图表 -->
					<div class="data-select">
						<a class="on" href="javascript:void(0);"
							arr="90,99,111,104,106,107,102,102,80,115,114,98,106,94,93,119,129,106,95,96,87,98,112,100,91,103,101,115,93,98,107,111,106,88,94,89,101,94,75,102,85,100,80,85,87"
							tit="本赛季得分变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均得分：99.3分"
							pointStart='2014-9-29' measure="分">得分</a> <a
							href="javascript:void(0);"
							arr="79,86,82,88,88,82,87,84,75,99,87,91,85,89,81,89,96,81,85,92,90,96,96,81,88,85,87,89,92,99,81,76,81,71,88,85,90,81,92,76,65,75,77,83,79"
							tit="本赛季出手数变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均出手数：85.1次"
							pointStart='2014-9-29' measure="次">出手数</a> <a
							href="javascript:void(0);" name="湖人"
							arr="35.4,43,51.2,46.6,39.8,51.2,47.1,41.7,37.3,39.4,54,40.7,51.8,37.1,40.7,53.9,49,48.1,38.8,41.3,40,39.6,45.8,42,33,48.2,37.9,51.7,39.1,36.4,51.9,52.6,53.1,38,42,43.5,40,44.4,31.5,51.3,47.7,45.3,36.4,39.8,43"
							tit="本赛季命中率变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均命中率：43.5%"
							pointStart='2014-9-29' measure="%">命中率</a> <a
							href="javascript:void(0);" name="湖人"
							arr="9,12,21,12,18,18,21,21,6,9,18,15,15,9,24,24,30,30,36,18,15,15,36,15,30,30,30,36,15,33,36,42,18,18,12,15,21,21,12,24,9,24,18,15,3"
							tit="本赛季3分得分变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均3分得分：20.2分"
							pointStart='2014-9-29' measure="分">三分得分</a> <a
							href="javascript:void(0);" name="湖人"
							arr="10,13,20,14,16,17,22,21,12,16,17,20,13,24,19,21,24,17,29,16,19,25,24,17,26,25,26,26,16,29,20,25,19,18,14,20,21,22,23,24,7,17,20,13,13"
							tit="本赛季3分出手变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均3分出手：19.3次"
							pointStart='2014-9-29' measure="次">三分出手</a> <a
							href="javascript:void(0);"
							arr="30,30.8,35,28.6,37.5,35.3,31.8,33.3,16.7,18.8,35.3,25,38.5,12.5,42.1,38.1,41.7,58.8,41.4,37.5,26.3,20,50,29.4,38.5,40,38.5,46.2,31.3,37.9,60,56,31.6,33.3,28.6,25,33.3,31.8,17.4,33.3,42.9,47.1,30,38.5,7.7"
							tit="本赛季3分命中率变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均3分命中率：34.8%"
							pointStart='2014-9-29' measure="%">三分命中率</a>
					</div>
					<div id="data-container"
						style="min-width: 310px; height: 400px; margin: 0 auto;"></div>
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
											'场均失分', '场均失误' ],
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
									data : [ 19, 24, 15, 29, 6 ],
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
				echarts : './js/dist'
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
		$(document)
				.ready(
						function() {
							//首次配置
							var options = {
								chart : {
									type : 'spline',
									renderTo : 'data-container'
								},
								title : {
									text : '本赛季得分变化趋势图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均得分：99.3分',
									useHTML : true,
									x : -20
								//center
								},
								xAxis : {
									gridLineWidth : 0,
									categories : [ '2014-10-29', '2014-10-30',
											'2014-11-01', '2014-11-02',
											'2014-11-05', '2014-11-10',
											'2014-11-12', '2014-11-13',
											'2014-11-15', '2014-11-17',
											'2014-11-19', '2014-11-20',
											'2014-11-22', '2014-11-24',
											'2014-11-27', '2014-11-29',
											'2014-12-01', '2014-12-03',
											'2014-12-04', '2014-12-06',
											'2014-12-08', '2014-12-10',
											'2014-12-13', '2014-12-15',
											'2014-12-16', '2014-12-20',
											'2014-12-22', '2014-12-24',
											'2014-12-26', '2014-12-27',
											'2014-12-29', '2014-12-31',
											'2015-01-03', '2015-01-05',
											'2015-01-06', '2015-01-08',
											'2015-01-10', '2015-01-12',
											'2015-01-14', '2015-01-16',
											'2015-01-17', '2015-01-20',
											'2015-01-22', '2015-01-24',
											'2015-01-26' ],
									labels : {
										style : {
											color : '#000',
											fontWeight : 'bold'
										}
									},
									tickInterval : 10,
									startOnTick : false,
								},
								yAxis : {
									title : {
										text : ''
									},
									labels : {
										format : '{value}分'
									}
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
								tooltip : {
									pointFormat : '{series.name}: <b>{point.y}</b><br/>',
									valueSuffix : ' 分',
								},
								series : [ {
									name : '湖人',
									color : 'red',
									data : [ 90, 99, 111, 104, 106, 107, 102,
											102, 80, 115, 114, 98, 106, 94, 93,
											119, 129, 106, 95, 96, 87, 98, 112,
											100, 91, 103, 101, 115, 93, 98,
											107, 111, 106, 88, 94, 89, 101, 94,
											75, 102, 85, 100, 80, 85, 87 ]
								} ]
							};
							var chart = new Highcharts.Chart(options);

							// var chart = $('#data-container').highcharts();
							$("a").click(
									function() {
										//为当前元素添加class:on
										$(this).addClass("on");
										// 遍历所有元素移除on
										$(this).siblings().removeClass("on");
										// 修改y轴单位
										var measure = $(this).attr('measure');
										options.yAxis.labels.format = '{value}'
												+ measure;
										// 修改提示单位
										options.tooltip.valueSuffix = measure;
										// 修改标题
										var title = $(this).attr('tit');
										options.title.text = title;
										// 修改数据
										var arr = $(this).attr('arr');
										var array = arr.split(",");
										var nums = [];
										for (var i = 0; i < array.length; i++) {
											nums.push(parseInt(array[i]));
										}
										// chart.series[0].setData(nums);
										options.series[0].data = nums;
										// 重画
										chart = new Highcharts.Chart(options);
										// chart.series[0].update(null,true);
									});
						});
	</script>


</body>
</html>