import IStackable.*;

public class LinkedStack implements IStackable {
 
 public class LinkedList {

	private Node base;

	public void push(int Object v) {
		Node novo = new Node();
		novo.setValor(v);
		novo.setProximo(null);
		
		if (base == null) //Pilha vazia, a base apontar� para o novo n�
		{ 
			base = novo;
			
		}
		else  //A pilha j� tem um topo sobre o qual ficar� o novo n�
		{ 
			Node topo = encontrarUltimo();
			topo.setProximo(novo);
		}
	}

	private Node encontrarUltimo() {
		Node auxiliar = base;
		while (auxiliar.getProximo() != null) {
			auxiliar = auxiliar.getProximo();
		}
		return auxiliar;
	}

	/**
	 * Remove e retorna o elemento no topo da pilha, ou seja, no final da fila.
	 * Se a pilha estiver vazia, lan�a exce��o.
	 * Se a pilha s� tiver um elemento, ficar� vazia ap�s o desempilhar, portanto 
	 * a base ser� null.
	 * Caso contr�rio, transforma o pen�ltimo n� em �ltimo, removendo o �ltimo original. 
	 */

	 public int Object pop() {
		
		if (base == null) {
			throw new NullPointerException("Pilha vazia");
		}
			
		Object valor;
		
		// Cont�m apenas um n�. A lista ficar� vazia ap�s o desempilhar.
		if (base.getProximo() == null) { 
			valor = base.getValor();
			base = null;
		
		} else { 
			// Caminha at� o pen�ltimo n�, guarda o valor do �ltimo n� e
			// transforma o pen�ltimo em �ltimo
			Node penultimo = encontrarPenultimo();
			valor = penultimo.getProximo().getValor();
			penultimo.setProximo(null); // Quebra o link com o �ltimo n� original
		}
		
		return valor;
	}

	protected Node encontrarPenultimo() {
		Node auxiliar = base;
		while (auxiliar.getProximo().getProximo() != null) {
			auxiliar = auxiliar.getProximo();
		}
		return auxiliar;
	}

	/**
	 * Percorre a lista, usando um contador para calcular o tamanha da pilha.
	 */
	public int size() {
		
		if (base == null) {
			return 0;
		}
		
		int size = 1;
		Node auxiliar = base;
		while (auxiliar.getProximo() != null) {
			auxiliar = auxiliar.getProximo();
			size++;
		}

		return size;
	}

	/**
	 * Retorna o elemento no topo da pilha.
	 * N�o altera os dados nem a estrutura da pilha.
	 */
	public Object topo() {
		Node topo = encontrarUltimo();
		return topo.getValor();
	}

}

/**
 * Possui uma refer�ncia para o valor que armazena e outra para 
 * o pr�ximo n� da lista encadeada.
 *
 */
class Node {

	private Object valor;
	private Node proximo;

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public Node getProximo() {
		return proximo;
	}

	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}

    }

}

	