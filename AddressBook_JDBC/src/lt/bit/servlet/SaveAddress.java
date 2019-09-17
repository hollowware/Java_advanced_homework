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
 * Servlet implementation class SaveAddress
 */
@WebServlet("/saveAddress")
public class SaveAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAddress() {
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
			// ignored
		}
		Address a = null;
		Person p = null;
		Integer pid = null;
		if (id == null) {
			String pidS = request.getParameter("pid");
			try {
				pid = new Integer (pidS);
			} catch (Exception e) {
				// ignored
			}
			p = DB.getById(pid);
		} else {
			a = DB.getAddressById(id);
			p = DB.getByAddress(a);
		}
		if (p == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		if (a == null) {
			a = new Address(address, city, postalCode);
			DB.addAddress(p.getId(), a);
		} else {
			a.setAddress(address);
			a.setCity(city);
			a.setPostalCode(postalCode);
			DB.updateAddress(a);
		}
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
