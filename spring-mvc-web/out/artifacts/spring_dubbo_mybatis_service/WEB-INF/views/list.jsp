<%@page pageEncoding="UTF-8" %>
<%@include file="public/tag.jsp"%>
<%@include file="public/head.jsp"%>
<div class="container">
    <div class="row">
        <div class="seckill">
            <table class="table table-striped table-bordered">
                <caption>秒杀物品清单</caption>
                <thead>
                <tr>
                    <th>秒杀物品</th>
                    <th>秒杀数量</th>
                    <th>秒杀开始时间</th>
                    <th>秒杀结束时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                    <c:if test="${list!= null || fn:length(list) != 0}">
                        <c:forEach var="Seckill" items="${list}" varStatus="status">
                            <c:choose>
                                <c:when test="${status.index % 2 == 0}">
                                    <tr class="info">
                                        <td>${Seckill.name}</td>
                                        <td>${Seckill.number}</td>
                                        <td>
                                            <fmt:formatDate value="${Seckill.startTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${Seckill.endTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                        <td><a href="/update?seckillId="${Seckill.seckillId}>修改</a>&nbsp;&nbsp;<a
                                                href=<%=request.getAttribute("basePath")%>insert>新增</a></td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <tr class="active">
                                        <td>${Seckill.name}</td>
                                        <td>${Seckill.number}</td>
                                        <td><fmt:formatDate value="${Seckill.startTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                        <td><fmt:formatDate value="${Seckill.endTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                        <td><a href=<%=request.getAttribute("basePath")%>update?seckillId=${Seckill.seckillId}>修改</a>&nbsp;&nbsp;<a
                                                href=<%=request.getAttribute("basePath")%>insert>新增</a></td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </c:if>
            </table>
            <div class="getpage">
                <ul class="pagination">
                    <li><a href="#">上一页</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">下一页</a></li>
                </ul>
            </div>

        </div>

    </div>
</div>