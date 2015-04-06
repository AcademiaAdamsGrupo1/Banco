class Contenedor {
  	Object elementos[];
  	int numElementos=0;
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
  	
  	public int libreSiguiente(){
		while((recorrido<elementos.length)&&(elementos[recorrido]!=null)){
			recorrido++;
		}
		return (recorrido);
  	}

  	public Object siguiente(){
		if (recorrido<elementos.length){
      		return elementos[recorrido++];
    	}else{
    		return (null);
    	}
  	}

  	public Object elementoLibreSiguiente(){
  		boolean hueco_libre;
  		iniciarRecorrido();
  		hueco_libre=haySiguiente();
  		if (hueco_libre){
  			return (elementos[recorrido]);
  		}else{
  			return(null);
  		}
  	}
  	public void eliminar() {
  		elementos[recorrido-1]=null;
  		numElementos--;
  	}
  	
  	public void eliminar(int posicion) {
  		elementos[posicion]=null;
  		numElementos--;
  	}
}