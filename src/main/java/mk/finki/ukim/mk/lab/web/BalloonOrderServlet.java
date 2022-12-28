package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.User;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet(name = "balloon-order-servlet",urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp, req.getServletContext());
        resp.setContentType("application/xhtml+xml");

        this.springTemplateEngine.process("deliveryInfo.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        String username = (String) req.getSession().getAttribute("username");
        String ip = req.getRemoteAddr();
        String userAgent = req.getHeader("User-Agent");
        req.getSession().setAttribute("clientName",clientName);
        req.getSession().setAttribute("clientAddress",clientAddress);
        req.getSession().setAttribute("ip",ip);
        req.getSession().setAttribute("userAgent",userAgent);
        resp.sendRedirect("/confirmationInfo");
    }
}
