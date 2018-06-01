import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

@WebServlet (name = "PickColorServlet", urlPatterns = "/pickcolor")
public class PickColorServlet extends HttpServlet {

    private String favoritecolor;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/get-color.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        favoritecolor = request.getParameter("color");
        request.setAttribute("color", StringUtils.capitalize(favoritecolor));
        request.getRequestDispatcher("/display-color.jsp").forward(request, response);
    }
}
