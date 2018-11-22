/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_of_products;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Катюша
 */
public class Calculator_of_products extends DefaultTableModel {

    /**
     * @param args the command line arguments
     */
    public Calculator_of_products() {
        super(new String[]{"Название", "Цена за шт.", "Кол-во", "Стоимость"}, 1); //названия столбцов
        super.setValueAt("Итого:", getRowCount() - 1, 2);
        super.setValueAt("0.0", getRowCount() - 1, 3);

    }
    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 0 && row != getRowCount() - 1) {
            return true;
        } else {
            return false;//запрет редактирования ячеек
        }
    }
    
}
