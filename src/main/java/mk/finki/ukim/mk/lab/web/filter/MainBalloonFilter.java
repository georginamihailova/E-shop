//package mk.finki.ukim.mk.lab.web.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "MainBalloonFilter",urlPatterns = "/*")
//public class MainBalloonFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("Filter init method started");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        String color = (String) request.getSession().getAttribute("option");
//        String path = request.getServletPath();
//
//        if((!"/balloons".equals(path)&&(!"/balloons/add-balloon".equals(path))&& (!"".equals(path)) && (!"balloons/edit-form/*".equals(path)) && (color==null || color.isEmpty())))
//        {
//            response.sendRedirect("/balloons");
//        }else{
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
