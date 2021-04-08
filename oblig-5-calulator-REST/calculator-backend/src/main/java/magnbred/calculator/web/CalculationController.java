package magnbred.calculator.web;

import magnbred.calculator.model.Calculation;
import magnbred.calculator.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CalculationController {

    @Autowired
    public CalculationService calculationService;

    @PostMapping("/calculations")
    public Calculation calculateEquation(@RequestBody Calculation calculation){
        return calculationService.calculateEquation(calculation);
    }
}
