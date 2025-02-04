package state.impl;

import model.Coin;
import model.Item;
import model.VendingMachine;
import state.State;

import java.util.List;

public class SelectionState implements State {
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can not click on Insert coin button in Selection state");
    }

    @Override
    public void startProductSelection(VendingMachine machine) throws Exception {
        return ;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Can not insert coin in Selection state");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Already in Selection state");
    }

    @Override
    public void choseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventory().getItem(codeNumber);

        int paidByUser = 0;
        for(Coin coin : vendingMachine.getCoinList()){
            paidByUser += coin.getValue();
        }

        if(paidByUser < item.getPrice()){
            refundFullMoney(vendingMachine);
            throw new Exception("Insufficient amount for this product in Selection State");
        }else{
            if(paidByUser > item.getPrice()){
                int returnChangeMoney = paidByUser - item.getPrice();
                getChange(returnChangeMoney);
            }
//            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returning change money: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the complete Amount in dispense tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Can not dispense product in Selection state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Can not update Inventory in Selection state");
    }
}
