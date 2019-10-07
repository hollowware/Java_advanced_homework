package lt.bit.controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import lt.bit.data.Address;
import lt.bit.data.Person;
import lt.bit.db.DB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddressController {
    
    @GetMapping("/personAddressList")
    public ModelAndView personAddressList (
            HttpServletRequest request,
            @RequestParam(value="id") Integer id) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        List<Address> addressList = DB.getPersonAddresses(id, em);
        ModelAndView maw = new ModelAndView("personAddressList");
        maw.addObject("addressList", addressList);
        return maw;
    }
    
    @GetMapping("/deleteAddress")  
    public String deleteAddress(HttpServletRequest request,
            @RequestParam(value="id") Integer id) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Address addr = DB.deleteAddress(id, em);
        return "redirect:/personAddressList?id=" + addr.getPerson().getId(); 
    }
    
    @GetMapping("/editAddress") // updatina, tik redirectina i person lista. 
    public ModelAndView editAddress(HttpServletRequest request,
            @RequestParam(value="id", required = false) Integer id) {
        ModelAndView maw = new ModelAndView("editAddress");
        if (id != null) {
            EntityManager em = (EntityManager) request.getAttribute("em");
            Address a = DB.getAddressById(id, em);
            if (a != null) {
                maw.addObject("address", a);
            }
        }
        return maw;
    }
    
    @PostMapping("/saveAddress")
    public String saveAddress(HttpServletRequest request, 
            @RequestParam(value="id", required = false) Integer id,
            @RequestParam(value="personId") Integer personId,
            @RequestParam(value="address", required = true) String address,
            @RequestParam(value="city", required = true) String city,
            @RequestParam(value="postalCode", required = false) String postalCode
            ) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Address a = null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (id != null) {
            a = DB.getAddressById(id, em);
        }
        if (a == null) {
            a = new Address();
        }
        Person p = DB.getById(personId, em);
        a.setPerson(p); 
        a.setAddress(address);
        a.setCity(city);
        a.setPostalCode(postalCode);
        em.persist(a);
        tx.commit();
        return "redirect:/personAddressList?id=" + a.getPerson().getId(); 
    }
    
}
