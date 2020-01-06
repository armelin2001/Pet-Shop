package petShop;

public class Vaca extends Mamifero {
	public Vaca(String nome, int idade,String dono) {
		super(nome, idade, dono);
		this.especie="Vaca";
	}
	public String soar() {
		return "muuuuuuuuuuuuuuuuuuuuuuuuu";
	}
}
