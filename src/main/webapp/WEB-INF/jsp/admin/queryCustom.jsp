<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
       
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/employList/x-admin.css" media="all">
    </head>
    <body>
    
    	<div>
            <xblock>
                <span class="x-right" style="line-height:25px">共有数据：${customs.size() } 条</span>
            </xblock>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th> ID</th>
                        <th>用户名</th>
                        <th>密码</th>       
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${customs}" var="custom" varStatus="status">
                    <tr>
                        <td>${custom.id}</td>
                        <td><u style="cursor:pointer">${custom.username}</u></td>
                        <td >${custom.password }</td>
                        <td class="td-status">
                        	<c:if test="${custom.open==1}">
                        		<span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>
                        	</c:if>
                            <c:if test="${custom.open==-1}">
                            	<span class="layui-btn layui-btn-disabled layui-btn-mini">已停用</span>
                            </c:if>                    
                        </td>
                        <td class="td-manage">
                        <c:if test="${custom.open==1}">
                        	<a style="text-decoration:none" onclick="member_stop(${custom.id})" href="javascript:;" title="停用">
                                <i class="layui-icon">&#xe601;</i>
                            </a>
                        </c:if>
                        <c:if test="${custom.open==-1}">  
                            <a style="text-decoration:none" onClick="member_start(${custom.id})" href="javascript:;" title="启用">
                                <i class="layui-icon">&#xe62f;</i>
                            </a>                            
						</c:if>
                        </td>
                    </tr>
                  </c:forEach>
                </tbody>
            </table>
        </div>
        <br /><br /><br />
        <script src="${pageContext.request.contextPath}/js/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${pageContext.request.contextPath}/js/employList/x-layui.js" charset="utf-8"></script>
        <script>

            /*用户-停用*/
            function member_stop(id){
                layer.confirm('确认要停用吗？',function(){
                    //发异步把用户状态进行更改
                    var url = "${pageContext.request.contextPath}/openCustom";
                    $.post(url,"id="+id+"&open=-1",function(data){
                    	layer.msg('已停用!',{icon: 5,time:1000});
                    	location.reload();
                    });
                    
                });
            }

            /*用户-启用*/
            function member_start(id){
                layer.confirm('确认要启用吗？',function(){
                    //发异步把用户状态进行更改
                     var url = "${pageContext.request.contextPath}/openCustom";
                    $.post(url,"id="+id+"&open=1",function(data){
                    	 layer.msg('已启用!',{icon: 6,time:1000});
                    	 location.reload();
                    });
                   
                });
            }
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              laydate = layui.laydate;//日期插件
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

              //以上模块根据需要引入

              laypage({
                cont: 'page'
                ,pages: 100
                ,first: 1
                ,last: 100
                ,prev: '<em><</em>'
                ,next: '<em>></em>'
              }); 
              
              var start = {
                min: laydate.now()
                ,max: '2099-06-16 23:59:59'
                ,istoday: false
                ,choose: function(datas){
                  end.min = datas; //开始日选好后，重置结束日的最小日期
                  end.start = datas //将结束日的初始值设定为开始日
                }
              };
              
              var end = {
                min: laydate.now()
                ,max: '2099-06-16 23:59:59'
                ,istoday: false
                ,choose: function(datas){
                  start.max = datas; //结束日选好后，重置开始日的最大日期
                }
              };
              
            });
            </script>
            <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>
</html>