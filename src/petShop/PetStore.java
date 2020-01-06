package petShop;

import javax.swing.JOptionPane;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class PetStore {
	private java.util.ArrayList<Mamifero> Mamiferos;
	
	public PetStore() {
		Mamiferos = new ArrayList<Mamifero>();
	}
	
	public void excluiAnimal(Mamifero mani){
		if(this.Mamiferos.contains(mani)) {
			this.Mamiferos.remove(mani);
			System.out.println("Animal:"+mani.toString()+"excluido com sucesso \n");
		}
		else {
			System.out.println("Animal inexistente! \n");
		}
	}
	public void excluirAnimais() {
		Mamiferos.clear();
		System.out.println("Animais excluidos com sucesso \n");
	}
	public void gravarAnimais() {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("animais.dat"));
			for (int f=0; f < Mamiferos.size(); f++)
				outputStream.writeObject(Mamiferos.get(f));
		} 
		catch (FileNotFoundException ex) {
			System.out.println("Impossível criar arquivo!");
			ex.printStackTrace();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} 
		finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	@SuppressWarnings("finally")
	public ArrayList<Mamifero> recuperaAnimais() {
		ArrayList<Mamifero> mamiferos= new ArrayList<Mamifero>();
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream
					(new FileInputStream("animais.dat"));
			Object obj = null;
			while((obj = inputStream.readObject())!= null) {
				if(obj instanceof Gato)
					this.Mamiferos.add((Mamifero) obj);//pegando classe amifero
				else if(obj instanceof Cao)
					this.Mamiferos.add((Mamifero) obj);
			}
		}catch(EOFException ex) {
			System.out.println("End of file reached.");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(FileNotFoundException ex) {
			System.out.println("Arquivo com filmes NÃO existe!");
			ex.printStackTrace();
		}catch(IOException ex) {
			
		}finally {
			try {
				if(inputStream != null) {
					inputStream.close();
					System.out.println("Animais recuperados com sucesso!\n");
				}
			}catch(final IOException ex) {
				ex.printStackTrace();
			}
			return Mamiferos;
		}
	}
	public void listarAnimais() {
		for(Mamifero mani: Mamiferos) {
			System.out.println(mani.toString());
		}
		System.out.println("total = "+ Mamiferos.size()+" listados com sucesso \n");
	}
	
	
	
	public static void main (String[] args) {
		PetStore pet = new PetStore();
		Gato felix    = new Gato("Felix",    3, "Maria");
		Gato garfield = new Gato("Garfield", 7, "Maria");
		Cao  rex      = new Cao ("Rex",  2, "Jose");
		Cao  toto     = new Cao ("Toto", 5, "Jose");
		Vaca mulan = new Vaca("leiite", 55, "indianos");
		Hamster robson = new Hamster("Robson", 1, "Julia");
		
		
		pet.adicionaAnimal(felix);
		pet.adicionaAnimal(garfield);
		pet.adicionaAnimal(rex);
		pet.adicionaAnimal(toto);
		pet.adicionaAnimal(mulan);
		pet.adicionaAnimal(robson);
		pet.listarAnimais();
		pet.gravarAnimais();
		pet.excluiAnimal(garfield);
		pet.listarAnimais();
		pet.excluirAnimais();
		pet.listarAnimais();
		pet.recuperaAnimais();
		pet.listarAnimais();
		
	}
	
	private void adicionaAnimal(Mamifero mani) {
		this.Mamiferos.add(mani);

	}
}
