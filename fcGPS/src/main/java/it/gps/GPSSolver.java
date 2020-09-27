package it.gps;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GPSSolver {

	public boolean solve(Problem p) {
		return achieveAll(p.getStatus(), p.getGoals(), p.getOperators());
	}

	public boolean achieveAll(List<String> s, List<String> goals, List<Operator> ops) {
		return true;
	}

	public boolean achieve(List<String> s, String goals, List<Operator> ops) {
		return true;
	}

	public void apply(List<String> s, Operator o) {
		// achieveAll o.getPrec
	}

}
