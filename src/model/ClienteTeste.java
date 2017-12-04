package model;

public class ClienteTeste {
	public static void main(String[] args) {
		Client client = new Client();
		client.setName("Erik Rocha");
		client.setEmail("");
		client.create();
		client.load();
		System.out.println(client);
		client.setPhone("754457854");
		client.setEmail("bcp"+client.getId()+"@usjt.br");
		client.update();
		client.load();
		System.out.println(client);
		client.delete();
		client.load();
		System.out.println(client);		
	}
}
