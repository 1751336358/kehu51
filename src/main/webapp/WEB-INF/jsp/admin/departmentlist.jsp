<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html class=" js csstransforms3d"><head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/departmentlist/base.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/departmentlist/page.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/departmentlist/my.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/departmentlist/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/departmentlist/main.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/departmentlist/modernizr.js"></script>
</head>
<script type="text/javascript">
	var did = "";
	function changeDepartmentInfo(id,info,name){
		$(".box").css("display","block");
		did = id;
		$("#name").val(name);
		$("#info").val(info);
	}
	$(function(){
		$(".box .btn .ok").click(function(){
			/* console.log(did);
			console.log($("#name").val());
			console.log($("#info").val()); */
			var name = $("#name").val();
			var info = $("#info").val();
			var url = "${pageContext.request.contextPath}/changeDepartmentInfo"
			$.post(url,"did="+did+"&name="+name+"&info="+info,function(data){
				if(data == 1){
					$(".box").css("display","none");
					alert("部门信息修改成功");
					location.reload();
				}else if(data == 0){
					alert("该部门名已存在，请更换其他的部门名");
				}else if(data == 403){
					alert("权限不足，修改失败");
				}
			});
			
		});
		$(".box .btn .close").click(function(){
			$(".box").css("display","none");
		});
	})
	
</script>
<body style="background: #f6f5fa;">
	<div class="super-content">
		<div class="superCtab">
			<div class="ctab-title clearfix"><h3>部门管理</h3></div>			
			<div class="ctab-Main">
				<div class="ctab-Mian-cont">					
					<div class="Mian-cont-wrap">
						<div class="defaultTab-T">
							<table border="0" cellspacing="0" cellpadding="0" class="defaultTable">
								<tbody><tr><th class="t_1">部门ID</th><th class="t_2_1">部门描述</th><th class="t_3">部门名称</th><th class="t_4">操作</th></tr>
							</tbody></table>
						</div>
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
								<c:forEach items="${requestScope.departments}" var="department">
								<tr>
									<td class="t_1">${department.id}</td>
									<td class="t_2_1">${department.info }</td>
									<td class="t_3">${department.name }</td>
									<td class="t_4">
										<div class="btn">
										<a href="${pageContext.request.contextPath}/delDepartmentById?id=${department.id}" class="delete">删除</a>
										<a href="javascript:void(0)" class="update" onclick=changeDepartmentInfo(${department.id},'${department.info }','${department.name }')>修改</a>
										</div>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="box" style="display:none;">
		<div class="input">
			<span>&nbsp&nbsp部门名：</span><input id="name" name="name" />
		</div>
		<br/><br/>
		<div class="input">
			<span>部门描述：</span><input id="info" name="info" />
		</div>
		<br/><br/>
		<div class="btn">
			<button class="ok">确认</button>
			<button class="close">关闭</button>
		</div>
	</div>
</body>

</html>