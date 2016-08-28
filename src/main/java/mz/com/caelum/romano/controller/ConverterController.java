package mz.com.caelum.romano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConverterController {
	
	@RequestMapping(value="/Romano", method=RequestMethod.GET)
	public String sendRomNumber(){
		return "rom";
	}
	
	@RequestMapping(value= "/Decimal",method= RequestMethod.POST)
	public String showDecimalNumber(){
		
		return "decimal";
	}

}
