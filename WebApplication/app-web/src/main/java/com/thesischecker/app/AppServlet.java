package com.thesischecker.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import com.thesischecker.dto.UserEntity;
import com.thesischecker.services.UserService;

/**
 * 
 * TODO COMMENTS MISSING!
 * 
 * @author Michał Szczygieł <michal.szczygiel@wp.pl>
 * 
 */
@Component("appServlet")
public class AppServlet implements HttpRequestHandler {

    @Autowired
    UserService userService;

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserEntity userEntity = new UserEntity();
        // userEntity.setId(2);
        // userEntity.setEmail("michal.szczygiel@wp.pl");
        System.out.println(userEntity.getId());

        try {
            userService.persistUser(userEntity);
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thesis Checker</h1>");
            out.println("<h2>User is inserted!</h2>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thesis Checker</h1>");
            out.println("<h2>Transaction Rollback!</h2>");
            out.println("</body>");
            out.println("</html>");
            e.printStackTrace();
            e.printStackTrace();
        }

    }

}
