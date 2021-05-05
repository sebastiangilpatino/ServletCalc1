package com.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculator", value = "/calculator")
public class calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double num1Sum=null, num2Sum=null, num1Multi=null, num2Multi=null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sum1Str = request.getParameter("sum1");
        String sum2Str = request.getParameter("sum2");
        String multi1Str = request.getParameter("multi1");
        String multi2Str = request.getParameter("multi2");
        String multiply = "";
        String sum = "";

        if (sum1Str.length() > 0 && sum2Str.length() > 0) {
            try {
                num1Sum = Double.parseDouble(sum1Str);
                num2Sum = Double.parseDouble(sum2Str);
            } catch (NumberFormatException e) {
                num1Sum = null;
                num2Sum = null;
            }
        }

        if (multi1Str.length() > 0 && multi2Str.length() > 0) {
            try {
                num1Multi = Double.parseDouble(multi1Str);
                num2Multi = Double.parseDouble(multi2Str);
            } catch (NumberFormatException e) {
                num1Multi = null;
                num2Multi = null;
            }
        }

        out.println("<html><body>");
        if (num1Sum != null && num2Sum != null) {
            sum = String.valueOf(num1Sum + num2Sum);
            out.println("<div>" + sum1Str + "<span>+</span>" + sum2Str + "<span>=</span>" + sum + "</div>");
        }

        if (num1Multi != null && num2Multi != null) {
            multiply = String.valueOf(num1Multi * num2Multi);
            out.println("<div>" + multi1Str + "<span>*</span>" + multi2Str + "<span>=</span>" + multiply + "</div>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
