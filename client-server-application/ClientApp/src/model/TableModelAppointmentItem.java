/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.AppointmentItem;
import domain.Service;
import domain.util.GDOStatus;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import session.Session;
import usecase.UseCase;

/**
 *
 * @author NEDA
 */
public class TableModelAppointmentItem extends AbstractTableModel {

    List<AppointmentItem> items;
    List<AppointmentItem> itemsAfterUpdate;
    List<AppointmentItem> itemsBeforeUpdate;
    String[] header = new String[]{"orderNo", "Service", "Price", "Quantity"};
    double amount;
    DecimalFormat df = new DecimalFormat(".##");
    List<Integer> list;

    public TableModelAppointmentItem(List<AppointmentItem> items) {
        this.items = items;
        amount = 0;
        setOrderNumbers();
    }

    private void setOrderNumbers() {
        int no = 0;
        for (AppointmentItem ai : items) {
            ai.setNo(++no);
        }
//        list = new ArrayList<>();
//        list = new ArrayList<>();
//        for (int i = 0; i < items.size(); i++) {
//            list.add(i + 1);
//        }
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AppointmentItem item = items.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
//                if (list != null) {
//                    return list.get(rowIndex);
//                } else {
//                    return "";
//                }
                return item.getNo();
            case 1:
                return item.getService().getName();
            case 2:
                return item.getService().getPrice();
            case 3:
                return item.getQuantity();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public double addItem(Service service) {
        AppointmentItem item = exist(service);
        if (item == null) {
            item = new AppointmentItem(service, 1);
            items.add(item);
            //list.add(items.size());
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
        update(item);
        amount += service.getPrice();
        setOrderNumbers();
        fireTableDataChanged();
        return Double.parseDouble(df.format(amount));
    }

    public void removeItem(AppointmentItem item) {
        items.remove(item);
        setOrderNumbers();
        fireTableDataChanged();
    }

    public List<AppointmentItem> getItems() {
        return items;
    }

    public double removeItem(int i) {
        amount -= items.get(i).getQuantity() * items.get(i).getService().getPrice();
        AppointmentItem item = items.get(i);
        item.setQuantity(0);
        update(item);
        items.remove(i);
        setOrderNumbers();
        //adjustOrderNumbers(i);
        fireTableDataChanged();
        return Double.parseDouble(df.format(amount));
    }

    private void adjustOrderNumbers(int i) {
//        list.remove(i);
//        for (int j = i; j < list.size(); j++) {
//            list.set(j, list.get(j) - 1);
//        }
    }

    public void removeAll() {
        items.removeAll(items);
        fireTableDataChanged();
    }

    private AppointmentItem exist(Service service) {
        for (AppointmentItem item : items) {
            if (item.getService().getName().equals(service.getName())) {
                return item;
            }
        }
        return null;
    }

    public double increaseQuantity(int selectedRow) {
        int currentQuatity = items.get(selectedRow).getQuantity();
        items.get(selectedRow).setQuantity(currentQuatity + 1);
        update(items.get(selectedRow));
        amount += items.get(selectedRow).getService().getPrice();
        fireTableDataChanged();
        return Double.parseDouble(df.format(amount));
    }

    public double decreaseQuantity(int selectedRow) {
        int currentQuatity = items.get(selectedRow).getQuantity();
        items.get(selectedRow).setQuantity(currentQuatity - 1);
        update(items.get(selectedRow));
        amount += items.get(selectedRow).getService().getPrice();
        fireTableDataChanged();
        if (items.get(selectedRow).getQuantity() == 0) {
            items.remove(selectedRow);
            amount -= items.get(selectedRow).getService().getPrice();
        }
        fireTableDataChanged();
        return Double.parseDouble(df.format(amount));
    }

    public void refresh(List<AppointmentItem> items) {

        this.items = items;
        fireTableDataChanged();
    }

    public List<AppointmentItem> getItemsAfterUpdate() {
        return itemsAfterUpdate;
    }

    public void setItemsAfterUpdate() {
        itemsAfterUpdate = new ArrayList<>();
        setItemsBeforeUpdate();
    }

    private void update(AppointmentItem item) {
        if (Session.getInstance().getCurrentUseCase() == UseCase.UC_NEW_APPOINTMENT) {
            return;
        }
        if (!itemsAfterUpdate.contains(item)) {
            if (itemsBeforeUpdate.contains(item)) {
                if (item.getQuantity() == 0) {
                    item.setStatus(GDOStatus.DELETED);
                } else {
                    item.setStatus(GDOStatus.UPDATED);
                }
            } else {
                item.setStatus(GDOStatus.NEW);
            }
            itemsAfterUpdate.add(item);
        } else {
            for (AppointmentItem ai : itemsAfterUpdate) {
                if (ai.equals(item)) {
                    ai.setQuantity(item.getQuantity());
                    if (ai.getQuantity() == 0) {
                        ai.setStatus(GDOStatus.DELETED);
                    } else {
                        if (ai.getStatus() != GDOStatus.NEW) {
                            ai.setStatus(GDOStatus.UPDATED);
                        }
                    }
                }
            }
        }
    }

    public double getAmount() {
        for (AppointmentItem ai : items) {
            amount += ai.getQuantity() * ai.getService().getPrice();
        }
        return Double.parseDouble(df.format(amount));
    }

    public void setItemsBeforeUpdate() {
        itemsBeforeUpdate = new ArrayList<>();
        for (AppointmentItem ai : items) {
            AppointmentItem ai1 = new AppointmentItem();
            ai1.setOrderNo(ai.getOrderNo());
            ai1.setQuantity(ai.getQuantity());
            Service s = new Service(ai.getService().getId(), ai.getService().getName(), ai.getService().getPrice());
            ai1.setService(s);
            ai1.setStatus(GDOStatus.DEFAULT);
            itemsBeforeUpdate.add(ai1);
        }

    }

    public List<AppointmentItem> getItemsBeforeUpdate() {
        return itemsBeforeUpdate;
    }

}
