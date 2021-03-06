<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>部门管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.core.js"></script>
</head>
<body>
<div id="treeDemo" class="ztree"></div>
</body>
<script type="text/javascript">
    function zTreeOnClick(event, treeId, treeNode) {
    	//window.parent 取到父页  因为父页面是一个fremeset里面有一个叫main的freme
    	//所以 window.parent.main取到deptRight.jsp这个页面对象 
        window.parent.main.reloadTable(treeNode.id)
    };
    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: zTreeOnClick
        }
    };
     function initLeftDeptTree(){
    	var url="${pageContext.request.contextPath }/dept/loadLeftZtree.action"
        $.post(url,function(json){
    	   $.fn.zTree.init($("#treeDemo"), setting, json);
       })
    };
    initLeftDeptTree();
</script>
</html>