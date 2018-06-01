import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

@WebServlet (name = "MultiplicationServlet", urlPatterns = "/multiplication")
public class MultiplicationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/get-summands.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int multiplicand2 = Integer.parseInt(request.getParameter("multiplicand2"));
        int multiplicand1 = Integer.parseInt(request.getParameter("multiplicand1"));
        int product = multiplicand1 * multiplicand2;
        request.setAttribute("product", product);
        request.getRequestDispatcher("/display-product.jsp").forward(request, response);
    }
}