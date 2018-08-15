<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category">
	<h2>商品分类</h2>
		<dl>
		<c:forEach items="${producttype}" var="p">
			<dt>
				<c:if test="${p.parentTypeId == p.categoryId}">
					<a href="">${p.categoryName} </a>
				</c:if>
			</dt>
				<c:forEach items="${producttype}" var="p1">
					<dd>
						<c:if test="${p1.parentTypeId == p.categoryId&&p1.categoryId != p1.parentTypeId}">
							<a href="">${p1.categoryName}</a>
						</c:if>
					</dd>
				</c:forEach>
			</c:forEach>	
		</dl>
</div>

