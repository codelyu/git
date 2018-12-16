<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>角色选择</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">
 <a class="layui-btn layui-btn-normal addUserRole_btn" style="margin-bottom: 5px">保存</a>
<table id="roleList" lay-filter="roleList"></table>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    var tableIns;
    layui.use(['form','layer','table'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;
        //角色列表
        tableIns = table.render({
            elem: '#roleList',
            url : '${pageContext.request.contextPath }/user/loadAllUserRoles.action?id=${userVo.id}',
            cellMinWidth : 95,
            height : "full",
            id : "roleListTable",
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'id', title: '角色ID',  align:"center"},
                {field: 'name', title: '角色名称', align:"center"},
                {field: 'remark', title: '角色备注', align:"center"}
            ]]
        });

        //添加角色
        $(".addUserRole_btn").click(function(){
       
        	  //得到当前表格里面的checkbox的选中对象集合
            var checkStatus = table.checkStatus('roleListTable'),//选中状态
                data = checkStatus.data;//选中的对象集
            var ids="id=${userVo.id}";
            for (var i in data) {
                ids+="&ids="+data[i].id;
            }
            layer.confirm('确定要分配这些角色吗？', {icon: 3, title: '提示信息'}, function (index) {
                $.post("${pageContext.request.contextPath }/user/addUserRoles.action?"+ids,function(data){
                   layer.msg(data.msg);
                })
            })
        })
    })
    
</script>
</html>