/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ochoreinas;

/**
 *
 * @author karla
 */
public class OchoReinas {
	
    public void imprimeTablero(int tablero[][]){
            
	for(int i = 0; i < tablero.length ; i++){
            for(int j = 0 ; j < tablero.length ; j++){
		System.out.printf(" %d", tablero[i][j]);
                          	
            }
            
        System.out.printf("\n");
        
	}
    }
               
    public boolean esPosibleColocar(int tablero[][],int fila,int col){
                
    int f,c;
            
            
    for(c = 0 ; c < col; c++){
        if(tablero[fila][c] == 1){
            return false;
        }
    }
                    
    for( f = fila , c = col; f >= 0 && c >= 0; f--, c--){    
        if(tablero[f][c] == 1) 
            return false;
    }
          
    for(f = fila, c = col; c >= 0 && f < tablero.length; f++, c--){
        if (tablero[f][c] == 1)
            return false;
    }
    
  return true;
		
  }
       
  public boolean colocarReina(int tablero[][], int col){
            
            
    if(col >= tablero.length)
        return true;
            
    for(int i = 0; i < tablero.length; i++){
        
        if(esPosibleColocar(tablero,i,col)){
            tablero[i][col] = 1;

            if(colocarReina(tablero,col+1))
                return true;
         
            tablero[i][col] = 0;
        
        }
        
    }
    
  return false;
  
  }
        
  public static void main(String[] args){
    OchoReinas r = new OchoReinas();
    
    int tablero[][] = {
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0}
    };
    
    if(!r.colocarReina(tablero,0)){
      System.out.println("No hay solución");
    }
    
    r.imprimeTablero(tablero); 
  }
} 