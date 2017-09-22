<%@page language="java" pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center;fit:true',border:false" style="height: 300px;height: 400px;">
        <div class="wu-toolbar-button" style="padding-bottom: 10px;padding-top: 20px;">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a>
        </div>
        <div class="wu-toolbar-search-case" style="margin-left: 13px;">
            <div class="page-case" style="padding: 4px 0 13px 0;">
                <label>模块名称：</label><input id="m_name" class="wu-text" style="width:100px" >
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>用例编号：</label><input class="wu-text" id="l_Id" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>用例名称：</label><input id="l_name" class="wu-text" style="width:100px" >
            </div>
            <div class="page-time" style="padding: 4px 0 13px 0;margin: 0 0 0 0;">
                <label>起始时间：</label><input id="startTime" class="easyui-datebox" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>结束时间：</label><input id="endTime" class="easyui-datebox" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="pSearch">搜索</a>
            </div>
        </div>
        <!-- Begin of toolbar -->
        <table id="wu-datagrid-case" toolbar="#" border="0"></table>
    </div>
</div>

<div id="wu-dialog-case" class="easyui-dialog" data-options="closed:true,iconCls:'icon-book-add'" style="width:450px; height:750px;padding:40px;text-align:center;">
    <form id="wu-form-case" method="post" style="text-align: left;font-size: 16px; padding-left: 42px;">
        <div style="text-align: center"> <span id="casemessage" style="color: red;display:none;"></span></div>
        <div style="margin-top: 30px;" class="one">
            <span>模块名称<span style="color: red;">*</span>：</span>
            <input class="wu-text" type="text" id="mName" name="mName" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <input type="hidden" id="cId" value="">
        <div style="height: 15px"></div>
        <span>用例名称<span style="color: red;">*</span>：</span>
        <div>
            <input class="wu-text" type="text" id="cName" name="cName" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <span>用例的检查点<span style="color: red;">*</span>：</span>
        <div>
            <input class="wu-text" type="text" id="cCheckPort" name="cCheckPort" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <span>用例前置条件：</span>
        <div>
            <input class="wu-text" type="text" id="cPrecondition" name="cPrecondition" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <span>用例预期结果<span style="color: red;">*</span>：</span>
        <div>
            <input class="wu-text" type="text" id="cExpected" name="cExpected" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <span>备&nbsp;&nbsp;&nbsp;注：</span>
        <div>
            <textarea  type="textarea" id="lDsec" name="lDsec" rows="10" cols="20" style="width: 240px">
            </textarea>
        </div>
    </form>
</div>
<!-- End of easyui-dialog -->
<script type="text/javascript">
    /**
     * Name 添加记录
     */
    function add(){
        $('#wu-form-case').form('submit', {
            url:'/case/addObjectPage',
            onSubmit: function(){
                var pName =$('#pName').val();
                if(pName!=""){
                    return true;
                }else{
                    showMessage('one',"输入的页面对象为空");
                    return false;
                }
            },
            success:function(data){
                var	rd = eval('('+data+')');
                if(rd.state==200){
                    $.messager.alert('信息提示',rd.message,'info');
                    $('#wu-dialog-case').dialog('close');
                    $('#wu-datagrid-case').datagrid('reload');
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
        $('#wu-form-case').form('submit',{
            url:'/case/updateLocatorPage',
            onSubmit: function(){
                var pName =$('#pName').val();
                if(pName!=""){
                    return true;
                }else{
                    showMessage('one',"输入的页面对象为空");
                    return false;
                }
            },
            success:function(data){
                //alert(data);
                var rd = eval('('+data+')');
                if(rd.state==200){
                    $.messager.alert('信息提示',rd.message,'info');
                    $('#wu-dialog-case').dialog('close');
                    $('#wu-datagrid-case').datagrid('reload');
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
                var items = $('#wu-datagrid-case').datagrid('getSelections');
                var ids = [];
                $(items).each(function(){
                    ids.push(this.id);
                });

                $.ajax({
                    url:'/case/deleteObjectPage',
                    data:'id='+ids,
                    success:function(data){
                        if(data.state=200){
                            $.messager.alert('信息提示',data.message,'info');
                            $('#wu-datagrid-case').datagrid('reload');
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
        $('#wu-form-case').form('clear');
        $('#wu-dialog-case').dialog({
            closed: false,
            modal:true,
            title: "添加用例信息",
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog-case').dialog('close');
                }
            }]
        });
        $('#wu-dialog-case').dialog('center');
    }

    /**
     * Name 打开修改窗口
     */
    function openEdit(){
        //$('#wu-dialog').dialog('open');
        //$('#wu-form').form('clear');
        var item = $('#wu-datagrid-case').datagrid('getSelected');
        if(item==null){
            $.messager.alert('提示信息','至少选择一条页面记录','warning');
        }else{
            var id = item.id;
            $.ajax({
                url:'/case/getOneLocatorPage',
                data:'id='+id,
                contentType : "application/x-www-form-urlencoded; charset=utf-8",
                success:function(data){
                    if(data){
                        $('#id').val(data.id);
                        $('#name').val(data.name);
                        $('#pwd').val(data.pwd);
                        //$('#wu-dialog').dialog('close');
                    }
                    else{
                        //绑定值
                        $('#wu-form-case').form('load', data)
                    }
                }
            });
            $('#wu-dialog-case').dialog({
                closed: false,
                modal:true,
                title: "修改用例信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: edit
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-case').dialog('close');
                    }
                }]
            });
        }

    }
    function onmblur(){
        $('#amessage').css("display","none");
    };
    function showMessage(class_name,str){
        $('.'+class_name).append('<span id="amessage" style="color: red;display: block;position:relative;top:-45px;">'+str+'</span>');
    }

    /**
     * Name 载入数据
     */
    $('#wu-datagrid-case').datagrid({
        url:'/case/getAllLocatorPage',
        //loadFilter:pagerFilter,
        //rownumbers:true,
        singleSelect:true,
        pageSize:1,
        pagination:false,
        multiSort:true,
        fitColumns:true,
        fit:true,
        columns:[[
            { checkbox:true},
            { field:'cId',title:'用例编号', sortable:true,order:'desc',width:15},
            { field:'mName',title:'模块名称',width:50},
            { field:'cName',title:'用例名称',width:50},
            { field:'cCheckPort',title:'用例的检查点',width:50},
            { field:'cPrecondition',title:'用例前置条件',width:50},
            { field:'cExpected',title:'用例预期结果',width:50},
            { field:'cEnforcement',title:'用例执行结果',width:50},
            { field:'cCreateTime',title:'创建时间',width:50}
        ]]
    });
</script>
</body>
</html>