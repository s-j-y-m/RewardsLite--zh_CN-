package com.backtobedrock.rewardslite.utilities;

import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InventoryUtils {
    public static Inventory getTopInventory(InventoryEvent event) {
        try {
            Object view = event.getView();
            Method getTopInventory = view.getClass().getMethod("getTopInventory");
            getTopInventory.setAccessible(true);
            return (Inventory) getTopInventory.invoke(view);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
