<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link href="${pageContext.request.contextPath}/css/changeemploy/zzsc.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/changeemploy/changeemploy.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/changeemploy/jquery-1.8.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/changeemploy/showList.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/changeemploy/changeemploy.js" type="text/javascript"></script>
</head>
<body>
<div>
	<div class="box"></div>	
  <div class="main content">
    <div class="left-sider">
      <div class="operate">
        <h3> 选择员工 </h3>
        <ul id="J_navlist">
	        <c:forEach items="${departments}" var="department">
	        	<li>
	        		<h4 >${department.name}</h4>
	        		<div class="list-item none">
		    		<c:forEach items="${department.employs }" var="employ">
		    			<p ><a onclick=showEmployInfo(${employ.id}) target="_self">${employ.username}</a></p>
		    		</c:forEach>
		    		</div>
	        	</li>	        	
	    	</c:forEach>
        </ul>
        <script type="text/javascript" language="javascript">
			navList(12);
		</script>
      </div>
    </div>
  </div>
</div>
<div style="text-align:center;clear:both">
</div>
</body>
</html>
