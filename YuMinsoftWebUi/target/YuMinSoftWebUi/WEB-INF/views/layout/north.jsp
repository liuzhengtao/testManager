<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="wu-header" data-options="region:'north',border:false,split:false">
    <div class="wu-header-left">
        <h1>郁敏科技自动化平台管理中心</h1>
    </div>
    <div class="wu-header-right" style="text-align: right">
        <p><strong class="easyui-tooltip" title="${1}" style="color: red">${name}</strong>，欢迎您！</p>
        <p id="de"></p>
    </div>
</div>
<script>
    function showTime() {
        var curTime = new Date();
        $("#de").html(curTime.toLocaleString()+'&nbsp;&nbsp;${week}<a href="/page/quitLogin" style="color: red">安全退出</a>');
        setTimeout("showTime()", 1000);
    }
    // 页面加载完成后执行上面的自定义函数
    $(function(){
        showTime()
    })
</script>
</body>
</html>
