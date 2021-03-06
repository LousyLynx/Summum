package com.lousylynx.summum.container;

import com.lousylynx.summum.tile.TileBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemHandlerHelper;

public abstract class ContainerBase extends Container {
    protected TileEntity tile;
    private EntityPlayer player;

    public ContainerBase(TileEntity tile, EntityPlayer player) {
        this.tile = tile;
        this.player = player;
    }

    public EntityPlayer getPlayer() {
        return player;
    }

    public TileEntity getTile() {
        return tile;
    }

    protected void addPlayerInventory(int xInventory, int yInventory) {
        int id = 0;

        for (int i = 0; i < 9; i++) {
            int x = xInventory + i * 18;
            int y = yInventory + 4 + (3 * 18);

            addSlotToContainer(new Slot(player.inventory, id, x, y));

            id++;
        }

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                addSlotToContainer(new Slot(player.inventory, id, xInventory + x * 18, yInventory + y * 18));

                id++;
            }
        }
    }

    @Override
    public ItemStack slotClick(int id, int dragType, ClickType clickType, EntityPlayer player) {
        //Slot slot = id >= 0 ? getSlot(id) : null;

        /*if (slot instanceof SlotSpecimen) {
            if (((SlotSpecimen) slot).isWithSize()) {
                if (clickType == ClickType.QUICK_MOVE) {
                    slot.putStack(null);
                } else if (player.inventory.getItemStack() != null) {
                    int amount = player.inventory.getItemStack().stackSize;

                    slot.putStack(ItemHandlerHelper.copyStackWithSize(player.inventory.getItemStack(), amount));
                } else if (slot.getHasStack()) {
                    int amount = slot.getStack().stackSize;

                    if (dragType == 0) {
                        amount = Math.max(1, amount - 1);
                    } else if (dragType == 1) {
                        amount = Math.min(64, amount + 1);
                    }

                    slot.getStack().stackSize = amount;
                }
            } else if (player.inventory.getItemStack() == null) {
                slot.putStack(null);
            } else if (slot.isItemValid(player.inventory.getItemStack())) {
                slot.putStack(player.inventory.getItemStack().copy());
            }

            return player.inventory.getItemStack();
        } else if (slot instanceof SlotSpecimenLegacy) {
            if (player.inventory.getItemStack() == null) {
                slot.putStack(null);
            } else if (slot.isItemValid(player.inventory.getItemStack())) {
                slot.putStack(player.inventory.getItemStack().copy());
            }

            return player.inventory.getItemStack();
        } else if (slot instanceof SlotDisabled) {
            return null;
        }*/

        return super.slotClick(id, dragType, clickType, player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        return null;
    }

    /*protected ItemStack mergeItemStackToSpecimen(ItemStack stack, int begin, int end) {
        for (int i = begin; i < end; ++i) {
            *//*if (API.instance().getComparer().isEqualNoQuantity(getStackFromSlot(getSlot(i)), stack)) {
                return null;
            }*//*
        }

        for (int i = begin; i < end; ++i) {
            Slot slot = getSlot(i);

            if (getStackFromSlot(slot) == null && slot.isItemValid(stack)) {
                slot.putStack(ItemHandlerHelper.copyStackWithSize(stack, 1));
                slot.onSlotChanged();

                return null;
            }
        }

        return null;
    }*/

    /*private ItemStack getStackFromSlot(Slot slot) {
        ItemStack stackInSlot = slot.getStack();

        if (stackInSlot == null) {
            if (slot instanceof SlotSpecimenFluid) {
                stackInSlot = ((SlotSpecimenFluid) slot).getRealStack();
            } else if (slot instanceof SlotSpecimenType) {
                stackInSlot = ((SlotSpecimenType) slot).getRealStack();
            }
        }

        return stackInSlot;
    }*/

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}