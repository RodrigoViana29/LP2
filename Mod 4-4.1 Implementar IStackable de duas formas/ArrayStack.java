import IStackable.*;

public class ArrayStack implements IStackable{

	public class ArrayList {
	  	public Object[] pilha;
    		public int posicaoPilha;

    		public Pilha() {
        		this.posicaoPilha = -1;
			// indica que esta nula, vazia, pois posição um indica que contém informação
        		this.pilha = new Object[1000];
			// criando uma pilha com 1000 posições
    		}

    		public boolean pilhaVazia() {
        		
        		if (this.posicaoPilha == -1) {
            			return true;
       			}
        		return false;
    			}

    		public int size() {
        		
        		if (this.pilhaVazia()) {
            			return 0;
        		}
        		return this.posicaoPilha + 1;
    			}

    		public Object exibeUltimoValor() {
        	
        		if (this.pilhaVazia()) {
            			return null;
        		}
        		return this.pilha[this.posicaoPilha];
    			}

    		public int Object pop() {
        	
        		if (pilhaVazia()) {
            			return null;
        		}
        		return this.pilha[this.posicaoPilha--];
    			}

    		public void push( int Object v) {
        
        		if (this.posicaoPilha < this.pilha.length - 1) {
            		this.pilha[++posicaoPilha] = v;
        		}
    	}
}
