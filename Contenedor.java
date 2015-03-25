class Contenedor {
  	Object elementos[];
  	int numElementos=3;
  	int recorrido;

  	public Contenedor(int capacidad) {
    		elementos=new Object[capacidad];
  	}

  	public int numElementos() {
    		return numElementos;
  	}

  	public boolean introducir(Object elemento){
		int i=0;

		// busca hueco libre
		while((i<elementos.length)&&(elementos[i]!=null)){
	  		i++;
		}
    	if (i<elementos.length){
    		elementos[i]=elemento;
    		numElementos++;
    		return (true);
    	}else{
    		return (false);
    	}
  	}

  	public void iniciarRecorrido(){
    		recorrido=0;
  	}

  	public boolean haySiguiente(){
		// salta los huecos libres
		while((recorrido<elementos.length)&&(elementos[recorrido]==null)){
			recorrido++;
		}
		return (recorrido<elementos.length);
  	}

  	public Object siguiente(){
		if (recorrido<elementos.length){
      		return elementos[recorrido++];
    	}else{
    		return (null);
    	}
  	}

  	public void eliminar() {
  		elementos[recorrido-1]=null;
  		numElementos--;
  	}
}