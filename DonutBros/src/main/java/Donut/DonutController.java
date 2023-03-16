package Donut;

import Donut.Donut;
import Donut.DonutService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping
public class DonutController {

    private final DonutService donutService;

    private final Logger logger = Logger.getLogger(Donut.class.toString());

    @Autowired
    public DonutController(DonutService donutService) {
        this.donutService = donutService;
    }

    @GetMapping
    public List<Donut> getDonuts(){
        return donutService.getDonuts();
    }

    @PostMapping
    public void registerNewDonut(@RequestBody Donut donut){
        donutService.addNewDonut(donut);
    }

    @DeleteMapping(path = "{donutId}")
    public void deleteDonut(@PathVariable("donutId") Long donutId) {
        donutService.deleteDonut(donutId);
    }

    @PutMapping(path = "{donutid}")
    public void updateDonut(
            @PathVariable("donutid") Long donutid,
            @RequestParam(required = false) Float price) {
        donutService.updateDonut(donutid, price);
    }
}
