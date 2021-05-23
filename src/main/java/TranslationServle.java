import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet(name = "TranslationServle", value = "/translate")
public class TranslationServle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", ("Xin chào"));
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = request.getParameter("Search");

        PrintWriter writer = response.getWriter();


        String result = dictionary.get(search);
        if(result != null){
            writer.println("<html>");
            writer.println("<meta charset=\"UTF-8\">");
            writer.println("<h1> Word : " + search + "</h1>");
            writer.println("<h1> Result : " + result + "</h1>");
            writer.println("/html");
        }
        else{
            writer.println("Not found");
        }
    }
}
