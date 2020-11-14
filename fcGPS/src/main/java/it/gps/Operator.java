package it.gps;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operator {
	// STRIPS
	private String name="";
	private List<String> prec=new ArrayList<String>(), 
			add=new ArrayList<String>(), del=new ArrayList<String>();
}
