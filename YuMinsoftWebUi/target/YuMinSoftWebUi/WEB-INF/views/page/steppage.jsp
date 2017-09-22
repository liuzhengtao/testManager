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
        <div class="wu-toolbar-search-step" style="margin-left: 13px;">
            <div class="page-step" style="padding: 4px 0 13px 0;">
                <label>步骤编号：</label><input class="wu-text" id="s_Id" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>步骤名称：</label><input id="s_name" class="wu-text" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>页面名称：</label><input id="p_name" class="wu-text" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>用例名称：</label><input id="c_name" class="wu-text" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>

            </div>
            <div class="page-time" style="padding: 4px 0 13px 0;margin: 0 0 0 0;">
                <label>起始时间：</label><input id="startTime" class="easyui-datebox" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>结束时间：</label><input id="endTime" class="easyui-datebox" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="sSearch">搜索</a>
            </div>
        </div>
        <!-- Begin of toolbar -->
        <table id="wu-datagrid-step" toolbar="#" border="0"></table>
    </div>
</div>
<!-- Begin of easyui-dialog -->
<div id="wu-dialog-step" class="easyui-dialog" data-options="closed:true,iconCls:'icon-book-add'" style="width:450px; height:750px;padding:40px;text-align:center;">
    <form id="wu-form-step" method="post" style="text-align: left;font-size: 16px; padding-left: 42px;">
        <div style="text-align: center"> <span id="stepmessage" style="color: red;display:none;"></span></div>
        <div style="margin-top: 30px;" class="one">
            <span>页面名称<span style="color: red;">*</span>：</span>
            <select id="pName" name="pName"  class="easyui-combobox" style="height: 30px;width: 240px">
                <option>id</option>
            </select>
        </div>
        <div style="height: 15px"></div>
        <span>用例名称<span style="color: red;">*</span>：</span>
        <div>
            <select id="cName" name="cName"  class="easyui-combobox" style="height: 30px;width: 240px">
                <option>id</option>
                <option>name</option>
                <option>className</option>
            </select>
        </div>
        <input type="hidden" id="sId" name="sId" value="">
        <div style="height: 15px"></div>
        <span>步骤名称<span style="color: red;">*</span>：</span>
        <div>
            <input class="wu-text" type="text" id="sName" name="sName" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <span>使用数据：</span>
        <div>
            <input class="wu-text" type="text" id="sData" name="sData" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <span>排序号<span style="color: red;">*</span>：</span>
        <div>
            <input class="wu-text" type="text" id="sNum" name="sNum" data-options="required:true" style="height: 20px;width: 240px">
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
        $('#wu-form-step').form('submit', {
            url:'/step/addStepPage',
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
                    $('#wu-dialog-step').dialog('close');
                    $('#wu-datagrid-step').datagrid('reload');
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
        $('#wu-form-step').form('submit',{
            url:'/step/updateLocatorPage',
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
                    $('#wu-dialog-step').dialog('close');
                    $('#wu-datagrid-step').datagrid('reload');
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
                var items = $('#wu-datagrid-step').datagrid('getSelections');
                var ids = [];
                $(items).each(function(){
                    ids.push(this.id);
                });

                $.ajax({
                    url:'/step/deleteStepPage',
                    data:'id='+ids,
                    success:function(data){
                        if(data.state=200){
                            $.messager.alert('信息提示',data.message,'info');
                            $('#wu-datagrid-step').datagrid('reload');
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
        $('#wu-form-step').form('clear');
        $('#wu-dialog-step').dialog({
            closed: false,
            modal:true,
            title: "添加页面步骤信息",
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog-step').dialog('close');
                }
            }]
        });
        $('#wu-dialog-step').dialog('center');
    }

    /**
     * Name 打开修改窗口
     */
    function openEdit(){
        //$('#wu-dialog').dialog('open');
        //$('#wu-form').form('clear');
        var item = $('#wu-datagrid-step').datagrid('getSelected');
        if(item==null){
            $.messager.alert('提示信息','至少选择一条页面记录','warning');
        }else{
            var id = item.id;
            $.ajax({
                url:'/step/getOneLocatorPage',
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
                        $('#wu-form-step').form('load', data)
                    }
                }
            });
            $('#wu-dialog-step').dialog({
                closed: false,
                modal:true,
                title: "修改页面步骤信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: edit
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-step').dialog('close');
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
    $('#wu-datagrid-step').datagrid({
        url:'/step/getAllLocatorPage',
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
            { field:'sId',title:'步骤编号', sortable:true,order:'desc',width:15},
            { field:'pName',title:'页面名称',width:50},
            { field:'cName',title:'用例名称',width:50},
            { field:'sName',title:'步骤名称',width:50},
            { field:'sData',title:'使用数据',width:50},
            { field:'sNum',title:'排序号',width:50},
            { field:'sCreateTime',title:'创建时间',width:50}
        ]]
    });



</script>
</body>
</html>