package it.gps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GPSSolver {

	public static final String PREFIX = "ESEGUO ";

	// ritorna NULL se non riesco a risolvere il problema
	public List<String> solve(Problem p) {
		return achieveAll(p.getStatus(), p.getGoals(), p.getOperators(), new ArrayList<>());
	}

	// ritorna NULL se non riesco a raggiungere almeno goal
	public List<String> achieveAll(List<String> s, List<String> goals, List<Operator> ops, List<String> working) {
		for (String goal : goals) {
			s = achieve(s, goal, ops, working);
			if (s==null)
				return s;
		}
		return s;
	}

	// ritorna NULL se non riesco a raggiungere goal
	public List<String> achieve(List<String> s, String goal, List<Operator> ops, List<String> working) {
		if (s.contains(goal))
			return s;
		if (working.contains(goal))
			return null;
		for (Operator o : ops) {
			List<String> w2 = new ArrayList(working);
			w2.add(goal);
			if (o.getAdd().contains(goal)) {// && apply(s, o, ops, w2))
				List<String> s2 = apply(s, o, ops, w2);
				if (s2 != null)
					return s2;
			}
		}
		return null;
	}

	// ritorna NULL se o non è applicabile
	public List<String> apply(List<String> s, Operator o, List<Operator> ops, List<String> working) {
		log.info("provo ad eseguire {}", o);
		List<String> s2 = achieveAll(s, o.getPrec(), ops, working);
		if (s2 == null) {
			log.info("non riesco ad eseguire {}", o);
			return s2;
		}
		log.info("ipotizzo di eseguire {}" , o.getName());
		List<String> s3 = new ArrayList<>(s2);
		s3.addAll(o.getAdd());
		s3.removeAll(o.getDel());
		s3.add(PREFIX + o.getName());
		return s3;
	}

}
