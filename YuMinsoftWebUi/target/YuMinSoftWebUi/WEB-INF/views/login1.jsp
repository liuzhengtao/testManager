<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="public/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>证大财富管理系统登录界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="public/head.jsp"%>
   <link href="/resources/css/style.css" rel='stylesheet' type='text/css' />
</head>
<script>
    var codeStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    function getRandom(n, m) {
        n = Number(n);       //转换n,m，结果不是数字就是NaN
        m = Number(m);
        if (isNaN(n) || isNaN(m)) {     //判断n,m,是不是有效数字，如果n或m其中一个传入的不是数字
            return Math.random();      //返回 【0-1）之间的随机小数
        }
        if (n > m) {             //如果n大于m，则交换位置
            var temp = n;
            n = m;
            m = temp;
        }
        return Math.round(Math.random() * (m - n) + n);          //返回，取m,n之间的随机整数。
    }
    function showIdentify() {
        var str = "";　　　　　　　　//定义一个空字符串备用
        for (var i = 0; i < 4; i++) {    //遍历4个索引
            var ran = getRandom(0, 61);      //调用getRandom方法，随机获取一个索引0-61里的随机索引
            str += codeStr.charAt(ran);      //把codeStr字符串里，我们指定获取ran（这个4个索引）；
        }
        return str;       //呈现在页面上
    }            
</script>
<body>
<!-----start-main---->
<div class="main">
    <div class="login-form">
        <h1 id="title">欢迎登录证大财富系统</h1>
        <h1 id="mes" style="text-align: center;display: none"></h1>
        <div class="head">
            <img src="/resources/img/user.png" alt=""/>
        </div>
        <form id="login" method="post">
            <div style="text-align: center"> <span id="mmessage" style="color: red;display: none;"></span></div>
            <div>
                <span>用户名：</span>
                <input class="easyui-textbox" type="text" id ="name" name="name" data-options="required:true" onfocus="onmblur()">
            </div>
            <div style="text-align: center"> <span id="dmessage" style="color: red;text-align: center;display: none"></span></div>
            <div>
                <span>密&nbsp;&nbsp;&nbsp;码：</span>
                <input class="easyui-textbox"  type="password" id="pwd" name="pwd" data-options="required:true';"  onfocus="onmblur()">
            </div>
            <div class="vertivy"><span id="img_verty" onclick="show()"></span> </div>
            <div style="text-align: center"> <span id="dcode" style="color: red;text-align: center;display: none"></span></div>
            <div>
                <span>验证码：</span>
                <input class="easyui-textbox"  type="text" id="md" name="md" data-options="required:true';"  onfocus="onmblur()">
            </div>
            <div class="submit">
                <input type="submit" onclick="" value="登录" >
                <input type="reset" onclick="" value="清空" >
            </div>
        </form>
    </div>
    <script>
        function show(){
            $('#img_verty').html(showIdentify());
        }
       $(function(){
           show();
           $('#login').form({
               url:'/user/doLogin',
               onSubmit: function(){
                   var name =$('#name').val();
                   var pwd =$('#pwd').val();
                   var identifyCode = $('#md').val();
                   var randomCode = $('#img_verty').text();
                   console.log(randomCode);
                   if(name!="" && pwd!="" && identifyCode!="" && identifyCode==randomCode){
                       return true;
                   }else if(name==""){
                       $('#mmessage').show();
                       $('#mmessage').html('输入用户为空');
                       return false;
                   }else if(pwd==""){
                       $('#dmessage').show();
                       $('#dmessage').html('输入密码为空');
                       return false;
                   }else if(identifyCode==""){
                       $('#dcode').show();
                       $('#dcode').html('输入验证码为空');
                   }else{
                       $('#dcode').show();
                       $('#dcode').html('输入验证码有误,请重新输入');
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
