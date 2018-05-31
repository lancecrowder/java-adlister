import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "CounterServlet", urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {
    protected int count = 0;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        count += 1;
        response.getWriter().println("<h1> Count is: " + count + "</h1>");
    }
}
