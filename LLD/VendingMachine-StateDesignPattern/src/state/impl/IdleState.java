package state.impl;

import model.Coin;
import model.Item;
import model.VendingMachine;
import state.State;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(){
        System.out.println("Currently on Idle State!!");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Machine:" + machine.toString() + " is currently on Idle State!!");
        machine.setCoinList(new ArrayList<>());
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void startProductSelection(VendingMachine machine) throws Exception {
        throw new Exception("Can not start product selection until coin is inserted");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Can not insert coin in Idle State");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Please press Insert Coin Button First");
    }

    @Override
    public void choseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Can not choose product in Idle State");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Can not get Change in Idle State");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can not refund in Idle State");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Product can not be dispensed in Idle State");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        vendingMachine.getInventory().addItem(item, codeNumber);
    }
}
