package it.gps;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Problem {
	private List<String> status, goals;
	private List<Operator> operators;
}
