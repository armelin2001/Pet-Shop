package petShop;

public class Hamster extends Mamifero{
	public Hamster(String nome, int idade,String dono) {
		super(nome, idade, dono);
		this.especie="Hamster";
	}
	public String soar() {
		return "reeeee";
	}

}
