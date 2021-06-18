
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       String action = request.getParameter("action");
        // if user click logout
        if (action != null && action.equals("logout")){
            //check if session exist and if so, destory session
           HttpSession session = request.getSession(false);
           session.invalidate();
           //display the logout message
           request.setAttribute("logoutmessage",true);
        } 
        
        HttpSession session = request.getSession(false);
       
       //if session exists, redirect to home 
       if (session != null && session.getAttribute("username") != null){
            response.sendRedirect("home");
        }    
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         }     
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("user_name");
        String password = request.getParameter("password");
        
        // validation: if the parameters don't exist or empty, show the invalid message and form again
        if(username == null || username.equals("") || password == null || password.equals("")){
            request.setAttribute("invalid",true);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }

        AccountService accountSerivce = new AccountService();
        User user = (User) accountSerivce.login(username,password);
        
        // Keeping the textboxes filed in user's inputs
        request.setAttribute("username",username);
        request.setAttribute("password",password);
        
        // validation: if the parameters don't exist in accountService, show the invalid message and form again
        // if the parameters are valid, redierect to home page.  
        if(user == null){
            request.setAttribute("invalid",true);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
        
        // create a session and store usersname in the session and redirect to home.jsp
        else{
            HttpSession session=request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("username",username);
            response.sendRedirect("home");
        }

    }

}
