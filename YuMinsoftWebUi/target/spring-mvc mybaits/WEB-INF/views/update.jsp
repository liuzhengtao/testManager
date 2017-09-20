<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="public/head.jsp"></c:import>
<div class="container">
    <div class="row">
       <div></div>
        <div></div>
    </div>
    <div class="row">
        <div class="col-sm-2">

        </div>
        <div class="col-sm-8">
            <form action=<%=request.getAttribute("basePath")%>updateInfo class="form-horizontal" role="form" method="post">
                <input type="hidden" name="seckillId" value="${seckill.seckillId}">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">秒杀物品名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="name" value="${seckill.name}" id="name" placeholder="请输入秒杀名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="number" class="col-sm-2 control-label">秒杀物品数量</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="number" value="${seckill.number}" id="number" placeholder="请输入秒杀物品的数量">
                    </div>
                </div>
                <div class="form-group">
                    <label for="datetimepicker"  class="col-sm-2 control-label">秒杀开启时间</label>
                    <div class="input-append form_datetime date col-sm-10" id="datetimepicker">
                        <input  type="text" name="startTime" value="${seckill.startTime}" class="form-control" placeholder="请输入秒杀开启时间">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                    <%--<div class="col_sm_2">
                        <img src="/resources/img/calendar.png" width="25px" height="25px">
                    </div>--%>
                    <script src="/resources/js/common/bootstrap/bootstrap-datetimepicker.js"></script>
                    <script src="/resources/js/common/locales/bootstrap-datetimepicker.zh-CN.js"></script>
                    <script src="/resources/js/common/locales/bootstrap-datetimepicker.fr.js"></script>
                    <script>
                        $(".form_datetime").datetimepicker({
                            format: "yyyy-mm-dd hh:i",
                            autoclose: true,
                            todayBtn: true,
                            language:'zh-CN',
                            pickerPosition: "bottom-left"
                        });
                    </script>
                </div>
                <div class="form-group">
                    <label for="datetimepicker"  class="col-sm-2 control-label">秒杀开启时间</label>
                    <div class="input-append form_datetime date col-sm-10" id="datetimepicker">
                        <input  type="text" name="endTime" value="${seckill.endTime}" class="form-control" placeholder="请输入秒杀结束时间">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                    <%--<div class="col_sm_2">
                        <img src="/resources/img/calendar.png" width="25px" height="25px">
                    </div>--%>
                    <script src="/resources/js/common/bootstrap/bootstrap-datetimepicker.js"></script>
                    <script src="/resources/js/common/locales/bootstrap-datetimepicker.zh-CN.js"></script>
                    <script src="/resources/js/common/locales/bootstrap-datetimepicker.fr.js"></script>
                    <script>
                        $(".form_datetime").datetimepicker({
                            format: "yyyy-mm-dd hh:i",
                            autoclose: true,
                            todayBtn: true,
                            language:'zh-CN',
                            pickerPosition: "bottom-left"
                        });
                    </script>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                    </div >
                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-default form-control">提交</button>
                    </div >
                    <div class="col-sm-2">
                        <button type="reset" class="btn btn-default form-control">清空</button>
                    </div>
                    <div class="col-sm-4">
                    </div >
                </div>
            </form>
        </div>
        <div class="col-sm-2">

        </div>

    </div>
</div>
