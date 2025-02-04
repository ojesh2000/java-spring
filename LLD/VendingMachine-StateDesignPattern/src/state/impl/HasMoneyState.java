package state.impl;

import model.Coin;
import model.Item;
import model.VendingMachine;
import state.State;

import java.util.List;

public class HasMoneyState implements State {
    public HasMoneyState(){
        System.out.println("Currently Vending Machine is in HasMoneyState");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Already in Has-Money State");
    }

    @Override
    public void startProductSelection(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine,Coin coin) throws Exception {
        System.out.println("Coin Inserted");
        vendingMachine.addCoin(coin);
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Click on Start product selection button first to start product selection");
    }

    @Override
    public void choseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Click on Start product selection button first to select a product");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Can not get change in this state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the complete Amount in dispense tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Can not dispense product in this state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Can not update Inventory in this state");
    }
}
