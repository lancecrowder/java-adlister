import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/login")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String message = "";
            if (username.equals("admin") && password.equals("password")) {
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
            } else {
                message = "Invalid Username or password. Please try again.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }