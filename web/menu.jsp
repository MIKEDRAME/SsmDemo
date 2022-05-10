
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--管理员的菜单--%>
<c:if test="${nowAdmin!=null}">
<!-- begin::side menu -->
<div class="side-menu">
    <div class='side-menu-body'>
        <ul>
            <li class="side-menu-divider">Navigation</li>

            <li class="open">
                <a href="#"><i class="icon ti-face-smile"></i> <span>用户</span> </a>
                <ul>
                    <li><a href="query">用户列表</a></li>
                    <li><a href="insertUser.jsp">添加用户</a></li>
                </ul>
            </li>
            <li class="open">
                <a href="#"><i class="icon ti-crown"></i> <span>银行</span> </a>
                <ul>

                    <li><a href="queryBank">银行列表</a></li>
                    <li><a href="insertBank.jsp">添加银行</a></li>
                </ul>
            </li>
            <li class="open">
                <a href="#"><i class="icon ti-map"></i> <span>银行卡</span> </a>
                <ul>

                    <li><a href="queryBankcard">银行卡列表</a></li>
                    <li><a href="toInsertBankcard">添加银行卡</a></li>
                </ul>
            </li>
            <li class="open">
                <a href="#"><i class="icon ti-rocket"></i> <span>基金理财产品</span> </a>
                <ul>

                    <li><a href="queryFundProduct">基金理财产品</a></li>
                    <li><a href="insertFundProduct.jsp">添加基金理财产品</a></li>
                </ul>
            </li>
            <li class="open">
                <a href="#"><i class="icon ti-pie-chart"></i> <span>用户投资基金</span> </a>
                <ul>

                    <li><a href="queryUserFundProduct">用户投资基金列表</a></li>
                    <li><a href="UserFundProductInsert.jsp">添加投资基金</a></li>
                </ul>
            </li>

        </ul>
    </div>
</div>
<!-- end::side menu -->
</c:if>

<c:if test="${nowUser!=null}">
<%--用户前台的菜单--%>
    <div class="side-menu">
        <div class='side-menu-body'>
            <ul>
                <li class="side-menu-divider">Navigation</li>
                    <%--     个人中心       --%>

                <li class="open">
                    <a href="#"><i class="icon ti-face-smile"></i> <span>用户</span> </a>
                    <ul>
                        <li><a href="userQueryBank">银行列表</a></li>
                            <%--        个人银行卡信息            --%>
                        <li><a href="userQueryBankcard">我的银行卡</a></li>

                    </ul>
                </li>
                <li class="open">
                    <a href="#"><i class="icon ti-rocket"></i> <span>基金理财产品</span> </a>
                    <ul>

                        <li><a href="userQueryFundProduct">基金理财产品列表</a></li>
                    </ul>
                </li>
                <li class="open">
                    <a href="#"><i class="icon ti-pie-chart"></i> <span>用户投资基金</span> </a>
                    <ul>

                        <li><a href="queryUserFundProduct">投资基金</a></li>

                    </ul>
                </li>

            </ul>
        </div>
    </div>
</c:if>
