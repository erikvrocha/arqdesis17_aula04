package test;


import static org.junit.Assert.assertEquals;
import model.Client;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {
	Client client, copy;
	static int id = 0;

	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setup");
		client = new Client(id, "Erik Rocha", "(11) 94321-9876", "errc@usjt.br" );
		copy =   new Client(id, "Erik Rocha", "(11) 94321-9876", "errc@usjt.br" );
		System.out.println(client);
		System.out.println(copy);
		System.out.println(id);
	}
	
	@Test
	public void test00Load() {
		System.out.println("Carregar");
		Client fixture = new Client(1, "Vinicius de Morais", "(11) 98765-4321", "vdm@usjt.br" );
		Client novo = new Client(1, null, null, null);
		novo.load();
		assertEquals("Teste de Inclusão", novo, fixture);
	}

	@Test
	public void test01Create() {
		System.out.println("Criar");
		client.create();
		id = client.getId();
		System.out.println(id);
		copy.setId(id);
		assertEquals("Teste de Criação", client, copy);
	}

	@Test
	public void test02Update() {
		System.out.println("Atualizar");
		client.setPhone("666666");
		copy.setPhone("666666");		
		client.update();
		client.load();
		assertEquals("Teste de Atualização", client, copy);
	}

	@Test
	public void test03Delete() {
		System.out.println("Excluir");
		copy.setId(-1);
		copy.setName(null);
		copy.setPhone(null);
		copy.setEmail(null);
		client.delete();
		client.load();
		assertEquals("Teste de Exclusão", client, copy);
	}
}