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

    <!-- 加载动画 -->
    <link rel="stylesheet" href=${path.concat("/NBA/css/fakeLoader.css")}>
    <!-- 加载动画 -->
    <div class="fakeloader"></div>
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

    <!-- 基本信息 -->
    <div class="bs-docs-header" id="content">
	   <p>找不到该球员，<a href="${path.concat('/NBA/team.jsp')}">返回</a></P>
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

<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../NBA/js/bootstrap.min.js"></script>
	<script src="../NBA/js/docs.min.js"></script>
	<!-- 导航栏搜索匹配 -->
	<script src="../NBA/js/jquery-ui/jquery-ui.js"></script>
	<script src="../NBA/js/search-autocomplete.js"></script>
	<!-- 加载动画 -->
    <script src="../NBA/js/fakeLoader.min.js"></script>

</body>
</html>