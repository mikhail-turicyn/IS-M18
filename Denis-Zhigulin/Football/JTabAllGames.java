/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import Games.DataGames;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Денис
 */
public class JTabAllGames extends AbstractTableModel{
     ArrayList<DataGames> list;
    //ArrayList<NewTEam> listT;
    
    public JTabAllGames  (ArrayList<DataGames> list){
        super();
        this.list = list;   
    }
    
      @Override
    public int getRowCount() {
        return list.size();
    }
    @Override
    public int getColumnCount() {
        return 7;
    }
    
     @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "Соперники";
            case 1:
                return "Счёт";
            case 2:
                return "Турнир";
            case 3:
                return "Стадион";
            case 4:
                return "Тур"; 
             case 5:
                return "Код матча";   
            default:
              return "Дата"; 
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {   
            case 0:
                return list.get(rowIndex).getGame();
            case 1:
                return list.get(rowIndex).getScore();
            case 2:
                return list.get(rowIndex).getTournament();
            case 3:
                return list.get(rowIndex).getLocation();
            
            case 4:
                return list.get(rowIndex).getTour();
            
            case 5:
                return list.get(rowIndex).getId();
          
            default:
                return list.get(rowIndex).getDate();
        } 
        
    }
}
