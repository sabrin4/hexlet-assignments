package exercise.servlet;

import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;
import static java.lang.System.out;

@WebServlet("/companies")
public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter pw = response.getWriter();
        String param = request.getParameter("search");
        List<String> companies = Data.getCompanies();
        if (param == null || param.isEmpty()) {
            for (String c : companies) {
                pw.write(c.trim() + "\n");
                //pw.write(List.of(c.trim().split("\\n")).toString());
            }
            //pw.write(companies.toString());
        }
        else {
            List<String> filteredCompanies = new ArrayList<>();
            for (String compName : companies) {
                if (compName.contains(param)) {
                    filteredCompanies.add(compName);
                }
            }
            if (filteredCompanies.size() == 0) {
                pw.write("Companies not found");
            }
            else {
                for (String c : filteredCompanies) {
                    pw.write(c.trim() + "\n");
                }
            }
        }
        pw.println();
        // END
    }
}
