package petShop;

public abstract class Mamifero implements java.io.Serializable {
	private String nome;
	private int idade;
	private String dono;
	protected String especie;
	
	public Mamifero(String nome, int idade, String dono) {
		this.nome = nome;
		this.idade = idade;
		this.dono = dono;
	}
	public String toString() {
		String retorno="";
		retorno += "Nome: " + this.nome + "\n";
		retorno += "Idade: " + this.idade + " anos\n";
		retorno += "Dono: " + this.dono + "\n";
		retorno += "Especie: " + this.especie + "\n";
		retorno += "Barulho: " + this.soar() + "\n";
		return retorno;
	}
	public abstract String soar();
}
