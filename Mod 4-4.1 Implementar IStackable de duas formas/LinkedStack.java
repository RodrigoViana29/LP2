import IStackable.*;

public class LinkedStack implements IStackable {
 
 public class LinkedList {

	private Node base;

	public void push(int Object v) {
		Node novo = new Node();
		novo.setValor(v);
		novo.setProximo(null);
		
		if (base == null) //Pilha vazia, a base apontará para o novo nó
		{ 
			base = novo;
			
		}
		else  //A pilha já tem um topo sobre o qual ficará o novo nó
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
	 * Se a pilha estiver vazia, lança exceção.
	 * Se a pilha só tiver um elemento, ficará vazia após o desempilhar, portanto 
	 * a base será null.
	 * Caso contrário, transforma o penúltimo nó em último, removendo o último original. 
	 */

	 public int Object pop() {
		
		if (base == null) {
			throw new NullPointerException("Pilha vazia");
		}
			
		Object valor;
		
		// Contém apenas um nó. A lista ficará vazia após o desempilhar.
		if (base.getProximo() == null) { 
			valor = base.getValor();
			base = null;
		
		} else { 
			// Caminha até o penúltimo nó, guarda o valor do último nó e
			// transforma o penúltimo em último
			Node penultimo = encontrarPenultimo();
			valor = penultimo.getProximo().getValor();
			penultimo.setProximo(null); // Quebra o link com o último nó original
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
	 * Não altera os dados nem a estrutura da pilha.
	 */
	public Object topo() {
		Node topo = encontrarUltimo();
		return topo.getValor();
	}

}

/**
 * Possui uma referência para o valor que armazena e outra para 
 * o próximo nó da lista encadeada.
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

	