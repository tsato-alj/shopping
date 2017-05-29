<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
<head>
  <meta charset="utf-8" />
  <title>GOAL</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
  <link rel="stylesheet" href="/demos/style.css" />
  <script>
  $(function() {
    $.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
    $( ".datepicker" ).datepicker();
  });
  </script>
</head>



<body>

	<form action="" methpd="post">
		<p>目標: <textarea name="goal" rows="2" cols="30" maxlength="50" ></textarea></p>
 		<p>開始日: <input type="text" class="datepicker"　name="start"  required /></p>
 		<p>目標終了予定日: <input type="text" class="datepicker"　name="goalDate" required /></p>
 		<p><button type="submit" name="" value="">目標を設定する</button></p>
 		<p><button type="reset" name="" value="">リセット</button></p>
	</form>
</body>
</html>
