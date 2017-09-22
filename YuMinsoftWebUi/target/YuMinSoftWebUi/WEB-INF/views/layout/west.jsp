<%@page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<div class="wu-sidebar" data-options="region:'west',split:false,border:false">
    <div class="easyui-accordion" data-options="border:true,fit:true">
        <div title="自动化平台管理" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <%--<li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="/page/getObjectPage" iframe="0">页面管理</a></li>--%>
                <li iconCls="icon-drive-web"><a href="javascript:void(0)" data-icon="icon-book" data-link="/page/getLocatorPage" iframe="0">页面管理</a></li>
                <%--<li iconCls="icon-user-group"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="/page/getModelPage" iframe="0">模块管理</a></li>--%>
                <li iconCls="icon-cog"><a href="javascript:void(0)" data-icon="icon-cog" data-link="/page/getCasePage" iframe="0">用例管理</a></li>
                <li iconCls="icon-application-osx-error"><a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="/page/getStepPage" iframe="0">步骤管理</a></li>
            </ul>
        </div>
        <div title="系统设置" data-options="iconCls:'icon-wrench'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="/page/getUserPage" iframe="0">用户管理</a></li>
                <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="/page/getRolePage" iframe="0">角色管理</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>