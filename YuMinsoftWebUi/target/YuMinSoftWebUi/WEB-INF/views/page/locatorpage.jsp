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
        <div class="wu-toolbar-search-locator" style="margin-left: 13px;">
            <div class="page-locator" style="padding: 4px 0 13px 0;">
                <label>控件编号：</label><input class="wu-text" id="l_Id" style="width:100px">
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>控件名称：</label><input id="l_name" class="wu-text" style="width:100px" >
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>页面名称：</label><input id="p_name" class="wu-text" style="width:100px" >
                <label>&nbsp;&nbsp;&nbsp;</label>
                <label>定位方式：</label>
                <select id="l_tpye" class="easyui-combobox" name="l_type" style="width:200px;">
                    <option value="aa">未选择</option>
                    <option>id</option>
                    <option>name</option>
                    <option>className</option>
                    <option>cssSelector</option>
                    <option>tagName</option>
                    <option>linkText</option>
                    <option>xpath</option>
                    <option>partialLinkText</option>
                </select>


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
        <table id="wu-datagrid-locator" toolbar="#" border="0"></table>
    </div>
</div>
<!-- Begin of easyui-dialog -->
<div id="wu-dialog-locator" class="easyui-dialog" data-options="closed:true,iconCls:'icon-book-add'" style="width:450px; height:750px;padding:40px;text-align:center;">
    <form id="wu-form-locator" method="post" style="text-align: left;font-size: 16px; padding-left: 42px;">
        <div style="text-align: center"> <span id="locatormessage" style="color: red;display:none;"></span></div>
        <div style="margin-top: 30px;" class="one">
            <span>页面名称<span style="color: red;">*</span>：</span>
            <input class="wu-text" type="text" id="pName" name="pName" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
            <span>页面对象url：</span>
        <div>
            <input class="wu-text" type="text" id="pUrl" name="pUrl" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <input type="hidden" id="lId" value="">
        <div style="height: 15px"></div>
        <span>控件名称<span style="color: red;">*</span>：</span>
        <div>
            <input class="wu-text" type="text" id="lName" name="lName" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <span>定位方式<span style="color: red;">*</span>：</span>
        <div>
            <select id="lType" name="lType"  class="easyui-combobox" style="height: 30px;width: 240px">
                <option value="aa">未选择</option>
                <option>id</option>
                <option>name</option>
                <option>className</option>
                <option>cssSelector</option>
                <option>tagName</option>
                <option>linkText</option>
                <option>xpath</option>
                <option>partialLinkText</option>
            </select>
        </div>
        <div style="height: 15px"></div>
        <span>定位值<span style="color: red;">*</span>：</span>
        <div>
            <input class="wu-text" type="text" id="lValue" name="lValue" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <span>等待时间<span style="color: red;">*</span>：</span>
        <div>
            <input class="wu-text" type="text" id="lWaitTime" name="lWaitTime" data-options="required:true" style="height: 20px;width: 240px">
        </div>
        <div style="height: 15px"></div>
        <div>
            <span>操作方式<span style="color: red;">*</span>：</span>
            <select id="lFunction" name="lFunction"  class="easyui-combobox" style="height: 30px;width: 240px;">
                <option value="aa">请选择一种方式</option>
                <option>text</option>
                <option>type</option>
                <option>submit</option>
                <option>click</option>
                <option>link</option>
                <option>open</option>
            </select>
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
        $('#wu-form-locator').form('submit', {
            url:'/locator/addObjectPage',
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
                    $('#wu-dialog-locator').dialog('close');
                    $('#wu-datagrid-locator').datagrid('reload');
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
        $('#wu-form-locator').form('submit',{
            url:'/locator/updateLocatorPage',
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
                    $('#wu-dialog-locator').dialog('close');
                    $('#wu-datagrid-locator').datagrid('reload');
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
                var items = $('#wu-datagrid-locator').datagrid('getSelections');
                var ids = [];
                $(items).each(function(){
                    ids.push(this.id);
                });

                $.ajax({
                    url:'/locator/deleteObjectPage',
                    data:'id='+ids,
                    success:function(data){
                        if(data.state=200){
                            $.messager.alert('信息提示',data.message,'info');
                            $('#wu-datagrid-locator').datagrid('reload');
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
        $('#wu-form-locator').form('clear');
        $('#wu-dialog-locator').dialog({
            closed: false,
            modal:true,
            title: "添加页面控件信息",
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog-locator').dialog('close');
                }
            }]
        });
        $('#wu-dialog-locator').dialog('center');
    }

    /**
     * Name 打开修改窗口
     */
    function openEdit(){
        //$('#wu-dialog').dialog('open');
        //$('#wu-form').form('clear');
        var item = $('#wu-datagrid-locator').datagrid('getSelected');
        if(item==null){
            $.messager.alert('提示信息','至少选择一条页面记录','warning');
        }else{
            var id = item.id;
            $.ajax({
                url:'/locator/getOneLocatorPage',
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
                        $('#wu-form-locator').form('load', data)
                    }
                }
            });
            $('#wu-dialog-locator').dialog({
                closed: false,
                modal:true,
                title: "修改页面控件信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: edit
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-locator').dialog('close');
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
    $('#wu-datagrid-locator').datagrid({
        url:'/locator/getAllLocatorPage',
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
            { field:'lId',title:'控件编号', sortable:true,order:'desc',width:15},
            { field:'pName',title:'页面名称',width:50},
            { field:'lName',title:'控件名称',width:50},
            { field:'lType',title:'定位方式',width:50},
            { field:'lValue',title:'定位值',width:50},
            { field:'lFunction',title:'操作方式',width:50},
            { field:'lCreateTime',title:'创建时间',width:50}
        ]]
    });
</script>
</body>
</html>