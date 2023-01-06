package mk.finki.ukim.mk.lab.web.Controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping(value = {"/", "/balloons"})
public class BalloonController {
    private final BalloonService balloonService;

    public BalloonController(BalloonService balloonService) {
        this.balloonService = balloonService;

    }

    @GetMapping()
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model)
    {
       List<Balloon> balloonList=this.balloonService.listAll();
        model.addAttribute("balloonList1",balloonList);
        return "listBalloons.html";
    }
    @PostMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id)
    {
        this.balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }


    @GetMapping("/add")
    public String addBalloon()
    {
        return "add-balloon.html";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam (required = false) Long id,@RequestParam String balloonName, @RequestParam String descirption, @RequestParam Long manufacturerId)
    {
        if(id!=null)
        {
            this.balloonService.edit(id,balloonName,descirption,manufacturerId);
        }
        else
        {
            this.balloonService.addBalloon(balloonName,descirption,manufacturerId);
        }

            return "redirect:/balloons";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model, HttpServletRequest req)
    {

        if(this.balloonService.getById(id).isPresent())
        {
            Balloon balon= balloonService.getById(id).get();
            model.addAttribute("balonZaEdit",balon);

            return "add-balloon";
        }
        else{
            return "redirect:/balloons/add";
        }

    }

    @GetMapping("/add-form")
    public String getAddBalloonPage()
    {
        return "redirect:/add";
    }

}
