package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entities.Financeiro;

public class Program {

	public static void main(String[] args) {
		
		JSONArray jsonObject;
		//Cria o parse de tratamento
		JSONParser parser = new JSONParser();

		//cria lista de objeto financeiro
		List<Financeiro> financeiro = new ArrayList<>();

	    Financeiro objFinanceiro = new Financeiro();

		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Leo\\eclipse-workspace\\distribuidora\\src\\resources\\dados.json"));
			for (Object obj : jsonArray) {
				JSONObject jsonObj = (JSONObject) obj;
				Long dia = (Long) jsonObj.get("dia");
				Double valor = (Double) jsonObj.get("valor");

			    //System.out.print("Dia: " + dia + " Valor: " + valor);
			    objFinanceiro = new Financeiro(dia, valor);
			    financeiro.add(objFinanceiro);
			    
			}
		}
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Max value: " + objFinanceiro.max_value(financeiro));
		System.out.println("Min value: " + objFinanceiro.min_value(financeiro));
		System.out.println("Month average: " + objFinanceiro.month_average(financeiro));

	}

}

