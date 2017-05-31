<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.LoginUserBean" %>

<a href="ForVegetalian.jsp">
	<h1 class="fontismrbedfort textcenter h1">VegeSel For Producer</h1>
	<p class="fontismrbedfort textcenter">Vegetable to Sell</p>
</a>
<p><a class="pull-right goto" href="modechange?vegatlianOrProducer=vegetalian">Go to "For Vegetalian"</a></p>
<br/>
<nav class="navbar navbar-default navbarsbackcolor navswidth">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="fontcoloriswhite"><a href="selling?mode=/selling?mode=recordItem" class="navbarsbackcolor fontcoloriswhite">商品を登録する<span class="sr-only">(current)</span></a></li>
        <li><a href="viewstock">在庫を確認・更新する</a></li>
        <li><a>プロフィールを更新する</a></li>
      </ul>
     </div>
</nav>