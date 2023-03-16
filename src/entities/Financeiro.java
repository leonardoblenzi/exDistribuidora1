package entities;

import java.util.List;

public class Financeiro {
	
	private Long dia;
	private Double valor;
	
	public Financeiro() {
		super();
	}

	public Financeiro(Long dia, Double valor) {
		super();
		this.dia = dia;
		this.valor = valor;
	}

	public Long getDia() {
		return dia;
	}

	public void setDia(Long dia) {
		this.dia = dia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Financeiro [dia=" + dia + ", valor=" + valor + "]";
	}
	
	public double max_value(List<Financeiro> list) {
		//valor inicial de comparação
		double max = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getValor() > max) {
				max = list.get(i).getValor();
			}
		}
		return max;
		
	}
	
	public double min_value(List<Financeiro> list) {
		//pegando valor para usar como comparação
		double min = list.get(0).getValor();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getValor() < min && list.get(i).getValor() > 0) {
				min = list.get(i).getValor();
			}
		}
		return min;
	}
	
	public double month_average(List<Financeiro> list) {
		int days = 0;
		double value = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getValor() != 0) {
				value += list.get(i).getValor();
				days += 1;
			}
		}
		return value / days;
	}
}
