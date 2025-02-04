package state;

import model.Coin;
import model.Item;
import model.VendingMachine;

import java.util.*;

public interface State {
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    public void startProductSelection(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception;
    public void choseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    public int getChange(int returnChangeMoney) throws Exception;
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception;

}
