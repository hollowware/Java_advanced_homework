package lt.bit.controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import lt.bit.data.Address;
import lt.bit.data.Contact;
import lt.bit.data.Person;
import lt.bit.db.DB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    
    @GetMapping("/personContactList")
    public ModelAndView personContactList (
            HttpServletRequest request,
            @RequestParam(value="id") Integer id) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        List<Contact> contactList = DB.getPersonContacts(id, em);
        ModelAndView maw = new ModelAndView("personContactList");
        maw.addObject("contactList", contactList);
        return maw;
    }
    
    @GetMapping("/deleteContact")  
    public String deleteContact(HttpServletRequest request,
            @RequestParam(value="id") Integer id) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Contact conn = DB.deleteContact(id, em);
        return "redirect:/personContactList?id=" + conn.getPerson().getId(); 
    }
    
    @GetMapping("/editContact") // updatina, tik redirectina i person lista. 
    public ModelAndView editContact(HttpServletRequest request,
            @RequestParam(value="id", required = false) Integer id) {
        ModelAndView maw = new ModelAndView("editContact");
        if (id != null) {
            EntityManager em = (EntityManager) request.getAttribute("em");
            Contact c = DB.getContactById(id, em);
            if (c != null) {
                maw.addObject("contact", c);
            }
        }
        return maw;
    }
    
    @PostMapping("/saveContact")
    public String saveContact(HttpServletRequest request, 
            @RequestParam(value="id", required = false) Integer id,
            @RequestParam(value="personId") Integer personId,
            @RequestParam(value="type", required = true) String type,
            @RequestParam(value="contact", required = true) String contact
            ) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Contact c = null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (id != null) {
            c = DB.getContactById(id, em);
        }
        if (c == null) {
            c = new Contact();
        }
        Person p = DB.getById(personId, em);
        c.setPerson(p);  
        c.setType(type);
        c.setContact(contact);
        em.persist(c);
        tx.commit();
        return "redirect:/personContactList?id=" + c.getPerson().getId();
    }
    
}
