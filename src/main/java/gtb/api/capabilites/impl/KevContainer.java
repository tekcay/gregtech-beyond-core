package gtb.api.capabilites.impl;

import static gtb.api.utils.NBTKeys.KEV_KEY;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.capabilities.Capability;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.metatileentity.MTETrait;
import gregtech.api.metatileentity.MetaTileEntity;

import gtb.api.capabilites.GTBTileCapabilities;
import gtb.api.capabilites.interfaces.containers.IKevContainer;
import lombok.Getter;

@Getter
public class KevContainer extends MTETrait implements IKevContainer {

    private int kev;

    public KevContainer(MetaTileEntity metaTileEntity) {
        super(metaTileEntity);
        this.kev = 0;
    }

    @Override
    public void setKev(int kev) {
        this.kev = kev;
        this.metaTileEntity.markDirty();
    }

    @NotNull
    @Override
    public String getName() {
        return "KeVContainer";
    }

    @Nullable
    public <T> T getCapability(Capability<T> capability) {
        if (capability == GTBTileCapabilities.CAPABILITY_KEV_CONTAINER) {
            return GTBTileCapabilities.CAPABILITY_KEV_CONTAINER.cast(this);
        }
        return null;
    }

    @NotNull
    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = super.serializeNBT();
        compound.setInteger(KEV_KEY, this.kev);
        return compound;
    }

    @Override
    public void deserializeNBT(@NotNull NBTTagCompound compound) {
        this.kev = compound.getInteger(KEV_KEY);
    }

    @Override
    public void writeInitialData(@NotNull PacketBuffer buffer) {
        super.writeInitialData(buffer);
        buffer.writeInt(this.kev);
    }

    @Override
    public void receiveInitialData(@NotNull PacketBuffer buffer) {
        super.receiveInitialData(buffer);
        this.kev = buffer.readInt();
    }

    @Override
    public void resetContainer() {
        this.setKev(0);
    }
}