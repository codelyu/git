<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>分配权限</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/public.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.excheck.js"></script>
</head>
<body>
	<div id="treeDemo" class="ztree"></div>
	<div style="text-align: center;">
		<a class="layui-btn layui-btn-normal addRolePermission_btn">确认分配</a>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
<script type="text/javascript">
    var setting = {
   		check: {
			enable: true
		}
    };
     function initRolePermissionTree(){
    	var url="${pageContext.request.contextPath }/role/initRolePermissionTree.action?id=${roleVo.id}"
        $.post(url,function(json){
    	   $.fn.zTree.init($("#treeDemo"), setting, json);
       })
    };
    initRolePermissionTree();
    
    
    layui.use(['layer'],function(){
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        	$(".addRolePermission_btn").click(function(){
        	//得到选中的树的节点id
        	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        	var nodes = treeObj.getCheckedNodes(true);
        	var params="id=${roleVo.id}"
        	for(var i=0;i<nodes.length;i++){
        		params+="&ids="+nodes[i].id;
        	}
        	var url="${pageContext.request.contextPath }/role/addRolePermission.action?"+params;
        	$.post(url,function(json){
        		layer.msg(json.msg);
        		//得到当前弹出层的index
        		var index=layer.getFrameIndex(window.name); 
        		//关闭
        		layer.close(index);
        	})
        	//alert(params);
        });
    });
    
    
    
    
</script>
</html>