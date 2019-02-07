package br.com.saude.api.generic;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.javatuples.Triplet;

import br.com.saude.api.util.constant.TypeFilter;

public class Helper {
	private static StringBuilder stringBuilder;
	
	public static String filterLike(String str) {
		str = str.replace("�", "%").replace("�", "%").replace("�", "%").replace("�", "%").replace("�", "%")
				.replace("�", "%").replace("�", "%").replace("�", "%").replace("�", "%").replace("�", "%")
				.replace("�", "%").replace("�", "%")
				.replace("�", "%").replace("�", "%").replace("�", "%").replace("�", "%")
				.replace("�", "%").replace("�", "%").replace("�", "%")
				.replace("�", "%").replace("�", "%").replace("�", "%")
				.replace("�", "%").replace("�", "%");
				
		
		stringBuilder = new StringBuilder("%");
		stringBuilder.append(str);
		stringBuilder.append("%");
		return stringBuilder.toString();
	}
	
	public static long getNow() {
		return new Date().getTime();
	}
	
	@SuppressWarnings("deprecation")
	public static long getToday() {
		Date today = new Date();
		today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);
		return today.getTime();
	}
	
	public static Criterion getCriterionDateFilter(String propertyName, DateFilter dateFilter) {
		if(dateFilter != null && dateFilter.getTypeFilter() != null && dateFilter.getInicio() > 0) {
			switch(dateFilter.getTypeFilter()) {
				case TypeFilter.ENTRE:
					return Restrictions.between(propertyName, 
								dateFilter.getInicio(), 
								dateFilter.getFim());
			case TypeFilter.MAIOR_IGUAL:return andDifferentZero(propertyName,Restrictions.ge(propertyName, dateFilter.getInicio()));
			case TypeFilter.MAIOR:return andDifferentZero(propertyName,Restrictions.gt(propertyName, dateFilter.getInicio()));
			case TypeFilter.MENOR_IGUAL:return andDifferentZero(propertyName,Restrictions.le(propertyName, dateFilter.getInicio()));
			case TypeFilter.MENOR: return andDifferentZero(propertyName,Restrictions.lt(propertyName, dateFilter.getInicio()));
			case TypeFilter.IGUAL: return andDifferentZero(propertyName,Restrictions.eq(propertyName, dateFilter.getInicio()));
			case TypeFilter.DIFERENTE: return andDifferentZero(propertyName,Restrictions.ne(propertyName, dateFilter.getInicio()));
			default:
				return null;
			}
		}
		
		return null;
	}
	
	private static Criterion andDifferentZero(String propertyName, Criterion c) {
		return Restrictions.and(Restrictions.ne(propertyName, (long)0), c);
	}

	public static String getStringMonth(int month) {
		String[] months = { "Janeiro", "Fevereiro", "Mar�o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro" };
		return months[month];
	}
	
	public static String getStringDiaSemana(int diaSemana) {
		String[] dias = { "Domingo", "Segunda", "Ter�a", "Quarta", "Quinta", "Sexta", "S�bado" };
		return dias[diaSemana];
	}

	public static Criteria loopCriterias(Criteria criteria, List<Triplet<String,CriteriaExample,JoinType>> criterias) {
		if(criterias != null)
			for(Triplet<String,CriteriaExample,JoinType> c: criterias) {
				Criteria example = criteria.createCriteria(c.getValue0(),c.getValue0(),c.getValue2());
				for(Criterion criterion : c.getValue1().getCriterions())
					example.add(criterion);
				example.add(c.getValue1().getExample());
				
				example = loopCriterias(example, c.getValue1().getCriterias());
			}
		return criteria;
	}
	
	public static DetachedCriteria loopCriterias(DetachedCriteria criteria, List<Triplet<String,CriteriaExample,JoinType>> criterias) {
		if(criterias != null)
			for(Triplet<String,CriteriaExample,JoinType> c: criterias) {
				DetachedCriteria example = criteria.createCriteria(c.getValue0(),c.getValue0(),c.getValue2());
				for(Criterion criterion : c.getValue1().getCriterions())
					example.add(criterion);
				example.add(c.getValue1().getExample());
				
				example = loopCriterias(example, c.getValue1().getCriterias());
			}
		return criteria;
	}
	
	public static <T> Predicate<T> distinctByKey(Function<T, Object> keyExtractor){
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
	
	public static String getProjectPath() {
		boolean isRunningOnXampp = false;
		
		if(isRunningOnXampp)
			return "C:/Users/BJZE/Downloads/xampp/tomcat/webapps/Api/WEB-INF/classes/";
		else
			return Helper.class.getProtectionDomain().getCodeSource().getLocation().toString();
	}
	
	public static Date cloneDate(Date data) {
		if(data != null)
			return new Date(data.getTime());
		return data;
	}
	
	private static <E> void swap(List<E> a, int i, int j) {
        if (i != j) {
            E temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        }
    }
	
	public static <E extends Comparable<E>> void simpleSort(List<E> a) {
		if (isNotNull(a)) {
	        for (int i = 0; i < a.size()  - 1; i++) {
	            int smallest = i;
	            for (int j = i + 1; j < a.size(); j++) {
	                if (a.get(j).compareTo(a.get(smallest))<=0) {
	                    smallest = j;
	                }
	            }
	
	            swap(a, i, smallest);
	        }
		}
    }
	
	public static boolean isNull(List<?> list) {
		return list == null;
	}
	
	public static boolean isNull(GenericFilter filter) {
		return filter == null;
	}
	
	public static boolean isNotNull(List<?> list) {
		return list != null;
	}
	
	public static boolean isNotNull(GenericFilter filter) {
		return filter != null;
	}
}
