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
        <div class="wu-toolbar-search-object" style="margin-left: 13px;">
            <div class="page-object" style="padding: 4px 0 13px 0;">
                <label>页面编号：</label><input class="wu-text" id="p_Id" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>页面对象名称：</label><input id="p_oject_name" class="wu-text" style="width:100px" >
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
        <table id="wu-datagrid-object" toolbar="#" border="0"></table>
    </div>
</div>
<!-- Begin of easyui-dialog -->
<div id="wu-dialog-object" class="easyui-dialog" data-options="closed:true,iconCls:'icon-book-add'" style="width:450px; height:400px;padding:40px;text-align:center;background-color: #6a6a6a;">
    <form id="wu-form-object" method="post" style="text-align: left;font-size: 16px;color: #00bbee; padding-left: 42px;">
        <input type="hidden" id="pId" value="">
        <div style="text-align: center"> <span id="objectmessage" style="color: red;display:none;"></span></div>
        <div style="margin-top: 30px;" class="one">
            <span>页面对象名称<span style="color: red;">*</span>：</span>
            <input class="easyui-textbox" type="text" id ="pName" name="pName" data-options="required:true" onfocus="onmblur()" style="height: 20px;width: 240px">
        </div>
        <%--<div style="height: 20px"></div>
        <div>
            <span>页面对象包名：</span>
            <input class="easyui-textbox" type="text" id="pObjectName" name="pObjectName" data-options="required:true" onfocus="onmblur()" style="height: 20px;width: 240px">
        </div>--%>
        <div style="height: 15px"></div>
        <div>
            <span>页面对象url：</span>
            <input class="easyui-textbox" type="text" id="pValue" name="pValue" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <div>
            <span>页面对象描述：</span>
            <input class="easyui-textbox" type="text" id="pDesc" name="pDesc" data-options="required:true" style="height: 20px;width: 240px">
        </div>
    </form>
</div>
<!-- End of easyui-dialog -->
<script type="text/javascript">
    /**
     * Name 添加记录
     */
    function add(){
        $('#wu-form-object').form('submit', {
            url:'/object/addObjectPage',
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
                    $('#wu-dialog-object').dialog('close');
                    $('#wu-datagrid-object').datagrid('reload');
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
        $('#wu-form-object').form('submit',{
            url:'/object/updateObjctPage',
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
                    $('#wu-dialog-object').dialog('close');
                    $('#wu-datagrid-object').datagrid('reload');
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
                var items = $('#wu-datagrid-object').datagrid('getSelections');
                var ids = [];
                $(items).each(function(){
                    ids.push(this.id);
                });

                $.ajax({
                    url:'/object/deleteObjectPage',
                    data:'id='+ids,
                    success:function(data){
                        if(data.state=200){
                            $.messager.alert('信息提示',data.message,'info');
                            $('#wu-datagrid-object').datagrid('reload');
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
        $('#wu-form-object').form('clear');
        $('#wu-dialog-object').dialog({
            closed: false,
            modal:true,
            title: "添加页面对象信息",
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog-object').dialog('close');
                }
            }]
        });
        $('#wu-dialog-object').dialog('center');
    }

    /**
     * Name 打开修改窗口
     */
    function openEdit(){
        //$('#wu-dialog').dialog('open');
        //$('#wu-form').form('clear');
        var item = $('#wu-datagrid-object').datagrid('getSelected');
        if(item==null){
            $.messager.alert('提示信息','至少选择一条页面记录','warning');
        }else{
            var id = item.id;
            $.ajax({
                url:'/object/getOnePageObject',
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
                        $('#wu-form-object').form('load', data)
                    }
                }
            });
            $('#wu-dialog-object').dialog({
                closed: false,
                modal:true,
                title: "修改页面对象信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: edit
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-object').dialog('close');
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
    $('#wu-datagrid-object').datagrid({
        url:'/object/getAllPageObjects',
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
            { field:'pId',title:'页面对象编号', sortable:true,order:'desc',width:10},
            { field:'pName',title:'页面对象名称',width:50},
            { field:'pValue',title:'页面路径',width:50},
            { field:'pDesc',title:'页面对象中文名称',width:50},
            { field:'pCreateTime',title:'创建时间',width:50}
        ]]
    });
</script>
</body>
</html>