<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="public/public.jsp"></c:import>
<div class="container">
    <div class="row myCenter">
        <div class="seckill">
            <table class="table table-striped table-bordered">
                <th>秒杀物品</th>
                <th>秒杀数量</th>
                <th>秒杀开始时间</th>
                <th>秒杀结束时间</th>
                    <c:if test="${list!= null || fn:length(list) != 0}">
                        <c:forEach var="Seckill" items="${list}" varStatus="status">
                            <tr>
                                <td class="success">${Seckill.name}</td>
                                <td class="success">${Seckill.number}</td>
                                <td class="success">${Seckill.startTime}</td>
                                <td class="success">${Seckill.endTime}</td>
                                <td class="success"><a href=<%=request.getAttribute("basePath")%>getupdate>修改</a></td>
                            </tr>

                        </c:forEach>
                    </c:if>
            </table>
        </div>

    </div>
</div>