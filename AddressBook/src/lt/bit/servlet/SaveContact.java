package lt.bit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.data.Contact;
import lt.bit.data.Person;
import lt.bit.db.DB;

/**
 * Servlet implementation class SaveContact
 */
@WebServlet("/saveContact")
public class SaveContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveContact() {
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
		Contact c = null;
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
			c = DB.getContactById(id);
			p = DB.getByContact(c);
		}
		if (p == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		String type = request.getParameter("type");
		String contact = request.getParameter("contact");
		if (c == null) {
			c = new Contact(type, contact);
			DB.addContact(p.getId(), c);
		} else {
			c.setType(type);
			c.setContact(contact);
			DB.updateContact(c);
		}
		response.sendRedirect("contactList.jsp?id=" + p.getId());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
