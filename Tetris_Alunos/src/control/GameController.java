package control;

import elements.Element;
import elements.Lolo;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Projeto de POO 2017
 * 
 * @author Luiz Eduardo
 * Baseado em material do Prof. Jose Fernando Junior
 * -------------------------------------------------
 */
public class GameController {
    
    /**
     * drawAllElements draws the game elements (probably not the background) on
     * the screen
     * @param elemArray
     * @param g 
     */
    public void drawAllElements(ArrayList<Element> elemArray, Graphics g){
        for(int i=0; i<elemArray.size(); i++){
            elemArray.get(i).autoDraw(g);
        }
    }
    public void processAllElements(ArrayList<Element> e){
        if(e.isEmpty())
            return;
        
        Lolo lLolo = (Lolo)e.get(0);
        if (!isValidPosition(e, lLolo)) {
            lLolo.backToLastPosition();
            
            return;
        }
        // verificador de colisão? -> alterar para o tetris
        Element eTemp;
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);
            if(lLolo.overlap(eTemp))
                if(eTemp.isMortal())
                    e.remove(eTemp);
        }
    }
    // lolo tem apenas 1 quadrado, será necessário fazer diferente p/ peças
    // de tetries (4x4) -> processamento será prejudicado?
    public boolean isValidPosition(ArrayList<Element> elemArray, Element elem){
        Element elemAux;
        for(int i = 1; i < elemArray.size(); i++){
            elemAux = elemArray.get(i);            
            if(!elemAux.isTransposable())
                if(elemAux.overlap(elem))
                    return false;
        }        
        return true;
    }
}
