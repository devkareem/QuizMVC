package controller;

import model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Quiz")
public class QuizController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Quiz q =(Quiz) session.getAttribute("quiz");
        String num=request.getParameter("num");
        int answer=(num.isEmpty())?0:Integer.parseInt(num);
        q.setAnswer(answer);
        session.setAttribute("quiz",q);

        if(q.hasQuestion())
            doGet(request,response);
        else
            response.sendRedirect("Result");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Quiz q =(session.isNew())?new Quiz():(Quiz) session.getAttribute("quiz");
        session.setAttribute("quiz",q);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
