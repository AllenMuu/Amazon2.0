<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.news-list ul li {
	
}
</style>
<div class="newsList">
	<h2>新闻动态</h2>
		<c:forEach items="${newslist}" var="list">
			<ul>
				<li><a href="${pageContext.request.contextPath }/readnews?newsId=${list.newsId}">${list.newsTitle}</a></li>
			</ul>
		</c:forEach>
</div>
