package petShop;

public class Cao extends Mamifero{
	public Cao(String nome, int idade,String dono) {
		super(nome, idade, dono);
		this.especie="Cao";
	}
	public String soar() {
		return "auauau";
	}
}
