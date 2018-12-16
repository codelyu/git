<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html> 
<head>
    <meta charset="utf-8">
    <title>供应商管理</title>
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
<fieldset class="layui-elem-field layui-field-title">
    <legend>查询条件</legend>
</fieldset>
<form class="layui-form" id="searchForm" method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label" >供应商名称:</label>
            <div class="layui-input-inline">
                <input type="text" name="providername"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"  >供应商电话:</label>
            <div class="layui-input-inline">
                <input type="text" name="telephone"  autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label" >联系人:</label>
            <div class="layui-input-inline">
                <input type="text" name="connectionperson"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"  >联系人电话:</label>
            <div class="layui-input-inline">
                <input type="text" name="phone"  autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item" style="text-align: center;">
        <a class="layui-btn search_btn" >查询</a>
       
        <button type="reset" class="layui-btn layui-btn-warm">清空</button>
        
        	<a class="layui-btn layui-btn-normal addprovider_btn">添加</a>
        
       
       		 <a class="layui-btn layui-btn-danger layui-btn-normal delAll_btn">批量删除</a>
      
        </div>
</form>
<table id="providerList" lay-filter="providerList"></table>
<!--操作-->
<script type="text/html" id="providerListBar">
 
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
 

 <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>


 
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    var tableIns;
    function reloadTable(id){
    	tableIns.reload({
    		where:{deptid:id}
    	})
    }
     layui.use(['form','layer','table','jquery'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;
	
        //供应商列表
        tableIns = table.render({
            elem: '#providerList',
            url : '${pageContext.request.contextPath }/provider/queryAllProviders.action',
            cellMinWidth : 95,
            page : true,
            height : "full-200",
            limits : [10,15,20,25],
            limit : 10,
            id : "providerListTable",
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'id', title: '供应商ID', minWidth:100, align:"center"},
                {field: 'providername', title: '供应商名称', minWidth:100, align:"center"},
                {field: 'address', title: '供应商地址', minWidth:100, align:"center"},
                {field: 'telephone', title: '电话',minWidth:100,  align:'center' },
                {field: 'connectionperson', title: '联系人',minWidth:100,  align:'center' },
                {field: 'phone', title: '联系人电话', minWidth:100, align:"center"},
                {field: 'bank', title: '银行', minWidth:100, align:"center"},
                {field: 'account', title: '银行账号',  minWidth:100, align:"center"},
                {field: 'zip', title: '邮编', minWidth:100, align:"center"},
                {field: 'email', title: '邮箱',  minWidth:100, align:"center"},
                {field: 'fax', title: '传真',  minWidth:100, align:"center"},
                {field: 'available', title: '是否可用',  align:'center',templet:function(d){
                    return d.available ==1 ? "<font color=blue>可用</font>" : "<font color=red>不可用</font>";
                }},
                {title: '操作', minWidth:150, templet:'#providerListBar',fixed:"right",align:"center"}
            ]]
        });

        //查询
        $(".search_btn").on("click",function(){
            var params=$("#searchForm").serialize();
            table.reload('providerListTable', {
                url: '${pageContext.request.contextPath }/provider/queryAllProviders.action?'+params
            });
        });

        //添加供应商
        $(".addprovider_btn").click(function(){
            var index = layui.layer.open({
                title : "添加供应商",
                type : 2,//ifream层
                area:["800px","500px"],
                content : "${pageContext.request.contextPath }/provider/toProviderAdd.action",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回供应商列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(index);
            })
        })
        //修改供应商
        function updateProvider(data){
            var index = layui.layer.open({
                title : "修改供应商",
                type : 2,
                area:["800px","500px"],
                content : "${pageContext.request.contextPath }/provider/toUpdateProvider.action?id="+data.id,
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回供应商列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(index);
            })
        }


        //列表操作
        table.on('tool(providerList)', function(obj){
            var layEvent = obj.event,
                data = obj.data;
            if(layEvent === 'edit'){ //编辑
            	updateProvider(data);//data主当前点击的行
            }else if(layEvent === 'del'){ //删除
                layer.confirm('确定删【'+data.providername+'】供应商吗？',{icon:3, title:'提示信息'},function(index){
                    $.post("${pageContext.request.contextPath }/provider/deleteProvider.action",{
                        id : data.id  //将需要删除的id作为参数传入
                    },function(data){
                        //刷新table
                        tableIns.reload();
                        //关闭提示框
                        layer.close(index);
                    })
                });
            }
        });
		
        
        //批量删除
        $(".delAll_btn").click(function(){
            //得到当前表格里面的checkbox的选中对象集合
            var checkStatus = table.checkStatus('providerListTable'),//选中状态
                data = checkStatus.data;//选中的对象集
            var ids="a=1";
            if(data.length > 0) {
                for (var i in data) {
                    ids+="&ids="+data[i].id;
                }
                layer.confirm('确定删除选中的供应商？', {icon: 3, title: '提示信息'}, function (index) {
                    $.post("${pageContext.request.contextPath }/provider/batchDeleteProvider.action?"+ids,function(data){
                        //刷新table
                        tableIns.reload();
                        //关闭提示框
                        layer.close(index);
                    })
                })
            }else{
                layer.msg("请选择需要删除的供应商");
            }
        })
	})
</script>
</html>