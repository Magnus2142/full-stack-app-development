package magnbred.calculator.service;


import magnbred.calculator.model.Calculation;
import magnbred.calculator.repo.CalculationRepo;
import magnbred.calculator.web.CalculationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {


    Logger logger = LoggerFactory.getLogger(CalculationService.class);

    @Autowired
    public CalculationRepo calculationRepo;


    public Calculation calculateEquation(Calculation calculation){
        logger.info("Equation received: " + calculation.getA() + " " + calculation.getOperation() + " " + calculation.getB());
        return calculationRepo.calculateEquation(calculation);
    }

}
