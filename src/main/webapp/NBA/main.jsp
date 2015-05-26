<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <!-- 加载动画 -->
    <link rel="stylesheet" href="css/fakeLoader.css">
    <!-- 加载动画 -->
    <div class="fakeloader"></div>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="js/jquery-ui/jquery-ui.css">
    <link href="css/new.css" rel="stylesheet">
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
          <a class="navbar-brand hidden-sm" href="${path.concat('/NBA/main.jsp')}">NBA数据分析网</a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${path.concat('/NBA/main.jsp')}">球员</a></li>
            <li><a href="${path.concat('/NBA/team.jsp')}">球队</a></li>
            <li><a href="${path.concat('/game/game')}">比赛</a></li>
            <li><a href="${path.concat('/player/comparison')}">球员对比</a></li>
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

    <!--轮播-->
    <div class="carousel slide" id="carousel-nba" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#carousel-nba" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-nba" data-slide-to="1"></li>
        <li data-target="#carousel-nba" data-slide-to="2"></li>
      </ol>

      <div class="carousel-inner">
        <div class="item active"><img alt="" src="images/kobe.jpg" />
          <div class="carousel-caption">
            <h4>科比·布莱恩特</h4>
            <p>能否重新带领湖人拿到季后赛名额</p>
          </div>
        </div>

        <div class="item"><img alt="" src="images/lebron.jpg" />
          <div class="carousel-caption">
            <h4>勒布朗·詹姆斯</h4>
            <p>重回骑士</p>
          </div>
        </div>

        <div class="item"><img alt="" src="images/curry.jpg" />
          <div class="carousel-caption">
            <h4>斯蒂芬·库里</h4>
            <p>崛起的MVP</p>
          </div>
        </div>
      </div>
      <!-- Controls -->
      <a class="left carousel-control" href="#carousel-nba" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#carousel-nba" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- 轮播 -->

    <!--球员列表-->
    <div class="player">
      <div class="bs-glyphicons">
        <ul class="bs-glyphicons-list">
          <li>
            <a href="${path.concat('/player/科比-布莱恩特')}">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="playersImage/P0000386.jpg" alt="科比">
              </div>
            </a>
              <span class="glyphicon-class">Kobe Bryant</span>
              <span class="glyphicon-class">科比·布莱恩特</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="playersImage/P0000094.jpg" alt="詹姆斯">
              </div>
            </a>
            <span class="glyphicon-class">LeBron Raymone James</span>
            <span class="glyphicon-class">勒布朗·詹姆斯</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Harden.jpg" alt="哈登">
              </div>
            </a>
            <span class="glyphicon-class">James Harden</span>
            <span class="glyphicon-class">詹姆斯·哈登</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Curry.jpg" alt="库里">
              </div>
            </a>
            <span class="glyphicon-class">Stephen·Curry</span>
            <span class="glyphicon-class">斯蒂芬·库里</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Durant.jpg" alt="杜兰特">
              </div>
            </a>
            <span class="glyphicon-class">Kevin Durant</span>
            <span class="glyphicon-class">凯文·杜兰特</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Wade.jpg" alt="韦德">
              </div>
            </a>
            <span class="glyphicon-class">Dwyane Tyrone Wade</span>
            <span class="glyphicon-class">德怀恩·韦德</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Duncan.jpg" alt="邓肯">
              </div>
            </a>
            <span class="glyphicon-class">Tim Duncan</span>
            <span class="glyphicon-class">蒂姆·邓肯</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Westbrook.jpg" alt="邓肯">
              </div>
            </a>
            <span class="glyphicon-class">Russell Westbrook</span>
            <span class="glyphicon-class">拉塞尔·威斯布鲁克</span>
          </li>


          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Paul.jpg" alt="保罗">
              </div>
            </a>
              <span class="glyphicon-class">Chris Paul</span>
              <span class="glyphicon-class">克里斯·保罗</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Griffin.jpg" alt="格里芬">
              </div>
            </a>
            <span class="glyphicon-class">Blake Griffin</span>
            <span class="glyphicon-class">布雷克·格里芬</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Nowitzki.jpg" alt="诺维斯基">
              </div>
            </a>
            <span class="glyphicon-class">Dirk Werner Nowitzki</span>
            <span class="glyphicon-class">德克·维尔纳·诺维茨基</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Rose.jpg" alt="罗斯">
              </div>
            </a>
            <span class="glyphicon-class">Derrick Martell Rose</span>
            <span class="glyphicon-class">德里克·马特尔·罗斯</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Nash.jpg" alt="纳什">
              </div>
            </a>
            <span class="glyphicon-class">Steve Nash</span>
            <span class="glyphicon-class">史蒂夫·纳什</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Parker.jpg" alt="帕克">
              </div>
            </a>
            <span class="glyphicon-class">Tony Parker</span>
            <span class="glyphicon-class">托尼·帕克</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Anthony.jpg" alt="安东尼">
              </div>
            </a>
            <span class="glyphicon-class">Carmelo Anthony</span>
            <span class="glyphicon-class">卡梅隆·安东尼</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Gasol.jpg" alt="加索尔">
              </div>
            </a>
            <span class="glyphicon-class">Pau Gasol</span>
            <span class="glyphicon-class">保罗·加索尔</span>
          </li>

          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="playersImage/P0000386.jpg" alt="科比">
              </div>
            </a>
              <span class="glyphicon-class">Kobe Bryant</span>
              <span class="glyphicon-class">科比·布莱恩特</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Lebron.jpg" alt="詹姆斯">
              </div>
            </a>
            <span class="glyphicon-class">LeBron Raymone James</span>
            <span class="glyphicon-class">勒布朗·詹姆斯</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Harden.jpg" alt="哈登">
              </div>
            </a>
            <span class="glyphicon-class">James Harden</span>
            <span class="glyphicon-class">詹姆斯·哈登</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Curry.jpg" alt="库里">
              </div>
            </a>
            <span class="glyphicon-class">Stephen·Curry</span>
            <span class="glyphicon-class">斯蒂芬·库里</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Durant.jpg" alt="杜兰特">
              </div>
            </a>
            <span class="glyphicon-class">Kevin Durant</span>
            <span class="glyphicon-class">凯文·杜兰特</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Wade.jpg" alt="韦德">
              </div>
            </a>
            <span class="glyphicon-class">Dwyane Tyrone Wade</span>
            <span class="glyphicon-class">德怀恩·韦德</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Duncan.jpg" alt="邓肯">
              </div>
            </a>
            <span class="glyphicon-class">Tim Duncan</span>
            <span class="glyphicon-class">蒂姆·邓肯</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Westbrook.jpg" alt="邓肯">
              </div>
            </a>
            <span class="glyphicon-class">Russell Westbrook</span>
            <span class="glyphicon-class">拉塞尔·威斯布鲁克</span>
          </li>


          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Paul.jpg" alt="保罗">
              </div>
            </a>
              <span class="glyphicon-class">Chris Paul</span>
              <span class="glyphicon-class">克里斯·保罗</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Griffin.jpg" alt="格里芬">
              </div>
            </a>
            <span class="glyphicon-class">Blake Griffin</span>
            <span class="glyphicon-class">布雷克·格里芬</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Nowitzki.jpg" alt="诺维斯基">
              </div>
            </a>
            <span class="glyphicon-class">Dirk Werner Nowitzki</span>
            <span class="glyphicon-class">德克·维尔纳·诺维茨基</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Rose.jpg" alt="罗斯">
              </div>
            </a>
            <span class="glyphicon-class">Derrick Martell Rose</span>
            <span class="glyphicon-class">德里克·马特尔·罗斯</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Nash.jpg" alt="纳什">
              </div>
            </a>
            <span class="glyphicon-class">Steve Nash</span>
            <span class="glyphicon-class">史蒂夫·纳什</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Parker.jpg" alt="帕克">
              </div>
            </a>
            <span class="glyphicon-class">Tony Parker</span>
            <span class="glyphicon-class">托尼·帕克</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Anthony.jpg" alt="安东尼">
              </div>
            </a>
            <span class="glyphicon-class">Carmelo Anthony</span>
            <span class="glyphicon-class">卡梅隆·安东尼</span>
          </li>
          <li>
            <a href="PlayerInfo.html">
              <div class="thumbnail"><!--头像大小选择120*100-->
                <img src="PlayersAvatar/Gasol.jpg" alt="加索尔">
              </div>
            </a>
            <span class="glyphicon-class">Pau Gasol</span>
            <span class="glyphicon-class">保罗·加索尔</span>
          </li>
        </ul>
      </div>
    </div><!--球员列表-->

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


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.2.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!-- 导航栏搜索匹配 -->
    <script src="js/jquery-ui/jquery-ui.js"></script>
    <script src="js/search-autocomplete.js"></script>
	<!-- 加载动画 -->
    <script src="js/fakeLoader.min.js"></script>

  </body>
</html>