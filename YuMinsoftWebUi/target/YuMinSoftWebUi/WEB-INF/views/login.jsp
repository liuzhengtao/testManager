<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="public/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>郁敏科技自动化平台管理中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="public/head.jsp"%>
   <link href="/resources/css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>
<!-----start-main---->
<div class="main">
    <div class="login-form">
        <h1 id="title" style="color: #0f0f0f;font-size: 28px;">郁敏科技自动化平台管理中心</h1>
        <h1 id="mes" style="text-align: center;display: none"></h1>
        <div class="head">
            <img src="/resources/img/user.png" alt=""/>
        </div>
        <form id="login" method="post">
             <div style="text-align: center"> <span id="mmessage" style="color: red;display: none;"></span></div>
            <span>用户名：</span>
            <input class="easyui-textbox" type="text" id ="name" name="name" data-options="required:true" onfocus="onmblur()">
            <div style="text-align: center"> <span id="dmessage" style="color: red;text-align: center;display: none"></span></div>
            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
            <input class="easyui-textbox" type="password" id="pwd" name="pwd" data-options="required:true" onfocus="onmblur()">
            <div class="submit">
                <input type="submit" onclick="" value="登录" >
                <input type="reset" onclick="" value="清空" >
            </div>
        </form>
    </div>
    <script>
       $(function(){
           $('#login').form({
               url:'/user/doLogin',
               onSubmit: function(){
                   var name =$('#name').val();
                   var pwd =$('#pwd').val();
                   if(name!="" && pwd!=""){
                       return true;
                   }else if(name==""){
                       $('#mmessage').show();
                       $('#mmessage').html('输入用户为空');
                       return false;
                   }else if(pwd==""){
                       $('#dmessage').show();
                       $('#dmessage').html('输入密码为空');
                       return false;
                   }
                   return false;
               },
               success:function(data){
                   var rdata = eval('('+data+')');
                   if(rdata.state=="200"){
                       //alert(rdata.name);
                       $(location).attr('href','/page/doLogin');
                   }else {
                       $('#mes').show();
                       $('#title').hide();
                       $('#mes').html('<span style="color: red">'+rdata.message +'</span>');
                   }

               }
           });
       });

        function onmblur(){
           $('#mmessage').hide();
            $('#dmessage').hide();
            $('#title').show();
            $('#mes').hide();

        }
    </script>
</div>
</body>
</html>
