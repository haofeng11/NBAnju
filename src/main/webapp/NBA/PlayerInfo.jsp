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
<title>球员信息介绍</title>
    <!-- Bootstrap -->
    <link href="../NBA/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../NBA/js/jquery-ui/jquery-ui.css">
    <link href="../NBA/css/new.css" rel="stylesheet">
    <!-- Highchart图表JS库 -->
    <script type="text/javascript" src="../NBA/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="../NBA/js/highcharts/highcharts.js"></script>
    <script type="text/javascript" src="../NBA/js/highcharts/highcharts-more.js"></script>
    
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
            <li class="active"><a href="${path.concat('/NBA/main.jsp')}">球员</a></li>
            <li><a href="${path.concat('/NBA/team.jsp')}">球队</a></li>
            <li><a href="${path.concat('/game/game')}">比赛</a></li>
            <li><a href="${path.concat('/player/comparison')}">球员对比</a></li>
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

    <!-- 基本信息 -->
    <div class="bs-docs-header" id="content">
      <div class="container">
        <h1>${player.cName }[${player.eName }]</h1>
        <div class="row">
          <div class="col-md-2">
            <div class="rounded" > <!-- 头像大小选择160*190 -->
              <img src="../NBA/${player.picture }" style="width:160px;height:190px;"alt="科比">
            </div>
          </div>
          <div class="col-md-6">
            <p>位置: ${player.position } ( ${player.playerNumber } )</p>
            <p>身高: ${player.height }</p>
            <p>体重: ${player.weight }</p>
            <p>生日: ${player.birthday }</p>
            <p>球队: <a href="../team/${player.team }队">${player.team }</a></p>
            <p>选秀: ${player.draftInfo }</p>
            <p>出生地: ${player.birthplace }</p>
            <p>本赛季薪金: ${player.salary }</p>
            <p>主要奖项: <i>${player.prize }</i></p>
          </div>
          <!-- 技术统计 -->
          <div class="col-md-4" >
            <table class="table table-hover statistics">
              <tr>
                <td>技术统计</td>
                <td>数值</td>
                <td>联盟排名</td>
              </tr>
              <tr>
                <td>场均得分</td>
                <th>${playerDataStatistics14.score }</th>
                <th>${scoreRanking }</th>
              </tr>
              <tr>
                <td>场均助攻</td>
                <th>${playerDataStatistics14.assistance }</th>
                <th>${assistanceRanking }</th>
              </tr>
              <tr>
                <td>场均篮板</td>
                <th>${playerDataStatistics14.rebound }</th>
                <th>${reboundRanking }</th>
              </tr>
              <tr>
                <td>命中率</td>
                <th>${playerDataStatistics14.shootPercentage }</th>
                <th>${shootPercentageRanking }</th>
              </tr>
              <tr>
                <td>三分命中率</td>
                <th>${playerDataStatistics14.threePercentage }</th>
                <th>${threePercentageRanking }</th>
              </tr>
              <tr>
                <td>罚球命中率</td>
                <th>${playerDataStatistics14.freeThrowPercentage }</th>
                <th>${freeThrowPercentageRanking }</th>
              </tr>
              <tr>
                <td>场均盖帽</td>
                <th>${playerDataStatistics14.block }</th>
                <th>${blockRanking }</th>
              </tr>
              <tr>
                <td>场均抢断</td>
                <th>${playerDataStatistics14.grab }</th>
                <th>${grabRanking }</th>
              </tr>
			  <tr>
                <td>场均失误</td>
                <th>${playerDataStatistics14.mistake }</th>
                <th>${mistakeRanking }</th>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div> <!-- 基本信息 -->
  
    <!-- 详细信息 -->
    <div class="container bs-docs-container">
      <div class="row">
          <div class="col-md-10" role="main">
            <div class="bs-docs-section">
              <h2 id="Career" class="page-header solutionForFixBar">生涯表现</h2>
              <div class="data-select" id="career_type" regular-date="<c:forEach items="${dataStatistics}" var="t"> ${t.seasonID},</c:forEach>" playoff-date="<c:forEach items="${dataStatisticsPO}" var="t"> ${t.seasonID},</c:forEach>">
                <a class="on" id="defen" href="javascript:void(0);" regular-data="<c:forEach items="${dataStatistics}" var="t"> ${t.score},</c:forEach>" playoff-data="<c:forEach items="${dataStatisticsPO}" var="t"> ${t.score},</c:forEach>" measure="分">得分</a>
                <a href="javascript:void(0);" id="sanfen" regular-data="<c:forEach items="${dataStatistics}" var="t"> ${t.threeHit},</c:forEach>" playoff-data="<c:forEach items="${dataStatisticsPO}" var="t"> ${t.threeHit},</c:forEach>" measure="个">三分</a>
                <a href="javascript:void(0);" id="lanban" regular-data="<c:forEach items="${dataStatistics}" var="t"> ${t.rebound},</c:forEach>" playoff-data="<c:forEach items="${dataStatisticsPO}" var="t"> ${t.rebound},</c:forEach>" measure="个">篮板</a>
                <a href="javascript:void(0);" id="zhugong" regular-data="<c:forEach items="${dataStatistics}" var="t"> ${t.assistance},</c:forEach>" playoff-data="<c:forEach items="${dataStatisticsPO}" var="t"> ${t.assistance},</c:forEach>" measure="个">助攻</a>
                <a href="javascript:void(0);" id="qiangduan" regular-data="<c:forEach items="${dataStatistics}" var="t"> ${t.grab},</c:forEach>" playoff-data="<c:forEach items="${dataStatisticsPO}" var="t"> ${t.grab},</c:forEach>" measure="个">抢断</a>
                <a href="javascript:void(0);" id="gaimao" regular-data="<c:forEach items="${dataStatistics}" var="t"> ${t.block},</c:forEach>" playoff-data="<c:forEach items="${dataStatisticsPO}" var="t"> ${t.block},</c:forEach>" measure="个">盖帽</a>
              </div>
               <div class="row">
                <!-- Highchart图表 -->
                <div id="Career-container" class="col-md-11" style="min-width: 310px; height: 400px; margin: 0 auto">
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

            <div class="bs-docs-section">
              <h2 id="Offense" class="page-header solutionForFixBar">进攻能力</h2>
              <!-- Highchart图表 -->
              <div id="Offense-container" style="min-width: 310px; height: 400px; margin: 0 auto">
              </div>
            </div>

            <div class="bs-docs-section">
              <h2 id="Defend" class="page-header solutionForFixBar">防守能力</h2>
              <!-- Highchart图表 -->
              <div id="Defend-container" style="min-width: 310px; height: 400px; margin: 0 auto">
              </div>
            </div>

            <div class="bs-docs-section">
              <h2 id="Backup" class="page-header solutionForFixBar">策应能力</h2>
              <!-- Highchart图表 -->
              <div id="Backup-container" style="min-width: 310px; height: 400px; margin: 0 auto">
              </div>
            </div>

            <div class="bs-docs-section">
              <h2 id="Synthesis" class="page-header solutionForFixBar">综合能力</h2>
              <!-- Highchart图表 -->
              <div id="Synthesis-container" style="min-width: 260px; height: 400px; margin: 0 auto">
              </div>
            </div>

            <div class="bs-docs-section">
              <h2 id="Experience" class="page-header solutionForFixBar">生涯经历</h2>
              <!-- Highchart图表 -->
              <div id="Experience-container" style="min-width: 310px; height: 400px; margin: 0 auto">
              </div>
            </div>
          </div>

          <div class="col-md-2" role="complementary">
            <nav class="bs-docs-sidebar hidden-print hidden-xs hidden-sm">
              <ul class="nav bs-docs-sidenav movingbar">
                <li>
                  <a href="#Career">生涯表现</a>
                </li>
                <li>
                  <a href="#Offense">进攻能力</a>
                </li>
                <li>
                  <a href="#Defend">防守能力</a>
                </li>
                <li>
                  <a href="#Backup">策应能力</a>
                </li>
                <li>
                  <a href="#Synthesis">综合能力</a>
                </li>
                <li>
                  <a href="#Experience">生涯经历</a>
                </li>
              </ul>
            </nav>
          </div>
      </div>
    </div> <!-- 详细信息 -->
    

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

    <script type="text/javascript"> 
      // 生涯表现
      var options = {
              chart: {
                  type: 'line',
                  renderTo:'Career-container'
              },
              title: {
                  text: '职业生涯常规赛得分变化趋势'
              },
              subtitle: {
                  text: ''
              },
              xAxis: {
                  categories: [<c:forEach items="${dataStatistics}" var="t"> 
				                    '${t.seasonID}',
						       </c:forEach>
						      ]
              },
              yAxis: {
                  title: {
                      text: ''
                  },
                  labels:{
                      format:'{value}分'
                  }
              },
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
                  enabled: false,
                  formatter: function() {
                      return '<b>'+ this.series.name +'</b><br/>'+this.x +': '+ this.y +'°C';
                  }
              },
              plotOptions: {
                  line: {
                      dataLabels: {
                          enabled: true
                      },
                      enableMouseTracking: false
                  }
              },
              series: [{
                  name: '${player.cName}',
                  data: [<c:forEach items="${dataStatistics}" var="t"> 
				           ${t.score},
						 </c:forEach>
						]
              }]
          };
      var chart = new Highcharts.Chart(options);
      $('#career_type a').click(function(){
        //为当前元素添加class:on
        $(this).addClass("on");
        // 遍历所有元素移除on
        $(this).siblings().removeClass("on");
        // 修改y轴单位
        var measure = $(this).attr('measure');
        options.yAxis.labels.format = '{value}'+measure;
        // 修改标题
        var active = $("label.active");
        var title;
        if(active.attr('id') == "regular")
          title = "职业生涯常规赛"+$(this).text()+"变化趋势";
        else
          title = "职业生涯季后赛"+$(this).text()+"变化趋势";
        options.title.text = title;
        //修改数据
        var data;
        if(active.attr('id') == "regular")
          data = $(this).attr('regular-data');
        else
          data = $(this).attr('playoff-data');
        var array = data.split(",");
        var nums = [ ];
        for (var i=0 ; i< array.length-1 ; i++)
        {
            nums.push(array[i]*1);
        }
        options.series[0].data = nums;
        // 重画
        chart = new Highcharts.Chart(options);
      });
      $("label#regular,label#playoff").click(function(){
        // 修改标题
        var title = "";
        var active = $('#career_type a.on');
        if($(this).attr('id') == "regular")
          title += "职业生涯常规赛" + active.text() + "变化趋势";
        else
          title += "职业生涯季后赛" + active.text() + "变化趋势";
        options.title.text = title;
        //修改数据
        var data;
        if($(this).attr('id') == "regular")
          data = active.attr('regular-data');
        else
          data = active.attr('playoff-data');
        var array = data.split(",");
        var nums = [ ];
        for (var i=0 ; i< array.length-1 ; i++)
        {
            nums.push(array[i]*1);
        }
        options.series[0].data = nums;
        //修改横坐标
        var date_array = [];
        if($(this).attr('id') == "regular")
          date_array = $('#career_type').attr('regular-date').split(',');
        else
          date_array = $('#career_type').attr('playoff-date').split(',');
        options.xAxis.categories = date_array;
        // 重画
        chart = new Highcharts.Chart(options);
      });
      // 进攻能力
      $(function () {
        $('#Offense-container').highcharts({
            chart: {
                type: 'column',
                margin: [ 50, 50, 100, 80]
            },
            title: {
                text: '进攻能力评分'
            },
            legend: {
              enabled: false
            },
            exporting: {
              enabled: false
            },
            credits: {
              enabled: false
            },
            xAxis: {
                categories: ['真实命中率','投篮效率','进攻篮板率','使用率','进攻效率','失误率',],
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '能力评分(100)'
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                pointFormat: '<b>{point.y} 分</b>',
            },
            series: [{
                name: 'Population',
                data: [${truePercentage }, ${shootEfficiency }, ${offenReboundPercent }, ${usePercent }, ${offensiveEfficiency }, ${mistakePercent }],
                dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif',
                        textShadow: '0 0 3px black'
                    }
                }
            }]
        });
      });
      // 防守能力
      $(function () {
        $('#Defend-container').highcharts({
            chart: {
                type: 'column',
                margin: [ 50, 50, 100, 80]
            },
            title: {
                text: '防守能力评分'
            },
            legend: {
              enabled: false
            },
            exporting: {
              enabled: false
            },
            credits: {
              enabled: false
            },
            xAxis: {
                categories: ['防守篮板率','抢断率','盖帽率','防守效率',],
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '能力评分(100)'
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                pointFormat: '<b>{point.y} 分</b>',
            },
            series: [{
                color: Highcharts.getOptions().colors[3],
                name: 'Population',
                data: [${defenReboundPercent }, ${grabPercent }, ${blockPercent }, ${defensiveEfficiency }],
                dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif',
                        textShadow: '0 0 3px black'
                    }
                  }
              }]
          });
      });
      // 策应能力
      $(function () {
          $('#Backup-container').highcharts({
              chart: {
                  type: 'column',
                  margin: [ 50, 50, 100, 80]
              },
              title: {
                  text: '策应能力评分'
              },
              legend: {
                enabled: false
              },
              exporting: {
                enabled: false
              },
              credits: {
                enabled: false
              },
              xAxis: {
                  categories: [
                      '助攻率',
                      '助攻失误比',
                  ],
                  labels: {
                      rotation: -45,
                      align: 'right',
                      style: {
                          fontSize: '13px',
                          fontFamily: 'Verdana, sans-serif'
                      }
                  }
              },
              yAxis: {
                  min: 0,
                  title: {
                      text: '能力评分(100)'
                  }
              },
              legend: {
                  enabled: false
              },
              tooltip: {
                  pointFormat: '<b>{point.y} 分</b>',
              },
              series: [{
                  color: Highcharts.getOptions().colors[4],
                  name: 'Population',
                  data: [${assistancePercent }, ${ATR }],
                  dataLabels: {
                      enabled: true,
                      rotation: -90,
                      color: '#FFFFFF',
                      align: 'right',
                      x: 4,
                      y: 10,
                      style: {
                          fontSize: '13px',
                          fontFamily: 'Verdana, sans-serif',
                          textShadow: '0 0 3px black'
                      }
                  }
              }]
          });
      }); 
      // 综合能力
      $(function () {
          $('#Synthesis-container').highcharts({
              chart: {
                  polar: true,
                  type: 'line'
              },
              
              title: {
                  text: '综合能力分析',
                  x: 0
              },
              pane: {
                size: '80%'
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
              xAxis: {
                  categories: ['WS', 'PER', '进攻能力', '防守能力', '策应能力'],
                  tickmarkPlacement: 'on',
                  lineWidth: 0
              },
                  
              yAxis: {
                  gridLineInterpolation: 'polygon',
                  lineWidth: 0,
                  min: 0
              },
              
              tooltip: {
                shared: true,
                  pointFormat: '<span style="color:{series.color}"><b>{point.y} 分</b><br/>'
              },
              
              
              series: [{
                  name: '${player.cName }',
                  data: [${WS }, ${PER }, ${OffensiveCapability }, ${DefensiveCapability }, ${AssistanceCapability }],
                  pointPlacement: 'on'
              }]             
          });
      });
      // 生涯重要经历
      $(function () {
          $('#Experience-container').highcharts({
              chart: {
                  type: 'spline'
              },
              title: {
                  text: '生涯重要经历'
              },
              subtitle: {
                  text: ''
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
              xAxis: {
                  categories: [<c:forEach items="${playerCareerHighList}" var="p">
								'${p.year}',
						        </c:forEach>
				              ]
              },
              yAxis: {
                  title: {
                      text: '重大经历'
                  },
                  labels:{
                    enabled: false
                  }
              },
              tooltip: {
                  enabled: true,
                  formatter: function() {
                      return '<b>'+ this.x +'年';
                  }
              },
              plotOptions: {
                  spline: {
                      dataLabels: {
                      formatter: function() {
					     <c:forEach items="${playerCareerHighList}" var="p">
						    if(this.x == ${p.year })
                               return '<b>${p.careerHighData }</b>';
						 </c:forEach>
                      },
                          enabled: true
                      },
                      enableMouseTracking: true
                  }
              },
              series: [{
                  name: '${player.cName }',
                  data: [<c:forEach items="${playerCareerHighList}" var="p">
								${p.yAxis},
						 </c:forEach>
				        ]
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