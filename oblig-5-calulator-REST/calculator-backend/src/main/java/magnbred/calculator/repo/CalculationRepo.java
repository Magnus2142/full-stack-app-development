package magnbred.calculator.repo;


import magnbred.calculator.model.Calculation;
import magnbred.calculator.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CalculationRepo {

    Logger logger = LoggerFactory.getLogger(CalculationService.class);

    @Autowired
    public CalculationService calculationService;


    public Calculation calculateEquation(Calculation calculation){
        if(calculation.getOperation().equals("+")){
            calculation.setAnswer(Double.toString(calculation.getA() + calculation.getB()));
        }
        if(calculation.getOperation().equals("-")){
            calculation.setAnswer(Double.toString(calculation.getA() - calculation.getB()));
        }
        if(calculation.getOperation().equals("/")){
            calculation.setAnswer(Double.toString(calculation.getA() / calculation.getB()));
        }
        if(calculation.getOperation().equals("*")){
            calculation.setAnswer(Double.toString(calculation.getA() * calculation.getB()));
        }

        logger.info("Answer calculated: " +  calculation.getAnswer());
        return calculation;
    }
}
