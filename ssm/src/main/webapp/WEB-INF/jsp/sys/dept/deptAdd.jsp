<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			<label class="layui-form-label">父级部门</label>
			<div class="layui-input-inline">
				<div id="deptTree" class="select-tree layui-form-select">
            	</div>
				<input type="hidden" id="pid" name="pid"  >
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">排序码</label>
			<div class="layui-input-inline">
				<input type="text" name="ordernum" lay-verify="required"  placeholder="排序码" autocomplete="off" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">部门名称</label>
		<div class="layui-input-block">
			<input type="text" name="name" lay-verify="required" autocomplete="off"
				   placeholder="请输入公司地址" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">部门地址</label>
		<div class="layui-input-block">
			<input type="text" name="loc" lay-verify="required" autocomplete="off"
				   placeholder="请输入公司地址" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">部门备注</label>
		<div class="layui-input-block">
			<textarea placeholder="请输入部门备注" name="remark" class="layui-textarea"></textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">是否展开</label>
			<div class="layui-input-inline">
				<input type="radio" name="spread" value="1" title="是" checked="">
				<input type="radio" name="spread" value="0" title="否">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">是否父节点</label>
			<div class="layui-input-inline">
				<input type="radio" name="parent" value="1" title="是" checked="">
				<input type="radio" name="parent" value="0" title="否">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">是否可用</label>
		<div class="layui-input-block">
			<input type="radio" name="available" value="1" title="是" checked="">
			<input type="radio" name="available" value="0" title="否">
		</div>
	</div>
	<div class="layui-form-item" style="text-align: center;">
		<button class="layui-btn" lay-submit="" lay-filter="addDept">提交</button>
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
        form.on('submit(addDept)', function(data){
        	//得到treeObj的对象
        	asyncPid();
            var data=$("#frm").serialize();
            //使用ajax提交
            $.ajax({
                url:'${pageContext.request.contextPath }/dept/addDept.action',
                type:'POST',
                async:true,    //或false,是否异步
                data:data,
                timeout:5000,    //超时时间
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success:function(data){
                	layer.msg(data.msg);
                    //关闭添加的弹出层
                    var addIndex = parent.layer.getFrameIndex(window.name);
                    window.parent.layer.close(addIndex);
                    //刷新左边的树
                    window.parent.parent.left.initLeftDeptTree();
                    //刷新父页面的table
                    window.parent.tableIns.reload();
                },
                error:function(xhr,textStatus){
                }
            })
            return false;
        });
    });

    $(function(){
    	var url="${pageContext.request.contextPath }/dept/loadLeftZtree.action"
        	$.post(url,function(zNodes){
        		initSelectTree("deptTree",zNodes, false);
        		//必须是树初始化完成之后才会加事件
       		   $(".layui-nav-item a").bind("click", function () {
       	            if (!$(this).parent().hasClass("layui-nav-itemed") && !$(this).parent().parent().hasClass("layui-nav-child")) {
       	                $(".layui-nav-tree").find(".layui-nav-itemed").removeClass("layui-nav-itemed")
       	            }
       	        })
        	})
    })
    function asyncPid(){
    	var treeObj = $.fn.zTree.getZTreeObj("deptTreeTree");
    	//得到id的值
    	var node=treeObj.getSelectedNodes();
    	$("#pid").val(node[0].id);
    }
</script>
</html>