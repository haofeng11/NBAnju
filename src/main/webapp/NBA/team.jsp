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
<title>球队信息介绍</title>
<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="js/jquery-ui/jquery-ui.css">
    <link href="css/new.css" rel="stylesheet">
    <!-- Highchart图表JS库 -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/jquery-ui/jquery-ui.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script src="js/map/highmaps.js"></script>
	<script src="js/map/data.js"></script>
	<script type="text/javascript" src="js/highcharts/themes/sand-signika.js"></script>
	<script src="js/map/us-all-mainland.js"></script>

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
            <li><a href="${path.concat('/NBA/main.jsp')}">球员</a></li>
            <li class="active"><a href="${path.concat('/NBA/team.jsp')}">球队</a></li>
            <li><a href="${path.concat('/game/game')}">比赛</a></li>
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
    <!-- 地图 -->
	<div id="map-container"></div>
	<script type="text/javascript">
		$(function () {
	    // Instanciate the map
	    $('#map-container').highcharts('Map', {
	        chart : {
	            borderWidth : 0
	        },
			
	        title : {
	            text : ''
	        },
	        subtitle : {
	            text : ''
	        },
	        credits: {
              enabled: false
            },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	               enabled: false
	            },
	  
	        plotOptions: {
	                series: {
	                    // point: {
	                    //     events: {
	                    //         click: function () {
	                    //         	if(this.series.name == 'Lakers'){
		                   //              // var text = '<b>Clicked point</b><br>Series: ' + this.series.name +
		                   //              //         '<br>Point: ' + this.name + ' (' + this.value + '/km²)',
		                   //              //     chart = this.series.chart;
		                   //              // window.location.href='http://www.baidu.com/';
		                                
		                   //          }
	                    //         }
	                    //     }
	                    // },
	                    dataLabels: {
	                    	useHTML:true
	                    }
	                },
	                map: {
	                	animation: true,
	                	// 取消鼠标移动到区域时闪烁
	                	enableMouseTracking: false,
	                	dataLabels: {
	                		enabled: true,
	                		color: 'white',
	                		formatter: function () {
	                			if(this.point.code == 'CA'){
	                				var clippers = '<a href="${path.concat('/team/洛杉矶快船队')}"><img data-toggle="tooltip" data-placement="top" title="洛杉矶-快船队" src="TeamsAvatar/clippers.png"  width="90px" height="58px" style="position:absolute; left:-10px; top:20px;"></a>';
	                				var lakers = '<a href="${path.concat('/team/洛杉矶湖人队')}"><img data-toggle="tooltip" data-placement="top" title="洛杉矶-湖人队" src="TeamsAvatar/lakers.png" width="90px" height="58px" style="position:absolute; left:-40px; top:-40px;"></a>';
	                				var warriors = '<a href="${path.concat('/team/金州勇士队')}"><img data-toggle="tooltip" data-placement="top" title="金州-勇士队" src="TeamsAvatar/warriors.png" width="67px" height="82px" style="position:absolute; left:-80px; top:-120px;"></a>';
	                				var kings = '<a href="${path.concat('/team/萨克拉门托国王队')}"><img data-toggle="tooltip" data-placement="top" title="萨克拉门托-国王队" src="TeamsAvatar/kings.png" width="67px" height="82px" style="position:absolute; left:-80px; top:-210px;"></a>';
	                        		return lakers+clippers+warriors+kings;
	                        	}
	                        	else if(this.point.code == 'OR'){
	                        		var blazers = '<a href="${path.concat('/team/波特兰开拓者队')}"><img data-toggle="tooltip" data-placement="top" title="波特兰-开拓者队" src="TeamsAvatar/blazers.png" width="67px" height="82px" style="position:absolute; left:-10px; top:-60px;"></a>';
	                        		return blazers;
	                			}
	                			else if(this.point.code == 'UT'){
	                        		var jazz = '<a href="${path.concat('/team/犹他爵士队')}"><img data-toggle="tooltip" data-placement="top" title="犹他-爵士队" src="TeamsAvatar/jazz.png" width="90px" height="40px" style="position:absolute; left:-40px; top:-30px;"></a>';
	                        		return jazz;
	                			}
	                			else if(this.point.code == 'AZ'){
	                        		var suns = '<a href="${path.concat('/team/菲尼克斯太阳队')}"><img data-toggle="tooltip" data-placement="top" title="菲尼克斯-太阳队" src="TeamsAvatar/suns.png" width="90px" height="90px" style="position:absolute; left:-40px; top:-40px;"></a>';
	                        		return suns;
	                			}
	                			else if(this.point.code == 'CO'){
	                        		var nuggets = '<a href="${path.concat('/team/丹佛掘金队')}"><img data-toggle="tooltip" data-placement="top" title="丹佛-掘金队" src="TeamsAvatar/nuggets.png" width="90px" height="60px" style="position:absolute; left:-40px; top:-40px;"></a>';
	                        		return nuggets;
	                			}
	                			else if(this.point.code == 'OK'){
	                        		var thunder = '<a href="${path.concat('/team/俄克拉荷马雷霆队')}"><img data-toggle="tooltip" data-placement="top" title="俄克拉荷马-雷霆队" src="TeamsAvatar/thunder.png" width="90px" height="80px" style="position:absolute; left:-50px; top:-40px;"></a>';
	                        		return thunder;
	                			}
	                			else if(this.point.code == 'TX'){
	                        		var mavericks = '<a href="${path.concat('/team/达拉斯小牛队')}"><img data-toggle="tooltip" data-placement="top" title="达拉斯-小牛队" src="TeamsAvatar/mavericks.png" width="90px" height="80px" style="position:absolute; left:-60px; top:-60px;"></a>';
	                        		var rockets = '<a href="${path.concat('/team/休斯顿火箭队')}"><img data-toggle="tooltip" data-placement="top" title="休斯顿-火箭队" src="TeamsAvatar/rockets.png" width="140px" height="75px" style="position:absolute; left:-10px; top:10px;"></a>';
	                        		var spurs = '<a href="${path.concat('/team/圣安东尼奥马刺队')}"><img data-toggle="tooltip" data-placement="top" title="圣安东尼奥-马刺队" src="TeamsAvatar/spurs.png" width="110px" height="58px" style="position:absolute; left:-120px; top:20px;"></a>';
	                        		return mavericks+rockets+spurs;
	                			}
	                			else if(this.point.code == 'LA'){
	                        		var pelicans = '<a href="${path.concat('/team/新奥尔良鹈鹕队')}"><img data-toggle="tooltip" data-placement="top" title="新奥尔良-鹈鹕队" src="TeamsAvatar/pelicans.png" width="90px" height="66px" style="position:absolute; left:-30px; top:-50px;"></a>';
	                        		return pelicans;
	                			}
	                			else if(this.point.code == 'MN'){
	                        		var timberwolves = '<a href="${path.concat('/team/明尼苏达森林狼队')}"><img data-toggle="tooltip" data-placement="top" title="明尼苏达-森林狼队" src="TeamsAvatar/timberwolves.png" width="90px" height="66px" style="position:absolute; left:-40px; top:-50px;"></a>';
	                        		return timberwolves;
	                			}
	                			else if(this.point.code == 'WI'){
	                        		var bucks = '<a href="${path.concat('/team/密尔沃基雄鹿队')}"><img data-toggle="tooltip" data-placement="top" title="密尔沃基-雄鹿队" src="TeamsAvatar/bucks.png" width="75px" height="104px" style="position:absolute; left:-20px; top:-40px;"></a>';
	                        		return bucks;
	                			}
	                			else if(this.point.code == 'IL'){
	                        		var bulls = '<a href="${path.concat('/team/芝加哥公牛队')}"><img data-toggle="tooltip" data-placement="top" title="芝加哥-公牛队" src="TeamsAvatar/bulls.png" width="75px" height="90px" style="position:absolute; left:-40px; top:-50px;"></a>';
	                        		return bulls;
	                			}
	                			else if(this.point.code == 'MI'){
	                        		var pistons = '<a href="${path.concat('/team/底特律活塞队')}"><img data-toggle="tooltip" data-placement="top" title="底特律-活塞队" src="TeamsAvatar/pistons.png" width="90px" height="76px" style="position:absolute; left:-40px; top:-50px;"></a>';
	                        		return pistons;
	                			}
	                			else if(this.point.code == 'IN'){
	                        		var pacers = '<a href="${path.concat('/team/印第安纳步行者队')}"><img data-toggle="tooltip" data-placement="top" title="印第安纳-步行者队" src="TeamsAvatar/pacers.png" width="75px" height="65px" style="position:absolute; left:-30px; top:-20px;"></a>';
	                        		return pacers;
	                			}
	                			else if(this.point.code == 'OH'){
	                        		var cavaliers = '<a href="${path.concat('/team/克里夫兰骑士队')}"><img data-toggle="tooltip" data-placement="top" title="克里夫兰-骑士队" src="TeamsAvatar/cavaliers.png" width="96px" height="51px" style="position:absolute; left:-50px; top:-50px;"></a>';
	                        		return cavaliers;
	                			}
	                			else if(this.point.code == 'TN'){
	                        		var grizzlies = '<a href="${path.concat('/team/孟菲斯灰熊队')}"><img data-toggle="tooltip" data-placement="top" title="孟菲斯-灰熊队" src="TeamsAvatar/grizzlies.png" width="80px" height="104px" style="position:absolute; left:-40px; top:-40px;"></a>';
	                        		return grizzlies;
	                			}
	                			else if(this.point.code == 'NY'){
	                        		var raptors = '<a href="${path.concat('/team/多伦多猛龙队')}"><img data-toggle="tooltip" data-placement="top" title="多伦多-猛龙队" src="TeamsAvatar/raptors.png" width="90px" height="80px" style="position:absolute; left:-90px; top:-90px;"></a>';
	                        		var knicks = '<a href="${path.concat('/team/纽约尼克斯队')}"><img data-toggle="tooltip" data-placement="top" title="纽约-尼克斯队" src="TeamsAvatar/knicks.png" width="90px" height="72px" style="position:absolute; left:70px; top:30px;"></a>';
	                        		return raptors+knicks;
	                			}
	                			else if(this.point.code == 'MA'){
	                        		var celtics = '<a href="${path.concat('/team/波士顿凯尔特人队')}"><img data-toggle="tooltip" data-placement="top" title="波士顿-凯尔特人队" src="TeamsAvatar/celtics.png" width="80px" height="90px" style="position:absolute; left:-30px; top:-100px;"></a>';
	                        		return celtics;
	                			}
	                			else if(this.point.code == 'NJ'){
	                        		var nets = '<a href="${path.concat('/team/布鲁克林篮网队')}"><img data-toggle="tooltip" data-placement="top" title="布鲁克林-篮网队" src="TeamsAvatar/nets.png" width="70px" height="92px" style="position:absolute; left:-30px; top:-90px;"></a>';
	                        		return nets;
	                			}
	                			else if(this.point.code == 'PA'){
	                        		var ers = '<a href="${path.concat('/team/费城76人队')}"><img data-toggle="tooltip" data-placement="top" title="费城-76人队" src="TeamsAvatar/76ers.png" width="67px" height="82px" style="position:absolute; left:-40px; top:-50px;"></a>';
	                        		return ers;
	                			}
	                			else if(this.point.code == 'VA'){
	                        		var wizards = '<a href="${path.concat('/team/华盛顿奇才队')}"><img data-toggle="tooltip" data-placement="top" title="华盛顿-奇才队" src="TeamsAvatar/wizards.png" width="90px" height="80px" style="position:absolute; left:-10px; top:-40px;"></a>';
	                        		return wizards;
	                			}
	                			else if(this.point.code == 'NC'){
	                        		var bobcats = '<a href="${path.concat('/team/夏洛特黄蜂队')}"><img data-toggle="tooltip" data-placement="top" title="夏洛特-黄蜂队" src="TeamsAvatar/bobcats.png" width="90px" height="82px" style="position:absolute; left:-70px; top:-10px;"></a>';
	                        		return bobcats;
	                			}
	                			else if(this.point.code == 'GA'){
	                        		var hawks = '<a href="${path.concat('/team/亚特兰大老鹰队')}"><img data-toggle="tooltip" data-placement="top" title="亚特兰大-老鹰队" src="TeamsAvatar/hawks.png" width="104px" height="56px" style="position:absolute; left:-40px; top:-10px;"></a>';
	                        		return hawks;
	                			}
	                			else if(this.point.code == 'FL'){
	                        		var magic = '<a href="${path.concat('/team/奥兰多魔术队')}"><img data-toggle="tooltip" data-placement="top" title="奥兰多-魔术队" src="TeamsAvatar/magic.png" width="90px" height="66px" style="position:absolute; left:-100px; top:-60px;"></a>';
	                        		var heat = '<a href="${path.concat('/team/迈阿密热火队')}"><img data-toggle="tooltip" data-placement="top" title="迈阿密-热火队" src="TeamsAvatar/heat.png" width="90px" height="124px" style="position:absolute; left:0px; top:-60px;"></a>';
	                        		return magic+heat;

	                			}
	                		}
	                	}
	                }
	            },

	        series : [{
	            name: 'Lakers',
	            mapData: Highcharts.maps['countries/us/custom/us-all-mainland'],
	            data: [{
	            			// 湖人
	                        value: 2,
	                        code: "CA",
	                        color: "#80ff00",
	                    },
	                    {
	                    	// 开拓者
	                        value: 4,
	                        code: "OR",
	                        color: "#ffff00",
	                    },
	                    {
	                    	// 爵士
	                        value: 8,
	                        code: "UT",
	                        color: "#df1616",
	                    },
	                    {
	                    	// 太阳
	                        value: 16,
	                        code: "AZ",
	                        color: "#00ffff",
	                    },
	                    {
	                    	// 掘金
	                        value: 32,
	                        code: "CO",
	                        color: "#807fff",
	                    },
	                    {
	                    	// 雷霆
	                        value: 64,
	                        code: "OK",
	                        color: "#7eff80",
	                    },
	                    {
	                    	// 马刺
	                        value: 128,
	                        code: "TX",
	                        color: "#ff7f00",
	                    },
	                    {
	                    	// 鹈鹕
	                        value: 256,
	                        code: "LA",
	                        color: "#0080ff",
	                    },
	                    {
	                    	// 森林狼
	                        value: 512,
	                        code: "MN",
	                        color: "#df1616",
	                    },
	                    {
	                    	// 雄鹿
	                        value: 1024,
	                        code: "WI",
	                        color: "#7f7f7f",
	                    },
	                    {
	                    	// 公牛
	                        value: 100,
	                        code: "IL",
	                        color: "#ff187e",
	                    },
	                    {
	                    	// 活塞
	                        value: 100,
	                        code: "MI",
	                        color: "#80ff00",
	                    },
	                    {
	                    	// 步行者
	                        value: 100,
	                        code: "IN",
	                        color: "#ff7f00",
	                    },
	                    {
	                    	// 骑士
	                        value: 100,
	                        code: "OH",
	                        color: "#7eff80",
	                    },
	                    {
	                    	// 灰熊
	                        value: 100,
	                        code: "TN",
	                        color: "#80ff00",
	                    },
	                    {
	                    	// 尼克斯、猛龙
	                        value: 100,
	                        code: "NY",
	                        color: "#807fff",
	                    },
	                    {
	                    	// 凯尔特人
	                        value: 100,
	                        code: "MA",
	                        color: "#7eff80",
	                    },
	                    {
	                    	// 篮网
	                        value: 100,
	                        code: "NJ",
	                        color: "#fe0100",
	                    },
	                    {
	                    	// 76人
	                        value: 100,
	                        code: "PA",
	                        color: "#ff7f00",
	                    },
	                    {
	                    	// 奇才
	                        value: 100,
	                        code: "VA",
	                        color: "#ffff00",
	                    },
	                    {
	                    	// 山猫
	                        value: 100,
	                        code: "NC",
	                        color: "#ff187e",
	                    },
	                    {
	                    	// 老鹰
	                        value: 100,
	                        code: "GA",
	                        color: "#7f00ff",
	                    },
	                    {
	                    	// 魔术,热火
	                        value: 100,
	                        code: "FL",
	                        color: "#df1616",
	                    },
	                ],
	            joinBy: ['postal-code', 'code'],
	            // animation: true,
	             // allowPointSelect: true,
	            // cursor: 'pointer',
	            
	            
	        }]
	    });
	});
	</script>
	<script type="text/javascript">
	$(function () {
		  $('[data-toggle="tooltip"]').tooltip({
		  	delay: { "show": 400, "hide": 0 },
		  	animation: false
		  	});
	});
	$(function(){
	var imgWid = 0 ;
	var imgHei = 0 ; //变量初始化
	var big = 1.5;//放大倍数
	$("#map-container a").hover(function(){
		$(this).find("img").stop(true,true);
		var imgWid2 = 0;var imgHei2 = 0;//局部变量
		imgWid = $(this).find("img").width();
		imgHei = $(this).find("img").height();
		imgWid2 = imgWid * big;
		imgHei2 = imgHei * big;
		$(this).find("img").css({"z-index":2});
		$(this).find("img").animate({"width":imgWid2,"height":imgHei2,"margin-left":-imgWid*(big - 1)/2,"margin-top":-imgHei*(big - 1) /2});
	},function(){$(this).find("img").stop().animate({"width":imgWid,"height":imgHei,"margin-left":0,"margin-top":0,"z-index":1});});
	})
</script>
    <!-- 导航栏搜索匹配 -->
    <script src="js/search-autocomplete.js"></script>
</body>
</html>