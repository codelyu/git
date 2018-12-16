<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加部门</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/public.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/plugin/css/index.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/plugin/js/selectTree.js"></script>
</head>
<body class="childrenBody">
<form class="layui-form" method="post" id="frm">
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">父级菜单</label>
			<div class="layui-input-inline">
				<div id="menuTree" class="select-tree layui-form-select">
            	</div>
            	<input type="hidden" name = "type" value = "menu">
				<input type="hidden" id="pid" name="pid"  >
				<input type="hidden" name="id" value="${permission.id }">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">序码</label>
			<div class="layui-input-inline">
				<input type="text" name="ordernum" value="${permission.ordernum }" lay-verify="required"  placeholder="排序码" autocomplete="off" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">菜单名称</label>
		<div class="layui-input-block">
			<input type="text" name="name" value="${permission.name }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入菜单地址" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">菜单地址</label>
		<div class="layui-input-block">
			<input type="text" name="href" value="${permission.href }" lay-verify="required" autocomplete="off"
				   placeholder="请输入菜单地址" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">是否展开</label>
			<div class="layui-input-inline">
				<input type="radio" name="spread" value="1" title="是" ${permission.spread==1?"checked":"" }>
				<input type="radio" name="spread" value="0" title="否"  ${permission.spread==0?"checked":"" }>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">是否父节点</label>
			<div class="layui-input-inline">
				<input type="radio" name="parent" value="1" title="是" ${permission.parent==1?"checked":"" }>
				<input type="radio" name="parent" value="0" title="否" ${permission.parent==0?"checked":"" }>
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">是否可用</label>
		<div class="layui-input-block">
			<input type="radio" name="available" value="1" title="是" ${permission.available==1?"checked":"" }>
			<input type="radio" name="available" value="0" title="否" ${permission.available==0?"checked":"" }>
		</div>
	</div>
	<div class="layui-form-item" style="text-align: center;">
		<button class="layui-btn" lay-submit="" lay-filter="updateMenu">提交</button>
		<button type="reset" class="layui-btn layui-btn-warm">重置</button>
	</div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    layui.use(['form','jquery','layer'],function(){
        var form=layui.form;
        var $=layui.jquery;
        //如果父页面有layer就使用父页的  没有就自己导入
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        //监听提交
        form.on('submit(updateMenu)', function(data){
        	 asyncPid();
            var data=$("#frm").serialize();
            //使用ajax提交
            $.ajax({
                url:'${pageContext.request.contextPath }/menu/updateMenu.action',
                type:'POST',
                async:true,    //或false,是否异步
                data:data,
                timeout:5000,    //超时时间
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success:function(data){
                    layer.msg("修改成功")
                    var updateIndex = parent.layer.getFrameIndex(window.name);
                    window.parent.layer.close(updateIndex);
                   
                    //刷新父页面的table
                    window.parent.tableIns.reload();
                    //刷新左侧树
                    window.parent.parent.left.initLeftMenuTree();
                },
                error:function(xhr,textStatus){
                    console.log('错误')
                    console.log(xhr)
                    console.log(textStatus)
                }
            })
            return false;
        });
    });
    
    
    $(function(){
    	var url="${pageContext.request.contextPath }/menu/loadLeftZtree.action"
        	$.post(url,function(zNodes){
        		initSelectTree("menuTree",zNodes, false);
        		//必须是树初始化完成之后才会加事件
       		   $(".layui-nav-item a").bind("click", function () {
       	            if (!$(this).parent().hasClass("layui-nav-itemed") && !$(this).parent().parent().hasClass("layui-nav-child")) {
       	                $(".layui-nav-tree").find(".layui-nav-itemed").removeClass("layui-nav-itemed")
       	            }
       	        })
        	})
    });
    
    //获取pid的值
    function asyncPid(){
	    	var treeObj = $.fn.zTree.getZTreeObj("menuTreeTree");
	    	//得到id的值
	    	var node=treeObj.getSelectedNodes();
	    	$("#pid").val(node[0].id);
 	}
    
</script>
</html>