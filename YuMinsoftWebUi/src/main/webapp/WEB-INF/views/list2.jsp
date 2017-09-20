<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="public/tag.jsp"%>
<html>
<head>
    <title>秒杀列表</title>
    <%@include file="public/head.jsp"%>
</head>
<body>

<h2>秒杀商品列表</h2>
<p>可以查看商品列表项</p>
<div style="margin:20px 0;"></div>

<div id="dd" style="width:100px;height:100px;">
    <div id="title" style="background:#ccc;">
        <table id="test" class="easyui-datagrid" title="商品秒杀列表" style="width:800px;height:400px">
            <thead>
            <tr>
                <th data-options="field:'name',width:80">秒杀商品名称</th>
                <th data-options="field:'number',width:100">秒杀数量</th>
                <th data-options="field:'startTime',width:80,align:'right'">开始时间</th>
                <th data-options="field:'endTime',width:80,align:'right'">结束时间</th>
                <th data-options="field:'createTime',width:250">创建时间</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script>
    $('#dd').draggable({
        handle:'#title'
    });
</script>
<script src="/resources/js/public/common.js"></script>
</body>
</html>
