package petShop;

public class Gato extends Mamifero {
	public Gato(String nome, int idade, String dono) {
		super(nome,idade,dono);
		this.especie="Gato";
	}
	public String soar() {
		return "miaumiau";
	}
}
