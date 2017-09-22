var Page={
    openAdd:function(data){
        $('#'+data.className).dialog({
            closed: false,
            modal:true,
            title: data.title,
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#'+data.className).dialog('close');
                }
            }]
        });
        $('#'+data.className).dialog('center');
    },
    /**
     * data:{url:'',title:''}
     * param:{id:'123',name:'liutao'}
     * @param data
     * @param param
     */
    openEdit:function(data,param){
        var item = $('#'+data.className).datagrid('getSelected');
        if(item==null){
            $.messager.alert('提示信息','至少选择一条页面记录','warning');
        }else{
            var id = item.id;
            $.ajax({
                url:data.url,
                data:'id='+id,
                contentType : "application/x-www-form-urlencoded; charset=utf-8",
                success:function(data){
                    if(data){
                       for(var key in data){
                           $('#'+key).html(data[key]);
                       }
                    }
                    else{
                        //绑定值
                        $('#'+data.formname).form('load', data)
                    }
                }
            });
            $('#'+data.className).dialog({
                closed: false,
                modal:true,
                title: data.title,
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: edit
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#'+data.className).dialog('close');
                    }
                }]
            });
        }

    },
    /**
     *分页过滤器 data响应结果数据
     * @param data
     * @returns {*}
     */
    pagerFilter:function(data){
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
    },
    remove:function(){
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

};

var div = document.getElementById('id');