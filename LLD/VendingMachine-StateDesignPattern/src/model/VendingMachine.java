package model;

import state.State;

import java.util.*;

public class VendingMachine {
    List<Coin> coinList;
    State vendingMachineState;
    Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public void addCoin(Coin coin){
        if(getCoinList() == null){
            setCoinList(new ArrayList<>());
        }
        getCoinList().add(coin);
    }
}
