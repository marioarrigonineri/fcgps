package it.gps;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operator {
	private String name="";
	private Set<String> prec=new HashSet<String>(), add=new HashSet<String>(), del=new HashSet<String>();
}
