//package org.apache.jsp.backstage.note;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.jsp.*;
//import java.util.*;
//
//public final class shownote_jsp extends org.apache.jasper.runtime.HttpJspBase
//    implements org.apache.jasper.runtime.JspSourceDependent {
//
//  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();
//
//  private static java.util.List<String> _jspx_dependants;
//
//  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
//
//  private javax.el.ExpressionFactory _el_expressionfactory;
//  private org.apache.tomcat.InstanceManager _jsp_instancemanager;
//
//  public java.util.List<String> getDependants() {
//    return _jspx_dependants;
//  }
//
//  public void _jspInit() {
//    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
//    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
//    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
//  }
//
//  public void _jspDestroy() {
//    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
//  }
//
//  public void _jspService(final HttpServletRequest request, final HttpServletResponse response)
//        throws java.io.IOException, ServletException {
//
//    final PageContext pageContext;
//    HttpSession session = null;
//    final ServletContext application;
//    final ServletConfig config;
//    JspWriter out = null;
//    final Object page = this;
//    JspWriter _jspx_out = null;
//    PageContext _jspx_page_context = null;
//
//
//    try {
//      response.setContentType("text/html;charset=utf-8");
//      pageContext = _jspxFactory.getPageContext(this, request, response,
//      			null, true, 8192, true);
//      _jspx_page_context = pageContext;
//      application = pageContext.getServletContext();
//      config = pageContext.getServletConfig();
//      session = pageContext.getSession();
//      out = pageContext.getOut();
//      _jspx_out = out;
//
//      out.write('\r');
//      out.write('\n');
//
//String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//
//      out.write("\r\n");
//      out.write("\r\n");
//      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
//      out.write("<html>\r\n");
//      out.write("  <head>\r\n");
//      out.write("    <base href=\"");
//      out.print(basePath);
//      out.write("\">\r\n");
//      out.write("    \r\n");
//      out.write("    <title>笔记</title>\r\n");
//      out.write("    \r\n");
//      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
//      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
//      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
//      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
//      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
//      out.write("\t<!--\r\n");
//      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
//      out.write("\t-->\r\n");
//      out.write("\t<script language=\"JavaScript\" src=\"js/jquery-1.11.1.js\"></script>\r\n");
//      out.write("\t<style type=\"text/css\">\r\n");
//      out.write("body{\r\n");
//      out.write("\tmargin:0;\r\n");
//      out.write("\tpadding:40px;\r\n");
//      out.write("\tbackground:#fff;\r\n");
//      out.write("\tfont:80% Arial, Helvetica, sans-serif;\r\n");
//      out.write("\tcolor:#555;\r\n");
//      out.write("\tline-height:180%;\r\n");
//      out.write("}\r\n");
//      out.write("img{border:none;}\r\n");
//      out.write("ul,li{\r\n");
//      out.write("\tmargin:0;\r\n");
//      out.write("\tpadding:0;\r\n");
//      out.write("}\r\n");
//      out.write("li{\r\n");
//      out.write("\tlist-style:none;\r\n");
//      out.write("\tfloat:left;\r\n");
//      out.write("\tdisplay:inline;\r\n");
//      out.write("\tmargin-right:10px;\r\n");
//      out.write("\tborder:1px solid #AAAAAA;\r\n");
//      out.write("}\r\n");
//      out.write("\r\n");
//      out.write("/* tooltip */\r\n");
//      out.write("#tooltip{\r\n");
//      out.write("\tposition:absolute;\r\n");
//      out.write("\tborder:1px solid #ccc;\r\n");
//      out.write("\tbackground:#333;\r\n");
//      out.write("\tpadding:2px;\r\n");
//      out.write("\tdisplay:none;\r\n");
//      out.write("\tcolor:#fff;\r\n");
//      out.write("}\r\n");
//      out.write("</style>\r\n");
//      out.write("<script type=\"text/javascript\">\r\n");
//      out.write("//<![CDATA[\r\n");
//      out.write("$(function(){\r\n");
//      out.write("\tvar x = 10;\r\n");
//      out.write("\tvar y = 20;\r\n");
//      out.write("\t$(\"a.tooltip\").mouseover(function(e){\r\n");
//      out.write("\t\tthis.myTitle = this.title;\r\n");
//      out.write("\t\tthis.title = \"\";\t\r\n");
//      out.write("\t\tvar imgTitle = this.myTitle? \"<br/>\" + this.myTitle : \"\";\r\n");
//      out.write("\t\tvar tooltip = \"<div id='tooltip'><img src='\"+ this.href +\"' alt='产品预览图'/>\"+imgTitle+\"<\\/div>\"; //创建 div 元素\r\n");
//      out.write("\t\t$(\"body\").append(tooltip);\t//把它追加到文档中\t\t\t\t\t\t \r\n");
//      out.write("\t\t$(\"#tooltip\")\r\n");
//      out.write("\t\t\t.css({\r\n");
//      out.write("\t\t\t\t\"top\": (e.pageY+y) + \"px\",\r\n");
//      out.write("\t\t\t\t\"left\":  (e.pageX+x)  + \"px\"\r\n");
//      out.write("\t\t\t}).show(\"fast\");\t  //设置x坐标和y坐标，并且显示\r\n");
//      out.write("    }).mouseout(function(){\r\n");
//      out.write("\t\tthis.title = this.myTitle;\t\r\n");
//      out.write("\t\t$(\"#tooltip\").remove();\t //移除 \r\n");
//      out.write("    }).mousemove(function(e){\r\n");
//      out.write("\t\t$(\"#tooltip\")\r\n");
//      out.write("\t\t\t.css({\r\n");
//      out.write("\t\t\t\t\"top\": (e.pageY+y) + \"px\",\r\n");
//      out.write("\t\t\t\t\"left\":  (e.pageX+x)  + \"px\"\r\n");
//      out.write("\t\t\t});\r\n");
//      out.write("\t});\r\n");
//      out.write("})\r\n");
//      out.write("//]]>\r\n");
//      out.write("</script>\r\n");
//      out.write("  </head>\r\n");
//      out.write("  <body>\r\n");
//      out.write("    <center>\r\n");
//      out.write("\t\t<h2>笔记</h2>\r\n");
//      out.write("\r\n");
//      out.write("\t\t<hr>\r\n");
//      out.write("\t\t\r\n");
//      out.write("\t\t<table border=\"1\" width=\"800\" cellpadding=\"0\" cellspacing=\"0\" bordercolor=\"#1F85B6\" align=\"center\">\r\n");
//      out.write("\t\t\t\r\n");
//      out.write("\t\t\t\r\n");
//      out.write("\t\t\t<tr height=\"30\">\r\n");
//      out.write("\t\t\t\t<th width=\"100\" style=\"color:#1F85B6\">日期</th>\r\n");
//      out.write("\t\t\t\t<th width=\"400\" style=\"color:#1F85B6\">笔记</th>\r\n");
//      out.write("\t\t\t\t\r\n");
//      out.write("\t\t\t</tr >\r\n");
//      out.write("\t\t\t");
//      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
//        return;
//      out.write("\r\n");
//      out.write("\t\t\t\r\n");
//      out.write("\t\t</table>\r\n");
//      out.write("\t</center>\r\n");
//      out.write("  \r\n");
//      out.write("  </body>\r\n");
//      out.write("</html>\r\n");
//    } catch (Throwable t) {
//      if (!(t instanceof SkipPageException)){
//        out = _jspx_out;
//        if (out != null && out.getBufferSize() != 0)
//          try { out.clearBuffer(); } catch (java.io.IOException e) {}
//        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
//      }
//    } finally {
//      _jspxFactory.releasePageContext(_jspx_page_context);
//    }
//  }
//
//  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
//          throws Throwable {
//    PageContext pageContext = _jspx_page_context;
//    JspWriter out = _jspx_page_context.getOut();
//    //  c:forEach
//    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
//    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
//    _jspx_th_c_005fforEach_005f0.setParent(null);
//    // /backstage/note/shownote.jsp(99,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
//    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/backstage/note/shownote.jsp(99,3) '${ requestScope.notelist }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ requestScope.notelist }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
//    // /backstage/note/shownote.jsp(99,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
//    _jspx_th_c_005fforEach_005f0.setVar("note");
//    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
//    try {
//      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
//      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
//        do {
//          out.write("\r\n");
//          out.write("\t\t\t\t<tr height=\"30\">\r\n");
//          out.write("\t\t\t\t\t<td align=\"center\">");
//          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${note.date }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
//          out.write("</td>\r\n");
//          out.write("\t\t\t\t\t<td align=\"left\"><form><textarea  type=\"text\" class=\"inputbox\" style=\"width:600px;hight:60px\">");
//          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${note.content }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
//          out.write("</textarea><br><table>\r\n");
//          out.write("\t\t\t\t\t");
//          if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
//            return true;
//          out.write("\r\n");
//          out.write("\t\t\t\t\t</table></form></td>\r\n");
//          out.write("\t\t\t\t</tr>\t\t\t\r\n");
//          out.write("\t\t\t\t\r\n");
//          out.write("\t\t\t");
//          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
//          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
//            break;
//        } while (true);
//      }
//      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
//        return true;
//      }
//    } catch (Throwable _jspx_exception) {
//      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
//        out = _jspx_page_context.popBody();
//      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
//    } finally {
//      _jspx_th_c_005fforEach_005f0.doFinally();
//      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
//    }
//    return false;
//  }
//
//  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
//          throws Throwable {
//    PageContext pageContext = _jspx_page_context;
//    JspWriter out = _jspx_page_context.getOut();
//    //  c:forEach
//    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
//    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
//    _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
//    // /backstage/note/shownote.jsp(103,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
//    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/backstage/note/shownote.jsp(103,5) 'note.noteImages'",_el_expressionfactory.createValueExpression("note.noteImages",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
//    // /backstage/note/shownote.jsp(103,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
//    _jspx_th_c_005fforEach_005f1.setVar("noteImage");
//    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
//    try {
//      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
//      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
//        do {
//          out.write("\r\n");
//          out.write("\t\t\t\t\t\t<th><a href=\"");
//          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
//          out.write('/');
//          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noteImage.url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
//          out.write("\" class=\"tooltip\" title=\"img\"><img height=\"50\" width=\"50\" src=\"");
//          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
//          out.write('/');
//          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noteImage.url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
//          out.write("\" alt=\"img\" /></a></th>\r\n");
//          out.write("\t\t\t\t\t");
//          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
//          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
//            break;
//        } while (true);
//      }
//      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
//        return true;
//      }
//    } catch (Throwable _jspx_exception) {
//      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
//        out = _jspx_page_context.popBody();
//      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
//    } finally {
//      _jspx_th_c_005fforEach_005f1.doFinally();
//      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
//    }
//    return false;
//  }
//}
