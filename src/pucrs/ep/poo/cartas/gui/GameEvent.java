package pucrs.ep.poo.cartas.gui;

public class GameEvent{
    public enum Target {DECK,GWIN,TABLE};
    public enum Action {INVPLAY,MUSTCLEAN,ENDGAME,REMOVESEL,ADDTOTABLE, INVCARD, ADDTOHAND, INICIOTURNO, WIN};
    
    private Target target;
    private Action action;
    private String arg;
    
    public GameEvent(Target aTarget,Action anAction,String anArg){
        target = aTarget;
        action = anAction;
        arg = anArg;
    }
    
    public Target getTarget(){
        return(target);
    }
    
    public Action getAction(){
        return(action);
    }
    
    public String getArg(){
        return(arg);
    }
    
    public String toString(){
        return target + ":"+ action + ":" + arg;
    }
}

