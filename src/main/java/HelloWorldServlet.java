import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//public class HelloWorldServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
//
//    }
//}

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Scanner input = new Scanner(System.in);
        response.setContentType("text/html");
        String output = input.nextLine();
        PrintWriter out = response.getWriter();
        if (output != null){
            out.println("<h1>Hello " + output + "!</h1>");
        }else {out.println("<h1>Hello, World!</h1>");}
    }
}