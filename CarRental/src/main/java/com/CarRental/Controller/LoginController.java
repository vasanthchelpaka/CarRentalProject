package com.CarRental.Controller;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.Controller.bean.Hist;
import com.CarRental.Controller.bean.User;
import com.CarRental.dao.CarDao;
import com.CarRental.dao.StatusDao;
import com.CarRental.dao.impl.CarDaoImpl;
import com.CarRental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Controller
public class LoginController {
    @Autowired
    PrizeService prizeService;

    @Autowired
    private ApplicationContext context;

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;
    @Autowired
    HistService histService;

    @Autowired
    StatusService statusService;

    @Autowired
    BillService billService;
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String loginP3age() {
        return "test2";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testPage() {
        return "test";
    }
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPage2() {
        return "redirect:login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(ModelMap model, @RequestParam String userId, @RequestParam String password) {
        User user = userService.getUserByUserId(userId);
        if (user.getPassword().equals(password)) {
            model.put("Msg", userId);
            return "redirect:welcome1";
        }
        else {
            model.put("Msg", userId);
            return "login";
        }

    }








    @RequestMapping(value = "/welcome1", method = RequestMethod.POST)
    public ModelAndView welcomePage(ModelAndView model, @RequestParam String bookfrom, @RequestParam String bookto, @RequestParam String type) throws ParseException {
        LocalDate a = LocalDate.parse(bookfrom);
        System.out.println(a);
        LocalDate b = LocalDate.parse(bookto);
        System.out.println(b);
        List<Cars> modeld=carService.getCarByCarId(a, b,type);
        Cars c1= new Cars();
        c1.setCompany("test");
        c1.setModel("asd");
        modeld.add(c1);

        model.addObject("modeld", modeld);
        model.setViewName("next");
        return model;
    }


    // bill code

    @RequestMapping(value = "/welcome1", method = RequestMethod.GET)
    public String welcomePage() {
        return "welcome1";
    }


    @RequestMapping(value="/bill", method = RequestMethod.POST)
        public ModelAndView billPage(ModelAndView model, @RequestParam("id1")  String carId) {
        System.out.println(carId);
        Integer id = Integer.valueOf(carId);
        List<Cars> model2= billService.getBillByCarId(id);
        model.addObject("model2", model2);
        model.setViewName("bill");
        return model;
    }


    @RequestMapping(value = "/batman", method = RequestMethod.GET)
    public String hashPage() {
        return "batman";
    }

    @RequestMapping(value="/batman", method = RequestMethod.POST)
    public ModelAndView hashPage(ModelAndView model, @RequestParam  int code) {
        System.out.println(code);
       // Integer id = Integer.valueOf(code);
        List<Hist> model3= histService.getHistByHashId(code);
        model.addObject("model3", model3);
        model.setViewName("flash");
        return model;
    }

    @RequestMapping(value = "/returnCar", method = RequestMethod.GET)
    public String returnPage() {
        return "returnCar";
    }
    @RequestMapping(value="/returnCar", method = RequestMethod.POST)
    public ModelAndView returnPage(ModelAndView model, @RequestParam(required=false,name="cardId") int carId,@RequestParam int hashcode) {
        System.out.println(carId);
        System.out.println("vasanth");
        List<Cars> model4= statusService.statusOfcar(carId,hashcode);
        model.addObject("model4", model4);
        model.setViewName("returnFinal");
        return model;
    }



    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String sortPage() {
        return "sort";
    }

    //sorting
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ModelAndView sortPage(ModelAndView model, @RequestParam String sort) throws ParseException {

        List<Cars> modeld=prizeService.getCarsSorted(sort);
        model.addObject("modeld", modeld);
        model.setViewName("afterSort");
        return model;
    }


}

