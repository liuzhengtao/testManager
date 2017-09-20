<%@page language="java" pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        #bm{
            padding: 100px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <%--<div data-options="region:'west',border:true,split:true," title="分类管理" style="width:150px; padding:5px;">
        <ul id="wu-category-tree" class="easyui-tree">

        </ul>
    </div>--%>
    <div data-options="region:'center',border:false">
        <!-- Begin of toolbar -->
        <div id="wu-toolbar-medel">
            <div class="wu-toolbar-button">
                <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a>
            </div>
        </div>
        <!-- End of toolbar -->
        <table id="wu-datagrid-model" toolbar="#wu-toolbar-medel">
        </table>
    </div>
</div>
<!-- Begin of easyui-dialog -->
<div id="wu-dialog-model" class="easyui-dialog" data-options="closed:true,iconCls:'icon-ok'" style="width:280px; height: 450px;padding:60px;text-align:center">
    <form id="wu-form-model" method="post">
        <input type="hidden" id="id" name="id" value="">
        <div style="text-align: center"> <span id="mmessage" style="color: red;display: none;"></span></div>
        <div>
            <span>用户名：</span>
            <input class="easyui-textbox" type="text" id ="name" name="name" data-options="required:true,iconCls:'icon-user'" onfocus="onmblur()">
        </div>
        <div style="text-align: center"> <span id="dmessage" style="color: red;text-align: center;display: none"></span></div>
        <div>
            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
            <input class="easyui-textbox" type="password" id="pwd" name="pwd" data-options="required:true" onfocus="onmblur()">
        </div>
        <div>
            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
        </div>
        <div>
            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>

        </div>
        <div>
            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
        </div>
    </form>
</div>
<!-- End of easyui-dialog -->
<script type="text/javascript">
    /**
     * Name 载入菜单树
     */
    /*$('#wu-category-tree').tree({
     url:'/seckill/getMenu',
     onClick:function(node){
     alert(node.text);
     }
     });*/

    /**
     * Name 添加记录
     */
    function add(){
        $('#wu-form-model').form('submit', {
            url:'/model/addModel',
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
                var	rd = eval('('+data+')');
                if(rd.state==200){
                    $.messager.alert('信息提示',rd.message,'info');
                    $('#wu-dialog').dialog('close');
                    $('#wu-datagrid').datagrid('reload');
                }
                else
                {
                    $.messager.alert('信息提示',rd.message,'info');
                }
            }
        });
    }

    /**
     * Name 修改记录
     */
    function edit(){
        $('#wu-form-model').form('submit',{
            url:'/model/updateModel',
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
                //alert(data);
                var rd = eval('('+data+')');
                if(rd.state==200){
                    $.messager.alert('信息提示',rd.message,'info');
                    $('#wu-dialog').dialog('close');
                    $('#wu-datagrid').datagrid('reload');
                }
                else
                {
                    $.messager.alert('信息提示',rd.message,'info');
                }
            }
        });
    }

    /**
     * Name 删除记录
     */
    function remove(){
        $.messager.confirm('信息提示','确定要删除该记录？', function(result){
            if(result){
                var items = $('#wu-datagrid').datagrid('getSelections');
                var ids = [];
                $(items).each(function(){
                    ids.push(this.id);
                });

                $.ajax({
                    url:'/user/deleteOneUser',
                    data:'id='+ids,
                    success:function(data){
                        if(data.state=200){
                            $.messager.alert('信息提示',data.message,'info');
                            $('#wu-datagrid').datagrid('reload');
                        }
                        else
                        {
                            $.messager.alert('信息提示',data.message,'info');
                        }
                    }
                });
            }
        });
    }

    /**
     * Name 打开添加窗口
     */
    function openAdd(){
        $('#wu-form-model').form('clear');
        $('#wu-dialog-model').dialog({
            closed: false,
            modal:true,
            title: "添加模块信息",
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog-model').dialog('close');
                }
            }]
        });
        $('#wu-dialog-model').dialog('center');
    }

    /**
     * Name 打开修改窗口
     */
    function openEdit(){
        //$('#wu-dialog').dialog('open');
        //$('#wu-form').form('clear');
        var item = $('#wu-datagrid-model').datagrid('getSelected');
        if(item==null){
            $.messager.alert('提示','未选择任何修改记录','error');
            return;
        }else{
            var id = item.id;
            $.ajax({
                url:'/user/getOneUser',
                data:'id='+id,
                contentType : "application/x-www-form-urlencoded; charset=utf-8",
                success:function(data){
                    if(data){
                        //alert(data.id);return;
                        $('#id').val(data.id);
                        $('#name').val(data.name);
                        $('#pwd').val(data.pwd);
                        //$('#wu-dialog').dialog('close');
                    }
                    else{
                        //绑定值
                        $('#wu-form-model').form('load', data)
                    }
                }
            });
            $('#wu-dialog-model').dialog({
                closed: false,
                modal:true,
                title: "修改信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: edit
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-model').dialog('close');
                    }
                }]
            });
        }

    }
    function onmblur(){
        $('#mmessage').hide();
        $('#dmessage').hide();
        $('#title').show();
        $('#mes').hide();

    };
    /**
     * Name 分页过滤器
     */
    function pagerFilter(data){
        if (typeof data.length == 'number' && typeof data.splice == 'function'){// is array
            data = {
                total: data.length,
                rows: data
            }
        }
        var dg = $(this);
        var opts = dg.datagrid('options');
        var pager = dg.datagrid('getPager');
        pager.pagination({
            onSelectPage:function(pageNum, pageSize){
                opts.pageNumber = pageNum;
                opts.pageSize = pageSize;
                pager.pagination('refresh',{pageNumber:pageNum,pageSize:pageSize});
                dg.datagrid('loadData',data);
            }
        });
        if (!data.originalRows){
            data.originalRows = (data.rows);
        }
        var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
        var end = start + parseInt(opts.pageSize);
        data.rows = (data.originalRows.slice(start, end));
        return data;
    }

    /**
     * Name 载入数据
     */
    $('#wu-datagrid-model').datagrid({
        url:'/user/getAllUsers',
        //loadFilter:pagerFilter,
        //rownumbers:true,
        singleSelect:true,
        pageSize:1,
        pagination:true,
        multiSort:true,
        fitColumns:true,
        fit:true,
        columns:[[
            { checkbox:true},
            { field:'id',title:'id', width:100},
            { field:'name',title:'name',width:180},
            { field:'pwd',title:'pwd',width:100}
        ]]
    });
</script>
</body>
</html>