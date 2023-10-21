package com.jsonpractice;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.base.Predicate;

public class TestMedicine {
	
	public static void main(String[] args) {
		
      
		List<Medicine> medicinesList=new ArrayList<Medicine>();
		
		Medicine m1=new Medicine(1, "Montecope", 98,"Yes");
		Medicine m2=new Medicine(2, "Dolo 650", 25,"Yes");
		Medicine m3=new Medicine(3, "Mega CV 625", 125,"Yes");
		Medicine m4=new Medicine(4, "Pan-D 40", 35,"Yes");
		Medicine m5=new Medicine(5, "Zincovit", 30,"Yes");
		Medicine m6=new Medicine(6, "AZAX 500", 130,"No");
		
		Collections.addAll(medicinesList, m1,m2,m3,m4,m5,m6);
		
		Predicate<Medicine> isPriceGrt30=e->e.getDrugPrice()>30;
		Predicate<Medicine> isDrugAvailable=e->e.getAvailability().equalsIgnoreCase("Yes");
		
	medicinesList
	.stream()
	.filter(product->product.getDrugPrice()>30 && product.getAvailability().equalsIgnoreCase("Yes"))
	.collect(Collectors.toList())
	.forEach(System.out::println);
		
	medicinesList
		.stream()
        .filter(isPriceGrt30.and(isDrugAvailable))
        .collect(Collectors.groupingBy(Medicine::getDrugName,Collectors.mapping(Medicine::getDrugPrice, Collectors.toList())))
        .entrySet()
        .stream()
        .forEach(System.out::println);
	
	}

}
