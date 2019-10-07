package lt.bit.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.bit.data.Person;
import lt.bit.db.DB;

/**
 * Servlet implementation class SavePerson
 */
@WebServlet("/save")
public class SavePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePerson() {
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
			id = new Integer(idS);
		} catch (Exception e) {
			// ignored
		}
		String firstName = request.getParameter("fn");
		String lastName = request.getParameter("ln");
		String birthDateS = request.getParameter("db");
		String salaryS = request.getParameter("salary");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = new Date();
		try {
			birthDate = sdf.parse(birthDateS);
		} catch (Exception e) {
			// ignored
		}
		BigDecimal salary = BigDecimal.ZERO;
		try {
			salary = new BigDecimal(salaryS);
		} catch (Exception e) {
			// ignored
		}
		Person p = new Person(firstName, lastName, birthDate, salary);
		if (id == null) {
			DB.add(p);
		} else {
			p.setId(id);
			DB.update(p);
		}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
