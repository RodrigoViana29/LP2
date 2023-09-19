import java.text.DecimalFormat;

public class Empresa {
	public static void main(String[] args) {
		Funcionario f1, f2;
		DecimalFormat deci = new DecimalFormat("0.00");
		f1 = new Funcionario("João", "Silva", 3000);
		f2 = new Funcionario();
		f2.setNome("Pedro");
		f2.setSobrenome("costa");
		f2.setSalario(2000);
		
		f1.setSalario(f1.getSalario()*1.1);
		f2.setSalario(f2.getSalario()*1.1);
		
		System.out.println("Salario do "+f1.getNome()+" "+f1.getSobrenome()+" é: "+deci.format(f1.getSalario()*12));
		System.out.println("Salario do "+f2.getNome()+" "+f2.getSobrenome()+" é: "+deci.format(f2.getSalario()*12));
	}
}