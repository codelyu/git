/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-09 15:09:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.sys.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class roleManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>角色管理</title>\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("    <meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\" media=\"all\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"childrenBody\">\r\n");
      out.write("<fieldset class=\"layui-elem-field layui-field-title\">\r\n");
      out.write("    <legend>查询条件</legend>\r\n");
      out.write("</fieldset>\r\n");
      out.write("<form class=\"layui-form\" id=\"searchForm\" method=\"post\">\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <div class=\"layui-inline\">\r\n");
      out.write("            <label class=\"layui-form-label\" >角色名称:</label>\r\n");
      out.write("            <div class=\"layui-input-inline\">\r\n");
      out.write("                <input type=\"text\" name=\"name\"  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"layui-inline\">\r\n");
      out.write("            <label class=\"layui-form-label\" >角色备注:</label>\r\n");
      out.write("            <div class=\"layui-input-inline\">\r\n");
      out.write("                <input type=\"tel\" name=\"remark\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-form-item\" style=\"text-align: center;\">\r\n");
      out.write("        <a class=\"layui-btn search_btn\" >查询</a>\r\n");
      out.write("        <button type=\"reset\" class=\"layui-btn layui-btn-warm\">清空</button>\r\n");
      out.write("        <a class=\"layui-btn layui-btn-normal addRole_btn\">添加</a>\r\n");
      out.write("        <a class=\"layui-btn layui-btn-danger layui-btn-normal delAll_btn\">批量删除</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("<table id=\"roleList\" lay-filter=\"roleList\"></table>\r\n");
      out.write("<!--操作-->\r\n");
      out.write("<script type=\"text/html\" id=\"roleListBar\">\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs layui-btn-danger\" lay-event=\"del\">删除</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs layui-btn-normal\" lay-event=\"selectPermission\">分配权限</a>\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var tableIns;\r\n");
      out.write("    layui.use(['form','layer','table'],function(){\r\n");
      out.write("        var form = layui.form,\r\n");
      out.write("            layer = parent.layer === undefined ? layui.layer : top.layer,\r\n");
      out.write("            $ = layui.jquery,\r\n");
      out.write("            table = layui.table;\r\n");
      out.write("        //角色列表\r\n");
      out.write("        tableIns = table.render({\r\n");
      out.write("            elem: '#roleList',\r\n");
      out.write("            url : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/queryAllRoles.action',\r\n");
      out.write("            cellMinWidth : 95,\r\n");
      out.write("            page : true,\r\n");
      out.write("            height : \"full-220\",\r\n");
      out.write("            limits : [10,15,20,25],\r\n");
      out.write("            limit : 10,\r\n");
      out.write("            id : \"roleListTable\",\r\n");
      out.write("            cols : [[\r\n");
      out.write("                {type: \"checkbox\", fixed:\"left\", width:50},\r\n");
      out.write("                {field: 'id', title: '角色ID', minWidth:100, align:\"center\"},\r\n");
      out.write("                {field: 'name', title: '角色名称', minWidth:100, align:\"center\"},\r\n");
      out.write("                {field: 'remark', title: '角色备注', minWidth:100, align:\"center\"},\r\n");
      out.write("                {field: 'available', title: '是否可用',  align:'center',templet:function(d){\r\n");
      out.write("                    return d.available ==1 ? \"<font color=blue>可用</font>\" : \"<font color=red>不可用</font>\";\r\n");
      out.write("                }},\r\n");
      out.write("                {title: '操作', minWidth:175, templet:'#roleListBar',fixed:\"right\",align:\"center\"}\r\n");
      out.write("            ]]\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //查询\r\n");
      out.write("        $(\".search_btn\").on(\"click\",function(){\r\n");
      out.write("            var params=$(\"#searchForm\").serialize();\r\n");
      out.write("            table.reload('roleListTable', {\r\n");
      out.write("                url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/queryAllRoles.action?'+params\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //添加角色\r\n");
      out.write("        $(\".addRole_btn\").click(function(){\r\n");
      out.write("            var index = layui.layer.open({\r\n");
      out.write("                title : \"添加角色\",\r\n");
      out.write("                type : 2,//ifream层\r\n");
      out.write("                area:[\"600px\",\"400px\"],\r\n");
      out.write("                content : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/toRoleAdd.action\",\r\n");
      out.write("                success : function(layero, index){\r\n");
      out.write("                    setTimeout(function(){\r\n");
      out.write("                        layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {\r\n");
      out.write("                            tips: 3\r\n");
      out.write("                        });\r\n");
      out.write("                    },500)\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("            //layui.layer.full(index);\r\n");
      out.write("            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）\r\n");
      out.write("            $(window).on(\"resize\",function(){\r\n");
      out.write("                layui.layer.full(index);\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("        //修改角色\r\n");
      out.write("        function updateRole(data){\r\n");
      out.write("            var index = layui.layer.open({\r\n");
      out.write("                title : \"修改角色\",\r\n");
      out.write("                type : 2,\r\n");
      out.write("                area:[\"600px\",\"400px\"],\r\n");
      out.write("                content : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/toUpdateRole.action?id=\"+data.id,\r\n");
      out.write("                success : function(layero, index){\r\n");
      out.write("                    setTimeout(function(){\r\n");
      out.write("                        layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {\r\n");
      out.write("                            tips: 3\r\n");
      out.write("                        });\r\n");
      out.write("                    },500)\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("            //layui.layer.full(index);\r\n");
      out.write("            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）\r\n");
      out.write("            $(window).on(\"resize\",function(){\r\n");
      out.write("                layui.layer.full(index);\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("        //列表操作\r\n");
      out.write("        table.on('tool(roleList)', function(obj){\r\n");
      out.write("            var layEvent = obj.event,\r\n");
      out.write("                data = obj.data;\r\n");
      out.write("            if(layEvent === 'edit'){ //编辑\r\n");
      out.write("                updateRole(data);//data主当前点击的行\r\n");
      out.write("            }else if(layEvent === 'del'){ //删除\r\n");
      out.write("                layer.confirm('确定删【'+data.name+'】角色吗？',{icon:3, title:'提示信息'},function(index){\r\n");
      out.write("                    $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/deleteRole.action\",{\r\n");
      out.write("                        id : data.id  //将需要删除的id作为参数传入\r\n");
      out.write("                    },function(data){\r\n");
      out.write("                        //刷新table\r\n");
      out.write("                        tableIns.reload({page:{curr:deleteJumpPage(obj)}});\r\n");
      out.write("                        //关闭提示框\r\n");
      out.write("                        layer.close(index);\r\n");
      out.write("                    })\r\n");
      out.write("                });\r\n");
      out.write("            }else if(layEvent===\"selectPermission\"){\r\n");
      out.write("            \ttoSelectPermission(data.id);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        function deleteJumpPage(obj){\r\n");
      out.write("        \t//取出obj里面的tr里面的data-index\r\n");
      out.write("        \tvar dataIndex=$(obj.tr[0]).attr(\"data-index\");\r\n");
      out.write("        \t//取到当前页\r\n");
      out.write("        \tvar curr=$(\".layui-laypage-curr em:eq(1)\").text();\r\n");
      out.write("        \tif(dataIndex==0){\r\n");
      out.write("        \t\tcurr = curr == 1 ? curr : curr - 1\r\n");
      out.write("        \t}\r\n");
      out.write("        \treturn curr;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        //批量删除\r\n");
      out.write("        function deleteDBJumpPage(checkStatus){\r\n");
      out.write("        \t//取到当前页\r\n");
      out.write("        \tvar curr=$(\".layui-laypage-curr em:eq(1)\").text();\r\n");
      out.write("        \tif(checkStatus.isAll){\r\n");
      out.write("        \t\tcurr = curr == 1 ? curr : curr - 1\r\n");
      out.write("        \t}\r\n");
      out.write("        \treturn curr;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        //跳车到分配权限的弹出层\r\n");
      out.write("        function toSelectPermission(roleid){\r\n");
      out.write("        \t var index = layui.layer.open({\r\n");
      out.write("                 title : \"分配权限\",\r\n");
      out.write("                 type : 2,\r\n");
      out.write("                 area:[\"300px\",\"400px\"],\r\n");
      out.write("                 content : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/toSelectPermission.action?id=\"+roleid,\r\n");
      out.write("                 success : function(layero, index){\r\n");
      out.write("                     setTimeout(function(){\r\n");
      out.write("                         layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {\r\n");
      out.write("                             tips: 3\r\n");
      out.write("                         });\r\n");
      out.write("                     },500)\r\n");
      out.write("                 }\r\n");
      out.write("             })\r\n");
      out.write("             //layui.layer.full(index);\r\n");
      out.write("             //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）\r\n");
      out.write("             $(window).on(\"resize\",function(){\r\n");
      out.write("                 layui.layer.full(index);\r\n");
      out.write("             })\r\n");
      out.write("        }\r\n");
      out.write("        //批量删除\r\n");
      out.write("        $(\".delAll_btn\").click(function(){\r\n");
      out.write("            //得到当前表格里面的checkbox的选中对象集合\r\n");
      out.write("            var checkStatus = table.checkStatus('roleListTable'),//选中状态\r\n");
      out.write("                data = checkStatus.data;//选中的对象集\r\n");
      out.write("            var ids=\"a=1\";\r\n");
      out.write("            if(data.length > 0) {\r\n");
      out.write("                for (var i in data) {\r\n");
      out.write("                    ids+=\"&ids=\"+data[i].id;\r\n");
      out.write("                }\r\n");
      out.write("                layer.confirm('确定删除选中的角色？', {icon: 3, title: '提示信息'}, function (index) {\r\n");
      out.write("                    $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/batchDeleteRole.action?\"+ids,function(data){\r\n");
      out.write("                        //刷新table\r\n");
      out.write("                        tableIns.reload({page:{curr:deleteDBJumpPage(checkStatus)}});\r\n");
      out.write("                        //关闭提示框\r\n");
      out.write("                        layer.close(index);\r\n");
      out.write("                        //刷新左边的树\r\n");
      out.write("                        window.parent.left.initLeftRoleTree();\r\n");
      out.write("                    })\r\n");
      out.write("                })\r\n");
      out.write("            }else{\r\n");
      out.write("                layer.msg(\"请选择需要删除的角色\");\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    })\r\n");
      out.write("    \r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
