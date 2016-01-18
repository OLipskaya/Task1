package servlets;

import action.MainController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "ControlServlet")
public class ControlServlet extends HttpServlet {

    private static MainController controller = new MainController();
    private String result = "keyword not found";
    private String input = "ring";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response, "post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response, "get");
    }

    private void process(HttpServletRequest request, HttpServletResponse response, String methodName) throws ServletException, IOException {
        if (methodName.equals("post")) {
            readInputLine(request);
        }
        String prmKey = (String)request.getParameter("key");
        String prmView = (String)request.getParameter("view");
        controller.setParametrs(prmKey, prmView);
        controller.start();
        result = controller.getResultMessage();

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void readInputLine(HttpServletRequest request) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        BufferedReader reader = (BufferedReader)request.getReader();
        while ((line = reader.readLine()) != null){
            jb.append(line);
        }
        input = jb.toString();
        //controller.parseJson(input);
    }

}
