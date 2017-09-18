<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="public/head.jsp"%>
    <style type="text/css">
        body{
            padding: 0px;
            margin: 0px;
        }
        #loggo{
            background: cornflowerblue;
        }
    </style>
</head>
<body>
<div class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'north'" style="height: 60%" id="loggo">
        <div class="wu-header" data-options="region:'north',border:false,split:true">
            <div class="wu-header-left">
                <h1>EasyUI Web Admin</h1>
            </div>
            <div class="wu-header-right">
                <p><strong class="easyui-tooltip" title="2条未读消息">admin</strong>，欢迎您！</p>
                <p><a href="#">网站首页</a>|<a href="#">支持论坛</a>|<a href="#">帮助中心</a>|<a href="#">安全退出</a></p>
            </div>
        </div>
    </div>
    <div data-options="region:'south',border:true,split:true">
        &copy; 2013 Wu All Rights Reserved
    </div>
    <div data-options="region:'west',split:true" title="West" style="width: 150px;">
        <%@include file="layout/west.jsp"%>
    </div>
    <div data-options="region:'center',title:'内容部分',iconCls:'icon-ok'">
        <%@include file="layout/center.jsp"%>
    </div>
</div>
<script>
    $(function(){
        $('.wu-side-tree a').bind("click",function(){
            var title = $(this).text();
            var url = $(this).attr('data-link');
            var iconCls = $(this).attr('data-icon');
            var iframe = $(this).attr('iframe')==1?true:false;
            addTab(title,url,iconCls,iframe);
        });
    })

    /**
     * Name 载入树形菜单
     */
    $('#wu-side-tree').tree({
        url:'temp/menu.php',
        cache:false,
        onClick:function(node){
            var url = node.attributes['url'];
            if(url==null || url == ""){
                return false;
            }
            else{
                addTab(node.text, url, '', node.attributes['iframe']);
            }
        }
    });

    /**
     * Name 选项卡初始化
     */
    $('#wu-tabs').tabs({
        tools:[{
            iconCls:'icon-reload',
            border:false,
            handler:function(){
                $('#wu-datagrid').datagrid('reload');
            }
        }]
    });

    /**
     * Name 添加菜单选项
     * Param title 名称
     * Param href 链接
     * Param iconCls 图标样式
     * Param iframe 链接跳转方式（true为iframe，false为href）
     */
    function addTab(title, href, iconCls, iframe){
        var tabPanel = $('#wu-tabs');
        if(!tabPanel.tabs('exists',title)){
            var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:100%;"></iframe>';
            if(iframe){
                tabPanel.tabs('add',{
                    title:title,
                    content:content,
                    iconCls:iconCls,
                    fit:true,
                    cls:'pd3',
                    closable:true
                });
            }
            else{
                tabPanel.tabs('add',{
                    title:title,
                    href:href,
                    iconCls:iconCls,
                    fit:true,
                    cls:'pd3',
                    closable:true
                });
            }
        }
        else
        {
            tabPanel.tabs('select',title);
        }
    }
    /**
     * Name 移除菜单选项
     */
    function removeTab(){
        var tabPanel = $('#wu-tabs');
        var tab = tabPanel.tabs('getSelected');
        if (tab){
            var index = tabPanel.tabs('getTabIndex', tab);
            tabPanel.tabs('close', index);
        }
    }
</script>
</body>
</html>
<html>
<head>
    <title>登录界面</title>
    <%@include file="public/head.jsp"%>
</head>
<body>
<div style="text-align: center">
    <div id="doLogin" class="easyui-pannel" title="欢迎来到登录界面" style="width:450px;height:340px;"
         data-options="reo_sizable:false,modal:true,close:false,closable:false,buttons:'#dlg-buttons'">
        <div style="padding:45px 60px 20px 75px">
            <form id="fm" method="post">
                <table cellpadding="5">
                    <thead>
                    <tr >
                        <td colspan="2" style="text-align: center">登录提示框</td>
                    </tr>
                    </thead>
                    <tr>
                        <td>用户名:</td>
                        <td><input class="easyui-textbox" type="text" id ="name" name="name" data-options="required:true"></td>
                    </tr>
                    <tr>
                        <td>密码:</td>
                        <td><input class="easyui-textbox" type="password" id="pwd" name="pwd" data-options="required:true"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>确认密码:</td>
                        <td><input class="easyui-textbox" type="password" id="confirm" name="confirm" data-options="required:true"></td>
                    </tr>
                    <tr>
                        <td>验证码:</td>
                        <td><input class="easyui-textbox" name="vertity" id="vertity"></td>
                        <td><span id="message" class=""></span></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" id="login" style="margin-right: 50px;" iconCls="icon-ok" onclick="sub()">登录</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" id="cancle" iconCls="icon-cancel" onclick="javascript:$('#dd').dialog('close')">清空</a>
    </div>
</div>


<script src="/resources/js/public/common.js"></script>
</body>
</html>