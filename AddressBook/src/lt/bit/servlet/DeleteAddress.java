package lt.bit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.bit.data.Address;
import lt.bit.data.Person;
import lt.bit.db.DB;

/**
 * Servlet implementation class DeleteAddress
 */
@WebServlet("/deleteAddress")
public class DeleteAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String idS = request.getParameter("id");

		Integer id = null;
		try {
			id = new Integer(new Integer(idS));
		} catch (Exception e) {
			response.sendRedirect("index.jsp");
			return;
		}

		Address a = DB.getAddressById(id);
		if (a == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		Person p = DB.getByAddress(a);
		DB.deleteAddress(a.getId());
		response.sendRedirect("addressList.jsp?id=" + p.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
