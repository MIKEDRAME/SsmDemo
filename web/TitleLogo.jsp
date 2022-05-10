<%--
  Created by IntelliJ IDEA.
  User: 上官-梓梓梓梓芸
  Date: 2022/4/22
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--    adminTitleLogo  begin    --%>
<c:if test="${nowAdmin!=null}">
<div class="header-logo">
  <a href="#">
    <img src="assets/media/image/light-logo.png" alt="...">
    <span class="logo-text d-none d-lg-block">管理员</span>
  </a>
</div>
</c:if>
<%--    adminTitleLogo  end    --%>

<%--    userTitleLogo  begin    --%>
<c:if test="${nowUser!=null}">
<div class="header-logo">
  <a href="#">
    <img src="assets/media/image/light-logo.png" alt="...">
    <span class="logo-text d-none d-lg-block">用户</span>
  </a>
</div>
</c:if>
<%--    userTitleLogo  end    --%>