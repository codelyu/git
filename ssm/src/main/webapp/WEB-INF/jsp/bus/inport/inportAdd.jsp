<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改商品</title>
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
				<label class="layui-form-label">选择供应商</label>
				<div class="layui-input-inline">
					<select name="providerid" lay-filter="providerid">
						<option value="0">--请选择供应商--</option>
						<c:forEach var="sn" items="${providers }">
							<option value="${sn.id }">${sn.providername }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">商品名称</label>
				<div class="layui-input-inline">
					<select name="goodsid"  id="goodsid" lay-filter="goodsid">
						
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">进货数量</label>
				<div class="layui-input-inline">
					<input type="text" name="number" lay-verify="required|number" placeholder="数量"
						autocomplete="off" class="layui-input">
						<input type="hidden" name="operateperson" value="${user.name }">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">进货价格</label>
				<div class="layui-input-inline">
					<input type="tel" name="inportprice" placeholder="进货价格" lay-verify="required|number" autocomplete="off"
						class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">支持类型</label>
				<div class="layui-input-block">
					<input type="radio" name="paytype" value="微信" title="微信"> <input
						type="radio" name="paytype" value="支付宝" title="支付宝" checked="">
					<input type="radio" name="paytype" value="银联" title="银联">
				</div>
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">进货备注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入进货备注" name="remark"
					class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item" style="text-align: center;">
			<button class="layui-btn" lay-submit="" lay-filter="addInport">提交</button>
			<button type="reset" class="layui-btn layui-btn-warm">重置</button>
		</div>
	</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    layui.use(['form','jquery','layer','upload'],function(){
        var form=layui.form;
        window.aaa=form;
        var laydate=layui.laydate;
        var $=layui.jquery;
        //如果父页面有layer就使用父页的  没有就自己导入
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        //渲染时间选择器
        var upload = layui.upload;
        
        
        //监听提交
        form.on('submit(addInport)', function(data){
            var data=$("#frm").serialize();
            //使用ajax提交
            $.ajax({
                url:'${pageContext.request.contextPath }/inport/addInport.action',
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
                    //刷新父页面的table
                    window.parent.tableIns.reload();
                },
                error:function(xhr,textStatus){
                }
            })
            return false;
        });
        
        
      //供应商的改变事件
		form.on("select(providerid)",function(obj){
			var providerid=obj.value;
			var url="${pageContext.request.contextPath }/goods/loadGoodsByProviderId.action"
			$.post(url,{providerid:providerid},function(json){
				var html="";
				for (var i = 0; i < json.length; i++) {
					var goodsObj = json[i];
					html+="<option value="+goodsObj.id+">"+(goodsObj.goodsname+"["+goodsObj.size+"]")+"</option>"
				}
				$("#goodsid").html(html);
				form.render("select");
			})
		})
        
    });

   
    
</script>
</html>