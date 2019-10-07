package lt.bit.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import lt.bit.data.Person;
import lt.bit.db.DB;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    
    @GetMapping("/")
    public ModelAndView list(HttpServletRequest request) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        List<Person> list = DB.getAll(em);
        ModelAndView maw = new ModelAndView("personList");
        maw.addObject("list", list);
        return maw;
    }
    
    @GetMapping("/delete")
    public String delete(HttpServletRequest request,
            @RequestParam(value="id") Integer id) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        DB.delete(id, em);
        return "redirect:/";
    }
    
    @GetMapping("/edit")
    public ModelAndView edit(HttpServletRequest request,
            @RequestParam(value="id", required = false) Integer id) {
        ModelAndView maw = new ModelAndView("editPerson");
        if (id != null) {
            EntityManager em = (EntityManager) request.getAttribute("em");
            Person p = DB.getById(id, em);
            if (p != null) {
                maw.addObject("person", p);
            }
        }
        return maw;
    }
    
    @PostMapping("/save")
    public String save(HttpServletRequest request, 
            @RequestParam(value="id", required = false) Integer id,
            @RequestParam(value="fn", required = true) String fn,
            @RequestParam(value="ln", required = true) String ln,
            @RequestParam(value="bd", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date bd,
            @RequestParam(value="salary", required = false) BigDecimal salary
            ) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Person p = null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (id != null) {
            p = DB.getById(id, em);
        }
        if (p == null) {
            p = new Person();
        }
        p.setFirstName(fn);
        p.setLastName(ln);
        p.setBirthDate(bd);
        p.setSalary(salary);
        em.persist(p);
        tx.commit();
        return "redirect:/";
    }
    
}
