package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  final String TAG_CLASS_NAME = this.getClass().getName();

  /**
   * Init of the class.
   */
  public void init() {
    System.out.println(TAG_CLASS_NAME);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	    System.out.println("get");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h2> MARS ROVERS @FormQuery Testing </h2> <hr> <br>");
    out.println("<form action=\"explorationResult\" method=\"post\" >");
    out.println("<p>Upper right coordinates plateau (x,y) : <input type=\"text\" name=\"plateauX\" /> <input type=\"text\" name=\"plateauY\" /></p>");
    out.println("<p>Position Rover (x,y): <input type=\"text\" name=\"positionX\" /> <input type=\"text\" name=\"positionY\" /></p>");
    out.println("<p>Direction Rover [N,E,S,W] : <input type=\"text\" name=\"direction\" /></p>");
    out.println("<p>Instructions [L,R,M]* : <input type=\"text\" name=\"instructions\" /></p>");
    out.println("<input type=\"submit\" value=\"Explore\" />");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	    System.out.println("post");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h2> MARS ROVERS @FormQuery Testing </h2> <hr> <br>");
    out.println("<form action=\"rest/user/add\" method=\"post\" >");
    out.println("<p>Upper right coordinates plateau (x,y) : <input type=\"text\" name=\"plateauX\" /> <input type=\"text\" name=\"plateauY\" /></p>");
    out.println("<p>Position Rover (x,y): <input type=\"text\" name=\"positionX\" /> <input type=\"text\" name=\"positionY\" /></p>");
    out.println("<p>Direction Rover [N,E,S,W] : <input type=\"text\" name=\"direction\" /></p>");
    out.println("<p>Instructions [L,R,M]* : <input type=\"text\" name=\"instructions\" /></p>");
    out.println("<input type=\"submit\" value=\"Explore\" />");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
