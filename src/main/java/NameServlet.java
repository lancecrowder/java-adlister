import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

@WebServlet (name = "nameServlet", urlPatterns = "/")
public class NameServlet extends HttpServlet {

    private String nameInput;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/get-name.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        nameInput = request.getParameter("name");
        request.setAttribute("name", StringUtils.capitalize(nameInput));
        request.getRequestDispatcher("/display-name.jsp").forward(request, response);
    }
}
