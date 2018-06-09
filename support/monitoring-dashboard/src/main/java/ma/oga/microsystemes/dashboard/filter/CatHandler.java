package ma.oga.microsystemes.dashboard.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;


public class CatHandler implements AccessDeniedHandler {

     public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException var3) throws IOException, ServletException {
         response.setHeader("Content-type", "text/html");
         response.getWriter().println(String.format("<html>" //
                 + "<head>" //
                 + "<style>" //
                 + ".center { display: block; margin-left: auto; margin-right: auto; width: 50%%; }" //
                 + "</style>" //
                 + "</head>" //
                 + "<body style=\"background-color: black;\">" //
                 + "<img src=\"https://http.cat/%s\" class=\"center\"/>" //
                 + "</body>" //
                 + "</html>", 403));
            }
        }
