<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>比赛</title>

<!-- Bootstrap -->
    <link href=${path.concat("/NBA/css/bootstrap.min.css")} rel="stylesheet">
    <link rel="stylesheet" href=${path.concat("/NBA/js/jquery-ui/jquery-ui.css")}>
    <link href=${path.concat("/NBA/css/new.css")} rel="stylesheet">
    <!-- Highchart图表JS库 -->
    <script type="text/javascript" src=${path.concat("/NBA/js/jquery-1.11.2.min.js")}></script>
    <script type="text/javascript" src=${path.concat("/NBA/js/highcharts/highcharts.js")}></script>
    <script type="text/javascript" src=${path.concat("/NBA/js/highcharts/highcharts-more.js")}></script>
    <script type="text/javascript" src=${path.concat("/NBA/js/highcharts/themes/custom.js")}></script>
    <script type="text/javascript" src=${path.concat("/NBA/js/highcharts/modules/exporting.js")}></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body style="background-image: url('/NBADataAnalysis/NBA/images/dark-wood-panels-pr.jpg');">
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
					<li><a href="${path.concat('/NBA/main.jsp')}">球员</a></li>
					<li><a href="${path.concat('/NBA/team.jsp')}">球队</a></li>
					<li><a href="game.html">比赛</a></li>
					<li><a href="comparison.html">球员对比</a></li>
					<li class="active"><a href="comparison_area.html">分区对比</a></li>
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

	<div class="container bs-docs-container">
		<div class="row">
			<div class="col-md-1" role="main"></div>
			<div class="col-md-10 area" role="main">
				<div class="data-select">
					<a class="on" href="#"
						eastdata="${eastAverage02.score}, ${eastAverage03.score}, ${eastAverage04.score}, ${eastAverage05.score}, ${eastAverage06.score}, ${eastAverage07.score}, ${eastAverage08.score}, ${eastAverage09.score}, ${eastAverage10.score}, ${eastAverage11.score}, ${eastAverage12.score}, ${eastAverage13.score},${eastAverage14.score}"
						westdata="${westAverage02.score}, ${westAverage03.score}, ${westAverage04.score}, ${westAverage05.score}, ${westAverage06.score}, ${westAverage07.score}, ${westAverage08.score}, ${westAverage09.score}, ${westAverage10.score}, ${westAverage11.score}, ${westAverage12.score}, ${westAverage13.score},${westAverage14.score}"
						measure="分">得分</a> 
					<a href="#"
						eastdata="${eastAverage02.score}, ${eastAverage03.score}, ${eastAverage04.score}, ${eastAverage05.score}, ${eastAverage06.score}, ${eastAverage07.score}, ${eastAverage08.score}, ${eastAverage09.score}, ${eastAverage10.score}, ${eastAverage11.score}, ${eastAverage12.score}, ${eastAverage13.score},${eastAverage14.score}"
						westdata="${westAverage02.score}, ${westAverage03.score}, ${westAverage04.score}, ${westAverage05.score}, ${westAverage06.score}, ${westAverage07.score}, ${westAverage08.score}, ${westAverage09.score}, ${westAverage10.score}, ${westAverage11.score}, ${westAverage12.score}, ${westAverage13.score},${westAverage14.score}"
						measure="分">失分</a> 
					<a href="#"
						eastdata="${eastAverage02.rebound}, ${eastAverage03.rebound}, ${eastAverage04.rebound}, ${eastAverage05.rebound}, ${eastAverage06.rebound}, ${eastAverage07.rebound}, ${eastAverage08.rebound}, ${eastAverage09.rebound}, ${eastAverage10.rebound}, ${eastAverage11.rebound}, ${eastAverage12.rebound}, ${eastAverage13.rebound},${eastAverage14.rebound}"
						westdata="${westAverage02.rebound}, ${westAverage03.rebound}, ${westAverage04.rebound}, ${westAverage05.rebound}, ${westAverage06.rebound}, ${westAverage07.rebound}, ${westAverage08.rebound}, ${westAverage09.rebound}, ${westAverage10.rebound}, ${westAverage11.rebound}, ${westAverage12.rebound}, ${westAverage13.rebound},${westAverage14.rebound}"
						measure="个">篮板</a> 
					<a href="#"
						eastdata="${eastAverage02.assistance}, ${eastAverage03.assistance}, ${eastAverage04.assistance}, ${eastAverage05.assistance}, ${eastAverage06.assistance}, ${eastAverage07.assistance}, ${eastAverage08.assistance}, ${eastAverage09.assistance}, ${eastAverage10.assistance}, ${eastAverage11.assistance}, ${eastAverage12.assistance}, ${eastAverage13.assistance},${eastAverage14.assistance}"
						westdata="${westAverage02.assistance}, ${westAverage03.assistance}, ${westAverage04.assistance}, ${westAverage05.assistance}, ${westAverage06.assistance}, ${westAverage07.assistance}, ${westAverage08.assistance}, ${westAverage09.assistance}, ${westAverage10.assistance}, ${westAverage11.assistance}, ${westAverage12.assistance}, ${westAverage13.assistance},${westAverage14.assistance}"
						measure="个">助攻</a> 
					<a href="#"
						eastdata="${eastAverage02.grab}, ${eastAverage03.grab}, ${eastAverage04.grab}, ${eastAverage05.grab}, ${eastAverage06.grab}, ${eastAverage07.grab}, ${eastAverage08.grab}, ${eastAverage09.grab}, ${eastAverage10.grab}, ${eastAverage11.grab}, ${eastAverage12.grab}, ${eastAverage13.grab},${eastAverage14.grab}"
						westdata="${westAverage02.grab}, ${westAverage03.grab}, ${westAverage04.grab}, ${westAverage05.grab}, ${westAverage06.grab}, ${westAverage07.grab}, ${westAverage08.grab}, ${westAverage09.grab}, ${westAverage10.grab}, ${westAverage11.grab}, ${westAverage12.grab}, ${westAverage13.grab},${westAverage14.grab}"
						measure="个">抢断</a> 
					<a href="#"
						eastdata="${eastAverage02.block}, ${eastAverage03.block}, ${eastAverage04.block}, ${eastAverage05.block}, ${eastAverage06.block}, ${eastAverage07.block}, ${eastAverage08.block}, ${eastAverage09.block}, ${eastAverage10.block}, ${eastAverage11.block}, ${eastAverage12.block}, ${eastAverage13.block},${eastAverage14.block}"
						westdata="${westAverage02.block}, ${westAverage03.block}, ${westAverage04.block}, ${westAverage05.block}, ${westAverage06.block}, ${westAverage07.block}, ${westAverage08.block}, ${westAverage09.block}, ${westAverage10.block}, ${westAverage11.block}, ${westAverage12.block}, ${westAverage13.block},${westAverage14.block}"
						measure="个">盖帽</a> 
					<a href="#"
						eastdata="${eastAverage02.mistake}, ${eastAverage03.mistake}, ${eastAverage04.mistake}, ${eastAverage05.mistake}, ${eastAverage06.mistake}, ${eastAverage07.mistake}, ${eastAverage08.mistake}, ${eastAverage09.mistake}, ${eastAverage10.mistake}, ${eastAverage11.mistake}, ${eastAverage12.mistake}, ${eastAverage13.mistake},${eastAverage14.mistake}"
						westdata="${westAverage02.mistake}, ${westAverage03.mistake}, ${westAverage04.mistake}, ${westAverage05.mistake}, ${westAverage06.mistake}, ${westAverage07.mistake}, ${westAverage08.mistake}, ${westAverage09.mistake}, ${westAverage10.mistake}, ${westAverage11.mistake}, ${westAverage12.mistake}, ${westAverage13.mistake},${westAverage14.mistake}"
						measure="个">失误</a> 
					<a href="#"
						eastdata="${eastAverage02.foul}, ${eastAverage03.foul}, ${eastAverage04.foul}, ${eastAverage05.foul}, ${eastAverage06.foul}, ${eastAverage07.foul}, ${eastAverage08.foul}, ${eastAverage09.foul}, ${eastAverage10.foul}, ${eastAverage11.foul}, ${eastAverage12.foul}, ${eastAverage13.foul},${eastAverage14.foul}"
						westdata="${westAverage02.foul}, ${westAverage03.foul}, ${westAverage04.foul}, ${westAverage05.foul}, ${westAverage06.foul}, ${westAverage07.foul}, ${westAverage08.foul}, ${westAverage09.foul}, ${westAverage10.foul}, ${westAverage11.foul}, ${westAverage12.foul}, ${westAverage13.foul},${westAverage14.foul}"
						measure="个">犯规</a>				
					</div>
				<div id="data-container"></div>
			</div>
			<div class="col-md-1" role="main"></div>
		</div>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							//首次配置
							var options = {
								chart : {
									backgroundColor : '#FCFFC5',
									type : 'column',
									renderTo : 'data-container'
								},
								title : {
									text : '东-西部分区2002-2014赛季'
								},
								subtitle : {
									text : '场均得分对比'
								},
								xAxis : {
									categories : [ '2002年', '2003年', '2004年',
											'2005年', '2006年', '2007年', '2008年',
											'2009年', '2010年', '2011年', '2012年',
											'2013年', '2014年' ],
									crosshair : true
								},
								yAxis : {
									title : {
										text : ''
									},
									labels : {
										format : '{value}分'
									}
								},
								tooltip : {
									headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
									pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
											+ '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
									footerFormat : '</table>',
									shared : true,
									useHTML : true
								},
								plotOptions : {
									column : {
										pointPadding : 0.2,
										borderWidth : 0
									}
								},
								series : [
										{
											name : '东部',
											data : [ 83.6, 86.8, 98.5, 93.4,
													106.0, 84.5, 105.0, 104.3,
													91.2, 83.5, 96.6, 86.3,
													88.2 ]

										},
										{
											name : '西部',
											data : [ 88.9, 90.5, 106.4, 129.2,
													124.0, 136.0, 135.6, 128.5,
													126.4, 114.1, 95.6, 94.4,
													96.2 ]

										} ]
							};
							var chart = new Highcharts.Chart(options);

							// var chart = $('#data-container').highcharts();
							$("a")
									.click(
											function() {
												//为当前元素添加class:on
												$(this).addClass("on");
												// 遍历所有元素移除on
												$(this).siblings().removeClass(
														"on");
												// 修改y轴单位
												var measure = $(this).attr(
														'measure');
												options.yAxis.labels.format = '{value}'
														+ measure;
												// 修改提示单位
												options.tooltip.valueSuffix = measure;
												// 修改标题
												var title = "场均"
														+ $(this).text() + "对比";
												options.subtitle.text = title;
												// 修改东部数据
												var eastdata = $(this).attr(
														'eastdata');
												var array = eastdata.split(",");
												var nums = [];
												for (var i = 0; i < array.length; i++) {
													nums
															.push(parseInt(array[i]));
												}
												options.series[0].data = nums;
												// 修改西部数据
												var westdata = $(this).attr(
														'westdata');
												var array = westdata.split(",");
												var nums = [];
												for (var i = 0; i < array.length; i++) {
													nums
															.push(parseInt(array[i]));
												}
												options.series[1].data = nums;
												// 重画
												chart = new Highcharts.Chart(
														options);
												// chart.series[0].update(null,true);
											});
						});
	</script>
	<!-- 导航栏搜索匹配 -->
	<script src=${path.concat("/NBA/js/jquery-ui/jquery-ui.js")}></script>
	<script src=${path.concat("/NBA/js/search-autocomplete.js")}></script>

</body>
</html>